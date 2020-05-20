package com.example.eComm.OrderDet.Controller;

import com.example.eComm.OrderDet.Service.OrderDetService;
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
    @PostMapping(value = "/createOrder")
    public String createOrder(@RequestBody(required = true) OrderCreateProjection orderCreateProjection ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse(orderCreateProjection.getOdate() ,formatter);
        LocalDate date2 = LocalDate.parse(orderCreateProjection.getOdel_date(),formatter);
        return orderDetService.createOrder(orderCreateProjection.getPid(), date1, date2, orderCreateProjection.getQuantity() , orderCreateProjection.getCid());
    }

    @RequestMapping(value = "/readAllOrders" , method = RequestMethod.GET)
    public List<String> readAllOrder() {
        return orderDetService.readAllOrder();
    }
    @RequestMapping(value = "/searchOrderById/{id}" , method = RequestMethod.GET)
    public List<String> readOrderById(@PathVariable int id) {
        return orderDetService.findOrderDetById(id);
    }

    @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.DELETE)
    public int deleteOrderById(@PathVariable int id) {
        return orderDetService.deleteOrderById(id);
    }

}
