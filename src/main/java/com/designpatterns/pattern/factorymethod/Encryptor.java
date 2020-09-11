package com.designpatterns.pattern.factorymethod;

public abstract class Encryptor {

    public String writeToDisk(String content,String path) {
        EncryptionAlgorithm encryptionAlgorithm = getEncryptionAlgorithm();
        String encryptedmessage = encryptionAlgorithm.encrypt(content);

        System.out.println("writing to disk");
        return encryptedmessage;
    }

    protected abstract EncryptionAlgorithm getEncryptionAlgorithm();

}
