
package id.delta.bmkg.retrofit.models.cuaca;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Besok  implements Serializable {

    @SerializedName("tgl")
    @Expose
    private String tgl;
    @SerializedName("cuaca")
    @Expose
    private String cuaca;
    @SerializedName("suhu")
    @Expose
    private Suhu_ suhu;
    @SerializedName("kelembaban")
    @Expose
    private Kelembaban_ kelembaban;

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
    public Suhu_ getSuhu() {
        return suhu;
    }

    /**
     * 
     * @param suhu
     *     The suhu
     */
    public void setSuhu(Suhu_ suhu) {
        this.suhu = suhu;
    }

    /**
     * 
     * @return
     *     The kelembaban
     */
    public Kelembaban_ getKelembaban() {
        return kelembaban;
    }

    /**
     * 
     * @param kelembaban
     *     The kelembaban
     */
    public void setKelembaban(Kelembaban_ kelembaban) {
        this.kelembaban = kelembaban;
    }

}
