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

        assertFalse(Pattern.matches(javaVariable(), "2varName"));
        assertFalse(Pattern.matches(javaVariable(), "VarName"));
        assertFalse(Pattern.matches(javaVariable(), "var Name"));
    }
}