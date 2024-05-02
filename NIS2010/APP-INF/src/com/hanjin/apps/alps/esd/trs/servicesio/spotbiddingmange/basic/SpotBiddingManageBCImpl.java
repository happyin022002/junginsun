/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingManageBCImpl.java
*@FileTitle : Spot Bidding Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-22
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-06-22 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.basic;


import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingListSend;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingListSendEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmt;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmtEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingReceiveBiddingAmtEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendAwkwardCargoInfo;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendAwkwardCargoInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendReeferCargoInfo;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendReeferCargoInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendDangerCargoInfo;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendDangerCargoInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSpUsrInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration.SpotBiddingManageDBDAO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br> 
 * @author SHIN DONG IL
 * @see SpotBiddingManageDBDAO 클래스 참조
 * @since J2EE 1.6
 */
public class SpotBiddingManageBCImpl extends BasicCommandSupport implements SpotBiddingManageBC {
	/**
	 *  Database Access Object
	 */
	private transient SpotBiddingManageDBDAO  dbDao= null;
	
	/**
	 * SpotBiddingManageBCImpl 객체 생성
	 * SpotBiddingManageDBDAO 객체 생성
	 */
	public SpotBiddingManageBCImpl(){
		dbDao =  new SpotBiddingManageDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SPP의 조회조건을 I/F받아 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e Event
	 * @return SpotBiddingListSend[]
	 * @exception EventException
	 */
	public SpotBiddingListSend[] sendSpotBiddingList(Event e) throws EventException{
		SpotBiddingListSendEvent event = (SpotBiddingListSendEvent) e;
		SpotBiddingListSend[] spotBiddingListSend = null;
		
		try {
			spotBiddingListSend = dbDao.sendSpotBiddingList(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return spotBiddingListSend;    
	}
	
	/**
	 * Bidding의 최저가 Bidding Amount를 SPP로 I/F받는다.
	 * 
	 * @param e Event
	 * @return SpotBiddingLowestAmt[]
	 * @exception EventException
	 */
	public SpotBiddingLowestAmt[] sendSpotBiddingLowestAmt(Event e) throws EventException{
		SpotBiddingLowestAmtEvent event = (SpotBiddingLowestAmtEvent) e;
		SpotBiddingLowestAmt[] spotBiddingLowestAmt = null;

		try {
			spotBiddingLowestAmt = dbDao.sendSpotBiddingLowestAmt(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return spotBiddingLowestAmt;    
	}
	
	/**
	 * SPP에서 Bidding Amount를 I/F받는다.
	 * 
	 * @param e Event
	 * @throws EventException
	 */
	public void spotBiddingReceiveBiddingAmt(Event e) throws EventException{
		SpotBiddingReceiveBiddingAmtEvent event = (SpotBiddingReceiveBiddingAmtEvent) e;

		try {
			dbDao.spotBiddingReceiveBiddingAmt(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}
	
	/**
	 * SPP에서 User정보를 I/F받아 Vendor의 SPP Flag를 Update한다.
	 * 
	 * @param e Event
	 * @exception EventException
	 */
	public void modifySpotBiddingSpUsrInfo(Event e) throws EventException{
		SpotBiddingSpUsrInfoEvent event = (SpotBiddingSpUsrInfoEvent) e;

		try {
			dbDao.modifySpotBiddingSpUsrInfo(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}
	
	/**
	 * 조회 이벤트 처리<br>
	* SPP의 조회조건을 I/F받아 Reefer Cargo 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e Event
	 * @return SpotBiddingSendReeferCargoInfo[]
	 * @exception EventException
	 */
	public SpotBiddingSendReeferCargoInfo[] searchSpotBiddingSendReeferCargoInfo(Event e) throws EventException{
		SpotBiddingSendReeferCargoInfoEvent event = (SpotBiddingSendReeferCargoInfoEvent) e;
		SpotBiddingSendReeferCargoInfo[] spotBiddingSendReeferCargoInfo = null;
		
		try {
			spotBiddingSendReeferCargoInfo = dbDao.searchSpotBiddingSendReeferCargoInfo(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return spotBiddingSendReeferCargoInfo;    
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SPP의 조회조건을 I/F받아 Awkward Cargo 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e Event
	 * @return SpotBiddingSendAwkwardCargoInfo[]
	 * @exception EventException
	 */
	public SpotBiddingSendAwkwardCargoInfo[] searchSpotBiddingSendAwkwardCargoInfo(Event e) throws EventException{
		SpotBiddingSendAwkwardCargoInfoEvent event = (SpotBiddingSendAwkwardCargoInfoEvent) e;
		SpotBiddingSendAwkwardCargoInfo[] spotBiddingSendAwkwardCargoInfo = null;
		
		try {
			spotBiddingSendAwkwardCargoInfo = dbDao.searchSpotBiddingSendAwkwardCargoInfo(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return spotBiddingSendAwkwardCargoInfo;    
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SPP의 조회조건을 I/F받아 Danger Cargo 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e Event
	 * @return SpotBiddingSendDangerCargoInfo[]
	 * @exception EventException
	 */
	public SpotBiddingSendDangerCargoInfo[] searchSpotBiddingSendDangerCargoInfo(Event e) throws EventException{
		SpotBiddingSendDangerCargoInfoEvent event = (SpotBiddingSendDangerCargoInfoEvent) e;
		SpotBiddingSendDangerCargoInfo[] spotBiddingSendDangerCargoInfo = null;
		
		try {
			spotBiddingSendDangerCargoInfo = dbDao.searchSpotBiddingSendDangerCargoInfo(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return spotBiddingSendDangerCargoInfo;    
	}
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * Spot Bidding Manage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}