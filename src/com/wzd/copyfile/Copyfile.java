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
    public static void main(String[] args){
        String sourcePath = "E:\\Delacey - Dream It Possible.mp3";
        String destPath = "src\\";
        sourcePath = "E:\\IMG_20190106_141012.jpg";
//        myCopyFile(sourcePath, destPath);
        myCopyFileByBuff(sourcePath, destPath);
    }

    /**
     * @Author     : ZeDongW
     * @Description: 通过缓冲字节流复制文件
     * @Date       : 2019/01/27/0027 12:02
     * @Param      : [sourcePath, destPath]
     * @return     : void
     */
    private static void myCopyFileByBuff(String sourcePath, String destPath) {
        //根据源文件路径，获取源文件对象
        File sourceFile = new File(sourcePath);
        if (!sourceFile.exists()){
            throw new RuntimeException(new FileNotFoundException("该文件不存在"));
        }
        File destFile = getDestFile(destPath, sourceFile);

        //缓冲输入字节流
        BufferedInputStream bufferedInputStream = null;

        //缓冲输出字节流
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFile));
            int length = 0;
            while ((length = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (bufferedInputStream != null){
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }

    }

    /**
     * @Author     : ZeDongW
     * @Description: 根据源文件路径和目标路径，将源文件复制到目标路径
     * @Date       : 2019/01/26/0026 20:05
     * @Param      : [sourcePath, destPath]
     * @return     : void
     */
    private static void myCopyFile(String sourcePath, String destPath) {
        //根据源文件路径，获取源文件对象
        File sourceFile = new File(sourcePath);
        if (!sourceFile.exists()){
            throw new RuntimeException(new FileNotFoundException("该文件不存在"));
        }
        File destFile = getDestFile(destPath, sourceFile);

        FileInputStream fileInputStream = null;

        FileOutputStream fileOutputStream = null;

        //定义一个字节数组，做读写文件的缓存数组
        byte[] buf = new byte[1024*8];

        //字节数组的长度
        int length = 0;

        try {
            //打开源文件的输入流
            fileInputStream = new FileInputStream(sourceFile);

            //打开目标文件的输出流
            fileOutputStream = new FileOutputStream(destFile);


            //读取源文件，同时写入目标文件
            while ((length = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                //关闭输入输出流,先开后关
                if (fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    //关闭输入输出流,先开后关
                    if (fileInputStream != null){
                        fileInputStream.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * @Author     : ZeDongW
     * @Description: 创建目标文件路径
     * @Date       : 2019/01/27/0027 12:12
     * @Param      : [destPath, sourceFile]
     * @return     : java.io.File
     */
    public static File getDestFile(String destPath, File sourceFile) {
        //获取源文件文件名
        String sourceFileName = sourceFile.getName();

        //获取源文件文件扩展名
        String expandedName = sourceFileName.substring(sourceFileName.lastIndexOf("."));

        //根据目标文件路径和源文件扩展名创建目标文件
        return new File(destPath + "newFile" + expandedName);
    }

}
