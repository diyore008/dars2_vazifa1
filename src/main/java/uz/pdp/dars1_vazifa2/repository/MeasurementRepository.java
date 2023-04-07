package uz.pdp.dars1_vazifa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.data.web.ProjectedPayload;
import uz.pdp.dars1_vazifa2.entity.Measurement;
import uz.pdp.dars1_vazifa2.projection.CustomMeasurement;

@RepositoryRestResource(collectionResourceRel = "list", path = "measurement",excerptProjection = CustomMeasurement.class)
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    boolean existsByName(String name);
}
