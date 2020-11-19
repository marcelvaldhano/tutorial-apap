package apap.tutorial.traveloke.service;

import reactor.core.publisher.Mono;


public interface RapidRestService {
    Mono<String> getHotele(String cityName);
}
