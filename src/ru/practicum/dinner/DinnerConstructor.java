package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    static HashMap<String, ArrayList<String>> menu = new HashMap<>();
    ArrayList<String> listOfDishes, dishCombo;
    ArrayList<ArrayList<String>> listOfCombos;
    int randomNumber;
    String randomDish, dishTypeForCombo;

    public void addNewDish(String dishType, String dishName) {
        if (checkType(dishType)) {
            listOfDishes = menu.get(dishType);
            listOfDishes.add(dishName);
        } else  {
            listOfDishes = new ArrayList<>();
            listOfDishes.add(dishName);
        }
        menu.put(dishType, listOfDishes);
        //System.out.println(menu.keySet());
        //System.out.println(menu.values());
    }

    public void generateCombo(int numberOfCombos, ArrayList <String> dishTypeList) {
        //System.out.println("Зашли в метод");
        dishCombo = new ArrayList<>(dishTypeList.size());
        listOfCombos = new ArrayList<>();
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