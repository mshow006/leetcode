package list;

public class SwapNodesInPairs {

    public ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        newHead.next = swapPairs(head.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode p = head, q = dummyHead;
        while (p != null && p.next != null) {
            q.next = p.next;
            q = q.next;
            p.next = p.next.next;
            q.next = p;
            p = p.next;
            q = q.next;
        }

        return dummyHead.next;
    }
}
