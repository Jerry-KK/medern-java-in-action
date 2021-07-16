package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author koujn
 * @date 2021/7/16 11:19
 */
public class TestFlatMap {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {3,4};

        /**
         * java.util class T
         * extends Object
         *  @SafeVarargs
         *  @SuppressWarnings("varargs")
         *  public static <T> List<T> asList(T... a) {
         *      return new ArrayList<>(a);
         *  }
         *  T是个继承于Object的类，并非基本类型，所以int[]作为参数导入事，T 为int[]。
         *  也就是Arrays.asList(传入一个int[]) 返回的是ArrayList<int[]>类型。
         */
        List<int[]> ints = Arrays.asList(a);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> result = numbers1.stream()
                .flatMap(i ->
                    numbers2.stream()
                            .filter(j -> (i+j)%3 == 0)
                            .map(j -> new int[]{i, j})
                )
                .collect(toList());
        result.forEach(arr->{
            System.out.println(arr[0] + " , " + arr[1]);
        });
    }
}
