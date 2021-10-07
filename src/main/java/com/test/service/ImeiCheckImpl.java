package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class ImeiCheckImpl {
	
	public String checkValidIMEI(String ImeiValue) {
		int n = ImeiValue.length();
		if(n!=15){
			return "Please provide valid IMEI number having 15 digits";
		}
		int sum=0;
		for(int i=n-1;i>=0;i--) {
			int val=ImeiValue.charAt(i)-'0';
			if(i%2!=0) {
				val=val*2;
			}
			sum+=sumDigit(val);
		}
		if(sum%10==0)
			return "Valid IMEI number";
		String res = "Invalid IMEI number, replace last digit with ";
		int last=ImeiValue.charAt(n-1)-'0';
		int val1 = last+10-(sum%10);
		int val2 = last-(sum%10);
		if(val1>=0 && val1<=9 )
			return res+val1;
		return res+val2;
	}
	
	public int sumDigit(int n) {
		int s=0;
		while(n>0){
            s = s+n % 10;
            n = n/10;
        }
		return s;
	}

}
