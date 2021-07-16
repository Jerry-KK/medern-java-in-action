package chapter4;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author koujn
 * @date 2021/7/16 10:23
 */
//流操作
public class StreamOperation {
    public static void main(String[] args) {
        /**
         * 1.流只选出了前三个，这是因为limit操作和一种称为 短路 的技巧
         * 2.尽管filter和map是两个独立的操作,但它们合并到同一个遍历中了（我们把这种技术叫做 循环合并 ）
         */
        List<String> names = Constant.menu.stream()
                .filter(dish -> {
                    System.out.println("filtering:" + dish.getName());
                    return dish.getCalories() > 500;
                })
                .map(dish -> {
                    System.out.println("mapping:" + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());

        /**
         * filtering:pork
         * mapping:pork
         * filtering:beef
         * mapping:beef
         * filtering:chicken
         * filtering:french fries
         * mapping:french fries
         */
    }
}
