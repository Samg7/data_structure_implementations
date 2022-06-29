#include <iostream>

const int DEFAULT_CAPACITY = 16;

class Stack 
{
    private:
        int elements[DEFAULT_CAPACITY];
        int length;

    public:
        // Constructors
        Stack(int capacity=DEFAULT_CAPACITY) 
        {
            int temp[capacity];
            this->elements = temp;
            this->length = 0;
        }

        /**
         * @brief Place object e on the top of the stack
         */
        void push(int e)
        {
            elements[length] = e;
            ++length;
        }

        /**
         * @brief Return and remove the top element from the stack
         * 
         * @return int 
         */
        int pop()
        {
            return elements[--length];
        }

        /**
         * @brief Return the top of the element from the stack
         * 
         * @return int 
         */
        int peek()
        {
            return elements[length - 1];
        }

        /**
         * @brief Return the number of elements in the stack
         * 
         * @return int 
         */
        int getLength()
        {
            return length;
        }
};

int main()
{
    std::cout << "Stack.cpp compiles!" << std::endl;
    Stack s1 = Stack();
    std::cout << "Top: " << s1.peek() << std::endl;
    s1.push(4);
    std::cout << "Top: " << s1.peek() << std::endl;
    std::cout << "Length: " << s1.getLength() << std::endl;
    s1.push(6);
    std::cout << "Top: " << s1.peek() << std::endl;
    std::cout << "Length: " << s1.getLength() << std::endl;

    return 0;
}