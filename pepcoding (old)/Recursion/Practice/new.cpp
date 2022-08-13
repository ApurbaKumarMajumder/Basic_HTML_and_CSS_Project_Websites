// Find power of a number

long long Pow(int x, int n)
{
    // Write your code here.
    if(n == 0){
        return 1;
    }
    
    long long temp = Pow(x, n/2);
    long long result = temp * temp;
    if(n%2 == 1){
        return result * x;
    }
    return result;
}

// Check Palindrome

bool isPalindromeHelper(int s, int e, string &str){
    // base case
    if(s >= e){
        return true;
    }
    
    if(str[s] != str[e]){
        return false;
    }
    return isPalindromeHelper(s+1, e-1, str);
}

bool isPalindrome(string &s)
{
	// Write your code here.
    // return the helper function
    isPalindromeHelper(0, s.size()-1, s);
}

// Reverse The Array

void reverseArrayHelper(int s, int e, vector<int> &arr){
    // base condition - 1
    if(s >= e){
        return;
    }
    
    // do the small task yourself - 2
    swap(arr[s], arr[e]);
    
    // ask recursion to handle the remaining part for you - 3
    reverseArrayHelper(s+1, e-1, arr);
}

void reverseArray(vector<int> &arr , int m)
{
	// Write your code here.
    reverseArrayHelper(m+1, arr.size()-1, arr);
}