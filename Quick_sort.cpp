#include<iostream>
using namespace std;
void sort(int a[],int s,int e,int n)
{
	if(s>=e)
	return;
	int pivot=a[s];
	int i=s+1;
	int j=e;
	while(i<=j)
	{
	
		
		while(a[i]<pivot && i<n)// for ascending i will go out
			i++;
		while(a[j]>pivot && j>=0)// for descending j will go out
			j--;
		if(i<j)
		{
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
	}
	int temp2=a[s];
	a[s]=a[j];
	a[j]=temp2;
	int n1=j-s;
	int n2=e-j;
	sort(a,s,j-1,n1);
	sort(a,j+1,e,n2);

}

int main()
{
	int a[5];
	int i;
	int s;
	int e;
	int n;
	cout<<"Enter no of elements\n";
	cin>>n;
	cout<<"Enter elements\n";
	for(i=0;i<n;i++)
	cin>>a[i];
	s=0;
	e=n-1;
	sort(a,s,e,n);
	 i=0;
	cout<<"Sorted\n";
	for(i=0;i<n;i++)
	cout<<a[i]<<"  ";
	cout<<endl;
	return 0;
}
