package exercises.hello_agent_v03;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

public class HelloAgentV3 {

    public static void main(String[] args) {

        // 启动提示：告诉用户这是啥、能干啥
        System.out.println("Hi, I'm your assistant. Available commands: hello / time / status / quit");

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");

        boolean running = true;
        int status = 0;
        try{
            while (running) {
                String word = sc.nextLine();
                word = word.trim().toLowerCase();

                switch (word) {
                    case "hello":
                        System.out.println("Hello! Nice to meet you.");
                        status++;
                        break;

                    case "time":
                        status++;
                        Date date = new Date();
                        System.out.println("Current time: " + sdf.format(date));
                        break;

                    case "quit":
                    case "exit":
                        status++;
                        running = false;
                        break;

                    case "status":
                        status++;
                        System.out.println("I've handled " + status + " command(s) so far.");
                        break;
                    case "":
                        System.out.println("Nothing");
                        break;
                    default:
                        status++;
                        System.out.println("Sorry, I don't understand that command.");
                        break;
                }
            }
        } catch (NoSuchElementException e) {
            // EOF（Ctrl+D / Ctrl+Z）落到这里，无需处理
        }
        System.out.println("Goodbye! See you next time.");
    }
}