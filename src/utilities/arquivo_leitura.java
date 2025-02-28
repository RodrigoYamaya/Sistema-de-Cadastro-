package utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class arquivo_leitura {
    
    public static List<String> lerPerguntas(String caminho) {
        List<String> linhas = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String line;
            while ((line = br.readLine()) != null) {
                linhas.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("error: ler arquivo: " + e.getMessage());
        }
        return linhas;

    }

    public static void escreverArquivoappen(String caminho, List<String> conteudos) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
            for(String linha: conteudos) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("error: ao escrever arquivo: " + e.getMessage());
        }

    }

    public static void adicionarLinhaArquivo(String caminhoArquivo, String newlinha) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            bw.write(newlinha);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao adicionar linha ao arquivo: " + e.getMessage());
        }

    }



}

