package com.akshaj.quizservice.feign;

import com.akshaj.quizservice.model.QuestionWrapper;
import com.akshaj.quizservice.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//Normally if you want to call Particular Rest Client, you have to write a bunch of Programs to invoke a Web Service. In the case of Feign,
// you don’t have to worry about those bunch of programs for communicating with Webservice. It is called Abstraction.
// Feign Hide all complexity and it takes care of everything.
//Feign provides some annotation, just we need to annotate those annotations in our program for connecting, sending a request, and receiving a response.
//That’s it. This is called "Declarative Web Service"

//

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam Integer numQuestions);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds );

    @PostMapping("question/getScore")
    public  ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
