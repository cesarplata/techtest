package com.napptilus.techtest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napptilus.techtest.entity.PrecioEntity;
import com.napptilus.techtest.mapper.TechTestMapper;
import com.napptilus.techtest.model.Precio;
import com.napptilus.techtest.repository.PrecioRepository;

@Service(value = "precioService")
public class PrecioServiceImpl implements PrecioService {

	@Autowired
	private PrecioRepository precioRepository;

	@Autowired
	private TechTestMapper mapper;

	@Override
	public List<Precio> getPrecios(Precio precio) {
		Iterable<PrecioEntity> preciosEntityList = precioRepository.findFinalPrice(precio.getProductId(),
				precio.getBrandId(), precio.getAppDate());
		List<Precio> preciosList = new ArrayList<Precio>();
		for (PrecioEntity precioEntity : preciosEntityList) {
			preciosList.add(mapper.toPrecio(precioEntity));
		}

		return preciosList;
	}
	
	@Override
	public Precio getPrecio(Precio precio) {
		List<PrecioEntity> preciosEntityList = precioRepository.findFinalPrice(precio.getProductId(),
				precio.getBrandId(), precio.getAppDate());
		
		Precio precioReturn = new Precio(); 
		if(preciosEntityList.size() > 0) {
			precioReturn = mapper.toPrecio(preciosEntityList.get(0));
		}

		return precioReturn;
	}

}
