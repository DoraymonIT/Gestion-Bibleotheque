package com.example.tp1.demo12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tp1.demo12.bean.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    public Client findByCne(String CNE);

    public List<Client> findByNom(String nom);

    public List<Client> findBypointDeFiabiliteLessThan(int x);

}
