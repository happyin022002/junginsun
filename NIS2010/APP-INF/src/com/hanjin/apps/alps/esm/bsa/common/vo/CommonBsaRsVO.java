/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonBSARsVO.java
*@FileTitle : CommonBSARsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.10  
* 1.0 Creation
* 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.common.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommonBsaRsVO extends AbstractValueObject {
	
	private static final long serialVersionUID = 1L;
	
	private List<DBRowSet> rsList = new ArrayList<DBRowSet>();
	
	private DBRowSet dbRowset = null;
	
	private Object conditionVO = null;
	
	@SuppressWarnings("unchecked")
	private List resultVOList = null;
	
	private CommonBsaRsVO[] m_voArray = null;
	
	private String strTemp = null;
	
	private String strTemp2 = null;
	
	private String strTemp3 = null;
	
	private String ErrorCode =null;
	
	private String ErrorMsg = null;
	
	public CommonBsaRsVO() {}

	/**
	* SearchSlotCostListVO[] 배열을 리턴
	*/
	public CommonBsaRsVO[] getCommonBsaRsVOArray(){
		return m_voArray;
	}	
	/**
	* SearchSlotCostListVO[] 배열을 셋팅
	*/
	public void setCommonBsaRsVOArray(CommonBsaRsVO[] voArray){
		m_voArray = voArray;
	}

	/**
	 * @return the dbRowset
	 */
	public DBRowSet getDbRowset() {
		return dbRowset;
	}

	/**
	 * @param dbRowset the dbRowset to set
	 */
	public void setDbRowset(DBRowSet dbRowset) {
		this.dbRowset = dbRowset;
	}

	/* (non-Javadoc)
	 * @see com.hanjin.framework.component.common.AbstractValueObject#getColumnValues()
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hanjin.framework.component.common.AbstractValueObject#getFieldNames()
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		return null;
	}

	/**
	 * @return the conditionVO
	 */
	public Object getConditionVO() {
		return conditionVO;
	}

	/**
	 * @param conditionVO the conditionVO to set
	 */
	public void setConditionVO(Object conditionVO) {
		this.conditionVO = conditionVO;
	}

	/**
	 * @return the resultVOList
	 */
	@SuppressWarnings("unchecked")
	public List getResultVOList() {
		return resultVOList;
	}

	/**
	 * @param resultVOList the resultVOList to set
	 */
	@SuppressWarnings("unchecked")
	public void setResultVOList(List resultVOList) {
		this.resultVOList = resultVOList;
	}

	/**
	 * @return the rsList
	 */
	public List<DBRowSet> getRsList() {
		return rsList;
	}

	/**
	 * @param rsList the rsList to set
	 */
	public void setRsList(List<DBRowSet> rsList) {
		this.rsList = rsList;
	}

	public String getStrTemp() {
		return strTemp;
	}

	public void setStrTemp(String strTemp) {
		this.strTemp = strTemp;
	}
		
	
	public String getStrTemp2() {
		return strTemp2;
	}

	public void setStrTemp2(String strTemp2) {
		this.strTemp2 = strTemp2;
	}

	public String getStrTemp3() {
		return strTemp3;
	}

	public void setStrTemp3(String strTemp3) {
		this.strTemp3 = strTemp3;
	}

	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}
	
}