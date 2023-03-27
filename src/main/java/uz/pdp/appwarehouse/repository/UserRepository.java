package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);

}
