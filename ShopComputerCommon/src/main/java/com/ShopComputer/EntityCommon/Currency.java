package com.ShopComputer.EntityCommon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false , length = 45)
	private String name;
	
	@Column(nullable = false , length = 3)
	private String symbol;
	
	
	@Column(nullable = false , length = 10)
	private String code;


	public Currency(String name, String symbol, String code) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.code = code;
	}


	public Currency() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return this.name+" - "+this.code+" - "+this.symbol;
	}
}
