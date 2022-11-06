#include<stdio.h>
#include<string.h>

int main(){
    char* word = "Hello World!";
    int n = strlen(word);
    // AND
    printf("AND with 127: ");
    for(int i=0; i<n; i++){
        printf("%c", word[i]&127);
    }
    printf("\n");

    // OR
    printf("OR with 127: ");
    for(int i=0; i<n; i++){
        printf("%c", word[i]|127);
    }
    printf("\n");
    
    // XOR
    printf("XOR with 127: ");
    for(int i=0; i<n; i++){
        printf("%c", word[i]^127);
    }
    
    return 0;
}