package mx.bbva.site.controller;

import mx.bbva.site.entity.ScoreCollaborator;
import mx.bbva.site.entity.dto.ScoreCollaboratorDTO;
import mx.bbva.site.service.ScoreCollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.lang.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/oauth2_client_example/scoreCollaborator")
public class ScoreCollaboratorController {

    @Autowired
    private ScoreCollaboratorService scoreCollaboratorService;

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public String save(@RequestBody ScoreCollaborator scoreCollaborator){
        return scoreCollaboratorService.save(scoreCollaborator);
    }

}
