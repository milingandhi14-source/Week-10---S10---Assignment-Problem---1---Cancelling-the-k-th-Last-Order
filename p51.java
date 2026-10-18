public class p51 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeKthFromEnd(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node lead = dummy;
        Node trail = dummy;

        // Move lead k + 1 steps ahead
        for (int i = 0; i <= k; i++) {
            lead = lead.next;
        }

        // Move both pointers until lead reaches the end
        while (lead != null) {
            lead = lead.next;
            trail = trail.next;
        }

        // Remove the k-th node from the end
        trail.next = trail.next.next;

        return dummy.next;
    }

    static Node append(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // Sample 1
        Node head1 = null;
        head1 = append(head1, 10);
        head1 = append(head1, 20);
        head1 = append(head1, 30);
        head1 = append(head1, 40);
        head1 = append(head1, 50);

        head1 = removeKthFromEnd(head1, 2);
        System.out.print("Sample 1: ");
        printList(head1);

        // Sample 2
        Node head2 = null;
        head2 = append(head2, 10);
        head2 = append(head2, 20);
        head2 = append(head2, 30);
        head2 = append(head2, 40);
        head2 = append(head2, 50);

        head2 = removeKthFromEnd(head2, 5);
        System.out.print("Sample 2: ");
        printList(head2);
    }
}