package chapter1.section2exercise;

// 回环变位
public class Exercise6 {

    public static void main(String[] args) {
        System.out.println(isCircularRotation("ACTGACG", "TGACGAC"));
        System.out.println(isCircularRotation("abc", "def"));
    }

    private static boolean isCircularRotation(String s, String t) {
        return s.length() == t.length() && (s + s).contains(t);
    }

}
