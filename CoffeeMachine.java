package machine;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        String command;
        Machine coffeeMachine = new Machine(
                400,
                540,
                120,
                9,
                550
        );
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            Scanner scanner = new Scanner(System.in);
            command = scanner.next();
            coffeeMachine.operation(Command.valueOf(command));
        } while (Command.valueOf(command) != Command.exit);
    }
}
