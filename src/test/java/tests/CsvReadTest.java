package tests;

import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class CsvReadTest {
    private final ClassLoader cl = PdfReadTest.class.getClassLoader();
    boolean csvFound = false;
    @Test
    void pdfParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("files.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> content = csvReader.readAll();
                    assertThat(content.get(0)).isEqualTo(new String[]{"name","phoneNumber","email","address","userAgent","hexcolor"});
                }
            }
        }
        if (csvFound) {
            fail("Файл .csv не найден");
        }
    }
}
