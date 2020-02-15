package com.example.tp1.demo12.service.facade;

import com.example.tp1.demo12.bean.Client;
import java.util.List;

import com.example.tp1.demo12.bean.Emprunt;
import com.example.tp1.demo12.bean.Livre;
import java.util.Optional;

public interface EmpruntService {

    public Emprunt findByReference(String ref);


    public List<Emprunt> findAll();

    public List<Emprunt> findByLivreIsbn(Livre livre);

    public Emprunt findByClientCne(Client client);

    public int save(Emprunt emprunt);

    public int restituerLivre(String ref);

    public List<Emprunt> EmpruntsNonRestitue();

}
