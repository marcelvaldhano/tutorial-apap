//package apap.tutorial.traveloke.service;
//
//import apap.tutorial.traveloke.model.HotelModel;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class HotelInMemoryService implements HotelService{
//    private List<HotelModel> listHotel;
//
//    public HotelInMemoryService(){
//        listHotel=new ArrayList<>();
//    }
//
//    @Override
//    public void addHotel (HotelModel hotel){
//        listHotel.add(hotel);
//    }
//
//
//    public void delete(HotelModel hotel){
//        listHotel.remove(hotel);
//    }
//
//
//    @Override
//    public List<HotelModel> getHotelList(){
//        return listHotel;
//    }
//
//    @Override
//    public HotelModel getHotelByIdHotel(String idHotel) {
//        for (HotelModel thisHotel:listHotel) {
//            if(thisHotel.getIdHotel().equals(idHotel)){
//                return thisHotel;
//            }
//
//        }
//    return null;
//    }
//
//
//
//
//}
