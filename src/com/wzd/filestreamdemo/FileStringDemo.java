package com.wzd.filestreamdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : FileStringDemo
 * @description：文件输入输出流演示
 * @modified By：
 * @date ：Created in 2019/01/26/0026 6:40
 */
public class FileStringDemo {
    public static void main(String[] args) throws IOException{
        File file = new File("src\\com\\wzd\\filestreamdemo\\a.txt");
        file.createNewFile();
//       writeTest1(file);
        writeTest2(file);
//        readTest1(file);
//        readTest2(file);
//        readTest3(file);
        readTest4(file);
    }

    /**
     * @Author     : ZeDongW
     * @Description: 字节数组写入文件
     * @Date       : 2019/01/26/0026 8:16
     * @Param      : [file]
     * @return     : void
     */
    private static void writeTest2(File file) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String str = "hello";
        byte[] arr = str.getBytes();
        fileOutputStream.write(arr);
        fileOutputStream.close();
    }

    /**
     * @Author     : ZeDongW
     * @Description: 向文件写入数据
     * @Date       : 2019/01/26/0026 8:10
     * @Param      : [file]
     * @return     : void
     */
    private static void writeTest1(File file) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write('h');
        fileOutputStream.write('e');
        fileOutputStream.write('l');
        fileOutputStream.write('l');
        fileOutputStream.write('o');
        fileOutputStream.close();
    }

    /**
     * @Author     : ZeDongW
     * @Description: 循环配额和数组读取文件
     * @Date       : 2019/01/26/0026 7:50
     * @Param      : [file]
     * @return     : void
     */
    private static void readTest4(File file) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(file);
        int length = 0;
        byte[] buf = new byte[1024*8];
        while ((length = fileInputStream.read(buf)) != -1){
            System.out.print(new String(buf, 0, length));
        }
        fileInputStream.close();
    }

    /**
     * @Author     : ZeDongW
     * @Description: 通过字节数组读取文件
     * @Date       : 2019/01/26/0026 7:42
     * @Param      : [file]
     * @return     : void
     */
    private static void readTest3(File file) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buf = new byte[1024*8];
        int length = fileInputStream.read(buf);
        String content = new String(buf, 0, length);
        System.out.println(content);
    }

    /**
     * @Author     : ZeDongW
     * @Description: 通过循环读取文件内容
     * @Date       : 2019/01/26/0026 7:35
     * @Param      : [file]
     * @return     : void
     */
    private static void readTest2(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        int content = 0;
        while ((content = fileInputStream.read()) != -1){
            System.out.print((char) content);
        }
        fileInputStream.close();
    }

    /**
     * @Author     : ZeDongW
     * @Description: 读取单个字节
     * @Date       : 2019/01/26/0026 7:32
     * @Param      : [file]
     * @return     : void
     */
    private static void readTest1(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        System.out.println((char)fileInputStream.read());
        fileInputStream.close();
    }


}
