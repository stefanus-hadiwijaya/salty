## Persiapan instalasi project

1.  Persiapkan database postgreSQL and buatlah sebuah database.
2.  Ubah data source untuk username, password and url database pada file `src/main/resources/application.properties` (sesuaikan dengan setingan masing-masing).
3.  Jalankan file `src/main/resources/database.sql` yang berisikan `query create table` untuk tabel konsumen.
4.  Jalankan aplikasi ini melalui IDE (main class nya yaitu `SaltyApplication.java`).
5.  Pastikan Spring Boot Application sudah berjalan dengan batik `(default port 8080)`.
6.  Jalankan seed data dengan mengakses url `localhost:8080/api/konsumen/seed` dari postman (`Method GET`) / browser untuk mengisi data dummy pada aplikasi.
7.  Aplikasi sudah dapat diakses melalui url `localhost:8080/` dari browser.

## Jawaban technical test
* Jawaban untuk technical test java developer dapat dilihat pada root folder project dengan nama file `Technical Test_Java Developer - Stefanus H A.txt`