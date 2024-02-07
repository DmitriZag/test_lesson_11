package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.AboutVga;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonParsingTest {
    private final ClassLoader cl = JsonParsingTest.class.getClassLoader();

    @Test
    void jsonTest() throws IOException {
        try (InputStream is = cl.getResourceAsStream("example.json");
             Reader reader = new InputStreamReader(is)) {
            ObjectMapper objectMapper = new ObjectMapper();
            AboutVga aboutVga = objectMapper.readValue(reader, AboutVga.class);

            assertThat(aboutVga.getBrand()).isEqualTo("Asus");
            assertThat(aboutVga.getModel()).isEqualTo("RTX4090");
            assertThat(aboutVga.getMemory()).isEqualTo(24);
            assertThat(aboutVga.getPurpose().toArray())
                    .isEqualTo(new String[]{"gaming", "working"
                    });
        }
    }
}

