package com.robin.konkurs;

/**
 * Created by ${Robert} on 19.05.2016.
 */
public class BonusForFirstAndLastZero extends BonusDecorator {
    Quiz quiz;

    public BonusForFirstAndLastZero(Quiz quiz) {
        this.quiz = quiz;
    }

    public int execute(int[] numbers) {
        int bonus = 0;
        int first = numbers[0];
        int last = numbers[numbers.length-1];
        if(first==0 && last == 0)
            bonus = 100;
        return quiz.execute(numbers) + bonus;
    }
}
