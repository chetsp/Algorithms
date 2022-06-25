
import java.util.*; 
public class Playfair {
String key[][];
static Scanner read = new Scanner(System.in);
Playfair() {
key = new String[5][5]; System.out.println("Enter the key:"); for (int i = 0; i < 5; i++) {
for (int j = 0; j < 5; j++) { key[i][j] = read.nextLine();
} }
System.out.println("The key is :"); for (int i = 0; i < 5; i++) {
for (int j = 0; j < 5; j++) { System.out.print(key[i][j] + "\t");
}
System.out.println(); }
}
String bogus(String plain) {
plain = plain.toUpperCase(); plain = plain.replaceAll(" ", ""); String bogus = "";
char a = plain.charAt(0);
bogus += a;
char b = plain.charAt(0);
int i = 1;
while (i < plain.length()) {
a = b;
b = plain.charAt(i); if (a == b) {
bogus += "X"; }
bogus += b;
i++; }
if (bogus.length() % 2 == 1) { bogus += "X";
}
return bogus; }

 String encrypt(String plain) { String cipher = "";
plain = bogus(plain);
int i = 0;
int r1, r2, c1, c2;
while (i < plain.length()) {
r1 = findrow(plain.charAt(i) + "");
r2 = findrow(plain.charAt(i + 1) + ""); c1 = findcol(plain.charAt(i) + "");
c2 = findcol(plain.charAt(i + 1) + ""); if (r1 == r2) {
cipher += key[r1][(c1 + 1) % 5].charAt(0);
cipher += key[r1][(c2 + 1) % 5].charAt(0); } else if (c1 == c2) {
cipher += key[(r1 + 1) % 5][c1].charAt(0);
cipher += key[(r2 + 1) % 5][c2].charAt(0); } else {
cipher += key[r1][c2].charAt(0);
cipher += key[r2][c1].charAt(0); }
i += 2; }
return cipher; }
String decrypt(String cipher) { String plain = "";
int i = 0;
int r1, r2, c1, c2;
while (i < cipher.length()) {
r1 = findrow(cipher.charAt(i) + "");
r2 = findrow(cipher.charAt(i + 1) + ""); c1 = findcol(cipher.charAt(i) + "");
c2 = findcol(cipher.charAt(i + 1) + ""); if (r1 == r2) {
plain += key[r1][(c1 + 4) % 5].charAt(0);
plain += key[r1][(c2 + 4) % 5].charAt(0); } else if (c1 == c2) {
plain += key[(r1 + 4) % 5][c1].charAt(0);
plain += key[(r2 + 4) % 5][c2].charAt(0); } else {
plain += key[r1][c2].charAt(0);
plain += key[r2][c1].charAt(0); }
i += 2; }
plain = plain.toUpperCase();

 System.out.println("Plain text with Xs : " + plain); plain = plain.replace("X", "");
return plain; }
int findrow(String letter) { int r = 0;
for (int i = 0; i < 5; i++) { for (int j = 0; j < 5; j++) {
if (key[i][j].contains(letter)) { r = i;
break; }
} }
return r; }
int findcol(String letter) { int c = 0;
for (int i = 0; i < 5; i++) { for (int j = 0; j < 5; j++) {
if (key[i][j].contains(letter)) { c = j;
break; }
} }
return c; }
public static void main(String args[]) {
Playfair p = new Playfair();
System.out.println("Choose an option:\n1:Encryption\n2:Decryption"); int ch = read.nextInt();
System.out.println("Enter the text:");
String text = read.nextLine();
text = read.nextLine();
switch (ch) {
case 1:
System.out.println("Cipher Text : " + p.encrypt(text)); break;
case 2:
System.out.println("Plain Text without Xs : " + p.decrypt(text)); break;
default:

 System.out.println("Error!"); }
} }
OUTPUT :
1. Enter the key: P
L
A
Y
F
I
R
E
X
M
B
C
D
G
H
K
N
O
Q
S
T
U
V
W
Z
The key is : PLAYF IREXM BCDGH KNOQS TUVWZ Choose an option: 1:Encryption

 2:Decryption
1
Enter the text:
Hide the gold in the tree stump
Cipher Text : BMODZBXDNABEKUDMUIXMMOUVIF
2. Enter the key: P
L
A
Y
F
I
R
E
X
M
B
C
D
G
H
K
N
O
Q
S
T
U
V
W
Z
The key is : PLAYF IREXM BCDGH KNOQS TUVWZ Choose an option: 1:Encryption
2:Decryption
2
Enter the text:
BMODZBXDNABEKUDMUIXMMOUVIF
Plain text with Xs : HIDETHEGOLDINTHETREXESTUMP Plain Text without Xs : HIDETHEGOLDINTHETREESTUMP
