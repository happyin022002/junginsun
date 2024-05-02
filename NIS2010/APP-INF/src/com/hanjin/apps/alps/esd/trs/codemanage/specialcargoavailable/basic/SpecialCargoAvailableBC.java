/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpecialCargoAvailableBC.java
*@FileTitle : Special Cargo Available S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-30
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014-12-30 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SHIN DONG IL
 * @see EsdTrs0088EventResponse 참조
 * @since J2EE 1.4
 */
public interface SpecialCargoAvailableBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * Special Cargo Available S/P 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchSpecialCargoAvailableList(Event e) throws EventException;
	

	/**
	 * 멀티 이벤트 처리<br>
	 * Special Cargo Available S/P 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiSpecialCargoAvailable(Event e) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Special Cargo Available S/P 화면에 대한 Row Delete 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse removeSpecialCargoAvailable(Event e) throws EventException;
	
	/**
	 * Special Cargo Available S/P 화면에 Vendor 체크로직<br>
	 * 
	 * @param e Event
	 * @return String
	 * @exception EventException
	 */
	public String searchVendorCheck(Event e) throws EventException;
	
	/**
	 * Special Cargo Available S/P 화면에 S/O Cre office 체크로직<br>
	 * 
	 * @param e Event
	 * @return String
	 * @exception EventException
	 */
	public String searchSoCreOfc(Event e) throws EventException;

}