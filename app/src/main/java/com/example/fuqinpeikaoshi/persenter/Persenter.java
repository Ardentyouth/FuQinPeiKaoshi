package com.example.fuqinpeikaoshi.persenter;
import com.example.fuqinpeikaoshi.bean.PicBean;
import com.example.fuqinpeikaoshi.callback.Mcallback;
import com.example.fuqinpeikaoshi.mainview.MainView;
import com.example.fuqinpeikaoshi.model.Model;
public class Persenter implements Mcallback , Percallback{
    private MainView mainView;
    private Model model;

    public Persenter(MainView mainView) {

        this.mainView = mainView;
        model=new Model();
    }

    @Override
    public void onSuress(PicBean picBean) {

        mainView.onSuress(picBean);
    }

    @Override
    public void onFile(String err) {
        mainView.onFile(err);
    }

    @Override
    public void getpic() {
model.onCallback(this);
    }
}
