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


	@DisplayName("Testing several mul")
	@ParameterizedTest(name = "{0} * {1} = {2}")
	@CsvSource({
			"0,    1,   0",
			"1,    2,   2",
			"49,  51, 2499",
			"1,  100, 100"
	})
	void severalMul(Long first, Long second, Long expectedResult) {
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
	void severalSubs(Long first, Long second, Long expectedResult) {
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
	void severalDiv(Long first, Long second, Long expectedResult) {
		assertEquals(expectedResult, basicCalculator.div(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@DisplayName("Testing for exception zero division")
	@ParameterizedTest(name = "{0} / {1}")
	@CsvSource({"1,0", "0,0"})
	void zeroDivision(Long first, Long second) {
		assertThrows(IllegalArgumentException.class, () -> {
			basicCalculator.div(first, second);
		});
	}

}


