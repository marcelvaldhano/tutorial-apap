package apap.tutorial.traveloke.repository;

import apap.tutorial.traveloke.model.HotelModel;
import net.bytebuddy.TypeCache;
import net.bytebuddy.asm.Advice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface HotelDb extends JpaRepository<HotelModel,Long>{
    Optional<HotelModel> findById(Long id);

    public List<HotelModel> findAllByOrderByIdDesc();
}
