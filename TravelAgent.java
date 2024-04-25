import java.util.ArrayList;
import java.util.Objects;

public class TravelAgent {
    private ArrayList <Trip> perjalanan = new ArrayList<>();
    public ArrayList <String> emailPemesan = new ArrayList<>();
    public ArrayList<String> idPemesan = new ArrayList<>();
    public void addTrip(Trip trip){
        perjalanan.add(trip);
    }
    public void showAvailableTrip(){
        for(int i = 0; i < perjalanan.size(); i++) {
            if (perjalanan.get(i).getJumlah() == 0 && cancel == 0) {
                perjalanan.remove(i);
            }
        }
        System.out.println("Terdapat " + perjalanan.size() + " Trip yang masih tersedia :");
        for(int j = 0; j < perjalanan.size(); j++){
            System.out.println("Destinasi : " + perjalanan.get(j).getTujuan() + " -- Keberangkatan : "
                    + perjalanan.get(j).getWaktu() + " 00:00:00 ICT -- Harga : " + perjalanan.get(j).getHarga()
                    + " -- Qty : " + perjalanan.get(j).getJumlah() + "-- Jenis : " + perjalanan.get(j).getTipe());
        }
    }
    private int tik = 1;
    private Boolean emailAda = false;
    public void bookTrip(Customer customer, Trip trip){
        cekEmail(customer.getEmail());
        if(!emailAda){
            if(trip.getJumlah() != 0) {
                emailPemesan.add(customer.getEmail());
                idPemesan.add("00" + trip.getTujuan() + "00" + trip.getTipe() + tik);
                trip.setJumlah(trip.getJumlah() - 1);
                System.out.println("Pesanan Berhasil dilakukan dengan booking " + "00" + trip.getTujuan() + "00"
                        + trip.getTipe() + tik);
                tik += 1;
            }else {
                System.out.println("Pemesanan gagal, perjalanan ke " + trip.getTujuan() + " telah habis terjual");
            }
        }else {
            System.out.println("Pemesanan gagal, pengguna telah memiliki pesanan pada trip yang sama dengan id "
                    + "00" + trip.getTujuan() + "00" + trip.getTipe() + 1);
        }

    }
    int ada = 0;
    int cancel = 0;
    boolean udah = false;
    public void cancelBooking(String email, Trip trip){
        for(int i = 0; i < emailPemesan.size(); i++){
            ada = 0;
            if(email == emailPemesan.get(i)){
                if(("00" + trip.getTujuan() + "00" + trip.getTipe() + (i + 1)).equals(idPemesan.get(i))){
                    System.out.println("Pesanan dengan id booking " + idPemesan.get(i) + " berhasil dibatalkan");
                    ada += 1;
                    cancel += 1;
                    trip.setJumlah(trip.getJumlah()+1);
                    break;
                }else {
                    if(ada == 0){
                        System.out.println("Pesanan tidak ditemukan");
                    }
                }
            }
            if(trip.getJumlah() > 0 && !udah){
                perjalanan.add(trip);
                udah = true;
            }
        }
    }
    public void cekEmail(String email){
        for(int i = 0; i < emailPemesan.size(); i++){
            if(Objects.equals(email, emailPemesan.get(i))){
                emailAda = true;
            }
        }
    }
    int sama = 0;
    boolean tipeAda = false;
    public void getAvailableTripsByType(Trip.TripType tipe){
        for(int i = 0; i < perjalanan.size(); i++){
            if(tipe == perjalanan.get(i).getTipe()){
                sama += 1;
                tipeAda = true;
            }
        }
        if (tipeAda){
            System.out.println("Ditemukan " + sama + " trip dengan jenis " + tipe);
            for(int i = 0; i < perjalanan.size(); i++){
                if(tipe == perjalanan.get(i).getTipe()){
                    System.out.println("Destinasi : " + perjalanan.get(i).getTujuan() + " -- Keberangkatan : " +
                            perjalanan.get(i).getWaktu() + " 00:00:00 ICT -- Harga : " + perjalanan.get(i).getHarga() +
                            " -- Qty : " + perjalanan.get(i).getJumlah() + "-- Jenis : " + perjalanan.get(i).getTipe());
                }
            }
        }
    }

    int sama2 = 0;
    boolean tglAda = false;
    public void getAvailableTripsByDate(String tgl){
        for(int i = 0; i < perjalanan.size(); i++){
            if(tgl == perjalanan.get(i).getWaktu()){
                sama2 += 1;
                tglAda = true;
            }
        }
        if (tglAda){
            System.out.println("Ditemukan " + sama2 + " trip dengan jadwal keberangkatan pada " + tgl);
            for(int i = 0; i < perjalanan.size(); i++){
                if(tgl == perjalanan.get(i).getWaktu()){
                    System.out.println("Destinasi : " + perjalanan.get(i).getTujuan() + " -- Keberangkatan : " +
                            perjalanan.get(i).getWaktu() + " 00:00:00 ICT -- Harga : " + perjalanan.get(i).getHarga() +
                            " -- Qty : " + perjalanan.get(i).getJumlah() + "-- Jenis : " + perjalanan.get(i).getTipe());
                }
            }
        }
        else {
            System.out.println("Tidak ditemukan data trip dengan jadwal keberangkatan pada " + tgl);
        }
    }
}
