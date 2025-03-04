@3030
D=A
@SP
A=M
M=D
@SP
M=M+1

@SP
AM=M-1
D=M
@THIS
M=D

@3040
D=A
@SP
A=M
M=D
@SP
M=M+1

@SP
AM=M-1
D=M
@THAT
M=D

@32
D=A
@SP
A=M
M=D
@SP
M=M+1

@THIS
D=M
@2
D=D+A
@R14
M=D
@SP
AM=M-1
D=M
@R14
A=M
M=D

@46
D=A
@SP
A=M
M=D
@SP
M=M+1

@THAT
D=M
@6
D=D+A
@R14
M=D
@SP
AM=M-1
D=M
@R14
A=M
M=D

@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1

@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@SP
M=M-1
A=M
M=D+M
@SP
M=M+1

@THIS
D=M
@2
D=D+A
A=D
D=M
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@SP
M=M-1
A=M
M=M-D
@SP
M=M+1

@THAT
D=M
@6
D=D+A
A=D
D=M
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@SP
M=M-1
A=M
M=D+M
@SP
M=M+1

@111
D=A
@SP
A=M
M=D
@SP
M=M+1

@333
D=A
@SP
A=M
M=D
@SP
M=M+1

@888
D=A
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@NoamTest.8
M=D

@SP
M=M-1
A=M
D=M
@NoamTest.3
M=D

@SP
M=M-1
A=M
D=M
@NoamTest.1
M=D

@NoamTest.3
D=M
@SP
A=M
M=D
@SP
M=M+1

@NoamTest.1
D=M
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@SP
M=M-1
A=M
M=M-D
@SP
M=M+1

@NoamTest.8
D=M
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@SP
M=M-1
A=M
M=D+M
@SP
M=M+1

(FINISH)
@FINISH
0;JMP
