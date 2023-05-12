package by.academy.threegroup.dao;

import by.academy.threegroup.core.MessageDTO;
import by.academy.threegroup.dao.api.IMessageDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageMemoryDao implements IMessageDao {

    Map<String, List<MessageDTO>> messages = new HashMap<>();

    @Override
    public void save(MessageDTO item) {
        String recipientLogin = item.getRecipientLogin();
        if (messages.containsKey(recipientLogin)){
            messages.get(recipientLogin).add(item);
        } else {
            messages.put(recipientLogin, new ArrayList<>(List.of(item)));
        }
    }

    @Override
    public List<MessageDTO> get(String userLogin) {
        return new ArrayList<>(messages.get(userLogin));
    }
}