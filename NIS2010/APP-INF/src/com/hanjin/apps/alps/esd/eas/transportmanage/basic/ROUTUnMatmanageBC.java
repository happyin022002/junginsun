/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ROUTUnMatmanageBC
*@FileTitle : Route Unmatch List
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
 * ROUTUnMatmanageBC PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface ROUTUnMatmanageBC {

	
	/**
	 * Route Unmatch List Main
	 * @param e EsdEas0002Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchRoutUnMatList(Event e) throws EventException;

	/**
	 * Settlement Request 대상 검색(조회) 이벤트 처리 Detail 조회
	 * @param e Event
	 * @return response ESD_EAS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRoutUnMatBlInforDetail(Event e) throws EventException;

	/**
	 * Settlement Request 대상 검색(조회) 이벤트 처리 Detail 조회 중 하부 조회
	 * @param e Event
	 * @return response ESD_EAS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRoutUnMatSoInforDetail(Event e) throws EventException;

//2011.07.13 이정수 R4J소스품질 위배 및 미사용으로 인해 주석처리함   		
	/**
	 * Expense Audit Remark 조회
	 * @param e Event
	 * @return response ESD_EAS_0902EventResponse
	 * @exception EventException
	 */
/*	public EventResponse searchExpnAudRmk(Event e) throws EventException;*/

//2011.07.13 이정수 R4J소스품질 위배 및 미사용으로 인해 주석처리함   	
	/**
	 * Expense Audit Remark 추가/수정
	 * @param e Event
	 * @return response ESD_EAS_0902EventResponse
	 * @exception EventException
	 */
/*	public EventResponse multiExpnAudRmk(Event e) throws EventException;*/
}
