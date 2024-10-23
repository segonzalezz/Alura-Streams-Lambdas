package com.segonzalez.screenmatch.demo.principal;

import com.segonzalez.screenmatch.demo.model.DatosEpisodio;
import com.segonzalez.screenmatch.demo.model.DatosSerie;
import com.segonzalez.screenmatch.demo.model.DatosTemporadas;
import com.segonzalez.screenmatch.demo.service.ConsumoApi;
import com.segonzalez.screenmatch.demo.service.ConvertirDatos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY  = "&apikey=3b2dec2c";
    private ConvertirDatos convertirDatos = new ConvertirDatos();

    public void muestraMenu(){
        System.out.println("Por favor escribe el nombre de la serie que deseas buscar");
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE+nombreSerie.replace(" ","+")+API_KEY);
        var datos = convertirDatos.obtenerDatos_(json, DatosSerie.class);

        //Buscar los datos de todas las temporadas
        List<DatosTemporadas> temporadas  = new ArrayList<>();
        for (int i = 1; i < datos.totalDeTemporadas(); i++) {
            json =  consumoApi.obtenerDatos(URL_BASE+nombreSerie.replace(" ", "+")+"&Season="+i+API_KEY);
            var datosTemporada = convertirDatos.obtenerDatos_(json, DatosTemporadas.class);
            temporadas.add(datosTemporada);
        }

        //Mostrar solo el titulo de los episodios para las temporadas
        //for (int i = 0; i < datos.totalDeTemporadas() ; i++) {
          //  List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();
            //for (int j = 0; j < episodiosTemporadas.size() ; j++) {
              //  System.out.println(episodiosTemporadas.get(j).titulo());
            //}
        //}

        //temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<DatosEpisodio> datosEpisodios =  temporadas.stream().flatMap(t->t.episodios().stream()).collect(Collectors.toList());

        //Top 5 episodios
        System.out.println("Top 5 episodios");
        int maxSize;
        datosEpisodios.stream()
                .filter(e->!e.evaluacion().equalsIgnoreCase("N/A")).sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .limit(maxSize = 5)
                .forEach(System.out::println);

    }

}
