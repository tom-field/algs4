package chapter1.section1exercise;

public class Exercise8 {

    public static void main(String[] args) {
        System.out.println('b');
        System.out.println('b' + 'c');
        // 输出的竟然是197
        System.out.println((char) ('a' + 4));
        // 打印出char对应的ASCII码
        int ascii = '!';
        System.out.println(ascii);
    }
}
