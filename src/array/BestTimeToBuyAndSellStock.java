package array;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(1);
        // List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        // String commaSeparatedNumbers = numbers.stream()
        //         .map(i -> i.toString())
        //         .collect(Collectors.joining(", "));
        // System.out.println(commaSeparatedNumbers);
    }

    // 暴力
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    // 一次遍历
    public int maxProfit1(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int p : prices) {
            if (p < min) {
                min = p;
            } else if (p - min > max) {
                max = p - min;
            }
        }
        return max;
    }
}
