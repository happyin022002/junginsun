/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ComboBoxSubTradeTag.java
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
public class ComboBoxSubTradeTag extends ComboBoxTag {
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ComboBoxSubTradeTag.class);
	boolean isRepTrade = false;
	boolean isAll = false;
	
	/**
	 * @param isRepTrade The isRepTrade to set.
	 */
	public void setRepTrade(boolean isRepTrade) {
		this.isRepTrade = isRepTrade;
	}

	/**
	 * @param isRepTrade The isRepTrade to set.
	 */
	public void setAll(boolean isAll) {
		this.isAll = isAll;
	}

	/**
	 * List에 보여질 데이터를 조회하는 추상화 함수
	 * 
	 * @return String[][]
	 */
	public String[][] getOptionList() throws EventException {
		CommonSC sc = new CommonSC();
		ComboxEventResponse response;
		String[][] datas = null;
		try {
			response = (ComboxEventResponse) sc.searchSubTradeComboList(getDel(), isRepTrade, isAll);
			DBRowSet rs = response.getRs();
			datas = new String[rs.getRowCount()][2];
			int idx = 0;
			while (rs.next()) {
				datas[idx][0] = rs.getString("sub_trd_cd");
				datas[idx][1] = rs.getString("trd_cd") + "|" + rs.getString("sub_trd_cd") + "|"
						+ rs.getString("sub_trd_nm");
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
		return super.getType(ComboBoxTag.MULTICOMBO);
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
		return 50;
	}

	/**
	 * 추상화 함수
	 * 
	 * @return int
	 */
	protected int getCols() {
		return 3;
	}

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected String getAlign() {
		return "left|left|left";
	}

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected String getTitle() {
		return "Trade|SubTrade|Description";
	}

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected String getColWidth() {
		return "50|60|150";
	}

	/**
	 * 추상화 함수
	 * 
	 * @return int
	 */
	protected int getShowCol(){
		return 1;
	}
}
