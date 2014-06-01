package org.dreamcorps.hackathon;

public class Question {

private String Question;
@SuppressWarnings("unused")
private int Question_ID;
@SuppressWarnings("unused")
private int Answer;
private String Option1;
private String Option2;
private String Option3;
private String Option4;
public void setQ(String Q){
	Question = Q;
}
public void setA(int A){
	this.Answer = A;	
}
public int getA(){
	return Answer;
	
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

public String[] getOptions(){
	String[] Options={""};
	Options[0]=Option1;
	Options[1]=Option2;
	Options[2]=Option3;
	Options[3]=Option4;
	return Options;	
}
}
