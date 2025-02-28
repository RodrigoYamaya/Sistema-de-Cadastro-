import java.io.File;

public class listaDeCandidatos {
    private static final String PASTA_CANDIDATOS = "candidatos";

    public void listarCandidatos() {
        File pasta = new File(PASTA_CANDIDATOS);
        if (!pasta.exists() || pasta.listFiles() == null) {
            System.out.println("Nenhum candidato cadastrado.");
            return;
        }

        for (File arquivo : pasta.listFiles()) {
            System.out.println(arquivo.getName());
        }
    }
}

