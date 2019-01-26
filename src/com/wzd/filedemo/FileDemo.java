package com.wzd.filedemo;

import java.io.File;

/**
 * @author ：ZeDongW
 * @version : Java File类示例
 * @ClassName : FileDemo
 * @description：1.0
 * @modified By：
 * @date ：Created in 2019/01/25/0025 6:25
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("\\src\\com\\wzd\\filestream");
        /*try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.exists());*/
        System.out.println(file.getAbsolutePath());
        System.out.println(File.separator);
    }
}
