
abstract class BaseItem {

    protected String description;
    protected boolean isCompleted;

    public BaseItem(String description) {
        this.description = description;
        this.isCompleted = false; 
    }

    public abstract void displayInfo(int index);

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
