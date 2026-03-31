package org.estudos.Pix_Key_Manager.application.domain.user;

import java.util.UUID;

public class UserDomain {

    private UUID id;
    private String name;
    private String cpf;
    private String email;
    private UserType userType;
    private int quantityPixKey;

    public UserDomain(String name, String cpf, String email, UserType userType) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.userType = userType;
    }

    public UserDomain(UUID id, String name, String cpf, String email, UserType userType, int quantityPixKey) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.userType = userType;
        this.quantityPixKey = quantityPixKey;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getQuantityPixKey() { return quantityPixKey; }

    public void setQuantityPixKey(int quantityPixKey) { this.quantityPixKey += quantityPixKey; }

}
