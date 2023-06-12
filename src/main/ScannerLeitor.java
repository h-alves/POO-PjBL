package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScannerLeitor {
    private String separador = ",";
    private List<List<String>> tabela = new ArrayList<>();
    private boolean hasReadFile = false;

    public List<List<String>> leituraDoArquivo(String fileName) {
        try {
            FileReader arquivo = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(arquivo);
            String cabecalho = buffer.readLine(); // lê o cabeçalho do arquivo

            String linha;
            while ((linha = buffer.readLine()) != null) { // lê cada linha do arquivo
                // executa a separação
                String[] conteudoDaLinhaSeparado = linha.split(separador);
                List<String> linhaDeDados = Arrays.asList(conteudoDaLinhaSeparado);
                tabela.add(linhaDeDados);
            }

            buffer.close();
            arquivo.close();

            hasReadFile = true; // Atualiza o indicador de leitura do arquivo

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tabela;
    }

    public boolean hasReadFile(String fileName) {
        return hasReadFile && tabela.size() > 0;
    }

    public List<List<String>> getTabela() {
        return tabela;
    }
}
