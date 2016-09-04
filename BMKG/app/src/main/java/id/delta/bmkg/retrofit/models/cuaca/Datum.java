
package id.delta.bmkg.retrofit.models.cuaca;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Datum implements Serializable {

    @SerializedName("kota")
    @Expose
    private String kota;
    @SerializedName("maps")
    @Expose
    private Maps maps;
    @SerializedName("prakiraan")
    @Expose
    private Prakiraan prakiraan;

    /**
     * 
     * @return
     *     The kota
     */
    public String getKota() {
        return kota;
    }

    /**
     * 
     * @param kota
     *     The kota
     */
    public void setKota(String kota) {
        this.kota = kota;
    }

    /**
     * 
     * @return
     *     The maps
     */
    public Maps getMaps() {
        return maps;
    }

    /**
     * 
     * @param maps
     *     The maps
     */
    public void setMaps(Maps maps) {
        this.maps = maps;
    }

    /**
     * 
     * @return
     *     The prakiraan
     */
    public Prakiraan getPrakiraan() {
        return prakiraan;
    }

    /**
     * 
     * @param prakiraan
     *     The prakiraan
     */
    public void setPrakiraan(Prakiraan prakiraan) {
        this.prakiraan = prakiraan;
    }

}
