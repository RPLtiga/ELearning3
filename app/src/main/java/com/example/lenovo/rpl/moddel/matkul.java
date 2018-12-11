package com.example.lenovo.rpl.moddel;

import com.google.gson.annotations.SerializedName;

public class matkul {
    @SerializedName("id_matkul")
    private String id;
    @SerializedName("nama_matkul")
    private String nama;
    @SerializedName("dosen")
    private String dosen;
    @SerializedName("jadwal")
    private String jadwal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }
}
