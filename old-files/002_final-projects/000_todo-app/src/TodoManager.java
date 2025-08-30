
public class TodoManager {

    private TodoItem[] todoList;
    private int todoCount;
    private final int maxSize;


    public TodoManager(int maxSize) {
        this.maxSize = maxSize;
        this.todoList = new TodoItem[maxSize];
        this.todoCount = 0;
    }

    public boolean addTodo(String description) {
        return addTodo(description, "Normal");
    }

    public boolean addTodo(String description, String priority) {
        if (todoCount < maxSize) {
            todoList[todoCount] = new TodoItem(description, priority);
            todoCount++;
            return true;
        }
        return false;
    }

    public void displayAllTodos() {
        if (todoCount == 0) {
            System.out.println("\nSiyahida hec bir tapirig yoxdur.");
        } else {
            System.out.println("\n--- Tapirig Siyahisi ---");
            for (int i = 0; i < todoCount; i++) {
                todoList[i].displayInfo(i); 
            }
        }
    }

    public boolean completeTodo(int index) {
        if (index >= 0 && index < todoCount) {
            if (todoList[index].canBeCompleted()) {
                todoList[index].markAsCompleted();
                return true;
            }
        }
        return false;
    }

    public boolean isValidIndex(int userIndex) {
        return userIndex >= 1 && userIndex <= todoCount;
    }

    public boolean isEmpty() {  
        return todoCount == 0;
    }

    public boolean isFull() {
        return todoCount >= maxSize;
    }

    public TodoItem getTodo(int index) {
        if (index >= 0 && index < todoCount) {
            return todoList[index];
        }
        return null;
    }

    public int getTodoCount() {
        return todoCount;
    }
}
