package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.AboutVga;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonParsingTest {
    private final ClassLoader cl = JsonParsingTest.class.getClassLoader();

    @Test
    void jsonTest() throws IOException {
        try (InputStream is = cl.getResourceAsStream("example.json");
             Reader reader = new InputStreamReader(is)) {
            ObjectMapper objectMapper = new ObjectMapper();
            AboutVga aboutVga = objectMapper.readValue(reader, AboutVga.class);

            assertEquals("Asus", aboutVga.getBrand());
            assertEquals("RTX4090", aboutVga.getModel());
            assertEquals(24, aboutVga.getMemory());
            assertArrayEquals(new String[]{"gaming", "working"}, aboutVga.getPurpose().toArray());
        }
    }
}

