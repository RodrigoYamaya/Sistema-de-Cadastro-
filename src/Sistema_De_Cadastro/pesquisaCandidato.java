package Sistema_De_Cadastro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class pesquisaCandidato {

        private static final String PASTA_CANDIDATOS = "candidatos";

        public void pesquisarCandidato(String termoBusca) {
            File pasta = new File(PASTA_CANDIDATOS);
            if (!pasta.exists() || pasta.listFiles() == null) {
                System.out.println("Nenhum candidato cadastrado.");
                return;
            }

            File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(".txt"));
            if (arquivos == null || arquivos.length == 0) {
                System.out.println("Nenhum candidato encontrado.");
                return;
            }

            boolean encontrou = false;
            System.out.println("\n=== Resultados da Pesquisa ===");


            for (File arquivo : pasta.listFiles()) {
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    StringBuilder candidatoDados = new StringBuilder();
                    candidatoDados.append(arquivo.getName());
                    while ((linha = br.readLine()) != null) {
                        if (linha.toLowerCase().contains(termoBusca.toLowerCase())) {
                            System.out.println(" Candidato encontrado em: " +candidatoDados);
                            encontrou = true;
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler arquivo: " + e.getMessage());
                }
            }
            if(!encontrou) {
                System.out.println("nenhum candidato foi encontrado!!");
            }
        }
    }


