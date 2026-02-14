class Node:
    __slots__ = ['nim', 'nama', 'next']

    def __init__(self, nim, nama):
        self.nim = nim
        self.nama = nama
        self.next = None


class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.count = 0

    def insert_beginning(self, nim, nama):
        new_node = Node(nim, nama)
        if not self.head:
            self.head = self.tail = new_node
        else:
            new_node.next = self.head
            self.head = new_node
        self.count += 1
        print("Data berhasil ditambahkan")

    def insert_end(self, nim, nama):
        new_node = Node(nim, nama)
        if not self.head:
            self.head = self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
        self.count += 1
        print("Data berhasil ditambahkan")

    def insert_position(self, pos, nim, nama):
        if pos < 1 or pos > self.count + 1:
            print("Posisi tidak valid")
            return

        if pos == 1:
            self.insert_beginning(nim, nama)
            return

        if pos == self.count + 1:
            self.insert_end(nim, nama)
            return

        new_node = Node(nim, nama)
        temp = self.head
        for _ in range(pos - 2):
            temp = temp.next
        new_node.next = temp.next
        temp.next = new_node
        self.count += 1
        print("Data berhasil ditambahkan")

    def delete_beginning(self):
        if not self.head:
            print("List kosong")
            return
        self.head = self.head.next
        if not self.head:
            self.tail = None
        self.count -= 1
        print("Data berhasil dihapus")

    def delete_end(self):
        if not self.head:
            print("List kosong")
            return
        if self.head == self.tail:
            self.head = self.tail = None
        else:
            temp = self.head
            while temp.next != self.tail:
                temp = temp.next
            temp.next = None
            self.tail = temp
        self.count -= 1
        print("Data berhasil dihapus")

    def delete_position(self, pos):
        if pos < 1 or pos > self.count:
            print("Posisi tidak valid")
            return
        if pos == 1:
            self.delete_beginning()
            return
        temp = self.head
        for _ in range(pos - 2):
            temp = temp.next
        temp.next = temp.next.next
        self.count -= 1
        print("Data berhasil dihapus")

    def delete_first_occurrence(self, nim):
        if not self.head:
            print("List kosong")
            return
        if self.head.nim == nim:
            self.delete_beginning()
            return
        temp = self.head
        while temp.next and temp.next.nim != nim:
            temp = temp.next
        if temp.next:
            if temp.next == self.tail:
                self.tail = temp
            temp.next = temp.next.next
            self.count -= 1
            print("Data berhasil dihapus")
        else:
            print("NIM tidak ditemukan")

    def show_data(self):
        if not self.head:
            print("List kosong")
            return
        temp = self.head
        while temp:
            print(f"{temp.nim} - {temp.nama}")
            temp = temp.next


def display_menu():
    print("\n=== MENU ===")
    print("1. Insert at beginning")
    print("2. Insert at given position")
    print("3. Insert at end")
    print("4. Delete from beginning")
    print("5. Delete given position")
    print("6. Delete from end")
    print("7. Delete first occurrence")
    print("8. Show data")
    print("9. Exit")


def main():
    sll = SinglyLinkedList()

    while True:
        display_menu()
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
            print("Program selesai")
            break

        else:
            print("Pilihan tidak valid")


if __name__ == "__main__":
    main()
