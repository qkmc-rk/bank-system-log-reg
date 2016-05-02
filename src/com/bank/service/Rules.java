package com.bank.service;

import javax.swing.JOptionPane;

import com.bank.entities.User;

public class Rules {
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
