package com.example.tp1.demo12.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp1.demo12.bean.Client;
import com.example.tp1.demo12.service.facade.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("bibleo/client")
@RestController
public class ClientRest {

    @Autowired
    private ClientService clientService;

    @GetMapping("cne/{CNE}")
    public Client findByCne(@PathVariable String CNE) {
        return clientService.findByCne(CNE);
    }

    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("nom/{nom}")
    public List<Client> findByNom(@PathVariable String nom) {
        return clientService.findByNom(nom);
    }

    @GetMapping("/NonFiable")
    public List<Client> clientNonFiable() {
        return clientService.clientNonFiable();
    }

    @GetMapping("pointFiablite/{x}")
    public List<Client> findBypointDeFiabiliteLessThan(int x) {
        return clientService.findBypointDeFiabiliteLessThan(x);
    }

    @PostMapping("/")
    public int save(@RequestBody Client client) {
        return clientService.save(client);
    }

}
