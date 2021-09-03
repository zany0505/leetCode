package leetcode.editor.cn;
//链表中倒数第k个节点
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 👍 244 👎 0

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        ListNode nodestr = new ListNode(1); //创建首结点
        ListNode nextNode;     //创建下一个结点
        nextNode = nodestr;    //指向首结点
        //创建链表 12345
        for (int i = 2; i < 6; i++) {
            ListNode newNode = new ListNode(i);  //创建新的结点
            nextNode.next = newNode;     // 把新结点连起来
            nextNode = nextNode.next; //把结点往后移
        }//nextNode指向最后一个结点
        nextNode = nodestr;


        ListNode kthFromEnd = solution.getKthFromEnd(nextNode, 2);
        while (kthFromEnd != null) {
            System.out.println(kthFromEnd.val);
            kthFromEnd = kthFromEnd.next;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && k > 0) {
                fast = fast.next;
                k--;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}