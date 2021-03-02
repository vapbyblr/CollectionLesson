package Validator;

public class ValidatorCustomClass implements Validator<CustomClass>{

    @Override
    public void validator(CustomClass customClass) {
        System.out.println("use CustomClass");
    }
}
