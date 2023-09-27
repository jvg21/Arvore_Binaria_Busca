public class ArvoreBinaria {
    private Node noRaiz;

    public ArvoreBinaria(int valor) {
        this.noRaiz = new Node(valor) ;
    }

    public Node getNoRaiz() {
        return noRaiz;
    }

    public void inserirNo(int valor){
        inserirRecursivo(valor,this.noRaiz);
    }

    private Node inserirRecursivo(int valor,Node no){

        if (valor>no.getValor()){ ///direita
            if (no.getDireita() == null){
                no.setDireita(new Node(valor));
                no.getDireita().setCima(no);

                System.out.println(valor+" Inserido");
                return no.getDireita();
            }else{
               return inserirRecursivo(valor,no.getDireita());
            }

        }

        if (valor<no.getValor()) {//esquerda
            if (no.getEsquerda() == null){
                no.setEsquerda(new Node(valor));
                no.getEsquerda().setCima(no);

                System.out.println(valor+" Inserido");
                return no.getDireita();
            }else{
                return inserirRecursivo(valor,no.getEsquerda());
            }
        }

        System.out.println(valor+" Já está na árvore");
        return no;
    }
    public boolean procurarNo(int valor){
        if (procurarRecursivo(valor,this.noRaiz)!=null){
            return true;
        }
        return false;
    }

    private Node procurarRecursivo(int valor, Node no){
        if (no == null){
            System.out.println(valor+" Não Encontrado");
            return no;
        }

        if (valor> no.getValor()){
            return procurarRecursivo(valor,no.getDireita());
        }
        if (valor< no.getValor()) {
            return procurarRecursivo(valor,no.getEsquerda());
        }

        System.out.println(valor+" Encontrado");
        return no;

    }

    public Node removerNo(int valor){
        Node noExcluir = procurarRecursivo(valor,this.noRaiz);
        if (noExcluir==null){
            return this.noRaiz;
        }
        Node Cima = noExcluir.getCima();
        Node Direita = noExcluir.getDireita();
        Node Esquerda = noExcluir.getEsquerda();

        if (Esquerda == null && Direita == null){ //É um nó folha

            if (Cima.getEsquerda() == noExcluir){
                Cima.setEsquerda(null);

            } else if (Cima.getDireita() == noExcluir) {
                Cima.setDireita(null);
            }
            noExcluir.matarNode();
        }
         if (Esquerda!=null && Direita==null){

            if (Cima.getEsquerda() == noExcluir){
                Cima.setEsquerda(Esquerda);

            } else if (Cima.getDireita() == noExcluir) {
                Cima.setDireita(Esquerda);
            }

            Esquerda.setCima(Cima);
        }
         if (Esquerda==null && Direita!=null) {
            if (Cima.getEsquerda() == noExcluir){
                Cima.setEsquerda(Direita);

            } else if (Cima.getDireita() == noExcluir) {
                Cima.setDireita(Direita);
            }
            Direita.setCima(Cima);
        }
         if (Esquerda!=null && Direita!= null){
//             System.out.println("Deu ruim");
             Node noSubstituto = ValorSubstituto(noExcluir.getDireita());

             noSubstituto.getCima().setEsquerda(null);
             noSubstituto.setCima(Cima);

             noSubstituto.setDireita(noExcluir.getDireita());
             noSubstituto.setEsquerda(noExcluir.getEsquerda());

             if (Cima.getEsquerda() == noExcluir){
                 Cima.setEsquerda(noSubstituto);
             }
             if (Cima.getDireita() == noExcluir){
                 Cima.setDireita(noSubstituto);
             }
             noExcluir.matarNode();
         }
        System.out.println(valor + "Removido");
         return this.noRaiz;

    }

    private Node ValorSubstituto(Node no){

        while (no.getEsquerda()!=null){
            no = no.getEsquerda();
        }
        return no;
    }


    public void printTree(){
        printTreeRec(this.noRaiz, 0);
    }

    private void printTreeRec(Node no, int profundidade) {
        if (no != null) {
            printTreeRec(no.getDireita(), profundidade + 1);
            for (int i = 0; i < profundidade; i++) {
                System.out.print("    ");
            }
            System.out.println(no.getValor());
            printTreeRec(no.getEsquerda(), profundidade + 1);
        }
    }
}
