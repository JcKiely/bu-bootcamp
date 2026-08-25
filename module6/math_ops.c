#include <stdio.h>

void print_math(int a, int b);

int main() {
    int input1;
    int input2;

    printf("Enter first number: ");
    scanf("%d", &input1);

    printf("Enter second number: ");
    scanf("%d", &input2);

    print_math(input1, input2);

    return 0;
}

void print_math(int a, int b) {
    int sum = a + b;
    int prod = a * b;
    printf("Sum: %d\n", sum);
    printf("Product: %d", prod);
}