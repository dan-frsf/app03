package isi.dan.app03;

import java.net.InetAddress;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class DockerTestController {
    

    @GetMapping
    public ResponseEntity<Map<String,String>> checkStatus(){
        Map<String,String> resultado = new LinkedHashMap<>();
        resultado.put("ts",Instant.now().toString());
        try{
            resultado.put("addres", InetAddress.getLocalHost().getHostAddress());
            resultado.put("name", InetAddress.getLocalHost().getHostName());
        } catch (Exception e){
            throw new RuntimeException("no anduvo");
        }
        return ResponseEntity.ok().body(resultado);
    }
}
