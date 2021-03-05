package Validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorSystemTest {
    ValidatorSystem validatorSystem;

    private final static String OBJECT_TYPE_STRING = "Test string";
    private final static Integer OBJECT_TYPE_INTEGER = 9;
    private final static Object OBJECT_TYPE_OBJECT = new Object();
    private final static Long OBJECT_TYPE_LONG = 9L;


    @Before
    public void setUp() throws Exception {
        validatorSystem = new ValidatorSystem();
    }

    @After
    public void tearDown() throws Exception {
        validatorSystem = null;
    }

    @Test
    public void validateStringType() {
        boolean actual = validatorSystem.validate(OBJECT_TYPE_STRING);
        assertTrue(actual);
    }

    @Test
    public void validateIntegerType() {
        boolean actual = validatorSystem.validate(OBJECT_TYPE_INTEGER);
        assertTrue(actual);
    }

    @Test
    public void validateObjectType() {
        boolean actual = validatorSystem.validate(OBJECT_TYPE_OBJECT);
        assertFalse(actual);
    }

    @Test
    public void validateLongType() {
        boolean actual = validatorSystem.validate(OBJECT_TYPE_LONG);
        assertFalse(actual);
    }
}