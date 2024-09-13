package ui;

import java.util.Scanner;

public class BurgerTown {

    public static Scanner reader;
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a BurgerTown!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada plato vendido en el dia");
            System.out.println("2. Calcular la cantidad total de platos vendidos en el dia");
            System.out.println("3. Calcular el precio promedio de los platos vendidos en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de platos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de platos vendidos en el dia fue de: "+calcularTotalPlatosVendidos());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de los platos vendidos en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarPlatosSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    System.out.println("\nOpcion invalida, intenta nuevamente.");
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de platos diferentes 
     * vendidos en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de platos diferentes vendidos en el dia ");
        int platos = reader.nextInt();

        precios = new double[platos];
        unidades = new int[platos];

    }

    /**
     * Descripcion: Solicita los datos sobre el numero de platos vendidos en el día, es decir, el precio y la cantidad total
     */
    public static void solicitarDatos(){
        int i = 0;
        int j=0;
        while (i<precios.length){
            System.out.println("Por favor, ingrese el precio del plato: " + (j + 1));
            double precioProduct = reader.nextDouble();
            precios [i] = precioProduct;

            System.out.println("Por favor, ingrese la cantidad total vendida del plato");
            int cantVendi = reader.nextInt();
            unidades[i] = cantVendi;

            j++;

            i++;
        }
     
    }

    /**
     * Descripción: Con lo datos anteriormente ingresados y almacenados, realiza el calculo de la cantidad total de platos vendidos en el día
     * @return int, totalPlatosVendi, regresa el resultado de dicho calculo 
     */
    public static int calcularTotalPlatosVendidos(){

        int i = 0;
        int totalPlatosVendi = 0;

        while (i<unidades.length){
            totalPlatosVendi = totalPlatosVendi + unidades[i];

            i++;

        }
        return totalPlatosVendi;

    }

    public static double calcularPrecioPromedio(){
        int i = 0;
        double sumPrecios = 0;
        int platos = 3;

        while(i<precios.length){
            sumPrecios += precios[i];

            i++;
        }

        double presupuesto = sumPrecios / (precios.length); 

        return presupuesto;

    }

    public static double calcularVentasTotales(){

        double totalVendidos = 0;

        for (int i=0 ; i<precios.length; i++){
            totalVendidos = totalVendidos + (precios[i] * unidades[i]);

        }

        return totalVendidos;

    }

    public static int consultarPlatosSobreLimite(double limite){
        //int = 0;
        double ventasPlatos = 0;
        int platosMax = 0;

        for (int i=0 ; i<precios.length ; i++){

            ventasPlatos += (precios [i] * unidades[i]); 
        }

        if (ventasPlatos >= limite){
            platosMax++;

        }


        

        return platosMax;

    }

}