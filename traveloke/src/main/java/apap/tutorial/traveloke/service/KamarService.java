package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarService {
    void addKamar(KamarModel kamar);
    List<KamarModel> findAllKamarByIdHotel(Long idHotel);

    KamarModel updateKamar(KamarModel kamar);
    KamarModel getKamarByNoKamar(Long idKamar);

    void deleteByNoKamar(Long noKamar);
    void deleteKamar(KamarModel kamar);
}
