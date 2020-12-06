package com.matyspring.market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/saludar")
@RestController

public class HolaMundoControler {

    @GetMapping("/hola")
    public String saludar(){
        return "Esto esta andando";
    }
}
