package com.Manudeep.demo;

class p{
    void m1(){

    }
    void m2(){

    }
}

class c1 extends p{
    void m3(){

    }
}

class Test{
    //    c1 c1=new p(); this gives error

    //here int p we only have m1 and m2 but reference is of c1 which is also having m3 p object doesn't know it
}