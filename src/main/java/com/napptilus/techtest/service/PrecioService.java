package com.napptilus.techtest.service;

import java.util.List;

import com.napptilus.techtest.model.Precio;

public interface PrecioService {
	List<Precio> getPrecios(Precio precio);
	
	Precio getPrecio(Precio precio);
}
