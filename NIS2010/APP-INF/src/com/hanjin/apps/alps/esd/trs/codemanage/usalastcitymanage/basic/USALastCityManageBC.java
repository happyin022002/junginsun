/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USALastCityManageBC.java
*@FileTitle : USA Last City for T&E Cargo
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-22
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-09-22 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usalastcitymanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author juhyun
 * @see EsdTrs0076EventResponse 참조  
 * @since J2EE 1.4
 */
public interface USALastCityManageBC  {

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_076 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiUSALastCityManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * UsaLastCityManagement화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUSALastCityManageList(Event e) throws EventException;
	
	/**
	 * SEARCH01 이벤트 처리<br>
	 * ESD_TRS_076 화면에 대한 SEARCH01 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_077Event
	 * @return EventResponse ESD_TRS_077EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchLocalCodeManage(Event e) throws EventException;
	

		

}