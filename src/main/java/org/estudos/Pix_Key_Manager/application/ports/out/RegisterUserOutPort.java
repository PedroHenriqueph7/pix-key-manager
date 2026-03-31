package org.estudos.Pix_Key_Manager.application.ports.out;

import org.estudos.Pix_Key_Manager.application.domain.user.UserDomain;

public interface RegisterUserOutPort {
    void save(UserDomain userDomain);

    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
