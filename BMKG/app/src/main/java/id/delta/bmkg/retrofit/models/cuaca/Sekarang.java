
package id.delta.bmkg.retrofit.models.cuaca;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Sekarang implements Serializable {

    @SerializedName("tgl")
    @Expose
    private String tgl;
    @SerializedName("cuaca")
    @Expose
    private String cuaca;
    @SerializedName("suhu")
    @Expose
    private Suhu suhu;
    @SerializedName("kelembaban")
    @Expose
    private Kelembaban kelembaban;

    /**
     * 
     * @return
     *     The tgl
     */
    public String getTgl() {
        return tgl;
    }

    /**
     * 
     * @param tgl
     *     The tgl
     */
    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    /**
     * 
     * @return
     *     The cuaca
     */
    public String getCuaca() {
        return cuaca;
    }

    /**
     * 
     * @param cuaca
     *     The cuaca
     */
    public void setCuaca(String cuaca) {
        this.cuaca = cuaca;
    }

    /**
     * 
     * @return
     *     The suhu
     */
    public Suhu getSuhu() {
        return suhu;
    }

    /**
     * 
     * @param suhu
     *     The suhu
     */
    public void setSuhu(Suhu suhu) {
        this.suhu = suhu;
    }

    /**
     * 
     * @return
     *     The kelembaban
     */
    public Kelembaban getKelembaban() {
        return kelembaban;
    }

    /**
     * 
     * @param kelembaban
     *     The kelembaban
     */
    public void setKelembaban(Kelembaban kelembaban) {
        this.kelembaban = kelembaban;
    }

}
