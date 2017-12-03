#include <stdio.h>
#include <string.h>

#define BUF_SIZE 8

int main() {
	
    char buf1[BUF_SIZE]="Noon is a 12";
    char buf2[BUF_SIZE];
	
    strncpy(buf2,buf1,BUF_SIZE);
    printf("%s\n", buf2); 
    return 0;
}
