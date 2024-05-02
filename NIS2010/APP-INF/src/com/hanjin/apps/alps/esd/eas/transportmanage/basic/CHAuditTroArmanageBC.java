/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CHAuditTroArmanageBC.java
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
 * CHAuditTroArmanageBC ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface CHAuditTroArmanageBC {

	/**
	 * C/H Audit List 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchChAuditList(Event e) throws EventException;
	
	/**
	 * BKG 단위의 C/H Audit Detail 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchChAuditBKGList(Event e) throws EventException;
	
	/**
	 * User가 선택한 Office의 모든 하위 Office를 선택하는 Function
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSubOfficeList(Event e) throws EventException;
}
