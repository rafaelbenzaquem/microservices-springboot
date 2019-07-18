package academy.devdojo.core.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ApplicationUser implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull(message = "O campo 'username' é requerido")
    @Column(nullable = false)
    private String username;
    @NotNull(message = "O campo 'password' é requerido")
    @Column(nullable = false)
    private String password;
    @NotNull(message = "O campo 'role' é requerido")
    @Column(nullable = false)
    private String role = "USER";

    public ApplicationUser(@NotNull ApplicationUser applicationUser) {
        this.id=applicationUser.getId();
        this.username=applicationUser.getUsername();
        this.password=applicationUser.getPassword();
        this.role=applicationUser.getRole();
    }
}
