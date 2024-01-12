package mx.bbva.site.service;

import mx.bbva.site.entity.ScoreCollaborator;
import mx.bbva.site.repository.IScoreCollaboratorRepository;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.sql.Types;

@Service
public class ScoreCollaboratorService {

    @Autowired
    private IScoreCollaboratorRepository scoreCollaboratorRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public String save(ScoreCollaborator scoreCollaborator){

        StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("sp_saveScoreCollaborator");

        procedureQuery.registerStoredProcedureParameter("p_emailEvaluator", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("p_emailEvaluated", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("p_token", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("p_optionValue", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("p_comment", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("p_score", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("out_response", String.class, ParameterMode.OUT);

        ((org.hibernate.procedure.ParameterRegistration) procedureQuery.getParameter("p_optionValue")).enablePassingNulls(true);
        ((org.hibernate.procedure.ParameterRegistration) procedureQuery.getParameter("p_comment")).enablePassingNulls(true);

        procedureQuery.setParameter("p_emailEvaluator", scoreCollaborator.getEmailEvaluator())
                .setParameter("p_emailEvaluated", scoreCollaborator.getEmailEvaluated())
                .setParameter("p_token", scoreCollaborator.getToken())
                .setParameter("p_optionValue", scoreCollaborator.getOptionValue())
                .setParameter("p_comment", scoreCollaborator.getComment())
                .setParameter("p_score", scoreCollaborator.getScore());

        procedureQuery.execute();
        return (String) procedureQuery.getOutputParameterValue("out_response");
    }
}
