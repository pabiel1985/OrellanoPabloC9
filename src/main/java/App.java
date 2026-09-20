import java.util.List;
import java.util.Scanner;

import Enum.Estado;

public class App {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        GestorEquipos gestorEquipos = new GestorEquipos();

        int opcion;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Agregar");
            System.out.println("2. Buscar");
            System.out.println("3. Modificar");
            System.out.println("4. Buscar por estado");
            System.out.println("5. Precio total:  ");
            System.out.println("6. Orden mas cara");
            System.out.println("7. Mayor a menor");
            System.out.println("0. Salir");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:

                    AlquilerEquipo orden = null;
                    System.out.println("Elegir 1-Comun o 2-Especial");
                    int tipoEquipo = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Nombre de Cliente");
                    String nombreCliente = entrada.nextLine();
                    System.out.println("Nombre del equipo");
                    String equipo= entrada.nextLine();
                    System.out.println("Fecha");
                    String fecha = entrada.nextLine();
                    System.out.println("Cantidad de dias");
                    int cantidadDias = entrada.nextInt();
                    entrada.nextLine();

                    if (tipoEquipo == 1) {
                        System.out.println("Precio Diario");
                        double precioDiario = entrada.nextDouble();
                        entrada.nextLine();
                        orden = new EquipoComun(nombreCliente,equipo,fecha,cantidadDias,precioDiario);
                    } else if (tipoEquipo == 2) {
                        System.out.println("Nivel servicio de 1 a 3");
                        int nivel = entrada.nextInt();
                        entrada.nextLine();

                        orden = new EquipoEspecial(nombreCliente,equipo,fecha,cantidadDias,nivel);
                    } else {
                        System.out.println("Incorrecto");
                    }

                    gestorEquipos.nuevoEquipo(orden);
                    break;

                case 2:
                    System.out.println("numero de orden a buscar");
                    int numOrden = entrada.nextInt();
                    entrada.nextLine();
                    //tambien ojo a ordentrabajo
                    AlquilerEquipo orden2 = gestorEquipos.buscarEquipo(numOrden);
                    if (orden2 != null) {
                        System.out.println(orden2);
                    } else {
                        System.out.println("No se encontro el orden");
                    }
                    break;

                case 3:
                    System.out.println("Numero de orden a modificar Estado");
                    int numOrden2 = entrada.nextInt();
                    entrada.nextLine();

                    Estado cambiarEstado = Estado.valueOf(entrada.nextLine().toUpperCase());
                    if (gestorEquipos.cambiarEstado(numOrden2, cambiarEstado)) {
                        System.out.println("Estado actualizado");
                    } else {
                        System.out.println("Error al cambiar estado");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese estado");

                    Estado b = Estado.valueOf(entrada.nextLine().toUpperCase());
                    List<AlquilerEquipo> listaEstados = gestorEquipos.buscarPorEstado(b);
                    for (AlquilerEquipo estado : listaEstados) {
                        System.out.println(estado);
                    }
                    break;

                case 5:
                    double total;
                    total = gestorEquipos.sumarAlquileres();
                    System.out.println("El total es: " + total);
                    break;


                case 6:
                    AlquilerEquipo m;
                    m = gestorEquipos.buscarElMayor();
                    System.out.println("El mas cara: " + m);
                    break;


                case 7:
                    List<AlquilerEquipo> ordenes = gestorEquipos.ordenarPorMayor();
                    for (AlquilerEquipo estado : ordenes) {
                        System.out.println(estado);
                    }
                    break;

                case 0:
                    System.out.println("Hasta pronto");
                    break;

                default:
                    System.out.println("Opcion no permitida");
                    break;
            }

        } while (opcion != 0);
    }
}