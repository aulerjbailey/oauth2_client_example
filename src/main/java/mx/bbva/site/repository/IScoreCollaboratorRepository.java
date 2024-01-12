package mx.bbva.site.repository;

import mx.bbva.site.entity.ScoreCollaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface IScoreCollaboratorRepository extends JpaRepository<ScoreCollaborator, Long> {

    @Procedure(procedureName = "sp_saveScoreCollaborator", outputParameterName = "out_response")
    public String sp_saveScoreCollaborator(
            @Param("p_emailEvaluator") String p_emailEvaluator,
            @Param("p_emailEvaluated") String p_emailEvaluated,
            @Param("p_optionValue") String p_optionValue,
            @Param("p_comment") String p_comment,
            @Param("p_score") int p_score
    );

}
