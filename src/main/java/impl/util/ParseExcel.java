package impl.util;

import impl.education.University;
import impl.education.Student;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Iterator;

public class ParseExcel {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static Row currentRow;
    private static String pastPath = "";

    private ParseExcel() {
    }

    private static void setWorkbook(String path) throws IOException {
        if (!path.equals(pastPath)) {
            File file = new File(path);
            try (FileInputStream fis = new FileInputStream(file)) {
                BufferedInputStream bis = new BufferedInputStream(fis);
                workbook = new XSSFWorkbook(bis);
                pastPath = path;
            } catch (IOException e) {
                throw e;
            }
        }
    }

    private static Student newStudent() {
        return new Student.Builder()
                .setFullName(currentRow.getCell(0).getStringCellValue())
                .setUniversityId(currentRow.getCell(1).getStringCellValue())
                .setCurrentCourseNumber((int)currentRow.getCell(2).getNumericCellValue())
                .setAvgExamSource((float)currentRow.getCell(3).getNumericCellValue())
                .build();
    }

    public static LinkedList<Student> readStudents(String path) throws IOException {
        setWorkbook(path);

        sheet = workbook.getSheetAt(1);
        Iterator<Row> iterator = sheet.iterator();
        iterator.next();
        Student student;
        LinkedList<Student> list = new LinkedList<>();

        while (iterator.hasNext()) {
            currentRow = iterator.next();
            student = newStudent();
            if (student.getFullName().equals("")) {
                break;
            }
            list.add(student);
        }
        return list;
    }
}
