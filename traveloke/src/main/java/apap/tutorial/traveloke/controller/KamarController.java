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
import org.springframework.validation.BindingResult;
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


//    private List<KamarModel> kamars;
//
//    public void addKamar(KamarModel kamar) { this.kamars.add(kamar); }

    @RequestMapping(value="/kamar/add-multiple/{noKamar}")
    public String addRow(
            @PathVariable Long noKamar, KamarModel kamars, Model model, final BindingResult bindingResult
    ) {
        KamarModel kamar=kamarService.getKamarByNoKamar(noKamar);


        return "form-update-kamar";
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



    @PostMapping(path="/kamar/delete")
    public String deleteKamarFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        model.addAttribute("kamarCount", hotel.getListKamar().size());
        for(KamarModel kamar:hotel.getListKamar()){
            kamarService.deleteKamar(kamar);
        }
        return "delete-kamar";
    }

}
