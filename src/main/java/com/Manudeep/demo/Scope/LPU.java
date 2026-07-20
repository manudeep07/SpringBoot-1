package com.Manudeep.demo.Scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LPU {

    LPU(){
        System.out.println("LPU Rank 1");
    }
    public void admission(){
        System.out.println("admission");
    }
    public void UMC(){
        System.out.println("UMc");
    }
    public void Naac(){
        System.out.println("Naac A++");
    }
}
