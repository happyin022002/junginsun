/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingReqCreateBC.java
*@FileTitle : RailBilling Request Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.Usa404EDISendVO;
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
public interface RailBillingReqCreateBC  {
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Request 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0010Event
     * @return EventResponse ExpPap010EventResponse
     * @exception EventException
     */
    public EventResponse searchRailBillingReqCreateFull(Event e) throws EventException;
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Request(Excel) 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap020Event
     * @return EventResponse ExpPap0020EventResponse
     * @exception EventException
     */
    public EventResponse searchRailBillingReqCreateExcelFull(Event e) throws EventException;
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Verify Request 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0014Event
     * @return EventResponse ExpPap0014EventResponse
     * @exception EventException
     */
    public EventResponse verifyRailBillingReqCreateFull(Event e) throws EventException;
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Creation Request 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap015Event
     * @return EventResponse ExpPap015EventResponse
     * @exception EventException
     */
    public EventResponse insertRailBillingReqCreateFull(Event e) throws EventException;
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Empty Cntr Request 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0016Event
     * @return EventResponse ExpPap0016EventResponse
     * @exception EventException
     */
    public EventResponse searchRailBillingReqCreateEmpty(Event e) throws EventException;
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Empty Cntr Verify Request 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0017Event
     * @return EventResponse ExpPap0017EventResponse
     * @exception EventException
     */
    public EventResponse verifyRailBillingReqCreateEmpty(Event e) throws EventException;
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Empty Cntr Request Creation 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0017Event
     * @return EventResponse ExpPap0017EventResponse
     * @exception EventException
     */
    public EventResponse insertRailBillingReqCreateEmpty(Event e) throws EventException;
    /**
     * 이벤트 처리<br>
     * Rail Billing EDI 전송 요청 처리<br>
     * 
     * @param ediSendInfo Usa404EDISendVO
     * @throws EventException
     */
    public void multiUSA404EDISend(Usa404EDISendVO ediSendInfo) throws EventException;
}