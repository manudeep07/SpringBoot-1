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

    @GetMapping("/projects")
    public String myProjects(){
        return """
                <h1> Projects </h1> 
                
                <h4> Title: <em>InterviewHub </em> | React.js, Node.js, Express.js, PostgreSQL, Prisma ORM, Docker, Docker Compose, GitHub Actions</h4>  
                <ul>
                <li> 
                Orchestrated a full-stack interview experience platform for exploring and sharing company-wise and role-wise interview
                experiences.
                </li>
                <li>
                Modeled relational data structures using PostgreSQL and Prisma ORM to manage users, companies, job roles, experiences,\s
                and interview rounds.\s
                </li>
                <li>
                 Containerized the app with Docker and Docker Compose, simplifying multi-container deployment and environment consistency.
                </li>
                
                <li>
                 Automated CI workflows with GitHub Actions for application builds, Docker image creation, and image publishing to Docker Hub.
                </li>
                </ul>
                
                <br/>
                
                <h4> Title: <em>Virtual Classroom Platform </em> |  MongoDB, Express.js, React.js, Node.js, WebRTC, Tailwind CSS\s</h4>  
                <ul>
                <li> 
                 Architected a real-time virtual classroom using WebRTC and Socket.io, supporting up to 10 concurrent users with low-latency\s
                            audio/video communication per session.\s
                </li>
                <li>
                Engineered an assignment workflow handling 30+ student submissions per course, including file uploads, deadline tracking, and\s
                instructor reviews.\s
                </li>
                <li>
                 Secured 20+ learning-content resources using role-based access control enforcing permissions across 2 user roles: students\s
                                                                                                                                          and instructors.\s
                </li>
                
                <li>
                 Developed dual dashboards for 2 user roles, organizing classes, tasks, announcements and shared materials in one platform.\s
                </li>
                </ul>
                
                
                """;
    }
}
