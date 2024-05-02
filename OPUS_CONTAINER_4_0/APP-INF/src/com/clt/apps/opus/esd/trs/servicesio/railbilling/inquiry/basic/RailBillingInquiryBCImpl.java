/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingInquiryBCImpl.java
*@FileTitle : RailBillingInquiry Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.basic;

import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.Constants;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0012Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0012EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0021Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0021EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event.RailBillingInquiry;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.integration.RailBillingInquiryDBDAO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br> 
 * @author leebh
 * @see RailBillingInquiryBCDAO 클래스 참조
 * @since J2EE 1.4
 */
public class RailBillingInquiryBCImpl   extends BasicCommandSupport implements RailBillingInquiryBC {

    // Database Access Object
    private transient RailBillingInquiryDBDAO dbDao=null;

    /**
     * RailBillingInquiryBCImpl 객체 생성<br>
     * RailBillingInquiryCDAO를 생성한다.<br>
     */
    public RailBillingInquiryBCImpl(){
        dbDao = new RailBillingInquiryDBDAO();
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Rail Bill Order Inquiry 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0012Event
     * @return EventResponse ExpPap0012EventResponse
     * @exception EventException
     */
    public EventResponse searchRailBillingInquiry(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        ExpPap0012Event event = (ExpPap0012Event)e;
        ExpPap0012EventResponse eventResponse = null;
        
        try {
        	Object[] result1 = dbDao.searchRailBillingInquiry(event);
        	RailBillingInquiry[] railBillingInquiryList  = (RailBillingInquiry[])result1[0];
        	
            eventResponse = new ExpPap0012EventResponse(	railBillingInquiryList,
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
     * 조회 이벤트 처리<br>
     * Rail Bill Order Inquiry Excel 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0021Event
     * @return EventResponse ExpPap0021EventResponse
     * @exception EventException
     */
    public EventResponse searchRailBillingInquiryExcel(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	ExpPap0021Event event = (ExpPap0021Event)e;
    	ExpPap0021EventResponse eventResponse = null;
    	
    	try {
    		Object[] result1 = dbDao.searchRailBillingInquiryExcel(event);
    		RailBillingInquiry[] railBillingInquiryList  = (RailBillingInquiry[])result1[0];
    		
    		eventResponse = new ExpPap0021EventResponse(	
    									railBillingInquiryList,
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