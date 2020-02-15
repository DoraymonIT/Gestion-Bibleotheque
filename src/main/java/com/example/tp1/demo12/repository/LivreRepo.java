/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tp1.demo12.repository;

import com.example.tp1.demo12.bean.Livre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
public interface LivreRepo extends JpaRepository<Livre, Long> {

    public List<Livre> findByNbrExmplaire(int NbrExemplaire);

    public Livre findByIsbn(String isbn);
}
