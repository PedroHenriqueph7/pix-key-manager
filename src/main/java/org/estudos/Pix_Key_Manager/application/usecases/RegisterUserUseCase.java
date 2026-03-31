package org.estudos.Pix_Key_Manager.application.usecases;

import jakarta.transaction.Transactional;
import org.estudos.Pix_Key_Manager.application.domain.user.UserDomain;
import org.estudos.Pix_Key_Manager.application.ports.in.RegisterUserInPort;
import org.estudos.Pix_Key_Manager.application.ports.out.RegisterUserOutPort;
import org.estudos.Pix_Key_Manager.application.usecases.exception.CpfAlreadyExistsException;
import org.estudos.Pix_Key_Manager.application.usecases.exception.EmailAlreadyExistsException;
import org.estudos.Pix_Key_Manager.application.usecases.exception.NullUserException;

public class RegisterUserUseCase implements RegisterUserInPort {

    private final RegisterUserOutPort registerUserOutPort;

    public RegisterUserUseCase(RegisterUserOutPort registerUserOutPort) {
        this.registerUserOutPort = registerUserOutPort;
    }

    @Transactional
    @Override
    public void execute(UserDomain userDomain) {

        if (userDomain == null) {throw new NullUserException("Usuario com o valor nulo!");}

        boolean jaExisteCpf = registerUserOutPort.existsByCpf(userDomain.getCpf());
        boolean jaExisteEmail = registerUserOutPort.existsByEmail(userDomain.getEmail());

        if (jaExisteCpf) { throw new CpfAlreadyExistsException("Este cpf já esta cadastrado em uma outra conta!");}
        if (jaExisteEmail) {throw new EmailAlreadyExistsException("Não foi possivel cadastrar o email, pois o email já esta vinculado a uma conta!");}

        registerUserOutPort.save(userDomain);
    }
}
