package apap.tutorial.traveloke.restcontroller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.rest.HotelDetail;
import apap.tutorial.traveloke.service.HotelRestService;
import apap.tutorial.traveloke.service.KamarRestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class KamarRestController {
    @Autowired
    private KamarRestServiceImpl kamarRestServiceImpl;


    @PostMapping(value="/kamar")
    private KamarModel createKamar(@Valid @RequestBody KamarModel kamar, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        }
        else{
            return kamarRestServiceImpl.createKamar(kamar);
        }
    }

    @GetMapping(value = "/kamar/{idKamar}")
    private KamarModel retrieveKamar(@PathVariable("idKamar") Long idKamar) {
        try {
            KamarModel kamarModel=kamarRestServiceImpl.getKamarByNoKamar(idKamar);
            return kamarModel;
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Kamar " + idKamar + " Not Found");
        }
    }

    @PutMapping(value = "/kamar/{idKamar}")
    private KamarModel updateKamar(
            @PathVariable(value = "idKamar") Long idKamar,
            @RequestBody KamarModel kamar
    ) {
        try {
            return kamarRestServiceImpl.changeKamar(idKamar, kamar);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Id Kamar " + idKamar + "Not Found");
        }
    }

    @GetMapping(value = "/kamar-all")
    private List<KamarModel> retrieveListKamar() {
        return kamarRestServiceImpl.retrieveListKamar();
    }

    @DeleteMapping(value="/kamar/{idKamar}")
    private ResponseEntity<String> deleteKamar(@PathVariable("idKamar") Long idKamar){
        try{
            kamarRestServiceImpl.deleteKamarById(idKamar);
            return ResponseEntity.ok("Kamar with ID "+String.valueOf(idKamar)+" Deleted!");
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Kamar with ID "+String.valueOf(idKamar)+" Note Found!");
        }
    }


}
