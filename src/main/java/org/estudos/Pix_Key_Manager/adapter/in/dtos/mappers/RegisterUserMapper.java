package org.estudos.Pix_Key_Manager.adapter.in.dtos.mappers;

import org.estudos.Pix_Key_Manager.adapter.in.dtos.registerUser.RegisterUserRequestDTO;
import org.estudos.Pix_Key_Manager.application.domain.user.UserDomain;
import org.estudos.Pix_Key_Manager.application.usecases.exception.NullUserException;

public final class RegisterUserMapper {

    private RegisterUserMapper() {}

    public static UserDomain toDomain(RegisterUserRequestDTO dto) {

        if (dto == null) { throw new NullUserException("DTO não pode ser nulo!!");}

        return new UserDomain(
                dto.name(),
                dto.cpf(),
                dto.email(),
                dto.userType()
        );
    }
}
