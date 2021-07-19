package chapter6;

import chapter4.Constant;
import chapter4.Dish;

import java.util.IntSummaryStatistics;

import static java.util.stream.Collectors.*;


/**
 * @author koujn
 * @date 2021/7/19 16:40
 */
public class CollectDemo {
    public static void main(String[] args) {
        getTotalCalories();
    }

    /**
     * 数一数菜单里有多少种菜
     * @return
     */
    private long getHowManyDishes() {
        long howManyDishes = Constant.menu.stream().collect(counting());

        //更直接的写法
        //long howManyDishes =  Constant.menu.stream().count();
        return howManyDishes;

    }

    /**
     * 求出菜单列表的总热量
     * @return
     */
    private static int getTotalCalories() {
        int totalCalories;

        //求出菜单列表的总热量
        totalCalories = Constant.menu.stream().collect(summingInt(Dish::getCalories));

        double avgCalories = Constant.menu.stream().collect(averagingInt(Dish::getCalories));

        IntSummaryStatistics menuStatistics = Constant.menu.stream().collect(summarizingInt(Dish::getCalories));
        //IntSummaryStatistics{count=9, sum=4200, min=120, average=466.666667, max=800}
        System.out.println(menuStatistics);

        return totalCalories;
    }

    /**
     * 
     * @return
     */
    private static String testJoining() {
        String shortMenu = Constant.menu.stream().map(Dish::getName).collect(joining());
        return shortMenu;
    }


}
