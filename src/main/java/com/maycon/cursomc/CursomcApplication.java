package com.maycon.cursomc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    // metodo a ser executado quando a aplicação rodar
    // metodo extendido da interface CommandLineRunner
    @Override
    public void run(String... args) throws Exception {
    }
}
