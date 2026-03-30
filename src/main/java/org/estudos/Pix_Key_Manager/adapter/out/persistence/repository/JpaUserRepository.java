package org.estudos.Pix_Key_Manager.adapter.out.persistence.repository;

import org.estudos.Pix_Key_Manager.adapter.out.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);

}
