package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.InputProduct;
import uz.pdp.appwarehouse.repository.InputProductRepository;

@Service
public class DashboardService {
    @Autowired
    InputProductRepository inputProductRepository;

    //Vazifani shu joyigacha baholasayiz ham boladi umuman yo'lini topamadim
}
