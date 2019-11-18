package igal.m.triviac;
public class QuestionLibrary
{
    private static String[] mQuestions = {
            "מה תדפיס התוכנית?" +
                    "\nint x = 3, y = 6;\n" +
                    "while (y > x > 1){\n" +
                    "x++};\n" +
                    "x--;\n" +
                    "printf(\"x= %d\", x);",
            "מה תדפיס המחרוזת?(באותיות קטנות)" +
                    "\n\nchar str[] = \"abc def ghi\";\n puts(str);",
            "מה ערכו של num בסוף התוכנית?" +
                    "\nint num =3;\n  num+=3;\n num= ??",
            "בסוף הלולאה כמה i שווה?:\n for(int i=0;i<5;i++)\n i = ?? ",
            "בסוף הלולאה כמה i שווה?:\n for(i=2;i<5;i+=2)\n i= ??",
            "מה ערכו של sum בסוף התוכנית?" +
                    "\nint x=6 , y = 4, sum = 4\n if (x>y)\nsum+=x;\n sum = ??",
            "מה תדפיס התוכנית?" +
                    "\nint i = 5, j = 2;\n" +
                    "i = i*i;\n" +
                    "j = j*j;\n" +
                    "printf(\"i=%d,j=%d\\n\",i,j);",
            "איזה ערך תחזיר הפונקצייה fun?" +
                    "\nfun(int x)\n{\n return x ? 1 + fun(x - 1) : 1; \n}\n" +
                    "main()\n{int x= 9;\n fun(x);}\n",
            "מה תדפיס התוכנית?" +
                    "\n\nint x = 7, y = 15;\n --x;" +
                    "\ny %= x;" +
                    "\nprintf(\"y=%d\", y);",
            "איזה 'תו' יודפס למסך?" +
                    "\nint a = 5;\n char str[] = \"xyz1xyz2\";\n printf(\"%c\",str[a-1]);\n //str[a-1] = ??",
            "מה תדפיס התוכנית?" +
                    "\nint x = 3,sum=2;\n" +
                    "\twhile (x--)\n" +
                    "\t\tsum *= 2;\n" +
                    "\tprintf(\"%d\", sum);",
            "מה תדפיס התוכנית?" +
                    "\nint x = 4,sum=24;\n" +
                    "while (x--)\n" +
                    "sum -= 3;\n" +
                    "printf(\"%d\", sum);",
            "מה תדפיס התוכנית?" +
                    "\nint x = 2,i,sum=0;\n" +
                    "for (i = 0; sum^2 !=0; i++)\n" +
                    "sum++;\n" +
                    "printf(\"%d\", i);",
            "חוקי או לא חוקי? אם כן, מה יודפס למסך?" +
                    "\n\nchar *str1 = \"igal\";\n" +
                    "strrev(str1);",
            "חוקי או לא חוקי? אם כן, מה יודפס למסך?" +
                    "\n\nchar str1[]=\"igal\",text[5];\n" +
                    "strcpy(text, str1);\n" +
                    "strrev(text);\n" +
                    "puts(text);",
            "int x = 4, y = 5, z = 6;\n" +
                    "if (x < z)\n" +
                    "x = 6;\n" +
                    "else\n" +
                    "x = 4;\n" +
                    "printf(\"%d\\n\", --x);",
            "int x = 6, y = 5, z = 6;\n" +
                    "if (x >= z)\n" +
                    "x = y++;\n" +
                    "else\n" +
                    "x = 4;\n" +
                    "printf(\"%d\\n\", --x);",
            "int x = 6, y = 5, z = 6;\n" +
                    "if (x == z)\n" +
                    "x = --y;\n" +
                    "else\n" +
                    "x = 4;\n" +
                    "printf(\"%d\\n\", x+=2);",
            "int Ax = 6, Bx = 5, Dx = 6 , Cx=3;\n" +
                    "while (--Cx)\n" +
                    "Ax++;\n" +
                    "Ax +=2;\n" +
                    "printf(\"%d\\n\", Ax);\n",
            "int Ax = 6, Bx = 5, Dx = 6 , Cx=1;\n" +
                    "while (--Cx)\n" +
                    "Ax++;\n" +
                    "Ax +=2;\n" +
                    "printf(\"%d\\n\", Ax);",
            "int Ax = 6;\n" +
                    "char Cx = \"6\";\n" +
                    "if (Ax == Cx)\n" +
                    "Ax++;\n" +
                    "else\n" +
                    "Ax +=2;\n" +
                    "printf(\"%d\\n\", Ax);",
            "int x = 4,y=0;\n" +
                    "char name[] = \"effi\";\n" +
                    "y = strlen(name);\n" +
                    "if (x == y)\n" +
                    "printf(\"Shayke bilu\");\n" +
                    "else\n" +
                    "printf(\"effi profesor!\");",
            "int x = 4,y=0;\n" +
                    "char name[] = \"effi\";\n" +
                    "y = strlen(name);\n" +
                    "if (x != y)\n" +
                    "printf(\"Shayke bilu\");\n" +
                    "else\n" +
                    "puts(name);",
            "char *a = \"i\";\n" +
                    "char *b = \"proffesor\";\n" +
                    "char *c = \"effi\";\n" +
                    "printf(\" %s %s %s \", --a , c , b );",
            "int x = 3, y = -3, z = 9;\n" +
                    "--x;\n" +
                    "y *= x;\n" +
                    "z += x;\n" +
                    "printf(\"%d\", z);"


    };


    private String mChoices [][] = {
            {"2","7","5"},
            {"abc def ghi", "abc ", "ghi"},
            {"3", "6", "9"},
            {"6", "4", "5"},
            {"6", "10", "4"},
            {"sum=10","sum= 6","sum=4"},
            {"j=25,i=4","i=20,j=5","i=25,j=4"},
            {"11","10","9"},
            {"6","3","1"},
            {"y","1","x"},
            {"8","16","12"},
            {"6","4","12"},
            {"0","1","2"},
            {"igal","lgai","error"},
            {"lagi","error","igal"},
            {"6","5","4"},
            {"6","5","4"},
            {"6","5","4"},
            {"13","10","7"},
            {"8","10","7"},
            {"7","8","10"},
            {"Shayke bilu","effi profesor!","4"},
            {"effi","effi profesor!","Shayke bilu"},
            {"  effi proffesor","i effi proffesor","proffesor"},
            {"10","11","9"},








    };


    private String mCorrectAnswers[] = {"2","abc def ghi","6","5","6","sum=10","i=25,j=4","10","3","x","16","12","1",
            "error","lagi","5","4","6","10","8","8","Shayke bilu","effi","  effi proffesor","11"};

    public static int getLenght(){ return mQuestions.length; }


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }



}

