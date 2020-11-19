package apap.tutorial.traveloke.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Transactional
@Service
public class RapidRestServiceImpl implements RapidRestService{

    @Override
    public Mono<String> getHotele(String cityName) {
        return null;
    }
}
