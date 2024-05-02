/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DoNotificationReportBC.java
*@FileTitle : D/O notification Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-03
*@LastModifier : 
*@LastVersion : 1.0
* 2016-06-03
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.basic;

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
public interface DoNotificationReportBC  {
	
	/**
	 * 조회 이벤트 처리<br>
	 * D/O Notification Report 화면을 조회하는 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDoNotificationReportList(Event e) throws EventException;
	
}