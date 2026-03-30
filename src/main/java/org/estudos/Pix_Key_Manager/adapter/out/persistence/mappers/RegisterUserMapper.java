package org.estudos.Pix_Key_Manager.adapter.out.persistence.mappers;

import org.estudos.Pix_Key_Manager.adapter.out.persistence.entities.UserEntity;
import org.estudos.Pix_Key_Manager.application.domain.user.UserDomain;
import org.estudos.Pix_Key_Manager.application.usecases.exception.NullUserException;

public final class RegisterUserMapper {

    private RegisterUserMapper() {}

    public static UserEntity toEntity(UserDomain userDomain) {

        if (userDomain == null) { throw new NullUserException("UserDomain está nulo!"); }

        return new UserEntity(
                userDomain.getId(),
                userDomain.getName(),
                userDomain.getCpf(),
                userDomain.getEmail(),
                userDomain.getUserType(),
                userDomain.getQuantityPixKey()
        );
    }
}
