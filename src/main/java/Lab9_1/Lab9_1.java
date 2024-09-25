/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab9_1;

/**
 *
 * @author David
 */
import java.util.Random;
import java.util.Scanner;

public class Lab9_1 {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una instancia de Chained_Hash con 5 posiciones, usando el método de la división o multiplicación
        System.out.println("Selecciona método hash: \n1. División\n2. Multiplicación");
        int metodoHash = scanner.nextInt();
        boolean usarDivision = metodoHash == 1;
        
        Chained_Hash<Usuario> tablaHash = new Chained_Hash<>(5, usarDivision);  // Tamaño de la tabla hash = 5

        // Insertar 10 usuarios por defecto
        Usuario[] usuariosPorDefecto = {
            new Usuario("Carlos", 10),
            new Usuario("Ana", 2),
            new Usuario("Maria Constanza", 7),
            new Usuario("Marta", 3),
            new Usuario("Pedro", 15),
            new Usuario("Lucia", 6),
            new Usuario("Juan", 9),
            new Usuario("Sofia", 12),
            new Usuario("Miguel", 8),
            new Usuario("Laura", 4)
        };

        for (Usuario usuario : usuariosPorDefecto) {
            tablaHash.insert(usuario.getClave(), usuario);
        }

        // Mostrar tabla hash inicial con usuarios por defecto
        System.out.println("Tabla hash inicial con usuarios por defecto:");
        tablaHash.printTable();

        // Interacción con el usuario
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Insertar nuevo dato");
            System.out.println("2. Buscar un dato por clave");
            System.out.println("3. Eliminar un dato por clave");
            System.out.println("4. Mostrar tabla hash");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1: // Insertar
                    System.out.print("Ingresa el nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingresa la clave del usuario (entero): ");
                    int clave = scanner.nextInt();
                    Usuario usuario = new Usuario(nombre, clave);
                    tablaHash.insert(clave, usuario);
                    System.out.println("Usuario insertado correctamente.");
                    tablaHash.printTable();
                    break;
                case 2: // Buscar
                    System.out.print("Ingresa la clave del usuario a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    Usuario encontrado = tablaHash.search(claveBuscar);
                    if (encontrado != null) {
                        System.out.println("Usuario encontrado: nombre = " + encontrado.getNombre() + ", clave = " + encontrado.getClave());
                    } else {
                        System.out.println("Usuario con clave " + claveBuscar + " no encontrado.");
                    }
                    break;
                case 3: // Eliminar
                    System.out.print("Ingresa la clave del usuario a eliminar: ");
                    int claveEliminar = scanner.nextInt();
                    boolean eliminado = tablaHash.delete(claveEliminar);
                    if (eliminado) {
                        System.out.println("Usuario con clave " + claveEliminar + " eliminado correctamente.");
                    } else {
                        System.out.println("Usuario con clave " + claveEliminar + " no encontrado.");
                    }
                    tablaHash.printTable();
                    break;
                case 4: // Mostrar tabla hash
                    tablaHash.printTable();
                    break;
                case 5: // Salir
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
