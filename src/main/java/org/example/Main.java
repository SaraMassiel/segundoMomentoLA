package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> codigos = new ArrayList<>();
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Float> precios = new ArrayList<>();
        ArrayList<LocalDate> fechasIngreso = new ArrayList<>();
        ArrayList<Boolean> perecederos = new ArrayList<>();
        ArrayList<LocalDate> fechasVencimiento = new ArrayList<>();


        int opcion;

        do {
            // Eliminar productos perecederos vencidos hace más de 3 días.
            LocalDate hoy = LocalDate.now();
            for (int i = fechasVencimiento.size() - 1; i >= 0; i--) {
                if (perecederos.get(i) && hoy.isAfter(fechasVencimiento.get(i).plusDays(3))) {
                    System.out.println("Producto vencido eliminado: " + nombres.get(i));
                    codigos.remove(i);
                    nombres.remove(i);
                    precios.remove(i);
                    fechasIngreso.remove(i);
                    perecederos.remove(i);
                    fechasVencimiento.remove(i);
                }
            }

            // Menú.
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Modificar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar la linea o algo así.

            if (opcion == 1) {
                System.out.print("Código: ");
                String codigo = sc.nextLine();
                if (codigos.contains(codigo)) {
                    System.out.println("Código ya existe.");
                    continue;
                }

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Precio: ");
                float precio = sc.nextFloat();
                sc.nextLine();

                System.out.print("Fecha de ingreso (YYYY-MM-DD): ");
                LocalDate fechaIngreso = LocalDate.parse(sc.nextLine());

                System.out.print("¿Es perecedero? (true/false): ");
                boolean perece = sc.nextBoolean();
                sc.nextLine();

                LocalDate fechaVencimiento;
                if (perece) {
                    System.out.print("Fecha de vencimiento (YYYY-MM-DD): ");
                    fechaVencimiento = LocalDate.parse(sc.nextLine());
                } else {
                    fechaVencimiento = fechaIngreso.plusYears(100); // Para no eliminar nunca jamas de los jamases.
                }

                codigos.add(codigo);
                nombres.add(nombre);
                precios.add(precio);
                fechasIngreso.add(fechaIngreso);
                perecederos.add(perece);
                fechasVencimiento.add(fechaVencimiento);

                System.out.println("Producto agregado.");
            }

            else if (opcion == 2) {
                System.out.println("\nProductos:");
                for (int i = 0; i < nombres.size(); i++) {
                    System.out.println("[" + (i + 1) + "] " + nombres.get(i));
                    System.out.println("Código: " + codigos.get(i));
                    System.out.println("Precio: $" + precios.get(i));
                    System.out.println("Fecha ingreso: " + fechasIngreso.get(i));
                    System.out.println("Perecedero: " + perecederos.get(i));
                    System.out.println("Vencimiento: " + fechasVencimiento.get(i));
                    System.out.println("-----------****----------");
                }
            }

            else if (opcion == 3) {
                System.out.print("Número del producto a modificar: ");
                int idx = sc.nextInt();
                sc.nextLine();
                if (idx < 1 || idx > nombres.size()) {
                    System.out.println("Número inválido.");
                } else {
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevo precio: ");
                    float nuevoPrecio = sc.nextFloat();
                    sc.nextLine();

                    nombres.set(idx - 1, nuevoNombre);
                    precios.set(idx - 1, nuevoPrecio);
                    System.out.println("Producto modificado.");
                }
            }

            else if (opcion == 4) {
                System.out.print("Número del producto a eliminar: ");
                int idx = sc.nextInt();
                sc.nextLine();
                if (idx < 1 || idx > nombres.size()) {
                    System.out.println("Número inválido.");
                } else {
                    codigos.remove(idx - 1);
                    nombres.remove(idx - 1);
                    precios.remove(idx - 1);
                    fechasIngreso.remove(idx - 1);
                    perecederos.remove(idx - 1);
                    fechasVencimiento.remove(idx - 1);
                    System.out.println("Producto eliminado.");
                }
            }

        } while (opcion != 0);

        System.out.println("Saliendo...");
    }
}
