/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CLMInquiryBC.java
*@FileTitle : ServiceProvicerVisibility Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-02
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * SPP-SCE Business Logic Command Interface<br>
 * - SPP-SCE에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yeon-jin park
 * @see SppSce0003EventResponse 참조
 * @since J2EE 1.4
 */
public interface ClmInquiryBC {
    /**
     * movement select
     * 
     * @param e Event
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse getCntrClmInquiry(Event e) throws EventException;

}
