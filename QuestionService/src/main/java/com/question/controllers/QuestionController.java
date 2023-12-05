package com.question.controllers;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")

public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.create(question);

    }
   @GetMapping
    List<Question> getAll() {
        return questionService.get();


    }

    @GetMapping("{questionId}")
    Question getOne(@PathVariable Long questionId) {
        return questionService.getOne(questionId);


    }
    @GetMapping("/quiz/{quizId}")
    List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestions0fQuiz(quizId);

    }
}
