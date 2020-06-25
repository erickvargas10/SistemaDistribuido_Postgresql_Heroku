package com.mycompany.principal;

import com.mycompany.entidades.Producto;
import com.mycompany.session.ProductoJpaController;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
        ProductoJpaController pjc = new ProductoJpaController(emf);
        Producto p = new Producto();

        Scanner scan = new Scanner(System.in);
        int opcion;

        String codigoS;
        int codigo;

        String nombre;

        String precioS, detalleS;
        Double precio;

        Test t = new Test();

        do {

            System.out.println("\n\t Mi Supermercado ");

            System.out.println("¿ Qué desea Hacer ?");
            System.out.println(" 1. Insertar");
            System.out.println(" 2. Actualizar");
            System.out.println(" 3. Eliminar");
            System.out.println(" 4. Visualizar el listado");
            System.out.println(" 5. Salir");

            System.out.print("Ingrese la opcion: ");
            opcion = scan.nextInt();

            switch (opcion) {

                case 1:

                    scan.nextLine();

                    System.out.println("\nIngresar Producto");
                    System.out.print("Codigo: ");
                    codigoS = scan.nextLine();
                    codigo = Integer.parseInt(codigoS);

                    System.out.print("Nombre: ");
                    nombre = scan.nextLine();

                    System.out.print("Precio: ");
                    precioS = scan.nextLine();
                    precio = Double.parseDouble(precioS);
                    
                    System.out.print("Detalle: ");
                    detalleS = scan.nextLine();

                    //Aqui
                    p.setCodigo(codigo);
                    p.setNombre(nombre);
                    p.setDetalle(detalleS);
                    
                    BigDecimal bd1 = BigDecimal.valueOf(precio.doubleValue());
                    p.setPrecio(bd1);

                    try {
                        pjc.create(p);
                        System.out.print("Producto Ingresado correctamente !");
                    } catch (Exception ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
                    }

                    break;

                case 2:
                    
                    String nombreA = "AV";

                    System.out.println("\n Actualizar Producto");

                    try {
                        System.out.println("");
                        System.out.println(pjc.findProductoEntities());
                        System.out.println("");
                    } catch (Exception ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
                    }

                    System.out.print("Ingrese el codigo del Producto a actualizar: ");
                    int codigoA = scan.nextInt();

                    System.out.print("Nombre: ");
                    nombreA = scan.nextLine();
                    nombreA = scan.nextLine();

                    System.out.print("Precio: ");
                    precioS = scan.nextLine();
                    precio = Double.parseDouble(precioS);
                    BigDecimal bd2 = BigDecimal.valueOf(precio.doubleValue());
                    
                    System.out.print("Detalle: ");
                    detalleS = scan.nextLine();
                    
                    //Aqui
                    p.setCodigo(codigoA);
                    p.setNombre(nombreA);
                    p.setDetalle(detalleS);
                    p.setPrecio(bd2);

                    try {
                        pjc.edit(p);
                        System.out.print("Producto Actualizado correctamente !");
                    } catch (Exception ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
                    }

                    break;

                case 3:

                    System.out.println("\n Eliminar Producto ");
                    
                   try {
                       System.out.println("");
                        System.out.println(pjc.findProductoEntities());
                        System.out.println("");
                    } catch (Exception ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
                    }

                    System.out.print("Ingrese el codigo del Producto a eliminar: ");
                    int codigoE = scan.nextInt();

                    try {
                        pjc.destroy(codigoE);
                        System.out.println("Producto Eliminado correctamente !");
                    } catch (Exception ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
                    }

                    break;

                case 4:

                    System.out.println("\t\nSu Lista de Productos");
                     try {
                        System.out.println("");
                        System.out.println(pjc.findProductoEntities());
                        System.out.println("");
                    } catch (Exception ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
                    }

                    break;

                case 5:

                    System.out.println("\nEsta seguro de que desea Salir ?");
                    System.out.println("1. Si");
                    System.out.println("2. No");
                    System.out.print("Ingrese Opcion = ");
                    int opcSalir = scan.nextInt();
                    if (opcSalir == 1) {
                        break;
                    } else {
                        opcion = 0;
                    }
                    break;

                default:

                    System.out.println("\nOpcion Incorrecta !");
                    break;
            }

        } while (opcion != 5);

    }

}
