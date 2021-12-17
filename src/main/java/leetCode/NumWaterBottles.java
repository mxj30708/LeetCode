package leetCode;

/**
 * @author mengxijie
 * @since 2021/12/17 10:54 上午
 */
public class NumWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        while (numBottles>=numExchange){
            int a = numBottles/numExchange;
            int b =numBottles%numExchange;
            total+=a;
            numBottles = a+b;
        }
        return total;
    }

    public static void main(String[] args) {
        NumWaterBottles numWaterBottles = new NumWaterBottles();
        System.out.println(numWaterBottles.numWaterBottles(5,5));
    }
}
