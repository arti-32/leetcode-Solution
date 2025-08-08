class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x,n);
    }

    // public double helperp(double x,int n){
    //     if(n==0){
    //         return 1;
    //     }
    //     return x*helperp(x,n-1);
    // }
    // public double helperm(double x,double n){
    //     if(n==0){
    //         return 1;
    //     }
    //     return (1/x)*helperm(x,n+1);
    // }
}