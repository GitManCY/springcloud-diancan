package com.cy.feign;

import com.cy.entity.Order;
import com.cy.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(@RequestBody Order order);

    @GetMapping("/order/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit,@PathVariable("uid") long uid);

    //
    @DeleteMapping("/order/deleteByMid/{mid}")
    public void deleteByMid(@PathVariable("mid") long mid);

    @DeleteMapping("/order/deleteByUid/{uid}")
    public void deleteByUid(@PathVariable("uid") long uid);

    @GetMapping("/order/findAllByState/{state}/{page}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state, @PathVariable("page") int page, @PathVariable("limit") int limit);

    @PutMapping("/order/updateState/{id}/{state}/{aid}")
    public void updateState(@PathVariable("id") long id, @PathVariable("state") long state,@PathVariable("aid") long aid);

}

