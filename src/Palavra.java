import Lista.ListaArquivos;

public class Palavra {
    private String palavra;
    private ListaArquivos l1;

    public Palavra(String valor,String dirArquivo){
        palavra = valor;
        l1 = new ListaArquivos();
        l1.inserirPrimeiro(dirArquivo);
    }

    public void addOcorrencia(String dirArquivo){
        l1.addOcorrencia(dirArquivo);
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public ListaArquivos getL1() {
        return l1;
    }

    public void setL1(ListaArquivos l1) {
        this.l1 = l1;
    }
    public String toString(){
        return "Palavra: " + palavra +"\n" +  l1.toString();

    }
}
