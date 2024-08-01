package telran.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    @Test
    void number0_300TrueTest() {
        String regex = Strings.number0_300();
        assertTrue("0".matches(regex));
        assertTrue("300".matches(regex));
        assertTrue("250".matches(regex));
        assertTrue("25".matches(regex));
        assertTrue("12".matches(regex));
        assertTrue("299".matches(regex));
        assertTrue("199".matches(regex));
        assertTrue("1".matches(regex));
    }
    @Test
    void number0_300FalseTest() {
        String regex = Strings.number0_300();
        assertFalse("00".matches(regex));
        assertFalse("301".matches(regex));
        assertFalse("01".matches(regex));
        assertFalse("000".matches(regex));
        assertFalse("1(".matches(regex));
        assertFalse("1000".matches(regex));
        assertFalse(" 20".matches(regex));
        assertFalse("1001".matches(regex));
    }
    @Test
    void ipV4OctetTrueTest() {
        String regex = Strings.ipV4Octet();
        assertTrue("0".matches(regex));
        assertTrue("00".matches(regex));
        assertTrue("000".matches(regex));
        assertTrue("10".matches(regex));
        assertTrue("100".matches(regex));
        assertTrue("255".matches(regex));
        assertTrue("199".matches(regex));
        assertTrue("249".matches(regex));
    }
    @Test
    void ipV4OctetFalseTest() {
        String regex = Strings.ipV4Octet();
        assertFalse("0000".matches(regex));
        assertFalse("t".matches(regex));
        assertFalse("-1".matches(regex));
        assertFalse("1111".matches(regex));
        assertFalse("0001".matches(regex));
        assertFalse("256".matches(regex));
        assertFalse("300".matches(regex));
        assertFalse("*".matches(regex));
        assertFalse("1 ".matches(regex));
    }
    @Test
    void ipV4AddressTrueTest() {
        String regex = Strings.ipV4Address();
        assertTrue("0.0.0.0".matches(regex));
        assertTrue("255.255.255.255".matches(regex));
    }
    @Test
    void ipV4AddressFalseTest() {
        String regex = Strings.ipV4Address();
        assertFalse("0.0.0".matches(regex));
        assertFalse("0.0.0+0".matches(regex));
        assertFalse("0.".matches(regex));
        assertFalse("0.0.0*0".matches(regex));
        assertFalse("0.0.0 0".matches(regex));
    }

    @Test
    void stringWithJavaNamesTest() {
        String names = "123 1a _ abs int enum null lmn";
        String expected = "abs lmn";
        assertEquals(expected,Strings.stringWithJavaNames(names));
    }

    @Test
    void isArithmeticExpressionTest() {
        assertTrue(isArithmeticExpression("(3+ name) * ( (variant1 - ser * 3) + (56 - bar6)) / (67 - 58)"));
        assertTrue(isArithmeticExpression("((a+b)/2)"));
        assertTrue(isArithmeticExpression("(a+b)/2"));
        assertTrue(isArithmeticExpression("(a*b)"));
        assertFalse(isArithmeticExpression("((a+b)/2"));
        assertFalse(isArithmeticExpression("(int + 10)"));
        assertFalse(isArithmeticExpression("(+a-10)"));
        assertTrue(isArithmeticExpression("var"));
        assertFalse(isArithmeticExpression("var-int"));
        assertFalse(isArithmeticExpression(")5 + 7("));
        assertFalse(isArithmeticExpression("4(v) + 5(g)"));
        assertFalse(isArithmeticExpression("(v)k + 5(3)"));
        
    }
}