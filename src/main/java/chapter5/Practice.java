package chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * @author koujn
 * @date 2021/7/16 14:57
 */
public class Practice {

    private static final List<Transaction> transactions = getTransactions();

    private static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul" , "Cambridge");
        Trader mario = new Trader("Mario" , "Milan");
        Trader alan = new Trader("Alan" , "Cambridge");
        Trader brian = new Trader("Brian" , "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian , 2011 ,300),
                new Transaction(raoul , 2012 ,1000),
                new Transaction(raoul , 2011 ,400),
                new Transaction(mario , 2012 ,710),
                new Transaction(mario , 2012 ,700),
                new Transaction(alan , 2012 ,950)
        );
        return transactions;
    }

    public static void main(String[] args) {
        //transactions.forEach(System.out::println);

        //question1();

        //question2();

        //question3();

        //question4();

        //question5();

        //question6();

        //question7();

        question8();
    }

    /**
     * 1.找出2011年发生的所有交易，并按交易额排序（从低到高）
     */
    public static void question1() {
        transactions.stream()
                .filter(e -> e.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);
    }

    /**
     * 2.交易员都在哪些不同的城市工作过
     */
    public static void question2() {
        transactions.stream()
                .map(e -> e.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 3.查找所有来自剑桥的交易员，并按姓名排序
     */
    public static void question3() {
        transactions.stream()
                .filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .sorted((comparing(o -> o.getTrader().getName())))
                .forEach(System.out::println);
    }

    /**
     * 4.返回所有交易员的姓名字符串，按字母顺序排序
     */
    public static void question4() {
        String allName = transactions.stream()
                .map(e -> e.getTrader().getName())
                .distinct()
                .sorted()
                //.reduce("", (n1, n2) -> n1 + n2);
                .collect(Collectors.joining());     //更高效
        System.out.println(allName);
    }

    /**
     * 5.有没有交易员是在米兰工作的
     */
    public static void question5() {
        boolean result = transactions.stream()
                .anyMatch(e -> e.getTrader().getCity().equals("Milan"));
        System.out.println(result);
    }

    /**
     * 6.打印生活在剑桥的交易员的所有交易额
     */
    public static void question6() {
        Optional<Integer> optional = transactions.stream()
                .filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(optional.orElse(0));
    }

    /**
     * 7.所有交易中,最高的交易额是多少
     */
    public static void question7() {
        Optional<Integer> optional = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(optional.orElse(0));
    }

    /**
     * 8.找到交易额最小的交易
     */
    public static void question8() {
        Optional<Transaction> first = transactions.stream()
                .min(comparing(Transaction::getValue));
        first.ifPresent(System.out::println);
    }
}
