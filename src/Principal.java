import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private static HistorialDeConversiones historial = new HistorialDeConversiones();

    public static void main(String[] args) {
        Conversor conversor = new Conversor(historial);
        Scanner lectura = new Scanner(System.in);
        int opcion = 0;
        String menuPrincipal = """
                **********************************************************
                Bienvenido al conversor de monedas. Seleccione una opción:
                  1 - Usar el conversor de monedas
                  2 - Ver historial de las conversiones
                  3 - Salir del programa
                **********************************************************
                """;

        while (opcion != 3) {
            System.out.println(menuPrincipal);
            try {
                opcion = lectura.nextInt();

                switch (opcion) {
                    case 1:
                        conversor.seleccionaOpcion();
                        break;
                    case 2:
                        historial.muestraElHistorial();
                        break;
                    case 3: break;
                    default:
                        System.out.println("Opción no encontrada.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n¡LA ENTRADA DEBE SER UN NÚMERO VÁLIDO!");
                break;
            }
        }

        System.out.println("Saliendo del conversor y finalizando el programa.");
    }
}