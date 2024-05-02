/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ContainerSelectPopupBC.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-31 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.containerselectpopup.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim_sang_geun
 * @see EsdTrs0908EventResponse 참조
 * @since J2EE 1.4
 */
public interface ContainerSelectPopupBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectPopup(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectMainList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectSubList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectReplaceTPSZList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup의 split bkg, current bkg list를 불러온다.<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSplitBkgList(Event e) throws EventException;
}