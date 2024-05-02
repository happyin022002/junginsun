/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SupplementSOManageBC.java
*@FileTitle : Service Order 생성-Supplement
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-30 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.supplementsomanage.supplementsomanage.basic;

import java.util.ArrayList;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author juhyun
 * @see EsdTrs0016EventResponse 참조
 * @since J2EE 1.4
 */
public interface SupplementSOManageBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_016Event
	 * @return EventResponse ESD_TRS_016EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSupplementSOTargetList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_016Event
	 * @return EventResponse ESD_TRS_016EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSupplementSOCorrectionList(Event e) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * SupplementSOManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_016Event
	 * @return EventResponse ESD_TRS_016EventResponse
	 * @exception EventException
	 */
	public ArrayList addSupplementSOList(Event e) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * SupplementSOManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param arrayList
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSOCreatedList(ArrayList arrayList) throws EventException;	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_016Event
	 * @return EventResponse ESD_TRS_016EventResponse
	 * @exception EventException
	 */
	public EventResponse removeSupplementSOCreatedList(Event e) throws EventException;	

}