package mx.bbva.site.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tokenVerified")
public class TokenVerified implements Serializable {

    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTokenVerified")
    private int idTokenVerified;

    @Getter @Setter
    @Column(name = "emailUser")
    private String emailUser;

    @Getter @Setter
    @Column(name = "token")
    private String token;

    @Getter @Setter
    @Column(name = "generatedFor")
    private String generatedFor;

    @Getter @Setter
    @Column(name = "created")
    private String created;


}
