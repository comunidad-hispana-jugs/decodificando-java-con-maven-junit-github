package org.medellin.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class CalculatorTest {

	private final BasicCalculator basicCalculator = new BasicCalculator();

	@Test
	@DisplayName("Testing sum: 1+1=2")
	void sum() {
		assertEquals(2, basicCalculator.sum(1L, 1L));
	}

	@Test
	@DisplayName("Testing wrong sum: 1+1<>0")
	void wrongSum() {
		assertNotEquals( 0, basicCalculator.sum(1L, 1L));
	}

	@DisplayName("Testing several sums")
	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void severalSums(Long first, Long second, Long expectedResult) {
		assertEquals(expectedResult, basicCalculator.sum(first, second),
					 () -> first + " + " + second + " should equal " + expectedResult);
	}


	//TODO Testing reading values from a file (Not sure if that is possible)
}


