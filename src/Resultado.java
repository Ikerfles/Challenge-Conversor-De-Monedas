public class Resultado {
    private ConsultaAPI consultaAPI;

    public Resultado(String claveAPI) {
        this.consultaAPI = new ConsultaAPI(claveAPI);
    }

    public void darResultado(Divisas divisas) {
        double resultado = consultaAPI.divisas(
                divisas.getMonedaLocal(),
                divisas.getMonedaConvertida(),
                divisas.getCantidad()
        );

        System.out.println("Resultado: " + resultado + " " + divisas.getMonedaConvertida());
    }
}
