/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpecialSOCheckBCImpl.java
*@FileTitle : Special S/O Check - Supplement & Other
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-07
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2007-12-07 Jun Ho Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.basic;

import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0003Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.integration.SpecialSOCheckDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-SpecialSOCheck Business Logic Basic Command implementation<br>
 * - ENIS-SpecialSOCheck에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Jun Ho Kim
 * @see ESD_EAS_003EventResponse,SpecialSOCheckBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class SpecialSOCheckBCImpl   extends BasicCommandSupport implements SpecialSOCheckBC {

    // Database Access Object
    private transient SpecialSOCheckDBDAO  dbDao=null;

    /**
     * ExceptionManageBCImpl 객체 생성<br>
     * ExceptionManageDBDAO를 생성한다.<br>
     */
    public SpecialSOCheckBCImpl(){
        dbDao = new SpecialSOCheckDBDAO();
    }
    
	/**
	 * Special SO Search List
	 * @param e EsdEas0003Event
	 * @return EventResponse
	 * @throws EventException
	 */
    public EventResponse searchSpecialSOCheckList(Event e) throws EventException {
    	EsdEas0003Event event  = (EsdEas0003Event)e ;
    	DBRowSet         rowSet = new DBRowSet();
       
        try {
        		rowSet = dbDao.searchSpecialSOCheckList(event);
    			GeneralEventResponse eventResponse = new GeneralEventResponse();	
    			eventResponse.setRsVo(rowSet);
    			return eventResponse;
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }

	/**
	 * Other SO Search List
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
    public EventResponse searchOtherSOCheckList(Event e) throws EventException {
    	EsdEas0003Event event  = (EsdEas0003Event)e ;
    	DBRowSet         rowSet = new DBRowSet();
       
        try {
        		rowSet = dbDao.searchOtherSOCheckList(event);
    			GeneralEventResponse eventResponse = new GeneralEventResponse();	
    			eventResponse.setRsVo(rowSet);
    			return eventResponse;        		

        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }
    
}

