package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Specialization {
    @SerializedName("programNazev")
    public String program;
    @SerializedName("oborNazev")
    public String specialization;
    @SerializedName("eprDeadlinePrihlaska")
    public ValueDate deadline;
}
