import java.io.*;

public class EncodingProbe {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入: 你好  然后回车");
        byte[] buf = new byte[32];
        int n = System.in.read(buf);   // 原始字节，不经任何解码
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 2; i++)   // 减掉末尾的回车换行
            sb.append(String.format("%02X ", buf[i]));
        System.out.println("收到字节数: " + (n - 2));
        System.out.println("字节内容: " + sb);
    }
}
