package by.academy.threegroup.service.encryption;

public class EncryptionFactory {
    private static volatile EncryptionService instance;

    public static EncryptionService getInstance() {
        if (instance == null) {
            synchronized (EncryptionFactory.class){
                if (instance == null){
                    instance = new EncryptionService();
                }
            }
        }
        return instance;
    }
}
