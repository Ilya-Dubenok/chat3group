package by.academy.threegroup.service.encryption;

public class EncryptionService {
    protected EncryptionService() {
    }

    public String encryptPassword(String inputPassword) {
        return EncryptionUtil.encryptPassword(inputPassword);
    }

    public boolean checkPassword(String inputPassword, String encryptedStoredPassword) {
        return EncryptionUtil.checkPassword(inputPassword, encryptedStoredPassword);
    }
}
