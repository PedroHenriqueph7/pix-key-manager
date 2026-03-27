package org.estudos.Pix_Key_Manager.application.domain.user;

import org.estudos.Pix_Key_Manager.application.domain.pix.PixKeyDomain;
import org.estudos.Pix_Key_Manager.application.domain.pix.TypeKey;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDomain {

    private UUID id;
    private String name;
    private String cpf;
    private String email;
    private UserType userType;
    List<PixKeyDomain> pixKeyList;

    public UserDomain(String name, String cpf, String email, UserType userType) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.userType = userType;
        this.pixKeyList = new ArrayList<>();
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


    public void addPixKeys(PixKeyDomain pixKey) {

        if (userType.equals(UserType.PF)) {
            if (pixKeyList.size() > 5) { throw new RuntimeException("Quantidade de Chaves Pix excedidas");}
        }

        int quantidadeMaximaChavePixPorTipo = 0;

        switch (pixKey.getType()) {
            case CPF:
                quantidadeMaximaChavePixPorTipo = 1;
                break;
            case TELEFONE:
                quantidadeMaximaChavePixPorTipo = 5;
                break;
            case EMAIL:
                quantidadeMaximaChavePixPorTipo = 5;
            case ALEATORIA:
                quantidadeMaximaChavePixPorTipo = 5;
            default:
                System.out.println("Tipo de chave Pix não existente!!");
        }

        Long quantity = quantityTypePixKey(pixKey.getType());
        if (quantity >= quantidadeMaximaChavePixPorTipo) { throw new RuntimeException("Voce Já Possui o máximo de chave Pix do tipo" + pixKey.getType() +"cadastrado!!");}
        pixKeyList.add(pixKey);
    }

    public Long quantityTypePixKey(TypeKey type) {
        Long quantity = pixKeyList.stream().filter( p -> p.getType() == type).count();

        return quantity;
    }
}
