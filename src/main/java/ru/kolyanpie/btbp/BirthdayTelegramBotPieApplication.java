package ru.kolyanpie.btbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "ru.kolyanpie.btbp",
        "org.telegram.telegrambots"
})
public class BirthdayTelegramBotPieApplication {
    public static void main(String[] args) {
        SpringApplication.run(BirthdayTelegramBotPieApplication.class, args);
    }
}
