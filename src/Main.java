import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Group group1 = new Group("TM");
        Student student1 = new Student("Alex", "Mccain", Gender.MALE, 123, "TM");
        Student student2 = new Student("John", "Smith", Gender.MALE, 111, "TM");
        Student student3 = new Student("Max", "Payne", Gender.MALE, 222, "TM");
        Student student4 = new Student("Anna", "Whisper", Gender.FEMALE, 333, "TM");
        Student student5 = new Student("Aelita", "Stark", Gender.FEMALE, 444, "TM");
        Student student6 = new Student("Samantha", "Clark", Gender.FEMALE, 555, "TM");
        Student student7 = new Student("Victor", "Barrera", Gender.MALE, 666, "TM");
        Student student8 = new Student("Kim", "Wexler", Gender.FEMALE, 777, "TM");
        Student student9 = new Student("Soul", "Goodman", Gender.MALE, 888, "TM");
        Student student10 = new Student("Borys", "Jonson", Gender.MALE, 999, "TM");
        Student student11 = new Student("Stephen", "King", Gender.MALE, 1000, "TM");

        try {
            group1.addStudent(student1);
            group1.addStudent(student2);
            group1.addStudent(student3);
            group1.addStudent(student4);
            group1.addStudent(student5);
            group1.addStudent(student6);
            group1.addStudent(student7);
            group1.addStudent(student8);
            group1.addStudent(student9);
            group1.addStudent(student10);
//            group1.addStudent(student11);
        } catch (GroupOverflowException gex) {
            gex.printStackTrace();
        }
        /* Search student by last name
        * */
//        try {
//            group1.searchStudentByLastName("King");
//        } catch (StudentNotFoundException fex) {
//            fex.printStackTrace();
//        }
//        group1.removeStudentById(123);

//        for (Student student : group1.getStudents()) {
//            if (student != null) {
//                System.out.println(student.getLastName());
//            }
//        }
        Arrays.sort(group1.students);
        System.out.println(group1);
    }
}