package by.academy.threegroup.service.api;

import by.academy.threegroup.core.MessageCreateDTO;
import by.academy.threegroup.core.MessageDTO;

import java.util.List;

public interface IMessageService {

    /**
     * Сохранить сообщение, используя его получателя в качестве ключа
     * @param item сообщение, которое сохраняем
     */
    MessageDTO save (MessageCreateDTO item);

    /**
     * Отдать список всех сообщений, имеющих одного получателя
     *
     * @param userLogin пользователь, являющийся получателем сообщений
     * @return список сообщений)))
     */
    List<MessageDTO> get (String userLogin);
}
