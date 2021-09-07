package impl.util;

import impl.education.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsWriter {

    private static final XSSFWorkbook workbook = new XSSFWorkbook();
    private static final List<XSSFCellStyle> arrayCellStyles = new ArrayList<>();
    private static final List<XSSFFont> arrayFonts = new ArrayList<>();
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;

    private static final Logger logger = Logger.getLogger(ParseExcel.class.getName());

    private XlsWriter() {}

    private static FileOutputStream createFileOutputStream(String path)
            throws IOException {

        File file = new File(path);
        file.createNewFile();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "File not found", e);
            throw e;
        }
        return fos;
    }

    private static void setTitleOfColumn(int index,
                                         String headerName) {
        sheet.setColumnWidth(index, (headerName.length() + 7) * 256);
        cell = row.createCell(index);
        cell.setCellValue(headerName);
        cell.setCellStyle(arrayCellStyles.get(0));
    }

    private static void setFont(String fontName,
                                short sizeFont,
                                boolean bold) {
        XSSFFont font = workbook.createFont();
        font.setFontName(fontName);
        font.setFontHeightInPoints(sizeFont);
        font.setBold(bold);
        arrayFonts.add(font);
    }

    private static void setStyle(HorizontalAlignment alignment,
                                 XSSFFont font) {
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(alignment);
        style.setFont(font);
        arrayCellStyles.add(style);
    }

    interface ValueOfStatistics {
        void createCell(int columnIndex);
    }

    private static class StringValue implements ValueOfStatistics {
        String stringValue;

        private StringValue() {}

        private void setStringValue(String stringValue) {
            this.stringValue = stringValue;
        }

        @Override
        public void createCell(int columnIndex) {
            cell = row.createCell(columnIndex);
            cell.setCellValue(stringValue);
        }
    }

    private static class IntValue implements ValueOfStatistics {
        int intValue;

        private IntValue() {}

        private void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        @Override
        public void createCell(int columnIndex) {
            cell = row.createCell(columnIndex);
            cell.setCellValue(intValue);
        }
    }

    private static class FloatValue implements ValueOfStatistics {
        float floatValue;

        private FloatValue() {}

        private void setFloatValue(float floatValue) {
            this.floatValue = floatValue;
        }

        @Override
        public void createCell(int columnIndex) {
            cell = row.createCell(columnIndex);
            cell.setCellValue(floatValue);
        }
    }

    private static void fillRow(int rowIndex,
                                int columnIndex,
                                ArrayList<ValueOfStatistics> listValues,
                                XSSFCellStyle style) {
        row = sheet.createRow(rowIndex);
        for (ValueOfStatistics value : listValues) {
            value.createCell(columnIndex++);
            if (columnIndex > 1) {
                cell.setCellStyle(style);
            }
        }
    }

    public static void generationFileXLXS(Collection<Statistics> collection,
                                          String path) throws IOException {
        sheet = workbook.createSheet("Статистика");
        row = sheet.createRow(0);
        setFont("Times New Roman", (short)12, true);
        setFont("Arial", (short)10, false);
        setStyle(HorizontalAlignment.valueOf("CENTER"),
                arrayFonts.get(0));
        setStyle(HorizontalAlignment.valueOf("CENTER"),
                arrayFonts.get(1));
        setTitleOfColumn(0, "Учебный профиль");
        setTitleOfColumn(1, "Средний балл студентов");
        setTitleOfColumn(2, "Количество студентов");
        setTitleOfColumn(3, "Количество университетов");
        ArrayList<ValueOfStatistics> listValues = new ArrayList<>();
        listValues.add(new StringValue());
        listValues.add(new FloatValue());
        listValues.add(new IntValue());
        listValues.add(new IntValue());

        int rowIndex = 1;
        for (Statistics statistics : collection) {
            ((StringValue)listValues.get(0))
                    .setStringValue(statistics
                    .getStudyProfile()
                    .getProfileName());
            ((FloatValue)listValues.get(1))
                    .setFloatValue(statistics
                    .getAvgExamScore());
            ((IntValue)listValues.get(2))
                    .setIntValue(statistics
                    .getNumberOfStudentsByProfile());
            ((IntValue)listValues.get(3))
                    .setIntValue(statistics
                    .getNumberOfUniversitiesByProfile());

            fillRow(rowIndex++,
                    0,
                    listValues,
                    arrayCellStyles.get(1));
        }
        workbook.write(createFileOutputStream(path));
    }
}
