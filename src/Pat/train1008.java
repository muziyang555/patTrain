package Pat;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyangbd on 2018/10/8.
 */
public class train1008 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //train1001();
        //train1002();
        //train1003(5, 27);
        train1004();

        long endTime = System.currentTimeMillis();
        System.out.println("当前程序耗时：" + (endTime - startTime) + "ms");
    }

    public static void train1001() {
        /*
		题目描述
            给定区间[-2的31次方, 2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。

            输入描述:
            输入第1行给出正整数T(<=10)，是测试用例的个数。随后给出T组测试用例，每组占一行，顺序给出A、B和C。整数间以空格分隔。


            输出描述:
            对每组测试用例，在一行中输出“Case #X: true”如果A+B>C，否则输出“Case #X: false”，其中X是测试用例的编号（从1开始）。
		 */
        String in = "4\n" +
                "1 2 3\n" +
                "2 3 4\n" +
                "2147483647 0 2147483646\n" +
                "0 -2147483648 -2147483647";

        String[] inchar = in.split("\\n");
        for (int j = 0; j < inchar.length; j++) {
            //System.out.println(inchar[j]);
//			String jstring = inchar[j];
//				System.out.println(jstring);
            if (j > 0) {
                boolean flag = false;
                int tmp = 0;
                String[] a = inchar[j].split(" ");
                for (int i = 0; i < a.length; i++) {
                    int[] as = {Integer.valueOf(a[0]), Integer.valueOf(a[1]), Integer.valueOf(a[2])};
                    if (as[0] + as[1] > as[2]) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                    tmp = i + 1;
                }
                System.out.println("Case #" + tmp + ":" + flag);
            }
        }
    }

    public static void train1002() {
		/*
		题目描述
            给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：

            A1 = 能被5整除的数字中所有偶数的和；
            A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
            A3 = 被5除后余2的数字的个数；
            A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
            A5 = 被5除后余4的数字中最大数字。

            输入描述:
            每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。


            输出描述:
            对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
            若其中某一类数字不存在，则在相应位置输出“N”。
		 */
        String in = "13 1 2 3 4 5 6 7 8 9 10 20 16 18";

        String[] inC = in.split(" ");
        int A1 = 0;
        int A2 = 0;
        int A3 = 0;
        double A4 = 0;
        int A5 = 0;
        int num = 0;
        int num4 = 0;

        for (int i = 0; i < inC.length; i++) {
            //A1
            if (Integer.valueOf(inC[i]) % 5 == 0 && Integer.valueOf(inC[i]) % 2 == 0) {

                A1 += Integer.valueOf(inC[i]);
            }
            //A2
            if (Integer.valueOf(inC[i]) % 5 == 1) {

                int tmp = 0;
                if (num % 2 != 1) {
                    tmp = Integer.valueOf(inC[i]);
                    A2 += tmp;
                } else {
                    tmp = Integer.valueOf(inC[i]);
                    A2 -= tmp;
                }
                num += 1;

            }
            //A3
            if (Integer.valueOf(inC[i]) % 5 == 2) {

                A3 += 1;
            }
            //A4
            if (Integer.valueOf(inC[i]) % 5 == 3) {


                num4 += 1;
                A4 += Integer.valueOf(inC[i]);


            }
            //A5
            if (Integer.valueOf(inC[i]) % 5 == 4) {

                if (Integer.valueOf(inC[i]) > A5) {
                    A5 = Integer.valueOf(inC[i]);
                }
            }
        }
        A4 = A4 / num4;
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.0");
        df.format(A4);
        System.out.println(A1 + " " + A2 + " " + A3 + " " + df.format(A4) + " " + A5);
    }

    public static void train1003(int start, int end) {
		/*
		题目描述
            令Pi表示第i个素数。现任给两个正整数M <= N <= 10000，请输出PM到PN的所有素数。

            输入描述:
            输入在一行中给出M和N，其间以空格分隔。


            输出描述:
            输出从PM到PN的所有素数，每10个数字占1行，其间以空格分隔，但行末不得有多余空格。

            输入例子:
            5 27

            输出例子:
            11 13 17 19 23 29 31 37 41 43
            47 53 59 61 67 71 73 79 83 89
            97 101 103


            素数：只能被1和本身整除

		 */
        int total = end - start + 1;

        List su = new ArrayList();

        for (int i = 1; i < 10000; i++) {
            //判断素数
//			if (i==2){
//				isSu = true;
//			}
            boolean isSu = true;
            for (int b = 2; b < i; b++) {
                if (i % b == 0) {
                    isSu = false;
                    break;
                }
            }
            if (isSu) {
                su.add(i);
            }

        }

        for (int j = 1; j < total + 1; j++) {
            if (j % 10 != 0) {
                System.out.print(su.get(start + j - 1) + " ");
            }
            if (j % 10 == 0) {
                System.out.println(su.get(start + j - 1) + "\n");
            }

        }

    }

    public static void train1004(){
        /*
        题目描述
            大侦探福尔摩斯接到一张奇怪的字条：“我们约会吧！ 3485djDkxh4hhGE 2984akDfkkkkggEdsb s&hgsfdk d&Hyscvnm”。大侦探很快就明白了，字条上奇怪的乱码实际上就是约会的时间“星期四 14:04”，因为
            前面两字符串中
            第1对相同的大写英文字母（大小写有区分）是第4个字母'D'，代表星期四；
            第2对相同的字符是'E'，那是第5个英文字母，代表一天里的第14个钟头（于是一天的0点到23点由数字0到9、以及大写字母A到N表示）；
            后面两字符串
            第1对相同的英文字母's'出现在第4个位置（从0开始计数）上，代表第4分钟。现给定两对字符串，

            请帮助福尔摩斯解码得到约会的时间。

            输入描述:
            输入在4行中分别给出4个非空、不包含空格、且长度不超过60的字符串。


            输出描述:
            在一行中输出约会的时间，格式为“DAY HH:MM”，其中“DAY”是某星期的3字符缩写，即MON表示星期一，TUE表示星期二，WED表示星期三，THU表示星期
            四，FRI表示星期五，SAT表示星期六，SUN表示星期日。题目输入保证每个测试存在唯一解。

            输入例子:
            3485djDkxh4hhGE
            2984akDfkkkkggEdsb
            s&hgsfdk
            d&Hyscvnm

            输出例子:
            THU 14:04
         */
        String A = "3485djDkxh4hhGE";
        String B = "2984akDfkkkkggEdsb";
        String C = "s&hgsfdk";
        String D = "d&Hyscvnm";

        /** 1、判断是否是字母
         *  2、判断字母大小写
         *  3、遍历比较
         *  4、字符在字符串的位置
        **/

        //字符串转换成数组
        char[] Achar = A.toCharArray();
        //数组转换成List
        List listA = new ArrayList();
        for (char tmp:Achar){
            listA.add(tmp);
        }

        //字符串转换成数组
        char[] Bchar = B.toCharArray();
        //数组转换成List
        List listB = new ArrayList();
        for (char tmp:Bchar){
            listB.add(tmp);
        }

        List Day = new ArrayList() ;
        for (int i = 0;i<Achar.length;i++){
            if (Achar[i]>'A'&& Achar[i]<'Z'){
                for (int j = 0;j<Bchar.length;j++){
                    if (Bchar[j]==Achar[i]){
                        Day.add(Bchar[j]);
                    }
                }
            }
        }


        if (Day.size()>=2){
            int day  = Day.get(0).toString().toCharArray()[0] - 'A';
            String DAY;
            switch (day){
                case 0:
                    DAY="MON";break;
                case 1:
                    DAY="TUE";break;
                case 2:
                    DAY="WED";break;
                case 3:
                    DAY="THU";break;
                case 4:
                    DAY="FRI";break;
                case 5:
                    DAY="SAT";break;
                case 6:
                    DAY="SUN";break;
                default:
                    DAY = "NO";break;
            }
            System.out.println("星期"+DAY);

            int time  = Day.get(1).toString().toCharArray()[0] - 'A';
            String TIEM;
            switch (time){
                case 0:TIEM="10";break;
                case 1:TIEM="11";break;
                case 2:TIEM="12";break;
                case 3:TIEM="13";break;
                case 4:TIEM="14";break;
                case 5:TIEM="15";break;
                case 6:TIEM="16";break;
                case 7:TIEM="17";break;
                case 8:TIEM="18";break;
                case 9:TIEM="19";break;
                case 10:TIEM="20";break;
                case 11:TIEM="21";break;
                case 12:TIEM="22";break;
                case 13:TIEM="23";break;
                case 14:TIEM="24";break;
                default:
                    TIEM = "NO";break;
            }
            System.out.println("小时"+TIEM);
        }else {
            System.out.printf("字符串不符合要求");
        }

        //字符串转换成数组
        char[] Cchar = C.toCharArray();
        //字符串转换成数组
        char[] Dchar = D.toCharArray();

        List min = new ArrayList() ;
        for (int i = 0;i<Cchar.length;i++){
            if (Cchar[i]>'a'&& Cchar[i]<'z'){
                for (int j = 0;j<Dchar.length;j++){
                    if (Dchar[j]==Dchar[i]){
                        min.add(Dchar[j]);
                    }
                }
            }
        }

        String mins = null;
        if (min.size()>=1) {
            for (int i = 0;i<Dchar.length;i++){
                if (Dchar[i]==min.get(0).toString().toCharArray()[0]){
                    mins = Integer.valueOf(i).toString();
                }
            }

            System.out.println("星期" + mins);
        }


            System.out.println(min);

    }


/*
*各种字符的unicode编码的范围：
     * 汉字：[0x4e00,0x9fa5]（或十进制[19968,40869]）
     * 数字：[0x30,0x39]（或十进制[48, 57]）
     *小写字母：[0x61,0x7a]（或十进制[97, 122]）
     * 大写字母：[0x41,0x5a]（或十进制[65, 90]）
 */
    public static boolean isLetterDigitOrChinese(String str) {
        String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";//其他需要，直接修改正则表达式就好
        return str.matches(regex);
    }
}
