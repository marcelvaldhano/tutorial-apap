package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.HotelDb;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.List;
import java.util.Optional;

@Controller
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    public HotelDb hotelDb;
    @Autowired
    private KamarService kamarService;

//    @GetMapping("/")
//    private String home(){
//        return "home";
//    }

    @GetMapping("hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel",new HotelModel());
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(
            @ModelAttribute HotelModel hotel,
    Model model){
        hotelService.addHotel(hotel);
        model.addAttribute("idHotel",hotel.getId());
        return "add-hotel";
    }

    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        try{
            HotelModel hotel=hotelService.getHotelByIdHotel(idHotel);
            model.addAttribute("hotel",hotel);
            return "form-update-hotel";
        }
        catch(Exception e){
            return "error-page";
        }

    }


    @GetMapping("/hotel/view/{idHotel}")
    public String viewhotel(
            @PathVariable Long idHotel,
            Model model
    ){
        try{
            HotelModel hotel=hotelService.getHotelByIdHotel(idHotel);
            List<KamarModel> listKamar=kamarService.findAllKamarByIdHotel(idHotel);
            model.addAttribute("hotel",hotel);
            model.addAttribute("listKamar",listKamar);
            return "view-hotel";
        }
        catch(Exception e){
            return "error-page";
        }

    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
            HotelModel hotelUpdated=hotelService.updateHotel(hotel);
            model.addAttribute("hotel",hotel);
            return "update-hotel";
    }
    @GetMapping("hotel/view")
    public String viewDetailHotel(
            @RequestParam(value="idHotel") Long idHotel,
            Model model
    ){
            try{
                HotelModel hotel=hotelService.getHotelByIdHotel(idHotel);
                List<KamarModel> listKamar=kamarService.findAllKamarByIdHotel(idHotel);
                model.addAttribute("hotel",hotel);
                model.addAttribute("listKamar",listKamar);
                return "view-hotel";
            }
            catch(Exception e){
                return "error-page";
            }

    }


    @RequestMapping("/hotel/viewall")
    public String listHotel (Model model){
        List<HotelModel> listHotel=hotelService.getHotelList();
        model.addAttribute("listHotel", listHotel);
        return "viewall-hotel";
    }


    @RequestMapping("/hotel/delete/{idHotel}")
    public String deleteHotel (
            @PathVariable Long idHotel,
            Model model
    ){
        try{
            int i= idHotel.intValue();
            HotelModel hotel=hotelService.getHotelByIdHotel(idHotel);
            List<KamarModel> listKamar=kamarService.findAllKamarByIdHotel(idHotel);
            if(listKamar.size()==0){
                hotelService.deleteHotel(hotel);
                return "delete-hotel";
        }
        }catch(Exception e){
            return "error-page";

        }
      return "delete-gagal";
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex, Model model) {
        return "error-page";
        // Actual exception handling
    }

    @RequestMapping("/hotel/viewallorder")
    public String orderedhotel (Model model){
        List<HotelModel> listHotel= hotelDb.findAllByOrderByIdDesc();
        model.addAttribute("listHotel", listHotel);
        return "viewall-hotel";
    }
}
