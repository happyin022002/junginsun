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

//import java.lang.reflect.Method;

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
public class ComboBoxCodeTag extends ComboBoxTag {
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ComboBoxCodeTag.class);
	String title = "";
	String align = "";
	String colWidth = "";
	String showCol = "";
	String displayColumns = "";
	String codeColumn = "";
	String code = "";
	
	/**
	 * @param align The align to set.
	 */
	public void setAlign(String align) {
		this.align = align;
	}

	/**
	 * @param codeColumn The codeColumn to set.
	 */
	public void setCodeColumn(String codeColumn) {
		this.codeColumn = codeColumn;
	}

	/**
	 * @param colWidth The colWidth to set.
	 */
	public void setColWidth(String colWidth) {
		this.colWidth = colWidth;
	}

	/**
	 * @param displayColumns The displayColumns to set.
	 */
	public void setDisplayColumns(String displayColumns) {
		this.displayColumns = displayColumns;
	}

	/**
	 * @param showCol The showCol to set.
	 */
	public void setShowCol(String showCol) {
		this.showCol = showCol;
	}

	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
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
			response = (ComboxEventResponse) sc.searchCodeList(code, getDel());
			DBRowSet rs = response.getRs();
			datas = new String[rs.getRowCount()][2];
			int idx = 0;
			String[] columns = displayColumns.replace('|', ':').split(":");
			while (rs.next()) {
				datas[idx][0] = rs.getString(codeColumn);
				datas[idx][1] = "";
				for(int i = 0 ; i < columns.length ; i++){
					datas[idx][1] = datas[idx][1] + "|" + rs.getString(columns[i]);
//log.debug("\n"+datas[idx][1] + "|" + rs.getString(columns[i]));
				}
				datas[idx][1] = datas[idx][1].substring(1);
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
		return displayColumns.split("|").length;
	}

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected String getAlign() {
		return align;
	}

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected String getTitle() {
		return title;
	}

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected String getColWidth() {
		return colWidth;
	}

	/**
	 * 추상화 함수
	 * 
	 * @return int
	 */
	protected int getShowCol(){
		int val = 0;
		if(showCol != null && !showCol.equals("") && showCol.matches("[0-9]*")) {
			val = Integer.parseInt(showCol);
		}
		return val;
	}
}
