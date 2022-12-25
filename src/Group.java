import java.util.Arrays;

public class Group {
    private String groupName;
    Student[] students = new Student[10];

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        boolean isAllowToAdd = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null && students[i] != student) {
                students[i] = student;
                isAllowToAdd = true;
                break;
            }
        }
        if (!isAllowToAdd) {
            throw new GroupOverflowException("The group of students is already completed");
        }
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getLastName().equals(lastName)) {
                return students[i];
            }
        }
        throw new StudentNotFoundException("Student " + lastName + " has not found");
    }

    public boolean removeStudentById(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                students[i] = null;
                return true;
            }
        }
        return false;
    }
    public String[] sortStudent(Student[] students){
        String[] lastNameArray = new String[students.length];
        for (int i = 0; i < students.length; i++) {
            lastNameArray[i] = students[i].getLastName();
        }
        Arrays.sort(lastNameArray);
        for (int i = 0; i < lastNameArray.length; i++) {
            Student temp;
            for (int j = i; j < students.length; j++) {
                if(lastNameArray[i].equals(students[j].getLastName())){
                    temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        return lastNameArray;
    }

    @Override
    public String toString() {
        return "Group{" +
                "students=" + Arrays.toString(sortStudent(students)) +
                '}';
    }
}
