package Validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorIntegerTest {
    private ValidatorInteger validatorInteger;

    private final static Integer ZERO = 0;
    private final static Integer ONE = 1;
    private final static Integer TEN = 10;
    private final static Integer MINUS_FIVE = -5;
    private final static Integer ELEVEN = 11;

    @Before
    public void setUp() throws Exception {
        validatorInteger = new ValidatorInteger();
    }

    @After
    public void tearDown() throws Exception {
        validatorInteger = null;
    }

    @Test
    public void validatorPositiveOne() {
        boolean actual = validatorInteger.validator(ONE);
        assertTrue(actual);
    }

    @Test
    public void validatorPositiveTen() {
        boolean actual = validatorInteger.validator(TEN);
        assertTrue(actual);
    }

    @Test(expected = ValidationFailedException.class)
    public void validatorZERO() {
        validatorInteger.validator(ZERO);
    }

    @Test(expected = ValidationFailedException.class)
    public void validatorPositiveEleven() {
        validatorInteger.validator(ELEVEN);
    }

    @Test(expected = ValidationFailedException.class)
    public void validatorNegativeFive() {
        validatorInteger.validator(MINUS_FIVE);
    }
}