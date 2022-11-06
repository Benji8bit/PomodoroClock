package telegram;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import telegram.commands.BeginCommand;
import telegram.commands.HelpCommand;

public class TelegramBot extends TelegramLongPollingCommandBot {
    public static final String BOT_TOKEN = "5697462471:AAG3cj5OdyIr86GtdYovAhNdN8e-H5OcnAk";
    public static final String BOT_USERNAME = "PomodoroClockBot";

    public static final int WORK = 25;
    public static final int BREAK = 5;

    public TelegramBot() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            botsApi.registerBot(this);
            register(new BeginCommand("begin", "Начать"));
            register(new HelpCommand("help", "Помощь"));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void processNonCommandUpdate(Update update) {

    }
}
