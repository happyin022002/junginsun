/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WebGateBC.java
*@FileTitle : WebGate
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-10
*@LastModifier : cho_gilhong@naver.com
*@LastVersion : 1.0
* 2007-07-10 cho_gilhong@naver.com
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.newwebgate.basic;
 
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * SPP-SCE Business Logic Command Interface<br>
 * - SPP-SCE에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author cho_gilhong
 * @see SPP_SCE_001EventResponse 참조
 * @since J2EE 1.4
 */
public interface WebGateBC {
    /**
     * movement insert
     * 
     * @param e Event
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse createMovement(Event e) throws EventException;
    
    
    /**
     * movement select
     * 
     * @param e Event
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse selectCntrMvmt(Event e) throws EventException;
}