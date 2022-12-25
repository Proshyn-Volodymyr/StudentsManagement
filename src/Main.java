public class Main {
    public static void main(String[] args) {
        Group group1 = new Group("TM");
        Student student1 = new Student("Alex", "Mccain", Gender.MALE, 123, "TM");
        try {
            group1.addStudent(student1);
        } catch (GroupOverflowException gex) {
            gex.printStackTrace();
        }
        for (Student student : group1.getStudents()) {
            if(student != null){
                System.out.println(student.getLastName());
            }else{
                System.out.println(student);
            }
        }
    }
}