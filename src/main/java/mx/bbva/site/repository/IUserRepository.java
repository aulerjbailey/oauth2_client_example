package mx.bbva.site.repository;

import mx.bbva.site.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

    //@Procedure(procedureName = "sp_getUserByEmail")
    public User getUserByEmail(String email);

}
