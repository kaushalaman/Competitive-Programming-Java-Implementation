#include <cstring>
#include <iostream>
using namespace std;
char check(string s, int k);

//ques 1 Shrinked Exploration
int main() {
    string msg;
    int k;
    while(cin >> msg >> k) {
        cout << check(msg,k) << endl;
    }
    return 0;
}
char check(string s, int k) 
{
	int len = s.length();
	int i = 0;
	long long len_of_str = 0;

	while (i < len)
	 {
		if (isalpha(s[i]))
		 {
			len_of_str++;
			if (len_of_str == k)return s[i];
			i++;
		}
		else 
		{
			int num = 0;

			while (i < len && !isalpha(s[i]))
			 {
				num = num*10 + (s[i]-'0');
				i++;
		 	 }

			long long answer = len_of_str*num;

			if (k <= answer) 
			{
				int index = k % len_of_str;
				if (!index) 
				{
					index = len_of_str;
				}

				return check(s, index);
			}
			else
			{
			   len_of_str = answer;
			}
		}
	}
	return -1;
	
	 
}


