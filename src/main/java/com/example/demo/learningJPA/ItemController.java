package com.example.demo.learningJPA;

import com.example.demo.learningJPA.requests.ItemBuyRequest;
import com.example.demo.learningJPA.requests.ItemRequest;
import com.example.demo.learningJPA.responses.ItemResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    ItemService service;

    @GetMapping("/all")
    public List<ItemResponse> getAll(){
        return service.getAllItems();
    }

    @GetMapping("/by_type")
    public List<ItemResponse> getByType(@RequestParam String type){
        return service.getItemsByType(type);
    }

    @GetMapping("/low_stock")
    public List<ItemResponse> getLowStock(@RequestParam int threshold){
        return service.getLowStockItems(threshold);
    }

    @DeleteMapping("/buy")
    public ResponseEntity<?> buy(@Valid @RequestBody ItemBuyRequest request){return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.buyItem(request));}

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody ItemRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(service.createItem(request));}

}
