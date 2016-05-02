package com.bank.service;

import javax.swing.JOptionPane;

import com.bank.entities.User;

public class Rules {
	public static void validataUser(User user)throws Exception{
		//userId����ȫ��������
		String userId=user.getUserId();
		for(int i=0;i<userId.length();i++){
			if(!Character.isDigit(userId.charAt(i))){//�ж�������Ǵ�����
				JOptionPane.showMessageDialog(null, "userId����ȫ��Ϊ����");
				throw new Exception("���벻���Ϲ���");
			}
		}
		//����������8λС��16λ
		if(user.getUserPwd().length()<8||user.getUserPwd().length()>16){
			JOptionPane.showMessageDialog(null, "����������8λС��16λ");
			throw new Exception("����������8λС��16λ");
		}
		//�������ͬʱ�������ֺ���ĸ
		boolean hasDigit=false;
		boolean hasLetter=false;
		for(int i=0;i<user.getUserPwd().length();i++){
			if(Character.isDigit(user.getUserPwd().charAt(i))){//���������
				hasDigit=true;
			}
			if(Character.isLetter(user.getUserPwd().charAt(i))){//�������ĸ
				hasLetter=true;
			}
		}
		if(hasDigit&&hasLetter){
		}else{
			JOptionPane.showMessageDialog(null, "���벻���Ϲ淶�����������ĸ������");
			throw new Exception("���벻���Ϲ淶�����������ĸ������");
		}
		//���벻�ܰ����û�id
		if(user.getUserPwd().contains(user.getUserId())){
			JOptionPane.showMessageDialog(null, "���벻�ܰ����û�id");
			throw new Exception("���벻�ܰ����û�id");
		}
	}
	

}
