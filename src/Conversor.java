import java.util.InputMismatchException;
import java.util.Scanner;

public class Conversor {
    private Scanner lectura = new Scanner(System.in);
    private HistorialDeConversiones historial;
    private int opcion = 0;
    private String resultado;

    public Conversor(HistorialDeConversiones historial) {
        this.historial = historial;
    }

    public String getResultado() {
        return resultado;
    }

    public void seleccionaOpcion() throws InputMismatchException {
        String menuPrincipal = """
                ---------------------------------------------------
                Seleccione el tipo de moneda al que desea convertir
                  1 - USD >>> Peso mexicano
                  2 - Peso mexicano >>> USD
                  3 - USD >>> Peso argentino
                  4 - Peso argentino >>> USD
                  5 - USD >>> Peso colombiano
                  6 - Peso colombiano >>> USD
                  7 - USD >>> Real brasileño
                  8 - Real brasileño >>> USD
                  9 - REGRESAR AL MENÚ PRINCIPAL
                ---------------------------------------------------
                """;

        while (opcion != 9) {
            System.out.println(menuPrincipal);
            opcion = lectura.nextInt();
            if (opcion == 9) break;
            obtieneResultadoDeConversion();
            historial.agregaAlHistorial(getResultado());
        }
    }

    void obtieneResultadoDeConversion() throws InputMismatchException {
        double cantidad;

        System.out.println("Ingrese la cantidad que desea convertir.");
        cantidad = lectura.nextDouble();
        switch (opcion) {
            case 1:
                realizaConsulta("USD", "MXN", cantidad);
                break;
            case 2:
                realizaConsulta("MXN", "USD", cantidad);
                break;
            case 3:
                realizaConsulta("USD", "ARS", cantidad);
                break;
            case 4:
                realizaConsulta("ARS", "USD", cantidad);
                break;
            case 5:
                realizaConsulta("USD", "COP", cantidad);
                break;
            case 6:
                realizaConsulta("COP", "USD", cantidad);
                break;
            case 7:
                realizaConsulta("USD", "BRL", cantidad);
                break;
            case 8:
                realizaConsulta("BRL", "USD", cantidad);
                break;
            case 9: break;
        }
    }

    void realizaConsulta(String monedaActual, String monedaObjetivo, double cantidad) {
        ConsultaMoneda consulta = new ConsultaMoneda();
        Moneda moneda = consulta.realizaConversion(monedaActual, monedaObjetivo, cantidad);
        resultado = toStringConsulta(moneda, cantidad);
        System.out.printf(resultado + ". El tipo de cambio es $%.2f%n", moneda.conversion_rate());
    }

    String toStringConsulta(Moneda moneda, double cantidad) {
        String monedaActual = moneda.base_code();
        String monedaObjetivo = moneda.target_code();
        double resultado = moneda.conversion_result();

        return "$" + cantidad + " " + moneda.base_code() + " equivale a $" + moneda.conversion_result() +
                " " + moneda.target_code();
    }
}