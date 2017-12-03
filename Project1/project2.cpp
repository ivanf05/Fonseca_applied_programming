#include <iostream>
#include "project2.hxx"
using namespace std;

int main(){
//Creating instance of class	
	Dog dog;
//Setting name. type, and age of dog
	dog.setName("George");
	dog.setType("Husky");
	dog.setAge(3);

//Printing out members of class
	cout<< dog.getName()<<"'s a "<<
	dog.getType()<<" and is "<<dog.getAge()
	<<" years old."<<endl;
	system("PAUSE");
}


