public class Buku {
    // ini saya kasih public karena bisa diakses dimanapun
    // dan protected juga dapat diakses dikelas yang lain
    public String judul;
    public String pengarang;
    public int tahunTerbit;
    protected String ISBN;
    protected String status;

    public Buku(String judul, String pengarang, int tahunTerbit, String ISBN, String status) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
        this.ISBN = ISBN;
        this.status = status;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.equals("tersedia") || status.equals("dipinjam")) {
            this.status = status;
        }
    }

    public void tampilkanInfoBuku() {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Status: " + status);
    }
}
