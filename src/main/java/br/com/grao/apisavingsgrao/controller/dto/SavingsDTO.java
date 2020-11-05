package br.com.grao.apisavingsgrao.controller.dto;

import java.math.BigDecimal;



public class SavingsDTO {

	private String name;
	private BigDecimal money;
	private Integer weeks;
	
	
	public SavingsDTO(String name, BigDecimal money, Integer weeks) {
		this.name = name;
		this.money = money;
		this.weeks = weeks;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	

	public Integer getWeeks() {
		return weeks;
	}


	public void setWeeks(Integer weeks) {
		this.weeks = weeks;
	}


	

}
