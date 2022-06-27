'''
Linked List implementation
Date: June 25, 2022 (06.25.2022)
'''

'''
Notes:
    1) I need to go back and verify each function is tests for an empty list
        - fpop() was recently fixed
    2) I should re-visit my implementations and refactor where possible
'''


class Node(object):
    def __init__(self, data=None, next=None):           # Node constructor
        self.data = data
        self.next = next
        
class LinkedList:
    def __init__(self):                                 # LinkedList constructor
        self.head = None                                # Default constructor creates a head with no reference
        
    # Appends to the end of the linked list
    def append(self, new_element):
        new_node = Node(new_element, None)
        # Approach: determine whether to append after head or set new_element as the head
        if self.head is not None:
            current = self.head
            while current.next is not None:             # I can shorten by using "while current.next:" 
                current = current.next
            current.next = new_node
        else:
            self.head = new_node
    
    def pop(self):
        current = self.head

        if current is None:
            return

        # Special case: list contains one element
        if current.next is None:
            self.head = None
            return

        # Case: list contains several elements
        previous = current                              # Case: There's only one element in the list
        while current.next is not None:
            previous = current
            current = current.next
        previous.next = None

    def search(self, value):
        index = 0
        current = self.head

        while current is not None:
            if current.data == value:
                return index
            index += 1
            current = current.next
        return -1                                       # Assertion: value not found

    '''
    Reversing a linked list
        The setup:
            1. initially 'current' and 'following' are set to head (covers single element case)
            2. previous is set to null (no prior element exists)
    '''
    def reverse(self):
        previous = None
        current = self.head
        following = self.head

        while current is not None:
            following = following.next
            current.next = previous
            previous = current 
            current = following
            
        self.head = previous

    def print(self):
        if self.head is not None:
            current = self.head
            list_contents = '[' + str(current.data)     # Fence-post approach 
            current = current.next                      # Load next node
            while current:
                list_contents += (', ' + str(current.data))
                current = current.next
            list_contents += ']'
            print(list_contents)
        else:
            print("Linked List is empty")

###################
# Function testing
ll = LinkedList()
ll.print()      # 'Linked list is empty'
return_val = ll.search(4)
print('Index of target: ' + str(return_val)) # expecting -1, empty list
ll.append(4)
ll.print()      # '[4]'
return_val = ll.search(4)
print('Index of target: ' + str(return_val)) # expecting 0, first element in the list
ll.pop()        # []
ll.print()      # 'Linked list is empty'
ll.append(5)    # [5]
ll.append(6)    # [5, 6]
ll.append(1)    # [5, 6, 1]
ll.print()      # '[5, 6, 1]'
return_val = ll.search(1)
print('Index of target: ' + str(return_val)) # expecting 2, last element in the list
ll.pop()        # [5, 6]
ll.print()      # '[5, 6]'
return_val = ll.search(1)
print('Index of target: ' + str(return_val)) # expecting -1, value was recently popped
ll.append(8)
ll.append(3)
ll.print()
ll.reverse()
ll.print()