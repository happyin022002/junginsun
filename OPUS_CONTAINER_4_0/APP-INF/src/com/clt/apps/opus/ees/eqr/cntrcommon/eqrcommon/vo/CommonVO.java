/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonVO.java
*@FileTitle : CommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;


/**
 * Common Value Object
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommonVO  extends AbstractValueObject{
	
	private static final long serialVersionUID = 1L;
	
	private Object ConditionVo 	= null;
	private Object ResultVo		= null;

	private DBRowSet dbRowset = null;	
	@SuppressWarnings("unchecked")
	private List list = null;

	//private String resultString = "";
	private StringBuffer resultSB = new StringBuffer();
	private String[] resultStrArray = null;
	private boolean resultBoolean = false;
	
	private String field1;
	private String field2;
	private String gubun;
	
	

	public CommonVO() {}

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


	/**
	 * @return the conditionVo
	 */
	public Object getConditionVo() {
		return ConditionVo;
	}

	/**
	 * @param conditionVo the conditionVo to set
	 */
	public void setConditionVo(Object conditionVo) {
		ConditionVo = conditionVo;
	}
	
	public Object getResultVo() {
		return ResultVo;
	}

	public void setResultVo(Object resultVo) {
		ResultVo = resultVo;
	}

	/**
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	@SuppressWarnings("unchecked")
	public void setList(List list) {
		this.list = list;
	}
	
	
	public String getResultString() {
		return resultSB.toString();
	}

	public void setResultString(String resultString) {
		this.resultSB = new StringBuffer();
		this.resultSB.append(resultString);
		//this.resultString = resultString;
	}
	

	public StringBuffer getResultSB() {
		return resultSB;
	}

	public void setResultSB(StringBuffer resultSB) {
		this.resultSB = resultSB;
	}

	public boolean isResultBoolean() {
		return resultBoolean;
	}

	public void setResultBoolean(boolean resultBoolean) {
		this.resultBoolean = resultBoolean;
	}
	

	public String[] getResultStrArray() {
		return resultStrArray;
	}

	public void setResultStrArray(String[] resultStrArray) {
		this.resultStrArray = resultStrArray;
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}
	/**
	 * @return the gubun
	 */
	public String getGubun() {
		return gubun;
	}
	/**
	 * @param gubun the gubun to set
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
}