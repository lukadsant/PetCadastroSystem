package inicial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscritaLeituraTxt {
    File file;

    public EscritaLeituraTxt(File file) {
        if(file == null || !file.exists()|| !file.canRead()){
            throw new IllegalArgumentException("Arquivo inválido ou inacessível!");
        }
        this.file = file;
    }

    public List<String> lerArquivo(){
        List<String> conteudo = new ArrayList<>();
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){
            String linha;
            while((linha = br.readLine())!=null) {
                conteudo.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conteudo;
    }

    public static void main(String[] args) {
        File file = new File("TheSrc/files/formulario.txt");
//        File file = new File("TheSrc/files/menu.txt");
        EscritaLeituraTxt obj = new EscritaLeituraTxt(file);
        List<String> conteudo = obj.lerArquivo();
        conteudo.forEach(System.out::println);
    }
}
