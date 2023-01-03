import javax.swing.filechooser.FileFilter;
import java.io.*;

public class GroupFileStorage {
    public static void saveGroupToCSV(File folder,Group group) {
        File csvOutputFile = new File(folder,group.getGroupName() + ".csv");
        Student[] students = group.getStudents();

        try (PrintWriter printWriter = new PrintWriter(csvOutputFile)) {
//            printWriter.println("Name,LastName,Gender,ID,GroupName");
            for (Student s : students
            ) {
                printWriter.println(s.getName() + "," + s.getLastName() + "," + s.getGender() + "," + s.getId() + "," + s.getGroupName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Group loadGroupFromCSV(File file) {
        Student[] students = new Student[10];
        String line = "";
        int index = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineElements = line.split(",");
                for (int i = 0; i < lineElements.length - 1; i++) {
                    Student student = new Student(lineElements[0], lineElements[1], Gender.valueOf(lineElements[2]), Integer.valueOf(lineElements[3]), lineElements[4]);
                    students[index] = student;
                }
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Group(students);
    }
    public static File findFileByGroupName(String groupName, File workFolder){
        if(workFolder.isDirectory()){
            File[] includingFiles = workFolder.listFiles();
            for (int i = 0; i < includingFiles.length; i++) {
                if(includingFiles[i].getName().startsWith(groupName)){
                    return includingFiles[i];
                }
            }
        }
        return workFolder;
    }
}
