package by.academy.threegroup.dao.memory;

import by.academy.threegroup.core.UserDTO;
import by.academy.threegroup.core.enums.UserRoles;
import by.academy.threegroup.dao.api.IUserDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserMemoryDao implements IUserDao {

    private Map<String, UserDTO> users = new ConcurrentHashMap<>();

    public UserMemoryDao() {
        UserDTO admin = new UserDTO();
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setSurname("Admin");
        admin.setLogin("Admin");
        admin.setRole(UserRoles.ADMIN);
        admin.setRegistrationDate(LocalDate.now());
        admin.setDateOfBirth(LocalDate.now());
        admin.setPassword("admin123".hashCode());
        users.put(admin.getLogin(), admin);
    }

    @Override
    public List<UserDTO> get() {
        return new ArrayList<>(this.users.values());
    }

    @Override
    public UserDTO save(UserDTO item) {
        return this.users.put(item.getLogin(), item);
    }

    @Override
    public UserDTO get(String login) {
        if(users.containsKey(login)){
            return users.get(login);
        }
        return null;
    }
}
