package com.sahitya.banksampahsahitya.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistersModel implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("password_confirmation")
    @Expose
    private String passwordConfirmation;

    @SerializedName("nim")
    @Expose
    private String nim;

    @SerializedName("fakultas")
    @Expose
    private String fakultas;

    @SerializedName("jurusan")
    @Expose
    private String jurusan;

    @SerializedName("hp")
    @Expose
    private String hp;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("tanggal_lahir")
    @Expose
    private String tanggalLahir;

    public RegistersModel(){

    }

    protected RegistersModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        email = in.readString();
        password = in.readString();
        passwordConfirmation = in.readString();
        nim = in.readString();
        fakultas = in.readString();
        jurusan = in.readString();
        hp = in.readString();
        alamat = in.readString();
        tanggalLahir = in.readString();
    }

    public static final Creator<RegistersModel> CREATOR = new Creator<RegistersModel>() {
        @Override
        public RegistersModel createFromParcel(Parcel in) {
            return new RegistersModel(in);
        }

        @Override
        public RegistersModel[] newArray(int size) {
            return new RegistersModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    @Override
    public String toString() {
        return "RegistersModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirmation='" + passwordConfirmation + '\'' +
                ", nim='" + nim + '\'' +
                ", fakultas='" + fakultas + '\'' +
                ", jurusan='" + jurusan + '\'' +
                ", hp='" + hp + '\'' +
                ", alamat='" + alamat + '\'' +
                ", tanggalLahir='" + tanggalLahir + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(password);
        parcel.writeString(passwordConfirmation);
        parcel.writeString(nim);
        parcel.writeString(fakultas);
        parcel.writeString(jurusan);
        parcel.writeString(hp);
        parcel.writeString(alamat);
        parcel.writeString(tanggalLahir);
    }
}
