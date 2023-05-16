package by.academy.threegroup.service;

import by.academy.threegroup.core.MessageCreateDTO;
import by.academy.threegroup.core.MessageDTO;
import by.academy.threegroup.dao.api.IMessageDao;
import by.academy.threegroup.dao.memory.factory.MessageMemoryDaoFactory;
import by.academy.threegroup.service.api.IMessageService;
import by.academy.threegroup.service.factory.UserServiceFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class MessageService implements IMessageService {

    private final IMessageDao dao = MessageMemoryDaoFactory.getInstance();

    @Override
    public MessageDTO save(MessageCreateDTO item) {
        validate(item);
        MessageDTO message = new MessageDTO();
        message.setSendingTime(LocalDateTime.now());
        message.setSenderLogin(item.getSenderLogin());
        message.setRecipientLogin(item.getRecipientLogin());
        message.setText(item.getText());
        return dao.save(message);
    }

    @Override
    public List<MessageDTO> get(String userLogin) {
        if (!dao.getRecipients().contains(userLogin)){
            return null;
        }
        return dao.get(userLogin);
    }

    @Override
    public Map<String, List<MessageDTO>> get() {
        return dao.get();
    }

    private void validate(MessageCreateDTO item) throws IllegalArgumentException {
        UserServiceFactory.getInstance().get(item.getRecipientLogin());
    }
}