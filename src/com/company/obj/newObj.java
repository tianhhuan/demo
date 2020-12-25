package com.company.obj;

public class newObj implements Cloneable {
    public int value;
    public newObj newObj1;
    public newObj(int nu){
        value=1;
        System.out.println("newObj 无参构造");
    }
    public newObj(){
        value=1;
        System.out.println("newObj 无参构造");
    }
    public newObj Clone() throws CloneNotSupportedException {
        return (newObj) clone();
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
