import java.util.Scanner;

class Node {
    String nim;
    String nama;
    Node next;

    Node(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;
    private Node tail; // Added tail pointer for O(1) end operations
    private int count;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public void insertAtBeginning(String nim, String nama) {
        Node newNode = new Node(nim, nama);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        count++;
        System.out.println("Data berhasil ditambahkan");
    }

    public void insertAtEnd(String nim, String nama) {
        Node newNode = new Node(nim, nama);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
        System.out.println("Data berhasil ditambahkan");
    }

    public void insertAtPosition(int pos, String nim, String nama) {
        if (pos < 1 || pos > count + 1) {
            System.out.println("Posisi tidak valid (1-" + (count + 1) + ")");
            return;
        }
        if (pos == 1) {
            insertAtBeginning(nim, nama);
            return;
        }
        if (pos == count + 1) {
            insertAtEnd(nim, nama);
            return;
        }

        Node newNode = new Node(nim, nama);
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        count++;
        System.out.println("Data berhasil ditambahkan");
    }

    public void deleteFromBeginning() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada yang dihapus");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        count--;
        System.out.println("Data berhasil dihapus");
    }

    public void deleteFromEnd() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada yang dihapus");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        count--;
        System.out.println("Data berhasil dihapus");
    }

    public void deleteAtPosition(int pos) {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada yang dihapus");
            return;
        }
        if (pos < 1 || pos > count) {
            System.out.println("Posisi tidak valid (1-" + count + ")");
            return;
        }
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }
        if (pos == count) {
            deleteFromEnd();
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        count--;
        System.out.println("Data berhasil dihapus");
    }

    public void deleteFirstOccurrence(String nim) {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada yang dihapus");
            return;
        }
        if (head.nim.equals(nim)) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;
        while (temp.next != null && !temp.next.nim.equals(nim)) {
            temp = temp.next;
        }
        
        if (temp.next != null) {
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
            count--;
            System.out.println("Data dengan NIM " + nim + " berhasil dihapus");
        } else {
            System.out.println("NIM " + nim + " tidak ditemukan");
        }
    }

    public void showData() {
        if (isEmpty()) {
            System.out.println("List kosong");
            return;
        }
        
        System.out.println("\nDATA MAHASISWA");
        System.out.println("Total: " + count + " data");
        
        Node temp = head;
        int index = 1;
        while (temp != null) {
            System.out.println(index + ". " + temp.nim + " - " + temp.nama);
            temp = temp.next;
            index++;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return count;
    }

    public void clearList() {
        head = tail = null;
        count = 0;
        System.out.println("Semua data berhasil dihapus");
    }
}

public class llMahasiswa {
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int choice;

        do {
            displayMenu();
            choice = getValidIntInput("Pilihan: ");

            switch (choice) {
                case 1:
                    handleInsertAtBeginning(list);
                    break;
                case 2:
                    handleInsertAtPosition(list);
                    break;
                case 3:
                    handleInsertAtEnd(list);
                    break;
                case 4:
                    list.deleteFromBeginning();
                    break;
                case 5:
                    handleDeleteAtPosition(list);
                    break;
                case 6:
                    list.deleteFromEnd();
                    break;
                case 7:
                    handleDeleteByNIM(list);
                    break;
                case 8:
                    list.showData();
                    break;
                case 9:
                    handleClearList(list);
                    break;
                case 10:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 10);

        sc.close();
    }

    private static void displayMenu() {
        System.out.println("\n MENU ");
        System.out.println("1. Insert at beginning");
        System.out.println("2. Insert at given position");
        System.out.println("3. Insert at end");
        System.out.println("4. Delete from beginning");
        System.out.println("5. Delete at given position");
        System.out.println("6. Delete from end");
        System.out.println("7. Delete by NIM");
        System.out.println("8. Show all data");
        System.out.println("9. Clear all data");
        System.out.println("10. Exit");
    }

    private static void handleInsertAtBeginning(SinglyLinkedList list) {
        String nim = getNonEmptyInput("NIM: ");
        String nama = getNonEmptyInput("Nama: ");
        list.insertAtBeginning(nim, nama);
    }

    private static void handleInsertAtPosition(SinglyLinkedList list) {
        int pos = getValidIntInput("Posisi: ");
        String nim = getNonEmptyInput("NIM: ");
        String nama = getNonEmptyInput("Nama: ");
        list.insertAtPosition(pos, nim, nama);
    }

    private static void handleInsertAtEnd(SinglyLinkedList list) {
        String nim = getNonEmptyInput("NIM: ");
        String nama = getNonEmptyInput("Nama: ");
        list.insertAtEnd(nim, nama);
    }

    private static void handleDeleteAtPosition(SinglyLinkedList list) {
        int pos = getValidIntInput("Posisi: ");
        list.deleteAtPosition(pos);
    }

    private static void handleDeleteByNIM(SinglyLinkedList list) {
        String nim = getNonEmptyInput("NIM: ");
        list.deleteFirstOccurrence(nim);
    }

    private static void handleClearList(SinglyLinkedList list) {
        System.out.print("Yakin ingin menghapus semua data? (y/n): ");
        String confirm = sc.nextLine().trim().toLowerCase();
        if (confirm.equals("y") || confirm.equals("yes")) {
            list.clearList();
        } else {
            System.out.println("Batal menghapus");
        }
    }

    private static String getNonEmptyInput(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
            }
        } while (input.isEmpty());
        return input;
    }

    private static int getValidIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(sc.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }
}