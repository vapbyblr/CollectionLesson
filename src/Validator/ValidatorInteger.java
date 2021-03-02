package Validator;

public class ValidatorInteger implements Validator<Integer>{

    @Override
    public void validator(Integer integer) {
        System.out.println("use Integer");
    }

}
