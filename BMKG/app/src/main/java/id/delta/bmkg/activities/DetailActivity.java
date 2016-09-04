package id.delta.bmkg.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import id.delta.bmkg.R;
import id.delta.bmkg.retrofit.models.cuaca.Besok;
import id.delta.bmkg.retrofit.models.cuaca.Datum;
import id.delta.bmkg.retrofit.models.cuaca.Sekarang;

/**
 * Created by DELTA on 8/19/2016.
 */
public class DetailActivity extends AppCompatActivity {


    Toolbar toolbar;
    Context context;
    Datum datum;
    Sekarang sekarang;
    Besok besok;

    @Bind(R.id.dt_maps)
    ImageView dtMaps;
    @Bind(R.id.title_kota)
    TextView dtKota;
    @Bind(R.id.dt_cuaca)
    TextView dtCuaca;
    @Bind(R.id.dt_suhu)
    TextView dtSuhu;
    @Bind(R.id.dt_tanggal)
    TextView dtTgl;
    @Bind(R.id.dt_kelembaban)
    TextView dtKelembaban;

    @Bind(R.id.dt_cuaca_bs)
    TextView dtCuacaBs;
    @Bind(R.id.dt_suhu_bs)
    TextView dtSuhuBs;
    @Bind(R.id.dt_tanggal_bs)
    TextView dtTglBs;
    @Bind(R.id.dt_kelembaban_bs)
    TextView dtKelembabanBs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cuaca);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        toolbar.setTitle("Prakiraan Cuaca Kota ");
       //
        ButterKnife.bind(this);
        context=this;
        isiTampilan();
    }

    private void isiTampilan(){
        datum = (Datum)getIntent().getSerializableExtra("city");
        getDataDetail();
    }

    private void getDataDetail(){
        String latitude = datum.getMaps().getLatitude();
        String longitude = datum.getMaps().getLongitude();

        // Lokasi Peta https://maps.googleapis.com/maps/api/staticmap?center=5.5482904,95.3237559&zoom=9&size=640x200&sensor=false
        String urlImage = "https://maps.googleapis.com/maps/api/staticmap?center="+latitude+","+longitude+"&zoom=9&size=340x224&sensor=false";
        Glide.with(this).load(urlImage).into(dtMaps);
        dtKota.setText(datum.getKota());
        //Sekarang
        sekarang = datum.getPrakiraan().getSekarang();
        dtTgl.setText("Tanggal "+sekarang.getTgl());
        dtCuaca.setText("Cuaca "+sekarang.getCuaca());
        dtKelembaban.setText("Kelembaban "+sekarang.getKelembaban().getMin()+" - "+sekarang.getKelembaban().getMax());
        dtSuhu.setText("Suhu "+sekarang.getSuhu().getMin()+" - "+sekarang.getSuhu().getMax());

        //Besok
        besok = datum.getPrakiraan().getBesok();
        dtTglBs.setText("Tanggal "+besok.getTgl());
        dtCuacaBs.setText("Cuaca "+besok.getCuaca());
        dtKelembabanBs.setText("Kelembaban "+besok.getKelembaban().getMin()+" - "+besok.getKelembaban().getMax());
        dtSuhuBs.setText("Suhu "+besok.getSuhu().getMin()+" - "+besok.getSuhu().getMax());



    }


}
