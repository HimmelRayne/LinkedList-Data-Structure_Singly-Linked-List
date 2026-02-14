AI PROMPT:
Please optimize this code from GeeksForGeeks about Linked List, follow the rules that i attach and use Singly Linked List tutorial from this link: https://www.geeksforgeeks.org/dsa/singly-linked-list-tutorial/
This my unoptimized code

==JAVA==
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
    Node head;
    int count = 0;

    void insertAtBeginning(String nim, String nama) {
        Node newNode = new Node(nim, nama);
        newNode.next = head;
        head = newNode;
        count++;
    }

    void insertAtEnd(String nim, String nama) {
        Node newNode = new Node(nim, nama);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        count++;
    }

    void insertAtPosition(int pos, String nim, String nama) {
        if (pos < 1 || pos > count + 1) {
            System.out.println("Posisi tidak valid");
            return;
        }
        if (pos == 1) {
            insertAtBeginning(nim, nama);
            return;
        }
        Node newNode = new Node(nim, nama);
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
        count++;
    }

    void deleteFromBeginning() {
        if (head == null) return;
        head = head.next;
        count--;
    }

    void deleteFromEnd() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) temp = temp.next;
            temp.next = null;
        }
        count--;
    }

    void deleteAtPosition(int pos) {
        if (pos < 1 || pos > count) return;
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) temp = temp.next;
        temp.next = temp.next.next;
        count--;
    }

    void deleteFirstOccurrence(String nim) {
        if (head == null) return;
        if (head.nim.equals(nim)) {
            head = head.next;
            count--;
            return;
        }
        Node temp = head;
        while (temp.next != null && !temp.next.nim.equals(nim)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            count--;
        }
    }

    void showData() {
        Node temp = head;
        if (temp == null) {
            System.out.println("List kosong");
            return;
        }
        while (temp != null) {
            System.out.println(temp.nim + " - " + temp.nama);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        int choice;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at given position");
            System.out.println("3. Insert at end");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete given position");
            System.out.println("6. Delete from end");
            System.out.println("7. Delete first occurrence");
            System.out.println("8. Show data");
            System.out.println("9. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            String nim, nama;
            int pos;

            switch (choice) {
                case 1:
                    System.out.print("NIM: ");
                    nim = sc.nextLine();
                    System.out.print("Nama: ");
                    nama = sc.nextLine();
                    list.insertAtBeginning(nim, nama);
                    break;

                case 2:
                    System.out.print("Posisi: ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("NIM: ");
                    nim = sc.nextLine();
                    System.out.print("Nama: ");
                    nama = sc.nextLine();
                    list.insertAtPosition(pos, nim, nama);
                    break;

                case 3:
                    System.out.print("NIM: ");
                    nim = sc.nextLine();
                    System.out.print("Nama: ");
                    nama = sc.nextLine();
                    list.insertAtEnd(nim, nama);
                    break;

                case 4:
                    list.deleteFromBeginning();
                    break;

                case 5:
                    System.out.print("Posisi: ");
                    pos = sc.nextInt();
                    list.deleteAtPosition(pos);
                    break;

                case 6:
                    list.deleteFromEnd();
                    break;

                case 7:
                    System.out.print("NIM: ");
                    nim = sc.nextLine();
                    list.deleteFirstOccurrence(nim);
                    break;

                case 8:
                    list.showData();
                    break;
            }
        } while (choice != 9);

        sc.close();
    }
}

==PYTHON==
class Node:
    def __init__(self, nim, nama):
        self.nim = nim
        self.nama = nama
        self.next = None


class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.count = 0

    def insert_beginning(self, nim, nama):
        new_node = Node(nim, nama)
        new_node.next = self.head
        self.head = new_node
        self.count += 1

    def insert_end(self, nim, nama):
        new_node = Node(nim, nama)
        if not self.head:
            self.head = new_node
        else:
            temp = self.head
            while temp.next:
                temp = temp.next
            temp.next = new_node
        self.count += 1

    def insert_position(self, pos, nim, nama):
        if pos < 1 or pos > self.count + 1:
            print("Posisi tidak valid")
            return
        if pos == 1:
            self.insert_beginning(nim, nama)
            return

        new_node = Node(nim, nama)
        temp = self.head
        for _ in range(pos - 2):
            temp = temp.next
        new_node.next = temp.next
        temp.next = new_node
        self.count += 1

    def delete_beginning(self):
        if self.head:
            self.head = self.head.next
            self.count -= 1

    def delete_end(self):
        if not self.head:
            return
        if not self.head.next:
            self.head = None
        else:
            temp = self.head
            while temp.next.next:
                temp = temp.next
            temp.next = None
        self.count -= 1

    def delete_position(self, pos):
        if pos < 1 or pos > self.count:
            return
        if pos == 1:
            self.delete_beginning()
            return

        temp = self.head
        for _ in range(pos - 2):
            temp = temp.next
        temp.next = temp.next.next
        self.count -= 1

    def delete_first_occurrence(self, nim):
        if not self.head:
            return
        if self.head.nim == nim:
            self.head = self.head.next
            self.count -= 1
            return

        temp = self.head
        while temp.next and temp.next.nim != nim:
            temp = temp.next
        if temp.next:
            temp.next = temp.next.next
            self.count -= 1

    def show_data(self):
        temp = self.head
        if not temp:
            print("List kosong")
            return
        while temp:
            print(f"{temp.nim} - {temp.nama}")
            temp = temp.next


def main():
    sll = SinglyLinkedList()

    while True:
        print("\n=== MENU ===")
        print("1 Insert at beginning")
        print("2 Insert at given position")
        print("3 Insert at end")
        print("4 Delete from beginning")
        print("5 Delete given position")
        print("6 Delete from end")
        print("7 Delete first occurrence")
        print("8 Show data")
        print("9 Exit")

        choice = int(input("Choice: "))

        if choice == 1:
            nim = input("NIM: ")
            nama = input("Nama: ")
            sll.insert_beginning(nim, nama)

        elif choice == 2:
            pos = int(input("Posisi: "))
            nim = input("NIM: ")
            nama = input("Nama: ")
            sll.insert_position(pos, nim, nama)

        elif choice == 3:
            nim = input("NIM: ")
            nama = input("Nama: ")
            sll.insert_end(nim, nama)

        elif choice == 4:
            sll.delete_beginning()

        elif choice == 5:
            pos = int(input("Posisi: "))
            sll.delete_position(pos)

        elif choice == 6:
            sll.delete_end()

        elif choice == 7:
            nim = input("NIM: ")
            sll.delete_first_occurrence(nim)

        elif choice == 8:
            sll.show_data()

        elif choice == 9:
            break


if __name__ == "__main__":
    main()

AI yang digunakan: 
Gemini as AI Agent
Claude as  Code Finalization