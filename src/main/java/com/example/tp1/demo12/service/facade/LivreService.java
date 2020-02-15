/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tp1.demo12.service.facade;

import com.example.tp1.demo12.bean.Livre;
import java.util.List;

/**
 *
 * @author dell
 */
public interface LivreService {

    public List<Livre> findAll();

    public int save(Livre livre);

    public List<Livre> findByNbrExmplaire(int NbrExemplaire);

    public Livre findByIsbn(String isbn);
}
