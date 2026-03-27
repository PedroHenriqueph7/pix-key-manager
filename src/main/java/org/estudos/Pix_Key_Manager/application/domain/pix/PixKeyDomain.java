package org.estudos.Pix_Key_Manager.application.domain.pix;

import org.hibernate.sql.results.DomainResultCreationException;
import java.util.UUID;

public class PixKeyDomain {

    private UUID id;
    private TypeKey type;
    private String value;
    private String accountId;

    public PixKeyDomain(TypeKey type, String value, String accountId) {
        boolean valid = this.type.isValidFormat(value);
        if (!valid) { throw new DomainResultCreationException("CHAVE Pix não valida!");}

        this.id = UUID.randomUUID();
        this.type = type;
        this.value = value;
        this.accountId = accountId;
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

    public String getAccountId() {
        return accountId;
    }
}
