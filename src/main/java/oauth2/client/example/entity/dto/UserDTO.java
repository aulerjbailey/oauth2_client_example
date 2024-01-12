package oauth2.client.example.entity.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    @Getter @Setter
    private int idPerson;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String lastname;

    @Getter @Setter
    private String birth;

    @Getter @Setter
    private String sex;

    @Getter @Setter
    private int idUser;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String provider;

    @Getter @Setter
    private String connected;

    @Getter @Setter
    private String created;

    @Getter @Setter
    private String nameArea;

    @Getter @Setter
    private String nameDepartment;
}
