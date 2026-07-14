package com.Manudeep.demo.Portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {
    @GetMapping("/myself")
    public String mySelf() {
        return """
                <h1>I am Manudeep</h1>
                <p>Currently Persuing btech <Strong> CSE </Strong> int <Strong> LPU </Strong></p>
                <ul>
                <li><a href="https://github.com/manudeep07">GitHub</a> 
                <li><a href="https://leetcode.com/u/manudeep_1000/">LeetCode</a>
                <li><a href="mailto:manudeep1000@gmail.com"> Contact me </>
                </ul>
                """;
    }


    @GetMapping("/skills")
    public String mySkills(){
        return """
                <h1> Skills </h1> 
                
                <b> Languages: </b> Java, JavaScript,<br/><br/>
                <b> Frameworks/Technologies: </b> Express , React, Node, LangChain<br/><br/>
                <b> Tools/DataBases : </b> Git, GitHub, Docker, MySql, MongoDb<br/><br/>    
                """;
    }

