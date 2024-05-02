/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WebGateBCImpl.java
*@FileTitle : WebGate
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-10
*@LastModifier : cho_gilhong@naver.com
*@LastVersion : 1.0
* 2007-07-10 cho_gilhong@naver.com
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.newwebgate.basic;
 
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.CntrMvmt;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0001Event;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0001EventResponse;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0002Event;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0002EventResponse;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.integration.WebGateDBDAO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * SPP_SCE Business Logic Basic Command implementation<br>
 * - SPP_SCE에 대한 비지니스 로직을 처리한다.<br> 
 * @author cho_gilhong
 * @see WebGateDBDAO 클래스 참조
 * @since J2EE 1.4
 */
public class WebGateBCImpl extends BasicCommandSupport implements WebGateBC {
    // Database Access Object
    private transient WebGateDBDAO dbDao=null;

    /**
     * WebGateBCImpl 객체 생성<br>
     * WebGateDBDAO를 생성한다.<br>
     */
    public WebGateBCImpl(){
        dbDao = new WebGateDBDAO();
    }
    
    /**
     * Movement 이벤트 처리<br>
     * create movement 화면에 대한 입력 이벤트 처리<br>
     * 
     * @param e SPP_SCE_001Event
     * @return EventResponse SPP_SCE_001EventResponse
     * @exception EventException
     */
    public EventResponse createMovement(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        SppSce0001Event event	= (SppSce0001Event)e;
        SppSce0001EventResponse eventResponse = null;
        
        try {
            eventResponse = (SppSce0001EventResponse)dbDao.createMovement(event);
        }catch(DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
	
    
    /**
     * Movement 이벤트 처리<br>
     * create movement 화면에 대한 입력 이벤트 처리<br>
     * 
     * @param e SPP_SCE_002Event
     * @return EventResponse SPP_SCE_002EventResponse
     * @exception EventException
     */
    public EventResponse selectCntrMvmt(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        SppSce0002Event event	= (SppSce0002Event)e;
        SppSce0002EventResponse eventResponse = null;
        
        try {
        	
        	Object[] result1 = dbDao.selectCntrMvmt(event);
        	CntrMvmt[] mvmt  = (CntrMvmt[])result1[0];
        	
        	eventResponse = new SppSce0002EventResponse(	mvmt,"SUCCESS");
        	
        }catch(DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
}