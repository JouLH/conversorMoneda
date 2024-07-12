import com.google.gson.Gson;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

// Making Request

        /*HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/4d2ca6c0f65eec20f1334d81/pair/USD/MXN/2")).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String json = response.body();
        //System.out.printf(json);
        Gson gson  = new Gson();
        MonedaOmdb miMonedaOmdb = gson.fromJson(json, MonedaOmdb.class);
        Moneda miMoneda = new Moneda(miMonedaOmdb, 2.0);

        System.out.println("Resultado " + miMoneda);*/
        String menu =  """
                **************************************************************
                                                            
                Bienvenidos al conversor de Moneas de @JoelLH
                1) Dolar ==> Peso Mexicano
                2) Peso Mexicano ==> Dolar
                3) Dolar ==> Peso Argentino
                4) Peso Argentino ==> Dolar
                5) Dolar ==> Peso Colombiano
                6) Colombiano ==> Dolar
                7) Salir
                Elija una opcion valida
                **************************************************************
                """;
        int n = 0;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.printf(menu);

            n = teclado.nextInt();
            switch (n){
                case 1:
                    convertirMoneda("USD", "MXN");
                    break;
                case 2:
                    convertirMoneda("MXN", "USD");
                    break;
                case 3:
                    convertirMoneda("USD", "ARS");
                    break;
                case 4:
                    convertirMoneda("ARS", "USD");
                    break;
                case 5:
                    convertirMoneda("USD", "COP");
                    break;
                case 6:
                    convertirMoneda("COP", "USD");
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        }while (n != 7);

        teclado.close();


    }

    public static void convertirMoneda(String base_code, String target_code) throws IOException, InterruptedException {
        Scanner t = new Scanner(System.in);
        System.out.println("Ingrese el valor que desea convertir: ");
        Double cantidad = t.nextDouble();

        HttpClient client = HttpClient.newHttpClient();
        String url = "https://v6.exchangerate-api.com/v6/4d2ca6c0f65eec20f1334d81/pair/"+base_code+"/"+target_code+"/"+cantidad;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String json = response.body();
        //System.out.printf(json);
        Gson gson  = new Gson();
        MonedaOmdb miMonedaOmdb = gson.fromJson(json, MonedaOmdb.class);
        Moneda miMoneda = new Moneda(miMonedaOmdb, cantidad);
        System.out.println(miMoneda);
    }

}