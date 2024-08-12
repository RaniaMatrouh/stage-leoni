package com.example.stage.Controllers;

import com.example.stage.ServiceImpl.EmailSenderService;
import com.example.stage.ServiceInterface.IIncident;
import com.example.stage.entites.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Incident")

public class IncidentController {
    @Autowired
    IIncident incidentService;


    @PostMapping("/add")
    public Incident addIncident(@RequestBody Incident incident) {
        return incidentService.addIncident(incident);
    }

    @PutMapping("/update/{id}")
    public Incident updateIncident(@PathVariable Integer id, @RequestBody Incident incident) {
        return incidentService.updateIncident(id, incident);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIncident(@PathVariable Integer id) {
        incidentService.deleteIncident(id);
    }

    @GetMapping("/all")
    public List<Incident> getAllIncidents() {
        return incidentService.getAllIncidents();
    }
  @GetMapping("/status/{status}")

    public List<Incident> getIncidentsByStatus(String status) {
        return incidentService.getIncidentsByStatus(status);
    }
}
