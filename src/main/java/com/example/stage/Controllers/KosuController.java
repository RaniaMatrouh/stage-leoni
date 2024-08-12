package com.example.stage.Controllers;

import com.example.stage.ServiceInterface.IKosu;
import com.example.stage.entites.Kosu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Kosu")

public class KosuController {
    @Autowired
    IKosu kosuService;
@PostMapping("/addKosu")

    public Kosu addKosu(@RequestBody Kosu kosu) {
        return kosuService.addKosu(kosu);
    }

    @PutMapping("/update/{id}")
    public Kosu updateKosu(@PathVariable Integer id, @RequestBody Kosu kosuDetails) {
        return kosuService.updateKosu(id, kosuDetails);
    }
    @DeleteMapping("/delete/{id}")

    public void deleteKosu(@PathVariable Integer id) {
        kosuService.deleteKosu(id);
    }
    @GetMapping("/all")
    public List<Kosu> getAllKosu() {
        return kosuService.getAllKosu();
    }
}
