package oauth2.client.example.controller;

import oauth2.client.example.entity.ScoreCollaborator;
import oauth2.client.example.service.ScoreCollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
