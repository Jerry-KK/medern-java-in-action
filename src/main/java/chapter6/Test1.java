package chapter6;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author koujn
 * @date 2021/7/19 13:34
 */
public class Test1 {
    public static void main(String[] args) {
        Collector<Object, ?, List<Object>> objectListCollector = Collectors.toList();



    }
}
