package br.com.throneguard.throneguard;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

    static void main(String[] args) {

        Dotenv.configure()
                .directory("./")
                .filename("env")
                .load();

        SpringApplication.run(ServerApplication.class, args);
    }

}
