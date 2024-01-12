package oauth2.client.example.entity;

import javax.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {

    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idDepartment")
    private int idDepartment;

    @Getter @Setter
    @Column(name = "nameDepartment")
    private String nameDepartment;

    @Getter @Setter
    @Column(name = "created")
    private String created;

    @Getter @Setter
    @Column(name = "updated")
    private String updated;

}
