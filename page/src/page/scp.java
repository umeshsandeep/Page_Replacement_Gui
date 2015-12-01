package page;
//import java.util.Scanner;


public class scp {

public static int full=0;
public static int[] a;
public static int ref[]=new int[3];
public static int frame[]=new int[3];
public static int repptr=0;
public static int count=0;
public static void display()
{		int i;
		System.out.println("\nThe elements in the frame are\n");
		for(i=0;i<full;i++)
			System.out.println(frame[i]);
 }
public static int Pagerep(int ele)
{
 int temp;
 while(ref[repptr]!=0)
{ 
	 ref[repptr++]=0;
	 if(repptr==3)
     repptr=0;
}                     
 temp=frame[repptr];
 frame[repptr]=ele;
 ref[repptr]=1;
 return temp;   
}
public static void Pagefault(int ele)
{
	if(full!=3)
{
		ref[full]=1;
       frame[full++]=ele;
}
//else
//System.out.println(Pagerep(ele));
}
public static  int Search(int ele)
{     
	int i,flag;
    flag=0;
    if(full!=0)
    {
    for(i=0;i<full;i++)
    if(ele==frame[i])
    {  
    	flag=1;
        ref[i]=1;
        break;
     }
    }
 return flag;   
}
public scp (int fr,int[] in)
{
	int n,i;
	//int a[]=new int[100];
   
	//Scanner in=new Scanner(System.in);
	System.out.println("Enter no .of pages");
	//n=in.nextInt();
	System.out.println("Enter page nos");
	a=new int[in.length];
    for(i=0;i<in.length;i++)
    	{
    	a[i]=in[i];
    	System.out.println(a[i]);
    	
    	}
    for(i=0;i<a.length;i++)
    {
                    if(Search(a[i])!=1)
                    {
                    	Pagefault(a[i]);
                        //display();
                        count++;
                    }
    }
                   System.out.print(count);
}
public int method(){
	return count;
}
}

