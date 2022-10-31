#include <stdio.h>
#include <stdlib.h>
#include <Windows.h>
#include <conio.h>
#include <time.h>

char option;
int guess;
int lives = 3;
time_t t1; // declare time variable
int randNum;
char tryAgainOption;

int Cenario2(){
    do{

    system("title Cenario 2 - Caminho da escola");
    system("cls");
    ResizeConsole();

    getText("../Textos/Cenario2/inicio.txt");

    gotoxy(0,24);
    printf("Dica: Escreva a opcao desejada");
    gotoxy(0,10);

    option = getchar();
    fflush(stdin);
    switch(option){
        case 'a':
        case 'A':
            system("cls");
            system("title Cenario 2 - Final Neutro");
            getText("../Textos/Cenario2/finalNeutro.txt");
            getch();
        break;

        case 'b':
        case 'B':
            system("cls");
            getText("../Textos/Cenario2/verificar.txt");

            option = getchar();
            fflush(stdin);

            switch(option){
                case 'a':
                case 'A':
                    while(lives > 0){
                        system("cls");
                        getText("../Textos/Cenario2/lutar.txt");

                        srand ((unsigned) time (&t1));
                        randNum = rand() % 10 + 1;

                        gotoxy(0,23);
                        printf("Dica: Apesar de ser Dr., o Pseudo-Aleatorio so sabe contar ate 10");
                        gotoxy(49,3);
                        printf("Vidas: %d",lives);
                        gotoxy(0,5);

                        scanf("%d", &guess);
                        fflush(stdin);
                        if(guess == randNum){
                            system("cls");
                            system("title Cenario 2 - Caminho da escola - Final Verdadeiro");
                            getText("../Textos/Cenario2/finalVerdadeiro.txt");
                            getch();
                            return;
                        }else{
                            lives--;
                            printf("\nNao era nesse numero que ele estava pensando! Agora ele esta pensando em outro!");
                            pressKey();
                        }
                    }
                    tryAgain(&tryAgainOption);

                    break;
                case 'b':
                case 'B':
                    system("cls");
                    system("title Cenario 2 - Caminho da escola - Final Ruim");
                    getText("../Textos/Cenario2/finalRuim.txt");
                    getch();
                    break;
            }
            break;
    }
    }while(tryAgainOption == 's' || tryAgainOption == 's' || tryAgainOption == 'y' || tryAgainOption == 'Y');
    }
