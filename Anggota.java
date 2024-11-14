public class Anggota {
    protected String nama;
    private String nomorAnggota;
    private String alamat;
    protected java.util.List<Buku> daftarPinjaman;

    public Anggota(String nama, String nomorAnggota, String alamat) {
        this.nama = nama;
        this.nomorAnggota = nomorAnggota;
        this.alamat = alamat;
        this.daftarPinjaman = new java.util.ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public String getNomorAnggota() {
        return nomorAnggota;
    }
    
    public void setNomorAnggota(String nomorAnggota) {
        this.nomorAnggota = nomorAnggota;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public java.util.List<Buku> getDaftarPinjaman() {
        return daftarPinjaman;
    }

    public void tambahPinjaman(Buku buku) {
        this.daftarPinjaman.add(buku);
    }

    public void hapusPinjaman(Buku buku) {
        this.daftarPinjaman.remove(buku);
    }

    public void tampilkanInfoAnggota() {
        System.out.println("Nama: " + nama);
        System.out.println("Nomor Anggota: " + nomorAnggota);
        System.out.println("Alamat: " + alamat);
        System.out.println("Daftar Pinjaman: ");
        for (Buku buku : daftarPinjaman) {
            buku.tampilkanInfoBuku();
        }
    }


}
