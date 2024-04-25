public class Trip {
    private String tujuan;
    private int harga;
    private String waktu;
    enum TripType{
        FLIGHT,
        HOTEL,
        PACKAGE
    }

    private TripType tipe;

    private int jumlah;

    public Trip(String tujuan, int harga, String waktu, TripType tipe, int  jumlah){
        this.tujuan = tujuan;
        this.harga = harga;
        this.tipe = tipe;
        this.waktu = waktu;
        this.jumlah = jumlah;
    }
    public String getTujuan() {
        return tujuan;
    }

    public int getHarga() {
        return harga;
    }

    public String getWaktu() {
        return waktu;
    }

    public int getJumlah() {
        return jumlah;
    }
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    public TripType getTipe() {
        return tipe;
    }
}
