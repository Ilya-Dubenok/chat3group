package by.academy.threegroup.core;

public class MessageCreateDTO implements IDTO{
    private final String senderLogin;
    private final String recipientLogin;
    private final String text;

    public MessageCreateDTO(String  senderLogin, String recipientLogin, String text) {
        this.senderLogin = senderLogin;
        this.recipientLogin = recipientLogin;
        this.text = text;
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
