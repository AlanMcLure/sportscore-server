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

import net.ausiasmarch.SportScore.entity.EquipoEntity;
import net.ausiasmarch.SportScore.service.EquipoService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/equipo")
public class EquipoApi {
     
    @Autowired
    EquipoService oEquipoService;


    @GetMapping("/{id}")
    public ResponseEntity<EquipoEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oEquipoService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody EquipoEntity oEquipoEntity) {
        return ResponseEntity.ok(oEquipoService.create(oEquipoEntity));
    }

    @PutMapping("")
    public ResponseEntity<EquipoEntity> update(@RequestBody EquipoEntity oEquipoEntity) {
        return ResponseEntity.ok(oEquipoService.update(oEquipoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oEquipoService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<EquipoEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oEquipoService.getPage(oPageable));
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(oEquipoService.populate(amount));
    }

    @DeleteMapping("/empty")
    public ResponseEntity<Long> empty() {
        return ResponseEntity.ok(oEquipoService.empty());
    }

}
