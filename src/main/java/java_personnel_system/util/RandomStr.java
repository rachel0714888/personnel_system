package java_personnel_system.util;

import java.util.Random;

/**
 * @auther Rachel
 * @date 2023/6/11 19:21
 */
public class RandomStr {
    private static String strPool =
            "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    public static String getRandomString(){
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            sb.append(strPool.charAt(r.nextInt(strPool.length())));
        }
        return sb.toString();
    }
}
