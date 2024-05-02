/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeUtilBC.java
*@FileTitle : 코드 성격의 데이터를 가져오는 Util BC interface
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-07
*@LastModifier : Sang-mo Kim
*@LastVersion : 1.0
* 2006-10-02 Sang-mo Kim
* 1.0 최초 생성
=========================================================*/
 
package com.clt.apps.opus.esd.lea.common.codeutil.basic;

import com.clt.framework.core.layer.event.EventException;

/**
 * 코드 성격의 데이터를 가져오는 Util BC interface
 * 
 * @author Sang-mo Kim
 * @see CodeUtilBCImpl.java
 * @since J2EE 1.4
 */

public interface CodeUtilBC {

//	/**
//	 * 
//	 * @param selectName select tag 명
//	 * @param table 테이블명
//	 * @param valueField value 필드명
//	 * @param textField text 필드명
//	 * @param orderByField 정렬 필드명
//	 * @param options select 옵션
//	 * @param addOtion 추가 option
//	 * @throws EventException
//	 */
//	public String getCodeCombo(String selectName, String table, String valueField, 
//							   String textField, String orderByField, String options, String addOption)
//								throws EventException;
//	
//	/**
//	 * 
//	 * @param selectName select tag 명
//	 * @param table 테이블명
//	 * @param valueField value 필드명
//	 * @param textField text 필드명
//	 * @param orderByField order by 필드명
//	 * @throws EventException
//	 */
//	public String getCodeCombo(String selectName, String table, String valueField, 
//							   String textField, String orderByField)
//								throws EventException;
//	
//	
//	/**
//	 * 
//	 * @param selectName select tag 명
//	 * @param table 테이블명
//	 * @param valueField value 필드명
//	 * @param textField text 필드명
//	 * @param orderByField order by 필드명
//	 * @param options select 옵션
//	 * @throws EventException
//	 */
//	public String getCodeCombo(String selectName, String table, String valueField, 
//							   String textField, String orderByField, String options)
//								throws EventException;
//	
//	/**
//	 * 
//	 * @param selectName select tag 명
//	 * @param table 테이블명
//	 * @param valueField value 필드명
//	 * @param textField text 필드명
//	 * @throws EventException
//	 */
//	public String getCodeCombo(String selectName, String table, String valueField, 
//							   String textField)
//								throws EventException;
	
	/**
     * 
     * @param selectName select tag 명
     * @param table 테이블명
     * @param valueField value 필드명
     * @param textField text 필드명
     * @param orderByField 정렬 필드명
     * @param options select 옵션
     * @param addOtion 추가 option
     * @throws EventException
     */
    public String getCodeCombo(String selectName, String table, String valueField, 
                               String textField, String whereField, String orderByField, String options, String addOption)
                                throws EventException;
    
}
