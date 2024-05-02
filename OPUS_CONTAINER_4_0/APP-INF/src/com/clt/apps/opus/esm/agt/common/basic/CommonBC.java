/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonBC.java
*@FileTitle : AGT CommonBC
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : junghyung kim
*@LastVersion : 1.0
* 2006-08-25 junghyung kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.common.basic;

import java.util.HashMap;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;

/**
 * OPUS-AGT Business Logic Command Interface<br>
 * - OPUS-AGT에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author junghyung kim
 * @see CommonBCImpl 참조
 * @since J2EE 1.4
 */
public interface CommonBC {
	
	/**
	 * (단건)Vendor 코드를 리턴한다.
	 * 
	 * @param String seq
	 * @return HashMap<String, String>
	 * @throws EventException
	 */
    public HashMap<String, String> searchVendorCode(String seq) throws EventException;
		
    /**
	 * (배열)Vendor 코드를 리턴한다.
	 * 
	 * @param String[] seq
	 * @return HashMap<String, Object>
	 * @throws EventException
	 */
    public HashMap<String, Object> searchVendorCode(String[] seq) throws EventException;
    
    /**
     * Customer/Vendor의 Code/Name을 리턴한다.<br>
     *
     * @param  String codeGubun
     * @param  String codeType
     * @param  String param
     * @return String 
     * @throws EventException
     */
    public String searchCode(String codeGubun, String codeType, String param) throws EventException;
	
    /**
     * Customer/Vendor 배열의 Code/Name을 배열로 리턴한다.<br>
     *
     * @param  String codeGubun
     * @param  String codeType
     * @param  String[] param
     * @return String[] 
     * @throws EventException
     */
    public String[] searchCodeList(String codeGubun, String codeType, String[] param) throws EventException;
	
    /**
     * 사용자가 입력한 Customer의 Name을 가져온다.<br>
     * 
     * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
    public HashMap<String, String> searchCustomerName( Event e ) throws EventException;
    
    /**
     * 사용자가 입력한 Customer의 Name을 가져온다.<br>
     * 
     * @param  HashMap<String, String> logMap
	 * @throws EventException
	 */
    public void processAgtErrLog(HashMap<String, String> logMap) throws EventException;
    
    /**
	 * (단건)Office 코드(Name)를 리턴한다.
	 * 
	 * @param String ofc_cd
	 * @return HashMap<String, String>
	 * @throws EventException
	 */
    public HashMap<String, String> searchOfficeCode(String ofc_cd) throws EventException;
}