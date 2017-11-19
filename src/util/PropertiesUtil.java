package util;

import org.apache.commons.lang3.StringUtils;


import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by OovEver on 2017/11/19.
 */
public class PropertiesUtil {
//   声明Properties对象
    private static Properties props;
    static {
        String fileName = "属性文件位置.properties";
        props = new Properties();
        try {
//            读取配置文件
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
            System.out.println("配置文件读取异常");
        }
    }

    /***
     *
     * @param key 键值
     * @return 返回获取结果
     */
    public static String getProperty(String key) {
        String value = props.getProperty(key.trim());
//        判断value是否为空，对于isBlank而言""， " "， "      "， null 都返回为空
        if(StringUtils.isBlank(value)){
            return null;
        }
        return value.trim();
    }

    /**
     *
     * @param key 键值
     * @param defaultValue 如果未找到相应的value值，则以defaultValue代替
     * @return  返回获取结果
     */
    public static String getProperty(String key,String defaultValue){

        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            value = defaultValue;
        }
        return value.trim();
    }
}
