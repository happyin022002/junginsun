/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpecialSOCheckBC.java
*@FileTitle : Special S/O Check - Supplement & Other
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-07
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2007-12-07 Jun Ho Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-SpecialSOCheck Business Logic Command Interface<br>
 * - ENIS-SpecialSOCheck에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jun Ho Kim
 * @see EsdEas0003EventResponse 참조
 * @since J2EE 1.4
 */
public interface SpecialSOCheckBC {

	/**
	 * Special SO Search List
	 * @param e EsdEas0003Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchSpecialSOCheckList(Event e) throws EventException;
	
	/**
	 * Other SO Search List
	 * @param e EsdEas0003Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchOtherSOCheckList(Event e) throws EventException;
}