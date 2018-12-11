package com.example.lenovo.rpl.moddel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class profilelist {
    @SerializedName("profile")
    @Expose
    private List<Profile> profile = null;

    public List<Profile> getProfile() {
        return profile;
    }

    public void setProfile(List<Profile> profile) {
        this.profile = profile;
    }
}
