package org.example;

import java.util.Scanner;

public class MenuSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[100];     // arreglo para nombres
        float[] precios = new float[100];       // arreglo para precios
        int cantidadProductos = 0;              // contador de productos guardados

        int opcion;

        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Modificar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");
            opcion = sc.nextInt();


            switch (opcion) {
                case 1:
                    if (cantidadProductos < 100) {
                        System.out.print("Nombre del producto: ");
                        nombres[cantidadProductos] = sc.nextLine();
                        System.out.print("Precio del producto: ");
                        precios[cantidadProductos] = sc.nextFloat();
                        sc.nextLine(); // limpiar buffer
                        cantidadProductos++;
                        System.out.println("Producto agregado.");
                    } else {
                        System.out.println("Capacidad máxima alcanzada.");
                    }
                    break;

                case 2:
                    System.out.println("\nLista de productos:");
                    for (int i = 0; i < cantidadProductos; i++) {
                        System.out.println((i+1) + ". " + nombres[i] + " - $" + precios[i]);
                    }
                    break;

                case 3:
                    System.out.print("Número del producto a modificar: ");
                    int numMod = sc.nextInt();
                    sc.nextLine();
                    if (numMod > 0 && numMod <= cantidadProductos) {
                        System.out.print("Nuevo nombre: ");
                        nombres[numMod - 1] = sc.nextLine();
                        System.out.print("Nuevo precio: ");
                        precios[numMod - 1] = sc.nextFloat();
                        sc.nextLine();
                        System.out.println("Producto modificado.");
                    } else {
                        System.out.println("Número inválido.");
                    }
                    break;

                case 4:
                    System.out.print("Número del producto a eliminar: ");
                    int numDel = sc.nextInt();
                    sc.nextLine();
                    if (numDel > 0 && numDel <= cantidadProductos) {
                        // mover los productos hacia atrás para eliminar el seleccionado
                        for (int i = numDel - 1; i < cantidadProductos - 1; i++) {
                            nombres[i] = nombres[i+1];
                            precios[i] = precios[i+1];
                        }
                        cantidadProductos--;
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Número inválido.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

    }
}
