import Sistema_De_Cadastro.*;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Exception.emailInvalidoException;
import Exception.nomeInvalidoException;
import Exception.idadeInvalidaException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        adicionarCandidato adicionaCandidato = new adicionarCandidato();
        adicionarPergunta adicionaPergunta = new adicionarPergunta();
        listaDeCandidatos listaDeCandidatos = new listaDeCandidatos();
        pesquisaCandidato pesquisaCandidato = new pesquisaCandidato();
        removePergunta removerpergunta = new removePergunta();
        validaCandidato validaCandidato = new validaCandidato();


        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar o usuário");
            System.out.println("2 - Listar todos candidatos");
            System.out.println("3 - Cadastrar nova pergunta no formulário");
            System.out.println("4 - Remover pergunta do formulario");
            System.out.println("5 - Pesquisar usuário por nome ou idade ou email");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar o usuário:  ");
                    List<String> respostas = adicionaCandidato.capturarRespostas();
                    if(!respostas.isEmpty()){
                        String email = respostas.get(1);
                        if(validaCandidato.duplicadaEmail(email)){
                            System.out.println("erro: e-mail ja esta cadastrado");
                        }
                        try {
                            validaCandidato.validarName(respostas.get(0));
                            validaCandidato.validarEmail(respostas.get(1));
                            validaCandidato.validarIdade(respostas.get(2));

                            adicionaCandidato.cadastrarCandidato(respostas);
                        } catch (nomeInvalidoException e) {
                            System.out.println("Erro: O nome deve ter no mínimo 10 caracteres.");
                        } catch (emailInvalidoException e) {
                            System.out.println("Erro: Email inválido! Necessário conter '@'.");
                        } catch (idadeInvalidaException e) {
                            System.out.println("Erro: É necessário ser maior de idade.");

                        }
                    }
                    break;
                case 2:
                    listaDeCandidatos.listarCandidatos();
                    break;
                case 3:
                    System.out.println("Cadastrar nova pergunta no formulário: ");
                    adicionaPergunta.adicionarPergunta(sc.nextLine());
                    break;
                case 4:
                    System.out.println("Deletar pergunta do formulário: ");
                    removerpergunta.removerPergunta(sc.nextLine());
                    break;
                case 5:
                    System.out.println("Pesquisar usuário por nome ou idade ou email: ");
                    pesquisaCandidato.pesquisarCandidato(sc.nextLine());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
