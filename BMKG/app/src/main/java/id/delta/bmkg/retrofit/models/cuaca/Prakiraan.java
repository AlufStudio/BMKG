
package id.delta.bmkg.retrofit.models.cuaca;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Prakiraan implements Serializable {

    @SerializedName("sekarang")
    @Expose
    private Sekarang sekarang;
    @SerializedName("besok")
    @Expose
    private Besok besok;

    /**
     * 
     * @return
     *     The sekarang
     */
    public Sekarang getSekarang() {
        return sekarang;
    }

    /**
     * 
     * @param sekarang
     *     The sekarang
     */
    public void setSekarang(Sekarang sekarang) {
        this.sekarang = sekarang;
    }

    /**
     * 
     * @return
     *     The besok
     */
    public Besok getBesok() {
        return besok;
    }

    /**
     * 
     * @param besok
     *     The besok
     */
    public void setBesok(Besok besok) {
        this.besok = besok;
    }

}
