package com.sample.perf;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PerfTest {

	static int threadCount = 1000;
	static ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

	static String text = "";
	
	public static void main(String[] args) throws Exception {

		text = new String(Files.readAllBytes(Paths.get("/Users/122746/CDE/java-pdd/src/main/resources/parsingFile.txt")), StandardCharsets.UTF_8);
		
		System.out.println("sleeping for 10 sec...");

		Thread.sleep(10000);

		System.out.println("execution starts now..");
		
		for (int i = 0; i < threadCount; i++) {
			executorService.execute(splitOperation());
			//executorService.execute(tokenizerOperation());
			//executorService.execute(indexOfOperation());
			
		}

		//Thread.sleep(10000);
		System.out.println("Shutting down all executorService");
		executorService.shutdown();
	}
	
	private static Runnable splitOperation() {
		return new Runnable()  {
			public void run() {
					
					String[] splitVaues = text.split(",");
					System.out.println("splitVaues : "+splitVaues.length);
				
				
				
				
			}
		};
	}
	
	private static Runnable indexOfOperation() {
		return new Runnable()  {
			public void run() {
				//LinkedHashSet<String> list = new LinkedHashSet<>();
				int index = text.indexOf(",");
				//System.out.println(index);
				while(index >=0){
					int startIndex = index;
					index = text.indexOf(",", index+1);
					//System.out.println(index);
					if(index>=0){
						text.substring(startIndex, index);
					}
					
				}
			}
		};
	}
	
	private static Runnable tokenizerOperation() {
		return new Runnable()  {
			public void run() {

					StringTokenizer st1 = new StringTokenizer(text, ","); 
					int counter =0;
			        while (st1.hasMoreTokens())  {
			        	counter++;
			        	//System.out.println(st1.nextToken()); 
			        	st1.nextToken();
			        }
			        System.out.println("counter : "+counter);
			}
		};
	}
}
