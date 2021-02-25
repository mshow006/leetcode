package list;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode detectCycleHash(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();

        ListNode curr = head;
        while (curr != null && !set.contains(curr)) {
            set.add(curr);
            curr = curr.next;
        }

        return curr;
    }
}
