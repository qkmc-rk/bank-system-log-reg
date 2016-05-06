package com.bank.service;

import javax.swing.JOptionPane;

import com.bank.entities.Account;
import com.bank.entities.User;

public class Rules {
	
	/*У��Account�Ƿ���Ϲ���*/
	public static void validataAccount(Account acct) throws Exception{
		//�û����ű��������飬���ұ������9λ
		String acctId = acct.getAcctId();
		if(acctId.length()<9) 
			throw new Exception("������ش���9λ");
		for (int i = 0; i < acctId.length(); i++) {
			if(!Character.isDigit(acctId.charAt(i))){//�ж�������Ǵ�����
				JOptionPane.showMessageDialog(null, "���ű���ȫ��Ϊ����");
				throw new Exception("���Ų����Ϲ���");
			}
		}
		//�洢ʱ�䲻�ó���100��
		int saveYear = acct.getSaveYear();
		if(saveYear>100) throw new Exception("�洢���޲��ܳ���100��");
	}
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
