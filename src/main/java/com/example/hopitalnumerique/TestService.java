package com.example.hopitalnumerique;

import com.example.hopitalnumerique.Model.Salle;
import com.example.hopitalnumerique.Repository.Interfaces.ISalleRepository;
import com.example.hopitalnumerique.Repository.SalleRepository;
import com.example.hopitalnumerique.Service.SalleService;

public class TestService {

    public static void main(String[] args) {
        ISalleRepository salleRepository = new SalleRepository();
        SalleService salleService = new SalleService(salleRepository);
        try{
        salleService.create(new Salle("test2", 130));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
