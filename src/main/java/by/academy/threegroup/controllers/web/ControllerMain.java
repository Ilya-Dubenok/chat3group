package by.academy.threegroup.contollers.web;

import by.academy.threegroup.core.MessageCreateDTO;
import by.academy.threegroup.core.MessageDTO;
import by.academy.threegroup.service.factory.MessageServiceFactory;

import java.util.List;
import java.util.Scanner;

public class ControllerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String senderLogin = "Alex";

        System.out.println("Введите имя получателя");
        String recipientLogin = scanner.nextLine();
        System.out.println("Введите текст сообщения");
        String messageText = scanner.nextLine();

        MessageServiceFactory.getInstance()
                .save(new MessageCreateDTO(senderLogin,recipientLogin,
                        "Тестовое сообщение"));
        MessageServiceFactory.getInstance().save(new MessageCreateDTO(senderLogin,recipientLogin
                ,messageText));

        List<MessageDTO> messages = MessageServiceFactory.getInstance().get("Joe");

        for (MessageDTO message : messages) {
            System.out.println(message.getText());
        }
    }
}