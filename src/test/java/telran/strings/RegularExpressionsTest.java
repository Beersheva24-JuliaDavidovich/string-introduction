package telran.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import static telran.strings.Strings.*;

public class RegularExpressionsTest {

    @Test
    void javaVariableTest() {
        assertTrue(Pattern.matches(javaVariable(), "var_Name"));
        assertTrue(Pattern.matches(javaVariable(), "var12"));
        assertTrue(Pattern.matches(javaVariable(), "varName$$"));
        assertTrue(Pattern.matches(javaVariable(), "_varName"));
        assertTrue(Pattern.matches(javaVariable(), "$"));
        assertTrue(Pattern.matches(javaVariable(), "_a"));
        assertTrue(Pattern.matches(javaVariable(), "A"));

        assertFalse(Pattern.matches(javaVariable(), "2varName"));
        assertFalse(Pattern.matches(javaVariable(), "var Name"));
        assertFalse(Pattern.matches(javaVariable(), "1"));
        assertFalse(Pattern.matches(javaVariable(), "_"));
    }
}