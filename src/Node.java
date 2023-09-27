public class Node {
    private int valor;
    private Node cima;
    private Node direita;
    private Node esquerda;

    public Node(int valor){
        this.valor = valor;
        direita = null;
        esquerda = null;
        cima = null;
    }

    public Node getCima() {
        return cima;
    }

    public void setClass(Node no){
        this.valor = no.valor;
        this.direita = no.direita;
        this.esquerda = no.esquerda;
        this.cima = no.getCima();
    }
    public void matarNode(){
        this.valor = -1;
        direita = null;
        esquerda = null;
        cima = null;
    }

    public void setCima(Node cima) {
        this.cima = cima;
    }

    public Node getDireita() {
        return direita;
    }

    public int getValor() {
        return valor;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
