package org.medellin.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {

	private final BasicCalculator basicCalculator = new BasicCalculator();

	@Test
	@DisplayName("Testing sum: 1+1=2")
	public void sum() {
		// Arrange
		Long number1 = 1L;
		Long number2 = 1L;
		Long expectedValue = 2L;

		// Act
		Long result = basicCalculator.sum(number1, number2);

		// Assert
		assertEquals(expectedValue, result);
	}

	@Test
	@DisplayName("Testing wrong sum: 1+1<>0")
	public void wrongSum() {
		// Arrange
		Long number1 = 1L;
		Long number2 = 1L;
		Long unexpectedValue = 0L;

		// Act
		Long result = basicCalculator.sum(number1, number2);

		// Assert
		assertNotEquals( unexpectedValue, result);
	}

	@DisplayName("Testing several sums")
	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	public void severalSums(Long first, Long second, Long expectedResult) {
		assertEquals(expectedResult, basicCalculator.sum(first, second),
					 () -> first + " + " + second + " should equal " + expectedResult);
	}

	@DisplayName("Testing several mul")
	@ParameterizedTest(name = "{0} * {1} = {2}")
	@CsvSource({
			"0,    1,   0",
			"1,    2,   2",
			"49,  51, 2499",
			"1,  100, 100"
	})
	public void severalMul(Long first, Long second, Long expectedResult) {
		assertEquals(expectedResult, basicCalculator.mul(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@DisplayName("Testing several subs")
	@ParameterizedTest(name = "{0} - {1} = {2}")
	@CsvSource({
			"10,    1,   9",
			"2,    12,  -10",
			"49,  51, -2",
			"0,  0, 0"
	})
	public void severalSubs(Long first, Long second, Long expectedResult) {
		assertEquals(expectedResult, basicCalculator.subs(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@DisplayName("Testing several div")
	@ParameterizedTest(name = "{0} / {1} = {2}")
	@CsvSource({
			"0,    1,   0",
			"1,    2,   0",
			"49,  51, 0",
			"51,  4, 12",
			"9,  3, 3"

	})
	public void severalDiv(Long first, Long second, Long expectedResult) {
		assertEquals(expectedResult, basicCalculator.div(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@DisplayName("Testing for exception zero division")
	@ParameterizedTest(name = "{0} / {1}")
	@CsvSource({"1,0", "0,0"})
	public void zeroDivision(Long first, Long second) {
		assertThrows(IllegalArgumentException.class, () -> {
			basicCalculator.div(first, second);
		});
	}

}
