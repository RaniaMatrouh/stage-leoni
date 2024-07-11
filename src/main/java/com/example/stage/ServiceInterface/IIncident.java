package com.example.stage.ServiceInterface;

import com.example.stage.entites.Incident;

import java.util.List;

public interface IIncident {
    Incident addIncident(Incident incident);
    Incident updateIncident(Integer id, Incident incident);
    void deleteIncident(Integer id);
    List<Incident> getAllIncidents();
    List<Incident> getIncidentsByStatus(String status);
}
