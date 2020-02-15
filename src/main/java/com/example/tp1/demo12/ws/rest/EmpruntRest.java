package com.example.tp1.demo12.ws.rest;

import com.example.tp1.demo12.bean.Client;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp1.demo12.bean.Emprunt;
import com.example.tp1.demo12.bean.Livre;
import com.example.tp1.demo12.service.facade.EmpruntService;

@RequestMapping("bibleo/emprunt")
@RestController
public class EmpruntRest {

	@Autowired
	private EmpruntService empruntRest;
    @GetMapping("Reference/{ref}")
    public Emprunt findByReference(@PathVariable String ref) {
        return empruntRest.findByReference(ref);
    }
    @GetMapping("/")
    public List<Emprunt> findAll() {
        return empruntRest.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Emprunt emprunt) {
        return empruntRest.save(emprunt);
    }
    @PutMapping("ref/{ref}")
    public int restituerLivre(@PathVariable String ref) {
        return empruntRest.restituerLivre(ref);
    }
    @GetMapping("/NonRestitue")
    public List<Emprunt> EmpruntsNonRestitue() {
        return empruntRest.EmpruntsNonRestitue();
    }
//
//    public List<Emprunt> findByLivreIsbn(Livre livre) {
//        return empruntRest.findByLivreIsbn(livre);
//    }
//
//    public Emprunt findByClientCne(Client client) {
//        return empruntRest.findByClientCne(client);
//    }

    

	

}
