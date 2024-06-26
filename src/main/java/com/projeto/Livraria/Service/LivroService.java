package com.projeto.Livraria.Service;

import com.projeto.Livraria.Entities.LivroEntity;
import com.projeto.Livraria.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroEntity create(LivroEntity obj) {
        return livroRepository.save(obj);
    }

    public void delete(Long id) {
        livroRepository.deleteById(id);
    }

    public LivroEntity getId(Long id) {
        Optional<LivroEntity> obj = livroRepository.findById(id);
        return obj.get();
    }

    public List<LivroEntity> getAll() {
        return livroRepository.findAll();
    }

    public LivroEntity update(LivroEntity obj) {
        Optional<LivroEntity> newObj = livroRepository.findById(obj.getIdLivro());
        updateLivro(newObj, obj);
        return livroRepository.save(newObj.get());
    }

    private void updateLivro(Optional<LivroEntity> newObj, LivroEntity obj) {
        newObj.get().setNome(obj.getNome());
    }
}
