import java.math.BigInteger; 
import java.util.Scanner; 
public class DES1 {
static Scanner read = new Scanner(System.in);
//For Initial Permutation
int init[] = {
58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};
//For Final Permutation
int fin[] = {
40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26,33, 1, 41, 9, 49, 17, 57, 25};
//For Expansion D-Box
int expand[] = {
32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
//Shifting
int[] shifts = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 }; //S-Boxes
int S1[][] = {{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
{0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8}, {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0}, {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}};
int S2[][] = {{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10}, {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
{0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
{13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}};
int S3[][] = {{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8}, {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
{13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
{1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}};
int S4[][] = {{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15}, {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
{10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
{3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}};
int S5[][] = {{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9}, {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
{4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
{11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}};
int S6[][] = {{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11}, {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
{9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
{4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}};
int S7[][] = {{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1}, {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
{1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
{6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}};
int S8[][] = {{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7}, {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
{7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
{2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};

 //For Straight D-Box
int straightD[] = { 16, 7, 20, 21,29, 12, 28, 17,1, 15, 23, 26, 5, 18, 31, 10,2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25 };
//Parity drop (for key)
int pc1[] = { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18,
10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};
//For Compression D-Box (for key)
int pc2[] = { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48,
44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32}; String hextobin(String hex) {
String binary = "";
char a;
int no = 0;
for (int i = 0; i < hex.length(); i++) {
a = hex.charAt(i);
if (a >= '0' && a <= '9') {
no = Integer.parseInt(a + ""); } else {
switch (a) { case 'A':
no = 10;
break; case 'B':
no = 11;
break; case 'C':
no = 12;
break; case 'D':
no = 13;
break; case 'E':
no = 14;
break; case 'F':
no = 15;
break; }
}
binary += dtob(no); }
return binary; }
String bintohex(String binary) {
BigInteger b = new BigInteger(binary, 2); String hex = b.toString(16);
return hex.toUpperCase();
}
int btod(String binary) {
int decimal = 0;
for (int i = 0; i < binary.length(); i++) {
decimal += Integer.parseInt(binary.charAt(i) + "") * (int) Math.pow(2, binary.length() - 1 - i);

 }
return decimal; }
String dtob(int decimal) { String bin = "";
while (decimal > 0) {
bin += decimal % 2;
decimal = decimal / 2; }
while (bin.length() != 4) {
bin = bin + "0"; }
String bin2 = "";
for (int i = 3; i >= 0; i--) {
bin2 += bin.charAt(i) + ""; }
return bin2; }
String permutation(String text, int arr[]) { String text2 = "";
for (int i = 0; i < arr.length; i++) {
text2 += text.charAt(arr[i] - 1) + ""; }
return text2; }
String roundKey(String key, int round) { String left = key.substring(0, 28); String right = key.substring(28);
for (int i = 0; i < shifts[round]; i++) {
left = left.substring(1) + left.charAt(0);
right = right.substring(1) + right.charAt(0); }
key = left + right;
return key; }
String roundKeyReverse(String key, int round) { if (round != 0) {
String left = key.substring(0, 28);
String right = key.substring(28);
int i = shifts[16 - round];
left = left.substring(28 - i) + left.substring(0, 28 - i); right = right.substring(28 - i) + right.substring(0, 28 - i); key = left + right;
}
return key; }
String encrypt(String text, String key) { text = text.replaceAll(" ", "");
key = key.replaceAll(" ", "");
text = text.toUpperCase();
key = key.toUpperCase(); System.out.println("Plain Text : " + text); text = hextobin(text);
key = hextobin(key);

 //Parity Drop of key (64 bits to 56 bits)
key = permutation(key, pc1);
//Initial permutation of text
text = permutation(text, init);
System.out.println("After initial permutation : " + bintohex(text));
//Splitting
String leftOriginal = text.substring(0, 32);
String rightOriginal = text.substring(32);
System.out.println("After Splitting : L0=" + bintohex(leftOriginal) + "\tR0=" +
bintohex(rightOriginal));
System.out.println(" Round\t Left\t\t Right\t\t Round Key"); String temp = "", keyTemp = "", right = "", left = "";
for (int rounds = 0; rounds < 16; rounds++) {
//Expansion (32 bits to 48 bits)
right = permutation(rightOriginal, expand);
//XOR with the key
key = roundKey(key, rounds); keyTemp = permutation(key, pc2); for (int j = 0; j < 48; j++) {
temp += (Integer.parseInt(right.charAt(j) + "") + Integer.parseInt(keyTemp.charAt(j) + "")) % 2; }
//S-boxes (48 bits to 32 bits)
int k = 0;
String temp2 = "", s1 = "", row = "", col = ""; while (k < 48) {
s1 = temp.substring(k, k + 6);
row = s1.charAt(0) + "" + s1.charAt(5) + ""; col = s1.substring(1, 5);
switch (k) {
case 0: temp2
break; case 6:
temp2
break; case 12:
temp2
break; case 18:
temp2
break; case 24:
temp2
break; case 30:
temp2
break; case 36:
temp2
break; case 42:
temp2
break; }
+= dtob(S1[btod(row)][btod(col)]); += dtob(S2[btod(row)][btod(col)]); += dtob(S3[btod(row)][btod(col)]); += dtob(S4[btod(row)][btod(col)]); += dtob(S5[btod(row)][btod(col)]); += dtob(S6[btod(row)][btod(col)]); += dtob(S7[btod(row)][btod(col)]); += dtob(S8[btod(row)][btod(col)]);

 k += 6; }
//Straight D-box
temp2 = permutation(temp2, straightD);
right = temp2;
//XOR of Left and output of the function(right) for (int j = 0; j < 32; j++) {
left += (Integer.parseInt(right.charAt(j) + "") + Integer.parseInt(leftOriginal.charAt(j) + "")) %2; }
if (rounds != 15) { leftOriginal = rightOriginal; rightOriginal = left;
} else {
leftOriginal = left; }
left = "";
right = "";
temp = "";
System.out.println("Round " + (rounds + 1) + ":\t" + bintohex(leftOriginal) + "\t" +
bintohex(rightOriginal) + "\t" + bintohex(keyTemp)); }
text = leftOriginal + rightOriginal; //Final Permutation of text
text = permutation(text, fin);
text = bintohex(text);
return text; }
String decrypt(String text, String key) { text = text.replaceAll(" ", "");
key = key.replaceAll(" ", "");
text = text.toUpperCase();
key = key.toUpperCase();
System.out.println("Cipher Text : " + text);
text = hextobin(text);
key = hextobin(key);
//Parity Drop of key (64 bits to 56 bits)
key = permutation(key, pc1);
//Initial permutation of text
text = permutation(text, init);
System.out.println("After initial permutation : " + bintohex(text));
//Splitting
String leftOriginal = text.substring(0, 32);
String rightOriginal = text.substring(32);
System.out.println("After Splitting : L0=" + bintohex(leftOriginal) + "\tR0=" +
bintohex(rightOriginal));
System.out.println(" Round\t Left\t\t Right\t\t Round Key"); String temp = "", keyTemp = "", right = "", left = "";
for (int rounds = 0; rounds < 16; rounds++) {
//Expansion (32 bits to 48 bits)
right = permutation(rightOriginal, expand);
//XOR with the key
key = roundKeyReverse(key, rounds); keyTemp = permutation(key, pc2); for (int j = 0; j < 48; j++) {

 temp += (Integer.parseInt(right.charAt(j) + "") + Integer.parseInt(keyTemp.charAt(j) + "")) % 2; }
//S-boxes (48 bits to 32 bits)
int k = 0;
String temp2 = "", s1 = "", row = "", col = ""; while (k < 48) {
s1 = temp.substring(k, k + 6);
row = s1.charAt(0) + "" + s1.charAt(5) + ""; col = s1.substring(1, 5);
switch (k) {
case 0: temp2
break; case 6:
temp2
break; case 12:
temp2
break; case 18:
temp2
break; case 24:
temp2
break; case 30:
temp2
break; case 36:
temp2
break; case 42:
temp2
break; }
k += 6; }
//Straight D-box
temp2 = permutation(temp2, straightD);
right = temp2;
//XOR of Left and output of the function(right) for (int j = 0; j < 32; j++) {
left += (Integer.parseInt(right.charAt(j) + "") + Integer.parseInt(leftOriginal.charAt(j) + "")) % 2; }
if (rounds != 15) { leftOriginal = rightOriginal; rightOriginal = left;
} else {
leftOriginal = left; }
left = ""; right = ""; temp = "";
+= dtob(S1[btod(row)][btod(col)]); += dtob(S2[btod(row)][btod(col)]); += dtob(S3[btod(row)][btod(col)]); += dtob(S4[btod(row)][btod(col)]); += dtob(S5[btod(row)][btod(col)]); += dtob(S6[btod(row)][btod(col)]); += dtob(S7[btod(row)][btod(col)]); += dtob(S8[btod(row)][btod(col)]);

 System.out.println("Round " + (rounds + 1) + ":\t" + bintohex(leftOriginal) + "\t" + bintohex(rightOriginal) + "\t" + bintohex(keyTemp));
}
text = leftOriginal + rightOriginal; //Final Permutation of text
text = permutation(text, fin);
text = bintohex(text);
return text;
}
public static void main(String args[]) {
DES1 d = new DES1();
System.out.println("Choose an option:\n1:Encryption\n2:Decryption"); int ch = read.nextInt();
System.out.println("Enter the text:");
String text = read.nextLine();
text = read.nextLine();
System.out.println("Enter the key:");
String key = read.nextLine();
switch (ch) {
case 1:
System.out.println("Cipher Text : " + d.encrypt(text, key)); break;
case 2:
System.out.println("Plain Text : " + d.decrypt(text, key)); break;
default: System.out.println("Error!");
} }
}
OUTPUT:
Choose an option: 1:Encryption 2:Decryption
1
Enter the text:
123456ABCD132536
Enter the key:
AABB09182736CCDD
Plain Text : 123456ABCD132536
After initial permutation : 14A7D67818CA18AD After Splitting : L0=14A7D678 R0=18CA18AD
Round Left Round 1: Round 2: Round 3: Round 4: Round 5: Round 6: Round 7: Round 8: Round 9: Round 10:
Right 18CA18AD
5A78E394 4A1210F6 B8089591 236779C2 A15A4B87 2E8F9C65 A9FC20A3 308BEE97 10AF9D37
Round Key
5A78E394 4A1210F6 B8089591 236779C2 A15A4B87 2E8F9C65 A9FC20A3 308BEE97 10AF9D37 6CA6CB20
194CD072DE8C 4568581ABCCE 6EDA4ACF5B5 DA2D032B6EE3 69A629FEC913 C1948E87475E 708AD2DDB3C0 34F822F0C66D 84BB4473DCCC 2765708B5BF

 Choose an option: 1:Encryption 2:Decryption
2
6CA6CB20 FF3C485F 22A5963B 387CCDAA BD2DD2AB 19BA9212
FF3C485F 22A5963B 387CCDAA BD2DD2AB CF26B472 CF26B472
Enter the text:
C0B7A8D05F3A829C
Enter the key:
AABB09182736CCDD
Cipher Text : C0B7A8D05F3A829C
After initial permutation : 19BA9212CF26B472 After Splitting : L0=19BA9212 R0=CF26B472
6D5560AF7CA5 C2C1E96A4BF3 99C31397C91F 251B8BC717D0 3330C5D9A36D 181C5D75C66D
Round 11:
Round 12:
Round 13:
Round 14:
Round 15:
Round 16:
Cipher Text : C0B7A8D05F3A829C
Round Left
Round 1:
Round 2:
Round 3:
Round 4:
Round 5:
Round 6:
Round 7:
Round 8:
Round 9:
Round 10:
Round 11:
Round 12:
Round 13:
Round 14:
Round 15:
Round 16:
Plain Text : 123456ABCD132536
Round Key
Right CF26B472
BD2DD2AB 387CCDAA 22A5963B FF3C485F 6CA6CB20 10AF9D37 308BEE97 A9FC20A3 2E8F9C65 A15A4B87 236779C2 B8089591 4A1210F6 5A78E394 18CA18AD 18CA18AD
181C5D75C66D 3330C5D9A36D 251B8BC717D0 99C31397C91F C2C1E96A4BF3 6D5560AF7CA5 2765708B5BF 84BB4473DCCC 34F822F0C66D 708AD2DDB3C0 C1948E87475E 69A629FEC913 DA2D032B6EE3 6EDA4ACF5B5 4568581ABCCE 194CD072DE8C
BD2DD2AB 387CCDAA 22A5963B FF3C485F 6CA6CB20 10AF9D37 308BEE97 A9FC20A3 2E8F9C65 A15A4B87 236779C2 B8089591 4A1210F6 5A78E394 14A7D678
