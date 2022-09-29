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
/*
class 로또생성기 {
    public static void main(String[] args) {
        로또생성기 solution = new 로또생성기();
        System.out.println(solution.solution());
        
    }
    public String solution(){
        String title = " ### 로또 생성기 ### \n";
        String result = "";
        Random random = new Random();
        for(int i =1; i<=6; i++ ){
            int number = random.nextInt(45) + 1;
            result += number + "\t";
        }
        String answer = String.format(
        "*****************************************\n"
        +"로또 번호\n"
        +"*****************************************\n"
        +"%s"
        +"\n*****************************************", result);
        return title + answer;
    }
}
*/
// 로또번호가 중복되었는지 체크하기 위해서는 수열 상태를 배열로 변환해야 한다.
// 그래서 다음과 같이 변경된다.

/*
class 로또생성기 {
    public static void main(String[] args) {
        로또생성기 solution = new 로또생성기();
        System.out.println(solution.solution());
        
    }
    public String solution(){
        String title = " ### 로또 생성기 ### \n";
        String result = "";
        int[] arr = new int[6];
        Random random = new Random();
        for(int i =0; i< 6; i++ ){
            int number = random.nextInt(45) + 1;
            arr[i] = number;
        }
        for(int i=0; i< arr.length; i++){
            result += arr[i]+"\t";
        }
        String answer = String.format(
        "*****************************************\n"
        +"로또 번호\n"
        +"*****************************************\n"
        +"%s"
        +"\n*****************************************", result);
        return title + answer;
    }
}
*/
// 중복 체크하는 단계
/*
class 로또생성기 {
    public static void main(String[] args) {
        로또생성기 solution = new 로또생성기();
        System.out.println(solution.solution());
        
    }
    public String solution(){
        String title = " ### 로또 생성기 ### \n";
        String result = "";
        int[] arr = new int[6];
        Random random = new Random();
        for(int i =0; i< 6; i++ ){
            int number = random.nextInt(45) + 1;
            // 로또번호 중복체크
            boolean check = false; // false가 중복되지 않은 값
            for(int j=0; j<6; j++){
                if(arr[j] == number){
                    check = true;
                }
            }
            if(check==false){
                arr[i] = number; // 중복되지 않았으니 배열에 담아라.
            }else{
                i--; // 중복됐으면 이번 회수는 무효로 하고 다시 뽑아라.
            }
            
        }
        for(int i=0; i< arr.length; i++){
            result += arr[i]+"\t";
        }
        String answer = String.format(
        "*****************************************\n"
        +"로또 번호\n"
        +"*****************************************\n"
        +"%s"
        +"\n*****************************************", result);
        return title + answer;
    }
}
*/
// 버블정렬을 진행한 코드
/*
class 로또생성기 {
    public static void main(String[] args) {
        로또생성기 solution = new 로또생성기();
        System.out.println(solution.solution());
        
    }
    public String solution(){
        String title = " ### 로또 생성기 ### \n";
        String result = "";
        int[] arr = new int[6];
        Random random = new Random();
        for(int i =0; i< 6; i++ ){
            int number = random.nextInt(45) + 1;
            // 로또번호 중복체크
            boolean check = false; // false가 중복되지 않은 값
            for(int j=0; j<6; j++){
                if(arr[j] == number){
                    check = true;
                }
            }
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
                    int temp = arr[i]; // 스왑 
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        
        for(int i=0; i< arr.length; i++){
            result += arr[i]+"\t";
        }
        String answer = String.format(
        "*****************************************\n"
        +"로또 번호\n"
        +"*****************************************\n"
        +"%s"
        +"\n*****************************************", result);
        return title + answer;
    }
}
*/
// 리팩토링( 너무 길어지는 메소드를 분리해서 새로운 매소드로 나누는 것 )
// 1차로 배열 출력 부분을 printArray() 분리한다
/*
class 로또생성기 {
    public static void main(String[] args) {
        로또생성기 solution = new 로또생성기();
        System.out.println(solution.solution());
        
    }
    public String solution(){
        String title = " ### 로또 생성기 ### \n";
        String result = "";
        int[] arr = new int[6];
        Random random = new Random();
        for(int i =0; i< 6; i++ ){
            int number = random.nextInt(45) + 1;
            // 로또번호 중복체크
            boolean check = false; // false가 중복되지 않은 값
            for(int j=0; j<6; j++){
                if(arr[j] == number){
                    check = true;
                }
            }
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
        return title + answer;
    }
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
}
*/

// 리팩토링 2차로 중복체크 분리한다.

class 로또생성기 {
    public static void main(String[] args) {
        로또생성기 solution = new 로또생성기();
        System.out.println(solution.solution());
        
    }
    public String solution(){
        String title = " ### 로또 생성기 ### \n";
        String result = "";
        int[] arr = new int[6];
        Random random = new Random();
        for(int i =0; i< 6; i++ ){
            int number = random.nextInt(45) + 1;
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