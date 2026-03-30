package org.estudos.Pix_Key_Manager.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import org.estudos.Pix_Key_Manager.application.domain.user.UserType;

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

    @Column(name = "quantity_pix_key", nullable = false)
    private int quantityPixKey;

}
