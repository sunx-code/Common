package com.sunx.common;

import com.sunx.common.charset.UnicodeTools;
import org.junit.Test;

/**
 * Created by sunxing on 2016/11/30.
 */
public class TestUnicode {

    @Test
    public void testToStr(){
        String str = "\\u5b59\\u661f";

        System.out.println(UnicodeTools.toStr(str));
    }

    @Test
    public void testToUnicode(){
        System.out.println(UnicodeTools.toUicode("孙星"));
    }


}
