package apap.tutorial.traveloke.restcontroller;

import apap.tutorial.traveloke.service.RapidRestService;
import com.fasterxml.jackson.datatype.jdk8.WrappedIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class RapidController {
    @Autowired
    private RapidRestService rapidRestService;

    @GetMapping(value = "/hotel/find")
    public Mono<String> viewDetailHotel(
            @RequestParam(value = "cityName") String cityName
    ){
        return rapidRestService.getHotele(cityName);

    }
}
