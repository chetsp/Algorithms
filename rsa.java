import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
public class rsa {
static int totient(int n) {
int i, x, c;
int count = 0;
for (i = 1; i < n; i++)
{
c = i > n ? i : n;
x = relp(i, n, c); if (x == 1)
count++;
static int relp(int a, int b, int c) { int e = gcd1(a, b, c);
if (e == 1) {
return 1; } else {
return 0; }
}
static int gcd1(int a, int b, int c) {
int d = 0;
for (int i = c; i > 0; i--)
{
if ((a % i == 0) && (b % i == 0)) {
d = i;
break; }
}
return d; }
public static void main(String[] args) throws IOException {
int n, p, q, i, j, M;
InputStreamReader r = new InputStreamReader(System.in); BufferedReader input = new BufferedReader(r);
String s = new String();
System.out.println("enter p");
s = input.readLine();
p = Integer.parseInt(s);
System.out.println("enter q");
s = input.readLine();
q = Integer.parseInt(s);
System.out.println("enter M");
s = input.readLine();
M = Integer.parseInt(s);
n = p * q;
int phi = totient(n);
int phiofphi = totient(phi);
}
return count; }

 } }
OUTPUT:
enter p
3
enter q
11
enter M
2
phi=20
private keys are=7 33 public keys are=3 33 the cipher is=8
the plain is=2
System.out.println("phi=" + phi); for (i = 2; i < phi; i++) {
if ((relp(phi, i, phi)) == 1) break;
}
int e = i;
int d = 1;
for (j = 1; j <= phiofphi - 1; j++) {
d *= e;
d %= phi; }
d = d % phi;
System.out.println("private keys are=" + d + " " + n); System.out.println("public keys are=" + e + " " + n); int C = 1;
for (j = 1; j <= e; j++) {
C *= M;
C %= n; }
System.out.println("the cipher is=" + C);
M = 1;
for (j = 1; j <= d; j++) {
M *= C;
M %= n; }
M = M % n;
System.out.println("the plain is=" + M);
