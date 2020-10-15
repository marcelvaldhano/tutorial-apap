package apap.tutorial.traveloke.repository;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KamarDb extends JpaRepository<KamarModel,Long> {
    Optional<KamarModel> findByNoKamar(Long NoKamar);
    public void deleteByNoKamar(Long noKamar);
    List<KamarModel>findByHotelId(Long hotelId);
}
