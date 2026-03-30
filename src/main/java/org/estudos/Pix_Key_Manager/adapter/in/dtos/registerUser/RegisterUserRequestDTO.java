package org.estudos.Pix_Key_Manager.adapter.in.dtos.registerUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.estudos.Pix_Key_Manager.application.domain.user.UserType;
import org.hibernate.validator.constraints.br.CPF;

public record RegisterUserRequestDTO(

        @NotBlank( message = "O campo nome é obrigatório!!")
        String name,

        @CPF(message = "O cpf informado não esta válido!")
        String cpf,
        @Email(message = "O email informado não é valido!")
        String email,

        @NotNull(message = "Formato Inválido, informe se você é uma Pessoa Física - PF, ou uma Pessoa Juridica - PJ")
        UserType userType
        ) {
}
