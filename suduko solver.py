class Solution:

    empty_spaces = 0
    size = 9
    board = None
    numbers = [str(i) for i in range(1,10)]

    def num_spaces(self):
        
        for i in range(self.size):
            for j in range(self.size):
                if self.board[i][j] == '.':
                        self.empty_spaces +=1

    def valid_move(self,pos,num):

        row,col = pos[0],pos[1]

        if num in self.board[row]:
            return False
        if num in [self.board[i][col] for i in range(self.size)]:
            return False

        box_row,box_col = row//3 *3,col//3 *3
        for x in range(box_row,box_row + 3):
            for y in range(box_col,box_col+3):
                # print(board[x][y],end=" ")
                if self.board[x][y] == num:
                    return False
        return True

    def solve(self,row,col):

        if self.empty_spaces == 0:
            return True

        while row < self.size:
            while col < self.size:

                if self.board[row][col] == '.':
                    
                    for num in self.numbers:
                        if self.valid_move((row,col),num): # row,col,area
                            self.board[row][col] = num
                            self.empty_spaces -= 1

                            if self.solve(row,col+1):
                                return True

                            self.board[row][col] = '.'
                            self.empty_spaces += 1

                    return False
                col += 1
            row += 1
            col = 0



    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.board = board
        self.num_spaces()
        self.solve(0,0)
        board = self.board

  


     
