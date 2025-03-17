package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private final BurgerDao burgerDao;

    public BurgerController(BurgerDao burgerDao){
        this.burgerDao = burgerDao;
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger){
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger);
    }
    @GetMapping
    public List<Burger> findAll(){
        return burgerDao.findAll();
    }
    @GetMapping("/{id}")
    public Burger findById(@PathVariable long id){ //tek bir kayıt geleceği için list gerek yok
        return burgerDao.findById(id);
    }
    @PutMapping()
    public Burger update(@RequestBody Burger burger){
        BurgerValidation.checkName(burger.getName());
        return burgerDao.update(burger);
    }
    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable long id){
        return burgerDao.remove(id);
    }
    @GetMapping("/breadType/{breadType}")
    public List<Burger> getByBreadType(@PathVariable("breadType") BreadType breadType){
        return burgerDao.findByBreadType(breadType);
    }
    @GetMapping("/price/{price}")
    public List<Burger> getByPrice(@PathVariable("price") Integer price){
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable("content") String content)
    {
        return burgerDao.findByContent(content);
    }
}
