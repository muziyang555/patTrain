//package Pat;
//
///**
// * Created by liyangbd on 2018/10/17.
// */
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Scanner;
//class Child {
//	long id;
//	int grade1;
//	int grade2;
//	int sumGrade;
//	public Child (long id, int grade1, int grade2, int sumGrade) {
//		this.id = id;
//		this.grade1 = grade1;
//		this.grade2 = grade2;
//		this.sumGrade=sumGrade;
//
//	}
//	@Override
//	public String toString() {
//		return id+" "+grade1+" "+grade2;
//	}
//	public static void disPlay(List list)
//	{
//		for(int i=0;i<list.size(); i++)
//		{
//			System.out.println(list.get(i).toString());
//		}
//	}
//
//}
//public class Main {
//	public static void main(String[] args) {
//
//		Scanner in = new Scanner(System.in);
//		int N,L,H;
//		int sum=0,sumall=0;
//		N=in.nextInt();
//		L=in.nextInt();
//		H=in.nextInt();
//		in.nextLine();
//		List<Child> list1 = new ArrayList<>();
//		List<Child> list2 = new ArrayList<>();
//		List<Child> list3 = new ArrayList<>();
//		List<Child> list4 = new ArrayList<>();
//		String s;
//		int grade1;
//		int grade2;
//		long id;
//		for(int i=0; i<N; i++)
//		{
//			s=in.nextLine();
//			String[] str =s.split(" ");
//			id=Long.parseLong(str[0]);
//			grade1=Integer.parseInt(str[1]);
//			grade2=Integer.parseInt(str[2]);
//			if(grade1>=L && grade2>=L)
//			{
//				sum++;
//				sumall=grade1+grade2;
//				if(grade1>=H && grade2>=H)
//				{
//					list1.add(new Child(id,grade1,grade2,sumall));
//				}else if(grade1>=H && grade2<H)
//				{
//					list2.add(new Child(id,grade1,grade2,sumall));
//
//				}else if(grade1<H && grade2<H && grade1>=grade2)
//				{
//					list3.add(new Child(id,grade1,grade2,sumall));
//				}else
//				{
//					list4.add(new Child(id,grade1,grade2,sumall));
//				}
//			}
//
//		}
//		Comparator<Child> com = new Comparator<Child>() {
//
//
//
//			public int compare(Child o1, Child o2) {
//				if(o1.sumGrade>o2.sumGrade)
//				{
//					return -(o1.sumGrade-o2.sumGrade);
//				}else if(o1.sumGrade == o2.sumGrade)
//				{
//					if(o1.grade1 > o2.grade1)
//					{
//						return -(o1.grade1-o2.grade1);
//					}else if(o1.grade1 == o2.grade1)
//					{
//						return (int)(o1.id-o2.id);
//					}
//				}
//				return 0;
//
//			}
//
//		};
//
//		Collections.sort(list1, com);
//		Collections.sort(list2, com);
//		Collections.sort(list3, com);
//		Collections.sort(list4, com);
//
//		System.out.println(sum);
//		Child.disPlay(list1);
//		Child.disPlay(list2);
//		Child.disPlay(list3);
//		Child.disPlay(list4);
//
//
//	}
//
//
//}
