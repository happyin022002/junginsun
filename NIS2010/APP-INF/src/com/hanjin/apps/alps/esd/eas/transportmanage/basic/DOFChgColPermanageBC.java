/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DOFChgColPermanageBC
*@FileTitle : Drop Off Charge Collection Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * DOFChgColPermanageBC PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface DOFChgColPermanageBC {

	
	/**
	 * Settlement Request 대상 검색(조회) 이벤트 처리<br>
	 * @param e Event
	 * @return response ESD_EAS_009EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDofChgColPerList(Event e) throws EventException;
	
}
