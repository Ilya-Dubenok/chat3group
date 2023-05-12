package by.academy.threegroup.service;

import by.academy.threegroup.core.MessageCreateDTO;
import by.academy.threegroup.core.MessageDTO;
import by.academy.threegroup.dao.api.IMessageDao;
import by.academy.threegroup.dao.factory.MessageMemoryDaoFactory;
import by.academy.threegroup.service.api.IMessageService;

import java.time.Instant;
import java.util.List;

public class MessageService implements IMessageService {

    private final IMessageDao dao = MessageMemoryDaoFactory.getInstance();

    @Override
    public MessageDTO save(MessageCreateDTO item) {
        validate(item);
        return dao.save(new MessageDTO(Instant.now().getEpochSecond()
                ,item.getSenderLogin()
                ,item.getRecipientLogin()
                ,item.getText()));
    }

    @Override
    public List<MessageDTO> get(String userLogin) {
        return dao.get(userLogin);
    }

    private void validate(MessageCreateDTO item) {
        //todo проверить, существует ли получатель
    }
}