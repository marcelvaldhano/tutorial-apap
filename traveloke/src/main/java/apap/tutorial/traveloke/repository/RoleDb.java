package apap.tutorial.traveloke.repository;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDb extends JpaRepository<RoleModel,Long> {
    public List<RoleModel> findAll();
}
