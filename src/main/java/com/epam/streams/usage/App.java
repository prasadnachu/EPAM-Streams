package com.epam.streams.usage;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App 
{
	private static Scanner sc;
	public static double getAverage(int[] array) {
		IntStream stream = IntStream.of(array); 
        OptionalDouble obj = stream.average(); 
        if (obj.isPresent()) { 
        	return (obj.getAsDouble()); 
        } 
        else { 
            return -1.0; 
        } 
	}
	public static List<String> getListOfWords(List<String>listWords){
		return listWords.stream().filter(s->s.startsWith("a")).filter(s->s.length()==3).collect(Collectors.toList());
	}
	public static List<String> getListOfPalindrome(List<String>listWords)
	{
		List<String> palindromeList=new ArrayList<>();
		for(int index=0;index<listWords.size();index++)
		{
			String temp=listWords.get(index);
			if(IntStream.range(0, temp.length()/2).noneMatch(i-> temp.charAt(i)!=temp.charAt(temp.length()-i- 1)))
			{
				palindromeList.add(temp);
			}
		}
		return palindromeList;
	}
    public static void main( String[] args)
    {
    	sc =new Scanner(System.in);
    	System.out.println("Enter number of elements ");
    	int n = sc.nextInt();
    	int[] arr=new int[n];
    	System.out.println("Enter elements of Array");
    	for(int i=0;i<n;i++) {
    		arr[i]=sc.nextInt();
    	}
    	System.out.println("The average of numbers is");
    	System.out.println(getAverage(arr));
    	System.out.println("Enter the size of word list");
    	int sizeWordsList=sc.nextInt();
    	sc.nextLine();
    	System.out.println("Enter the words");
    	List<String>listWords=new ArrayList<>();
    	for(int i=0;i<sizeWordsList;i++) {
    		listWords.add(sc.nextLine());
    	}
    	List<String>wordsStartWithA=getListOfWords(listWords);
    	System.out.println("List of words that start with a and length is of 3");
    	for(int i=0;i<wordsStartWithA.size();i++) {
    		System.out.println(wordsStartWithA.get(i));
    	}
    	System.out.println("Enter the size of word number");
    	int sizeOfPalindrome=sc.nextInt();
    	sc.nextLine();
    	System.out.println("Enter the strings");
    	List<String>listWordsPalindrome=new ArrayList<>();
    	for(int i=0;i<sizeOfPalindrome;i++) {
    		listWordsPalindrome.add(sc.nextLine());
    	}
    	List<String>listOfPalindrome=getListOfPalindrome(listWordsPalindrome);
    	System.out.println("List of Palindrome from the given list of words:");
    	for(int i=0;i<listOfPalindrome.size();i++) {
    		System.out.println(listOfPalindrome.get(i));
    	}
    	sc.close();
        
    }
}