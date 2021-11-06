package com.example.quizapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizapp.databinding.FragmentQuestionDetailBinding
import com.example.quizapp.shared.Question


class QuestionDetail(val model : Question) : Fragment() {

    lateinit var binding : FragmentQuestionDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.question.text = model.text

        var numberOfCorrectAnswers = 0
        for(q in model.answers){
            if(q.second) {
                numberOfCorrectAnswers++
            }
        }

        if(numberOfCorrectAnswers == 1)
            binding.numberOfQuestion.text = "Single answer"
        else
            binding.numberOfQuestion.text = "Multiple answers"

        binding.answer1.text = model.answers[0].first
        binding.answer2.text = model.answers[1].first
        binding.answer3.text = model.answers[2].first
        binding.answer4.text = model.answers[3].first


    }

}