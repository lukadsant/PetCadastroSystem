package inicial;

public class Pet {
    String nomeSobronome;
    TipoPet tipo;
    TipoSex sexo;
    Endereco endereco;
    double idade;
    double peso;
    String raca;

    public Pet(String nomeSobronome, TipoPet tipo, TipoSex sexo, Endereco endereco, double idade, double peso, String raca) {
        setNomeSobronome(nomeSobronome);
        this.tipo = tipo;
        this.sexo = sexo;
        this.endereco = endereco;
        setIdade(idade);
        setPeso(peso);
        setRaca(raca);
    }


    private boolean isNomeValido(String nome){
        return nome.matches("^[A-Za-z]+\\s+[A-Za-z]+$");
    }

    private boolean isRacaValido(String raca){
        return raca.matches("^[A-Za-z ]+$");
    }
    private boolean isIdadeValido(double idade){
        return idade > 0 && idade <= 20 ;
    }
    private boolean isPesoValido(double peso){
        return peso>=0.5 && peso<60;
    }
    public String getNomeSobronome() {
        return nomeSobronome;
    }

    public void setNomeSobronome(String nomeSobronome) {
        if (isNomeValido(nomeSobronome)){
            this.nomeSobronome = nomeSobronome;

        }else{
            throw new IllegalArgumentException("Nome inválido! Apenas letras e espaços são permitidos.");
        }
    }

    public TipoPet getTipo() {
        return tipo;
    }

    public void setTipo(TipoPet tipo) {
        this.tipo = tipo;
    }

    public TipoSex getSexo() {
        return sexo;
    }

    public void setSexo(TipoSex sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        if (isIdadeValido(idade)){
            this.idade = idade;
        }else{
            throw new IllegalArgumentException("Idade inválida!");

        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (isPesoValido(peso)){
            this.peso = peso;
        }else{
            throw new IllegalArgumentException("Peso inválido!");
        }
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        if(isRacaValido(raca)){
            this.raca = raca;
        }else{
            throw new IllegalArgumentException("raça inválida!");
        }
    }

    public static void main(String[] args) {
        Endereco myend=new Endereco(165,"Recife","Celeste");
        Pet obj= new Pet("a a" ,TipoPet.CACHORRO,TipoSex.MACHO,myend,20,0.5,"pitbul");

        System.out.println(obj.getNomeSobronome());
    }
}


