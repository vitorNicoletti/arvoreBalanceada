package Lista;

public class ListaArquivos {
    private NoLista primeiro;


    public void inserirPrimeiro(String dirPath){
        if (primeiro == null){
            primeiro = new NoLista(dirPath);
        }
        else {
            NoLista n = primeiro;
            primeiro = new NoLista(dirPath);
            primeiro.next = n;

        }
    }
    public NoLista getNoPeloDir(String dirPath) {
        NoLista p = primeiro;
        while (p != null && (!(p.getDirArquivo().equals(dirPath)))) {
            p = p.next;
        }
        return p;
    }
    public void addOcorrencia(String dirPath){
        NoLista no = getNoPeloDir(dirPath);
        if (no == null){
            inserirPrimeiro(dirPath);
        }
        else{
            no.addOcorrencia();
        }
    }
    public String toString(){
        NoLista p = primeiro;
        String saida = "Lista de Ocorrencias: \n";
        int totalOcorrencias = 0;
        while(p != null){
            saida += p.toString() +"\n";
            totalOcorrencias += p.getnOcorrencias();
            p = p.next;
        }
        saida += "Total de Ocorrencias: " + totalOcorrencias + "\n";
        return saida;
    }
}


