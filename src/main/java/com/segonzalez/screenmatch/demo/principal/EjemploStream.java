package com.segonzalez.screenmatch.demo.principal;

import java.util.Arrays;
import java.util.List;


public class EjemploStream {
    public void mostrar_ejemplo(){
        List<String> nombres = Arrays.asList( "Brenda","Luis","Maria Fernanda", "Eric", "Genesys" );
        int maxSize;
        nombres.stream().sorted().limit( maxSize = 4).filter(n->n.startsWith("L")).map(n -> n.toUpperCase()).forEach(System.out::println);
    }
}
