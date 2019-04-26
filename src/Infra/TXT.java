package Infra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TXT implements CRUD {

    String diretorio = "src/Infra/instancias/instancias_tsp_cup/";

    private TXT() {}
    
    public static TXT txt = null;

    public static TXT getInstance() {

        if (txt == null)
            txt = new TXT();
        return txt;
    }

    @Override
    public boolean criar(String nomeArquivo) {

        try {

            File arquivo = new File(diretorio + nomeArquivo + ".txt");
            arquivo.createNewFile();

        } catch (IOException e) {
            System.err.println("Erro ao criar arquivo");
        }

        return true;
    }

    @Override
    public String ler(String nomeArquivo) {
        try {

            Path caminho = Paths.get(this.diretorio + nomeArquivo + ".txt");

            byte[] text = Files.readAllBytes(caminho);

            String str = new String(text);

            text.clone();

            return str;

        } catch (FileNotFoundException fnfex) {
        } catch (IOException ioex) {
        }
        return null;

    }

    @Override
    public boolean atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
