
public class TodoItem extends BaseItem implements Completable {

    private String priority;

    public TodoItem(String description) {
        super(description);
        this.priority = "Normal";
    }

    public TodoItem(String description, String priority) {
        super(description);
        this.priority = priority;
    }

    @Override
    public void markAsCompleted() {
        if (canBeCompleted()) {
            this.isCompleted = true;
        }
    }

    @Override
    public boolean canBeCompleted() {
        return !this.isCompleted;
    }

    @Override
    public void displayInfo(int index) {
        String status = isCompleted ? "[X]" : "[ ]";
        System.out.println((index + 1) + ". " + status + " " + description + " (" + priority + ")");
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
