package exercises.Ex9SecondMax;

public class Ex9SecondMax {
    public static void main(String[] args) {
 System.out.println(findSecondMax(new int[]{3, 1, 4, 1, 5}));   // 1  -> 4
        System.out.println(findSecondMax(new int[]{7, 7, 7}));         // 2  -> 不存在
        System.out.println(findSecondMax(new int[]{9, 5, 3, 1}));      // 3  -> 5
        System.out.println(findSecondMax(new int[]{-5, -2, -9}));      // 4  -> -5
        System.out.println(findSecondMax(new int[]{8}));               // 5a -> 不存在（校验层拦）
        System.out.println(findSecondMax(new int[]{8, 3}));            // 5b -> 3
        System.out.println(findSecondMax(new int[]{4, 4}));            // 6  -> 不存在
        System.out.println(findSecondMax(new int[]{3, 9}));            // 7  -> 3
        System.out.println(findSecondMax(new int[]{1, 4, 5}));         // 8  -> 4
        System.out.println(findSecondMax(new int[]{5, 5, 3}));         // 9  -> 3   （雷一）
        System.out.println(findSecondMax(new int[]{5, -1, -1}));       // 10 -> -1  （雷二）
        System.out.println(findSecondMax(new int[]{7, 7, 7, 3}));      // 11 -> 3   （雷一第二发）
    }

    public static Integer findSecondMax(int[] arr){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int length = arr.length;
        if(length < 2){
            System.out.print("没有第二大的数"+ " ");
            return null;
        }else{
            for(int i = 0; i < length; i++){
                
                if(arr[i]>max1){
                    max2 = max1;
                    max1 = arr[i];
                }else if ((max1 > arr[i])&&(arr[i]>max2)){
                    max2 = arr[i];
                }
            }
            if ((max1 == max2) || (max2 == Integer.MIN_VALUE)){
                System.out.print("没有第二大的数"+ " ");
                return null;
            }
            
            return max2;
           
        }
    }
    
}
