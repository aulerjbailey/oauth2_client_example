package oauth2.client.example.service;

import oauth2.client.example.entity.TokenVerified;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Service
public class TokenVerifiedService {
    @PersistenceContext
    private EntityManager entityManager;

    public String save(TokenVerified tokenVerified){

        tokenVerified.setGeneratedFor("scoreCollaborator");

        StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("sp_saveToken");

        procedureQuery.registerStoredProcedureParameter("p_emailUser", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("p_token", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("p_generatedFor", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("out_response", String.class, ParameterMode.OUT);

        procedureQuery.setParameter("p_emailUser", tokenVerified.getEmailUser())
                .setParameter("p_token", tokenVerified.getToken())
                .setParameter("p_generatedFor", tokenVerified.getGeneratedFor());

        procedureQuery.execute();
        return (String) procedureQuery.getOutputParameterValue("out_response");
    }

}
