import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PesquisaCandidato {

        private static final String PASTA_CANDIDATOS = "candidatos";

        public void pesquisarCandidato(String termoBusca) {
            File pasta = new File(PASTA_CANDIDATOS);
            if (!pasta.exists() || pasta.listFiles() == null) {
                System.out.println("Nenhum candidato cadastrado.");
                return;
            }

            for (File arquivo : pasta.listFiles()) {
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        if (linha.toLowerCase().contains(termoBusca.toLowerCase())) {
                            System.out.println(" Candidato encontrado em: " + arquivo.getName());
                            return;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler arquivo: " + e.getMessage());
                }
            }
            System.out.println("Candidato não encontrado.");
        }
    }


