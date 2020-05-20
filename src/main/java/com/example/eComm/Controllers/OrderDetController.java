package com.example.eComm.Controllers;

import com.example.eComm.Services.OrderDetService;
import com.example.eComm.Projection.OrderCreateProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@RestController
public class OrderDetController {

    @Autowired
    private OrderDetService orderDetService;

    //    orderDetails
    @PostMapping(value = "/create/Order")
    public String createOrder(@RequestBody(required = true) OrderCreateProjection orderCreateProjection ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse(orderCreateProjection.getOdate() ,formatter);
        LocalDate date2 = LocalDate.parse(orderCreateProjection.getOdel_date(),formatter);
        return orderDetService.createOrder(orderCreateProjection.getPid(), date1, date2, orderCreateProjection.getQuantity() , orderCreateProjection.getCid());
    }

    @GetMapping(value = "/readAll/Orders" )
    public List<String> readAllOrder() {
        return orderDetService.readAllOrder();
    }

    @GetMapping(value = "/searchBy/Order/{id}" )
    public List<String> readOrderById(@PathVariable int id) {
        return orderDetService.findOrderDetById(id);
    }

    @DeleteMapping(value = "/deleteBy/Order/{id}")
    public int deleteOrderById(@PathVariable int id) {
        return orderDetService.deleteOrderById(id);
    }

}
