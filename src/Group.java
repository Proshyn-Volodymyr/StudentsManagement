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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Student student:students
        ) {
            sb.append(student.getLastName()).append(", ");
        }
        String result = sb.deleteCharAt(sb.length() - 2).toString();
        return "Group{ " + getGroupName() +
                " students=" + result +
                '}';
    }
}
