package basic;
import java.util.*;
class 게시판 {
    public static void main(String[] args) {
        게시판 solution = new 게시판();
        solution.solution();
    }
    public void solution(){
        System.out.println("\n### 게시판 ### \n");
        Scanner scanner = new Scanner(System.in);
        String[] board = new String[4];
        int emptyCount = 4;
        int lastIndex = -1; // 인덱스 0은 이미 존재하는 상황이므로 없음은 -1로 표현
        while(true){
            System.out.println("[메뉴] 0.종료 1.글쓰기 2.글목록 3.글삭제");
            String menu = scanner.next();
            switch(menu){
                case "0": System.out.println("종료합니다."); return;
                case "1": System.out.println("*** 글쓰기 ***");
                            if(emptyCount <= 0){
                                System.out.println(" === 게시판 용량(4개)이 가득 찼습니다. === ");
                                //System.out.println("last index : "+ lastIndex);
                            }else{
                                lastIndex++; // 처음 글을 쓸 때 -1은 0이 되어야 하므로 쓰기 전에 추가한다
                                board = write(board, scanner, lastIndex); 
                                emptyCount--;
                                //System.out.println("last index : "+ lastIndex);
                            }
                            break;
                case "2": System.out.println("*** 글목록 ***");
                            board = list(board); break;
                case "3": System.out.println("*** 글삭제 ***");
                            if(emptyCount == 3){
                                System.out.println(" === 삭제할 글이 없습니다. === ");
                            }else{
                                board = delete(board, scanner, lastIndex); 
                                emptyCount++;
                                lastIndex--;
                            }
                            break;
                default: System.out.println("이 번호는 없는 메뉴입니다. 다시 선택해주세요."); 
            }
        }
    }
    /**
     * 글쓰기
    */
    public String[] write(String[] board, Scanner scanner, int lastIndex){
        System.out.println(" === 글을 작성해 주세요 === ");
        System.out.print(">>> ");
        scanner.nextLine(); // 스캐너 버그 때문에 작성함
        String message = scanner.nextLine();
        board[lastIndex] = message;
        return board;
    }
    /**
     * 글목록
    */
    public String[] list(String[] board){
        for(int i=0; i< board.length; i++){
            System.out.println(String.format("[%d]번 글 : %s", i+1, board[i]));
        }
        return board;
    }
    /**
     * 글삭제
    */
    public String[] delete(String[] board, Scanner scanner, int lastIndex){
        System.out.println("몇번 글을 삭제하시겠습니까? ");
        System.out.print(">>> ");
        int deleteNumber = scanner.nextInt();
        // System.out.println("마지막 인덱스: "+lastIndex);
        board[deleteNumber-1] = board[lastIndex];
        board[lastIndex] = "";
        return board;
    }
}