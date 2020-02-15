package com.example.tp1.demo12.service.impl;

import com.example.tp1.demo12.bean.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tp1.demo12.bean.Emprunt;
import com.example.tp1.demo12.bean.Livre;
import com.example.tp1.demo12.repository.EmrpuntRepo;
import com.example.tp1.demo12.service.facade.ClientService;
import com.example.tp1.demo12.service.facade.EmpruntService;
import com.example.tp1.demo12.service.facade.LivreService;
import java.util.ArrayList;
import java.util.Date;

@Service
public class EmpruntServiceImpl implements EmpruntService {

    @Autowired
    private EmrpuntRepo empruntRepo;
    @Autowired
    private ClientService clientService;
    @Autowired
    private LivreService livreService;

    @Override
    public Emprunt findByReference(String ref) {
        return empruntRepo.findByReference(ref);
    }

    @Override
    public List<Emprunt> findAll() {
        return empruntRepo.findAll();
    }

    @Override
    public int save(Emprunt emprunt) {
//        Emprunt cl1 = findByClientCne(emprunt.getClient());
//        List<Emprunt> cl2 = findByLivreIsbn(emprunt.getLivre());
        Client cl = clientService.findByCne(emprunt.getClient().getCne());
        Livre li = livreService.findByIsbn(emprunt.getLivre().getIsbn());
        if (cl == null) {
            return -1; // ==null
        } else if (emprunt.getClient().getPointDeFiabilite() > 5) {
            return -2;
        } else if (li == null) {
            return -3;
        }
         else {
            emprunt.setClient(cl);
            emprunt.setLivre(li);
            emprunt.setDateEmprunt(new Date());
            emprunt.setDateRetour(null);
            empruntRepo.save(emprunt);
            return 1;
        }
    }
//public float DateExemple(Date devant,Date apres){
//   SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//    
//        Date dateAvant = devant;
//       Date dateApres = apres;
//       long diff = dateApres.getTime() - dateAvant.getTime();
//       float res = (diff / (1000*60*60*24));
//  
//            return res;
//   }
//public List<Emprunt> find(Long id){
//    List<Emprunt> emFound = new ArrayList<>();
//    for(int i=0;i<findAll().size();i++){
//        Emprunt em = findAll().get(i);
//        if(em.getId()==id) emFound.add(em);
//    }
//    return emFound;
//
//}

    @Override
    public int restituerLivre(String ref) {
        Emprunt empFound = empruntRepo.findByReference(ref);
        if (empFound == null) {
            return -1;
        } else if (empFound.getDateRetour() != null) {
            return -2;
        } else {
            empFound.setDateRetour(new Date());
            empFound.getLivre().setNbrExmplaire(empFound.getLivre().getNbrExmplaire() + 1);
//            empFound.getClient().setPointDeFiabilite(empFound.getClient().getPointDeFiabilite() - 2);
            empruntRepo.save(empFound);
            return 1;
        }
    }

    @Override
    public List<Emprunt> EmpruntsNonRestitue() {
        List<Emprunt> nonRestitue = new ArrayList<>();
        for (int i = 0; i < findAll().size(); i++) {
            Emprunt em = findAll().get(i);
            if (em.getDateRetour() == null) {
                nonRestitue.add(em);
            }
        }
        return nonRestitue;
    }

    @Override
    public List<Emprunt> findByLivreIsbn(Livre livre) {
        return empruntRepo.findByLivreIsbn(livre);
    }

    @Override
    public Emprunt findByClientCne(Client client) {
        return empruntRepo.findByClientCne(client);
    }

}
