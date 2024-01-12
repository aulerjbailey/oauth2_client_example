package mx.bbva.site.controller;

import mx.bbva.site.entity.TokenVerified;
import mx.bbva.site.service.TokenVerifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/oauth2_client_example/tokenVerified")
public class TokenVerifiedController {

    @Autowired
    private TokenVerifiedService tokenVerifiedService;

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public String save(@RequestBody TokenVerified tokenVerified){
        return tokenVerifiedService.save(tokenVerified);
    }

}
