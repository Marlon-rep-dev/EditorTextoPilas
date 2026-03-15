public class Pila {

    String[] datos;   // este es el arreglo donde se guardan los elementos
    int cima;

    // este es el constructor de la pila
    public Pila(int tamaño) {
        datos = new String[tamaño];
        cima = -1; // la pila inicia vacía
    }

    // Método push: agrega un elemento a la pila
    public void push(String texto) {
        cima++;
        datos[cima] = texto;
    }

    // Método pop: este elimina el último elemento de la pila
    public String pop() {
        String elemento = datos[cima];
        cima--;
        return elemento;
    }

    // Método peek: este nos muestra el último elemento sin eliminarlo
    public String peek() {
        return datos[cima];
    }

    // Método isEmpty: verifica si la pila está vacía
    public boolean isEmpty() {
        return cima == -1;
    }

    // Método para mostrar todo el contenido de la pila
    public void mostrar() {

        if (isEmpty()) {
            System.out.println("No hay texto");
        } else {

            for (int i = 0; i <= cima; i++) {
                System.out.println(datos[i]);
            }

        }

    }
}