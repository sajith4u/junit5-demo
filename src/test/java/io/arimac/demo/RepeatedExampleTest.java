package io.arimac.demo;

import io.arimac.demo.repeated.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Repeated Test")
public class RepeatedExampleTest {

    @RepeatedTest(value = 5, name = "Repeat Test {currentRepetition} Out Of  {totalRepetitions}")
    @DisplayName("Run Test")
    void testEnvironmentVariables() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        assertTrue(randomNumberGenerator.getRandomNumber() < 10);
    }
}
