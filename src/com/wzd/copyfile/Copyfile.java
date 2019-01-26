package com.wzd.copyfile;

import java.io.*;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : Copyfile
 * @description：复制文件
 * @modified By：
 * @date ：Created in 2019/01/26/0026 19:34
 */
public class Copyfile {
    public static void main(String[] args) throws IOException{
        String sourcePath = "E:\\Delacey - Dream It Possible.mp3";
        String destPath = "src\\";
        sourcePath = "E:\\IMG_20190106_141012.jpg";
        myCopyFile(sourcePath, destPath);
    }

    /**
     * @Author     : ZeDongW
     * @Description: 根据源文件路径和目标路径，将源文件复制到目标路径
     * @Date       : 2019/01/26/0026 20:05
     * @Param      : [sourcePath, destPath]
     * @return     : void
     */
    private static void myCopyFile(String sourcePath, String destPath) throws IOException {
        //根据源文件路径，获取源文件对象
        File sourceFile = new File(sourcePath);
        if (!sourceFile.exists()){
            throw new FileNotFoundException("该文件不存在");
        }

        //获取源文件文件名
        String sourceFileName = sourceFile.getName();

        //获取源文件文件扩展名
        String expandedName = sourceFileName.substring(sourceFileName.lastIndexOf("."));

        //根据目标文件路径和源文件扩展名创建目标文件
        File destFile = new File(destPath + "newFile" + expandedName);


        //打开源文件的输入流
        FileInputStream fileInputStream = new FileInputStream(sourceFile);

        //打开目标文件的输出流
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);

        //定义一个字节数组，做读写文件的缓存数组
        byte[] buf = new byte[1024*8];

        //字节数组的长度
        int length = 0;

        //读取源文件，同时写入目标文件
        while ((length = fileInputStream.read(buf)) != -1) {
            fileOutputStream.write(buf, 0, length);
        }

        //关闭输入输出流
        fileInputStream.close();
        fileOutputStream.close();
    }

}
