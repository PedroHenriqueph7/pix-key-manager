package org.estudos.Pix_Key_Manager.infracstruture.config;


import org.estudos.Pix_Key_Manager.application.ports.in.RegisterUserInPort;
import org.estudos.Pix_Key_Manager.application.ports.out.RegisterUserOutPort;
import org.estudos.Pix_Key_Manager.application.usecases.RegisterUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public RegisterUserInPort registerUserInPort(RegisterUserOutPort registerUserOutPort) {

        return new RegisterUserUseCase(registerUserOutPort);
    }
}
