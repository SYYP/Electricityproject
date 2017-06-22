package xiangmu.bawai.com.electricityproject.adapter;/**
 * Created by holmes k on 2017.05.19.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xiangmu.bawai.com.electricityproject.R;
import xiangmu.bawai.com.electricityproject.acticity.HomeWebActivity;
import xiangmu.bawai.com.electricityproject.bean.Titlebean;
import xiangmu.bawai.com.electricityproject.util.MyRecyclerViewListener;

/**
 * auth:holmes k
 * date:2017.05.19
 */
public class TeMaiAdapter extends RecyclerView.Adapter<TeMaiAdapter.TeMaiHolder> {
    public static final String utr = "http://image3.suning.cn";

    private Context context;
    private List<Titlebean.DataBean> dataBeen;

    public TeMaiAdapter(Context context, List<Titlebean.DataBean> dataBeen) {

        this.context = context;
        this.dataBeen = dataBeen;
    }


    @Override
    public TeMaiHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.home_item5_item, parent, false);

//        View view = View.inflate(context, R.layout.home_item5_item, null);

        TeMaiHolder holder = new TeMaiHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final TeMaiHolder holder, final int position) {

        if (dataBeen.get(position).getModelFullId() == 10108) {

            String picUrl = utr + dataBeen.get(position).getTag().get(0).getPicUrl();
            Glide.with(context).load(picUrl).into(holder.imgCoupon);
            holder.recViMx.setVisibility(View.GONE);

        } else if (dataBeen.get(position).getModelFullId() == 10109) {
            holder.recViMx.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            MyRecyclerViewListener listener = new MyRecyclerViewListener(context,
                    holder.recViMx);
            listener.setOnItemClickListener(new MyRecyclerViewListener.OnItemClickListener() {
                @Override
                public void onItemClick(int position1, View view) {
                    String linkUrl = dataBeen.get(position).getTag().get(position1).getLinkUrl();
                    Intent intent = new Intent(context, HomeWebActivity.class);
                    intent.putExtra("web", linkUrl);
                    context.startActivity(intent);
                }
            });

            holder.imgCoupon.setVisibility(View.GONE);

            List<Titlebean.DataBean.TagBean> tagBeanList = dataBeen.get(position).getTag();
            holder.recViMx.setAdapter(new MXAdapter(context, tagBeanList));
        }


    }

    @Override
    public int getItemCount() {


        return dataBeen != null ? dataBeen.size() : 0;
    }

    class TeMaiHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_coupon)
        ImageView imgCoupon;
        @BindView(R.id.recVi_mx)
        RecyclerView recViMx;

        public TeMaiHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
