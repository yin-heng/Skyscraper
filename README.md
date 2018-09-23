# Skyscraper
AOA Project
Problem definition
You are assigned to find the largest suitable location within a bounded area to build a skyscraper. The area is divided into a grid of N by M cells. Each cell (i,j) as an integer height H[i,j], where 1≤i≤N and1≤j≤M.
You have four different tasks:
1. Design and implement an Θ(N · M) time algorithm that uses O(M) space for computing a largest area square block with all cells have the height C. Note that this problem is the same as the Problem 4 of Exam 1 when C = 1 and N = M.
2. Design and implement an Θ(N · M2) time algorithm that uses O(M) space for computing a largest area rectangle block with all cells have the height C.
3. Design and implement an Θ(N · M) time algorithm that uses O(M) space for computing a largest area rectangle block with all cells have the height C.
4. Design and implement an Θ(N·M2·C) time algorithm that uses O(M·C) space for computing a largest area rectangle block with the height difference of at most C for any two cells in the block. In other words, for any two cells (i1, j1) , (i2, j2) in the block, we have |H[i1, j1] − H[i2, j2]| ≤ C.
Input/Output Requirements
You may implement this assignment in Java or C++. Your program must be compilable and runable on the Thunder CISE server using gcc/g++ or standard JDK. You may access the server using Telnet or SSH client on thunder.cise.ufl.edu.
You must write a makefile document which creates an executable. The name of your executable must be Skyscraper.
COT 5405 – Programming Project Page 1 / 2
The command line for this mode is as follows for C++ and Java respectively. The task is passed by an argument. For example, when Skyscraper 3 is called from the terminal, your program needs to run the third task. Sample input and output files for each task will be provided with running times.
Your program will read input from standard input (stdin) in the following order:
• Line 1 consists three integers N, M, C separated by one space character.
• For the next N lines, line i + 1 consist of M integers H [i, 1], H [i, 2], ..., H [i, m] in this particular order separated by one space character.
As the output, print four integers locating the region found: X1, Y1, X2, Y2 to standard output (stdout) separated by a space character, where (X1, Y1) is the upper left corner and (X2, Y2) is the lower right corner of the region.
