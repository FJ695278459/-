package ���߳�;

public class ���߳�ʾ�� {

	public static void main(String[] args) 
	{
		for(int i=0;i<50;i++)
		{
			
		}
		
		
			new Thread(() -> //����̲߳����ӣ�����ʹ�����
			{//Lambda���ʽ
					try 
					{
						for(int i=0;i<50;i++)
						{
							Thread.sleep(100);//ÿ��100����  
							System.out.println("�����߳�һ");
						}
						System.out.println("�߳�һ����");
					catch (Exception e)
						{
							e.printStackTrace();
						}
					}).start();//���̴�������1

				new Thread(new Runnable() {//����̲߳����ӣ�����ʹ�����
					@Override
					public void run() {
						try{
							for(int i=0;i<50;i++)
							{
								Thread.sleep(100);//ÿ��100����
								System.out.println("�����̶߳�");
							}
							System.out.println("�̶߳�����");
						}catch (Exception e){
							e.printStackTrace();
						}
					}
					}
			}).start();//���̴�������
		//����ķ����ʺϽϸ��ӵ��߳�  ��
		RunnableDemo R1 = new RunnableDemo("�߳���");//��������   �ǵÿ���
		R1.start();
		      
		
			

		
		
		
	}
	
}


/*
 * �̳߳��÷���
 * 
 * public static void sleep(long num)    	//��ָ���ĺ��������õ�ǰ����ִ�е��߳����ߣ���ִͣ�У�
 * Thread.sleep(100);//ÿ��100����  
 * 
 * public static Thread currentThread()		//���ضԵ�ǰ����ִ�е��̶߳��������
 * Thread.currentThread();
 * 
 * public void interrupt()					//�ж��߳�
 * Thread.interrupt();
 * 
 * public final void join(long num)			//�߳������ʱ�䣨���룩  �������ʱ�����ֹ
 * 
 */
//https://www.runoob.com/java/java-multithreading.html 			//�����ַ



class RunnableDemo implements Runnable //��õķ����Ǵ���һ��ʵ�� Runnable�ӿڵ���
{
	/*
	 * /**
     * ���ڲ���������ĺ���
     * @param lower �����������  (����ȡ)
     * @param upper �����������  (������ȡ)
     * @return key    ��Χ�ڵ������
     */
	
	
	private Thread thread;//����߳�
	private String ThreadName;//�߳���

	/**
     * ���캯��
     * @param Name  �߳���
     */

	public RunnableDemo(String Name)//�߳���       
	{
		ThreadName = Name;
	}

	/**
     * ��д�÷���       ������߳���ʹ�ö����� Runnable ���ж�����ģ�����ø� Runnable ����� run ���������򣬸÷�����ִ���κβ��������ء�
     */

	public void run()
	{
		try
		{
			for(int i=0;i<50;i++)
			{
				Thread.sleep(100);
				System.out.println("����" +ThreadName);
			}
			System.out.println( ThreadName+"����");
			}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	//ʹ���߳̿�ʼִ�У�Java ��������ø��̵߳� run ����
	
	/**
     * ��д�÷���      ʹ���߳̿�ʼִ�У�Java ��������ø��̵߳� run ������
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










