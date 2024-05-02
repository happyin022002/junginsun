/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BangladeshOdcyReqBC.java
*@FileTitle : WebGate Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-06
*@LastModifier : tae-kyoung.kim
*@LastVersion : 1.0
* 2012-04-06 tae-kyoung.kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;


/**
 * Business Logic Command Interface<br>
 * 비지니스 로직에 대한 인터페이스<br>
 *
 * @author tae-kyoung.kim
 * @see SppBkg0001ventResponse 참조
 * @since J2EE 1.4
 */

public interface BangladeshOdcyReqBC {
    /**
     * 조회 이벤트 처리<br>
     * searchShippingInstruction 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e SppBkg0001Event
     * @return EventResponse SppBkg0001EventResponse
     * @exception EventException
     */
    public EventResponse verifyShipmentReq(Event e) throws EventException;
 
    /**
     * ShippingRequest 저장 <br>
     * manageShippingRequest 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e SppBkg0002Event
     * @return EventResponse SppBkg0002EventResponse
     * @exception EventException
     */
    public EventResponse manageShippingRequest(Event e) throws EventException;
    
    /**
     * 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchShippingRequest(Event e) throws EventException;
}
