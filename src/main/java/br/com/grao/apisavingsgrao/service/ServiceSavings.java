package br.com.grao.apisavingsgrao.service;

import br.com.grao.apisavingsgrao.controller.dto.SavingIncomeDTO;
import br.com.grao.apisavingsgrao.controller.dto.SavingsDTO;


public interface ServiceSavings {

	  
	SavingIncomeDTO savesXIncome(SavingsDTO savings);
}
