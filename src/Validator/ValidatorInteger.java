package Validator;

public class ValidatorInteger implements Validator<Integer>{

    @Override
    public boolean validator(Integer integer) {
        if (integer > 0 & integer < 11){
            return true;
        } else throw new ValidationFailedException("data does not match format");
    }

}
