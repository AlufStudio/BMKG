package id.delta.bmkg.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.delta.bmkg.R;
import id.delta.bmkg.adapter.GempaAdapter;
import id.delta.bmkg.retrofit.api.ApiInterface;
import id.delta.bmkg.retrofit.models.gempa.Datum;
import id.delta.bmkg.retrofit.models.gempa.GempaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    Spinner spView;
    ProgressDialog pgDialog;
    Button btnCek;
    Context context;

    private RecyclerView recyclerView;
  //  private ArrayList<Datum> data;
    private GempaAdapter adapter;
    private LayoutInflater inflater;


    List<Datum> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        isiSpinner();
        isiTampilan();
        setupRecycler();
    }


    private void isiSpinner(){
        spView = (Spinner)findViewById(R.id.spinner_view);
        spView.setOnItemSelectedListener(this);

        List<String> view = new ArrayList<String>();
        view.add("Gempa");
        view.add("Prakiraan Cuaca");

        ArrayAdapter<String> viewAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, view);
        viewAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spView.setAdapter(viewAdapter);

    }

    private void isiTampilan(){
        pgDialog = new ProgressDialog(this);
        pgDialog.setIndeterminate(true);
        pgDialog.setCancelable(false);
        btnCek = (Button)findViewById(R.id.tombol_cek);
    }

    private void setupRecycler(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler_hasil);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    private void getDataGempa(){
        pgDialog.setMessage("Sedang Mengambil Data...");
        pgDialog.show();

        final ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        apiInterface.getGempa("gempa").enqueue(new Callback<GempaResponse>() {
            @Override
            public void onResponse(Call<GempaResponse> call, Response<GempaResponse> response) {
                pgDialog.dismiss();
                dataList.clear();
                GempaResponse gempaResponse = response.body();
                if (gempaResponse.getStatus().equals("success")){
                    for (int i = 0; i < gempaResponse.getData().size(); i++){
                        Datum data = gempaResponse.getData().get(i);
                        dataList.add(data);
                    }
                    adapter= new GempaAdapter(context, dataList);
                    recyclerView.setAdapter(adapter);
                } else {

                }

            }

            @Override
            public void onFailure(Call<GempaResponse> call, Throwable t) {
                pgDialog.dismiss();

                if(t instanceof SocketTimeoutException) {
                    Toast.makeText(MainActivity.this, "Request Timeout. Please try again!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Connection Error!", Toast.LENGTH_LONG).show();
                }
                Log.i("FAILURE", t.toString());

            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                getDataGempa();
                btnCek.setVisibility(View.GONE);
               /* btnCek.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getDataGempa();
                    }
                }); */
                break;
            case 1:
                btnCek.setVisibility(View.VISIBLE);
                btnCek.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, CuacaActivity.class));
                    }
                });
             //   startActivity(new Intent(MainActivity.this, CuacaActivity.class));
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void dialogAbout(){
        inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View content = inflater.inflate(R.layout.dialog_tentang, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(content);
        AlertDialog dialog = builder.create();
        dialog.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            dialogAbout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
