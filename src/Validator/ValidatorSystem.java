package Validator;

import java.util.HashMap;
import java.util.Map;

public class ValidatorSystem {

    private Map createMapValidator(){
        Map<Class,Validator> map = new HashMap<>();
        map.put(String.class, new ValidatorString());
        map.put(Integer.class, new ValidatorInteger());
        return map;
    }

    public <T> boolean validate(T t){
        Map<Class,Validator> map = createMapValidator();
        if(!map.containsKey(t.getClass())) return false;
        return map.get(t.getClass()).validator(t);
    }
}
