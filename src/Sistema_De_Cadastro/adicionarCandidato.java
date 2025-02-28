package Sistema_De_Cadastro;

import java.io.*;
import java.util.*;
import utilities.arquivo_leitura;



public class adicionarCandidato {
    private static final String PASTA_CANDIDATOS = "candidatos";
    private static final String FORMULARIO =("Formulario.txt");


    public void cadastrarCandidato(List<String> respostas) {
        if (respostas.isEmpty()) {
            System.out.println("error: nenhum resposta foi fornecida");
            return;
        }

        validaCandidato validador = new validaCandidato();
        String emailNovo = respostas.get(1);
        if(validador.duplicadaEmail(emailNovo)) {
            System.out.println("erro: este e-mail ja esta cadastrado");
            return;
        }

        String nomeCandidato = respostas.get(0).replace(" ", "").toUpperCase();
        File userFolder = new File(PASTA_CANDIDATOS);
        if (!userFolder.exists()) userFolder.mkdirs();

        File[] arquivosExistentes = userFolder.listFiles((dir, name) -> name.endsWith(".txt"));
        int numeroArquivo = (arquivosExistentes != null) ? arquivosExistentes.length + 1 : 1;

        String caminhoArquivo = PASTA_CANDIDATOS + File.separator + numeroArquivo + "-" + nomeCandidato + ".txt";

        arquivo_leitura.escreverArquivoappen(caminhoArquivo, respostas);
        System.out.println("Candidato cadastrado com sucesso: " + caminhoArquivo);
    }

    public List<String> capturarRespostas() {
        List<String> respostas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        List<String> perguntas = arquivo_leitura.lerPerguntas(FORMULARIO);
        if (perguntas.isEmpty()) {
            System.out.println("Erro: Nenhuma pergunta cadastrada!");
            return respostas;
        }

        for (String pergunta : perguntas) {
            System.out.println(pergunta);
            System.out.print("Resposta: ");
            respostas.add(sc.nextLine());
        }

        return respostas;
    }



}
