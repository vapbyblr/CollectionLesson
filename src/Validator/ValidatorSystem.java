package Validator;

import java.util.HashMap;
import java.util.Map;

public class ValidatorSystem <T>{

    private Map createMapValidator(){
        Map<Object,Validator> map = new HashMap<>();
        map.put("string", new ValidatorString());
        map.put(123, new ValidatorInteger());
        map.put(new CustomClass(), new ValidatorCustomClass());
        return map;
    }

    public void validate(T t){
        if(t == null) throw new NullPointerException();
        Map<Object,Validator> map = createMapValidator();
        for (Object o : map.keySet()){
            if(o.getClass()==t.getClass()){
                map.get(o).validator(t);
            } else throw new RuntimeException(" unknown Object type ");
        }
    }

}
