package com.sistema.mercadoOnline.Database.Model;

import com.sistema.mercadoOnline.Database.Model.Enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String login;

    @Column(nullable = true)
    private String senha;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) return List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_CLIENTE"),
                new SimpleGrantedAuthority("ROLE_VIP"));

        if (this.role == UserRole.VIP) return List.of(
                new SimpleGrantedAuthority("ROLE_VIP"),
                new SimpleGrantedAuthority("ROLE_CLIENTE"));

        else return List.of(
                new SimpleGrantedAuthority("ROLE_CLIENTE"));
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }
}
