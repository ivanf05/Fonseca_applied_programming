#include <iostream>
 
using namespace std;
 

class StackManager {
    public:
 
    class Node {
		public:
        Node(int val) { element = val; next = 0; };
        Node *next;
        int element;
 
    };
 
    void insert(int val);
    void pop(int i);
    void traverse();
	void traverseReverse();
 
    Node *headPtr;
 
};
void StackManager::pop(int i){
	int stop =0;
	Node *currPtr = headPtr;
	//Pop operation
	for(currPtr= headPtr; stop !=i; currPtr = currPtr ->next){
		cout << "Popped: " << headPtr->element<< endl;
		headPtr = headPtr->next;
	
		delete currPtr;
		stop++;    
	}	
};
 
 void StackManager::insert(int val) {
    // Always inserts at the head node(Fifo)
 
	Node* currPtr = new Node(val);
	currPtr ->next=headPtr;
	headPtr = currPtr;
 
};

 void StackManager::traverseReverse() {
		Node* temp = headPtr;
		Node* curr = headPtr;
		Node* tail; 
		//Iterates through list until right before reaching null
			while(curr -> next!= NULL){
				temp = curr;
				curr = curr -> next;
			}
			//Sets tail to curent pointer
			tail = curr;
			cout<<"Element: "<<tail ->element<<endl;
			//Iternates through whole list setting the tail to the temp pointer 
			// and prints out each element until reaching head node.
			while(tail !=headPtr){
				temp = headPtr;
				curr = headPtr;
				while(curr -> next!= NULL){
					temp = curr;
					curr = curr -> next;
					if(temp->next== tail){
						tail =temp;
						cout<<"Element: "<<tail->element<<endl;
						break;
					}
				}
			}
		};
 void StackManager::traverse() {
	 //Prints Stack starting from top
	Node *currPtr = headPtr;
	for(currPtr= headPtr; currPtr !=0; currPtr = currPtr ->next){
		cout<< "Element: "<< currPtr -> element<<endl;
		}	
};		
int main() {
  
 
    // STACK OPERATIONS
 
	StackManager *sm = new StackManager();
    // Insert 10 elements
    for ( int i = 0; i < 10; i++ ) {
		sm->insert(i);
    }
	//Prints Stack
	sm->traverse();
	// Pop off 3 elements

	sm->pop(3);
		
   
	// Print out all the elements of the stack
	sm->traverse();     
 
}