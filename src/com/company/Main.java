package com.company;

import com.company.obj.newObj;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, CloneNotSupportedException, NoSuchMethodException, InvocationTargetException, IOException {
	// write your code heresi
        //通过 new
        newObj newObj1=new newObj();

        newObj1.value=2;
        // 反射


        //无参反射创建
        newObj newObj2= (newObj) Class.forName("com.company.obj.newObj").newInstance();

        //带参反射创建
        Constructor constructor=newObj1.getClass().getDeclaredConstructor(new Class[]{int.class});

        constructor.setAccessible(true);
        newObj newObj23= (newObj) constructor.newInstance(new Object[]{1});
        newObj2.newObj1=newObj1;

        //clone
        newObj newObj3= newObj2.Clone();

        // 浅拷贝
        System.out.println("newObj3.newObj1.value(newObj1.value):"+newObj3.newObj1.value);
        newObj1.value=11;
        System.out.println("newObj3.newObj1.value(newObj1.value=11;):"+newObj3.newObj1.value);

        System.out.println("newObj3.value:"+newObj3.value);
        newObj3.value=11;
        System.out.println("newObj3.value"+newObj3.value);

        //深拷贝需要自己实现属性循环拷贝
        System.out.println("newObj3==null:"+(newObj3==null));

        //使用io数据实例 深拷贝
        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream("./objectFile.swf"));


        //深拷贝
        out.writeObject(newObj3);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("./objectFile.swf"));

        newObj newObj31= (newObj) in.readObject();
        System.out.println("newObj31.value"+newObj31.value);
        newObj1.value=13;
        System.out.println("newObj31.newObj1==newObj1:"+(newObj31.newObj1.value));
    }
}
