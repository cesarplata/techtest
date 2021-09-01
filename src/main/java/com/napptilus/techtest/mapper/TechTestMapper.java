package com.napptilus.techtest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.napptilus.techtest.entity.PrecioEntity;
import com.napptilus.techtest.model.Precio;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TechTestMapper {

	public Precio toPrecio(PrecioEntity precioEntity);
	
}