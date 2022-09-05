#include<stdio.h>
#include<string.h>

int main()
{
    char* word = "Hello World";
    int len, i;
    len = strlen(word);
    printf("XORed message: ");
    for(int i=0; i<len; i++){
        printf("%c", word[i]^0);
    }
    printf("\n");
    return 0;
} 