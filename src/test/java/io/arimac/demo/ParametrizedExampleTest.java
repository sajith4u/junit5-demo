package io.arimac.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Parametrized Test Samples")
class ParametrizedExampleTest {


    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    @DisplayName("Parameter Values Input")
    void testSimpleParamaterlizeTest(int x) {
        System.out.println(x);
        assertTrue((x % 2 == 0));
    }


    @ParameterizedTest
    @NullSource
    @DisplayName("Null Input Test")
    void testNullAndEmpty(String input) {
        assertNull(input);
    }


    @ParameterizedTest
    @EmptySource
    @DisplayName("Empty Input")
    void testEmpty(String input) {
        assertTrue(input.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("phoneNumbers")
    @DisplayName("Method Source Test")
    void testMethodSource(String phoneNumber) {
        assertNotNull(phoneNumber);
    }


    @ParameterizedTest
    @DisplayName("Enum Input")
    @EnumSource(UserCategory.class)
    void testEnums(UserCategory userCategory) {
        //  Run In Every User Category
        assertNotNull(userCategory);
    }

    @DisplayName("CSV Value Test")
    @ParameterizedTest(name = "{index} {0} Student GPA Test")
    @CsvSource({"Jhon", "Kilal", "Max"})
    void testCsvValues(String input) {
        //  Run In Every User Category
        assertNotNull(input);
    }


    @DisplayName("CSV Value Test")
    @ParameterizedTest(name = "{index} {0} Student GPA Test")
    @CsvSource({"Jhon", "Kilal", "Max"})
    void testCsvAdvancedValues(String input) {
        //  Run In Every User Category
        assertNotNull(input);
    }


    @DisplayName("CSV File Test")
    @ParameterizedTest(name = "{index}  Height : {0}, weight: {1} Check BMI")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testCsvFiles(float height, float weight, UserCategory expected) {

        final BMICalculatorService bmiCalculatorService = new BMICalculatorService();
        float bmi = bmiCalculatorService.calculateBMI(weight, height);
        assertEquals(expected, bmiCalculatorService.getUserCategory(bmi));
    }


    private static List<String> phoneNumbers() {
        return Arrays.asList("1234567", "1112227", "3334445");
    }

}
