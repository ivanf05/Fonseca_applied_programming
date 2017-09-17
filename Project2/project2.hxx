#ifndef FUNCTIONS_H_
#define FUNCTIONS_H_

#include <iostream>
using namespace std;
class Dog{
	public:
		int age;
		string name;
		string type;
		void setName(string n){name = n;}
		string getName(){return name;}
		
		void setType(string t){type = t;}
		string getType(){return type;}
		
		void setAge(int a){age = a;}
		int getAge(){return age;}
};

#endif

