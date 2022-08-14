package com.JUnit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
//step1
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class LoginTestJunit {
	//step2
	String Username;
	String Password;
	String Browser;
	//step3-constructor
	public LoginTestJunit(String Username,String Password,String Browser) {
		this.Username=Username;
		this.Password=Password;
		this.Browser=Browser;
	}
	@Test
	public void JunitLogin() {
		System.out.println(Username+"--"+Password+"--"+Browser);
	}
	
	//step-4
	@Parameters
	public static Collection<Object[]> getData()
	{
		Object[][] data=new Object[4][3];
		data[0][0]="U1";
		data[0][1]="P1";
		data[0][2]="Mozilla";
		
		data[1][0]="U2";
		data[1][1]="P2";
		data[1][2]="Chrome";
		
		data[2][0]="U3";
		data[2][1]="P3";
		data[2][2]="IE";
		
		data[3][0]="U4";
		data[3][1]="P4";
		data[3][2]="Safari";
		
		//Converting the 2D data into list
		return Arrays.asList(data);
	}

}
