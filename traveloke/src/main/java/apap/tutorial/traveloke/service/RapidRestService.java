package apap.tutorial.traveloke.service;

import reactor.core.publisher.Mono;


public interface RapidRestService {
    Mono<String> getHotel(String cityName);
}
