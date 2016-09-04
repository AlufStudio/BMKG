package id.delta.bmkg.adapter;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import id.delta.bmkg.R;
import id.delta.bmkg.retrofit.models.gempa.Datum;
import id.delta.bmkg.view.TouchImageView;

/**
 * Created by Administrator on 8/18/16.
 */
public class GempaAdapter extends RecyclerView.Adapter<GempaAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Datum> items = new ArrayList<>();
    final Context context;

    public GempaAdapter (Context context, List<Datum> items){
        this.context = context;
        this.items = items;
    }
    @Override
    public GempaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gempa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GempaAdapter.ViewHolder viewHolder, int i) {
        final Datum data = items.get(i);

     //   final ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.hsKedalaman.setText(data.getKedalaman());
        viewHolder.hsLokasi.setText(data.getLokasi());
        viewHolder.hsTanggal.setText(Html.fromHtml(data.getTgl()));
        viewHolder.hsMagnitudo.setText(Html.fromHtml(data.getMagnitudo()));
        viewHolder.hsWaktu.setText(data.getWaktu());
        viewHolder.titLokasi.setText(data.getDirasakan());
        viewHolder.hsLintang.setText(data.getLintangBujur());

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inflater = (LayoutInflater)viewHolder.cardView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View content = inflater.inflate(R.layout.item_gempa_dialog, null);
                final ImageView hsImage = (ImageView ) content.findViewById(R.id.hs_image);

                Glide.with(content.getContext()).load(data.getImg()).into(hsImage);

                AlertDialog.Builder builder = new AlertDialog.Builder(viewHolder.cardView.getContext());
                builder.setView(content);
                final AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public CardView cardView;
        public TextView hsTanggal, hsLokasi, hsWaktu, hsKedalaman, hsMagnitudo,hsLintang, titLokasi;
      //  public ImageView hsImage;

        public ViewHolder (View view){
            super(view);

            cardView = (CardView)view.findViewById(R.id.card_hasil);
            hsKedalaman = (TextView)view.findViewById(R.id.hs_kedalaman);
            hsLokasi = (TextView)view.findViewById(R.id.hs_lokasi);
            hsMagnitudo = (TextView)view.findViewById(R.id.hs_magnitudo);
            hsTanggal = (TextView)view.findViewById(R.id.hs_tanggal);
            hsWaktu = (TextView)view.findViewById(R.id.hs_waktu);
            titLokasi = (TextView)view.findViewById(R.id.title_lokasi);
            hsLintang = (TextView)view.findViewById(R.id.hs_lintang);

        }
    }
}
