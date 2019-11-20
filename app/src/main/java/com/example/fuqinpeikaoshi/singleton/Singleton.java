package com.example.fuqinpeikaoshi.singleton;

public class Singleton {
//    private Singleton(){}
//    private volatile static Singleton single;
//    public static Singleton getInstance(){
//        if (single==null){
//            synchronized (Singleton.class){
//                if (single==null){
//                    single=new Singleton();
//                }
//            }
//        }
//        return single;
//    }
    private Singleton(){}
    private volatile static Singleton single;
    public static Singleton getInstance(){
        if (single==null){
            synchronized (Singleton.class){
                if (single==null){
                    single=new Singleton();
                }
            }
        }
        return single;
    }

}
