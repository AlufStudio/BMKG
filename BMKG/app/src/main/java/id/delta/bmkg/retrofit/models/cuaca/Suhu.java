
package id.delta.bmkg.retrofit.models.cuaca;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Suhu implements Serializable {

    @SerializedName("min")
    @Expose
    private String min;
    @SerializedName("max")
    @Expose
    private String max;

    /**
     * 
     * @return
     *     The min
     */
    public String getMin() {
        return min;
    }

    /**
     * 
     * @param min
     *     The min
     */
    public void setMin(String min) {
        this.min = min;
    }

    /**
     * 
     * @return
     *     The max
     */
    public String getMax() {
        return max;
    }

    /**
     * 
     * @param max
     *     The max
     */
    public void setMax(String max) {
        this.max = max;
    }

}
