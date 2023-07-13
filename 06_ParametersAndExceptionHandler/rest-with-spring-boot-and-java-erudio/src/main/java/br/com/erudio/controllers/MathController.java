package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exception.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;


@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	
	private SimpleMath simpleMath = new SimpleMath();
	
	@RequestMapping(value = "/{operation}/{numberOne}/{numberTwo}", 
			method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "operation") String operation,
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		
		
		if(operation.equals("sum") || operation.equals("sub") || 
				operation.equals("multi") || operation.equals("div") || 
				operation.equals("media")) {} 
		else {
			throw new UnsupportedMathOperationException("Error in path");
		}
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {			
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		if(operation.equals("sum")) return simpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		if(operation.equals("sub")) return simpleMath.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		if(operation.equals("multi")) return simpleMath.multi( NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		if(operation.equals("div")) return simpleMath.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		if(operation.equals("media")) return simpleMath.media(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) / 2;
		else return 0D;
		}
	
	@RequestMapping(value = "/squareRoot/{numberOne}", method = RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value = "numberOne") String numberOne) throws Exception {
		if(!NumberConverter.isNumeric(numberOne)) {			
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return simpleMath.squareRoot(NumberConverter.convertToDouble(numberOne)); 
		
	}
	
	

	
}