package br.com.grao.apisavingsgrao.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


import br.com.grao.apisavingsgrao.controller.dto.SavingIncomeDTO;
import br.com.grao.apisavingsgrao.controller.dto.SavingsDTO;

public class ServiceSavingsImplTestTest {

	private ServiceSavings savingsService;
	
	@BeforeEach
	public void setUp() {
		this.savingsService = new ServiceSavingsImpl();
			
	
	}
	
	@Test
	@DisplayName("calculates the investment of 100 reais for 36 weeks")
	public void deveCalcularInvestimentoDeCemReais() {
		
		SavingsDTO savings = new SavingsDTO("João", new BigDecimal("100.00"), 36);
		SavingIncomeDTO income = savingsService.savesXIncome(savings);
		
		assertThat(income.getName(), equalTo(savings.getName()));
		assertThat(income.getValue(), equalTo(savings.getMoney()));
		assertThat(income.getIncome(), equalTo(new BigDecimal("103.02")));
	}
	
	@Test
	@DisplayName("Exception should be thrown for investments with a value of 0")
	public void naoDeveRealizarCalculoParaInvestimentoIgualAZero() {
		
		SavingsDTO savings = new SavingsDTO("João", new BigDecimal("0.00"), 36);
		
		RuntimeException exception = assertThrows(ArithmeticException.class,
				() -> savingsService.savesXIncome(savings));

		assertThat(exception.getMessage(), equalTo("Valor de investimento deve ser maior que 0!"));
	}
	
	@Test
	@DisplayName("Exceptions should be thrown for investments with a value less than 0")
	public void naoDeveRealizarCalculoParaInvestimentoMenorQueZero() {
		
		SavingsDTO savings = new SavingsDTO("João", new BigDecimal("-1.00"), 36);
		
		RuntimeException exception = assertThrows(ArithmeticException.class,
				() -> savingsService.savesXIncome(savings));

		assertThat(exception.getMessage(), equalTo("Valor de investimento deve ser maior que 0!"));
	}
	
}

