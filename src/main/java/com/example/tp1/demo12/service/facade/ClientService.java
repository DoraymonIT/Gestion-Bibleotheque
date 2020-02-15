package com.example.tp1.demo12.service.facade;

import java.util.List;

import com.example.tp1.demo12.bean.Client;

public interface ClientService {

    public Client findByCne(String CNE);

    public List<Client> findAll();

    public List<Client> findByNom(String nom);

    public List<Client> clientNonFiable();

    public List<Client> findBypointDeFiabiliteLessThan(int x);
    
    public int save(Client client);

}
