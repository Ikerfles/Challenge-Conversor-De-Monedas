import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    private final String claveAPI;

    public ConsultaAPI(String claveAPI) {
        this.claveAPI = claveAPI;
    }

    public double divisas(String monedaLocal, String monedaConvertida, int cantidad) {
        URI enlace = URI.create("https://v6.exchangerate-api.com/v6/" + claveAPI + "/pair/" +
                monedaLocal + "/" + monedaConvertida + "/" + cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(enlace).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            ConversorAPI conversorAPI = gson.fromJson(response.body(), ConversorAPI.class);//gson.fromJson(response.body(), ConversorAPI.class);

            return conversorAPI.getResultadoDeConversion();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al consultar la API.", e);
        }
    }
}