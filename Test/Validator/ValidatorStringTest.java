package Validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorStringTest {
    private ValidatorString validatorString;

    private final static String UPPERCASE_LETTER_AT_THE_BEGINNING = "Ahcuk ujcsk";
    private final static String ONE_UPPERCASE_LETTER = "A";
    private final static String LOWERCASE_LETTER_AT_THE_BEGINNING = "aAcuk Ajcsk";
    private final static String EMPTY_STRING = "";
    private final static String NUMBER_AT_THE_BEGINNING = "2Ahcuk AjcsA";


    @Before
    public void setUp() throws Exception {
        validatorString = new ValidatorString();
    }

    @After
    public void tearDown() throws Exception {
        validatorString = null;
    }

    @Test
    public void validatorUppercaseLetterAtTheBeginning() {
        boolean actual = validatorString.validator(UPPERCASE_LETTER_AT_THE_BEGINNING);
        assertTrue(actual);
    }

    @Test
    public void validatorOneUppercaseLetter() {
        boolean actual = validatorString.validator(ONE_UPPERCASE_LETTER);
        assertTrue(actual);
    }

    @Test(expected = ValidationFailedException.class)
    public void validatorLowercaseLetterAtTheBeginning() {
        validatorString.validator(LOWERCASE_LETTER_AT_THE_BEGINNING);
    }

    @Test(expected = ValidationFailedException.class)
    public void validatorEmptyString() {
        validatorString.validator(EMPTY_STRING);
    }

    @Test(expected = ValidationFailedException.class)
    public void validatorNumberAtTheBeginning() {
        validatorString.validator(NUMBER_AT_THE_BEGINNING);
    }
}