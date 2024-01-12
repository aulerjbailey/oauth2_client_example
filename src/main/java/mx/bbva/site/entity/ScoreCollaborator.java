package mx.bbva.site.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "[dbo].[scoreCollaborator]")
public class ScoreCollaborator {

    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idScoreCollaborator")
    private int idScoreCollaborator;

    @Getter @Setter
    @Column(name = "emailEvaluator")
    private String emailEvaluator;

    @Getter @Setter
    @Column(name = "emailEvaluated")
    private String emailEvaluated;

    @Getter @Setter
    @Column(name = "token")
    private String token;

    @Getter @Setter
    @Column(name = "optionValue")
    private String optionValue;

    @Getter @Setter
    @Column(name = "comment")
    private String comment;

    @Getter @Setter
    @Column(name = "score")
    private int score;

    @Getter @Setter
    @Column(name = "created")
    private String created;

    @Getter @Setter
    @Column(name = "tokenGenerated")
    private String tokenGenerated;

}
