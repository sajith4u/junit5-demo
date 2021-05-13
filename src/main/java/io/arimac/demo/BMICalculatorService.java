package io.arimac.demo;

public class BMICalculatorService {

    /**
     * Calculate BMI
     *
     * @param weight in KG
     * @param height in CM
     * @return
     */
    public float calculateBMI(float weight, float height) {
        if (weight > 0 && height > 0) {
            return weight / ((height / 100) * (height / 100));
        } else {
            throw new IllegalArgumentException("Values shold Grated Than 0 ");
        }
    }


    /**
     * Get User Category
     *
     * @param bmi
     * @return
     */
    public UserCategory getUserCategory(float bmi) {
       // System.out.println("Check Category for " + bmi);
        if (bmi < 18.5) {
            return UserCategory.UNDER_WEIGHT;
        } else if (bmi < 25) {
            return UserCategory.NORMAL;
        } else if (bmi < 30) {
            return UserCategory.OVER_WEIGHT;
        } else {
            return UserCategory.OBESE;
        }
    }
}
