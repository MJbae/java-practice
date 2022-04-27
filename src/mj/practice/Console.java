package mj.practice;

import java.util.Scanner;

import static mj.practice.Operation.*;


public class Console {
    TaskService service;
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);
        Console console = new Console(service);

        console.runConsole(service);
    }

    Console(TaskService service){
        this.service = service;
    }

    private void runConsole(TaskService service){
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

                if (operation == LIST) System.out.println(service.showAll());
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
