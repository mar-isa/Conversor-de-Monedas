import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistorialDeConversiones {
    private List<String> listaDelHistorial = new ArrayList<>();

    public void agregaAlHistorial(String consulta) {
        String consultaConFecha = consulta + "\nConsulta realizada el: " + generaFecha() + "\n";
        listaDelHistorial.add(consultaConFecha);
    }

    public void muestraElHistorial() {
        if (!listaDelHistorial.isEmpty()) {
            for (String item : listaDelHistorial) {
                System.out.println(item);
            }
        }
        else {
            System.out.println("Historial vacío, aún no se han realizado conversiones.");
        }
    }

    String generaFecha() {
        Date fecha = new Date();
        String formatoFecha = "dd-MM-yyyy kk:mm:ss";
        SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);

        return formato.format(fecha);
    }
}