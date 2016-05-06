package com.bank.service;

import javax.swing.JOptionPane;

import com.bank.entities.Account;
import com.bank.entities.User;

public class Rules {
	
	/*校验Account是否符合规则*/
	public static void validataAccount(Account acct) throws Exception{
		//用户卡号必须是数组，并且必须大于9位
		String acctId = acct.getAcctId();
		if(acctId.length()<9) 
			throw new Exception("卡号务必大于9位");
		for (int i = 0; i < acctId.length(); i++) {
			if(!Character.isDigit(acctId.charAt(i))){//判断如果不是纯数字
				JOptionPane.showMessageDialog(null, "卡号必须全部为数字");
				throw new Exception("卡号不符合规则");
			}
		}
		//存储时间不得超过100年
		int saveYear = acct.getSaveYear();
		if(saveYear>100) throw new Exception("存储年限不能超过100年");
	}
	public static void validataUser(User user)throws Exception{
		//userId必须全部是数字
		String userId=user.getUserId();
		for(int i=0;i<userId.length();i++){
			if(!Character.isDigit(userId.charAt(i))){//判断如果不是纯数字
				JOptionPane.showMessageDialog(null, "userId必须全部为数字");
				throw new Exception("密码不符合规则");
			}
		}
		//密码必须大于8位小于16位
		if(user.getUserPwd().length()<8||user.getUserPwd().length()>16){
			JOptionPane.showMessageDialog(null, "密码必须大于8位小于16位");
			throw new Exception("密码必须大于8位小于16位");
		}
		//密码必须同时包含数字和字母
		boolean hasDigit=false;
		boolean hasLetter=false;
		for(int i=0;i<user.getUserPwd().length();i++){
			if(Character.isDigit(user.getUserPwd().charAt(i))){//如果有数字
				hasDigit=true;
			}
			if(Character.isLetter(user.getUserPwd().charAt(i))){//如果有字母
				hasLetter=true;
			}
		}
		if(hasDigit&&hasLetter){
		}else{
			JOptionPane.showMessageDialog(null, "密码不符合规范，必须包含字母和数字");
			throw new Exception("密码不符合规范，必须包含字母和数字");
		}
		//密码不能包含用户id
		if(user.getUserPwd().contains(user.getUserId())){
			JOptionPane.showMessageDialog(null, "密码不能包含用户id");
			throw new Exception("密码不能包含用户id");
		}
	}
	

}
