package mx.bbva.site.controller;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import mx.bbva.site.entity.User;
import mx.bbva.site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/oauth2_client_example/users/getUserByEmail/{email}")
    @Transactional()
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/oauth2_client_example/users/getUserByToken/{token}/{email}")
    @Transactional()
    public String getUserByToken(@PathVariable String token, @PathVariable String email){
        return userService.getUserByToken(token, email);
    }

    @GetMapping("/noauth")
    public ResponseEntity<?> noAuth() {
        Map<String, String> body = new HashMap<>();
        body.put("message", "unauthorized");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
    }

    @GetMapping("/login")
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect("/oauth2/authorization/google");
    }


}
