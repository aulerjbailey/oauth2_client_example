package oauth2.client.example.entity;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "[dbo].[person]")
public class Person {

    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPerson")
    private int idPerson;

    @Getter @Setter
    @Column(name = "name")
    private String name;

    @Getter @Setter
    @Column(name = "lastname")
    private String lastname;

    @Getter @Setter
    @Column(name = "birth")
    private String birth;

    @Getter @Setter
    @Column(name = "sex")
    private String sex;

}
