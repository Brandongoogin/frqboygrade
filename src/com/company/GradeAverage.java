package com.company;

/***
 Consider a grading scheme where your final grade is computed more generously
 if your grades show improvement over the term.  Scores show improvement
 if each grade is greater than or equal to the previous grade.

 A student has x scores indexed from 0 to x-1.  If the scores have shown improvement
 only those grades with indexes greater than to equal to x/2 are averaged.  If the
 scores have not improved, all of the scores are averaged.
 ***/

public class GradeAverage {

    private int[] scores;

    public GradeAverage(int[] s) {
        scores = s;
    }

    // returns the mean (average) of the values in the scores array
    // whose indexes are between first and last (including first and last).
    //You may assume that first and last are > 0 and < scores.length
    public double mean(int first, int last) {
        double c = 0;
        for (int b = first; b <= last; b++) {
            c = c + scores[b];
        }
        double av = c / ((last + 1) - first);
        return av;
    }


    // returns true if each successive value in scores is greater than
    // or equal to the previous value.  Otherwise returns false
    private boolean showsImprovement() {
        for (int a = 0; a < scores.length; a++) {
            if (scores[a] < scores[a + 1]) {
                return true;
            } else {
                return false;
            }
        }
    }


    // if the values in the scores array show improvement, returns the
    // average of the elements in scores with indexes greater than or
    // equal to scores.length()/2
    public double finalGrade() {
            double f = 0;
            int d = scores.length;
            int b = 0;
            for (int a = 0; a < d; a++) {
                b = b + scores[a];
                if (scores[a] > scores[a + 1]) {
                    f = b + d / 2;
                    return f;
                } else {
                    if (scores[a] < scores[a + 1]) {
                        f = b++ / d;
                        return f;
                    }
                }
            }
        }


    public static void main(String[] args) {
        int [] s1 = {50,50,20,80,53};   // not improved, finalGrade is 50.6
        int [] s2 = {20,50,50,53,80};   // improved, final grade is 61.0
        int [] s3 = {20,50,50,80};      // improved, final grade is 65.0

        GradeAverage sr1 = new GradeAverage(s1);
        System.out.println(sr1.mean(1,4));
        System.out.println(sr1.showsImprovement());
        System.out.println(sr1.finalGrade());
        GradeAverage sr2 = new GradeAverage(s2);
        //System.out.println(sr2.mean());
        System.out.println(sr2.showsImprovement());
        System.out.println(sr2.finalGrade());
       // System.out.println(sr3.mean());
        //System.out.println(sr3.showsImprovement());
        GradeAverage sr3 = new GradeAverage(s3);
       // System.out.println(sr3.finalGrade());
    }

}
