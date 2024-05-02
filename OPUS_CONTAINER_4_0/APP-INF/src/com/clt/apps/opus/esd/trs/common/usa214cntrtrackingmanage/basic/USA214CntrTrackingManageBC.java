/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : Usa214CntrTrackingBC.java
*@FileTitle : USA 214 CONTAINER TRACKING 
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-18
*@LastModifier : Park Jun-Yong
*@LastVersion : 1.0
* 2008-07-18 Park Jun-Yong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.usa214cntrtrackingmanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;

/**
 * USA 214 CONTAINER TRACKING<br>
 * - TRS 테이블 갱신을 위해 SCEM에 제공하는 메소드<br>
 *
 * @author Park Jun-Yong
 * @see USA214CntrTrackingManageEvent 참조
 * @since J2EE 1.4
 */
public interface USA214CntrTrackingManageBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * USA214CntrTracking화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e USA214CntrTrackingManageEvent
	 * @return NULL
	 * @exception EventException
	 */
	public String usa214CntrTracking(Event e) throws EventException;


}