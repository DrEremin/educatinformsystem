package impl.util;

import impl.education.Statistics;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

public class XlsWriter {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static Row currentRow;

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

    public static void generationFileXLXS(Collection<Statistics> collection,
                                          String path) throws IOException {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Статистика");
        workbook.write(createFileOutputStream(path));
    }
}
