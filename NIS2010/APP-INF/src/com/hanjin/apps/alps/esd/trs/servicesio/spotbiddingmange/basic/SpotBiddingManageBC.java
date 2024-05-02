/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingManageBC.java
*@FileTitle : SpotBiddingManageBC
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-22
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-06-22 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingListEventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingListSend;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmt;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendReeferCargoInfo;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendAwkwardCargoInfo;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendDangerCargoInfo;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SHIN DONG IL
 * @see SpotBiddingListEventResponse 참조
 * @since J2EE 1.4
 */
public interface SpotBiddingManageBC  {
	/**
	 * 조회 이벤트 처리<br>
	 * SPP의 조회조건을 I/F받아 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e Event
	 * @return SpotBiddingListSend[]
	 * @exception EventException
	 */
	public SpotBiddingListSend[] sendSpotBiddingList(Event e) throws EventException;
	/**
	 * Bidding의 최저가 Bidding Amount를 SPP로 I/F받는다.
	 * 
	 * @param e Event
	 * @return SpotBiddingLowestAmt[]
	 * @exception EventException
	 */
	public SpotBiddingLowestAmt[] sendSpotBiddingLowestAmt(Event e) throws EventException;
	
	/**
	 * SPP에서 Bidding Amount를 I/F받는다.
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void spotBiddingReceiveBiddingAmt(Event e) throws EventException;
	
	/**
	 * SPP에서 User정보를 I/F받아 Vendor의 SPP Flag를 Update한다.
	 * 
	 * @param e
	 * @exception EventException
	 */
	public void modifySpotBiddingSpUsrInfo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * SPP의 조회조건을 I/F받아 Reefer Cargo 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e Event
	 * @return SpotBiddingSendReeferCargoInfo[]
	 * @exception EventException
	 */
	public SpotBiddingSendReeferCargoInfo[] searchSpotBiddingSendReeferCargoInfo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * SPP의 조회조건을 I/F받아 Awkward Cargo 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e Event
	 * @return SpotBiddingSendAwkwardCargoInfo[]
	 * @exception EventException
	 */
	public SpotBiddingSendAwkwardCargoInfo[] searchSpotBiddingSendAwkwardCargoInfo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * SPP의 조회조건을 I/F받아 Danger Cargo 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e Event
	 * @return SpotBiddingSendDangerCargoInfo[]
	 * @exception EventException
	 */
	public SpotBiddingSendDangerCargoInfo[] searchSpotBiddingSendDangerCargoInfo(Event e) throws EventException;
}
