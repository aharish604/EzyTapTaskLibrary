package com.example.ezytapexample.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataModel implements Serializable {


    @SerializedName("logo-url")
    @Expose
    private String logoUrl;
    @SerializedName("heading-text")
    @Expose
    private String headingText;
    @SerializedName("uidata")
    @Expose
    private ArrayList<Uidatum> uidata = null;

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getHeadingText() {
        return headingText;
    }

    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    public List<Uidatum> getUidata() {
        return uidata;
    }

    public void setUidata(ArrayList<Uidatum> uidata) {
        this.uidata = uidata;
    }


    public class Uidatum implements Serializable {



        @SerializedName("uitype")
        @Expose
        private String uitype;
        @SerializedName("value")
        @Expose
        private String value;

        @Override
        public String toString() {
            return "Uidatum{" +
                    "uitype='" + uitype + '\'' +
                    ", value='" + value + '\'' +
                    ", key='" + key + '\'' +
                    ", hint='" + hint + '\'' +
                    '}';
        }

        @SerializedName("key")
        @Expose
        private String key;
        @SerializedName("hint")
        @Expose
        private String hint;

        public String getUitype() {
            return uitype;
        }

        public void setUitype(String uitype) {
            this.uitype = uitype;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }
    }
}
