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

                if (command.equalsIgnoreCase(LIST.toString())) {
                    System.out.println("Listing");
                }
                else if (command.equalsIgnoreCase(CREATE.toString())) {
                    System.out.println("CREATING");
                }
                else if (command.equalsIgnoreCase(UPDATE.toString())) {
                    System.out.println("UPDATING");
                }
                else if (command.equalsIgnoreCase(REMOVE.toString())) {
                    System.out.println("REMOVING");
                }
                else {
                    System.out.println("Invalid Input");
                    break;
                }
            }
        }
    }
}
