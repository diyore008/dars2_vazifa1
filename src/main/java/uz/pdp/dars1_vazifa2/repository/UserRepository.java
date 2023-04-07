package uz.pdp.dars1_vazifa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.dars1_vazifa2.entity.User;
import uz.pdp.dars1_vazifa2.projection.CustomUser;

import java.util.List;
@RepositoryRestResource(collectionResourceRel = "list", path = "user",excerptProjection = CustomUser.class)
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);

}