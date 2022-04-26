package mj.practice;

import java.util.Scanner;

import static mj.practice.Operation.*;


public class Console {
    public static void main(String[] args) {
        Console console = new Console();
        console.runConsole();
    }

    private void runConsole(){
        String command;

        try(Scanner scanner = new Scanner(System.in)){
            while (true){
                System.out.print("> ");
                command = scanner.nextLine();
                Operation operation = getOperationInput(command);

                if (operation == null) {
                    System.out.println("Invalid Input");
                    break;
                }

                if (operation == LIST) System.out.println("Listing");
                if (operation == CREATE) System.out.println("CREATING");
                if (operation == UPDATE) System.out.println("UPDATING");
                if (operation == REMOVE) System.out.println("REMOVING");

            }
        }
    }

    private Operation getOperationInput(String command) {
        Operation result = null;

        for (Operation operation : Operation.values()) {
            if (operation.toString().equalsIgnoreCase(command)) {
                result = operation;
                break;
            }
        }

        return result;
    }

}
