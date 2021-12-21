package leetCode;

import java.time.LocalDate;

/**
 * @author mengxijie
 * @since 2021/12/21 9:45 上午
 * 1154. 一年中的第几天
 */
public class DayOfYear {

    public int dayOfYear(String date) {
        return LocalDate.parse(date).getDayOfYear();
    }

    public int dayOfYear2(String date) {
        int[] rYear = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] pYear = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int total = 0;
        String[] ss = date.split("-");
        int y = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        int d = Integer.parseInt(ss[2]);
        if( y% 400 == 0  || (y % 4== 0 && y / 100 != 0)){
            for(int i = 0; i < m-1; i++) {
                total += rYear[i];
            }
        }else{
            for(int i = 0; i < m-1;i++) {
                total += pYear[i];
            }
        }
        return total+d;
    }

    public static void main(String[] args) {
        DayOfYear dayOfYear = new DayOfYear();
        System.out.println(dayOfYear.dayOfYear2("2000-03-09"));
        System.out.println(dayOfYear.dayOfYear("2000-03-09"));
    }
}
