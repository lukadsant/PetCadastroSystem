package inicial;

public class Endereco {
    int NumeroCasa;
    String Cidade;
    String Rua;

    public Endereco(int numeroCasa, String cidade, String rua) {
        NumeroCasa = numeroCasa;
        Cidade = cidade;
        Rua = rua;
    }

    public int getNumeroCasa() {
        return NumeroCasa;
    }

    public String getCidade() {
        return Cidade;
    }

    public String getRua() {
        return Rua;
    }

    public void setNumeroCasa(int numeroCasa) {
        NumeroCasa = numeroCasa;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public static void main(String[] args) {
        Endereco obj = new Endereco(165,"Recife","Itaparica");
        System.out.println(obj.getRua());
    }

}
