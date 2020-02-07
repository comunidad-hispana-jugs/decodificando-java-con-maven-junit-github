package org.medellin.app.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicCalculator {

	final Logger logger = LoggerFactory.getLogger( BasicCalculator.class );

	public Long sum(Long number1, Long number2) {
		logger.info( "Summing {} + {}", number1, number2 );
		return number1 + number2;
	}

	public Long div(Long number1, Long number2) {
		logger.info( "Div {} + {}", number1, number2 );
		if(number2 == 0){
			throw new IllegalArgumentException("Div by zero cannot be done");
		}
		return number1 / number2;
	}

	public Long subs(Long number1, Long number2) {
		logger.info( "Substract {} + {}", number1, number2 );
		return number1 - number2;
	}

	public Long mul(Long number1, Long number2) {
		logger.info( "Multiply {} + {}", number1, number2 );
		return number1 * number2;
	}
}
