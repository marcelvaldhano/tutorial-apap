package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @RequestMapping("/hotel/add")
    public String addHotel(
        @RequestParam(value = "idHotel", required = true) String idHotel,
        @RequestParam(value = "namaHotel", required = true) String namaHotel,
        @RequestParam(value = "alamat", required = true) String alamat,
        @RequestParam(value = "noTelepon", required = true) String noTelepon,
        Model model
    ){
        HotelModel hotel= new HotelModel(idHotel,namaHotel,alamat,noTelepon);

        hotelService.addHotel(hotel);
        model.addAttribute("idHotel",idHotel);
        return "add-hotel";

    }

    @RequestMapping("/hotel/viewall")
    public String listHotel (Model model){
        List<HotelModel> listHotel=hotelService.getHotelList();
        model.addAttribute("listHotel", listHotel);
        return "viewall-hotel";
    }

    @RequestMapping("/hotel/view")
    public String detailHotel(
            @RequestParam(value = "idHotel") String idHotel,
            Model model){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        model.addAttribute("hotel",hotel);
        return "view-hotel";
    }
    @GetMapping(value = "hotel/view/id-hotel/{idHotel}")
    public String viewHotel(
            @PathVariable(value = "idHotel") String idHotel,
            Model model){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        model.addAttribute("hotel",hotel);
        return "view-hotel";
    }
    @GetMapping("/hotel/update/id-hotel/{idHotel}/no-telepon/{noTelepon}")
    public String updateHotel(
            @PathVariable(value = "idHotel", required = true) String idHotel,
            @PathVariable(value = "noTelepon", required = true) String noTelepon,
            Model model){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        hotel.setNoTelepon(noTelepon);
        model.addAttribute("hotel",hotel);
        return "view-hotel";
    }

    @GetMapping("/hotel/delete/id-hotel/{idHotel}")
    public String deleteHotel(
            @PathVariable(value = "idHotel", required = true) String idHotel,
            Model model
    ){

        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if(hotel.getIdHotel().equals(idHotel)){
                hotelService.getHotelList().remove(idHotel);
        }
        model.addAttribute("hotel",hotel);
        return "view-hotel";
    }




}
