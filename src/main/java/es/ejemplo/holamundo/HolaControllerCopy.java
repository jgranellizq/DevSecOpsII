
package es.ejemplo.holamundo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HolaControllerCopy {

    @GetMapping("/hola")
    public Map<String, String> hola() {
        return Map.of("mensaje", "Hola Mundo desde Spring Boot en Docker");
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @GetMapping("/holaplus")
    public Map<String, String> holaplus() {
        return Map.of("mensaje", "Hola de nuevo Mundo desde Spring Boot en Docker");
    }
}


