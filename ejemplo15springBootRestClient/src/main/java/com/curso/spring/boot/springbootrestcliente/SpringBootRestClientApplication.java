package com.curso.spring.boot.springbootrestcliente;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.curso.java.cliente.spring.boot.ClienteApplication;
import com.curso.java.spring.boot.model.entities.Multa;

@SpringBootApplication
public class SpringBootRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Multa[]> httpEntity = new HttpEntity<Multa[]>(headers);
		RestTemplate template = new RestTemplate();
		ResponseEntity<Multa[]> response = 
				template.exchange(
						"http://localhost:8080/multas", 
						HttpMethod.GET,
						httpEntity,
						Multa[].class);
		HttpStatus statusCode = response.getStatusCode();
		
		if(statusCode == HttpStatus.OK) {
			Multa[] multas = response.getBody();
			if(multas != null) {
				for(Multa multa : multas) {
					System.out.println("Matricula: "+multa.getMatricula());
					System.out.println("Categoría: "+multa.getCategoria());
					System.out.println("Cantidad: "+multa.getCantidad());
					System.out.println("------------------------------------------");
				}
			}
		}
	}

}
