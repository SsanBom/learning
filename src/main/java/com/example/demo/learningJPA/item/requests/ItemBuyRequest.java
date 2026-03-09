package com.example.demo.learningJPA.item.requests;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ItemBuyRequest {
    @Id
    @NotNull
    Long itemId;

    @Min(1)
    int purchaseQuantity;

    @Min(0)
    int playerBalance;

    public ItemBuyRequest(Long itemId, int purchaseQuantity, int playerBalance) {
        this.itemId = itemId;
        this.purchaseQuantity = purchaseQuantity;
        this.playerBalance = playerBalance;
    }

    public Long getItemId() {
        return itemId;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public int getPlayerBalance() {
        return playerBalance;
    }
}
