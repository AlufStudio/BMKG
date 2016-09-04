package id.delta.bmkg.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import id.delta.bmkg.R;
import id.delta.bmkg.adapter.KotaAdapter;
import id.delta.bmkg.retrofit.api.ApiInterface;
import id.delta.bmkg.retrofit.models.cuaca.CuacaResponse;
import id.delta.bmkg.retrofit.models.cuaca.Datum;
import id.delta.bmkg.view.RecyclerViewFastScroller;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tr.xip.errorview.ErrorView;
import tr.xip.errorview.RetryListener;

/**
 * Created by DELTA on 8/18/2016.
 */
public class CuacaActivity extends AppCompatActivity{

    Toolbar toolbar;
    ProgressDialog pgDialog;
    Context context;
    ErrorView errorView;
    RecyclerView recyclerView;
    RecyclerViewFastScroller recyclerViewFastScroller;
    List<Datum> dataList = new ArrayList<>();
    KotaAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuaca);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        context=this;
        isiTampilan();
        getDataCuaca();
    }

    private void isiTampilan(){
        pgDialog = new ProgressDialog(this);
        pgDialog.setIndeterminate(true);
        pgDialog.setCancelable(false);
        errorView = (ErrorView)findViewById(R.id.errorView);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerViewFastScroller = (RecyclerViewFastScroller)findViewById(R.id.fastscroller);
        errorView.setVisibility(View.GONE);
        errorView.setOnRetryListener(new RetryListener() {
            @Override
            public void onRetry() {
                getDataCuaca();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) {
            @Override
            public void onLayoutChildren(final RecyclerView.Recycler recycler, final RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                final int firstVisibleItemPosition = findFirstVisibleItemPosition();
                if (firstVisibleItemPosition != 0) {
                    if (firstVisibleItemPosition == -1)
                        recyclerViewFastScroller.setVisibility(View.GONE);
                    return;
                }
                final int lastVisibleItemPosition = findLastVisibleItemPosition();
                int itemsShown = lastVisibleItemPosition - firstVisibleItemPosition + 1;
                recyclerViewFastScroller.setVisibility(adapter.getItemCount() > itemsShown ? View.VISIBLE : View.GONE);
            }
        });
        recyclerViewFastScroller.setRecyclerView(recyclerView);
        recyclerViewFastScroller.setViewsToUse(R.layout.fastscroller_layout, R.id.fastscroller_bubble, R.id.fastscroller_handle);

    }

    private void getDataCuaca(){
        pgDialog.setMessage("Sedang Mengambil Data...");
        pgDialog.show();

        final ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        apiInterface.getCuaca("cuaca").enqueue(new Callback<CuacaResponse>() {
            @Override
            public void onResponse(Call<CuacaResponse> call, Response<CuacaResponse> response) {
                errorView.setVisibility(View.GONE);
                pgDialog.dismiss();
                dataList.clear();
                CuacaResponse cuacaResponse = response.body();
                if(cuacaResponse.getStatus().equals("success")){
                    for (int i = 0; i <cuacaResponse.getData().size(); i++){
                        Datum datum = cuacaResponse.getData().get(i);
                        dataList.add(datum);
                    }
                    adapter = new KotaAdapter(context, dataList);
                    recyclerView.setAdapter(adapter);
                }else {

                }
            }

            @Override
            public void onFailure(Call<CuacaResponse> call, Throwable t) {
                pgDialog.dismiss();
                errorView.setVisibility(View.VISIBLE);
                recyclerViewFastScroller.setVisibility(View.GONE);

                if(t instanceof SocketTimeoutException) {
                    Toast.makeText(CuacaActivity.this, "Request Timeout. Please try again!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(CuacaActivity.this, "Connection Error!", Toast.LENGTH_LONG).show();
                }
                Log.i("FAILURE", t.toString());

            }
        });
    }
}
