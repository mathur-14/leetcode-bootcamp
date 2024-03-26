public boolean isValidSudoku(char[][] board) {
    Set s = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j];
            if (number != '.')
                if (!s.add(number + " in row " + i) ||
                    !s.add(number + " in column " + j) ||
                    !s.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
}