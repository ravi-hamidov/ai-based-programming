public class Student {
    private int id;
    private String name;
    private static int nextID = 1;


    public Student(String name) {
        this.id = nextID++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student { ID = " + id + ", Name = '" + name + "' }";
    }
}
