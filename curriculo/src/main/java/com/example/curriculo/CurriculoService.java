package com.example.curriculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curriculo.*;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository repository;

    // Listar todos os currículos
    public List<Curriculo> listarTodos() {
        return repository.findAll();
    }

    // Buscar um currículo pelo ID
    public Curriculo buscarPorId(Long id) {
        Optional<Curriculo> curriculo = repository.findById(id);
        if(curriculo.isPresent()) {
            return curriculo.get();
        } else {
            throw new RuntimeException("Currículo não encontrado para o ID: " + id);
        }
    }

    // Salvar ou atualizar um currículo
    public Curriculo salvar(Curriculo curriculo) {
        return repository.save(curriculo);
    }

    // Deletar um currículo
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

