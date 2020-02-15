package com.example.tp1.demo12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp1.demo12.bean.Client;
import com.example.tp1.demo12.repository.ClientRepo;
import com.example.tp1.demo12.service.facade.ClientService;
import java.util.ArrayList;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepo clientRepo;

    @Override
    public Client findByCne(String CNE) {
        return clientRepo.findByCne(CNE);
    }

    @Override
    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    @Override
    public List<Client> findByNom(String nom) {
        return clientRepo.findByNom(nom);
    }

    @Override
    public List<Client> clientNonFiable() {
        List<Client> clientNonFiable = new ArrayList<>();
        for(int i=0;i<findAll().size();i++){
          Client cl = findAll().get(i);
          if(cl.getPointDeFiabilite()<5)
              clientNonFiable.add(cl); 
        }
          return clientNonFiable;
    }

    @Override
    public List<Client> findBypointDeFiabiliteLessThan(int x) {
        return clientRepo.findBypointDeFiabiliteLessThan(x);
    }

    @Override
    public int save(Client client) {
        Client clFound = findByCne(client.getCne());
        if(clFound != null) return -1;
        else if(client.getNom().equalsIgnoreCase("") || client.getPrenom().equalsIgnoreCase("")) return -2;
        else if(client.getDateDeNaissance()==null) return -3;
        else client.setPointDeFiabilite(20);
            clientRepo.save(client);
             return 1;
    }

}
