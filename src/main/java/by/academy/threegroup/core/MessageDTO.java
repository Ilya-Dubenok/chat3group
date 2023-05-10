package by.academy.threegroup.core;

public class MessageDTO implements IDTO{
    private final long sendingTime;
    private final String senderLogin;
    private final String recipientLogin;
    private final String text;

    public MessageDTO(long sendingTime, String senderLogin, String recipientLogin, String text) {
        this.sendingTime = sendingTime;
        this.senderLogin = senderLogin;
        this.recipientLogin = recipientLogin;
        this.text = text;
    }

    public long getSendingTime() {
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