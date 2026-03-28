package org.estudos.Pix_Key_Manager.application.domain.pix;

import org.estudos.Pix_Key_Manager.application.domain.exceptions.LimitPixKeysRegisteredException;
import org.estudos.Pix_Key_Manager.application.domain.user.UserDomain;
import org.estudos.Pix_Key_Manager.application.domain.user.UserType;
import org.hibernate.sql.results.DomainResultCreationException;
import java.util.UUID;

public class PixKeyDomain {

    private UUID id;
    private TypeKey type;
    private String value;
    private UserDomain account;

    public PixKeyDomain(TypeKey type, String value, UserDomain account) {
        boolean valid = this.type.isValidFormat(value);
        if (!valid) { throw new DomainResultCreationException("Chave Pix não Valida!!");}

        this.id = UUID.randomUUID();
        this.type = type;
        this.value = value;
        this.account = account;

        limitPixkeyRegister();
    }


    public UUID getId() {
        return id;
    }

    public TypeKey getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public UserDomain getAccount() {
        return account;
    }

    public void limitPixkeyRegister() {

        int limiteDeChavesPixParaPF = 5;
        int limitedeChavesPixParaPJ = 20;

        if (account.getUserType().equals(UserType.PF)) {
            if (account.getQuantityPixKey() >= limiteDeChavesPixParaPF) { throw new LimitPixKeysRegisteredException();}
        } else {
            if (account.getQuantityPixKey() >= limitedeChavesPixParaPJ) { throw new LimitPixKeysRegisteredException();}
        }
    }

}
