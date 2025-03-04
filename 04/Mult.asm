// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/4/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)
// The algorithm is based on repetitive addition.

//// Replace this comment with your code.

//i=R0
@R0
D=M
@i 
M=D
// R2=R1
@R1
D=M
@R2
M=D

(LOOP)
@R1
D=M
@R2
M=D+M
@i
M=M-1
D=M
@LOOP
D;JGE





















//i = R0
@R0
D=M
@i
M=D
// sum = 0 
@0
D=A
@sum
M=D
(LOOP)
// if (i = 0) goto STOP
@i
D=M
@STOP
D;JEQ
// i = i - 1
@i
M=M-1
//sum += R1
@R1
D=M
@sum
M=D+M
// goto LOOP
@LOOP
0;JMP
(STOP)
@sum
D=M
@R2
M=D
(END)
