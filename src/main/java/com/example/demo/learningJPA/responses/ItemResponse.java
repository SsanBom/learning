package com.example.demo.learningJPA.responses;

public record ItemResponse(Long id, String name, String type, int price, int quantity, boolean available) {
}
