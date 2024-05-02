/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ComboBoxMonthTag.java
 *@FileTitle : Common
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-11
 *@LastModifier : 김원섭
 *@LastVersion : 1.0
 * 2006-10-11 김원섭
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.esm.spc.common.taglib;

import java.util.Calendar;

/**
 * 조회조건 ComboBox를 생성시킨다
 * 
 * @author 김원섭
 * @see ComboBoxTag
 * @since J2EE 1.4
 */
public class ComboBoxMonthTag extends ComboBoxTag {

	String monthType = "";
	
	/**
	 * @param monthType the monthType to set
	 */
	public void setMonthType(String monthType) {
		this.monthType = monthType;
	}

	/**
	 * List에 보여질 데이터를 조회하는 추상화 함수
	 * 
	 * @return String[][]
	 */
	public String[][] getOptionList() {
		String[][] datas = new String[12][2];
		for (int i = 1; i < 13; i++) {
			datas[i-1][0] = (i < 10 ? "0" : "") + i;
			datas[i-1][1] = (i < 10 ? "0" : "") + i;
		}
		if(monthType.equals("ENG")) {
			datas[0][1] = "JAN";
			datas[1][1] = "FEB";
			datas[2][1] = "MAR";
			datas[3][1] = "APR";
			datas[4][1] = "MAY";
			datas[5][1] = "JUN";
			datas[6][1] = "JUL";
			datas[7][1] = "AUG";
			datas[8][1] = "SEP";
			datas[9][1] = "OCT";
			datas[10][1] = "NOV";
			datas[11][1] = "DEC";
		}
		else if(monthType.equals("ENGF")) {
			datas[0][1] = "January";
			datas[1][1] = "February";
			datas[2][1] = "March";
			datas[3][1] = "April";
			datas[4][1] = "May";
			datas[5][1] = "June";
			datas[6][1] = "July";
			datas[7][1] = "August";
			datas[8][1] = "September";
			datas[9][1] = "October";
			datas[10][1] = "November";
			datas[11][1] = "December";
		}

		return datas;
	}

	/**
	 * MultiCombo로 보여질지 SelectBox로 보여질지 선택하는 추상화 함수
	 * 
	 * @return int
	 */
	public int getType() {
		return super.getType(ComboBoxTag.SELECT);
	}

	/**
	 * 초기값을 조회하는 추상화 함수
	 * 
	 * @return String
	 */
	protected String getDefault() {
		Calendar c = Calendar.getInstance();
		int t = c.get(Calendar.MONTH) + 1;
		return (t < 10 ? "0" : "") + t;
	}

	/**
	 * 추상화 함수
	 * 
	 * @return int
	 */
	protected int getDefaultWidth() {
		return 90;
	}

	/**
	 * 추상화 함수
	 * 
	 * @return int
	 */
	protected int getCols() {
		return 2;
	}

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected String getAlign() {
		return "";
	}

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected String getTitle() {
		return "|";
	}

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected String getColWidth() {
		return "|";
	}

	/**
	 * 추상화 함수
	 * 
	 * @return int
	 */
	protected int getShowCol(){
		return 0;
	}
}
