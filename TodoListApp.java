import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    String description;

    public Task(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}

public class TodoListApp {

    public static final Scanner scanner = new Scanner(System.in);
    public static final ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    sortTasks();
                    break;
                case 5:
                    viewTasks();
                    break;
                case 6:
                    System.out.println("Exiting the To-Do List Application. Goodbye!");
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display menu options
    public static void showMenu() {
        System.out.println("\n--- To-Do List Application ---");
        System.out.println("1. Add a To-Do Item");
        System.out.println("2. Edit a To-Do Item");
        System.out.println("3. Delete a To-Do Item");
        System.out.println("4. Sort To-Do List");
        System.out.println("5. View To-Do List");
        System.out.println("6. Exit");
        System.out.print("Choose an option (1-6): ");
    }

    // Get user input for menu option
    public static int getUserChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
        return choice;
    }

    // Add a new task
    public static void addTask() {
        System.out.print("Enter the description of the new task: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added successfully!");
        viewTasks();
    }

    // Edit an existing task
    public static void editTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to edit!");
            return;
        }

        viewTasks();
        System.out.print("Enter the number of the task to edit: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        System.out.print("Enter the new description for task " + taskNumber + ": ");
        String newDescription = scanner.nextLine();
        tasks.get(taskNumber - 1).description = newDescription;
        System.out.println("Task updated successfully!");
        viewTasks();
    }

    // Delete a task
    public static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete!");
            return;
        }

        viewTasks();
        System.out.print("Enter the number of the task to delete: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.remove(taskNumber - 1);
        System.out.println("Task deleted successfully!");
        viewTasks();
    }

    // Sort the tasks alphabetically
    public static void sortTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to sort!");
            return;
        }

        Collections.sort(tasks, Comparator.comparing(task -> task.description));
        System.out.println("Tasks sorted alphabetically!");
        viewTasks();
    }

    // View the list of tasks
    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in your To-Do list.");
        } else {
            System.out.println("\n--- Your To-Do List ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
