
package es.ejemplo.holamundo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HolaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void holaplus_returnsMensaje() throws Exception {
        mockMvc.perform(get("/holaplus"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.mensaje").value("Hola Mundo desde Spring Boot en Docker"));
    }

    @Test
    void health_returnsUp() throws Exception {
        mockMvc.perform(get("/health"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void hola_returnsMensaje() throws Exception {
        mockMvc.perform(get("/hola"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.mensaje").value("Hola Mundo desde Spring Boot en Docker"));
    }
}
