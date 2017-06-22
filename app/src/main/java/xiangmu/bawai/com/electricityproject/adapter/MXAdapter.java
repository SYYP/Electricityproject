package xiangmu.bawai.com.electricityproject.adapter;/**
 * Created by holmes k on 2017.05.19.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xiangmu.bawai.com.electricityproject.R;
import xiangmu.bawai.com.electricityproject.acticity.HomeWebActivity;
import xiangmu.bawai.com.electricityproject.bean.Titlebean;

/**
 * auth:holmes k
 * date:2017.05.19
 */
public class MXAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String utr = "http://image3.suning.cn";
    private Context context;
    private int VIEW_TYPE1 = 1;
    private int VIEW_TYPE2 = 2;
    private List<Titlebean.DataBean.TagBean> tagBeanList;
    private List<Titlebean.DataBean.TagBean> tagList;

    public MXAdapter(Context context, List<Titlebean.DataBean.TagBean> tagBeanList) {
        this.context = context;
        this.tagBeanList = tagBeanList;
        tagList = new ArrayList<>();
        for (int i = 0; i < tagBeanList.size(); i++) {
            if (i > 0) {
                tagList.add(tagBeanList.get(i));
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder = null;
        if (viewType == VIEW_TYPE1) {
            view = LayoutInflater.from(context).inflate(R.layout.home_item5_item_goodsitem, parent, false);
            holder = new MXViewHolder(view);
        } else if (viewType == VIEW_TYPE2) {
            view = LayoutInflater.from(context).inflate(R.layout.home_layout_show_more, parent, false);
            holder = new MXViewHolder1(view);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int itemViewType = getItemViewType(position);

        if (itemViewType == VIEW_TYPE1) {
            MXViewHolder holder1 = (MXViewHolder) holder;
            Glide.with(context).load(utr+ "/uimg/cms/img/148835821506680891.jpg").into(holder1.ivGoodIcon);
            holder1.tvGoodName.setText(tagList.get(position).getElementName());
            holder1.tvGoodPrice.setText("￥15" + position);
        } else {
            MXViewHolder1 holder2 = (MXViewHolder1) holder;
            holder2.rlItemIdMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String linkUrl = tagList.get(0).getLinkUrl();
                    Intent intent = new Intent(context, HomeWebActivity.class);
                    intent.putExtra("web", linkUrl);
                    context.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {


        return tagBeanList != null ? tagBeanList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == tagList.size()) {
            return VIEW_TYPE2;
        } else {
            return VIEW_TYPE1;
        }

    }

    class MXViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_good_icon)
        ImageView ivGoodIcon;
        @BindView(R.id.tv_goodName)
        TextView tvGoodName;
        @BindView(R.id.tv_goodPrice)
        TextView tvGoodPrice;

        public MXViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class MXViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.rl_item_id_more)
        RelativeLayout rlItemIdMore;

        public MXViewHolder1(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
