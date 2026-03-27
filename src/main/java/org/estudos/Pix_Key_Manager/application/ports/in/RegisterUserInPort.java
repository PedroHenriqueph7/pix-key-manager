package org.estudos.Pix_Key_Manager.application.ports.in;

import org.estudos.Pix_Key_Manager.application.domain.user.UserDomain;

public interface RegisterUserInPort {

    void execute(UserDomain userDomain);
}
