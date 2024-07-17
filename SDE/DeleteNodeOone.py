#Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def create_LL(arr):
    head  = ListNode(arr[0])
    curr = head
    for n in arr[1:]:
        curr.next = ListNode(n)
        curr  = curr.next
    return head


class Solution:
    def deleteNode(self, node):
        node.val = node.next.val
        node.next  = node.next.next

ll = create_LL([4,5,1,9])
head  = ll 
ll = ll.next

s = Solution()
s.deleteNode(ll)

while head:
    print(head.val ,end = " ")
    head = head.next