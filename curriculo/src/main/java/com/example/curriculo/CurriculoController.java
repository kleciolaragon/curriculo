package com.example.curriculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.curriculo.*;

import java.util.List;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {

    @Autowired
    private CurriculoService service;

    // Listar todos os currículos
    @GetMapping
    public List<Curriculo> listarTodos() {
        return service.listarTodos();
    }

    // Buscar um currículo pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Curriculo> buscarPorId(@PathVariable Long id) {
        try {
            Curriculo curriculo = service.buscarPorId(id);
            return ResponseEntity.ok(curriculo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Adicionar um novo currículo
    @PostMapping
    public Curriculo adicionar(@RequestBody Curriculo curriculo) {
        return service.salvar(curriculo);
    }

    // Atualizar um currículo existente
    @PutMapping("/{id}")
    public ResponseEntity<Curriculo> atualizar(@PathVariable Long id, @RequestBody Curriculo curriculo) {
        if (!service.listarTodos().contains(curriculo)) {
            return ResponseEntity.notFound().build();
        }
        curriculo.setId(id);
        return ResponseEntity.ok(service.salvar(curriculo));
    }

    // Deletar um currículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
