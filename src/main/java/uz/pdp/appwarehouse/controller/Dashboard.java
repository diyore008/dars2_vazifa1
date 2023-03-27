package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appwarehouse.entity.InputProduct;
import uz.pdp.appwarehouse.service.DashboardService;
import uz.pdp.appwarehouse.service.InputService;

@RestController
@RequestMapping("/dashboard")
public class Dashboard {
    @Autowired
    DashboardService dashboardService;

    @GetMapping("/getInputProductTotalCountPrice")
    public InputProduct getInputProductTotalCountPrice(){
        InputProduct inputProductTotalPrice = dashboardService.getInputProductTotalPrice();
        return inputProductTotalPrice;
    }
}
