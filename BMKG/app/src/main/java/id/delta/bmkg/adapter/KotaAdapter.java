package id.delta.bmkg.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import id.delta.bmkg.activities.DetailActivity;
import id.delta.bmkg.retrofit.models.cuaca.Datum;
import id.delta.bmkg.view.RecyclerViewFastScroller;

/**
 * Created by DELTA on 8/19/2016.
 */
public final class KotaAdapter extends RecyclerView.Adapter<KotaAdapter.ViewHolder> implements RecyclerViewFastScroller.BubbleTextGetter{

    private List<Datum> items = new ArrayList<>();
    Context context;

    public KotaAdapter(Context context,List<Datum> items) {
        this.context=context;
        this.items=items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Datum data = items.get(position);
        holder.setText(data.getKota());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailActivity.class)
                        .putExtra("city", data));
            }
        });
    }


    @Override
    public String getTextToShowInBubble(final int pos) {
        return Character.toString(items.get(pos).getKota().charAt(0));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        private ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(android.R.id.text1);
        }

        public void setText(CharSequence text) {
            textView.setText(text);
        }
    }
}
