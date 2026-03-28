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

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
