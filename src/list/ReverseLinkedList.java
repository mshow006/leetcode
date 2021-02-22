package list;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = head, tmp;
        while (curr != null) {
            tmp = curr.next;
            curr.next = dummyHead.next;
            dummyHead.next = curr;
            curr = tmp;
        }
        return dummyHead.next;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
