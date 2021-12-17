package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mengxijie
 * @since 2021/12/16 9:56 上午
 * 1610题
 */
public class VisiblePoints {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int x = location.get(0), y = location.get(1);
        List<Double> list = new ArrayList<>();
        int cnt = 0;
        double pi = Math.PI, t = angle * pi / 180;
        for (List<Integer> p : points) {
            int a = p.get(0), b = p.get(1);
            //如果是同一个点的情况。不管如何旋转是可以观察到的。直接累加
            if (a == x && b == y && ++cnt >= 0) {
                continue;
            }
            list.add(Math.atan2(b - y, a - x));
        }
        Collections.sort(list);
        int n = list.size(), max = 0;
        //由于可能夸象限，所以得把所有角度都复制一遍
        for (int i = 0; i < n; i++) {
            list.add(list.get(i) + 2 * pi);
        }
        //滑动窗口
        for (int i = 0, j = 0; j < 2 * n; j++) {
            while (i < j && list.get(j) - list.get(i) > t) {
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return cnt + max;
    }

    public static void main(String[] args) {
        VisiblePoints visiblePoints = new VisiblePoints();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> point1 = new ArrayList<>();
        point1.add(2);
        point1.add(1);
        list.add(point1);
        List<Integer> point2 = new ArrayList<>();
        point2.add(2);
        point2.add(2);
        list.add(point2);
        List<Integer> point3 = new ArrayList<>();
        point3.add(3);
        point3.add(4);
        list.add(point3);
        List<Integer> point4 = new ArrayList<>();
        point4.add(1);
        point4.add(1);
        list.add(point4);
        List<Integer> location =new ArrayList<>();
        location.add(1);
        location.add(1);
        System.out.println(visiblePoints.visiblePoints(list,90,location));
    }
}
