package 입문;
import java.util.*;

/* 문제출처: https://ssnack655.tistory.com/31

1. 서로 겹치지 않는 숫자 6개를 생성
2. 각 숫자는 1 ~ 45 범위 내의 숫자
3. 매번 실행 시 다른 숫자 출력
4. 오름차순 정렬
-> 랜덤수 : Math 사용
 
결과)
**********************************
로또 번호
**********************************
2 11 25 27 35 38
**********************************
*/

class 로또생성기 {
    public static void main(String[] args) {
        로또생성기 solution = new 로또생성기();
        System.out.println(solution.solution());
        
    }
    public String solution(){
        String title = " ### 로또 ### \n";
        System.out.println(" === 로또 구매 ===\n");
        System.out.println("원하는 숫자를 입력하시오. 단, 범위는 1부터 8까지 입니다.");
        System.out.print(">>> ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(String.format("당신이 입력한 번호는 %d 입니다.", input));

        String result = "";

        System.out.println(" === 로또 추첨 ===\n");
        int[] arr = new int[6];
        Random random = new Random();
        for(int i =0; i< 6; i++ ){
            int number = random.nextInt(8) + 1;
            boolean check = false; // false가 중복되지 않은 값
            check = contains(arr, number, check);
            if(check==false){
                arr[i] = number; // 중복되지 않았으니 배열에 담아라.
            }else{
                i--; // 중복됐으면 이번 회수는 무효로 하고 다시 뽑아라.
            }
            
        }
        // 버블정렬이 들어갈 부분
        for(int j =0; j < arr.length; j++){
            for(int i=0; i< arr.length -1; i++){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        String answer = printArray(arr);

        scanner.close();
        return title + answer;
    }
    /**
     * 배열 출력 메서드
    */
    public String printArray(int[] arr){ 
        String result = "";
        for(int i=0; i< arr.length; i++){
            result += arr[i]+"\t";
        }
        String answer = String.format(
        "*****************************************\n"
        +"로또 번호\n"
        +"*****************************************\n"
        +"%s"
        +"\n*****************************************", result);
        return answer;
    }
    /**
     * 중복체크 메서드
    */
    public boolean contains(int[] arr, int number, boolean check){
        for(int j=0; j<6; j++){
            if(arr[j] == number){
                check = true;
            }
        }
        return check;
    }
}