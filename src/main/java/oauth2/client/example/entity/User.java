package oauth2.client.example.entity;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "[dbo].[user]")
public class User {

    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUser")
    private int idUser;

    @Getter @Setter
    @Column(name = "email")
    private String email;

    @Getter @Setter
    @Column(name = "picture")
    private String picture;

    @Getter @Setter
    @OneToOne()
    @JoinColumn(name = "idPerson")
    private Person idPerson;

    @Getter @Setter
    @OneToOne()
    @JoinColumn(name = "idArea")
    private Area idArea;

    @Getter @Setter
    @Column(name = "created")
    private String created;

    @Getter @Setter
    @Column(name = "updated")
    private String updated;

}
