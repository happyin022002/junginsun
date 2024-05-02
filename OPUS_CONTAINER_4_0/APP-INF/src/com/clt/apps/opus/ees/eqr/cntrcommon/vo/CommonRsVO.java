/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonRsVO.java
*@FileTitle : CommonRsVO
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcommon.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommonRsVO extends AbstractValueObject {
	
	private static final long serialVersionUID = 1L;
	
	private List<DBRowSet> rsList = new ArrayList<DBRowSet>();
	
	private DBRowSet dbRowset = null;
	
	private Object conditionVO = null;
	
	@SuppressWarnings("unchecked")
	private List resultVOList = null;
	
	private String[] resultStrArray = null;
	
	private String resultString = "";
	
	public CommonRsVO() {}

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
	 * @see com.clt.framework.component.common.AbstractValueObject#getColumnValues()
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.clt.framework.component.common.AbstractValueObject#getFieldNames()
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

	/**
	 * @return the resultStrArray
	 */
	public String[] getResultStrArray() {
		return resultStrArray;
	}

	/**
	 * @param resultStrArray the resultStrArray to set
	 */
	public void setResultStrArray(String[] resultStrArray) {
		this.resultStrArray = resultStrArray;
	}

	/**
	 * @return the resultString
	 */
	public String getResultString() {
		return resultString;
	}

	/**
	 * @param resultString the resultString to set
	 */
	public void setResultString(String resultString) {
		this.resultString = resultString;
	}
	
}