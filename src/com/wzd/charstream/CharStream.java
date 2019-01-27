package com.wzd.charstream;

import java.io.*;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : CharStream
 * @description：字符流
 * @modified By：
 * @date ：Created in 2019/01/27/0027 12:28
 */
public class CharStream {
    public static void main(String[] args) {
//        writeChar();
//        reedChar();
//        fileReaderDemo();
//        fileReaderDemoByBuf();
//        fileWriterDemo();
        bufferedCopyDemo();
    }

    /**
     * @Author     : ZeDongW
     * @Description: 使用buffered读写文件
     * @Date       : 2019/01/27/0027 21:02
     * @Param      : []
     * @return     : void
     */
    private static void bufferedCopyDemo() {
        File sourceFile = new File("src\\reedme.txt");
        File destFile = new File("src\\com\\wzd\\charstream\\b.txt");

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(sourceFile));
            bufferedWriter = new BufferedWriter(new FileWriter(destFile));

            String str = null;

            while ((str = bufferedReader.readLine()) != null){
                bufferedWriter.write(str);
                bufferedWriter.newLine(); //换行
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (bufferedReader != null){
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }

    }

    /**
     * @return : void
     * @Author : ZeDongW
     * @Description: 输出字符流
     * @Date : 2019/01/27/0027 18:32
     * @Param : []
     */
    private static void fileWriterDemo() {
        String str = "大家新年快乐！！！";

        File file = new File("src\\a.txt");

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file);

            fileWriter.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * @Author     : ZeDongW
     * @Description: 通过数组缓存
     * @Date       : 2019/01/27/0027 19:21
     * @Param      : []
     * @return     : void
     */
    private static void fileReaderDemoByBuf() {
        File file = new File("src\\a.txt");

        FileReader fileReader = null;

        char[] chars = new char[1024*8];

        try {
            fileReader = new FileReader(file);

            int content = 0;

            while ((content = fileReader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, content));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    /**
     * @return : void
     * @Author : ZeDongW
     * @Description: 输入字符流
     * @Date : 2019/01/27/0027 18:30
     * @Param : []
     */
    private static void fileReaderDemo() {
        File file = new File("src\\a.txt");

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);

            int content = 0;

            while ((content = fileReader.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * @return : void
     * @Author : ZeDongW
     * @Description: 缓冲字节流
     * @Date : 2019/01/27/0027 18:30
     * @Param : []
     */
    private static void reedChar() {
        File file = new File("src\\a.txt");

        //缓冲字节流
        BufferedInputStream bufferedInputStream = null;

        StringBuffer sb = new StringBuffer();

        try {

            //初始化
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[2];
            int length = 0;
            while ((length = bufferedInputStream.read(bytes)) != -1) {
                sb.append(new String(bytes));
            }

            System.out.println(sb);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    /**
     * @return : void
     * @Author : ZeDongW
     * @Description: 缓冲字节流
     * @Date : 2019/01/27/0027 18:29
     * @Param : []
     */
    private static void writeChar() {
        String str = "大家好！！！";
        File file = new File("src\\a.txt");

        //缓冲字节流
        BufferedOutputStream bufferedOutputStream = null;

        try {
            //将字符串转化为字节数组
            byte[] bytes = str.getBytes();
            //初始化
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));

            //写文件
            bufferedOutputStream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
