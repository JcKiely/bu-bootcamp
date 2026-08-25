#include <stdio.h>

void swap(int *a, int *b);
void broken_swap(int a, int b);

int main() {
    int input1 = 1;
    int input2 = 12;
    int input3 = 6;
    int input4 = 7;

    printf("Before swap: x=%d, y=%d\n", input1, input2);
    swap(&input1, &input2);
    printf("After swap: x=%d, y=%d\n", input1, input2);

    printf("Before broken swap: x=%d, y=%d\n", input3, input4);
    broken_swap(input3, input4);
    printf("After broken swap: x=%d, y=%d\n", input3, input4);

    return 0;
}

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// does not work because function is receiving copies of the values, not the addresses
void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}