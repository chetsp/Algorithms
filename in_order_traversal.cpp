#include<iostream>
#include<cstdlib>
using namespace std;

struct node
{ 
int data;
node *right,*left;
};

class del
{node *root;
public:
del()
{root=NULL;}
void insert(int x);
void display();
void inorder(node *p);
void inorder1();

};

void del::inorder1()
{node *p=root;
node *a[10];
int top=-1;
while(1)
	{while(p!=NULL)
		{a[++top]=p;
		p=p->left;
		}
	if(top!=-1)
		{p=a[top--];
		cout<<p->data<<"  ";
		p=p->right;
		}
	else break;
	}
}

void del::insert(int x)
{ node *temp=new node;
temp->data=x;
temp->right=temp->left=NULL;
node *t=root;
node *foll=NULL;
if(root==NULL)
	root=temp;
else
{ while(t!=NULL)
{foll=t;
if(x<t->data)
	t=t->left;
  else if(x>t->data)
	t=t->right;
  else
	{cout<<"Duplicate";
	return;
	}
}
if(x<foll->data)
	foll->left=temp;
else
	foll->right=temp;
}
}

void del::display()
{
	inorder(root);
}

void del::inorder(node *p) {

	if(p==NULL)
		return ;

		inorder(p->left);
		cout << p->data << " ";
		inorder(p->right);
}


int main()
{del d;
int n,a[10];
cout<<"Enter no. of nodes:";
cin>>n;
cout<<”Enter elements.”
for(int i=0;i<n;i++)
{cin>>a[i];
d.insert(a[i]);
} 
cout<<endl<<"Recursive in-order:"<<endl;

d.display();
cout<<endl<<"Non-recursive"<<endl;
d.inorder1();
return 0;
}

OUTPUT:
Enter no. of nodes:
5
Enter elements.
8
3
6
2
5
Recursive in-order:
2  3  5  6  8
Non-recursive
2  3  5  6  8
