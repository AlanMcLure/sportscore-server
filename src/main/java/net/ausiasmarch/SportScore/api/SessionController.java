package net.ausiasmarch.SportScore.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.SportScore.bean.JugadorBean;
import net.ausiasmarch.SportScore.service.SessionService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/session")
public class SessionController {
    
    @Autowired
    SessionService oSessionService;

    @PostMapping()
    public ResponseEntity<String> login(@RequestBody JugadorBean oJUgadorBean) {
        return ResponseEntity.ok("\"" + oSessionService.login(oJUgadorBean) + "\"");
    }

}
