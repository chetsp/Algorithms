import java.util.Scanner;
public class powerOfTwo {
	static Scanner s1=new Scanner(System.in);
	int powTwo(int i)
	{if(i==0)
		return 1;
	if(i==1)
		return 2;
	int q=i/2;
	int temp=powTwo(q);
	if(i%2==0)
		{
			return temp*temp;
		}
	else
	{

		return 2*temp*temp; 
		
	}
	
	}
	void sort(int arr[],int i,int n)
	{
		if(i==n)return;
		int key=arr[i],j;
		for(j=i-1;j>=0 && arr[j]>key;j--)
		{
			arr[j+1]=arr[j];
		}
		arr[j+1]=key;
		sort(arr,i+1,n);
	}
	
	void binSearch(int a[],int low,int high,int key)
	{int mid=(low+high)/2+1;
		
		while(low<high)
		{
			if(key<a[mid])
			{
				binSearch(a,low,high,key);
			}
			else if(key>a[mid])
			{
				low=mid+1;
				binSearch(a,low,high,key);
			}
			else if(key==a[mid])
				{System.out.println("Key element found");
				}
			break;
		}
		if(low==high)
			{System.out.println("Element not found");
			return;
			}
	}
                   public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
int x,key,c;
powerOfTwo p=new powerOfTwo();
System.out.println("Enter ur choice");
System.out.println("1- Power of two");
System.out.println("2-Binary Search");
System.out.println("3-Insertion Sort");
c=s.nextInt();
switch(c)
{case 1:
	System.out.println("Enter value:");
	x=s.nextInt();
	x=p.powTwo(x);
	System.out.println(x);
	break;
case 2:
	int i,n;
	System.out.println("Enter the no. of elements");
	n=s.nextInt();
	int b[]=new int[n];
	System.out.println("Enter elements:");
	for(i=0;i<n;i++)
		b[i]=s.nextInt();
	int low=0;
	int high=n-1;
	System.out.println("Enter element to be found:");
	key=s.nextInt();
	p.binSearch(b,low,high,key);
	break;
case 3:
	System.out.println("Enter the no. of elements");
	n=s.nextInt();
	int a[]=new int[n];
	System.out.println("Enter elements:");
	for(i=0;i<n;i++)
		a[i]=s.nextInt();
	if(n>1)
		p.sort(a,1,n);
	System.out.println("Sorted order is : ");
	for( i=0;i<n;i++)
	System.out.print(a[i]);	
		System.out.println();
	break;
		
	}
	}

}






OUTPUT:
Enter ur choice
1- Power of two
2-Binary Search
3-Insertion Sort
1
Enter value:
10
1024

Enter ur choice
1- Power of two
2-Binary Search
3-Insertion Sort
2
Enter the no. of elements
5
Enter elements:
1 5 8 9 6
Enter element to be found:
9
Key element found

Enter ur choice
1- Power of two
2-Binary Search
3-Insertion Sort
3
Enter the no. of elements
5
Enter elements:
1 5 8 9 7
Sorted order is : 
1 5 7 8 9


