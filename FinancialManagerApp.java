package ProjekAKHIR;

import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    private String description;
    private double amount;
    private String date; // Format: yyyy-mm-dd

    public Transaction(String description, double amount, String date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    // Getter dan Setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Tanggal  : " + date + "\n   Deskripsi: " + description + "\n   Jumlah   : " + amount + "\n   --------------------";
    }
}

public class FinancialManagerApp {
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n|=== Financial Manager App ===|");
            System.out.println("1. Tambah Transaksi");
            System.out.println("2. Lihat Semua Transaksi");
            System.out.println("3. Edit Transaksi");
            System.out.println("4. Hapus Transaksi");
            System.out.println("5. Urutkan Transaksi");
            System.out.println("6. Keluar");
            System.out.print("\nSilahkan pilih kebutuhan anda: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (choice) {
                case 1 -> addTransaction();
                case 2 -> viewTransactions();
                case 3 -> editTransaction();
                case 4 -> deleteTransaction();
                case 5 -> sortTransactions();
                case 6 -> System.out.println("\nTerima kasih telah menggunakan aplikasi ini!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 6);
    }

    // Tambah transaksi
    private static void addTransaction() {
        System.out.print("\nMasukkan Deskripsi: ");
        String description = scanner.nextLine();
        System.out.print("Masukkan Jumlah (positif untuk pemasukan, negatif untuk pengeluaran): ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan buffer
        System.out.print("Masukkan Tanggal (yyyy-mm-dd): ");
        String date = scanner.nextLine();

        transactions.add(new Transaction(description, amount, date));
        System.out.println("\n|--Transaksi berhasil ditambahkan!--|");
    }

    // Lihat semua transaksi
    private static void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("|--Belum ada transaksi--|");
        } else {
            System.out.println("\n|--- Daftar Transaksi ---|");
            for (int i = 0; i < transactions.size(); i++) {
                System.out.println((i + 1) + ". " + transactions.get(i));
            }
        }
    }

    // Edit transaksi
    private static void editTransaction() {
        viewTransactions();
        if (!transactions.isEmpty()) {
            System.out.print("\nPilih nomor transaksi yang ingin diubah: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Membersihkan buffer

            if (index >= 0 && index < transactions.size()) {
                System.out.print("\nMasukkan deskripsi baru: ");
                String description = scanner.nextLine();
                System.out.print("Masukkan jumlah baru: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Membersihkan buffer
                System.out.print("Masukkan tanggal baru (yyyy-mm-dd): ");
                String date = scanner.nextLine();

                Transaction transaction = transactions.get(index);
                transaction.setDescription(description);
                transaction.setAmount(amount);
                transaction.setDate(date);
                System.out.println("\n--|Transaksi berhasil diubah!--|");
            } else {
                System.out.println("Nomor transaksi tidak valid.");
            }
        }
    }

    // Hapus transaksi
    private static void deleteTransaction() {
        viewTransactions();
        if (!transactions.isEmpty()) {
            System.out.print("\nPilih nomor transaksi yang ingin dihapus: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Membersihkan buffer

            if (index >= 0 && index < transactions.size()) {
                transactions.remove(index);
                System.out.println("\n|--Transaksi berhasil dihapus!--|");
            } else {
                System.out.println("Nomor transaksi tidak valid.");
            }
        }
    }

    // Urutkan transaksi
private static void sortTransactions() {
    System.out.println("Urutkan daftar transaksi berdasarkan:");
    System.out.println("1. Tanggal (ascending)");
    System.out.println("2. Tanggal (descending)");
    System.out.println("3. Jumlah (ascending)");
    System.out.println("4. Jumlah (descending)");
    System.out.print("\nPilihan Anda: ");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Membersihkan buffer

    switch (choice) {
        case 1 -> bubbleSortByDateAscending();
        case 2 -> selectionSortByDateDescending();
        case 3 -> bubbleSortByAmountAscending();
        case 4 -> selectionSortByAmountDescending();
        default -> {
            System.out.println("Pilihan tidak valid.");
            return;
        }
    }
    System.out.println("\n|--Transaksi berhasil diurutkan!--|");
}

// Bubble sort untuk tanggal (ascending)
private static void bubbleSortByDateAscending() {
    for (int i = 0; i < transactions.size() - 1; i++) {
        for (int j = 0; j < transactions.size() - 1 - i; j++) {
            if (transactions.get(j).getDate().compareTo(transactions.get(j + 1).getDate()) > 0) {
                swap(j, j + 1);
            }
        }
    }
}

// Selection sort untuk tanggal (descending)
private static void selectionSortByDateDescending() {
    for (int i = 0; i < transactions.size() - 1; i++) {
        int maxIndex = i;
        for (int j = i + 1; j < transactions.size(); j++) {
            if (transactions.get(j).getDate().compareTo(transactions.get(maxIndex).getDate()) > 0) {
                maxIndex = j;
            }
        }
        swap(i, maxIndex);
    }
}

// Bubble sort untuk jumlah (ascending)
private static void bubbleSortByAmountAscending() {
    for (int i = 0; i < transactions.size() - 1; i++) {
        for (int j = 0; j < transactions.size() - 1 - i; j++) {
            if (transactions.get(j).getAmount() > transactions.get(j + 1).getAmount()) {
                swap(j, j + 1);
            }
        }
    }
}

// Selection sort untuk jumlah (descending)
private static void selectionSortByAmountDescending() {
    for (int i = 0; i < transactions.size() - 1; i++) {
        int maxIndex = i;
        for (int j = i + 1; j < transactions.size(); j++) {
            if (transactions.get(j).getAmount() > transactions.get(maxIndex).getAmount()) {
                maxIndex = j;
            }
        }
        swap(i, maxIndex);
    }
}

// Metode untuk menukar posisi dua transaksi
private static void swap(int i, int j) {
    Transaction temp = transactions.get(i);
    transactions.set(i, transactions.get(j));
    transactions.set(j, temp);
    }
}

