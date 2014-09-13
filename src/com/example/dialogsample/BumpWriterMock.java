package com.example.dialogsample;

import android.*;
import android.R;

/**
 * Created by makiuchi on 2013/07/26.
 */
public class BumpWriterMock {

    private static <T extends IBumpRecord> String getFileSuffix(Class<T> recordClass) {
        return "_Accel.txt";
    }

    /***
     * 指定したファイルが、指定種類かどうかを判断する
     * @param fileName
     * @param recordClass
     * @return
     */
    public static <T extends IBumpRecord> boolean isDirectedFile(String fileName, Class<T> recordClass) {
        try {
            return isDirectedFile(fileName, getFileSuffix(recordClass));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /***
     * 指定したファイルが、指定種類かどうかを判断する
     * @param fileName
     * @param otherStrings
     * @return
     */
    public static boolean isDirectedFile(String fileName, String... otherStrings) {
        try {
            for (String item : otherStrings) {
                System.out.println(item);
                if (fileName.toLowerCase().endsWith(item.toLowerCase())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
