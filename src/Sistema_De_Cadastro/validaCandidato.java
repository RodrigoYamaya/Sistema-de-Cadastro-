package Sistema_De_Cadastro;

import Exception.emailInvalidoException;
import Exception.nomeInvalidoException;
import Exception.idadeInvalidaException;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class validaCandidato {
    private static final String PASTA_CANDIDATOS = "candidatos";


    public void validarIdade(String idade) throws idadeInvalidaException {
        try {
            int idadeInt = Integer.parseInt(idade);
            if (idadeInt < 18) {
                throw new idadeInvalidaException("Erro: A idade deve ser maior que 18 anos.");
            }
        } catch (NumberFormatException e) {
            throw new idadeInvalidaException("Erro: A idade deve ser um número válido.");
        }
    }

    public void validarEmail(String email) throws emailInvalidoException {
        if (!email.contains("@")) {
            throw new emailInvalidoException("Erro: O e-mail deve conter o caractere '@'.");
        }
    }

    public void validarName(String name) throws nomeInvalidoException {
        if (name.length() < 10) {
            throw new nomeInvalidoException("Erro: O nome deve ter no mínimo 10 caracteres.");
        }
    }

    public boolean duplicadaEmail(String email) {
        File pasta = new File(PASTA_CANDIDATOS);
        if(!pasta.exists() || pasta.listFiles()  == null) {
            return false;

        }
        for(File arquivo : pasta.listFiles()) {
            try(BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                String line;
                int contador = 0;
                while ((line = br.readLine()) != null) {
                   if(contador == 1 && line.equalsIgnoreCase(email)) {
                       return true;
                   }
                    contador++;
                }

            } catch (IOException e) {
                System.out.println("Erro ao verificar e-mail" + e.getMessage());
            }
        }
        return false;

    }


}