package com.cqu;

import lombok.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @version 1.0
 * @author:罗天天
 * @date 2021/3/13  13:59
 * ReadTxtData:  采用BIO模式读取txt文件，并按照行存入configList
 */
@Data
public class ReadTxtData {

    private  List<String> configList = new CopyOnWriteArrayList<>();

    public List<String> getConfigList() {
        return configList;
    }

    public void setConfigList(List<String> configList) {
        this.configList = configList;
    }

    //NIO按行读取
    public void readLineNio(String filePath) {

        //RandomAccessFile因为它可以指定位置读,指定位置写的一个类,通常开发过程中,多用于多线程下载一个大文件.
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw")) {

            FileChannel channel = randomAccessFile.getChannel();//与此文件关联的文件通道
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);//allocate()方法用于分配缓冲区。
            //从该通道读取到给定缓冲区的字节序列。
            int readBytesNum = channel.read(buffer);  // 读取的字节数，可能为零，如果通道已达到流出端， 则为-1

            ByteBuffer stringBuffer = ByteBuffer.allocate(1024);//分配缓冲区
            while (readBytesNum != -1) {

                //Buffer有两种模式，写模式和读模式。在写模式下调用flip()之后，Buffer从写模式变成读模式。
                buffer.flip();
                boolean merger = false;
                //hasRemaining() 告诉当前位置和极限之间是否有任何元素
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    if (b == 10 || b == 13) {
                        merger = true;
                    } else {
                        if (merger) {
                            stringBuffer.flip();
                            String line = Charset.forName("utf-8").decode(stringBuffer).toString();
                            stringBuffer.clear();
                            line=Utils.delSpace(line);//去除空格
                            configList.add(line);
                            merger = false;

                        }
                        if (!stringBuffer.hasRemaining()) {
                            stringBuffer = reAllocate(stringBuffer);
                        }
                        stringBuffer.put(b);
                    }
                }
                buffer.clear();
                readBytesNum = channel.read(buffer);
            }

            if (stringBuffer.position() != 0) {
                stringBuffer.flip();
                String line = Charset.forName("utf-8").decode(stringBuffer).toString();
                stringBuffer.clear();
                line=Utils.delSpace(line);//去除空格
                configList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private ByteBuffer reAllocate(ByteBuffer stringBuffer) {
        //返回此缓冲区的容量。
        final int capacity = stringBuffer.capacity();
        byte[] newBuffer = new byte[capacity * 2];
        //src表示源数组，srcPos表示源数组要复制的起始位置，desc表示目标数组，length表示要复制的长度。
        System.arraycopy(stringBuffer.array(), 0, newBuffer, 0, capacity);
        //将一个字节数组包装到缓冲区中。    position(capacity)设置此缓冲区的位置。
        return (ByteBuffer) ByteBuffer.wrap(newBuffer).position(capacity);
    }



}
