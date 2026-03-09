package com.example.demo.learningJPA.item;

import com.example.demo.learningJPA.item.exceptions.NotEnoughMoneyException;
import com.example.demo.learningJPA.item.exceptions.NotSufficientSupplyException;
import com.example.demo.learningJPA.item.mapping.ItemMapper;
import com.example.demo.learningJPA.item.requests.ItemBuyRequest;
import com.example.demo.learningJPA.item.requests.ItemRequest;
import com.example.demo.learningJPA.item.responses.ItemBuyResponse;
import com.example.demo.learningJPA.item.responses.ItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    public ItemRepository repository;
    @Autowired
    public ItemMapper mapper;

    public ItemResponse createItem(ItemRequest request){
        Item item = mapper.itemRequestToItem(request);
        repository.save(item);
        return mapper.itemToItemResponse(item);
    }

    public List<ItemResponse> getAllItems(){
        return repository.findAll()
                .stream()
                .map(item -> mapper.itemToItemResponse(item))
                .toList();
    }

    public List<ItemResponse> getLowStockItems(int threshold){
        return repository.findLowStock(threshold)
                .stream()
                .map(item -> mapper.itemToItemResponse(item))
                .toList();
    }

    public ItemBuyResponse buyItem(ItemBuyRequest buyRequest){
        Item item = repository.findById(buyRequest.getItemId()).orElseThrow();
        int requestedQuantityPrice = item.getPrice() * buyRequest.getPurchaseQuantity();
        if (buyRequest.getPlayerBalance() - requestedQuantityPrice < 0){
            throw new NotEnoughMoneyException(requestedQuantityPrice,
                    buyRequest.getPlayerBalance(),
                    buyRequest.getPurchaseQuantity(),
                    item.getName());
        }
        if (item.isAvailable()){
            item.setQuantity(item.getQuantity() - buyRequest.getPurchaseQuantity());
            if (item.getQuantity() > 0){
                repository.save(item);
                return new ItemBuyResponse(item.getId(),
                        item.getName(),
                        item.getPrice(),
                        item.getQuantity(),
                        requestedQuantityPrice,
                        buyRequest.getPurchaseQuantity());
            }
        }
        throw new NotSufficientSupplyException(buyRequest.getPurchaseQuantity(),
                item.getQuantity(),
                item.getName());
    }


}


