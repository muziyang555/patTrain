package Pat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyangbd on 2018/10/8.
 */
public class train1008 {

	public static void main(String[] args) {
		train1001();
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
		for (int j = 0;j<inchar.length;j++) {
			System.out.println(inchar[j]);
			String jstring = inchar[j];
			if (j != 0) {
				String[] jchar = jstring.split(" ");
				System.out.println(jchar[j]);
			}
		}

		int num = 4;
		for (int i = 0; i < num; i++) {
			int[] a = {10, 11, 12};
			boolean flag ;
			if (a[0]+a[1]>a[2]){
				flag=true;
			}else{
				flag=false;
			}
			int tmp = i+1;
			System.out.println("Case #"+tmp+":"+flag);
		}





	}
}
