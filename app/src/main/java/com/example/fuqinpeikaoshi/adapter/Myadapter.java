package com.example.fuqinpeikaoshi.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.fuqinpeikaoshi.R;
import com.example.fuqinpeikaoshi.bean.PicBean;
import java.util.ArrayList;
import java.util.HashMap;
public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<PicBean.DataBean.ListBean> list;
    private Context context;
    private HashMap<Integer,Boolean> map = new HashMap<>();
    private Boolean onBind;
    public Myadapter(ArrayList<PicBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_adapter, null);
        ViewHorder1 viewHorder1 = new ViewHorder1(inflate);
        return viewHorder1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHorder1 horder1 = (ViewHorder1) holder;
        horder1.name.setText(list.get(position).getName());
        horder1.pic.setText(list.get(position).getPrice() + "");
        Glide.with(context).load(list.get(position).getPic()).into(horder1.img);
        horder1.rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    map.clear();
                    map.put(position, true);
                } else {
                    map.remove (position);
                }
                if (!onBind) {
                    notifyDataSetChanged();
                }
            }
        });
        onBind = true;
        //containsKey是否包含此key
        if (map != null && map.containsKey(position)) {
            //如果选择了 则把然后选中的文件设置为true
           horder1.rb.setChecked(true);
        } else {
            //把之前设置的为false
            horder1.rb.setChecked(false);
        }
        onBind = false;
        horder1.rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onitemlick != null) {
                    onitemlick.onitenlistlick(position);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHorder1 extends RecyclerView.ViewHolder {
        private final CheckBox rb;
        private final ImageView img;
        private final TextView pic;
        private final TextView name;
        public ViewHorder1(@NonNull View itemView) {
            super(itemView);
            rb = itemView.findViewById(R.id.cheak);
            img = itemView.findViewById(R.id.recy_img);
            pic = itemView.findViewById(R.id.recy_pic1);
            name = itemView.findViewById(R.id.recy_name);
        }
    }
    private Onitemlick onitemlick;
    public void setOnitemlick(Onitemlick onitemlick) {
        this.onitemlick = onitemlick;
    }
    public interface Onitemlick {
        void onitenlistlick(int posi);
    }
}
