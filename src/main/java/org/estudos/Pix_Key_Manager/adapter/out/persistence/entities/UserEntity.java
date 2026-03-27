package org.estudos.Pix_Key_Manager.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import org.estudos.Pix_Key_Manager.application.domain.pix.PixKeyDomain;
import org.estudos.Pix_Key_Manager.application.domain.user.UserType;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @EqualsAndHashCode.Include
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "user_type")
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @OneToMany
    @JoinColumn(name = "pix_key_list", nullable = false)
    PixKeyDomain pixKey;

}
