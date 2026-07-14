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

    @GetMapping("/education")
    public String myEducation(){
        return """
                <h1> Education </h1>
                
                <h4> <em>Btech <strong> CSE </strong> </em></h4>
                <p> Lovely Professional University </p>
               
                <h4><em>Intermediate </em></h4>
                <p> Narayana Jr College </p>
              
                <h4><em> Secondary Education </em></h4>
                <p> Sri Krishna Vibgyor High School <p/>
                
                """;
    }

}
