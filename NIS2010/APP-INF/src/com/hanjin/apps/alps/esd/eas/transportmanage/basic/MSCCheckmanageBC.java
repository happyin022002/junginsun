/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MSCCheckmanageBC.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * MSCCheckmanageBC ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface MSCCheckmanageBC {

	/**
	 * MSC Check Search List.
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMSCList(Event e) throws EventException;
	

	/**
	 * 유럽지역의 TRO Office를 찾아오는 메소드. 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSubOfcList(Event e) throws EventException;
}
