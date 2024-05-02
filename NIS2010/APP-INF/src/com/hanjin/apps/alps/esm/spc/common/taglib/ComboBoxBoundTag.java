/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ComboBoxBoundTag.java
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


/**
 * 조회조건 ComboBox를 생성시킨다
 * 
 * @author 김원섭
 * @see ComboBoxTag
 * @since J2EE 1.4
 */
public class ComboBoxBoundTag extends ComboBoxTag {
	private String sn = "Y";

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param style
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}

	/**
	 * List에 보여질 데이터를 조회하는 추상화 함수
	 * 
	 * @return String[][]
	 */
	public String[][] getOptionList() {
		if (sn.equals("Y")) {
			return new String[][] { { "E", "E" }, { "W", "W" }, { "S", "S" }, { "N", "N" } };
		} else {
			return new String[][] { { "E", "E" }, { "W", "W" } };
		}
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
		return "";
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
