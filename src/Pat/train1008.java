package Pat;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyangbd on 2018/10/8.
 */
public class train1008 {

	public static void main(String[] args) {
		//train1001();
		train1002();
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
		String in ="13 1 2 3 4 5 6 7 8 9 10 20 16 18";

		String[] inC = in.split(" ");
		int A1 = 0;
		int A2 = 0;
		int A3 = 0;
		double A4 = 0;
		int A5 = 0;

		int num = 0;

		for (int i = 0;i<inC.length;i++){
			//A1
			if (Integer.valueOf(inC[i])%5==0&&Integer.valueOf(inC[i])%2==0){

				A1+=Integer.valueOf(inC[i]);
			}
			//A2
			if (Integer.valueOf(inC[i])%5==1){
				num+=1;
				if (num%2!=0){
					A2+=Integer.valueOf(inC[i]);
				}else{
					A2-=Integer.valueOf(inC[i]);
				}

			}
			//A3
			if (Integer.valueOf(inC[i])%5==2){

				A3+=1;
			}
			//A4
			if (Integer.valueOf(inC[i])%5==3){



				A4+=Integer.valueOf(inC[i]);
				num+=1;
				A4 = A4/num;
//				java.text.DecimalFormat df =new java.text.DecimalFormat("#.0");
//				df.format(A4);

			}
			//A5
			if (Integer.valueOf(inC[i])%5==4){

				if (Integer.valueOf(inC[i])>A5){
					A5=Integer.valueOf(inC[i]);
				}
			}
		}

		System.out.println(A1+" "+A2+" "+A3+" "+A4+" "+A5);
	}
}
