// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. Вывести доску

// Решение.
// Данная задача имеет 92 варианта решений.
// В представленном коде реализован рандомный поиск решения:
// Первый ферзь ставится на случайную клетку. При этом клетки по вертикали, горизонтали и диагоналям помечаются как занятые (-1)
// Каждый следующий ферзь ставится на случайную свободную ячейку, соответствующие ячейки вокруг помечаются как занятые.
// Процесс продолжается до тех пор, пока не останется свободных ячеек.
// Далее проверяется количество ферзей на доске. Если их 8 - решение найдено, иначе запускается поиск нового решения.


class chess {
    final public static int BOARD_SIZE = 8;     // размерность шахматной доски
    public static void main(String[] args) {
        // Задаём шахматную доску
        int[][] chessBoard = new int[BOARD_SIZE][BOARD_SIZE];
        int counter = 0;                        // ради любопытства - на каком варианте будет найдено решение
        while (countQueens(chessBoard) != 8) {
            eigthQueens(chessBoard);
            counter++;
        }
      
        printBoard(chessBoard);
        System.out.println("\n" + printAnswer(chessBoard));
        System.out.println("Found on step : " + counter);
    }

    // вывод схемы шахматной доски с ферзями в консоль
    public static void printBoard(int[][] board) {
        System.out.print("  ");
        for(int i = 0; i < BOARD_SIZE; i++) System.out.print("----");
        System.out.println();
        for(int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((8 - i) + " |");                           // подписываем цифры слева
            for(int j = 0; j < BOARD_SIZE; j++){
                if (board[i][j] == 1) System.out.print(" Q |");
                    else System.out.print("   |"); //
                    
            }
            System.out.print("\n  ");
            for(int k = 0; k < BOARD_SIZE; k++) System.out.print("----");
            System.out.println();
        }

        // подписываем буквы внизу
        System.out.print("  ");
        for(int i = 0; i < BOARD_SIZE; i++) System.out.print("  " + ((char) ('A' + i)) + " ");
        System.out.println();
    }

    // вывод решения координатами
    public static String printAnswer(int[][] board) {
        StringBuilder ans = new StringBuilder("");
        for(int j = 0; j < BOARD_SIZE; j++){
            for(int i = 0; i < BOARD_SIZE; i++){
                if (board[i][j] == 1) {
                    ans.append((char) ('A' + j));
                    ans.append(BOARD_SIZE - i);
                    ans.append(" ");
                }
            }
        }
        return ans.toString();
    }

    // считает количество ферзей на доске
    public static int countQueens(int[][] board) {
        int counter = 0;
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1) counter++;
            }
        }

        return counter;
    }

    // проверяет есть ли куда ещё поставить ферзя
    // true - доска заполнена, ставить ферзей некуда, false - для ферзя еще есть место
    public static boolean fullBoard(int[][] board) {
        boolean full = true;
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 0) {
                    full = false;
                    break;
                }
            }
            if (!full) break;   // прерываем внешний цикл, если внутренний был прерван
        }
        return full;
    }

    // Очищает игровую доску
    public static void clearBoard(int[][] board) {
        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j = 0; j < BOARD_SIZE; j++){
                board[i][j] = 0;
            }
        }
    }

    // забивает ячейки, в которые ферзей ставить нельзя
    public static void fillLines(int[][] board, int x, int y){
        // по вертикали
        for(int i = 0; i < BOARD_SIZE; i++){
            if (i != x) board[i][y] = -1;
        }
        // по горизонтали
        for(int j = 0; j < BOARD_SIZE; j++){
            if (j != y) board[x][j] = -1;
        }
        // по главной диагонали
        int i = x + 1;
        int j = y + 1;
        while (i < BOARD_SIZE && j < BOARD_SIZE) board[i++][j++] = -1;
        i = x - 1;
        j = y - 1;
        while (i >= 0 && j >= 0) board[i--][j--] = -1;
        // по побочной диагонали
        i = x - 1;
        j = y + 1;
        while (i >= 0 && j < BOARD_SIZE) board[i--][j++] = -1;
        i = x + 1;
        j = y - 1;
        while (i < BOARD_SIZE && j >= 0) board[i++][j--] = -1;

    }

    // расставляет 8 ферзей
    public static void eigthQueens(int[][] board) {
        clearBoard(board);
        
        while (!fullBoard(board)) {
            
            int x = (int) (Math.random() * 8);
            int y = (int) (Math.random() * 8);
            while (board[x][y] != 0) {
                x = (int) (Math.random() * 8);
                y = (int) (Math.random() * 8);
            }
            board[x][y] = 1;
            fillLines(board, x, y);
        }

    }
}