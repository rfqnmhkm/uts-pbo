public class Perpustakaan {
    protected java.util.List<Buku> daftarBuku;
    protected java.util.List<Anggota> daftarAnggota;

    public Perpustakaan() {
        this.daftarBuku = new java.util.ArrayList<>();
        this.daftarAnggota = new java.util.ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        System.out.println("\nBuku baru telah ditambahkan!");
    }

    public void daftarBukuTersedia() {
        System.out.println("\nDaftar Buku Tersedia:");
        boolean adaBukuTersedia = false;
        for (Buku buku : daftarBuku) {
            if (buku.getStatus().equals("tersedia")) {
                buku.tampilkanInfoBuku();
                adaBukuTersedia = true;
            }
        }
        if(!adaBukuTersedia){
            System.out.println("tidak ada buku brow!!!!!!!!!!");
        }
    }

    public void tambahAnggota(Anggota anggota) {
        daftarAnggota.add(anggota);
        System.out.println("\nAnggota baru telah didaftarkan!");
    }

    public void pinjamBuku(String nomorAnggota, String ISBN) {
        Anggota anggota = null;
        for (Anggota a : daftarAnggota) {
            if (a.getNomorAnggota().equals(nomorAnggota)) {
                anggota = a;
                break;
            }
        }

        if (anggota == null) {
            System.out.println("Anggota tidak ditemukan.");
            return;
        }

        Buku buku = null;
        for (Buku b : daftarBuku) {
            if (b.getISBN().equals(ISBN) && b.getStatus().equals("tersedia")) {
                buku = b;
                break;
            }
        }

        if (buku == null) {
            System.out.println("Buku tidak ditemukan atau tidak tersedia.");
            return;
        }

        buku.setStatus("dipinjam");
        anggota.tambahPinjaman(buku);
        System.out.println("Buku berhasil dipinjam!");
    }

    public void kembalikanBuku(String nomorAnggota, String ISBN) {
        Anggota anggota = null;
        for (Anggota a : daftarAnggota) {
            if (a.getNomorAnggota().equals(nomorAnggota)) {
                anggota = a;
                break;
            }
        }

        if (anggota == null) {
            System.out.println("Anggota tidak ditemukan.");
            return;
        }

        Buku buku = null;
        for (Buku b : anggota.getDaftarPinjaman()) {
            if (b.getISBN().equals(ISBN)) {
                buku = b;
                break;
            }
        }

        if (buku == null) {
            System.out.println("Buku tidak ditemukan dalam daftar pinjaman anggota.");
            return;
        }

        buku.setStatus("tersedia");
        anggota.hapusPinjaman(buku);
        System.out.println("Buku berhasil dikembalikan!");
    }

    public void tampilkanInfoAnggota(String nomorAnggota) {
        Anggota anggota = null;
        for (Anggota a : daftarAnggota) {
            if (a.getNomorAnggota().equals(nomorAnggota)) {
                anggota = a;
                break;
            }
        }

        if (anggota == null) {
            System.out.println("Anggota tidak ditemukan.");
            return;
        }

        anggota.tampilkanInfoAnggota();
    }
}
