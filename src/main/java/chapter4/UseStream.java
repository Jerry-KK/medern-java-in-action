package chapter4;


import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author lethe
 * @date 2021/7/15 23:24
 */
public class UseStream {
    public static void main(String[] args) {
        List<String> threeHeightCaloricDishNames = Constant.menu
                //从menu（菜肴列表）获得流
                .stream()
                //建立操作流水线：首先选出高热量的菜肴
                .filter(dish -> dish.getCalories() > 300)
                //获取菜名
                .map(Dish::getName)
                //只选择头三个
                .limit(3)
                //将结果保存在另一个List
                .collect(toList());
        System.out.println(threeHeightCaloricDishNames);
    }
}
