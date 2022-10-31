#include <stdio.h>
#include <stdlib.h>
#include <Windows.h>
#include <conio.h>

const char itensMochila[5][25] = {"Cinto de utilidades","Espada","Capa","Manopla","Escudo"};
char itemEscolhido[25];
char tryAgainOption;
char opcao;


int Cenario1(){
    do{
        system("title Cenario 1 - Casa");
        system("cls");
        ResizeConsole();
        getText("../Textos/Cenario1/inicio.txt");

        pressKey();

        int counter = 0;
        for(counter = 0; counter < 3; counter++){
            Beep(2000, 700);
        }
        system("cls");
        getText("../Textos/Cenario1/primeira_pergunta.txt");

        gotoxy(0,24);
        printf("Dica: Escreva a opcao desejada");
        gotoxy(0,10);


        opcao = getchar();
        fflush(stdin);

        switch(opcao){
            case 'a':
            case 'A':
                printf("\nVou dormir mais quinze minutinhos, o que pode acontecer de mal?\n");
                pressKey();
                fflush(stdin);
                system("cls");
                printf("Dormir mais fez voce se atrasar e perder a prova!\n\nPro tip: acorde quando tiver uma prova pra fazer XD\n\n");
                pressKey();
                tryAgain(&tryAgainOption);

                break;
            case 'b':
            case 'B':
                system("cls");
                printf("Voce levanta se levanta e vai buscar somente o necessario para a prova de hoje\n\n");
                printf("Tenho que pegar algo na mochila...mas o que era mesmo?\n\n");

                printf("Itens na mochila:\n");


                for(int i = 0; i < sizeof(itensMochila)/sizeof(itensMochila[0]); i++){
                    printf("%s\n", itensMochila[i]);
                }

                gotoxy(0,24);
                printf("Dica: Escreva o nome do item que voce deve pegar");
                gotoxy(0,12);

                gets(itemEscolhido);

                if(strcmp(itemEscolhido, "capa") == 0 || strcmp(itemEscolhido, "Capa") == 0 || strcmp(itemEscolhido, "CAPA") == 0){
                    printf("Otimo, agora voce esta pronto para ir!");
                    pressKey();
                    Cenario2();
                }
                else{
                    printf("Nao faz sentido voce pegar %s para essa prova", itemEscolhido);
                    pressKey();

                tryAgain(&tryAgainOption);

                }
                break;
            default:
                tryAgain(&tryAgainOption);
                pressKey();
                break;
        }
    }while(tryAgainOption == 's' || tryAgainOption == 's' || tryAgainOption == 'y' || tryAgainOption == 'Y');
}
