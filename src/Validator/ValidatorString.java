package Validator;

public class ValidatorString implements Validator<String>{

    @Override
    public void validator(String str){
        System.out.println("use String");
    }
}
