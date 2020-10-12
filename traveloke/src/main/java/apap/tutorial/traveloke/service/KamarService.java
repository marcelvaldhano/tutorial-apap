package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarService {
    void addKamar(KamarModel kamar);
    List<KamarModel> findAllKamarByIdHotel(Long idHotel);

    KamarModel updateKamar(KamarModel kamar);
    KamarModel getKamarByNoKamar(Long idKamar);
    List<KamarModel> getKamarModelByNamaKamarAndKapasitasKamar(String namaKamar, Integer kapasitasKamar);

    void deleteByNoKamar(Long noKamar);
   
}
