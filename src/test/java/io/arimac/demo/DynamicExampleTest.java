package io.arimac.demo;

import io.arimac.demo.dynamic.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static io.arimac.demo.UserCategory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DynamicExampleTest {


    @Test
    @DisplayName("Simple Dynamic Test")
    @TestFactory
    Stream<DynamicTest> testDynamicLogic() {

        BMICalculatorService bmiCalculatorService = new BMICalculatorService();

        List<Employee> employeeList = Arrays.asList(
                Employee.builder().height(165).weight(55).name("Saman").build(),
                Employee.builder().height(175).weight(25).name("Nimal").build(),
                Employee.builder().height(155).weight(45).name("Kokila").build(),
                Employee.builder().height(135).weight(85).name("Kasun").build()
        );

        List<UserCategory> userConditions = Arrays.asList(NORMAL, NORMAL, NORMAL, OBESE);

        Stream<DynamicTest> employeeTestResult = employeeList.stream()
                .map(emp -> DynamicTest.dynamicTest(
                        "Test Employee :  " + emp.getName(),
                        () -> {
                            int index = employeeList.indexOf(emp);

                            float bmiValue = bmiCalculatorService.calculateBMI(emp.getWeight(), emp.getHeight());

                            assertEquals(userConditions.get(index), bmiCalculatorService.getUserCategory(bmiValue));
                        }
                ));

        return employeeTestResult;
    }


    @Test
    @DisplayName("Complex Dynamic Test")
    @TestFactory
    Stream<DynamicTest> testCombinedDynamicTest() {

        BMICalculatorService bmiCalculatorService = new BMICalculatorService();

        List<Employee> employeeList = Arrays.asList(
                Employee.builder().height(165).weight(55).name("Zam").age(25).build(),
                Employee.builder().height(175).weight(25).name("Don").age(45).build(),
                Employee.builder().height(155).weight(45).name("Philips").age(12).build(),
                Employee.builder().height(135).weight(85).name("Jhon").age(75).build()
        );


        List<Employee> testDataSet2 = Arrays.asList(
                Employee.builder().height(145).weight(52).name("Kim").age(25).build(),
                Employee.builder().height(162).weight(60).name("Kholi").age(45).build(),
                Employee.builder().height(157).weight(55).name("Root").age(12).build(),
                Employee.builder().height(170).weight(90).name("Vince").age(75).build(),
                Employee.builder().height(163).weight(45).name("Jofra").age(75).build()
        );

        List<UserCategory> userConditions = Arrays.asList(NORMAL, UNDER_WEIGHT, NORMAL, OBESE);

        List<UserCategory> testConditions2 = Arrays.asList(NORMAL, NORMAL, NORMAL, OBESE, UNDER_WEIGHT);

        Stream<DynamicTest> employeeTestResult = employeeList.stream()
                .filter(age -> age.getAge() > 20)
                .map(emp -> DynamicTest.dynamicTest(
                        "Set One Employee :  " + emp.getName(),
                        () -> {
                            int index = employeeList.indexOf(emp);

                            float bmiValue = bmiCalculatorService.calculateBMI(emp.getWeight(), emp.getHeight());

                            assertEquals(userConditions.get(index), bmiCalculatorService.getUserCategory(bmiValue));
                        }
                ));


        Stream<DynamicTest> testResults2 = testDataSet2.stream()
                .map(emp -> DynamicTest.dynamicTest(
                        "Set Two Employee :  " + emp.getName(),
                        () -> {
                            int index = testDataSet2.indexOf(emp);

                            float bmiValue = bmiCalculatorService.calculateBMI(emp.getWeight(), emp.getHeight());

                            assertEquals(testConditions2.get(index), bmiCalculatorService.getUserCategory(bmiValue));
                        }
                ));

        return Stream.concat(employeeTestResult, testResults2);
    }
}
