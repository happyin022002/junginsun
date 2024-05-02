/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonVO.java
*@FileTitle : CommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.21  정은호
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.common.eqrcommon.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;


/**
 * 각 Manage SC 에서 호출되는 Common 값 들의 Value Object
 * 반환값 타입별정의
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommonVO  extends AbstractValueObject{
	
	private static final long serialVersionUID = 1L;
	
	private Object ConditionVo 	= null;
	private Object ResultVo		= null;
	/*
	 * 반환값 타입별정의
	 */
	
	private DBRowSet dbRowset = null;	
	@SuppressWarnings("unchecked")
	private List list = null;
	/*
	 * String 변수로 셋팅하면 StringBuffer 변수에 담기는것을 기본으로 하여 String 개체는 사용하지 않고 StringBuffer 개체만을 사용한다.
	 */
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