package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class XlsxReadTest {
    private final ClassLoader cl = PdfReadTest.class.getClassLoader();
    @Test
    void pdfParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("files.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".xlsx")) {
                    XLS xls = new XLS(zis);
                    Assertions.assertEquals("January",
                            xls.excel.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue());
                }
            }
        }
    }
}
