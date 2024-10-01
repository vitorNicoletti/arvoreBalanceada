import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LeitorArquivos {
    ArvoreAVL arvore;
    File[] arquivos;
    File txtAtual;

    public LeitorArquivos(File[] arquivos) {
        this.arquivos = arquivos;
        arvore = new ArvoreAVL();
    }

    public void readFiles() {
        for (File arquivo : arquivos) {
            txtAtual = arquivo;
            if (txtAtual.canRead()) {
                try {
                    String[] s = Files.readString(arquivo.toPath()).split(" ");
                    for (String palavra : s) {
                        storeOneWord(palavra);
                    }
                } catch (IOException ex) {
                    System.out.println("erro ao ler o arquivo");
                }

            }
        }
    }

    public void storeOneWord(String palavra) {
        palavra = palavra.replaceAll("[^a-zA-Z0-9]", "");
        addWordOnTree(palavra);
    }

    public void addWordOnTree(String palavra) {
        if (arvore.raiz == null) {
            arvore.raiz = new No(palavra, txtAtual.getPath());
        } else {
            arvore.inserirElemento(palavra, txtAtual.getPath());
        }
    }

    public String getWord(String palavra) {
        No p = arvore.raiz.acharElemento(palavra);
        if (p != null){
            return p.getValor().toString();
        }
        else {
            return null;
        }

    }

    public void printAllFileNames() {
        for (File arquivo : arquivos) {
            System.out.println(arquivo.getName());
        }
    }


    public void runUserInterface() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != -1) {
            try {
                // Solicita a palavra ao usuário
                System.out.println("Digite a palavra a ser consultada (ou -1 para sair):");
                String palavra = scanner.nextLine().trim(); // Captura a entrada do usuário

                // Verifica se o usuário deseja sair
                if (palavra.equals("-1")) {
                    opcao = -1;
                    System.out.println("Saindo...");
                } else {
                    // A palavra foi digitada corretamente
                    if (getWord(palavra) != null){
                        System.out.println(getWord(palavra));
                    }
                    else {
                        System.out.println("Palavra nao encontrada nos arquivos");
                    }



                }
            } catch (InputMismatchException e) {
                // Captura entradas incorretas
                System.out.println("Entrada inválida! Tente novamente.");
                scanner.nextLine(); // Limpa o buffer do Scanner
            } catch (Exception e) {
                // Captura qualquer outra exceção não prevista
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
                scanner.nextLine(); // Limpa o buffer
            }
        }

        // Fecha o scanner ao final do uso
        scanner.close();
    }
}
