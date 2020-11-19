package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.HotelDb;
import apap.tutorial.traveloke.repository.KamarDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class KamarRestServiceImpl implements KamarRestService{
    private WebClient webClient;

    @Autowired
    private KamarDb kamarDb;

    public KamarRestServiceImpl() {
    }

    @Override
    public KamarModel createKamar(KamarModel kamar){
        return kamarDb.save(kamar);
    }

    @Override
    public List<KamarModel> retrieveListKamar(){ return kamarDb.findAll(); }

    @Override
    public HotelModel getHotelByIdHotel(Long idHotel) {
        return null;
    }

    @Override
    public KamarModel getKamarByNoKamar(Long noKamar){
        Optional<KamarModel> kamar=kamarDb.findByNoKamar(noKamar);
        if(kamar.isPresent()){
            return kamar.get();
        }else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public void deleteKamar(KamarModel kamar) {
        kamarDb.delete(kamar);
    }


    @Override
    public KamarModel getKamarByIdKamar(Long idKamar) {
        return kamarDb.findById(idKamar).get();
    }

    @Override
    public void deleteKamarById(Long idKamar){
        kamarDb.deleteById(idKamar);
    }

    @Override
    public KamarModel changeKamar(Long idKamar, KamarModel kamarModelUpdate) {
        KamarModel kamar = getKamarByIdKamar(idKamar);
        kamar.setNamaKamar(kamarModelUpdate.getNamaKamar());
        kamar.setTipe(kamarModelUpdate.getTipe());
        kamar.setKapasitasKamar(kamarModelUpdate.getKapasitasKamar());
        return kamarDb.save(kamar);
    }

}
