CREATE TABLE konsumen
(
    id SERIAL PRIMARY KEY NOT NULL,
    nama VARCHAR(255),
	alamat TEXT,
    kota CHAR(20),
    provinsi CHAR(20),
    tgl_registrasi TIMESTAMP,
    status CHAR(20)
);