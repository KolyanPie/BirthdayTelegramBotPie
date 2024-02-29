package ru.kolyanpie.btbp.bot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class BotService {

    public void handle(Update update, DefaultAbsSender sender) {

    }

    public void onRegister(DefaultAbsSender sender) {

    }
}
