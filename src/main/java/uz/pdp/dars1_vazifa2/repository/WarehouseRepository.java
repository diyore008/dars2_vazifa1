package uz.pdp.dars1_vazifa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.dars1_vazifa2.entity.Warehouse;
import uz.pdp.dars1_vazifa2.projection.CustomWarehouse;


@EnableJpaRepositories
@Repository
@RepositoryRestResource(collectionResourceRel = "list", path = "warehouse",excerptProjection = CustomWarehouse.class)
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    boolean existsByName(String name);

}
