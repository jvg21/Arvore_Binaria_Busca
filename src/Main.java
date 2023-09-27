// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArvoreBinaria abb = new ArvoreBinaria(50);
        abb.inserirNo(60);
        abb.inserirNo(71);
        abb.inserirNo(79);
        abb.inserirNo(78);
        abb.inserirNo(75);
        abb.inserirNo(80);
        abb.inserirNo(69);
        abb.inserirNo(71);
        abb.inserirNo(68);
        abb.inserirNo(55);
        abb.inserirNo(20);
        abb.inserirNo(30);
        abb.inserirNo(29);
        abb.printTree();

        abb.removerNo(71);
        
        abb.printTree();



    }
}