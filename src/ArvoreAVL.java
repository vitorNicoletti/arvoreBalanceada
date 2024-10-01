public class ArvoreAVL {
    No raiz;
    public void inserirElemento(String palavraNova, String dirPath) {
        raiz.inserirElemento(palavraNova,dirPath);
        int subtracao = diferencaBalanceamento(raiz);
        if (subtracao == 2) {
            if (raiz.getEsquerda() != null && diferencaBalanceamento(raiz.getEsquerda()) == -1) {
                // Rotação Dupla à Direita (LR)
                raiz.setEsquerda(rotacaoEsquerda(raiz.getEsquerda()));
            }
            raiz = rotacaoDireita(raiz);
        } else if (subtracao == -2) {
            if (raiz.getDireita() != null && diferencaBalanceamento(raiz.getDireita()) == 1) {
                // Rotação Dupla à Esquerda (RL)
                raiz.setDireita(rotacaoDireita(raiz.getDireita()));
            }
            raiz = rotacaoEsquerda(raiz);
        }


    }

    public int diferencaBalanceamento(No n){

        int alturaEsquerda = -1;
        int alturaDireita = -1;
        if (n.getEsquerda() != null) alturaEsquerda = n.getEsquerda().altura +1;
        if (n.getDireita() !=null) alturaDireita = n.getDireita().altura+1;
        return alturaEsquerda-alturaDireita;
    }
    private No rotacaoDireita(No desbalanceado) {
        // Verifica se o filho esquerdo existe
        No novoPai = desbalanceado.getEsquerda();
        if (novoPai == null) {
            return desbalanceado; // Não há nada para rotacionar, então retorne o nó desbalanceado
        }

        // O filho direito de Y se torna o filho esquerdo de X (o nó desbalanceado)
        desbalanceado.setEsquerda(novoPai.getDireita());

        // Se o novo filho direito de desbalanceado não for nulo, atualize sua altura
        if (desbalanceado.getEsquerda() != null) {
            desbalanceado.getEsquerda().altura = desbalanceado.getEsquerda().calcularAltura();
        }

        desbalanceado.altura = desbalanceado.calcularAltura();

        // Agora o nó Y se torna o pai de X
        novoPai.setDireita(desbalanceado);
        novoPai.altura = novoPai.calcularAltura();

        return novoPai; // Retorna o novo nó pai
    }

    private No rotacaoEsquerda(No desbalanceado) {
        // Verifica se o filho direito existe
        No novoPai = desbalanceado.getDireita();
        if (novoPai == null) {
            return desbalanceado; // Não há nada para rotacionar, então retorne o nó desbalanceado
        }

        // O filho esquerdo de Y se torna o filho direito de X (desbalanceado)
        desbalanceado.setDireita(novoPai.getEsquerda());

        // Se o novo filho esquerdo de desbalanceado não for nulo, atualize sua altura
        if (desbalanceado.getDireita() != null) {
            desbalanceado.getDireita().altura = desbalanceado.getDireita().calcularAltura();
        }

        desbalanceado.altura = desbalanceado.calcularAltura();

        // Agora o nó Y se torna o pai de X
        novoPai.setEsquerda(desbalanceado);
        novoPai.altura = novoPai.calcularAltura();

        return novoPai; // Retorna o novo nó pai (Y)
    }

}
