package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import uz.pdp.appwarehouse.entity.Warehouse;

import java.util.Set;
@EnableJpaRepositories
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    boolean existsByName(String name);

}
