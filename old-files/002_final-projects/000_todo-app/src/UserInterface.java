
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoManager todoManager;

    public UserInterface() { 
        this.scanner = new Scanner(System.in);
        this.todoManager = new TodoManager(10);
    }

    public void start() {
        System.out.println("--- Gundelik Tapsiriqlar Tetbiqine Xos Gelmisiniz! ---");

        int choice;
        do {
            choice = showMenuAndGetChoice();
            processChoice(choice);
        } while (choice != 0);

        cleanup();
    }

    private int showMenuAndGetChoice() {
        System.out.println("\n--- Menyu ---");
        System.out.println("1. Yeni tapsirig elave et");
        System.out.println("2. Butun tapsiriqlari goster");
        System.out.println("3. Tapsirigi tamamlandi olaraq qeyd et");
        System.out.println("4. Prioritetli tapsirig elave et");
        System.out.println("0. Cixis");
        System.out.print("Seciminizi daxil edin: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Buffer temizleme
        return choice;
    }

    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                handleAddTodo();
                break;
            case 2:
                handleDisplayTodos();
                break;
            case 3:
                handleCompleteTodo();
                break;
            case 4:
                handleAddPriorityTodo();
                break;
            case 0:
                System.out.println("To-Do Tetbiqinden cixilir. Sag olun!");
                break;
            default:
                System.out.println("Yanlis secim! Zehmet olmasa, kecerli secim edin.");
                break;
        }
    }

    private void handleAddTodo() {
        if (todoManager.isFull()) {
            System.out.println("Tapsirig siyahisi doludur.");
            return;
        }

        System.out.print("Tapsiriqin tesvirini daxil edin: ");
        String description = scanner.nextLine();

        if (todoManager.addTodo(description)) {
            System.out.println("Tapsirig ugurla elave edildi.");
        } else {
            System.out.println("Tapsirig elave edilemedi.");
        }
    }

    private void handleAddPriorityTodo() {
        if (todoManager.isFull()) {
            System.out.println("Tapsirig siyahisi doludur.");
            return;
        }

        System.out.print("Tapsiriqin tesvirini daxil edin: ");
        String description = scanner.nextLine();
        System.out.print("Prioritet daxil edin (Yuksek/Normal/Asagi): ");
        String priority = scanner.nextLine();

        if (todoManager.addTodo(description, priority)) {
            System.out.println("Prioritetli tapsirig ugurla elave edildi.");
        } else {
            System.out.println("Tapsirig elave edilemedi.");
        }
    }

    private void handleDisplayTodos() {
        todoManager.displayAllTodos();
    }

    private void handleCompleteTodo() {
        if (todoManager.isEmpty()) {
            System.out.println("\nTamamlanacaq tapsirig yoxdur.");
            return;
        }

        System.out.println("\n--- Tapsirigi Tamamla ---");
        todoManager.displayAllTodos();

        System.out.print("Tamamlanacaq tapsiriqin nomresini daxil edin: ");
        int taskIndex = scanner.nextInt();

        if (todoManager.isValidIndex(taskIndex)) {
            TodoItem todo = todoManager.getTodo(taskIndex - 1);
            if (todo.isCompleted()) {
                System.out.println("Bu tapsirig artiq tamamlanmisdir!");
            } else {
                if (todoManager.completeTodo(taskIndex - 1)) {
                    System.out.println("Tapsirig ugurla tamamlandi!");
                } else {
                    System.out.println("Tapsirig tamamlanamadi.");
                }
            }
        } else {
            System.out.println("Yanlis nomre! Zehmet olmasa kecerli nomre daxil edin.");
        }
    }

    private void cleanup() {
        scanner.close();
    }
}
