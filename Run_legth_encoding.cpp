#include <iostream>
#include <string>
#include <stdlib.h>
#include <sstream>
using namespace std;
bool isDigit(char ch)
{
     return ch >= '0' && ch <= '9';
}
string encode(const string &in)
{
     string out = "";
     int cnt = 1;
     for (int i = 0; i != in.size() - 1; ++i)
     {
          if (in[i] == in[i+1])
               ++cnt;
else {
} }
out += in[i];
stringstream ss;
ss << cnt;
string count;
ss >> count;
out += count;
cnt = 1;
     out += in[in.size() - 1];
     out += cnt + '0';
return out; }
string decode(const string &in)
{
     string out = "";
     char ch = in[0];
     for (int i = 0; i < in.size(); ++i)
     {
           if (!isDigit(in[i]))
          {
ch = in[i];
               out += in[i];
          }
else {
i+1).c_str());
} }
int start = i;
while (isDigit(in[i+1]))
     ++i;
int times = atoi(in.substr(start,
for (int k = 0; k != times - 1; ++k)
     out += ch;
return out; }
int main() {
    string str;
     cout << "Enter the string you want to encode/decode: ";
cin >> str;
    char ch = 0;
     cout << "What do you want to do? " << endl;
     cout << "1. Encode" << endl;
     cout << "2. Decode" << endl;
     cin >> ch;
switch(ch) {
          case '1':
          cout << encode(str) << endl;
          break;
          case '2':
          cout << decode(str) << endl;
          break;
}
return 0; }
OUTPUT:
Enter the string you want to encode/decode: aaaabbbbbbcccc
What do you want to do?

1. Encode
2. Decode
1
$a4$b6$c4
Enter the string you want to encode/decode: $a4$b6$c4
What do you want to do?
1. Encode
2. Decode
2
aaaabbbbbbcccc
OUTPUT OF CRC:
Enter dataword: 1 0 0 1 0 0 1 0 Enter generator: 1 0 1 0
10
OUTPUT HAMMING:
Hamming code
Enter the size of the data word:
8
Enter the data word: 1 0 1 0 1 0 0 1
Code word: 0 0 1 0 0 1 0 0 1 0 0 1
