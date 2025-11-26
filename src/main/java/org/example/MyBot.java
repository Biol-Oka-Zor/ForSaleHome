package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    MyBotService myBotService = new MyBotService();

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();


            if (text.equals("/start")) {
                try {
                    execute(myBotService.startMenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (text.equals("🇺🇿 O'zbekcha")){
                try {
                    execute(myBotService.buyMenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("🇷🇺 Русский")){
                try {
                    execute(myBotService.buyMenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("🇬🇧 English")){
                try {
                    execute(myBotService.buyMenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("🏘 Uylar ro'yxati")) {
                try {
                    execute(myBotService.photo1(chatId));
                    execute(myBotService.photo2(chatId));
                    execute(myBotService.photo3(chatId));
                    execute(myBotService.photo4(chatId));
                    execute(myBotService.photo5(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("📞 Kontaktlar")) {
                try {
                    execute(myBotService.contacts(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⭐ Yoqtirgan uylar")) {
                try {
                    execute(myBotService.favorites(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("💳 Hissa qo'shish")) {
                try {
                    execute(myBotService.donate(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("❓ Yordam")) {
                try {
                    execute(myBotService.help(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("ℹ Bot haqida")) {
                try {
                    execute(myBotService.about(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("📍 Yaqin uylar")) {
                try {
                    execute(myBotService.nearly(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("🆕 Yangi uylar")) {
                try {
                    execute(myBotService.newHomes(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("🔙 Orqaga")) {
                try {
                    execute(myBotService.backToMain(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @Override
    public String getBotUsername() {
        return "@for_sale_home_bot";
    }

    @Override
    public String getBotToken() {
        return "8282031759:AAF-8pwAw_kvpVQGUOYAwXV-pXzc1nizyP0";
    }
}

