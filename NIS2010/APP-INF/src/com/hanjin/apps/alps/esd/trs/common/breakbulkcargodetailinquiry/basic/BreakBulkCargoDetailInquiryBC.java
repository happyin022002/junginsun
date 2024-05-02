/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BreakBulkCargoDetailInquiryBC.java
*@FileTitle : BKG CGO SPE Detail Popup - BB
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-27
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-27 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.breakbulkcargodetailinquiry.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author juhyun
 * @see EsdTrs0937EventResponse 참조
 * @since J2EE 1.4
 */
public interface BreakBulkCargoDetailInquiryBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * BreakBulkCargoDetailInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchBreakBulkCargoDetailInquiry(Event e) throws EventException;


}