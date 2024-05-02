/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ComboBoxTradeTag.java
 *@FileTitle : Common
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-11
 *@LastModifier : 김원섭
 *@LastVersion : 1.0
 * 2006-10-11 김원섭
 * 1.0 최초 생성
 * 2011.07.12 Kim jong jun :[CHM-201111824] 소스 품질검토 결과 적용 .
 =========================================================*/
package com.hanjin.apps.alps.esm.spc.common.taglib;

import com.hanjin.apps.alps.esm.spc.common.CommonSC;
import com.hanjin.apps.alps.esm.spc.common.common.event.ComboxEventResponse;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * 조회조건 ComboBox를 생성시킨다
 * 
 * @author 김원섭
 * @see ComboBoxTag
 * @since J2EE 1.4
 */
public class ComboBoxCommonCodeTag extends ComboBoxTag {
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ComboBoxCommonCodeTag.class);
	String width = "";
	String code = "";
	
	/**
	 * @param width The width to set.
	 */
	public void setWidth(String width) {
		this.width = width;
	}
	

	/**
	 * @param code The code to set.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * List에 보여질 데이터를 조회하는 추상화 함수
	 * 
	 * @return String[][]
	 */
	protected String[][] getOptionList() throws EventException {
		CommonSC sc = new CommonSC();
		ComboxEventResponse response;
		String[][] datas = new String[0][0];
		try {
			response = (ComboxEventResponse) sc.searchCommonCodeList(code, getDel());
			DBRowSet rs = response.getRs();
			datas = new String[rs.getRowCount()][2];
			int idx = 0;
			while (rs.next()) {
				datas[idx][0] = rs.getString("code");
				datas[idx][1] = ((getType()==ComboBoxTag.MULTICOMBO)?rs.getString("code")+"|":"")+rs.getString("text");
				idx++;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
		return datas;
	}

	/**
	 * MultiCombo로 보여질지 SelectBox로 보여질지 선택하는 추상화 함수
	 * 
	 * @return int
	 */
	protected int getType() {
		return super.getType(ComboBoxTag.SELECT);
	}

	/**
	 * 초기값을 조회하는 추상화 함수
	 * 
	 * @return String
	 */
	protected String getDefault() {
		return getDef();
	}

	/**
	 * 추상화 함수
	 * 
	 * @return int
	 */
	protected int getDefaultWidth() {
		return 100;
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
		return "left|left";
	}

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected String getTitle() {
		return "Code|Desc";
	}

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected String getColWidth() {
		return "50|150";
	}

	/**
	 * 추상화 함수
	 * 
	 * @return int
	 */
	protected int getShowCol(){
		int col = 0;
		if(getType() == ComboBoxTag.MULTICOMBO) {
			col = 1; 
		}
		return col;
	}
}
