/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComboVO.java
*@FileTitle : ComboVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.16 김기대 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기대
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EsmCoa0036ComboVO extends AbstractValueObject {
	
	private static final long serialVersionUID = 1L;

	/* Condition Info */
	private String sRow = null;
	
	/* Condition Info */
	private String trade = null;
	
	/* DB List 객체  */
	List<EsmCoa0036ComboVO> list = null;	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();	

	public EsmCoa0036ComboVO() {}

	public EsmCoa0036ComboVO(
			String sRow
		  , String trade) {
		this.sRow = sRow;
		this.trade = trade;
	}
	
	
	/**
	 * Condition Info
	 * @param sRow
	 */
	public void setSRow(String sRow) {
		this.sRow = sRow;
	}		
		
	/**
	 * Condition Info
	 * @param sRow
	 */
	public String getSRow() {
		return sRow;
	}
	
	/**
	 * Condition Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}		
		
	/**
	 * Condition Info
	 * @param trade
	 */
	public String getTrade() {
		return trade;
	}
	
	/** DB List Getter */
	public List<EsmCoa0036ComboVO> getListSet() {
		return list;
	}

	/** DB List Setter */
	public void setListSet(List<EsmCoa0036ComboVO> list) {
		this.list = list;
	}		
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSRow(JSPUtil.getParameter(request, "sRow", ""));
		setTrade(JSPUtil.getParameter(request, "trade", ""));
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sRow"	, getSRow()		 );
		this.hashColumns.put("trade", getTrade()	 );
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		return null;
	}	
	
}
