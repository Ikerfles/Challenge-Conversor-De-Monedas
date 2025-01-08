import java.util.Scanner;

public class Menu {
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        String entrada = "";
        String menu = """
                1.- MXN (Peso mexicano)
                2.- USD (Dólar estadounidense)
                3.- ARS (Peso argentino)
                4.- BOB (Boliviano boliviano)
                5.- BRL (Real brasileño)
                6.- CLP (Peso chileno)
                7.- COP (Peso colombiano)
                """;

        System.out.println("Ingrese su clave API:");
        String claveAPI = scanner.nextLine();
        System.out.println("Divisa local:");
        System.out.println(menu);
        int monedaLocal = Integer.parseInt(scanner.nextLine());

        while (!entrada.equalsIgnoreCase("salir")){

            System.out.println("Elija la moneda a la que desea convertir:");
            System.out.println(menu);
            int monedaConvertida = Integer.parseInt(scanner.nextLine());

            System.out.println("Escriba la cantidad a convertir:");
            int cantidad = Integer.parseInt(scanner.nextLine());

            String opcionMonedaLocal = obtenerOpcionMoneda(monedaLocal);
            String opcionMoedaConvertida = obtenerOpcionMoneda(monedaConvertida);

            Divisas divisas = new Divisas(opcionMonedaLocal, opcionMoedaConvertida, cantidad);

            Resultado resultado = new Resultado(claveAPI);
            resultado.darResultado(divisas);

            System.out.println("¿Desea realizar otra conversión?");
            System.out.println("Escriba 'salir' para terminar el programa o presione Enter para continuar: ");
            entrada = scanner.nextLine();
        }
    }

    private String obtenerOpcionMoneda(int opcion) {
        return switch (opcion) {
            case 1 -> "MXN";
            case 2 -> "USD";
            case 3 -> "ARS";
            case 4 -> "BOB";
            case 5 -> "BRL";
            case 6 -> "CLP";
            case 7 -> "COP";
            default -> null;
        };
    }
}