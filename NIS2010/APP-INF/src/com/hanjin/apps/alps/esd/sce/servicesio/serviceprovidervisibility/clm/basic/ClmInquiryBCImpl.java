/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CLMInquiryBCImpl.java
*@FileTitle : ServiceProvicerVisibility Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-02
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.basic;

import com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.event.ClmInquiry;
import com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.event.SppSce0003Event;
import com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.event.SppSce0003EventResponse;
import com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.integration.ClmInquiryDBDAO;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.Constants;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * Business Logic Basic Command implementation<br>
 *
 * @author 2007607
 * @see 
 * @since J2EE 1.4
 */
public class ClmInquiryBCImpl extends BasicCommandSupport implements ClmInquiryBC {
	private transient ClmInquiryDBDAO dbDao  = null;
    /**
     * CLMInquiryBCImpl 객체 생성<br>
     * CLMInquiryDBDAO를 생성한다.<br>
     */
    public ClmInquiryBCImpl(){
        dbDao = new ClmInquiryDBDAO();
    }
    /**
     * getCntrClmInquiry 데이터 산출 쿼리 호출 <br>
     * return EventResponse.<br>
     */
    public EventResponse getCntrClmInquiry(Event et) throws EventException{
    	SppSce0003Event event = (SppSce0003Event)et;
    	SppSce0003EventResponse eventResponse = null;
    	
    	log.debug("CLMInquiryBCImpl getCntrClmInquiry() ");
    	
    	try{
    		Object[] result = dbDao.getCntrClmInquiry(event);
    		
    		eventResponse = new SppSce0003EventResponse((ClmInquiry[])result[0], "SUCCESS");
    		eventResponse.setTotalCount(((Integer)result[1]).intValue());
    		
    		log.debug("CLMInquiryBCImpl result[1] length " + ((Integer)result[1]).intValue());
    		log.debug("eventResponse.getTotalCount()  " + eventResponse.getTotalCount());
    	} catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
        return eventResponse;
    }

}
