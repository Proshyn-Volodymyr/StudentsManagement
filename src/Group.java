import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Group {
    private String groupName;
    Student[] students = new Student[10];

    public Group(String groupName) {
        this.groupName = groupName;
    }
    public Group(Student[]students){
        this.students = students;
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
    public void sortStudentsByLastName(){
        Arrays.sort(students, Comparator.nullsFirst(new StudentLastNameComparator()));
    }

    public boolean isUnique(){
        for (int i = 0; i < this.students.length - 1; i++) {
            for (int j = i+1; j < this.students.length; j++) {
                if(students[i].equals(students[j])){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
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
