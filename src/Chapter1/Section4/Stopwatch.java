package Chapter1.Section4;

public class Stopwatch {
    private final long start;
    public Stopwatch() {
        start = System.currentTimeMillis();
    }
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
