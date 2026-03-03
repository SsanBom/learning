package com.example.demo.learningJava;

import java.util.*;
import java.util.stream.Collectors;

public class LearningListSet {
    public static void initiate(){
        List<String> playerNames = List.of("Steve", "Alex", "Notch", "Steve");
        System.out.println(playerNames);
        HashSet<String> uniquePlayerNames = new HashSet<>(playerNames);
        System.out.println(uniquePlayerNames);
        uniquePlayerNames.add("Herobrine");
        TreeSet<String> uniquePlayerNamesTreeSet = new TreeSet<>(uniquePlayerNames);
        System.out.println(uniquePlayerNamesTreeSet);
        if (uniquePlayerNamesTreeSet.contains("Alex")){
            System.out.println(true);
        }

        List<String> fruits = new ArrayList<>();
        List<String> filteredFruits = fruits.stream().filter(fruit -> fruit.toCharArray()[0] == 'A').toList();

// 3
        List<String> animals = Arrays.asList("cat", "dog", "bird");
        var upperAnimals = animals.stream().map(String::toUpperCase).toList();

// 4
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8);
        var updatedNumbers = evenNumbers.stream().map(num -> num * 3).toList();

// 5
        List<String> letters = Arrays.asList("a", "b", "c");
        String joinedLetters =  letters.stream().collect(Collectors.joining(","));

// 6
        List<Integer> oneToFive = Arrays.asList(1, 2, 3, 4, 5);
        //не знаю как. Видимо, нужен небольшой ликбез по collectors
// 7
        List<String> names = Arrays.asList("Anna", "Bob", "Alice", "John");
        var updatedNames = names.stream().filter(name -> name.length() > 3).map(String::toUpperCase).toList();

// 8
        List<Integer> oneToSix = Arrays.asList(1, 2, 3, 4, 5, 6);
        var onlyEven = oneToSix.stream().filter(num -> num % 2 == 0).map(num -> num * 10).findFirst();
    }
}
