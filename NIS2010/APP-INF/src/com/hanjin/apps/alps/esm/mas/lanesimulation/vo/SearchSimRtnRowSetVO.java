/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSimConditionVO.java
*@FileTitle : SearchSimConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.08  
* 1.0 Creation
* 2010.02.18 윤진영 미사용 변수 삭제
=========================================================*/

package com.hanjin.apps.alps.esm.mas.lanesimulation.vo;

import java.util.HashMap;


import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimRtnRowSetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	/* DB RowSet 객체  */
	private DBRowSet rowSet = null;
	private DBRowSet[] rowSets = null;

	/* RowSet 단건처리*/
	public DBRowSet getRowSet() {
		return rowSet;
	}

	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
	
	/* RowSet 다건처리*/
	public DBRowSet[] getRowSets() {
		return rowSets;
	}
	
	public void setRowSet(DBRowSet[] rowSets) {
		this.rowSets = rowSets;
	}

	public SearchSimRtnRowSetVO() {}

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


	
}
