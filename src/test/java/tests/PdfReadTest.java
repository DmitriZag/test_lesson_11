package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.fail;

public class PdfReadTest {
    private final ClassLoader cl = PdfReadTest.class.getClassLoader();
    boolean pdfFound = false;

    @Test
    void pdfParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("files.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".pdf")) {
                    PDF content = new PDF(zis);
                    assertThat(content.title).isEqualTo("PowerPoint 簡報");
                }
            }
        }
        if (pdfFound) {
            fail("Файл .pdf не найден");
        }
    }
}