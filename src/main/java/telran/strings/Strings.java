package telran.strings;

import java.util.Arrays;

public class Strings {
    static final String keyWords[] = { "abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while" };

    public static String firstname() {
        // regex for strings starting with capital letter and rest as lowercase letters
        // mininal lenghth is 5 letters
        return "[A-Z][a-z]*{4,}";
    }

    public static String javaVariable() {
        // TODO
        // regular expression for testing syntax of Java veriable names
        // only ACII symbols allowed
        // return "[a-z_$A-Z][a-zA-Z0-9$_]+|[a-z$A-Z]";
        return "(?!_$)[a-zA-Z$_][\\w$]*";
    }

    public static String number0_300() {

        return "[1-9]\\d?|[1-2]\\d\\d|300|0";
    }

    public static String ipV4Octet() {

        return "([0-1]?\\d{1,2}|2([0-4]\\d|5[0-5]))";
    }

    public static String ipV4Address() {
        String octetExpr = ipV4Octet();
        return String.format("%s(\\.%s){3}", octetExpr, octetExpr);
    }

    public static String stringWithJavaNames(String names) {
        String[] tokens = names.split("\\s+");
        int i = getJavaNameIndex(tokens, -1);
        String res = "";
        if (i >= 0) {
            res = tokens[i];
        }
        while ((i = getJavaNameIndex(tokens, i)) > 0) {
            res += " " + tokens[i];
        }
        return res;
    }

    private static int getJavaNameIndex(String[] tokens, int i) {
        i++;
        while (i < tokens.length && !isJavaName(tokens[i])) {
            i++;
        }
        return i < tokens.length ? i : -1;
    }

    private static boolean isJavaName(String string) {
        return string.matches(javaVariable()) && Arrays.binarySearch(keyWords, string) < 0;
    }

    public static boolean isArithmeticExpression(String expr) {
        // "((name+b)/2)"
        // 7+ 4 *10
        // 8+4/10
        // (3+ name) * ( (8variant1 - ser * 3) +(56 - bar6)) / (67 - 58)
        // jlby dff kjkj kjkjk
        // (
        // (
        // name
        // +
        boolean result = true;

        if (!isValidBrackets(expr)) {
            result = false;
        }

        String[] tokens = expr.split("[\\+\\-\\*\\/]");
        for (int i = 0; i < tokens.length; i++) {
             if(tokens[i].matches("[\\)].*.*([0-9A-Za-z])*||.*([0-9A-Za-z])[\\(]*")) {
               result = false;
            }
            if (!isJavaName(tokens[i].replaceAll("[\\s+\\(\\)]", ""))
                    && !tokens[i].replaceAll("[\\s+\\(\\)]", "").matches("\\d+")) {
                result = false;
            }
        }
        return result;
    }

    public static boolean isValidBrackets (String getExpression) {
        int counter = 0;
        char[] charArray = getExpression.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
            counter++;
            } 
            if(charArray[i] == ')') {
                counter--;
            }
        }
        return counter == 0;
    } 
}