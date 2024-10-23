package com.segonzalez.screenmatch.demo;

import com.segonzalez.screenmatch.demo.model.DatosEpisodio;
import com.segonzalez.screenmatch.demo.model.DatosSerie;
import com.segonzalez.screenmatch.demo.model.DatosTemporadas;
import com.segonzalez.screenmatch.demo.principal.EjemploStream;
import com.segonzalez.screenmatch.demo.principal.Principal;
import com.segonzalez.screenmatch.demo.service.ConsumoApi;
import com.segonzalez.screenmatch.demo.service.ConvertirDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScrennmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrennmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal= new Principal();
		principal.muestraMenu();
		//EjemploStream ejemploStream = new EjemploStream();
		//ejemploStream.mostrar_ejemplo();
	}
}
