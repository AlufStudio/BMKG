
package id.delta.bmkg.retrofit.models.gempa;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Datum {

    @SerializedName("tgl")
    @Expose
    private String tgl;
    @SerializedName("waktu")
    @Expose
    private String waktu;
    @SerializedName("lintang_bujur")
    @Expose
    private String lintangBujur;
    @SerializedName("magnitudo")
    @Expose
    private String magnitudo;
    @SerializedName("kedalaman")
    @Expose
    private String kedalaman;
    @SerializedName("lokasi")
    @Expose
    private String lokasi;
    @SerializedName("dirasakan")
    @Expose
    private String dirasakan;
    @SerializedName("img")
    @Expose
    private String img;

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
     *     The waktu
     */
    public String getWaktu() {
        return waktu;
    }

    /**
     * 
     * @param waktu
     *     The waktu
     */
    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    /**
     * 
     * @return
     *     The lintangBujur
     */
    public String getLintangBujur() {
        return lintangBujur;
    }

    /**
     * 
     * @param lintangBujur
     *     The lintang_bujur
     */
    public void setLintangBujur(String lintangBujur) {
        this.lintangBujur = lintangBujur;
    }

    /**
     * 
     * @return
     *     The magnitudo
     */
    public String getMagnitudo() {
        return magnitudo;
    }

    /**
     * 
     * @param magnitudo
     *     The magnitudo
     */
    public void setMagnitudo(String magnitudo) {
        this.magnitudo = magnitudo;
    }

    /**
     * 
     * @return
     *     The kedalaman
     */
    public String getKedalaman() {
        return kedalaman;
    }

    /**
     * 
     * @param kedalaman
     *     The kedalaman
     */
    public void setKedalaman(String kedalaman) {
        this.kedalaman = kedalaman;
    }

    /**
     * 
     * @return
     *     The lokasi
     */
    public String getLokasi() {
        return lokasi;
    }

    /**
     * 
     * @param lokasi
     *     The lokasi
     */
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    /**
     * 
     * @return
     *     The dirasakan
     */
    public String getDirasakan() {
        return dirasakan;
    }

    /**
     * 
     * @param dirasakan
     *     The dirasakan
     */
    public void setDirasakan(String dirasakan) {
        this.dirasakan = dirasakan;
    }

    /**
     * 
     * @return
     *     The img
     */
    public String getImg() {
        return img;
    }

    /**
     * 
     * @param img
     *     The img
     */
    public void setImg(String img) {
        this.img = img;
    }

}
