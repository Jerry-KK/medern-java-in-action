package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author koujn
 * @date 2021/7/16 9:51
 */
public class StreamAndCollection {
    public static void main(String[] args) {

        //4.3.1 只能遍历一次
        List<String> title = Arrays.asList("Modern","Java","In","Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        /**
         * 和迭代器类似，流只能遍历一次。遍历完以后，我们就说这个流已经被消费掉了。
         * java.lang.IllegalStateException: stream has already been operated upon or closed
         */
        //s.forEach(System.out::println);

        //外部迭代与内部迭代
        List<String> names = null;
        //1.集合：用for-each循环外部迭代
        //for-each结构是一个语法糖
        names = new ArrayList<>();
        for (Dish dish:Constant.menu) {
            names.add(dish.getName());
        }
        //2.集合：用背后的迭代器做外部迭代
        names = new ArrayList<>();
        Iterator<Dish> iterator = Constant.menu.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            names.add(dish.getName());
        }
        //3.流：内部迭代
        names = Constant.menu.stream()
                .map(Dish::getName)
                .collect(toList());
    }
}
