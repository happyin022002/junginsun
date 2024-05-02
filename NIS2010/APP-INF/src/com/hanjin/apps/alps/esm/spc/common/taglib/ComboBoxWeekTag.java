/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ComboBoxWeekTag.java
 *@FileTitle : Common
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-11
 *@LastModifier : 김원섭
 *@LastVersion : 1.0
 * 2006-10-11 김원섭
 * 1.0 최초 생성
 * History-------------------------------------------------
 * 2010.12.28 이행지 [CHM-201008010-01] [SPC]주차 Tag Library 수정 : 마지막 주차에 1월의 날짜가 겹쳐 자바 Calendar에서 1주차로 인식되는 경우가 있어 예외처리.
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
public class ComboBoxWeekTag extends ComboBoxTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * List에 보여질 데이터를 조회하는 추상화 함수
	 * 
	 * @return String[][]
	 */
	public String[][] getOptionList() {
		String[][] datas = new String[54][2];
		for (int i = 0; i < 54; i++) {
			datas[i][0] = (i < 10 ? "0" : "") + i;
			datas[i][1] = (i < 10 ? "0" : "") + i;
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
		int t = c.get(Calendar.WEEK_OF_YEAR) - 1;
		
		/* 
		 * 2010.12.28  이행지 [CHM-201008010-01][SPC]주차 Tag Library 수정
		 * 마지막 주차에 1월의 날짜가 겹쳐 자바 Calendar에서 1주차로 인식되는 경우가 있어 예외처리.
		 */
		if ( c.getActualMaximum(Calendar.MONTH) == c.get(Calendar.MONTH)
			&& c.get(Calendar.WEEK_OF_YEAR) == 1){
			c.add(Calendar.WEEK_OF_YEAR, -1);
			t = c.get(Calendar.WEEK_OF_YEAR) ;
		}

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
