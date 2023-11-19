package net.ausiasmarch.SportScore.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.SportScore.entity.JugadorEntity;
import net.ausiasmarch.SportScore.service.JugadorService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/jugador")
public class JugadorApi {

    @Autowired
    JugadorService oJugadorService;

    @GetMapping("/{id}")
    public ResponseEntity<JugadorEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oJugadorService.get(id));
    }

    @GetMapping("/byUsername/{username}")
    public ResponseEntity<JugadorEntity> get(@PathVariable("username") String username) {
        return ResponseEntity.ok(oJugadorService.getByUsername(username));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody JugadorEntity oJugadorEntity) {
        return ResponseEntity.ok(oJugadorService.create(oJugadorEntity));
    }

    @PutMapping("")
    public ResponseEntity<JugadorEntity> update(@RequestBody JugadorEntity oJugadorEntity) {
        return ResponseEntity.ok(oJugadorService.update(oJugadorEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oJugadorService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<JugadorEntity>> getPage(Pageable oPageable,
            @RequestParam(value = "equipo", defaultValue = "0", required = false) Long equipoId) {
        return ResponseEntity.ok(oJugadorService.getPage(oPageable, equipoId));
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(oJugadorService.populate(amount));
    }

    @DeleteMapping("/empty")
    public ResponseEntity<Long> empty() {
        return ResponseEntity.ok(oJugadorService.empty());
    }

}
