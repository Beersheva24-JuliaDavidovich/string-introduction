package telran.strings;

public class Strings {
    public static String firstname() {
        //regex for strings starting with capital letter and rest as lowercase letters
        //mininal lenghth is 5 letters
        return "[A-Z][a-z]*{4,}";
    }
    public static String javaVariable() {
        //TODO
        //regular expression for testing syntax of Java veriable names
        //only ACII symbols allowed
        return "[a-z][a-zA-Z0-9_$]*";
    }
}
