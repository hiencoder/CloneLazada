package vn.edu.imic.clonelazada.utils;

import android.text.TextUtils;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by MyPC on 02/03/2018.
 */

public class ValidateUtils {
    /**
     * Kiểm tra chuỗi text có rỗng hay k
     * @param text
     * @return
     */
    public static boolean isEmpty(String text){
        return text == null || text.trim().equals("null") || text.trim().length() <= 0;
    }

    /**
     * Kiểm tra list có rỗng hay k
     * @param list
     * @return
     */
    public static boolean isEmpty(List list){
        return list == null || list.size() == 0;
    }

    /**
     * Kiểm tra chuỗi chỉ chứa số hay k
     * @param text
     * @return
     */
    public static boolean isValidNumber(String text){
        return TextUtils.isDigitsOnly(text);
    }

    /**
     * Validate email
     * @param email
     * @return
     */
    public static boolean isValidEmail(String email){
        if (Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$",
                Pattern.CASE_INSENSITIVE).matcher(email).matches()) {
            return true;
        }
        return false;
    }

    /**
     * Trả về vị trí của text trong list
     * @param list
     * @param text
     * @return
     */
    public static int getIndexOfTextInList(List<String> list, String text){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(text)){
                return i;
            }
        }
        return -1;
    }
}
