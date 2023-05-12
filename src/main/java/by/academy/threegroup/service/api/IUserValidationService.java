package by.academy.threegroup.service.api;

import by.academy.threegroup.core.UserCreateDTO;

public interface IUserValidationService {
    void validate(UserCreateDTO user);
}
