package leetCode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/**
 * @author mengxijie
 * @since 2020/9/7 10:52 上午
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class TopKFrequent {


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 1) + 1);
        }
        map = map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        int[] ints = new int[k];
        AtomicInteger i = new AtomicInteger(0);
        map.forEach((x, y) -> {
            if (i.get() < k) {
                ints[i.get()] = x;
            }
            i.set(i.get() + 1);

        });
        return ints;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 1) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                assert queue.peek() != null;
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            ret[i] = Objects.requireNonNull(queue.poll())[0];
        }
        return ret;
    }

    public static void main(String[] args) {
        TopKFrequent top = new TopKFrequent();
        System.out.println(Arrays.toString(top.topKFrequent(new int[]{1}, 1)));
    }
}
