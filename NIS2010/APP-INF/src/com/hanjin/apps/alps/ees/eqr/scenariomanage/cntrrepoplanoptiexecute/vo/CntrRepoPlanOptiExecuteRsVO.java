/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanOptiExecuteRsVO.java
*@FileTitle : CntrRepoPlanOptiExecuteRsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo;
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

public class CntrRepoPlanOptiExecuteRsVO extends AbstractValueObject {
	
	private static final long serialVersionUID = 1L;
	
	
	private DBRowSet dbRowset = null;
	
	private Object ConditionVo = null;

	public CntrRepoPlanOptiExecuteRsVO() {}

	
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