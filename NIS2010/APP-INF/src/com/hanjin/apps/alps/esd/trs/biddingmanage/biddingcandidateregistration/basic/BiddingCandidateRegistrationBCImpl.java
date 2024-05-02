/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FuelScgManageBCImpl.java
*@FileTitle : Fuel Surcharge Mamange
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.basic;

import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.event.EsdTrs0300Event;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.integration.BiddingCandidateRegistrationDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
* ESD-TRS Business Logic Basic Command implementation<br>
* - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
* 
* @author SHIN DONG IL
* @see ESD_TRS_0280EventResponse,FuelScgManageBC 각 DAO 클래스 참조
* @since J2EE 1.6
*/
public class BiddingCandidateRegistrationBCImpl extends BasicCommandSupport implements BiddingCandidateRegistrationBC {
	// Database Access Object
	private transient BiddingCandidateRegistrationDBDAO dbDao=null;
	/**
	 * BiddingCandidateBCImpl 객체 생성<br>
	 * BiddingCandidateDBDAO 생성한다.<br>
	 */
	public BiddingCandidateRegistrationBCImpl(){
		dbDao = new BiddingCandidateRegistrationDBDAO();
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpotBidCnddtTermList(Event e) throws EventException{
		EsdTrs0300Event event = (EsdTrs0300Event)e;
		DBRowSet rowSet 		= null;
		try{
			rowSet = dbDao.searchSpotBidCnddtTermList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpotBidCnddtVndrList(Event e) throws EventException{
		EsdTrs0300Event event = (EsdTrs0300Event)e;
		DBRowSet rowSet 		= null;
		try{
			rowSet = dbDao.searchSpotBidCnddtVndrList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse addSpotBidCnddtTerm(Event e) throws EventException{
		EsdTrs0300Event event = (EsdTrs0300Event)e;
		DBRowSet rowSet 		= null;
		try{
			dbDao.addSpotBidCnddtTerm(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse delSpotBidCnddtTerm(Event e) throws EventException{
		EsdTrs0300Event event = (EsdTrs0300Event)e;
		DBRowSet rowSet 		= null;
		try{
			dbDao.delSpotBidCnddtTerm(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse addSpotBidCnddtVndr(Event e) throws EventException{
		EsdTrs0300Event event = (EsdTrs0300Event)e;
		DBRowSet rowSet 		= null;
		try{
			dbDao.addSpotBidCnddtVndr(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse delSpotBidCnddtVndr(Event e) throws EventException{
		EsdTrs0300Event event = (EsdTrs0300Event)e;
		DBRowSet rowSet 		= null;
		try{
			dbDao.delSpotBidCnddtVndr(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

}