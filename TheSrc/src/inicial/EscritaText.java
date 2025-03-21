package inicial;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscritaText {
    private  File arquivo;

    public EscritaText(File arquivo) {
        this.arquivo=arquivo;
    }

    public void gravarTexto(String texto){
        try(FileWriter fw = new FileWriter(arquivo,true)){
            fw.write(texto+"\n");
            fw.flush();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File fileresp = new File("file.txt");
        EscritaText obj = new EscritaText(fileresp);
        obj.gravarTexto("Setando texto");
    }
}
