package com.example.demo.learningJPA.item.mapping;

import com.example.demo.learningJPA.item.Item;
import com.example.demo.learningJPA.item.requests.ItemRequest;
import com.example.demo.learningJPA.item.responses.ItemResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ItemMapper {
    ItemResponse itemToItemResponse(Item item);
    Item itemRequestToItem(ItemRequest request);
}
