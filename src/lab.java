import java.util.Scanner;

/**
 * lab_1
 * @author Kotsko Volodymyr
 */
public class lab {
    /**
     * maximum value of interval
     */
    private int max;
    /**
     * minimal value of interval
     */
    private int min;
    /**
     * the sum of odds elements
     */
    private int sumOdds = 0;
    /**
     * the sum of even elements
     */
    private int sumEven = 0;

    public static void main(String[] args) {
        System.out.println("Перше завдання");
        Task_1 first = new Task_1();
        System.out.println("\nДруге завдання");
        Task_2 second = new Task_2();
        System.out.println("\nТретє завдання");
        Task_3 third = new Task_3(args);
        System.out.println("\nЧетверте завдання");
        lab num = new lab();

    }

    /**
     * Constructor
     */
    lab() {
        Input();
        printOddAndEven();
        sum();
        System.out.println("\nСума парних = " + sumEven + "\nСума непарних = " + sumOdds);
        int num =inputFibonacci();
        int[] fibonacci = new int[num];
        Fibonacci(fibonacci,num);
        oddAndEvenFibonacci(fibonacci,num);
    }

    /**
     * finding number of odd and even element
     * @param fibonacci array of fibonacci
     * @param num the amount of fibonacci
     */
    private void oddAndEvenFibonacci(int[] fibonacci,int num) {
        int numOdd=0;
        int numEven=0;
        for (int element:fibonacci){
            if(element%2==0){
                numEven++;
            }else numOdd++;
        }
        outputFibonacci(fibonacci,num,numEven,numOdd);
    }

    /**
     * Output info about fibonacci
     * @param fibonacci array of fibonacci
     * @param num the amount of fibonacci
     * @param numEven the amount of even element
     * @param numOdd the amount of odd element
     */
    private void outputFibonacci(int[] fibonacci, int num, int numEven, int numOdd) {
        System.out.print("Ряд Фібоначчі : ");
        for (int element: fibonacci){
            System.out.print(element+"  ");
        }
        System.out.println("\nВідсоток непарних чисел Фібоначі : " + (numOdd * 100) / num + " %");
        System.out.println("\nВідсоток парних чисел Фібоначі : " + (numEven * 100) / num + " %");
    }

    /**
     * Input interval
     */
    public void Input(){
        Scanner g = new Scanner(System.in);
        System.out.print("Введіть мінімалне значення інтервалу: ");
        min = g.nextInt();
        System.out.print("Введіть максимальне значення інтервалу: ");
        max = g.nextInt();
    }
    /**
     * Finding sum odds and pairs
     */
    private void sum() {
        int tmp = min;
        if (min % 2 == 0)
            sumEven += tmp++;
        while (tmp <= max) {
            sumOdds += tmp++;
            if (tmp <= max)
                sumEven += tmp++;
        }
    }

    /**
     * Output odds and pairs
     */
    public void printOddAndEven() {
        int num;
        if (min % 2 == 1) {
            num = min;
        } else num = min + 1;
        System.out.println("Непарні числа за зростанням з інтервалу");
        while (num <= max) {
            System.out.print(num + " ");
            num += 2;
        }
        System.out.println("\nПарні числа за спаданням з інтервалу");
        if (max % 2 == 0) {
            num = max;
        } else num = max - 1;
        while (num >= min) {
            System.out.print(num + " ");
            num -= 2;
        }
    }


    /**
     * @return the amount of fibonacci
     */
    public int inputFibonacci(){
        System.out.print("\nВведіть довжину ряду Фібоначчі : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * @param fibonacci array for fibonacci
     * @param num the amount of fibonacci
     */
    public void Fibonacci(int[] fibonacci,int num) {
        int flag;
        if (max % 2 == 1) {
            fibonacci[0] = max;
            fibonacci[1] = max - 1;
            flag = -1;
        } else {
            fibonacci[0] = max - 1;
            fibonacci[1] = max;
            flag = 1;
        }
        System.out.print(" " + fibonacci[0] + " " + fibonacci[1]);
        for (int i = 2; i < num; i++) {
            fibonacci[i] = fibonacci[i - 2] + flag * fibonacci[i - 1];
        }
    }
}
    