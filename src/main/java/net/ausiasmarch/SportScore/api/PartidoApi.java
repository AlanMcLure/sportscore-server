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

import net.ausiasmarch.SportScore.entity.PartidoEntity;
import net.ausiasmarch.SportScore.service.PartidoService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/partido")
public class PartidoApi {

    @Autowired
    PartidoService oPartidoService;

    @GetMapping("/{id}")
    public ResponseEntity<PartidoEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oPartidoService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody PartidoEntity oPartidoEntity) {
        return ResponseEntity.ok(oPartidoService.create(oPartidoEntity));
    }

    @PutMapping("")
    public ResponseEntity<PartidoEntity> update(@RequestBody PartidoEntity oPartidoEntity) {
        return ResponseEntity.ok(oPartidoService.update(oPartidoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oPartidoService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<PartidoEntity>> getPage(Pageable oPageable,
            @RequestParam(value = "equipo", defaultValue = "0", required = false) Long equipoId) {
        return ResponseEntity.ok(oPartidoService.getPage(oPageable, equipoId));
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(oPartidoService.populate(amount));
    }

    @DeleteMapping("/empty")
    public ResponseEntity<Long> empty() {
        return ResponseEntity.ok(oPartidoService.empty());
    }
}