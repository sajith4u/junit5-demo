package io.arimac.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;
import static org.junit.jupiter.api.condition.OS.LINUX;

class CalculatorTest {


    @Test
    @DisplayName("Check Assertion Display Name")
    void testSimpleAssertion() {
        assertEquals(1, 1);
    }


    @Test
    @Disabled("Not implemented yet")
    void testDisabledLogic() {
        assertEquals(1, 2);
    }

    @Test
    void testExceptions() {
        final BMICalculatorService bmiCalculatorService = new BMICalculatorService();
        assertThrows(IllegalArgumentException.class, () -> {
            bmiCalculatorService.calculateBMI(0, 0);
        });
    }


    @Test
    @DisplayName("Junit 4 Way To Run Multiple Tests")
    void testOldList() {

        final BMICalculatorService bmiCalculatorService = new BMICalculatorService();

        float bmi1 = bmiCalculatorService.calculateBMI(55, 161);
        float bmi2 = bmiCalculatorService.calculateBMI(75, 161);
        float bmi3 = bmiCalculatorService.calculateBMI(65, 135);

        assertEquals(UserCategory.NORMAL, bmiCalculatorService.getUserCategory(bmi1));
        assertEquals(UserCategory.UNDER_WEIGHT, bmiCalculatorService.getUserCategory(bmi2));
        assertEquals(UserCategory.OBESE, bmiCalculatorService.getUserCategory(bmi3));
    }

    @Test
    @DisplayName("BMI Calculator")
    void testMBICalculator() {

        final BMICalculatorService bmiCalculatorService = new BMICalculatorService();
        final float bmi1 = bmiCalculatorService.calculateBMI(55, 161);
        float bmi2 = bmiCalculatorService.calculateBMI(75, 161);

        Assertions.assertAll(() -> assertEquals(UserCategory.NORMAL, bmiCalculatorService.getUserCategory(bmi1)),
                () -> assertEquals(UserCategory.NORMAL, bmiCalculatorService.getUserCategory(bmi2)),
                () -> assertEquals(UserCategory.OVER_WEIGHT, bmiCalculatorService.getUserCategory(bmi2)));
    }


    @Test
    @DisplayName("Test Assumptions")
    void testAssumptions() {

        final BMICalculatorService bmiCalculatorService = new BMICalculatorService();
        float bmi2 = bmiCalculatorService.calculateBMI(75, 161);

        assumeTrue(bmi2 > 100);

        assertEquals(UserCategory.OVER_WEIGHT, bmiCalculatorService.getUserCategory(bmi2));
    }


    @Test
    @DisplayName("Run On OS Level")
    @EnabledOnOs({LINUX})
    @EnabledOnJre(JAVA_9)
    void testRunOnOsLevel() {

        assertEquals(1, 1);
    }


    @Test
    @DisplayName("Run On Enviroment Variable")
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "STAGE")
    void testEnvironmentVariables() {

        assertEquals(1, 1);
    }


    @Test
    @EnabledIf("isTestingEnabled") // Read Property file & run tests OR only run for java 1.8 Upwards
    /*@EnabledIf(
            expression = "${tests.enabled}",
            loadContext = true)*/
    @DisplayName("Run On Custom Condition")
    void testCustomConditions() {

        assertEquals(1, 1);
    }


    boolean isTestingEnabled() {
        return false;
    }

}
