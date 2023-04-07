package uz.pdp.dars1_vazifa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.dars1_vazifa2.entity.InputProduct;
import uz.pdp.dars1_vazifa2.projection.CustomInputProduct;

@RepositoryRestResource(collectionResourceRel = "list", path = "inputProduct",excerptProjection = CustomInputProduct.class)
public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {

}
