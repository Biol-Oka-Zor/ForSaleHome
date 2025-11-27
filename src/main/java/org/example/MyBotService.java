package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MyBotService {

    public SendPhoto photo1(Long chatId) {
        SendPhoto p = new SendPhoto();
        p.setChatId(chatId);
        p.setPhoto(new InputFile("https://t.me/forsale_home/29"));
        p.setCaption(
                "🏠 Narx: 120.000$\n" +
                        "📏 Sotix: 3\n" +
                        "📞 Tel: 90 111 11 11\n" +
                        "📍 Lokatsiya: ..."
        );
        return p;
    }

    public SendPhoto photo2(Long chatId) {
        SendPhoto p = new SendPhoto();
        p.setChatId(chatId);
        p.setPhoto(new InputFile("https://t.me/forsale_home/28"));
        p.setCaption(
                "🏠 Narx: 150.000$\n" +
                        "📏 Sotix: 4\n" +
                        "📞 Tel: 71 711 11 11\n" +
                        "📍 Lokatsiya: ..."
        );
        return p;
    }

    public SendPhoto photo3(Long chatId) {
        SendPhoto p = new SendPhoto();
        p.setChatId(chatId);
        p.setPhoto(new InputFile("https://t.me/forsale_home/30"));
        p.setCaption(
                "🏠 Narx: 200.000$\n" +
                        "📏 Sotix: 5\n" +
                        "📞 Tel: 93 333 33 33\n" +
                        "📍 Lokatsiya: ..."
        );
        return p;
    }


    public SendPhoto photo4(Long chatId) {
        SendPhoto p = new SendPhoto();
        p.setChatId(chatId);
        p.setPhoto(new InputFile("https://t.me/forsale_home/31"));
        p.setCaption(
                "🏠 Narx: 250.000$\n" +
                        "📏 Sotix: 6\n" +
                        "📞 Tel: 88 888 88 88\n" +
                        "📍 Lokatsiya: ..."
        );
        return p;
    }


    public SendPhoto photo5(Long chatId) {
        SendPhoto p = new SendPhoto();
        p.setChatId(chatId);
        p.setPhoto(new InputFile("https://t.me/forsale_home/32"));
        p.setCaption(
                "🏠 Narx: 300.000$\n" +
                        "📏 Sotix: 7\n" +
                        "📞 Tel: 94 444 44 44\n" +
                        "📍 Lokatsiya: ..."
        );
        return p;
    }


    public SendMessage startMenu(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Tilni tanlang / Choose language:");

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("🇺🇿 O'zbekcha"));
        rows.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("🇷🇺 Русский"));
        rows.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("🇬🇧 English"));
        rows.add(row3);

        markup.setKeyboard(rows);
        message.setReplyMarkup(markup);

        return message;
    }

    public SendMessage uzbekMain(Long chatId) {
        return mainMenu(chatId, "Kerakli bo‘limni tanlang:");
    }

    public SendMessage russianMain(Long chatId) {
        return mainMenu(chatId, "Выберите раздел:");
    }

    public SendMessage englishMain(Long chatId) {
        return mainMenu(chatId, "Choose an option:");
    }

    private SendMessage mainMenu(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow r1 = new KeyboardRow();
        r1.add(new KeyboardButton("🏠 Sotib olish"));
        r1.add(new KeyboardButton("🏚 Sotish"));
        rows.add(r1);

        markup.setKeyboard(rows);
        message.setReplyMarkup(markup);

        return message;
    }

    public SendMessage buyMenu(Long chatId) {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText("🏠 Sotib olish bo‘limi:");

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        rows.add(singleButtonRow("🏘 Uylar ro'yxati"));
        rows.add(singleButtonRow("📞 Kontaktlar"));
        rows.add(singleButtonRow("⭐ Yoqtirgan uylar"));
        rows.add(singleButtonRow("💳 Hissa qo'shish"));
        rows.add(singleButtonRow("❓ Yordam"));
        rows.add(singleButtonRow("ℹ Bot haqida"));
        rows.add(singleButtonRow("📍 Yaqin uylar"));
        rows.add(singleButtonRow("🆕 Yangi uylar"));
        rows.add(singleButtonRow("🔙 Orqaga"));

        markup.setKeyboard(rows);
        msg.setReplyMarkup(markup);

        return msg;
    }

    public SendMessage listHomes(Long chatId) {
        return simple(chatId, "📋 Mavjud uylar ro‘yxati:\n1. 3 xonali ...\n2. 2 xonali ...\n/back");
    }

    public SendMessage contacts(Long chatId) {
        return simple(chatId, "📞 Kontaktlar:\n+998 90 123 45 67\n/back");
    }

    public SendMessage favorites(Long chatId) {
        return simple(chatId, "⭐ Yoqtirgan uylar ro‘yxati bo‘sh.\n/back");
    }

    public SendMessage donate(Long chatId) {
        return simple(chatId, "💳 Karta: 8600 1234 5678 9012\n/back");
    }

    public SendMessage help(Long chatId) {
        return simple(chatId, "❓ Yordam bo‘limi.\n/back");
    }

    public SendMessage about(Long chatId) {
        return simple(chatId, "ℹ Bot haqida.\n/back");
    }

    public SendMessage nearly(Long chatId) {
        return simple(chatId, "📍 Yaqin uylar:\n- Chilonzor\n- Sergeli\n/back");
    }

    public SendMessage newHomes(Long chatId) {
        return simple(chatId, "🆕 Yangi uylar.\n/back");
    }

    public SendMessage sellMenu(Long chatId) {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText("🏚 Sotish bo‘limi:");

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(singleButtonRow("📝 E'lon berish"));
        rows.add(singleButtonRow("📋 Sotiladigan uylar"));
        rows.add(singleButtonRow("📞 Sotuvchi kontaktlari"));
        rows.add(singleButtonRow("⭐ Mening e'lonlarim"));
        rows.add(singleButtonRow("💳 Hissa qo'shish"));
        rows.add(singleButtonRow("❓ Sotish bo‘yicha yordam"));
        rows.add(singleButtonRow("ℹ Sotish haqida"));
        rows.add(singleButtonRow("📍 Yaqin uylar"));
        rows.add(singleButtonRow("🆕 Yangi e'lonlar"));
        rows.add(singleButtonRow("🔙 Orqaga"));

        markup.setKeyboard(rows);
        msg.setReplyMarkup(markup);

        return msg;
    }

    public SendMessage sellReport(Long chatId) {
        return simple(chatId, "📝 E'lon berish uchun ma'lumot yuboring.\n/back");
    }

    public SendMessage sellList(Long chatId) {
        return simple(chatId, "📋 Mavjud uylar ro‘yxati:\n1. 3 xonali ...\n2. 2 xonali ...\n/back");
    }

    public SendMessage sellContacts(Long chatId) {
        return simple(chatId, "📞 Kontaktlar:\n+998 90 123 45 67\n/back");
    }

    public SendMessage sellFavorites(Long chatId) {
        return simple(chatId, "⭐ Sizning e'lonlaringiz yo‘q.\n/back");
    }

    public SendMessage sellDonate(Long chatId) {
        return simple(chatId, "💳 Karta: 8600 1234 5678 9012\n/back");
    }

    public SendMessage sellHelp(Long chatId) {
        return simple(chatId, "❓ Sotish bo‘yicha yordam.\n/back");
    }

    public SendMessage sellAbout(Long chatId) {
        return simple(chatId, "ℹ Sotish haqida.\n/back");
    }

    public SendMessage sellNearly(Long chatId) {
        return simple(chatId, "📍 Yaqin uylar:\n- Chilonzor\n- Sergeli\n/back");
    }

    public SendMessage sellNew(Long chatId) {
        return simple(chatId, "🆕 Yangi e'lonlar.\n/back");
    }

    public SendMessage backToMain(Long chatId) {
        return uzbekMain(chatId);
    }

    private SendMessage simple(Long chatId, String text) {
        SendMessage m = new SendMessage();
        m.setChatId(chatId);
        m.setText(text);
        return m;
    }

    private KeyboardRow singleButtonRow(String text) {
        KeyboardRow row = new KeyboardRow();
        row.add(new KeyboardButton(text));
        return row;
    }
}
