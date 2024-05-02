/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CnlBKGCntrmanageBC.java
*@FileTitle : Cancelled BKG's Cntr Tracing
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 ���� ��
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * CnlBKGCntrmanageBC PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface CnlBKGCntrmanageBC  {
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchCnlBKGCntrList(Event e) throws EventException;
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	//public EventResponse searchCnlBKGCntrDtlList(Event e) throws EventException;
}
