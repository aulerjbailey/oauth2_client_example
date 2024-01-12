package mx.bbva.site.entity.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreCollaboratorDTO implements Serializable {

    @Getter @Setter
    private int idScoreCollaborator;

    @Getter @Setter
    private String emailEvaluator;

    @Getter @Setter
    private String emailEvaluated;

    @Getter @Setter
    private String option;

    @Getter @Setter
    private String comment;

    @Getter @Setter
    private int score;

    @Getter @Setter
    private String created;

}
