package com.example.demo.learningJPA.mapping;

import com.example.demo.learningJPA.Item;
import com.example.demo.learningJPA.requests.ItemRequest;
import com.example.demo.learningJPA.responses.ItemResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ItemMapper {
    ItemResponse itemToItemResponse(Item item);
    Item itemRequestToItem(ItemRequest request);
}
