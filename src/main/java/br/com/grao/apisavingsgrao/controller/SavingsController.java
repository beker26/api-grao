package br.com.grao.apisavingsgrao.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grao.apisavingsgrao.controller.dto.SavingIncomeDTO;
import br.com.grao.apisavingsgrao.controller.dto.SavingsDTO;
import br.com.grao.apisavingsgrao.service.ServiceSavings;

@RestController
@RequestMapping("/savings")
public class SavingsController implements SavingsControllerApi {
	
	private ServiceSavings savingsService;
	
	public SavingsController(ServiceSavings savingsService) {
		this.savingsService = savingsService;
	}
	
	@Override
	public SavingIncomeDTO incomeCalculated(SavingsDTO savings) {
		return savingsService.savesXIncome(savings);
	}

}
