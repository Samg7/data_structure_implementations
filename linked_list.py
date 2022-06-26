'''
Linked List implementation
Date: June 25, 2022 (06.25.2022)
'''

class Node(object):
    def __init__(self, data=None, next=None):  # Node constructor, attributes default to None if no arguements are passed
        self.data = data
        self.next = next
        
class LinkedList:
    def __init__(self):  # LinkedList constructor
        self.head = None  # Default constructor creates a head with no reference
        
    # Append to the end of the linked list
    def append(self, new_element):
        new_node = Node(new_element, None)
        # Approach: determine whether to append after head or set new_element as the head
        if self.head is not None:
            current = self.head
            while current.next is not None:  # I can shorten by using "while current.next:" 
                current = current.next
            current.next = new_node
        else:
            self.head = new_node

    def print(self):
        if self.head is not None:
            current = self.head
            list_contents = '[' + str(current.data)  # Fence-post approach 
            current = current.next    #  load next node
            while current:
                list_contents += (', ' + str(current.data))
                current = current.next
            list_contents += ']'
            print(list_contents)
        else:
            print("Linked List is empty")

ll = LinkedList()
ll.print()
ll.append(4)
ll.append(5)
ll.append(6)
ll.print()