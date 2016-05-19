package com.robin.konkurs;

/**
 * Created by ${Robert} on 19.05.2016.
 */
public class BonusOdds extends BonusDecorator {
    Quiz quiz;

    public BonusOdds(Quiz quiz) {
        this.quiz = quiz;
    }

    public int execute(int[] numbers) {
        for (int num : numbers) {
            if(num % 2 == 0) {
                return quiz.execute(numbers);
            }
        }
        return quiz.execute(numbers) + 50;
    }
}
