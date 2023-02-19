package Go2023;

public class ReorderList143 {
    public void reorderList(ListNode head) {
        //find mid
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;

        //break mid
        mid.next = null;

        //reverse second half list
        ListNode head2 = reverse(midNext);

        //merge two list
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        while (head != null && head2 != null) {
            curr.next = head;
            curr = curr.next;
            head = head.next;

            curr.next = head2;
            curr = curr.next;
            head2 = head2.next;
        }
        if (head != null) {
            curr.next = head;
        }

        if (head2 != null) {
            curr.next = head2;
        }
    }

    //1 2 3 4
    //  ^

    //1 2 3 4 5
    //    ^
    private ListNode getMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
