import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda realizaConversion(String monedaAConvertir, String monedaObjetivo, double cantidad) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/API_key/pair/" +
                        monedaAConvertir + "/" + monedaObjetivo + "/" + cantidad);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Moneda no encontrada.");
        }
    }
}