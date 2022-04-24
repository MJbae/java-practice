package mj.practice;

import java.util.Scanner;

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

                if (command.equalsIgnoreCase("START")){
                    System.out.println("Running");
                } else if (command.equalsIgnoreCase("END")){
                    System.out.println("Done");
                    break;
                }else System.out.println("Invalid Input");
            }
        }
    }
}
