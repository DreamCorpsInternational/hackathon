package org.dreamcorps.hackathon;

public class Question {

private String Question;
private int Question_ID;
private String Answer;
private String Option1;
private String Option2;
private String Option3;
private String Option4;
public void setQ(String Q){
	Question = Q;
}
public void setA(String A){
	Answer = A;	
}
public void setOptions(String[] Options){
	Option1 = Options[0];
	Option2 = Options[1];
	Option3 = Options[2];
	Option4 = Options[3];
	
}
public String getQ(){
	return Question;
}
}
