public class No {
    private Palavra valor;
    private No esquerda;
    private No direita;

    public No(Palavra valor) {
        this.valor = valor;
    }
    public No(String palavra, String dirPath) {
        valor = new Palavra(palavra, dirPath);
    }

    public Palavra getValor() {
        return valor;
    }

    public void inserirElemento(String palavraNova, String dirPath) {
        int comparacao = palavraNova.compareToIgnoreCase(valor.getPalavra());

        if (comparacao == 0) {
            valor.addOcorrencia(dirPath); // A palavra já existe, só adiciona a ocorrência
        } else{
            if (comparacao < 0) {
                esquerda = inserirDireitaOuEsquerda(esquerda, palavraNova, dirPath); // A palavra vem antes (menor)
            } else {
                direita = inserirDireitaOuEsquerda(direita, palavraNova, dirPath); // A palavra vem depois (maior)
            }

            int subtracao = diferencaBalanceamento();
            if (subtracao == 2) {
                if (esquerda != null && esquerda.diferencaBalanceamento() == -1) {
                    // Rotação Dupla à Direita (LR)
                    esquerda.rotacaoEsquerda();
                }

                rotacaoDireita();
            }
            else if (subtracao == -2) { // A subárvore direita está desbalanceada
                if (direita != null && direita.diferencaBalanceamento() == 1) {
                    // Rotação Dupla à Esquerda (RL)
                    direita.rotacaoDireita(); // Primeiro, faça a rotação à direita no filho direito
                }
                // Rotação Simples à Esquerda
                rotacaoEsquerda(); // Depois, faça a rotação à esquerda
            }

        }
    }

    private No inserirDireitaOuEsquerda(No direcao, String palavraNova, String dirPath) {
        if (direcao == null) {
            return new No(palavraNova, dirPath); // Cria um novo nó se o lado (esquerda ou direita) for null
        } else {
            direcao.inserirElemento(palavraNova, dirPath); // Continua a inserção recursivamente
            return direcao;
        }
    }
    private void rotacaoDireita() {
        // Guardamos a subárvore esquerda (que será promovida)
        No novaRaiz = this.esquerda;

        // Ajustamos o filho esquerdo para ser o filho direito da nova raiz
        this.esquerda = novaRaiz.direita;

        // Promovemos a nova raiz no lugar de "this"
        novaRaiz.direita = this;

        // Atualiza o valor do nó atual com o da nova raiz (troca de informações)
        this.valor = novaRaiz.valor;
        this.direita = novaRaiz.direita;
        this.esquerda = novaRaiz.esquerda;
    }

    private void rotacaoEsquerda() {
        No novaRaiz = this.direita;

        this.direita = novaRaiz.esquerda;

        novaRaiz.esquerda = this;

        this.valor = novaRaiz.valor;
        this.direita = novaRaiz.direita;
        this.esquerda = novaRaiz.esquerda;
    }

    public No acharElemento(String palavra) {
        int comparacao = palavra.compareToIgnoreCase(valor.getPalavra());

        if (comparacao == 0) {
            return this; //
        } else if (comparacao < 0) {
            return esquerda != null ? esquerda.acharElemento(palavra) : null; // Procura à esquerda
        } else {
            return direita != null ? direita.acharElemento(palavra) : null; // Procura à direita
        }
    }
    public int altura() {
        int alturaEsq = 0;
        int alturaDir = 0;
        if (esquerda != null) {
            alturaEsq = 1+ esquerda.altura();
        }
        if (direita != null) {
            alturaDir = 1 + direita.altura();
        }
        return Math.max(alturaDir, alturaEsq);
    }
    public int[] alturaEsqDir() {
        int alturaEsq = 0;
        int alturaDir = 0;
        if (esquerda != null) {
            alturaEsq = 1+ esquerda.altura();
        }
        if (direita != null) {
            alturaDir = 1 + direita.altura();
        }
        return new int[]{alturaEsq,alturaDir};
    }
    public int diferencaBalanceamento(){
        int[] alturas = alturaEsqDir();
        return alturas[0] - alturas[1];
    }
    public void mostrarInorder() {
        if (esquerda != null) {
            esquerda.mostrarInorder();
        }
        System.out.println(valor.getPalavra());
        if (direita != null) {
            direita.mostrarInorder();
        }
    }

    public void mostrarPreordem() {
        System.out.println(valor.getPalavra());
        if (esquerda != null) {
            esquerda.mostrarPreordem();
        }
        if (direita != null) {
            direita.mostrarPreordem();
        }
    }

    public void mostrarPosordem() {
        if (esquerda != null) {
            esquerda.mostrarPosordem();
        }
        if (direita != null) {
            direita.mostrarPosordem();
        }
        System.out.println(valor.getPalavra());
    }

    public void setValor(Palavra valor) {
        this.valor = valor;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
}
