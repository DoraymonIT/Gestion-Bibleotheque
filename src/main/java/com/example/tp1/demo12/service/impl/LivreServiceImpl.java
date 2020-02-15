/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tp1.demo12.service.impl;

import com.example.tp1.demo12.bean.Livre;
import com.example.tp1.demo12.repository.LivreRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dell
 */
@Service
public class LivreServiceImpl implements com.example.tp1.demo12.service.facade.LivreService {

    @Autowired
    private LivreRepo livreRepo;

    @Override
    public List<Livre> findAll() {
        return livreRepo.findAll();
    }

    @Override
    public int save(Livre livre) {
        Livre livreFound = findByIsbn(livre.getIsbn());
        if (livreFound == null) {
            return -1;
        } else if (livre.getTitre().equalsIgnoreCase("") || livre.getIsbn().equalsIgnoreCase("")) {
            return -2;
        } else if (livre.getNmbrJourEmprunt() <= 0 || livre.getNbrExmplaire() <= 0) {
            return -3;
        } else {
            livreRepo.save(livre);
        }
        return 1;
    }

    @Override
    public List<Livre> findByNbrExmplaire(int NbrExemplaire) {
        return livreRepo.findByNbrExmplaire(NbrExemplaire);
    }

    @Override
    public Livre findByIsbn(String isbn) {
        return livreRepo.findByIsbn(isbn);
    }

}
