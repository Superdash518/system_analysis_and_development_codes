#ifndef RESIZECONSOLE_H_INCLUDED
#define RESIZECONSOLE_H_INCLUDED

HWND WINAPI GetConsoleWindowNT(void)
{
    //declare function pointer type
    typedef HWND WINAPI(*GetConsoleWindowT)(void);
    //declare one such function pointer
    GetConsoleWindowT GetConsoleWindow;
    //get a handle on kernel32.dll
    HMODULE hk32Lib = GetModuleHandle(TEXT("KERNEL32.DLL"));
    //assign procedure address to function pointer
    GetConsoleWindow = (GetConsoleWindowT)GetProcAddress(hk32Lib
    ,TEXT("GetConsoleWindow"));
    //check if the function pointer is valid
    //since the function is undocumented
    if(GetConsoleWindow == NULL){
        return NULL;
    }
    //call the undocumented function
    return GetConsoleWindow();
}

int main(){
HWND hWnd=GetConsoleWindowNT();
MoveWindow(hWnd,1230,600,300,200,TRUE);
}



#endif // RESIZECONSOLE_H_INCLUDED
