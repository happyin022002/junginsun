/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RptSearchChargeSummaryReportBlInquiryRtnVO.java
*@FileTitle : RptSearchChargeSummaryReportBlInquiryRtnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.10
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.06.10 이혜민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.screport.screport.vo;

import java.util.HashMap;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RptSearchChargeSummaryReportBlInquiryRtnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
		
	/* DB RowSet 객체  */
	private DBRowSet rowSet = null;	
	
	/* DB RowSet 객체  */
	private DBRowSet[] rowSets = null;	
	
	/* Column Info */
	private RptSearchChargeSummaryReportBlInquiryVO rtnVo = null;
		
	public RptSearchChargeSummaryReportBlInquiryRtnVO() {}

	
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
	 * @return RptSearchChargeSummaryReportBlInquiryVO
	 */
	public RptSearchChargeSummaryReportBlInquiryVO getRptSearchChargeSummaryReportBlInquiryVO() {
		return this.rtnVo;
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
	 * @param RptSearchChargeSummaryReportBlInquiryVO
	 */
	public void setRptSearchChargeSummaryReportBlInquiryVO(RptSearchChargeSummaryReportBlInquiryVO rtnVo) {
		this.rtnVo = rtnVo;
	}
	
}
