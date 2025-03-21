package inicial;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MenuOpcoes {
    private int qPerguntas;

    public MenuOpcoes(int qPerguntas) {
        this.qPerguntas=qPerguntas;
    }

    public void recarregarOpcoes(){
        File file = new File("TheSrc/files/menu.txt");
        EscritaLeituraTxt obj = new EscritaLeituraTxt(file);
        List<String> conteudo = obj.lerArquivo();
        conteudo.forEach(System.out::println);
    }

    public void salvarResposta(String texto){
        File fileresp = new File("file.txt");
        EscritaText obj = new EscritaText(fileresp);
        obj.gravarTexto(texto);


    }
    public void EsperarPergunta(){
        System.out.print("Digite uma das opções acima (1 a " + qPerguntas + "): ");
        Scanner scanner=new Scanner(System.in);

        while(true){
            try {
                int qDigitada = Integer.parseInt(scanner.nextLine());

                if (qDigitada <= qPerguntas && qDigitada > 0) {
                    System.out.println("opção escolhida: " + qDigitada);
                    String qResp = scanner.nextLine();
                    salvarResposta(qDigitada+": "+qResp);
                    break;
                } else {
                    System.out.println("Opção inválida. Digite um número entre 1 e " + qPerguntas + ": ");
                    recarregarOpcoes();

                }
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("TheSrc/files/menu.txt");
        EscritaLeituraTxt obj = new EscritaLeituraTxt(file);
        List<String> conteudo = obj.lerArquivo();
        conteudo.forEach(System.out::println);

        MenuOpcoes menu = new MenuOpcoes(conteudo.size());
        menu.EsperarPergunta();

    }
}
