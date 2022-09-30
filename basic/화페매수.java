package basic;
import java.util.*;
/**
출력형식
*******************************************************
성명 출장비 오만원 만원 오천원 천원 오백원 백원 오십원 십원
*******************************************************
엄철식 222222 1 2 3 4 5 6 7 8
*******************************************************
전체 화폐 매수 
*/
class 화폐매수 {
    public static void main(String[] args) {
        화폐매수 solution = new 화폐매수();
        System.out.println(solution.solution());
    }   
    public String solution(){
        String title = "\n### 화폐매수 ###\n";
        String result = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름을 입력하시오");
        String name = scanner.next();
        System.out.print(">>> ");
        System.out.println("출장비를 입력하시오");
        int money = scanner.nextInt();
        System.out.print(">>> ");
        int expense = money; // 출장비
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        int mok = 0;
        int nmg = 0;
        for(int i=0; i < unit.length; i++){
            mok = money / unit[i];
            nmg = money % unit[i];
            money = nmg;
            result += mok+"\t";
        }
        String answer = String.format(
        "*********************************************************\n"
        +"성명 출장비 오만원 만원 오천원 천원 오백원 백원 오십원 십원\n"
        +"*********************************************************\n"
        +"%s %d %s\n"
        +"*********************************************************\n", 
        name, expense, result);

        scanner.close();
        return title + answer;
    }
}