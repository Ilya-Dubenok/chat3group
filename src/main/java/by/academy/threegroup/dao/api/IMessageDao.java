package by.academy.threegroup.dao.api;

import by.academy.threegroup.core.MessageDTO;
import by.academy.threegroup.core.UserDTO;

import java.util.List;

public interface IMessageDao {

    /**
     * Сохранить сообщение, используя его получателя в качестве ключа
     * @param item сообщение, которое сохраняем
     */
    void save (MessageDTO item);

    /**
     * Отдать список всех сообщений, имеющих одного получателя
     * @param userLogin пользователь, являющийся получателем сообщений
     * @return список сообщений)))
     */
    List<MessageDTO> get (String userLogin);
}
