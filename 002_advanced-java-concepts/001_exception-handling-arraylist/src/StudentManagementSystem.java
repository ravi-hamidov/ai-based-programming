import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Telebe Elave Et
    public static void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Telebe ugurla elave edildi: " + student);
    }

    // Butun Telebeleri Goster
    public static void showStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Hec bir telebe tapilmadi!");
        } else {
            System.out.println("Telebe Siyahisi:");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    // Telebeni Sil
    public static void deleteStudent(int id) {
        try {
            Student s = getStudentById(id);
            studentList.remove(s);
            System.out.println("Telebe ugurla silindi!");
        } catch (StudentNotFoundExceptionR e) {
            System.out.println(e.getMessage());
        }
    }

    // Telebeni Yenile
    public static void updateStudent(int id, String name) {
        try {
            Student s = getStudentById(id);
            s.setName(name);
            System.out.println("Telebe melumatlari ugurla yenilendi: " + s);
        } catch (StudentNotFoundExceptionR e) {
            System.out.println(e.getMessage());
        }
    }

    // ID ile Telebe Tap
    public static Student getStudentById(int id) throws StudentNotFoundExceptionR {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new StudentNotFoundExceptionR(id + " ID-li telebe tapilmadi!");
    }

    // Esas Metod ve Menyu
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Telebe Idareetme Sistemi =====");
            System.out.println("1. Telebe Elave Et");
            System.out.println("2. Telebeni Sil");
            System.out.println("3. Melumatlari Yenile");
            System.out.println("4. Telebe Axtar");
            System.out.println("5. Butun Siyahini Goster");
            System.out.println("6. Cixis");
            System.out.print("Seciminizi daxil edin: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // buffer temizlenmesi ucun

                switch (choice) {
                    case 1:
                        System.out.print("Telebenin adini daxil edin: ");
                        String name = sc.nextLine();
                        addStudent(new Student(name));
                        break;
                    case 2:
                        System.out.print("Silmek ucun telebe ID-sini daxil edin: ");
                        int delId = sc.nextInt();
                        deleteStudent(delId);
                        break;
                    case 3:
                        System.out.print("Yenilemek ucun telebe ID-sini daxil edin: ");
                        int updId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Yeni adi daxil edin: ");
                        String newName = sc.nextLine();
                        updateStudent(updId, newName);
                        break;
                    case 4:
                        System.out.print("Axtarmaq ucun telebe ID-sini daxil edin: ");
                        int findId = sc.nextInt();
                        try {
                            Student s = getStudentById(findId);
                            System.out.println("Tapildi: " + s);
                        } catch (StudentNotFoundExceptionR e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        showStudents();
                        break;
                    case 6:
                        System.out.println("Sistemden cixilir... Gorusenedek!");
                        break;
                    default:
                        System.out.println("Yanlis secim! Yeniden cehd edin.");
                }
            } catch (Exception e) {
                System.out.println("Yanlis daxiletme! Zehmet olmasa, reqem daxil edin.");
                sc.nextLine(); // sehv inputu temizlemek ucun
                choice = -1;
            }

        } while (choice != 6);
    }
}