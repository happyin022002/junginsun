/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonCoaRsVO.java
*@FileTitle : CommonCoaRsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.10  
* 1.0 Creation
History
========================================================== 
* 2009.09.08 송호진 header, eventName Field 추가
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================*/

package com.clt.apps.opus.esm.coa.common.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommonCoaRsVO extends AbstractValueObject { 
	
	private static final long serialVersionUID = 1L;
	
	private List<DBRowSet> rsList = new ArrayList<DBRowSet>();
	
	private DBRowSet dbRowset = null;
	
	private Object conditionVO = null;
	
	private List resultVOList = null;
	
	private String	header = null;
	
	private String	eventName = null;
	
	private HashMap<String, String> hMap = null;
	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public CommonCoaRsVO() {}

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
	public List getResultVOList() {
		return resultVOList;
	}

	/**
	 * @param resultVOList the resultVOList to set
	 */
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
	
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public HashMap<String, String> getHMap() {
		return hMap;
	}

	public void setHMap(HashMap<String, String> map) {
		hMap = map;
	}
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap hashReqeust = null;
	
	/**
	 * hashReqeust
	 * @param HashMap hashReqeust
	 */
	public void setHashReqeust(HashMap hashReqeust) {
		this.hashReqeust = hashReqeust;
	}	
	/**
	 * hashReqeust
	 * @return HashMap hashReqeust
	 */
	public HashMap getHashReqeust() {
		return this.hashReqeust;
	}
	
    public String[] getHashAttribute(String key){
        return (String[])hashReqeust.get(key);
    }

	/**
	 * 화면에서 넘긴 request 객체의 데이터를 HashMap에 입력하여 HashMap객체를 리턴한다.
	 * 
	 * key   : 화면의 컨트롤객체 이름
	 * value : 화면의 컨트롤객체 값
	 * 
	 * @param request
	 * @return HashMap
	 */
	public void requestToHashMap(HttpServletRequest request){
		// requestToHashMap(HttpServletRequest request)
		HashMap hash = new HashMap();
		hashReqeust = new HashMap();
		Map map = request.getParameterMap();
		Iterator it = map.keySet().iterator();
		Object key = null;
		String[] value = null;
		StringBuffer sysOut = new StringBuffer();
		
		while(it.hasNext()){
			key = it.next();
			value = (String[])map.get(key);
			hashReqeust.put(key, value);
			sysOut.append("\n key[" +Utils.fillSpace((String)key, 15, " ", "right")+ "] : [");
			for(int i=0; i<value.length; i++){
				sysOut.append(value[i] );
				if(i != value.length-1)sysOut.append( " : ");
			}
			sysOut.append("]");
		}
	}
}
