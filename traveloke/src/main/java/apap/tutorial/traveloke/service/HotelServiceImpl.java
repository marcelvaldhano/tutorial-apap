package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.HotelDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelDb hotelDb;
    @Override
    public void addHotel(HotelModel hotel){
        hotelDb.save(hotel);
    }

    @Override
    public void deleteHotel(HotelModel hotel) {
        hotelDb.delete(hotel);
    }

//    @Override
//    public void deleteByNoHotel(Long id) {
//        hotelDb.deleteByNoHotel(id);
//    }

    @Override
    public void deleteByNoHotel(HotelModel hotel){hotelDb.delete(hotel);}

    @Override
    public List<HotelModel>getHotelList(){return hotelDb.findAll();}

//    @Override
//    public void deleteHotel(HotelModel hotel) {
//        hotelDb.delete(hotel);
//    }


    @Override
    public List<HotelModel> findAllByOrderByIdDesc(){return hotelDb.findAllByOrderByIdDesc();}

    @Override
    public HotelModel getHotelByIdHotel(Long idHotel){
        return hotelDb.findById(idHotel).get();
    }
    @Override
    public HotelModel updateHotel(HotelModel hotel){
        HotelModel targetHotel=hotelDb.findById(hotel.getId()).get();
        try{
            targetHotel.setNamaHotel(hotel.getNamaHotel());
            targetHotel.setAlamat(hotel.getAlamat());
            targetHotel.setNomorTelepon(hotel.getNomorTelepon());
            hotelDb.save(targetHotel);
            return targetHotel;
        }catch (NullPointerException nullException){
            return null;
        }

    }
}
