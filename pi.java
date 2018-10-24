package multithread;

import java.util.Scanner;

public class pi {

	public static void main(String[] args) {
		computer c=new computer();
		c.go();

	}

}
class computer
{
	double pi;
	double s=4;
	double n;
	boolean flag;
	void go()
	{
		pi=0;
		flag=true;
		n=1;
		new Thread(){

			@Override
			public void run() {
				while(flag)
				{
					pi+=s/n;
					n+=2;
					s=-s;
				}
				super.run();
			}
			
			
		}.start();

		int t=0;
		Scanner s=new Scanner(System.in);
		while(t!=2)
		{
			t=s.nextInt();
			if(t==1 || t==2) System.out.println(pi);
			if(t==2) flag=false;
		}
	}
}