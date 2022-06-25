
#include "opt.h"
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
    cout<<"Enter the refrence string to end enter -1"<<endl;
    cin>>j;
    while(j >=0)
    {
        s[count]=j;
        count++;
        cin>>j;
    }
    sn=count;
}

int forwardcheck(int i,int *s,int sn,int *f,int n)
{
    for(int q =0;q<n;q++){
        if(f[q] == -1)
            return q;
    }
    int pos =0;
    int where;
    for(int k =0;k<n;k++){
        int flag = 0;
        for(int j = i+1;j<sn;j++){
            if(s[j]==f[k]){
                flag = 1;
                if(j-i>pos){
                    pos = j-i;
                    where = k;
                }
                break;
            }
        }
        if (flag==0) {
            return k;
        }
    }
    return where;
}

int check(int *f,int n,int a)
{
    for (int i =0; i<n; i++)
    {
        if(f[i]==a)
            return 0;
    }
    return 1;
}
int main(void){
    int s[100],f[10],sn,n;
    int pagefault=0;
    read(s,sn,f,n);
    cout<<endl;
    for(int i=0;i<sn;i++)
    {
        if(check(f,n,s[i]))
        {
            pagefault++;
            f[forwardcheck(i,s,sn,f,n)]=s[i];
        }
        cout<<f[0]<<"\t"<<f[1]<<"\t"<<f[2]<<endl;
        cout<<endl;
    }
    cout<<"the no of page faults are "<<pagefault<<endl;
    return 0;
}

Output
Enter the refrence string to end enter -1
1 2 3 2 4 1 3 2 4 1 -1

1	-1	-1

1	2	-1

1	2	3

1	2	3

1	4	3

1	4	3

1	4	3

1	4	2

1	4	2

1	4	2

the no of page faults are 5
