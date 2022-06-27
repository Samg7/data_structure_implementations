'''
Linked List implementation
Date: June 25, 2022 (06.25.2022)
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

        # Special case: list contains one element
        if current.next is None:
            self.head = None

        # Case: list contains several elements
        previous = current                          # Case: There's only one element in the list
        while current.next is not None:
            previous = current
            current = current.next
        previous.next = None

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
ll.append(4)
ll.print()      # '[4]'
ll.pop()        # []
ll.print()      # 'Linked list is empty'
ll.append(5)    # [5]
ll.append(6)    # [5, 6]
ll.append(1)    # [5, 6, 1]
ll.print()      # '[5, 6, 1]'
ll.pop()        # [5, 6]  
ll.print()      # '[5, 6]'