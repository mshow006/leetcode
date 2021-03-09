package list;

public class SortListQuick implements SortList {

    @Override
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode l = left;
        ListNode r = right;
        ListNode cur = head.next;
        head.next = null; // 第一个节点为基准节点，将链表分成两份
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (cur.val < head.val) {
                l.next = cur;
                l = l.next;
            } else {
                r.next = cur;
                r = r.next;
            }
            cur = next;
        }

        left.next = sortList(left.next);
        right.next = sortList(right.next);
        head.next = right.next;
        if (left.next != null) {
            cur = left.next;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = head;
            return left.next;
        } else {
            return head;
        }
    }
}
