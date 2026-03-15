import java.util.Scanner;

// este es el programa principal que simula un editor de texto simple

public class EditorTexto {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // esta pila guarda las acciones realizadas
        Pila pilaUndo = new Pila(100);

        // esta pila guarda las acciones deshechas
        Pila pilaRedo = new Pila(100);

        int opcion = 0;

        // menú principal del programa
        while (opcion != 5) {

            System.out.println("===== EDITOR DE TEXTO =====");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");
            System.out.println("===========================");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            // aqui se agrega una opción para escribir texto
            if (opcion == 1) {

                System.out.print("Escriba una línea: ");
                String texto = scanner.nextLine();

                pilaUndo.push(texto);

                // cuando se escribe algo nuevo se limpia la pila redo
                pilaRedo = new Pila(100);

            }

            // opción para deshacer la última acción
            if (opcion == 2) {

                if (!pilaUndo.isEmpty()) {

                    String eliminado = pilaUndo.pop();
                    pilaRedo.push(eliminado);

                    System.out.println("Se deshizo: " + eliminado);

                } else {

                    System.out.println("No hay acciones para deshacer");

                }

            }

            // opción para rehacer una acción deshecha
            if (opcion == 3) {

                if (!pilaRedo.isEmpty()) {

                    String rehacer = pilaRedo.pop();
                    pilaUndo.push(rehacer);

                    System.out.println("Se rehizo: " + rehacer);

                } else {

                    System.out.println("No hay acciones para rehacer");

                }

            }

            // opción para mostrar el texto actual
            if (opcion == 4) {

                System.out.println("\nTexto actual:");
                pilaUndo.mostrar();

            }

        }

        scanner.close();
    }
}