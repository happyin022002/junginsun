/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpotBidPerformanceReportBC.java
*@FileTitle : Spot Bid Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 2016.02.03 
* 1.0 최초 생성
* --------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidperformancereport.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see EsdTrs0092EventResponse 참조
 * @since J2EE 1.4
 */
public interface SpotBidPerformanceReportBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * SpotBidPerformanceReport 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @param soffice_cd
	 * @return
	 * @throws EventException
	 */
	public EventResponse srchSpotBidPerfRpt(Event e, String soffice_cd) throws EventException;

}