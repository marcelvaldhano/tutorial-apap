package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarRestService {
    KamarModel createKamar(KamarModel kamar);

    List<KamarModel> retrieveListKamar();

    HotelModel getHotelByIdHotel(Long idHotel);
    public KamarModel getKamarByNoKamar(Long noKamar);
    void deleteKamar(KamarModel kamar);

    KamarModel getKamarByIdKamar(Long idKamar);
    KamarModel changeKamar(Long idKamar, KamarModel UpdatedKamar);

    void deleteKamarById(Long id);

}
