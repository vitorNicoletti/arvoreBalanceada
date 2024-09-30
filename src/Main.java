//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Palavra p = new Palavra("arrou", "/papa.txt");

        No raiz = new No("Aroldo","./show.txt");
        raiz.inserirElemento("Bartolomeu Cuma","./Bacamarte.txt");
        raiz.inserirElemento("Pneu","./Bacamarte.txt");
        raiz.inserirElemento("Pneu","./show.txt");
        raiz.inserirElemento("Pneu","./show.txt");
        raiz.inserirElemento("Denis","./Bacamarte.txt");
        raiz.inserirElemento("Zneu","./Bacamarte.txt");

        raiz.mostrarInorder();
        System.out.println(raiz.altura());
        System.out.println(raiz.acharElemento("Pneu") == null);
        No n1 = raiz.acharElemento("Pneu");
        System.out.println(n1.getValor().toString());
    }
}