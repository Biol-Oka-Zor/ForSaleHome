package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    MyBotService myBotService = new MyBotService();

    @Override
    public void onUpdateReceived(Update update) {

        if (!update.hasMessage() || !update.getMessage().hasText()) return;

        long chatId = update.getMessage().getChatId();
        String text = update.getMessage().getText();

        try {
            if (text.equals("/start")) {
                execute(myBotService.startMenu(chatId));
            }

            else if (text.equals("🇺🇿 O'zbekcha")) {
                execute(myBotService.uzbekMain(chatId));
            } else if (text.equals("🇷🇺 Русский")) {
                execute(myBotService.russianMain(chatId));
            } else if (text.equals("🇬🇧 English")) {
                execute(myBotService.englishMain(chatId));
            }

            // SOTIB OLISH
            else if (text.equals("🏠 Sotib olish") || text.equals("/buy")) {
                execute(myBotService.buyMenu(chatId));
            }

            else if (text.equals("🏘 Uylar ro'yxati") || text.equals("/list")) {
                execute(myBotService.listHomes(chatId));
            }

            else if (text.equals("📞 Kontaktlar") || text.equals("/contacts")) {
                execute(myBotService.contacts(chatId));
            }

            else if (text.equals("⭐ Yoqtirgan uylar") || text.equals("/favorites")) {
                execute(myBotService.favorites(chatId));
            }

            else if (text.equals("💳 Hissa qo'shish") || text.equals("/donate")) {
                execute(myBotService.donate(chatId));
            }

            else if (text.equals("❓ Yordam") || text.equals("/help")) {
                execute(myBotService.help(chatId));
            }

            else if (text.equals("ℹ Bot haqida") || text.equals("/about")) {
                execute(myBotService.about(chatId));
            }

            else if (text.equals("📍 Yaqin uylar") || text.equals("/nearly")) {
                execute(myBotService.nearly(chatId));
            }

            else if (text.equals("🆕 Yangi uylar") || text.equals("/new")) {
                execute(myBotService.newHomes(chatId));
            }


            else if (text.equals("🏚 Sotish") || text.equals("/sell")) {
                execute(myBotService.sellMenu(chatId));
            }

            else if (text.equals("📝 E'lon berish") || text.equals("/report")) {
                execute(myBotService.sellReport(chatId));
            }

            else if (text.equals("📋 Sotiladigan uylar") || text.equals("/sell_list")) {
                execute(myBotService.sellList(chatId));
            }

            else if (text.equals("📞 Sotuvchi kontaktlari") || text.equals("/sell_contacts")) {
                execute(myBotService.sellContacts(chatId));
            }

            else if (text.equals("⭐ Mening e'lonlarim") || text.equals("/sell_favorites")) {
                execute(myBotService.sellFavorites(chatId));
            }

            else if (text.equals("💳 To'lov qoidalari") || text.equals("/sell_donate")) {
                execute(myBotService.sellDonate(chatId));
            }

            else if (text.equals("❓ Sotish bo‘yicha yordam") || text.equals("/sell_help")) {
                execute(myBotService.sellHelp(chatId));
            }

            else if (text.equals("ℹ Sotish haqida") || text.equals("/sell_about")) {
                execute(myBotService.sellAbout(chatId));
            }

            else if (text.equals("📍 Sizga yaqin sotuvchilar") || text.equals("/sell_nearly")) {
                execute(myBotService.sellNearly(chatId));
            }

            else if (text.equals("🆕 Yangi e'lonlar") || text.equals("/sell_new")) {
                execute(myBotService.sellNew(chatId));
            }

            else if (text.equals("🔙 Orqaga") || text.equals("/back")) {
                execute(myBotService.backToMain(chatId));
            }

        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
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
