package chapter5;

import chapter4.Constant;
import chapter4.Dish;

import java.util.List;
import java.util.Optional;

/**
 * @author koujn
 * @date 2021/7/16 13:36
 */
public class TestFindAny {
    public static void main(String[] args) {

        /**
         * Optional 简介
         * 1. isPresent() 将在Optional 包含值的时候返回 true ，否则返回false。
         * 2. isPresent(Consumer<T> block) 会在值存在的时候执行给定的代码块。
         *    前面介绍过Consumer函数式接口，它让你传递一个接收T类型参数，并返回void的Lambda表达式。
         * 3. T get()会在值存在时返回值，否则抛出一个NoSuchElement 异常。
         * 4. T orElse(T other) 会在值存在时返回值，否则返回一个默认值。
         */
        Optional<Dish> optionalDish = Constant.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        /**
         * findAny 方法将返回当前流中的任意元素
         * 当一些流由一个出现顺序（encounter order）来指定流中项目出现的逻辑顺序（比如由List或排序好的数据列生成的流）。
         * 对于这种流，你可能想要找到第一个元素。为此有一个 findFirst 方法。
         */
        Constant.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()));
    }
}
