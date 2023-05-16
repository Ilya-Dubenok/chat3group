package by.academy.threegroup.core;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class MessageDTO implements Serializable {
    private LocalDateTime sendingTime;
    private String senderLogin;
    private String recipientLogin;
    private String text;

    public void setSendingTime(LocalDateTime sendingTime) {
        this.sendingTime = sendingTime;
    }

    public void setSenderLogin(String senderLogin) {
        this.senderLogin = senderLogin;
    }

    public void setRecipientLogin(String recipientLogin) {
        this.recipientLogin = recipientLogin;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSendingTime() {
        return sendingTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT));
    }

    public String getSenderLogin() {
        return senderLogin;
    }

    public String getRecipientLogin() {
        return recipientLogin;
    }

    public String getText() {
        return text;
    }
}