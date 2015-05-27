For a character X in the string

1) let p(X) be its predecessor, if X is not the first, or the last character otherwise;

2) let s(X) be its successor, if X is not the last, or the first character otherwise.

For each character X (from first to last), if X = '?' then replace it with the first of 'a','b' or 'c' that is distinct from p(X) and s(X). At each iteration check also whether X is distinct from p(X) and s(X) and, if not, output "Not Possible" and stop.

#include <iostream>
#include <string>

void next_string(std::string& str) {
  
  for (unsigned i = 0; i < str.size(); ++i) {
      
    char const p = (i == 0 ? str.back() : str[i - 1]);
    char&      x = str[i];
    char const s = (i == str.size() - 1 ? str.front() : str[i + 1]);
    
    if (x == '?') {
      
      if (p != 'a' && s != 'a')
        x = 'a';
      
      else if (p != 'b' && s != 'b')
        x = 'b';
      
      else
         x = 'c';
    }
    
    else if (x == p || x == s) {
      std::cout << "Not Possible\n";
      return;
    }
  }
  
  std:: cout << str << '\n';
}
