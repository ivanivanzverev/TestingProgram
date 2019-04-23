import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] mas = scanner.nextLine().split(" ");
        for (String str: mas) {
            System.out.println(str);
        }
    }
}
