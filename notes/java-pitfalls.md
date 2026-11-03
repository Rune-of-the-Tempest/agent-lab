# Java 踩坑记录

> 按坑分类，遇到问题先翻这里。

## 1. Windows + Java 中文编码三重坑

### 坑1a：编译时中文报错 / 匹配不上
- **症状**：javac报错，或程序里的中文case永远匹配不上
- **原因**：javac默认按GBK读源码，但源码是UTF-8存的
- **修法**：`javac -encoding UTF-8 xxx.java`
- **规矩**：源码有中文，编译永远带 -encoding UTF-8

### 坑1b：输入的中文变乱码（???）
- **症状**：输入"你好"，收到 3 个乱码字符
- **原因**：本机终端（PowerShell）发的是GBK字节，Java按UTF-8解
- **诊断法**：写小程序直接打印 System.in 读到的原始字节（十六进制）
  - GBK的"你好" = C4 E3 BA C3（4字节）
  - UTF-8的"你好" = E4 BD A0 E5 A5 BD（6字节）
- **修法**：`new Scanner(System.in, "GBK")`
- **领悟**：调试别猜，打印原始字节看证据

## 2. switch 里的 break 跳不出外层 while
- **症状**：case "再见" 里 break，循环还在跑
- **原因**：break只跳出switch，不跳出while
- **修法**：用布尔开关——case里写 `running = false;`，循环条件自然退出

## 3. PowerShell 会拆 -D 参数
- **症状**：`java -Dfile.encoding=UTF-8 Hello` 报 ClassNotFoundException: /encoding=UTF-8
- **原因**：PowerShell把带点带等号的参数从中间劈开
- **修法**：参数整体加引号 → `java "-Dfile.encoding=UTF-8" Hello`

## 4. Scanner 读不到输入直接崩
- **症状**：Ctrl+Z 或输入流关闭后抛 NoSuchElementException
- **修法**：读之前用 `sc.hasNextLine()` 探测，没有就体面退出
