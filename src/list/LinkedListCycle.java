package list;

public class LinkedListCycle {

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode p = head, q = head.next;
        while (p != null && q != null && q.next != null) {
            if (p == q) {
                return true;
            }

            p = p.next;
            q = q.next.next;
        }
        return false;
    }
}
