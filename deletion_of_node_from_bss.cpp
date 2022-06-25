#include <iostream>
using namespace std;
template<class T>
struct Node {
	int data;
	Node *left;
	Node *right;
};
class BST {
	Node *root;
	void preorder(Node *p);
		void inorder(Node *p);
		void postorder(Node *p);
		Node*makeNode(int v);
		public:
	BST() {
		root = NULL;
	}
	void insert(int v);
	void display();
	void del(int v);
};
void BST::del(int v)
{
	Node *p=root,*prev=NULL;
	while(p!=NULL)
	{
		if(p->data==v)
			break;
		prev=p;
		if(p->data<v)
			p=p->right;
		else p=p->left;
	}
	if(p==NULL);
	else if(p->left!=NULL&&p->right!=NULL)
	{
		prev=p;
		Node *suc=p->right;
		while(suc->left!=NULL)
			{
			prev=suc;
			suc=suc->left;
			}
		p->data=suc->data;
		if(prev->right==suc)
			prev->right=suc->right;
		else prev->left=suc->right;

		p=suc;
	}
	else if(p==root)
	{
		if(p->left!=NULL)
			root=p->left;
		else root=p->right;
	}
	else if(p->left==NULL&&p->right==NULL)
	{
		if(prev->left==p)
			prev->left=NULL;
		else prev->right=NULL;
	}
	else if(p->left!=NULL&&p->right==NULL)
		{
			if(prev->left==p)
				prev->left=p->left;
			else prev->right=p->left;
		}
	else if(p->left==NULL&&p->right!=NULL)
		{
			if(prev->left==p)
				prev->left=p->right;
			else prev->right=p->right;
		}
	delete p;
}
Node* BST::makeNode(int v) {
	Node *newnode = new Node;
	newnode->data = v;
	newnode->left = NULL;
	newnode->right = NULL;
	return newnode;
}
void BST::insert(int v) {
	if (root == NULL) {
		root = makeNode(v);
	} else {
		Node *p = root;
		Node *q = root;
		while (q != NULL) {
			p = q;
			if (v < p->data)
				q = p->left;
			else
				q = p->right;
		}
		if (v < p->data)
			p->left = makeNode(v);
		else
			p->right = makeNode(v);
	}
}
void BST::preorder(Node *p) {
	if (p != NULL) {
		cout << p->data << " ";
		preorder(p->left);
		preorder(p->right);
	}
}
void BST::inorder(Node *p) {
	if (p != NULL) {

		inorder(p->left);
		cout << p->data << " ";
		inorder(p->right);
	}
}
void BST::postorder(Node *p) {
	if (p != NULL) {

		postorder(p->left);
		postorder(p->right);
		cout << p->data << " ";
	}
}
void BST::display() {
	cout << "ENTER YOUR CHOICE\n1.PREORDER\n2.INORDER\n3.POSTORDER\n";
	int ch;
	cin >> ch;
	switch (ch) {
	case 1:
		preorder(root);
		break;
	case 2:
		inorder(root);
		break;
	case 3:
		postorder(root);
		break;
	}
}
int main() {
	BST b;
		int ch, a;

	cout << "ENTER YOUR CHOICE\n1.TO INSERT\n2.TO DISPLAY\n3.TO DELETE\n4.TO QUIT\n";
	do{
	cin >> ch;
	switch (ch) {
	case 1:
		cout << "ENTER THE NO. TO INSERT\n";
		cin >> a;
		b.insert(a);
		break;
	case 2:
		b.display();
		break;
	case 3:
		cout<<"DELETE NODE : ";
		cin>>a;
		b.del(a);
		break;
	case 4:
		break;
	}
		}
	while(ch!=4);
	return 0;
}











OUTPUT:
ENTER YOUR CHOICE
1.TO INSERT
2.TO DISPLAY
3.TO DELETE
4.TO QUIT
1
ENTER THE NO. TO INSERT
5
1
ENTER THE NO. TO INSERT
3
1
ENTER THE NO. TO INSERT
1
1
ENTER THE NO. TO INSERT
7
1
ENTER THE NO. TO INSERT
8
1
ENTER THE NO. TO INSERT
6
3
DELETE NODE :
6
2
ENTERYOURCHOICE
1.PREORDER
2.INORDER
3.POSTORDER
2
1 3 5 7 8



