import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese cantidad de Personas del listado: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Persona[] personas = new Persona[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese Persona "+ (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Edad: ");
            int edad;
            do {
                edad = scanner.nextInt();
                if (edad < 0) {
                    System.out.println("La edad no puede ser negativa. Intente de nuevo.");
                }
            } while (edad < 0);
            scanner.nextLine(); 

            personas[i] = new Persona(nombre, edad);
        }

        Arrays.sort(personas);

        System.out.print("Valor de la edad a buscar: ");
        int edadBuscada = scanner.nextInt();

        busquedaBinaria(personas, edadBuscada);

        scanner.close();
    }

    public static void busquedaBinaria(Persona[] arr, int edadBuscada) {
        int bajo = 0;
        int alto = arr.length - 1;

        while (bajo <= alto) {
            int centro = (bajo + alto) / 2;
            
            
            System.out.print("[");
            for (int i = bajo; i <= alto; i++) {
                System.out.print(arr[i].getEdad());
                if (i < alto) {
                    System.out.print(" | ");
                }
            }
            System.out.println("]");
            
            System.out.print("bajo=" + bajo + " alto=" + alto + " centro=" + centro + " valorCentro=" + arr[centro].getEdad());

            if (arr[centro].getEdad() == edadBuscada) {
                System.out.println(" --> ENCONTRADO");
                System.out.println();
                System.out.println("La persona con la edad " + edadBuscada + " es: " + arr[centro].getNombre());
                return;
            } else if (arr[centro].getEdad() < edadBuscada) {
                System.out.println(" --> DERECHA");
            } else {
                System.out.println(" --> IZQUIERDA");
            }
            
            System.out.println();

            if (arr[centro].getEdad() < edadBuscada) {
                bajo = centro + 1;
            } else {
                alto = centro - 1;
            }
        }

        System.out.println("No se encontró ninguna persona con la edad " + edadBuscada);
    }
}