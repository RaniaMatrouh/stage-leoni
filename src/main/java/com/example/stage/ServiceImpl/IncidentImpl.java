package com.example.stage.ServiceImpl;

import com.example.stage.Repository.IncidentRepository;
import com.example.stage.ServiceInterface.IIncident;
import com.example.stage.entites.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IncidentImpl implements IIncident {
@Autowired
IncidentRepository incidentRepository;

    @Override
    public Incident addIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    @Override
    public Incident updateIncident(Integer id, Incident incident) {
        Optional<Incident> existingIncident = incidentRepository.findById(id);
        if (existingIncident.isPresent()) {
            Incident updatedIncident = existingIncident.get();
            updatedIncident.setType(incident.getType());
            updatedIncident.setDescription(incident.getDescription());
            updatedIncident.setDate(incident.getDate());
            updatedIncident.setStatus(incident.getStatus());
            updatedIncident.setNotifications(incident.getNotifications());
            updatedIncident.setUser(incident.getUser());
            return incidentRepository.save(updatedIncident);
        } else {
            throw new IllegalArgumentException("Incident with id " + id + " not found");
        }
    }

    @Override
    public void deleteIncident(Integer id) {
        incidentRepository.deleteById(id);


    }

    @Override
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    @Override
    public List<Incident> getIncidentsByStatus(String status) {
        return incidentRepository.findByStatus(status);
    }


}
