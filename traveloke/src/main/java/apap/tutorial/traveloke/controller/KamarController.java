package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.HotelDb;
import apap.tutorial.traveloke.repository.KamarDb;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;
    @Autowired
    public HotelDb hotelDb;
    @Autowired
    public KamarDb kamarDb;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/kamar/change/{noKamar}")
    public String changeHotelFormPage(
            @PathVariable Long noKamar,
            Model model
    ){
        KamarModel kamar= kamarService.getKamarByNoKamar(noKamar);
        model.addAttribute("kamar",kamar);
        return "form-update-kamar";
    }

    @PostMapping("/kamar/change")
    public String changeKamarFormSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        KamarModel kamarUpdated=kamarService.updateKamar(kamar);
        model.addAttribute("kamar",kamar);
        return "update-kamar";
    }

    @GetMapping("/kamar/add/{idHotel}")
    private String addKamarFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        KamarModel kamar=new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        kamar.setHotel(hotel);
        model.addAttribute("kamar", kamar);
        return "form-add-kamar";
    }

    @PostMapping("/kamar/add")
    private String addKamarSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        kamarService.addKamar(kamar);
        model.addAttribute("kamar",kamar.getNoKamar());
        if(kamar != null){
            model.addAttribute("kamar",kamar.getNoKamar());
        }
        return "add-kamar";
    }

    @GetMapping("/kamar/delete/{noKamar}")
    public String deleteKamar (
            @PathVariable Long noKamar,
            Model model
    ){

        kamarService.deleteByNoKamar(noKamar);
        return "delete-kamar";
    }

}
