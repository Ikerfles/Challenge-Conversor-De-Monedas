public class Divisas {
    private String monedaLocal;
    private String monedaConvertida;
    private int cantidad;

    public Divisas(String monedaLocal, String monedaConvertida, int cantidad) {
        this.monedaLocal = monedaLocal;
        this.monedaConvertida = monedaConvertida;
        this.cantidad = cantidad;
    }

    public String getMonedaLocal() {
        return monedaLocal;
    }

    public String getMonedaConvertida() {
        return monedaConvertida;
    }

    public int getCantidad() {
        return cantidad;
    }
}