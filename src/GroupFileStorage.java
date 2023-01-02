import java.io.*;

public class GroupFileStorage {
    public static void saveGroupToCSV(Group group){
        File csvOutputFile = new File(group.getGroupName() + ".csv");
        Student[] students = group.getStudents();

        try(PrintWriter printWriter = new PrintWriter(csvOutputFile)){
            for (Student s:students
            ) {
                printWriter.println(s.toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
