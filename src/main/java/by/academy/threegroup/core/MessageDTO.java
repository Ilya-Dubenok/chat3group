package by.academy.threegroup.core;

import java.io.Serializable;
import java.time.LocalDateTime;

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

    public LocalDateTime getSendingTime() {
        return sendingTime;
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