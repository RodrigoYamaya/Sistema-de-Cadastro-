import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class adicionarPergunta {
    private static final File ARQUIVO =  new File("Formulario.txt");



    public void adicionarPergunta(String novaPergunta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            bw.write(novaPergunta + "\n");
            bw.flush();
            System.out.println("Pergunta adicionada com sucesso!");
        } catch (IOException e) {
            System.out.println("error: pergunta nao foi adicionado!");
        }

    }
}
