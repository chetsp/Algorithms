#include<iostream>
#include<malloc.h>
using namespace std;

struct node
{
  int data,pri;
  node *link;
};

 class priority
{   public:
   node *first;
   
        priority()
   	 {
        first=NULL;
    	  }
	void insert(int,int);
	int deleteq();
	void display();
};

 void priority::insert(int data,int pri)
{
       node *tmp;
	node *pq=first;
	tmp =new node;
       tmp->data=data;
     tmp->pri=pri;
    if(first==NULL )
      { first=tmp;
           first->link=NULL;
   	 }
else if(tmp->pri<pq->pri)
	{tmp->link=pq;
	first=tmp;
	}
  else
        {
           node *p =first->link;
            node *prev=first;
            while(p!=NULL)
              {     
                       if(tmp->pri<p->pri)
                 	{
                        prev->link=tmp;
                         tmp->link=p;
			break;
                    	}
			prev=p;
                    p=p->link; 
              }
	if(p==NULL)
		{prev->link=tmp;
		tmp->link=NULL;
		}
	}
}

int priority::deleteq()
{
	node *temp=first;
	if(first==NULL)
		{cout<<"Queue Underflow";
		return 0;
		}
	first=first->link;
	delete(temp);
	return 1;
}


void priority::display()
{ node *t=first;
if(first==NULL)
		{cout<<"Queue Underflow";
		}
else
{
cout<<"DATA \t PRIORITY"<<endl;
while(t!=NULL)
	{cout<<t->data<<"\t"<<t->pri<<endl;
	t=t->link;
	}
}
}



int main()
{ priority pt;
  int x,e,pr;
char y;
do{
cout<<"Enter your choice: \n 1: Insertion \n 2:Deletion \n 3:Display "<<endl;
cin>>x;
switch(x)
{case 1: cout<<"Enter element:"; cin>>e;
	cout<<"Enter priority:"; cin>>pr;
	 pt.insert(e,pr);break;
case 2: pt.deleteq(); pt.display(); break;
case 3: pt.display();break;
default: cout<<"ERROR! Duh!";
}
cout<<"Enter y to continue:";
cin>>y;
}while(y=='y');
return 1;
}



OUTPUT:
Enter your choice
Insertion
Deletion
Display
1
Enter element
5
Enter priority
10
Enter y to continue:
y
Enter your choice
Insertion
Deletion
Display
1
Enter element
3
Enter priority
1
Enter y to continue:
y
Enter your choice
Insertion
Deletion
Display
1
Enter element
7
Enter priority
3
Enter y to continue:
y
Enter your choice
Insertion
Deletion
Display
3
DATA    PRIORITY
3		1
7		3
5		10
Enter y to continue:
y
Enter your choice
Insertion
Deletion
Display
2
DATA    PRIORITY
7		3
5		10




