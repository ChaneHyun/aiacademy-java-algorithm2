package basic;

import java.util.*;
class 성적표 {
    public static void main(String[] args){
        성적표 solution = new 성적표();
        System.out.println(solution.solution());
    }

    public String solution(){
        String title = "############# 성적표 #############\n";
        final int SUBJECT_NUM = 3;
        String anwser = "";
        Scanner scanner = new Scanner(System.in);
        String name = "";
        int kor = 0;
        int eng = 0;
        int math = 0;
        
        System.out.print("이름 : ");
        name = scanner.nextLine();
        System.out.print("국어 성적 : ");
        kor = scanner.nextInt();
        while (kor < 0 || kor > 100) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.print("국어 성적 : ");
            kor = scanner.nextInt();
        }

        System.out.print("영어 성적 : ");
        eng = scanner.nextInt();
        while (eng < 0 || eng > 100){
            System.out.println("잘못 입력하셨습니다.");
            System.out.print("영어 성적 : ");
            eng = scanner.nextInt();
        }

        System.out.print("수학 성적 : ");
        math = scanner.nextInt();
        while (math < 0 || math > 100){
            System.out.println("잘못 입력하셨습니다.");
            System.out.print("수학 성적 : ");
            math = scanner.nextInt();
        }

        int sum = kor + eng + math;
        float average = sum / SUBJECT_NUM;
        String grade = "";

        if(average >= 90 && average <= 100){ grade = "A"; } 
        else if(average >= 80 && average <= 89){ grade = "B"; } 
        else if(average >= 70 && average <= 79){ grade = "C"; } 
        else if(average >= 60 && average <= 69){ grade = "D"; } 
        else if(average >= 50 && average <= 59){ grade = "E"; }
        else { grade = "F"; }

        anwser = String.format(
            "***********************************************\n"
            + "이름 | 국어 | 영어 | 수학 | 총점 | 평균 | 성적\n"
            + "-----------------------------------------------\n"
            + "%s | %d | %d | %d | %d | %.1f | %s\n"
            + "***********************************************\n", 
            name, kor, eng, math, sum, average, grade);
        
        scanner.close();
        return title + anwser;
    }
}
