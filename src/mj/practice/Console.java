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
        Integer PERSONAL_CATEGORY_ID = 0;
        Integer SECOND_TASK_ID = 998;
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

                if (operation == LIST){
                    System.out.print("List All: ");
                    System.out.println(service.showAll());
                    System.out.print("List Personal Category Tasks: ");
                    System.out.println(service.showBy(PERSONAL_CATEGORY_ID));
                }
                if (operation == CREATE){
                    Task savedTask = service.create(PERSONAL_CATEGORY_ID, new Task(600, "Saving Test"));
                    System.out.println("Saved Task: " + savedTask);
                }
                if (operation == UPDATE){
                    Task updatingTask = new Task(SECOND_TASK_ID, "Updating Test");
                    Task updatedTask = service.update(PERSONAL_CATEGORY_ID, updatingTask);
                    System.out.println("Updated Task: " + updatedTask);
                }
                if (operation == REMOVE){
                    Task savedTask = service.create(PERSONAL_CATEGORY_ID, new Task(600, "Saving Test"));
                    Task deletedTask = service.delete(PERSONAL_CATEGORY_ID, savedTask);
                    System.out.println("Deleted Task: " + deletedTask);
                }

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
