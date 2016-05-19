package com.robin.konkurs;

/**
 * Created by ${Robert} on 19.05.2016.
 */
public class BonusMoreThen7 extends BonusDecorator {
    Quiz quiz;

    public BonusMoreThen7(Quiz quiz) {
        this.quiz = quiz;
    }

    public int execute(int[] numbers) {
        int bonus=0;
        if(numbers.length > 7) {
            bonus = 150;
        }
        return quiz.execute(numbers) + bonus;
    }
}
