import java.util.Scanner;

public class StudentCreateService {
    private Student newStudent;
    Scanner scanner = new Scanner(System.in);

    public Student createStudent() {
        System.out.println("Enter the new student's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the new student's last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the new student's gender: ");
        String gender = scanner.nextLine().toUpperCase();
        Gender genEnum= Gender.valueOf(gender);
        System.out.println("Enter the new student's id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        newStudent = new Student(name, lastName, genEnum, id);
        return newStudent;
    }

    @Override
    public String toString() {
        return "StudentCreateService{" +
                "newStudent=" + newStudent.getLastName() +
                '}';
    }
}

