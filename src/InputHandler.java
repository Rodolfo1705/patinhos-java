import java.util.Scanner;

public class InputHandler {
    final static Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String message){
        System.out.print(message);

        return scanner.nextInt();
    }
}
