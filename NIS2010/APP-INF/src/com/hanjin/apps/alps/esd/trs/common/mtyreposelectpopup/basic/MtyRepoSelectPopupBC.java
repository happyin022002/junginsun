/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MtyContainerSelectPopupBC.java
*@FileTitle : Empty Repo Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-25
*@LastModifier : eunju son
*@LastVersion : 1.0
* 2009-03-25 eunju son
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.mtyreposelectpopup.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim_sang_geun
 * @see EsdTrs0909EventResponse 참조
 * @since J2EE 1.4
 */
public interface MtyRepoSelectPopupBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * MtyRepoSelectPopup화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_909Event
	 * @return EventResponse ESD_TRS_909EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMtyRepoSelectPopup(Event e) throws EventException;
	
	
}