#include <stdio.h>
#include <stdlib.h>
#include <Windows.h>
#include <conio.h>

void getText(char filepath[100]){
	int c;
	FILE *file;
	file = fopen(filepath, "r");
	if (file) {
	    while ((c = getc(file)) != EOF)
	    putchar(c);
	    fclose(file);
	}
}

void pressKey(){
    printf("\n\n\n\nPressione qualquer tecla para continuar...");
    getch();
    fflush(stdin);
}

void tryAgain(char* tryAgainOption){
system("cls");
printf("Gostaria de tentar novamente? s/n\n\n");
scanf("%c",tryAgainOption);
fflush(stdin);
}


int main() {
	Cenario1();
    return 0;
}















