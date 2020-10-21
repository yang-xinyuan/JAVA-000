package demo.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;

/**
 * @program: test
 * @description:
 * @author: Yang.xinyuan
 * @create: 2020-10-19 23:53
 **/

public class HelloClassLoader extends ClassLoader{
    public static void main(String[] args) {
        try {
            Object hello = new HelloClassLoader().findClass("Hello").newInstance();// 加载并初始化Hello类
            Class<?> aClass = hello.getClass();
            Method method = null;
            method = aClass.getMethod("hello");
            method.invoke(hello);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        File file = new File("/Users/yangxinyuan/Downloads/Hello/Hello.xlass");
        byte[] bytes = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            bytes = baos.toByteArray();
            fis.close();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte)(255- bytes[i]);
        }

        return defineClass(name,bytes,0,bytes.length);
    }

}
