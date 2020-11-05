package br.com.grao.apisavingsgrao.controller.dto;

import java.math.BigDecimal;

public class SavingIncomeDTO {
	private String name;
	private BigDecimal value;
	private BigDecimal income;

	public SavingIncomeDTO(String name, BigDecimal value, BigDecimal income) {

		this.name = name;
		this.value = value;
		this.income = income;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public BigDecimal getIncome() {
		return income;
	}

	
}
