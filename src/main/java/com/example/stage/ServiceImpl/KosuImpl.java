package com.example.stage.ServiceImpl;

import com.example.stage.Repository.KosuRepository;
import com.example.stage.ServiceInterface.IKosu;
import com.example.stage.entites.Incident;
import com.example.stage.entites.Kosu;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KosuImpl implements IKosu {

    @Autowired
    KosuRepository kosuRepository;

    @Override
    public Kosu addKosu(Kosu kosu) {
        calculateKosuEquivalent(kosu); // Calcul automatique de kosuEquivalent
        return kosuRepository.save(kosu);
    }

    private void calculateKosuEquivalent(Kosu kosu) {
        if (kosu.getEffectifPresent() != null && kosu.getTempsNetDeTravail() != null && kosu.getCoefficient() != 0 && kosu.getNok() != 0) {
            kosu.setKosuEquivalent((kosu.getEffectifPresent() * kosu.getTempsNetDeTravail()) / (kosu.getCoefficient() * kosu.getNok()));
        }
    }

    @Override
    public Kosu updateKosu(Integer id, Kosu updatedKosu) {
        Kosu existingKosu = kosuRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kosu not found with id: " + id));

        // Mise à jour des champs modifiables
        existingKosu.setHoraire(updatedKosu.getHoraire());
        existingKosu.setSerieReference(updatedKosu.getSerieReference());
        existingKosu.setEffectifPresent(updatedKosu.getEffectifPresent());
        existingKosu.setTempsNetDeTravail(updatedKosu.getTempsNetDeTravail());
        existingKosu.setNok(updatedKosu.getNok());
        existingKosu.setCoefficient(updatedKosu.getCoefficient());

        // Calcul du nouveau kosuEquivalent
        calculateKosuEquivalent(existingKosu);

        // Sauvegarde de l'entité mise à jour
        return kosuRepository.save(existingKosu);
    }
    @Override
    public void deleteKosu(Integer id) {
        kosuRepository.deleteById(id);
    }

    @Override
    public List<Kosu> getAllKosu() {
        return kosuRepository.findAll();
    }

}
