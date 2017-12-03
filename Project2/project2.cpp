#include <iostream>
using namespace std;

class HeadNode{
	//Node object
	class Node{
		public:
			Node* next;
			int data;
	};
	public:
		int list_length =0;
		
		Node* head;
		Node* curr;
		Node* temp;
		//Constructor
		HeadNode(){
			this ->head = NULL;
			this ->curr = NULL;
			this ->temp = NULL;	
		}
		void insert(int data){
			Node* node = new Node();
			node->data = data;
			node->next = NULL;
			if(head != NULL){
				curr = head;
				//Adds nodes to list 
				while(curr -> next != NULL){
					curr = curr ->next;
				}
				curr-> next = node; 
				list_length++;
			}
			//Adds front node
			else
			{
				head = node;
				list_length++;
			}
		}
		void remove(int del){
		
		
			Node* delPtr = NULL;
			temp = head;
			curr = head;
			//Iterates through each node until desired data is reached
			while(curr != NULL && curr->data != del){
				temp = curr;
				curr = curr -> next;
			}
			//Deletes first node in list 
			if(curr == head){
				//Initializes the middle and end of list also
				delPtr = curr;
				curr = curr -> next;
				temp -> next = curr; 
				head= curr;
				delete delPtr;
				list_length--;
				cout<< del<< " was deleted at the Front:"<<endl;
			}
			//Deletes node in middle
		
			//Deletes node in end
			else if(curr -> next == NULL){
				delPtr = curr;
				curr = curr -> next;
				temp -> next = curr; 
				delete delPtr;
				list_length--;
				cout<< del<< " was deleted at the End:"<<endl;		
			}
			else{
				delPtr = curr;
				curr = curr -> next;
				temp -> next = curr; 
				delete delPtr;
				list_length--;
				cout<< del<< " was deleted at the middle:"<<endl;	
			}
		}
		//Tranverses the list and prints it out
		void print(){
			for(curr= head; curr !=NULL; curr = curr ->next){
				cout<< "Element: "<< curr -> data<< ", Length of Linked list: "<<list_length<<endl;
			}	
		}
		void reverse(){
			temp = head;
			curr = head;
			Node* tail; 
			//Iterates through list until right before reaching null
			while(curr -> next!= NULL){
				temp = curr;
				curr = curr -> next;
			}
			//Sets tail to curent pointer
			tail = curr;
			cout<<"Element: "<<tail ->data<<", Length of Linked list: "<<list_length<<endl;
			//Iternates through whole list setting the tail to the temp pointer 
			// and prints out each element until reaching head node.
			while(tail !=head){
				temp = head;
				curr = head;
				while(curr -> next!= NULL){
					temp = curr;
					curr = curr -> next;
					if(temp->next== tail){
						tail =temp;
						cout<<"Element: "<<tail->data<<", Length of Linked list: "<<list_length<<endl;
						break;
					}
				}
			}
		}
};
int main(){
	cout<<"Ivan Fonseca-Project2"<<endl;
	cout<<"Applied Programming Languages-Fall 2017"<<endl;
	cout<<""<<endl;
	
	HeadNode headNode;
	//Adds 10 nodes to linked list
	for(int i=1;i<=10;i++){
		headNode.insert(i);
	}
	headNode.print();
	cout<<""<<endl;
	cout<<"List traversed reversed"<<endl;
	headNode.reverse();
	cout<<""<<endl;
	//Deletes the front, middle, and end Nodes of list

	headNode.remove(1);
	headNode.remove(3);
	headNode.remove(10);
	headNode.print();
	cout<<""<<endl;
	cout<<"List traversed reversed"<<endl;
	headNode.reverse();
	return 0;
}