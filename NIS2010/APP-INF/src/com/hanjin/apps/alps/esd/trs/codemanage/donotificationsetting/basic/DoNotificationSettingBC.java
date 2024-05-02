/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DoNotificationSettingBC.java
*@FileTitle : D/O notification Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-30
*@LastModifier : geun hwan park
*@LastVersion : 1.0
* 2016-05-30 geun hwan park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SHIN DONG IL
 * @see EsdTrs0290EventResponse 참조
 * @since J2EE 1.4
 */
public interface DoNotificationSettingBC  {
	
	/**
	 * 조회 이벤트 처리<br>
	  * D/O Notificatio Setting 화면을 조회하는 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDoNotificationSetting(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	  * D/O Notification Setting 화면을 조회하는 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDoScNo(Event e) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * D/O Notification Setting 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @param account
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiDoScNo(Event e,SignOnUserAccount account) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * D/O Notification Setting 화면에 대한 Row Delete 이벤트 처리<br>
	 * 
	 * @param e
	 * @param account
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse removeDoNotificationSetting(Event e,SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Grid Door Yard 변경시 Yard name 조회<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDorYdNm(Event e) throws EventException;
	
}