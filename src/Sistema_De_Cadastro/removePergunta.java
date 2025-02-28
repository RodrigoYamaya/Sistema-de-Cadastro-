    import java.io.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class RemovePergunta {
        private static final File ARQUIVO = new File("Formulario.txt");
        private static final Scanner sc = new Scanner(System.in);

        public void removerPergunta(String s) {
            if (!ARQUIVO.exists()) {
                System.out.println("Erro: O arquivo de perguntas não existe.");
                return;
            }

            List<String> perguntas = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    perguntas.add(linha.trim());
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
                return;
            }

            if (perguntas.isEmpty()) {
                System.out.println("O formulário está vazio!");
                return;
            }

            System.out.println("\n=== Perguntas cadastradas ===");
            for (int i = 0; i < perguntas.size(); i++) {
                System.out.println(" " + perguntas.get(i));
            }

            int indicePergunta;

            try {
                indicePergunta = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida! Digite um número válido.");
                return;
            }

            if (indicePergunta <= 4 || indicePergunta > perguntas.size()) {
                System.out.println("Erro: Não é permitido apagar as 4 primeiras perguntas obrigatórias!");
                return;
            }

            String perguntaRemovida = perguntas.remove(indicePergunta - 1);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO,false))) {
                for (String pergunta : perguntas) {
                    bw.write(pergunta);
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
                return;
            }

            System.out.println("Pergunta removida com sucesso: \"" + perguntaRemovida + "\"");
        }
    }
