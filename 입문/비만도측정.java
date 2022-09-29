package 입문;

import java.util.*;
class 비만도측정{
    public static void main(String[] args) {
        비만도측정 solution = new 비만도측정();
        System.out.println(solution.solution());
    }

    public String solution(){
        String title = " ### BMI 측정 ###\n";
        Scanner scanner = new Scanner(System.in);
        String name = "";
        float cm = 0.0f;
        float m = 0.0f;
        float kg = 0.0f;
        int bmi = 0;
        String degree = "";
        System.out.print("이름 입력 : ");
        name = scanner.nextLine();
        System.out.print("키 입력 : ");
        cm = scanner.nextFloat();
        System.out.print("체중 입력 : ");
        kg = scanner.nextFloat();

        m = cm / 100;
        bmi = (int)(kg / (m*m));

        if(bmi > 30){ degree = "비만(High)"; } 
        else if(bmi >= 25 && bmi <= 30){ degree = "과체중(over)"; }
        else if(bmi >= 19 && bmi <= 24){ degree = "정상(Normal)"; }
        else{ degree = "저체중(Low)"; }

        String answer = String.format(
            "****************학생 정보 출력****************\n"
            + "**********************************************\n"
            + "이름 | 키(cm) | 체중(kg) | BMI | 비만정도\n"
            + "----------------------------------------------\n"
            + "%s | %.1f | %.1f | %d | %s\n"
            + "**********************************************\n", 
            name, m, kg, bmi, degree);

        scanner.close();
        return title + answer;
    }
}