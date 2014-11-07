import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
	public static ArrayList<String> muts;
	public static double[] prob;
	public static int[] priority;
	public static String[] citDna;
	public static String virusDna;
	public static int numCitizens,lengthCitDNA,lengthVirusDNA;
	
	public static void main(String args[]){
		//data
		muts=new ArrayList<String>();
		
		//REEEEAAAAADDDDddd
		File file = new File("PracticeInput.txt");
		try {
			readFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//create the array containing possible mutations
		muts.add(virusDna);
		mutations(virusDna);
		//infeciton PROB
		//every cit
		for(int i=0;i<citDna.length;i++){
			//every mut
			for(int j=0;j<muts.size();j++){
				//if DNA has a virus mutation in it, store its prob of infection. else, infection prob  =0
				if(citDna[i].indexOf(muts.get(j)) >= 0){
					double prob2 = ((double)muts.get(j).length()/(double)lengthVirusDNA);
					if(prob2>prob[i]){prob[i]=prob2;}
				}
			}
		}
		
		//prioritize
		int currentPri=1;
		double max=maxProb();
		while(keepLooking()){
			findAllWithThisPri(max,currentPri);
			max=maxProb();
			currentPri++;
		}
		
		//PRINT
		for(int i=0;i<numCitizens;i++){
			System.out.println("Person#"+i+":"+priority[i]+".");
		}
	}
	
	private static void readFile(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		//get the first line parsed
		String line = br.readLine();
		String[] nums = line.split(" ");
		numCitizens = Integer.parseInt(nums[0]);
		lengthCitDNA = Integer.parseInt(nums[1]);
		lengthVirusDNA = Integer.parseInt(nums[2]);
		
		priority=new int[numCitizens];		
		citDna=new String[numCitizens];
		prob=new double[numCitizens];
		
		//parse all citizens
		for(int i=0;i<numCitizens;i++){
			citDna[i]=br.readLine();
		}
		//parse the virus
		virusDna=br.readLine();
	 
		br.close();
	}
	
	//all possible combinations of a string where a letter has been removed, down to 1 char
	private static void mutations(String dna){
		StringBuilder sb = new StringBuilder(dna);
//		System.out.println(sb.toString());
		for(int i=0;i<sb.length();i++){
			sb.deleteCharAt(i);
			if(!muts.contains(sb.toString())){mutations(sb.toString());}
			if(!muts.contains(sb.toString()) && !sb.toString().equals("")){
			muts.add(sb.toString());}

			sb=new StringBuilder(dna);
		}
//}
//		String tempVir = virusDna;
//		while(!tempVir.equals("")){
//			if(!muts.contains(tempVir)){
//				muts.add(tempVir);
//			}
//			tempVir=tempVir.substring(0,tempVir.length()-1);
//		}
//		int i=0;
//		tempVir=virusDna.substring(i,virusDna.length());
//		while(i<virusDna.length()){
//			if(!muts.contains(tempVir)){
//				muts.add(tempVir);
//			}
//			i++;
//			tempVir=virusDna.substring(i,virusDna.length());
//			
	}
	
//	private static void permutation(String prefix, String str) {
//	    int n = str.length();
//	    if (n == 0) muts.add(prefix);
//	    else {
//	        for (int i = 0; i < n; i++)
//	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
//	    }
//	}

	private static double maxProb(){
		double max=-1;
		for(int i=0;i<prob.length;i++){
			if(prob[i]>max){
				max=prob[i];
			}
		}
		return max;
	}
	
	private static void findAllWithThisPri(double max,int currentPri){
		for(int i=0;i<numCitizens;i++){
			if(check(prob[i],max)){
				priority[i]=currentPri;
				prob[i]=-1;
			}
		}
	}
	
	private static boolean keepLooking(){
		for(int i=0;i<priority.length;i++){
			if(check(priority[i],0)){
				return true;
			}
		}
		return false;
	}
	
	private static boolean check(double a,double b){
		if(Math.abs(a-b)<.00001){return true;}
		else{return false;}
	}
}
