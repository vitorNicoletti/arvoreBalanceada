import java.io.File;

public class LeitorArquivosInicializer {
    ArvoreAVL raizz;


    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("Parametros nao fornecidos");
            return;
        }
        File pasta = new File(args[0]);
        if (pasta.isDirectory()){
            File[] arquivos = pasta.listFiles();
            if (arquivos != null && arquivos.length > 0) {
                LeitorArquivos la = new LeitorArquivos(arquivos);
                System.out.println("Arquivos encontrados na pasta:");
                la.printAllFileNames();
                System.out.println("=========");
                la.readFiles();
                System.out.println("Arquivos lidos com sucesso!");
                la.runUserInterface();


            }
        }
        else{
            System.out.println("diretorio Invalido");
        }
    }

}

