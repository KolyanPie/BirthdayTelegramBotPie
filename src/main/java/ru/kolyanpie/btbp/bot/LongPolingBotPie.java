package ru.kolyanpie.btbp.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.kolyanpie.btbp.bot.config.BotConfig;

@Service
@Profile("local")
public class LongPolingBotPie extends TelegramLongPollingBot {
    private final String botUsername;
    private final BotService botService;

    @Autowired
    public LongPolingBotPie(BotConfig config, BotService botService) {
        super(config.getToken());
        this.botUsername = config.getName();
        this.botService = botService;
    }

    @Override
    public void onRegister() {
        botService.onRegister(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        botService.handle(update, this);
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }
}
