package list;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while (true) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && min > lists[i].val) {
                    min = lists[i].val;
                    index = i;
                }
            }
            if (index == -1) break;
            curr.next = new ListNode(min);
            curr = curr.next;
            lists[index] = lists[index].next;
        }

        return dummyHead.next;
    }
}
