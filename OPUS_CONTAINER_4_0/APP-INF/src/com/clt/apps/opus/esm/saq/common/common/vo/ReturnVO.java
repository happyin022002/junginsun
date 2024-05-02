/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0076ConditionVO.java
*@FileTitle      : EsmSaq0076ConditionVO
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.common.common.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 성미영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ReturnVO extends AbstractValueObject{
	
	private static final long serialVersionUID = 1L;
	
	private QuotaConditionVO conditionVO = null;
	private ModelConditionVO modelConditionVO = null;
	
	private List<DBRowSet> rsList = null;
	private DBRowSet dbRowset = null;
	//private Object returnObj1 = null;
	private List<Object> voLists = new ArrayList<Object>()	;
	private List<AbstractValueObject> valueObjectVOs = new ArrayList<AbstractValueObject>()	;
	private String resultYN = null;
	
	public void addList(Object list) {
		this.voLists.add(list);
	}

	public Object getList(int index) {
		return this.voLists.get(index) ;
	}		
	
	public Object getList() {
		return this.voLists ;
	}	
	
	public int getListSize() { 
		return this.voLists.size() ;
	}	


	public void add(AbstractValueObject obj) {
		this.valueObjectVOs.add(obj) ;
	}

	public AbstractValueObject get(int index) {
		return this.valueObjectVOs.get(index) ;
	}	
	
	
	public List<AbstractValueObject> getValueObjectVOs() {
		return valueObjectVOs;
	}

	public void setValueObjectVOs(List<AbstractValueObject> valueObjectVOs) {
		this.valueObjectVOs = valueObjectVOs;
	}


	public ModelConditionVO getModelConditionVO() {
		return modelConditionVO;
	}

	public void setModelConditionVO(ModelConditionVO modelConditionVO) {
		this.modelConditionVO = modelConditionVO;
	}

	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public ReturnVO() {}

	public QuotaConditionVO getConditionVO() {
		return conditionVO;
	}





	public void setConditionVO(QuotaConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}


	public DBRowSet getDbRowset(){
		return dbRowset;
	}
	
	public void setDbRowset(DBRowSet dbRowset){
		this.dbRowset = dbRowset;
	}
	
	public List<DBRowSet> getRsList(){
		return rsList;
	}
	
	public void setRsList(List<DBRowSet> rsList){
		this.rsList = rsList;
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
	
	public String getResultYN() {
		return resultYN;
	}

	public void setResultYN(String resultYN) {
		this.resultYN = resultYN;
	}		
}