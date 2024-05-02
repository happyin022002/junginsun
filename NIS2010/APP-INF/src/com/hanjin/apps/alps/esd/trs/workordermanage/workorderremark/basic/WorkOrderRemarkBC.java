/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderRemarkBC.java
*@FileTitle : Office별로 Cost/Trans Mode 및 IN/OUT Bound 별 W/O에 공통 적용할 비고 사항을 관리하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-08
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-11-08 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderremark.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-WorkOrderManage Business Logic Command Interface<br>
 * - ESD-WorkOrderManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author poong_yeon
 * @see EsdTrs0078EventResponse 참조
 * @since J2EE 1.4
 */
public interface WorkOrderRemarkBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderRemark화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 * @author choice
	 * @deprecated
	 */
	public EventResponse searchWorkOrderRemark(Event e) throws EventException;

	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TRS_078 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse addWorkOrderRemark(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_078 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyWorkOrderRemark(Event e) throws EventException;

	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_078 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse removeWorkOrderRemark(Event e) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_078 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse multiWorkOrderRemark(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderRemark화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return response ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderRemarkList(Event e) throws EventException;

}