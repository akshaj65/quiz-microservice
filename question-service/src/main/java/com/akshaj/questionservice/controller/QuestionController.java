package com.akshaj.questionservice.controller;


import com.akshaj.questionservice.model.Question;
import com.akshaj.questionservice.model.QuestionWrapper;
import com.akshaj.questionservice.model.Response;
import com.akshaj.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("level/{level}")
    public ResponseEntity<List<Question>> getQuestionByDifficultyLevel(@PathVariable String  level){
        return questionService.getQuestionsByDifficultyLevel(level);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    /*
    *  cURL example: curl "http://localhost:8080/Question/generate?category=Gk&numQuestions=4"
    * */
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam Integer numQuestions){
        return questionService.getQuestionsForQuiz(category,numQuestions);
    }
    /*
     *  cURL example: curl -X POST -H "Content-Type: application/json" -d '[7,12,10,11]' "http://localhost:8080/Question/getQuestions"
     * */
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds ){
        System.out.println(environment.getProperty("local.server.port"));
        return  questionService.getQuestionsById(questionIds);
    }

    /*
     *   cURL example: curl -X POST -H "Content-Type: application/json" -d '[{"id": 8,"response": "United States of America"},{"id": 1,"response": "Paris"}]' "http://localhost:8080/Question/getScore"
     */
    @PostMapping("getScore")
    public  ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return  questionService.getScore(responses);
    }
}
