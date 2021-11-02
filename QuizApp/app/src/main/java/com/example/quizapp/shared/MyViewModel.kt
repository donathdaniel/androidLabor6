package com.example.quizapp.shared

import androidx.lifecycle.ViewModel
import java.io.File


data class Question(var answers : MutableList<Pair<String,Boolean>>, val text : String)

val hardCodedQuestions: MutableList<Question> = mutableListOf(
    Question(mutableListOf(Pair("14",false),Pair("11",false),Pair("8",false),Pair("5",true)), "One rabbit saw 6 elephants while going towards River. Every elephant saw 2 monkeys are going towards river. Every monkey holds one tortoice in their hands. How many animals are going towards the river?")
    ,Question(mutableListOf(Pair("Light",false),Pair("Bats",false),Pair("Stars",true),Pair("Flights",false)), "They come out at night without being called and are lost in the day without being stolen. What are they?")
    ,Question(mutableListOf(Pair("Maggi",false),Pair("Ericson",false),Pair("Sona",false),Pair("Jason",true)), "A man was murdered in his office. The suspects are Ericson, Maggi, Joel, Benny, Sona, Patick. A calendar found near the man has blood written 6, 4, 9, 10, 11. Who is the killer?")
    ,Question(mutableListOf(Pair("Egyszer",false),Pair("Kétszer",false),Pair("Háromszor",true),Pair("Nyolcszor",false)), "Hányszor 8 88-ból 8*8?")
    ,Question(mutableListOf(Pair("Shoe",false),Pair("Charcoal",true),Pair("Belt",true),Pair("All the above",false)), "What is black when you buy it, red when you use it, and gray when you throw it away?")
    ,Question(mutableListOf(Pair("Money",false),Pair("Luxury items",false),Pair("Brain",false),Pair("Nothing",true)), "Poor people have it.Rich people need it.If you eat it you die.")
    ,Question(mutableListOf(Pair("Mirror",false),Pair("Book",true),Pair("Table",false),Pair("None of the above",false)), "What has a spine but no bones?")
    ,Question(mutableListOf(Pair("Son-in-law",true),Pair("Daughter-in-law",true),Pair("Grand mother",false),Pair("Grand Daughter",false)), "If Theresa's daughter is my daughter's mother, what am I to Theresa?")
)

class MyViewModel : ViewModel() {
    companion object {
        var questions: MutableList<Question> = mutableListOf()
        var questionCounter : Int = 0
        var points : Float = 0F
        var finalPoints : Int = 0
    }

    var companion = Companion

    fun startQuiz() {
        questions = mutableListOf()
        points = 0F
        finalPoints = 0
        questionCounter = 0

        questions = hardCodedQuestions

        randomizeQuestions()
    }

    fun typeOfNewxtQuestion() : Int{
        var counter = 0
        for(q in questions[questionCounter].answers){
            if(q.second == true){
                counter++
            }
        }
        return counter
    }

    fun randomizeQuestions(){
        questions.shuffle()
        randomizeAnswers()
    }

    fun randomizeAnswers(){
        for(q in questions)
            q.answers.shuffle()
    }

    fun endOfQuiz() : Boolean {
        if (questionCounter == questions.size) {
            return true
        }
        return false
    }

    fun getQuestion() : Question{
        val question = Question(questions[questionCounter].answers, questions[questionCounter].text)
        questionCounter++
        return question
    }

    fun calculateResult(question: Question, numbers : MutableList<Int>) {
        finalPoints++

        var correctAnswers = 0F
        for(number in numbers)
            if(question.answers[number].second == true){
                correctAnswers++
            }

        var questionCorrectAnswer = 0
        for(q in question.answers){
            if(q.second == true)
                questionCorrectAnswer++
        }

        points += correctAnswers/questionCorrectAnswer
    }

}