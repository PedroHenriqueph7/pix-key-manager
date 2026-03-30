package org.estudos.Pix_Key_Manager.adapter.out.persistence;

import org.estudos.Pix_Key_Manager.adapter.out.persistence.entities.UserEntity;
import org.estudos.Pix_Key_Manager.adapter.out.persistence.mappers.RegisterUserMapper;
import org.estudos.Pix_Key_Manager.adapter.out.persistence.repository.JpaUserRepository;
import org.estudos.Pix_Key_Manager.application.domain.user.UserDomain;
import org.estudos.Pix_Key_Manager.application.ports.out.RegisterUserOutPort;

public class RegisterUserAdapter implements RegisterUserOutPort {

    private final JpaUserRepository repository;

    public RegisterUserAdapter(JpaUserRepository repository) {
        this.repository = repository;
    }


    @Override
    public void save(UserDomain userDomain) {

        UserEntity entity = RegisterUserMapper.toEntity(userDomain);
        repository.save(entity);
    }

    @Override
    public boolean exitsByCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }

    @Override
    public boolean exitsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
