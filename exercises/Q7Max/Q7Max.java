package exercises.Q7Max;   // ← 必须与目录结构一致

import java.util.Scanner;  // ← 移到 class 外面

public class Q7Max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("要输入几个数？");
        int n = sc.nextInt();

        while (n<=0) {
            System.out.println("重新输入");
            System.out.print("要输入几个数？");
            n = sc.nextInt();
        }
            // 用第一个真实数当擂主，而不是 0
            // 如果擂主是 0，当所有输入都是负数时，0 会比任何数都"大"，结果永远输出 0（错误）
            int max = sc.nextInt();

            // max 先吃第 1 个、循环再吃 n-1 个、共 n 个
            for (int i = 0; i < n - 1; i++) {
                int challenger = sc.nextInt();
                if (max < challenger) {
                    max = challenger;
                }
            }

            System.out.println("最大值是：" + max);
            sc.close();
            }
              
}