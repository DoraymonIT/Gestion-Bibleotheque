/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tp1.demo12.ws.rest;

import com.example.tp1.demo12.bean.Livre;
import com.example.tp1.demo12.service.facade.LivreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("bibleo/livre")
@RestController
public class LivreRest {

    @Autowired
    private LivreService livreService;

    @GetMapping("/")
    public List<Livre> findAll() {
        return livreService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Livre livre) {
        return livreService.save(livre);
    }

    @GetMapping("nbrEx/{NbrExemplaire}")
    public List<Livre> findByNbrExmplaire(@PathVariable int NbrExemplaire) {
        return livreService.findByNbrExmplaire(NbrExemplaire);
    }

    @GetMapping("isbn/{isbn}")
    public Livre findByIsbn(@PathVariable String isbn) {
        return livreService.findByIsbn(isbn);
    }

}
