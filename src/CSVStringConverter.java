import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CSVStringConverter implements StringConverter {
    @Override
    public String toStringRepresentation(Student student) {
        return student.getName() + ";" + student.getLastName() + ";" + student.getGender() + ";" + student.getId() + ";"
                + student.getGroupName();
    }

    @Override
    public Student fromStringRepresentation(String str) {
        String[] strArray = str.split(";");
        Student newStudent = new Student(strArray[0], strArray[1], Gender.valueOf(strArray[2]), Integer.valueOf(strArray[3]), strArray[4]);

        return newStudent;
    }
}
