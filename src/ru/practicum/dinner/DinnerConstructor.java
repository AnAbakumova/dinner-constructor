package ru.practicum.dinner;

import java.util.*;
import java.util.List;


public class DinnerConstructor {
    static Map<String, List<String>> menu = new HashMap<>();

    public void addNewDish(String dishType, String dishName) {
        List<String> listOfDishes = new ArrayList<>();
        if (checkType(dishType)) {
            listOfDishes = menu.get(dishType);
            listOfDishes.add(dishName);
        } else  {
            listOfDishes.add(dishName);
        }
        menu.put(dishType, listOfDishes);
    }

    public void generateCombo(int numberOfCombos, List<String> dishTypeList) {
        int randomNumber;
        String randomDish, dishTypeForCombo;
        List<String> dishCombo = new ArrayList<>(dishTypeList.size());

        for (int i = 0; i < numberOfCombos; i++) {
            for (int j = 0; j < dishTypeList.size(); j++) {
                dishTypeForCombo = dishTypeList.get(j);
                //получаем j-ый выбранный пользователем тип блюда для набора
                randomNumber = new Random().nextInt(menu.get(dishTypeForCombo).size());
                // получаем рандомное число от 0 до ((кол-во блюд заданного типа) - 1)
                randomDish = menu.get(dishTypeForCombo).get(randomNumber);
                // рандомное блюдо из списка блюд заданного типа

                dishCombo.add(j, randomDish);
                // формируем массив случайных блюд - т.е. один комбо-набор
            }
            System.out.println("Комбо " + (i + 1));
            System.out.println(dishCombo);
            dishCombo.clear();
        }
    }

    public boolean checkType(String type) {
        return menu.containsKey(type);
    }
}