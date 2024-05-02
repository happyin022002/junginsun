/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : US204EDISetupBC.java
*@FileTitle : US 204 EDI Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-22
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2012-04-22 조인영
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jun Ho
 * @see EsdTrs0082EventResponse 참조
 * @since J2EE 1.4
 */
public interface US204EDISetupBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * US204EDI SetUp 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchUS204EDISetupList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * US204EDI SetUp 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchUS204EDISetupVndr(Event e) throws EventException;
	

	/**
	 * 멀티 이벤트 처리<br>
	 * US204EDI SetUp 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse multiUS204EDISetup(Event e) throws EventException;

}