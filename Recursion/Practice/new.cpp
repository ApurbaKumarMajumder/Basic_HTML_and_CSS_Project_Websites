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

