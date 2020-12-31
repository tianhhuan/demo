package com.company.Util;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class Annotation<T> {
    private T t;
    Map meberValues;
    Map<String,Method> methods;
    public Annotation(Class c, Class<T> annotation) throws IllegalAccessException, NoSuchFieldException {
        t = (T) c.getAnnotation(annotation);
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(t);
        Field field = invocationHandler.getClass().getDeclaredField("memberValues");
        field.setAccessible(true);
        meberValues = (Map) field.get(invocationHandler);
    }
    public Annotation(T c){
        t=c;
        methods=new HashMap<>();
        Method[] methods= c.getClass().getDeclaredMethods();
        for (Method method : methods) {
            this.methods.put(method.getName(),method);
        }
    }
    public void setAnnotationProperty(String property, String value) {
        meberValues.put(property, value);
    }

    public Object getAnnotationProperty(String property) {
        return meberValues.get(property);
    }
    public void execute(String methodName,Object... objs ) throws InvocationTargetException, IllegalAccessException {
        methods.get(methodName).setAccessible(true);
        methods.get(methodName).invoke(t,objs);
    }
}