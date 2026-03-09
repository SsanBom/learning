package com.example.demo.learningJPA.item.responses;

public record ItemBuyResponse(Long itemId, String itemName, int itemPrice, int remainingSupply, int purchasePrice,
                              int purchaseQuantity) {
}
