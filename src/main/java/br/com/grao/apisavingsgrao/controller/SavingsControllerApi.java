package br.com.grao.apisavingsgrao.controller;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grao.apisavingsgrao.controller.dto.SavingIncomeDTO;
import br.com.grao.apisavingsgrao.controller.dto.SavingsDTO;


@RestController
@RequestMapping("/savings")
public interface SavingsControllerApi  {

	@PostMapping
	public SavingIncomeDTO incomeCalculated(@RequestBody SavingsDTO savings);
	
}
