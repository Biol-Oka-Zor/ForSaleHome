package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    MyBotService myBotService = new MyBotService();

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();

            if (text.equals("/start")) send(myBotService.startMenu(chatId));

            if (text.equals("🇺🇿 O'zbekcha")) send(myBotService.uzbekMain(chatId));
            if (text.equals("🇷🇺 Русский")) send(myBotService.russianMain(chatId));
            if (text.equals("🇬🇧 English")) send(myBotService.englishMain(chatId));

            if (text.equals("🏠 Sotib olish")) send(myBotService.buyMenu(chatId));

            if (text.equals("🏘 Uylar ro'yxati")) {
                send(myBotService.photo1(chatId));
                send(myBotService.photo2(chatId));
                send(myBotService.photo3(chatId));
                send(myBotService.photo4(chatId));
                send(myBotService.photo5(chatId));
            }

            if (text.equals("📞 Kontaktlar")) send(myBotService.contacts(chatId));
            if (text.equals("⭐ Yoqtirgan uylar")) send(myBotService.favorites(chatId));
            if (text.equals("❓ Yordam")) send(myBotService.help(chatId));
            if (text.equals("ℹ Bot haqida")) send(myBotService.about(chatId));
            if (text.equals("📍 Yaqin uylar")) send(myBotService.nearly(chatId));
            if (text.equals("🆕 Yangi uylar")) send(myBotService.newHomes(chatId));


            if (text.equals("🔙 Orqaga")) send(myBotService.uzbekMain(chatId));


            if (text.equals("🏚 Sotish")) send(myBotService.sellMenu(chatId));

            if (text.equals("📝 E'lon berish")) send(myBotService.sellReport(chatId));
            if (text.equals("📋 Sotiladigan uylar")) send(myBotService.sellList(chatId));
            if (text.equals("📞 Sotuvchi kontaktlari")) send(myBotService.sellContacts(chatId));
            if (text.equals("⭐ Mening e'lonlarim")) send(myBotService.sellFavorites(chatId));
            if (text.equals("💳 Hissa qo'shish")) send(myBotService.sellDonate(chatId));
            if (text.equals("❓ Sotish bo‘yicha yordam")) send(myBotService.sellHelp(chatId));
            if (text.equals("ℹ Sotish haqida")) send(myBotService.sellAbout(chatId));
            if (text.equals("📍 Yaqin uylar")) send(myBotService.sellNearly(chatId));
            if (text.equals("🆕 Yangi e'lonlar")) send(myBotService.sellNew(chatId));
        }
    }

    private void send(Object msg) {
        try {
            if (msg instanceof SendMessage) execute((SendMessage) msg);
            else if (msg instanceof SendPhoto) execute((SendPhoto) msg);
            else if (msg instanceof SendDocument) execute((SendDocument) msg);
            else if (msg instanceof SendVideo) execute((SendVideo) msg);
            else if (msg instanceof SendAudio) execute((SendAudio) msg);
            else if (msg instanceof SendAnimation) execute((SendAnimation) msg);

        } catch (TelegramApiException e) {
            e.printStackTrace();
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
