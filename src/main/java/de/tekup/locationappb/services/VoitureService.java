package de.tekup.locationappb.services;


import de.tekup.locationappb.entites.Voiture;
import de.tekup.locationappb.repositories.VoitureRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VoitureService {    
    private VoitureRepository voitureRepository;

    public Voiture insertIntoDB(Voiture voiture){
        return voitureRepository.save(voiture);
    }

    public List<Voiture> getAllVoitures(){
        return (List<Voiture>) voitureRepository.findAll();
    }

    public Voiture getVoitureById(int id){
        return voitureRepository
                .findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Voiture ID not Found"));
    }
    //@PostConstruct
    private void addVoituresToEmptyDB(){
        if(voitureRepository.count()==0){
            insertIntoDB(new Voiture("00Tunis0001",
                    LocalDate.of(2022,01,03),"GOLF 7"));
            insertIntoDB(new Voiture("00Tunis0002",
                    LocalDate.of(2022,01,04),"POLO 8"));
        }

    }

    public Page<Voiture> getPageVoitures(Pageable pageable){
                return voitureRepository.findAll(pageable);
    }
}
