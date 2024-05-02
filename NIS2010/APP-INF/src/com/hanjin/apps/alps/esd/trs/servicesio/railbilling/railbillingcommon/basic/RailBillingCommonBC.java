/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingCommonBC.java
*@FileTitle : RailBilling Common 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0010EventResponse;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author leebh
 * @see ExpPap0010EventResponse 참조
 * @since J2EE 1.4
 */
public interface RailBillingCommonBC  {
    /**
     * 조회 이벤트 처리<br>
     * Potal Main Rail Bill Ack Count 조회  화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0019Event
     * @return EventResponse ExpPap0019EventResponse
     * @exception EventException
     */
    public EventResponse searchRailBillingAckCount(Event e) throws EventException;
}