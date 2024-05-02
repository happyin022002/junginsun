/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesOffiRepoRtnVO.java
*@FileTitle : SalesOffiRepoRtnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.09.29 김기식 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo;

import java.util.HashMap;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SalesOffiRepoRtnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
		
	/* Column Info */
	private String fPreWeek = null;

	/* DB RowSet 객체  */
	private DBRowSet rowSet = null;	
	
	/* DB RowSet 객체  */
	private DBRowSet[] rowSets = null;	
	
	/* Column Info */
	private SalesOffiRepoConditionVO conVo = null;
		
	public SalesOffiRepoRtnVO() {}

	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		return null;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		return null;
	}
	
		
	/**
	 * Column Info
	 * @return fPreWeek
	 */
	public String getFPreWeek() {
		return this.fPreWeek;
	}
	
	/** DBRowSet Getter */
	public DBRowSet getRowSet() {
		return rowSet;
	}
	
	/** DBRowSets Getter */
	public DBRowSet[] getRowSets() {
		return rowSets;
	}
	
	
	/**
	 * Column Info
	 * @return SalesOffiRepoConditionVO
	 */
	public SalesOffiRepoConditionVO getSalesOffiRepoConditionVO() {
		return this.conVo;
	}

	/**
	 * Column Info
	 * @param fPreWeek
	 */
	public void setFPreWeek(String fPreWeek) {
		this.fPreWeek = fPreWeek;
	}
	
	/** DBRowSet Setter */
	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
	
	/** DBRowSets Setter */
	public void setRowSets(DBRowSet[] rowSets) {
		this.rowSets = rowSets;
	}
	
	/**
	 * Column Info
	 * @param SalesOffiRepoConditionVO
	 */
	public void setSalesOffiRepoConditionVO(SalesOffiRepoConditionVO conVo) {
		this.conVo = conVo;
	}
	
}
