package id.delta.bmkg.retrofit.api;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import id.delta.bmkg.retrofit.models.cuaca.CuacaResponse;
import id.delta.bmkg.retrofit.models.gempa.GempaResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 8/18/16.
 */
public interface ApiInterface {

   // GET http://ibacor.com/api/bmkg?view=...

    String BASE_URL = "http://ibacor.com/api/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(new OkHttpClient.Builder().readTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS).build())
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
            .build();


    @GET("bmkg")
    Call<GempaResponse> getGempa(@Query("view") String view);

    @GET("bmkg")
    Call<CuacaResponse> getCuaca(@Query("view") String view);

}
