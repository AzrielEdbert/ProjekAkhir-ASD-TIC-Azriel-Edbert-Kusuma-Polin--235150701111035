# ProjekAkhir-ASD-TIC-Azriel-Edbert-Kusuma-Polin--235150701111035

Kode Java yang saya buat dalam projek akhir ini adalah aplikasi Financial Manager yang berfungsi untuk mengelola daftar transaksi keuangan dimana di dalamnya saya menggunakan dua metode sorting yaitu Bubble Sort dan Selection Sort. Aplikasi ini memiliki antarmuka berbasis teks dan memungkinkan pengguna untuk menambah, melihat, mengedit, menghapus, dan mengurutkan transaksi.

1. Kelas Transaction
   Kelas ini merepresentasikan satu transaksi keuangan dengan atribut:
   - description: Deskripsi transaksi (contoh: "Belanja bulanan").
   - amount: Jumlah transaksi (positif untuk pemasukan, negatif untuk pengeluaran).
   - date: Tanggal transaksi dalam format yyyy-mm-dd.
   Kelas ini menyediakan getter, setter, dan metode toString() untuk mencetak informasi transaksi.

2. Kelas FinancialManagerApp
   Kelas ini mengelola daftar transaksi menggunakan ArrayList dan menyediakan fungsi-fungsi berikut:
   a. main()
   Metode utama yang menampilkan menu utama aplikasi. Menu ini menyediakan opsi:
   - Tambah transaksi.
   - Lihat semua transaksi.
   - Edit transaksi.
   - Hapus transaksi.
   - Urutkan transaksi.
   - Keluar.
   Pilihan diproses menggunakan switch-case.

   b. Tambah Transaksi (addTransaction())
   Meminta input deskripsi, jumlah, dan tanggal transaksi dari pengguna, lalu menambahkan transaksi baru ke daftar.

   c. Lihat Semua Transaksi (viewTransactions())
   Menampilkan daftar semua transaksi. Jika daftar kosong, pesan khusus akan ditampilkan.

   d. Edit Transaksi (editTransaction())
   - Menampilkan daftar transaksi.
   - Meminta pengguna memilih transaksi yang akan diubah berdasarkan nomor urut.
   - Memperbarui deskripsi, jumlah, dan tanggal transaksi yang dipilih.
   
   e. Hapus Transaksi (deleteTransaction())
   - Menampilkan daftar transaksi.
   - Meminta pengguna memilih transaksi berdasarkan nomor urut.
   - Menghapus transaksi dari daftar.
   
   f. Urutkan Transaksi (sortTransactions())
   Fungsi ini menawarkan 4 cara untuk mengurutkan transaksi:
   - Berdasarkan tanggal (ascending).
   - Berdasarkan tanggal (descending).
   - Berdasarkan jumlah (ascending).
   - Berdasarkan jumlah (descending).
   
   Urutan diterapkan menggunakan metode sorting berikut:
   - Bubble Sort untuk pengurutan ascending.
   - Selection Sort untuk pengurutan descending.
   
   g. Metode Pendukung Sorting
   - bubbleSortByDateAscending(): Mengurutkan transaksi berdasarkan tanggal secara menaik (ascending) menggunakan Bubble Sort.
   - selectionSortByDateDescending(): Mengurutkan transaksi berdasarkan tanggal secara menurun (descending) menggunakan Selection Sort.
   - bubbleSortByAmountAscending(): Mengurutkan transaksi berdasarkan jumlah secara menaik (ascending) menggunakan Bubble Sort.
   - selectionSortByAmountDescending(): Mengurutkan transaksi berdasarkan jumlah secara menurun (descending) menggunakan Selection Sort.
   - swap(): Menukar posisi dua transaksi di dalam daftar.
