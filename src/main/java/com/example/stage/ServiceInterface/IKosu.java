package com.example.stage.ServiceInterface;

import com.example.stage.entites.Incident;
import com.example.stage.entites.Kosu;

import java.util.List;

public interface IKosu {
    Kosu addKosu(Kosu kosu);
    Kosu updateKosu(Integer id, Kosu kosuDetails);
    void deleteKosu(Integer id);

}
