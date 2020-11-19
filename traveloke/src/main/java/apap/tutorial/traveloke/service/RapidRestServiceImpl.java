package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.rest.Setting;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Transactional
@Service
public class RapidRestServiceImpl implements RapidRestService{
    private  WebClient webClient;

    @Override
    public Mono<String> getHotel(String cityName) {
        return this.webClient.get().uri(uriBuilder -> uriBuilder
                .path("/json").queryParam("query",cityName)
                .queryParam("locale","en_US")
                .build())
                .header("x-rapidapi-key", "a29da09f9emshd287e68e440dcf2p12a30fjsn3189d246066f")
                .header("x-rapidapi-host", "hotels-com-free.p.rapidapi.com")
                .retrieve()
                .bodyToMono(String.class);

    }

    public RapidRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient=webClientBuilder.baseUrl(Setting.rapidUrl).build();}


}
