public class Main {
    private static final Perpustakaan perpustakaan = new Perpustakaan();
    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            tampilkanMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1 -> tambahBuku();
                case 2 -> tambahAnggota();
                case 3 -> pinjamBuku();
                case 4 -> kembalikanBuku();
                case 5 -> daftarBukuTersedia();
                case 6 -> tampilkanInfoAnggota();
                case 7 -> tampilkanInfoBuku();
                case 8 -> {
                    System.out.println("Keluar dari aplikasi.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }

    private static void tampilkanMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Buku Baru");
        System.out.println("2. Daftarkan Anggota Baru");
        System.out.println("3. Pinjam Buku");
        System.out.println("4. Kembalikan Buku");
        System.out.println("5. Daftar Buku Tersedia");
        System.out.println("6. Tampilkan Informasi Anggota");
        System.out.println("7. Tampilkan Informasi Buku");
        System.out.println("8. Keluar");
        System.out.print("Pilih opsi: ");
    }

    private static void tambahBuku() {
        System.out.print("\nJudul: ");
        String judul = scanner.nextLine();

        System.out.print("Pengarang: ");
        String pengarang = scanner.nextLine();

        System.out.print("Tahun Terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        System.out.print("ISBN: ");
        String ISBN = scanner.nextLine();

        System.out.print("Status (tersedia/dipinjam): ");
        String status = scanner.nextLine();

        System.out.print("Apakah ini buku digital? (ya/tidak): ");
        String isDigital = scanner.nextLine();

        Buku buku;
        if (isDigital.equalsIgnoreCase("ya")) {
            System.out.print("Format Buku: ");
            String format = scanner.nextLine();
            buku = new BukuDigital(judul, pengarang, tahunTerbit, ISBN, status, format);
        } else {
            buku = new Buku(judul, pengarang, tahunTerbit, ISBN, status);
        }

        perpustakaan.tambahBuku(buku);
    }

    private static void tambahAnggota() {
        System.out.print("\nNama Anggota: ");
        String nama = scanner.nextLine();

        System.out.print("Nomor Anggota: ");
        String nomorAnggota = scanner.nextLine();

        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();

        Anggota anggota = new Anggota(nama, nomorAnggota, alamat);
        perpustakaan.tambahAnggota(anggota);
    }

    private static void pinjamBuku() {
        System.out.print("\nNomor Anggota: ");
        String nomorAnggota = scanner.nextLine();

        System.out.print("ISBN Buku: ");
        String ISBN = scanner.nextLine();

        perpustakaan.pinjamBuku(nomorAnggota, ISBN);
    }

    private static void kembalikanBuku() {
        System.out.print("\nNomor Anggota: ");
        String nomorAnggota = scanner.nextLine();

        System.out.print("ISBN Buku: ");
        String ISBN = scanner.nextLine();

        perpustakaan.kembalikanBuku(nomorAnggota, ISBN);
    }

    private static void daftarBukuTersedia() {
        perpustakaan.daftarBukuTersedia();
    }

    private static void tampilkanInfoAnggota() {
        System.out.print("\nNomor Anggota: ");
        String nomorAnggota = scanner.nextLine();

        perpustakaan.tampilkanInfoAnggota(nomorAnggota);
    }

    private static void tampilkanInfoBuku() {
        System.out.print("\nISBN Buku: ");
        String ISBN = scanner.nextLine();

        Buku buku = null;
        for (Buku b : perpustakaan.daftarBuku) {
            if (b.getISBN().equals(ISBN)) {
                buku = b;
                break;
            }
        }

        if (buku == null) {
            System.out.println("Buku tidak ditemukan.");
        } else {
            buku.tampilkanInfoBuku();
            if (!(buku instanceof BukuDigital)) {
                System.out.println("Jenis Buku: Cetak");
            } else {
                System.out.println("Jenis Buku: Digital");
                System.out.println("Format: " + ((BukuDigital) buku).getFormat());
            }
        }
    }
}
