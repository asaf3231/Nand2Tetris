// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/4/Fill.asm

// Runs an infinite loop that listens to the keyboard input. 
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel. When no key is pressed, 
// the screen should be cleared.

(INF)
// i = 8191
@8191
D=A
@i
M=D
//checking KBD
@KBD
D=M
@BLACKLOOP
D;JNE
//if kbd = 0
(WHITELOOP)
@i
D=M
@SCREEN
A=D+A
M=0
// i = i - 1
@i
M=M-1
//if i = 0
@WHITELOOP
D;JGE
@INF
0;JMP
//if kbd.value != 0 
(BLACKLOOP)
@i
D=M
@SCREEN
A=D+A
M=-1
// i = i - 1
@i
M=M-1
//if i < 8191
@BLACKLOOP
D;JGE
@INF
0;JMP