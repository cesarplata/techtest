package com.napptilus.techtest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prices")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class PrecioEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "price_list")
	private Integer priceList;	

	@Column(name = "brand_id")
	private Integer brandId;
	
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "priority")
	private Integer priority;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "currency")
	private String curr;
	
	@Column(name = "last_update_by")
	private String LastUpdateBy;
	
	
}
