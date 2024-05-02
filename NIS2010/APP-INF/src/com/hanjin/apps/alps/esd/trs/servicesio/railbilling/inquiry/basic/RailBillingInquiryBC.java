/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingInquiryBC.java
*@FileTitle : RailBilling Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author leebh
 * @see ExpPap010EventResponse 참조
 * @since J2EE 1.4
 */
public interface RailBillingInquiryBC  {
    /**
     * 조회 이벤트 처리<br>
     * Rail Bill Order Inquiry 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0012Event
     * @return EventResponse ExpPap0012EventResponse
     * @exception EventException
     */
    public EventResponse searchRailBillingInquiry(Event e) throws EventException;
    /**
     * 조회 이벤트 처리<br>
     * Rail Bill Order Inquiry Excel 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0021Event
     * @return EventResponse ExpPap0021EventResponse
     * @exception EventException
     */
    public EventResponse searchRailBillingInquiryExcel(Event e) throws EventException;
}