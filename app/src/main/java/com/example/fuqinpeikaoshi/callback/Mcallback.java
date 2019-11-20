package com.example.fuqinpeikaoshi.callback;

import com.example.fuqinpeikaoshi.bean.PicBean;

public interface Mcallback {
    void onSuress(PicBean picBean);
    void onFile(String err);
}
