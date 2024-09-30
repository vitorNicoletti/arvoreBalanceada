package Lista;

public class NoLista {

    private String dirArquivo;
    private int nOcorrencias;
    protected NoLista next;

    public NoLista(String dirArquivo){
        this.dirArquivo = dirArquivo;
        nOcorrencias = 1;
    }
    public void addOcorrencia(){
        nOcorrencias++;
    }
    public String getDirArquivo() {
        return dirArquivo;
    }

    public void setDirArquivo(String dirArquivo) {
        this.dirArquivo = dirArquivo;
    }

    public int getnOcorrencias() {
        return nOcorrencias;
    }

    public void setnOcorrencias(int nOcorrencias) {
        this.nOcorrencias = nOcorrencias;
    }

    @Override
    public String toString() {
        return
                "diretorio =" + dirArquivo +
                ", ocorrencias: " + nOcorrencias + '\'';
    }
}
