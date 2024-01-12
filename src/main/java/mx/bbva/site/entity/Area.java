package mx.bbva.site.entity;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "area")
public class Area {

    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idArea")
    private int idArea;

    @Getter @Setter
    @Column(name = "nameArea")
    private String nameArea;

    @OneToOne()
    @JoinColumn(name = "idDepartment")
    private Department idDepartment;

    @Getter @Setter
    @Column(name = "created")
    private String created;

    @Getter @Setter
    @Column(name = "updated")
    private String updated;
}
