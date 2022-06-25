#include "fifo.h"
#include <iostream.h>
//#include <conio>
using namespace std;

void read(int *s,int &sn,int *f,int &n)
{
    cout<<"enter the no of frames"<<endl;
    cin>>n;
    for (int i=0; i<n; i++) {
        f[i]=-1;
    }
    int j,count =0;
    cout<<"Enter the reference string to end enter -1"<<endl;
    cin>>j;
    while(j >=0)
    {
        s[count]=j;
        count++;
        cin>>j;
    }
    sn=count;
    
}
int check(int *f,int n,int a)
{
    for (int i =0; i<n; i++) {
        if(f[i]==a)
            return 0;
    }
    return 1;
}

int main(void){
    int s[100],f[10],sn,n;
    int pagefault=0;
    int count=0;
    read(s,sn,f,n);
    for(int i=0;i<sn;i++)
    {
        if(check(f,n,s[i]))
        {
            pagefault++;
            f[count]=s[i];
            count = (count+1)%n;
        }
    }
    cout<<"the no of page faults are "<<pagefault<<endl;
    return 0;
}
Output
enter the no of frames
3
Enter the reference string to end enter -1
1 2 3 2 4 1 3 2 4 1 -1
the no of page faults are 6;
