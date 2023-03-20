import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ukarsy extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        //System.out.println(update.getMessage().getFrom().getFirstName() + ", "+update.getMessage().getText());
        if (update.hasMessage() && update.getMessage().hasText()) {

            String user_first_name = update.getMessage().getChat().getFirstName();
            String user_last_name = update.getMessage().getChat().getLastName();
            long user_id = update.getMessage().getChat().getId();
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            String answer = "Hello "+update.getMessage().getChat().getFirstName()+" "+ EmojiParser.parseToUnicode(" :smile:\n");
            SendMessage message = new SendMessage();
            message.setChatId(chat_id);
            message.setText(answer);
            log(user_first_name, user_last_name, Long.toString(user_id), message_text, answer);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
            }
        // TODO
        private void log(String first_name, String last_name, String user_id, String txt, String bot_answer) {
            System.out.println("\n ----------------------------");
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            System.out.println("Message from " + first_name + " " + last_name + ". (id = " + user_id + ") \n Text - " + txt);
            System.out.println("Bot answer: \n Text - " + bot_answer);
        }



    @Override
    public String getBotUsername() {
        // TODO
        return null;
    }

    @Override
    public String getBotToken() {
        // TODO
        return null;
    }
}
