package com.vwaber.quipstage;

import android.os.Parcel;
import android.os.Parcelable;

import com.vwaber.adquip.backend.quipService.model.QuipData;

public class QuipParcelable implements Parcelable{

    public static final String EXTRA_KEY = "quip-intent-parcelable-extra-key";

    private final String setup;
    private final String punchline;

    public String getSetup(){return setup;}
    public String getPunchline(){return punchline;}

    public QuipParcelable(QuipData data) {
        setup = data.getSetup();
        punchline = data.getPunchline();
    }

    private QuipParcelable(Parcel in) {
        setup = in.readString();
        punchline = in.readString();
    }

    public static final Creator<QuipParcelable> CREATOR = new Creator<QuipParcelable>() {
        @Override
        public QuipParcelable createFromParcel(Parcel in) {
            return new QuipParcelable(in);
        }

        @Override
        public QuipParcelable[] newArray(int size) {
            return new QuipParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(setup);
        parcel.writeString(punchline);
    }
}
