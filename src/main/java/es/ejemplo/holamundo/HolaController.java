
package es.ejemplo.holamundo;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

@RestController
public class HolaController {

    @GetMapping("/hola")
    public Map<String, String> hola() {
        return Map.of("mensaje", "Hola Mundo desde Spring Boot en Docker");
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }
    
    @GetMapping("/demo/exec")
    public Map<String, String> exec(@RequestParam(defaultValue = "whoami") String cmd) throws Exception {
        Process p = Runtime.getRuntime().exec(cmd);
        try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String out = r.readLine();
            return Map.of("cmd", cmd, "out", out == null ? "" : out);
        }
    }

}

