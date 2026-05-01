import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int a,b;

        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero:");
        a = sc.nextInt();

        System.out.println("Digite outro numero: ");
        b = sc.nextInt();

        System.out.println("Soma: " + a+b);

    }

}
