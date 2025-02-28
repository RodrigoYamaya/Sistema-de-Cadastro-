package Sistema_De_Cadastro;

import java.io.File;
import java.util.List;
import utilities.arquivo_leitura;

public class listaDeCandidatos {
    private static final String PASTA_CANDIDATOS = "candidatos";


    public void listarCandidatos() {
        File pasta = new File(PASTA_CANDIDATOS);
        File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(".txt"));
        if (!pasta.exists() || pasta.listFiles() == null) {
            System.out.println("Nenhum candidato cadastrado.");
            return;
        }

        System.out.println("====================================");
        System.out.println("| Nome               | Idade | Altura | Email               |");
        System.out.println("|--------------------|-------|--------|---------------------|");


        for (File arquivo :arquivos) {
            List<String> dadosCandidatos = arquivo_leitura.lerPerguntas(arquivo.getPath());
            if(dadosCandidatos.size() >= 4) {
                String nome = dadosCandidatos.get(0);
                String email = dadosCandidatos.get(1);
                String idade = dadosCandidatos.get(2);
                String altura = dadosCandidatos.get(3);
                System.out.printf("| %-18s | %-5s | %-6s | %-19s |\n", nome, idade, altura, email);

            } else {
                System.out.println("erro: ler dados do candidato: " + arquivo.getName());
            }
        }

        System.out.println("=========================================================");
    }
}

