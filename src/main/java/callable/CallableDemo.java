package callable;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> f1 = es.submit(new Sum(10));
        Future<Double> f2 = es.submit(new Hypot(4, 5));
        Future<Integer> f3 = es.submit(new Factorial(5));

        System.out.println("Sum = " + f1.get());
        System.out.println("Sum = " + f2.get());
        System.out.println("Sum = " + f3.get());
    }
}
class Sum implements Callable<Integer> {

    int stop;

    public Sum(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }
}
class Hypot implements Callable<Double> {
    double side1, side2;

    public Hypot(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public Double call() throws Exception {
        return Math.sqrt((side1*side1) + (side2*side2));
    }
}
class Factorial implements Callable<Integer> {
    int number;
    int result = 1;

    public Factorial(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}