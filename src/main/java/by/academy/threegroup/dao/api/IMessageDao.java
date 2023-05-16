package by.academy.threegroup.dao.api;

import by.academy.threegroup.core.MessageDTO;

import java.util.List;
import java.util.Map;

public interface IMessageDao{

    /**
     * Сохранить сообщение, используя его получателя в качестве ключа
     * @param item сообщение, которое сохраняем
     */
    MessageDTO save (MessageDTO item);

    /**
     * Отдать список всех сообщений, имеющих одного получателя
     * @param userLogin пользователь, являющийся получателем сообщений
     * @return список сообщений)))
     */
    List<MessageDTO> get (String userLogin);


    /**
     * Отдать список всех пользователей, для которых есть больше одного сообщения
     * @return список логинов пользователей
     */
    List<String> getRecipients ();

    Map<String, List<MessageDTO>> get();
}
