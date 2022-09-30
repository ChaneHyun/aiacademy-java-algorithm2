package basic;
import java.util.*;
class 게시판 {
    public static void main(String[] args) {
        게시판 solution = new 게시판();
        solution.solution();
    }
    public void solution(){
        System.out.println(" ### 게시판 ### \n");
        Scanner scanner = new Scanner(System.in);
        String[] board = new String[3];
        while(true){
            System.out.println("[메뉴] 0.종료 1.글쓰기 2.글목록 3.글삭제");
            System.out.print(">>> ");
            String menu = scanner.next();
            switch(menu){
                case "0": System.out.println("종료합니다."); return;
                case "1": System.out.println("글쓰기");
                            board = write(board, scanner); break;
                case "2": System.out.println("글목록");
                            board = list(board); break;
                case "3": System.out.println("글삭제");
                            board = delete(board); break;
                default: System.out.println("이 번호는 없는 메뉴입니다. 다시 선택해주세요."); 
            }
        }
    }
    /**
     * 글쓰기
    */
    public String[] write(String[] board, Scanner scanner){
        int emptyCount = 3;
        int lastIndex = 0;
        if(emptyCount==0){
            System.out.println(" === 게시판 용량(3개)이 가득 찼습니다. === ");
        }else{
            System.out.println(" === 글을 작성해 주세요 === ");
            scanner.nextLine(); // 스캐너 버그 때문에 작성함
            String message = scanner.nextLine();
            board[lastIndex] = message;
            emptyCount--;
            lastIndex++;
        }
        return board;
    }
    /**
     * 글목록
    */
    public String[] list(String[] board){
        System.out.println(board[0]);
        return board;
    }
    /**
     * 글삭제
    */
    public String[] delete(String[] board){
        board[0] = "";
        return board;
    }
}