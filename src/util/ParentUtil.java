package util;

/**
 * Created by OovEver on 2017/11/20.
 * Parent类
 */
public class ParentUtil {
    protected Class clazz;
    public ParentUtil() {
        try {
            throw new Exception();
        } catch (Exception e) {
//            获得异常栈信息
            StackTraceElement stes[]= e.getStackTrace();
//            获得继承的子类名称,stes[0].getClassName为父类名称
//            如果想要获取继承children的类，即当前类的“孙子”类，则调用stes[2].getClassName,依此类推
            String serviceImpleClassName=   stes[1].getClassName();
            try {
//               通过反射获取类名
                Class  serviceImplClazz= Class.forName(serviceImpleClassName);
                String serviceImpleClassSimpleName = serviceImplClazz.getSimpleName();
                System.out.println(serviceImpleClassSimpleName);
//                获取该类所在的包名
                String pojoPackageName = serviceImplClazz.getPackage().getName();
//                获得该类的完整路径
                String pojoFullName = pojoPackageName +"."+ serviceImpleClassSimpleName;
                clazz=Class.forName(pojoFullName);
                System.out.println(clazz);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }
}
