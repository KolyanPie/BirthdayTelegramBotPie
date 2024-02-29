package ru.kolyanpie.btbp.bot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties("telegram.bot")
public class BotConfig {
    private String webhookPath;
    private String name;
    private String token;
}
