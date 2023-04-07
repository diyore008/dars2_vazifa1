package uz.pdp.dars1_vazifa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.dars1_vazifa2.entity.OutputProduct;
import uz.pdp.dars1_vazifa2.projection.CustomOutputProduct;

@RepositoryRestResource(collectionResourceRel = "list", path = "outputProduct",excerptProjection = CustomOutputProduct.class)
public interface OutputProductRepository extends JpaRepository<OutputProduct, Integer> {
}
