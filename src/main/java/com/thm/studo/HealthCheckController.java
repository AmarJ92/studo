package com.thm.studo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studo")
public class HealthCheckController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(){
        return new ResponseEntity<>("Hello from studo!", HttpStatus.OK);
    }

}
