package impl.util;

import impl.education.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

public class XlsWriter {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow currentRow;
    private static XSSFRow titleRow;
    private static XSSFCell titleCell;
    private static XSSFCellStyle cellStyle;
    private static HorizontalAlignment alignment;

    private XlsWriter() {}

    private static FileOutputStream createFileOutputStream(String path) throws IOException {

        File file = new File(path);
        file.createNewFile();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new IOException(e);
        }
        return fos;
    }

    private static void setTitleOfColumn(int index, String headerName) {
        sheet.setColumnWidth(index, (headerName.length() + 7) * 256);
        titleRow.createCell(index).setCellValue(headerName);
    }

    public static void generationFileXLXS(Collection<Statistics> collection,
                                          String path) throws IOException {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Статистика");
        titleRow = sheet.createRow(0);
        /*alignment = HorizontalAlignment.valueOf("CENTER");
        cellStyle = titleRow.getRowStyle();
        cellStyle.setAlignment(alignment);
        titleRow.setRowStyle(cellStyle);*/
        setTitleOfColumn(0, "Учебный профиль");
        setTitleOfColumn(1, "Средний балл студентов");
        setTitleOfColumn(2, "Количество студентов");
        setTitleOfColumn(3, "Количество университетов");

        int rowIndex = 1;
        for (Statistics statistics : collection) {
            int columnIndex = 0;
            currentRow = sheet.createRow(rowIndex++);
            currentRow.createCell(columnIndex++)
                    .setCellValue(statistics
                            .getStudyProfile()
                            .getProfileName());
            currentRow.createCell(columnIndex++)
                    .setCellValue(statistics
                            .getAvgExamScore());
            currentRow.createCell(columnIndex++)
                    .setCellValue(statistics
                            .getNumberOfStudentsByProfile());
            currentRow.createCell(columnIndex)
                    .setCellValue(statistics
                            .getNumberOfUniversitiesByProfile());
        }

        workbook.write(createFileOutputStream(path));
    }
}
