package org.rocko.nice.common.utils;

import java.util.Arrays;
import java.util.List;

public class TypeConverter {

    public static List<String> ObjectToListStr(Object o) {
        String str = o.toString();
        str = str.substring(1, str.length() - 1);
        return Arrays.asList(str.split(","));
    }
}
