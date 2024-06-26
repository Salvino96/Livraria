package com.projeto.Livraria.Controller;

import com.projeto.Livraria.Entities.LivroEntity;
import com.projeto.Livraria.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroEntity> create(@RequestBody LivroEntity obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(livroService.getId(id));
    }

    @GetMapping
    public ResponseEntity<List<LivroEntity>> getAll() {
        return ResponseEntity.ok().body(livroService.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LivroEntity> update(@PathVariable Long id, @RequestBody LivroEntity obj) {
        obj.setIdLivro(id);
        return ResponseEntity.ok().body(livroService.update(obj));
    }
}
