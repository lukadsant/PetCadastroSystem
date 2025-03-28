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


    public void petSwitch(int methodNumber,String qResp){
        Pet pet= new Pet();

        System.out.println(methodNumber);

        switch(methodNumber){
            case 1:
                pet.setNomeSobronome(qResp);
            case 2:
                pet.setTipo(TipoPet.valueOf(qResp));
            case 3:
                pet.setSexo(TipoSex.valueOf(qResp));

        }


    }
    public void perguntarESalvar(){
        File file = new File("TheSrc/files/formulario.txt");
        EscritaLeituraTxt obj = new EscritaLeituraTxt(file);
        List<String> conteudo = obj.lerArquivo();
        Scanner scanner=new Scanner(System.in);

        for (String i:conteudo){
            System.out.println(conteudo.get(conteudo.indexOf(i)));
            String qResp = scanner.nextLine();
            petSwitch(conteudo.indexOf(i)+1,qResp);

            System.out.println("--------------------");
//
//            salvarResposta(conteudo.indexOf(i)+": "+qResp);

        }

    }
    public void carregarPergunta(int posicao){
        File file = new File("TheSrc/files/formulario.txt");
        EscritaLeituraTxt obj = new EscritaLeituraTxt(file);
        List<String> conteudo = obj.lerArquivo();
        System.out.println(conteudo.get(posicao));;

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
                  switch (qDigitada){
                      case 1:
                          perguntarESalvar();
                          break;
                      case 2:
                          System.out.println("outra opçõa");
                          break;

                  }
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
