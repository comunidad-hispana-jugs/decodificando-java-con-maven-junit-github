package org.medellin.app.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorClient {
	private static final  Logger logger = LoggerFactory.getLogger( CalculatorClient.class );

	public static void main(String[] args) throws IOException {
		logger.info( "Starting calculator console client" );
		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );

		System.out.println( "Enter number 1: " );
		String textNumber1 = bufferedReader.readLine();
		validateNumber( textNumber1 );

		System.out.println( "Enter number 2: " );
		String textNumber2 = bufferedReader.readLine();
		validateNumber( textNumber2 );

		System.out.println( "Operation (+, -, *, /): " );
		String operation = bufferedReader.readLine();

		Long number1 =Long.valueOf( textNumber1 );
		Long number2 = Long.valueOf( textNumber2 );

		BasicCalculator calculator = new BasicCalculator();

		Long result;
		switch (operation){
			case "+": {
				result = calculator.sum( number1, number2 );
				break;
			}
			case "*": {
				result = calculator.mul( number1, number2 );
				break;
			}
			case "-": {
				result = calculator.subs( number1, number2 );
				break;
			}
			case "/": {
				result = calculator.div( number1, number2 );
				break;
			}

			default: throw new IllegalArgumentException("operation " + operation + " doesn't exist");
		}

		System.out.println( number1 + " " + operation + " " + number2 + " = " +  result);
		logger.info( "Closing calculator console client" );

	}

	public static void validateNumber(String textNumber) {
		try {
			Long.valueOf( textNumber );
		}catch (NumberFormatException e) {
			System.err.println( textNumber + " is not a valid Number.");
			//logger.error( "{} is not a valid Number.", textNumber);
			System.exit( 1 );
		}
	}
}
