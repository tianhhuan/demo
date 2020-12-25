package com.company;

import com.company.obj.newObj;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, CloneNotSupportedException, NoSuchMethodException, InvocationTargetException {
	// write your code heresi
        //通过 new
        newObj newObj1=new newObj(1);

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
        System.out.println("newObj3.newObj1.value:"+newObj3.newObj1.value);
        newObj1.value=11;
        System.out.println("newObj3.newObj1.value:"+newObj3.newObj1.value);

        System.out.println("newObj3.value:"+newObj3.value);
        newObj3.value=11;
        System.out.println("newObj3.value"+newObj3.value);

        //深拷贝需要自己实现属性循环拷贝
        System.out.println("newObj3==null:"+(newObj3==null));
    }
}
