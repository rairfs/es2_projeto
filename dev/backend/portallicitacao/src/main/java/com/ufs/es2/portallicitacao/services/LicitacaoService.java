package com.ufs.es2.portallicitacao.services;

import com.ufs.es2.portallicitacao.models.*;
import com.ufs.es2.portallicitacao.repositories.LicitacaoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
public class LicitacaoService {

    private final LicitacaoRepository licitacaoRepository;
    private final ModalidadeService modalidadeService;
    private final UnidadeGestoraService unidadeGestoraService;
    private Logger logger;

    public LicitacaoService(LicitacaoRepository licitacaoRepository,
                            ModalidadeService modalidadeService,
                            UnidadeGestoraService unidadeGestoraService){
        this.licitacaoRepository = licitacaoRepository;
        this.modalidadeService = modalidadeService;
        this.unidadeGestoraService = unidadeGestoraService;
        logger = Logger.getLogger(LicitacaoService.class.getName());
    }

    public List<Licitacao> getAll(){
        return this.licitacaoRepository.findAll();
    }

    public Licitacao findById(Integer id){
        return this.licitacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Licitação não encontrada para este ID."));
    }

    public List<Licitacao> findAllByModalidade(String codigoModalidade){
        return this.licitacaoRepository.findAllByModalidade_codigo(codigoModalidade);
    }

    public List<Licitacao> findAllByUnidadeGestora(String codigoUnidadeGestora){
        return this.licitacaoRepository.findAllByUnidadeGestora_codigo(codigoUnidadeGestora);
    }

    @Transactional
    public void inserirLicitacoes(MultipartFile file) throws IOException, ParseException {
        logger.info("Inserindo licitações...");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String linha = br.readLine();
            linha = br.readLine();
            while(linha != null && !linha.isBlank()){
                linha = linha.replaceAll("\"", "");
                String[] colunas = linha.split(";");
                if(colunas.length > 17){
                    System.out.println("Entrou aqui");
                }
                Licitacao licitacao = obterLicitacao(colunas);

                Modalidade modalidade = obterModalidade(colunas);
                //modalidadeService.save(modalidade);
                licitacao.setModalidade(modalidade);

                UnidadeGestora unidadeGestora = obterUnidadeGestora(colunas);
                //unidadeGestoraService.save(unidadeGestora);
                licitacao.setUnidadeGestora(unidadeGestora);

                Municipio municipio = Municipio.builder()
                        .nome(colunas[13])
                        .pais("BRASIL")
                        .codigoRegiao("1")
                        .codigoIBGE("1")
                        .nomeIBGE(colunas[13])
                        .estado(Estado.builder().sigla(colunas[12]).build())
                        .build();
                licitacao.setMunicipio(municipio);
                linha = br.readLine();
            }
        } catch (IOException e) {
            logger.severe("Erro ao processar arquivo." + e.getMessage());
            throw new IOException("Erro ao processar arquivo." + e.getMessage());
        }
    }

    private Licitacao obterLicitacao(String[] colunas) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAbertura = colunas[15].isBlank() ? null : sdf.parse(colunas[15]);
        Date dataResultadoCompra = sdf.parse(colunas[14]);
        Licitacao licitacao = Licitacao.builder()
                .idLicitacao(Integer.valueOf(colunas[0]))
                .situacao(colunas[7])
                .dataAbertura(dataAbertura == null ? LocalDateTime.now() : dataAbertura.toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime())
                .dataPublicacao(dataAbertura == null ? LocalDateTime.now() : dataAbertura.toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime())
                .valor(new BigDecimal(colunas[16].replace(",", ".")))
                .dataResultadoCompra(dataResultadoCompra == null ? LocalDateTime.now() : dataResultadoCompra.toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime())
                .instrumentoLegal("Instrumento Legal da Licitação")
                .situacaoCompra(colunas[7])
                .build();
        return licitacao;
    }

    private UnidadeGestora obterUnidadeGestora(String[] colunas) {
        UnidadeGestora unidadeGestora = UnidadeGestora.builder()
                .codigo(colunas[1])
                .nome(colunas[2])
                .descricaoPoder(colunas[2])
                .orgaoMaximo(OrgaoMaximo.builder()
                        .codigo(colunas[9])
                        .nome(colunas[10])
                        .sigla("Sigla Órgão Maximo")
                        .build())
                .orgaoVinculado(OrgaoVinculado.builder()
                        .cnpj("11.111.111/1111-11")
                        .codigoSIAFI(colunas[10])
                        .nome(colunas[11])
                        .sigla("Sigla Órgão Vinculado")
                        .build())
                .build();
        return unidadeGestora;
    }

    private Modalidade obterModalidade(String[] colunas) {
        Modalidade modalidade = Modalidade.builder()
                .codigo(colunas[3])
                .descricao(colunas[4])
                .build();
        return modalidade;
    }

}
