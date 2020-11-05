package br.com.grao.apisavingsgrao.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;
import ch.obermuhlner.math.big.BigDecimalMath;


import br.com.grao.apisavingsgrao.controller.dto.SavingIncomeDTO;
import br.com.grao.apisavingsgrao.controller.dto.SavingsDTO;


@Service
public class ServiceSavingsImpl implements ServiceSavings {

	@Override
	public SavingIncomeDTO savesXIncome(SavingsDTO savings) {
		
		if(savings.getMoney().compareTo(BigDecimal.ZERO) <= 0) {
			throw new ArithmeticException("Valor de investimento deve ser maior que 0!");
		}
		
		BigDecimal anualPercent = new BigDecimal("104.25").divide(new BigDecimal(100));
		
		Integer usefulDays = savings.getWeeks()*5;
		
		BigDecimal insvestimentPeriod = new BigDecimal(usefulDays).divide(new BigDecimal(252), 100, RoundingMode.UP);
		
		BigDecimal periodPercentual = BigDecimalMath.pow(anualPercent, insvestimentPeriod, new MathContext(100));
		
		BigDecimal income = savings.getMoney().multiply(periodPercentual).setScale(2, RoundingMode.UP);
		
		return new SavingIncomeDTO(savings.getName(), savings.getMoney(), income);
		
	}

}
