package com.napptilus.techtest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.napptilus.techtest.model.Precio;
import com.napptilus.techtest.service.PrecioService;

@RestController
@RequestMapping("/api")
public class PrecioController {

	@Autowired
	private PrecioService precioService;

	@GetMapping("/Precios")
	public ResponseEntity<List<Precio>> getAllPrecios(@Valid @RequestBody Precio precio) {
		return new ResponseEntity<>(precioService.getPrecios(precio), HttpStatus.OK);
	}
	
	@GetMapping("/Precio")
	public ResponseEntity<Precio> getPrecio(@Valid @RequestBody Precio precio) {
		return new ResponseEntity<>(precioService.getPrecio(precio), HttpStatus.OK);
	}
}
