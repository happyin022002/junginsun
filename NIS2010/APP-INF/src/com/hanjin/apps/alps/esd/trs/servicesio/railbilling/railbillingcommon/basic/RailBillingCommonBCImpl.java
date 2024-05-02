/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingCommonBCImpl.java
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

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.Constants;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.event.ExpPap0019Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.event.ExpPap0019EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.integration.RailBillingCommonDBDAO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br> 
 * @author leebh
 * @see RailBillingCommonBCDAO 클래스 참조
 * @since J2EE 1.4
 */
public class RailBillingCommonBCImpl   extends BasicCommandSupport implements RailBillingCommonBC {

    // Database Access Object
    private transient RailBillingCommonDBDAO dbDao=null;

    /**
     * RailBillingCommonBCImpl 객체 생성<br>
     * RailBillingCommonCDAO를 생성한다.<br>
     */
    public RailBillingCommonBCImpl(){
        dbDao = new RailBillingCommonDBDAO();
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Potal Main Rail Bill Ack Count 조회  화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0019Event
     * @return EventResponse ExpPap0019EventResponse
     * @exception EventException
     */
    public EventResponse searchRailBillingAckCount(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        ExpPap0019Event event = (ExpPap0019Event)e;
        ExpPap0019EventResponse eventResponse = null;
        
        try {
        	Object[] result1 = dbDao.searchRailBillingAckCount(event);
        	Integer ackCount  = (Integer)result1[0];
        	
            eventResponse = new ExpPap0019EventResponse(	ackCount.intValue(),
            												"SUCCESS");
        } catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
        return eventResponse;
    }
 
    /**
     * ESD_TRS 업무 시나리오 마감작업<br>
     * RailBilling업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        dbDao = null;
    }
    

}