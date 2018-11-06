package com.cielo.desafio.controller;
import java.io.File;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cielo.desafio.model.entity.Extrato;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
class ExtratoContaController {

    public ExtratoContaController() {
    }
    // Controlador aonde se chama o arquivo json
    @GetMapping("/api/extratoContaCorrente")
    public Extrato extrato() {
    	
    	ObjectMapper mapper = new ObjectMapper();
    	Extrato extrato = new Extrato();
		try {
			
			//Mapea o json para a classe extrato
			File file =new ClassPathResource(
				      "lancamento-conta-legado.json").getFile();
			extrato = mapper.readValue(file, Extrato.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return extrato;
    }

}