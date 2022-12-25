public class Group {
    private String groupName;
    Student[] students = new Student[10];

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students.length > 10 || i > 9) {
                throw new GroupOverflowException("The group of students is already completed");
            }
            if (students[i] == null && students[i] != student) {
                students[i] = student;
            }
        }
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getLastName() == lastName) {
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
}
