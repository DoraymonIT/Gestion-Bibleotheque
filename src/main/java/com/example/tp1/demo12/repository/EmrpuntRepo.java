package com.example.tp1.demo12.repository;

import com.example.tp1.demo12.bean.Client;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tp1.demo12.bean.Emprunt;
import com.example.tp1.demo12.bean.Livre;
import java.util.Optional;

@Repository
public interface EmrpuntRepo extends JpaRepository<Emprunt, Long> {

    public Emprunt findByReference(String ref);

    public List<Emprunt> findByLivreIsbn(Livre livre);

    public Emprunt findByClientCne(Client client);
    

}
