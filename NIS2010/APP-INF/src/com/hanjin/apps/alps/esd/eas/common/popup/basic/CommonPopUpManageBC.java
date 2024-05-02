/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonPopUpManageBC.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-27
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.common.popup.basic;

import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * ESD-EAS Business Logic Command Interface<br>
 * - ESD-EAS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yujin
 * @see EsdEasCom0001EventResponse 참조
 * @since J2EE 1.4
 */
public interface CommonPopUpManageBC
{

	/**
	 * 조회 이벤트 처리<br>
	 * Common Office화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_EAS_COM_0001Event
	 * @return EventResponse ESD_EAS_COM_001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchServiceOfficeCodeManage(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Common Office화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_EAS_COM_0002Event
	 * @return EventResponse ESD_EAS_COM_001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchServiceOfficeCodeManage2(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Office Hierarchy 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTroSubOfc(Event e) throws EventException;
}