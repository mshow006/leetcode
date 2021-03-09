package list;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode dummyHead = new ListNode(0);
        ListNode res = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                res.next = left;
                left = left.next;
            } else {
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }
        res.next = left != null ? left : right;
        return dummyHead.next;
    }
}
