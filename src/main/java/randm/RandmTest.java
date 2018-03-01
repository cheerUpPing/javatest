package randm;

import java.util.Random;
import java.util.concurrent.ExecutorService;

/**
 * 2016/8/23 17:32.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class RandmTest {
    /**
     * 随机指定范围内N个不重复的数
     * 最简单最基本的方法
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n   随机数个数
     */
    public static int[] randomCommon(int min, int max, int n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Random random = new Random();
        System.out.println("创建一个对象话费的时间："+(System.currentTimeMillis()-start));
        for (int i = 0; i < 10; i++) {
            int arr[] = randomCommon(1000,9999,10);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]+",");
            }
            System.out.println("\n");
        }
    }
}
