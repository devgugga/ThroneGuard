package br.com.throneguard.throneguard;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

    static void main(String[] args) {

        // Loading .env before startup the application
        String profile = System.getProperty("spring.profiles.active");
        if (profile == null) {
            profile = "dev";
        }

        Dotenv dotenv;
        if (profile.equals("dev")) {
            dotenv = Dotenv.configure()
                    .directory("./server")
                    .load();
        } else {
            dotenv = Dotenv.configure()
                    .directory(".")
                    .ignoreIfMissing()
                    .load();
        }

        dotenv.entries().forEach(entry ->
                System.setProperty(entry.getKey(), entry.getValue())
        );

        SpringApplication.run(ServerApplication.class, args);
    }

}
