package org.medellin.app.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicCalculator {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasicCalculator.class);

	public Long sum(final Long number1, final Long number2) {
		LOGGER.info( "Summing {} + {}", number1, number2 );
		return number1 + number2;
	}

	public Long div(final Long number1, final Long number2) {
		LOGGER.info( "Div {} / {}", number1, number2 );
		if(number2 == 0){
			throw new IllegalArgumentException("Div by zero cannot be done");
		}
		return number1 / number2;
	}

	public Long subs(final Long number1, final Long number2) {
		LOGGER.info( "Substract {} - {}", number1, number2 );
		return number1 - number2;
	}

	public Long mul(final Long number1, final Long number2) {
		LOGGER.info( "Multiply {} * {}", number1, number2 );
		return number1 * number2;
	}
}
