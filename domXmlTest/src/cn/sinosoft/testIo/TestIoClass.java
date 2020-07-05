package cn.sinosoft.testIo;

import java.io.*;

public class TestIoClass {

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        File file = new File("D:\\img\\1.png");
        try {
            FileReader reader=new FileReader("D:\\img\\1.txt");
            char[] chars= new char[1024];
            reader.read(chars);
            for (char c : chars) {
                System.out.print(c);
            }
            reader.close();
            FileWriter writer= new FileWriter("D:\\img\\1.txt");
            writer.write("ffjjfskdfsjkti啦啦啦啦东方嘉盛交付时间方式时代峻峰收款方式快递费技术附件");
            writer.close();
            ////FileInputStream可以传入文件对象读取字节流也可以直接读取某路径下的文件字节流，FileInputStream提供有方法传路径进去也去创建文件对象，这点我有点理解开源的好了
            inputStream = new FileInputStream(file);
            //读取到流数据后要新建一个文件存。
            File file1 = new File("D:\\img\\3.png");
            file1.createNewFile();
            //然后写入到新建的文件里,将新建的文件对象给输出流
            outputStream = new FileOutputStream(file1);
            //这里输出流提供的方法不支持一次性写入数据
            //outputStream.write(inputStream);

            byte[] bytes = new byte[1024];
            int size = -1;
            //每次读取1024个字节，写到新创建的文件里
            while ((size = inputStream.read(bytes)) != -1) {
                //inputStream.read(bytes);
                outputStream.write(bytes);
            }
            outputStream.flush();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
