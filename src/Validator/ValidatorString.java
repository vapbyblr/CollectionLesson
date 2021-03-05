package Validator;

public class ValidatorString implements Validator<String>{

    @Override
    public boolean validator(String str){
        if(str.matches("^[A-Z]+.*")){
            return true;
        } else throw new ValidationFailedException("data does not match format");
    }
}
