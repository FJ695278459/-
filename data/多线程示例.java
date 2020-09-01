package 多线程;

public class 多线程示例 {

	public static void main(String[] args) 
	{
		for(int i=0;i<50;i++)
		{
			
		}
		
		
			new Thread(() -> //如果线程不复杂，可以使用这个
			{//Lambda表达式
					try 
					{
						for(int i=0;i<50;i++)
						{
							Thread.sleep(100);//每隔100毫秒  
							System.out.println("运行线程一");
						}
						System.out.println("线程一结束");
					catch (Exception e)
						{
							e.printStackTrace();
						}
					}).start();//进程创建方法1

				new Thread(new Runnable() {//如果线程不复杂，可以使用这个
					@Override
					public void run() {
						try{
							for(int i=0;i<50;i++)
							{
								Thread.sleep(100);//每隔100毫秒
								System.out.println("运行线程二");
							}
							System.out.println("线程二结束");
						}catch (Exception e){
							e.printStackTrace();
						}
					}
					}
			}).start();//进程创建方法
		//下面的方法适合较复杂的线程  ，
		RunnableDemo R1 = new RunnableDemo("线程三");//类在下面   记得看哈
		R1.start();
		      
		
			

		
		
		
	}
	
}


/*
 * 线程常用方法
 * 
 * public static void sleep(long num)    	//在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）
 * Thread.sleep(100);//每隔100毫秒  
 * 
 * public static Thread currentThread()		//返回对当前正在执行的线程对象的引用
 * Thread.currentThread();
 * 
 * public void interrupt()					//中断线程
 * Thread.interrupt();
 * 
 * public final void join(long num)			//线程运行最长时间（毫秒）  多余这个时间就终止
 * 
 */
//https://www.runoob.com/java/java-multithreading.html 			//相关网址



class RunnableDemo implements Runnable //最好的方法是创建一个实现 Runnable接口的类
{
	/*
	 * /**
     * 用于产生随机数的函数
     * @param lower 随机数的下限  (可以取)
     * @param upper 随机数的上限  (不可以取)
     * @return key    范围内的随机数
     */
	
	
	private Thread thread;//这个线程
	private String ThreadName;//线程名

	/**
     * 构造函数
     * @param Name  线程名
     */

	public RunnableDemo(String Name)//线程名       
	{
		ThreadName = Name;
	}

	/**
     * 重写该方法       如果该线程是使用独立的 Runnable 运行对象构造的，则调用该 Runnable 对象的 run 方法；否则，该方法不执行任何操作并返回。
     */

	public void run()
	{
		try
		{
			for(int i=0;i<50;i++)
			{
				Thread.sleep(100);
				System.out.println("运行" +ThreadName);
			}
			System.out.println( ThreadName+"结束");
			}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	//使该线程开始执行；Java 虚拟机调用该线程的 run 方法
	
	/**
     * 重写该方法      使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
     */

	public void start ()
	{
	      if (thread == null) 
	      {
	    	  thread = new Thread (this, ThreadName);
	    	  thread.start();
	      }
	}
}










