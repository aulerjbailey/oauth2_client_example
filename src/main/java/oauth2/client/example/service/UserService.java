package oauth2.client.example.service;

import oauth2.client.example.entity.User;
import oauth2.client.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

    public String getUserByToken(String token, String email){

        StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("sp_getUserByToken");

        procedureQuery.registerStoredProcedureParameter("p_token", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("p_emailSession", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("out_response", String.class, ParameterMode.OUT);

        procedureQuery.setParameter( "p_token", token );
        procedureQuery.setParameter( "p_emailSession", email );

        procedureQuery.execute();

        return (String) procedureQuery.getOutputParameterValue("out_response");
    }

    public void savePictureByEmail(String email, String picture){

        StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("sp_savePictureByEmail");

        procedureQuery.registerStoredProcedureParameter("p_email", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("p_picture", String.class, ParameterMode.IN);

        procedureQuery.setParameter( "p_email", email );
        procedureQuery.setParameter( "p_picture", picture );

        procedureQuery.execute();
    }
}
