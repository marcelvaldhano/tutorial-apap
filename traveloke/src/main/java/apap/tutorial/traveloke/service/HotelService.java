package apap.tutorial.traveloke.service;
import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    void addHotel(HotelModel hotel);

    void deleteHotel(HotelModel hotel);
//    void deleteByNoHotel(Long id);

    void deleteByNoHotel(HotelModel hotel);

    List<HotelModel> getHotelList();
    HotelModel getHotelByIdHotel(Long idHotel);
    HotelModel updateHotel(HotelModel hotel);
    List<HotelModel>findAllByOrderByIdDesc();
}
