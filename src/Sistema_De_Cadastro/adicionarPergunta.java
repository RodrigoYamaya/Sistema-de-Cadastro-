package Sistema_De_Cadastro;


import utilities.arquivo_leitura;

public class adicionarPergunta {
    private static final String CAMINHO_ARQUIVO = ("Formulario.txt");



    public void adicionarPergunta(String novaPergunta) {
      if(novaPergunta == null || novaPergunta.trim().isEmpty()) {
          System.out.println("Erro: A pergunta não pode ser vazia!");
          return;
      }

      arquivo_leitura.adicionarLinhaArquivo(CAMINHO_ARQUIVO, novaPergunta);

    }
}
