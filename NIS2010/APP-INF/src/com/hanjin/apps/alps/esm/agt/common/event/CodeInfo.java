/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeInfo.java
*@FileTitle : 공통코드 관리 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-20
*@LastModifier : junghyung kim
*@LastVersion : 1.0
* 2006-11-20 junghyung kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.common.event;

import java.lang.reflect.Field;
//import com.hanjin.apps.enis.esm.agt.common.basic.CommonBC;
//import com.hanjin.framework.core.layer.event.EventException;
//import com.hanjin.framework.core.layer.integration.DAOException;
//import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.esd.lea.common.CodeComboUtil;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ENIS-Agent Commission에 대한 공통코드 처리를 담당<br>
 * - ENIS-Agent Commission에 대한 공통코드 비지니스 로직을 처리한다.<br>
 * 
 * @author junghyung kim
 * @see CodeUtil 참조
 * @since J2EE 1.4
 */
public class CodeInfo extends EventSupport implements java.io.Serializable, Comparable {
	
	// log 객체
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(CodeComboUtil.class);

	/**
	 * code 값
	 */
	private String code;

	/**
	 * sort key
	 */
	private String sortKey;

	/**
	 * code 명
	 */
	private String name;

	/**
	 * 1. 기능 : CodeInfo 생성자
	 * <p>
	 * 2. 처리개요 :
	 * <p> - CodeInfo 객체를 생성
	 * <p>
	 * 3. 주의사항 :
	 * <p>
	 * 
	 */
	public CodeInfo() {
	}

	/**
	 * 1. 기능 : CodeInfo 생성자<p>
	 * 2. 처리개요 :<p>
	 *  - code값, code명을 받아 모델 setting<p>
	 * 3. 주의사항 :<p>
	 *
	 * @param sortKey
	 * @param code code 값
	 * @param name code 명
	 */
	public CodeInfo(String sortKey, String code, String name) {
		this.code = code;
		this.name = name;
		this.sortKey = sortKey;
	}

	/**
	 * 1. 기능 : CodeInfo 생성자 <p>
	 * 2. 처리개요 :<p>
	 *  - code값, code명을 받아 모델 setting<p>
	 * 3. 주의사항 : <p>
	 * 
	 * @param code code 값
	 * @param name code 명
	 */
	public CodeInfo(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/**
	 * 1. 기능 : code 값 return
	 * <p>
	 * 2. 처리개요 :
	 * <p>
	 * 3. 주의사항 :
	 * <p>
	 * 
	 * @return String code 값
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * 1. 기능 : code 명 return<p>
	 * 2. 처리개요 : getter method <p>
	 * 3. 주의사항 : <p>
	 * 
	 * @return String code 명
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * key 값을 반환한다.
	 * @return
	 */
	public String getSortKey() {
		return sortKey;
	}

	/**
	 * key 값을 세팅한다.
	 * @param sortKey
	 */
	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	/**
	 * 1. 기능 : toString() 의 overriding 된 method
	 * 
	 * @return String model의 toString()
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "                              ";
		
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
		
				//try {
					arr = (String[]) field[i].get(this);
				//} catch (Exception e) {
				//	log.error(e.getMessage());
				//	arr = new String[1];
				//	arr[0] = String.valueOf(field[i].get(this));
				//}
				
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
//2011.07.07 이정수 R4J 로그메세지 추가			
			log.error(ex.getMessage());
			return null;
		}
		
		return ret.toString();
	}

	/**
	 * 메소드를 구현한다.
	 * 
	 * @param Object o
	 * @return int
	 */
	public int compareTo(Object o) {
		CodeInfo bean = (CodeInfo) o;
		//오름차순 정렬 
		return (this.sortKey.compareTo( bean.sortKey));
		
	}

	/**
	 * code를 세팅한다.
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * name을 세팅한다.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
