package ru.kolyanpie.btbp.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import ru.kolyanpie.btbp.bot.config.BotConfig;

@Slf4j
@Service
@Lazy
@Profile("!local")
public class WebhookBotPie extends SpringWebhookBot {
    private final String botUsername;
    private final BotService botService;

    @Autowired
    public WebhookBotPie(BotConfig config, BotService botService) {
        super(new SetWebhook(config.getWebhookPath()), config.getToken());
        botUsername = config.getName();
        this.botService = botService;
    }

    @Override
    public void onRegister() {
        botService.onRegister(this);
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        botService.handle(update, this);
        return null;
    }

    @Override
    public String getBotPath() {
        return null;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }
}
