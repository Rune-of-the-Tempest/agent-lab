package exercises.hello_agent_v01;
import java.util.Scanner;

public class HelloAgent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "GBK");   // ← 唯一改动
        System.out.println("Agent已启动。");

        boolean running = true;

        while (running) {
            if (!sc.hasNextLine()) {
                System.out.println("输入流已关闭，Agent退出。");
                break;
            }
            String input = sc.nextLine();

            switch (input) {
                case "你好":
                    System.out.println("你好！我是你的Agent，很高兴见到你。");
                    break;
                case "你是谁":
                    System.out.println("我是一个Java写的对话程序，目前还是v0.1，只会几句话。");
                    break;
                case "再见":
                    System.out.println("再见！期待下次对话。");
                    running = false;
                    break;
                case "":
                    System.out.println("（你什么都没说，请输入点什么）");
                    break;
                default:
                    System.out.println("抱歉，我还没学会回应这句话。");
                    break;
            }
        }
        sc.close();
    }
}
