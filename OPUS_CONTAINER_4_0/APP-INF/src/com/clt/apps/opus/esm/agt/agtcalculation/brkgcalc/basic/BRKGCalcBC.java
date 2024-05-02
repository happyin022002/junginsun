/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BRKGCalcBC.java
*@FileTitle : Brokerage Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-12-22 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtcalculation.brkgcalc.basic;

import java.util.HashMap;

//import com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.event.ESM_AGT_035EventResponse;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-AGT Business Logic Command Interface<br>
 * - OPUS-AGT에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hwang GyeongNam 
 * @see ESM_AGT_035EventResponse 참조
 * @since J2EE 1.4
 */
public interface BRKGCalcBC  {
	
	
	/**
	 * Agent Commission Calculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @return int ( 정상 : cost 테이블 update 갯수, 실패 : -1)
	 * @exception EventException
	 */
	public int createAgentComm(String bkg_no) throws EventException;
	
	/**
	 * Brokerage Commission Calculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @return Object
	 * @exception EventException
	 */
	public Object createBRKGComm(String bkg_no) throws EventException;

	/**
	 * Booking 정보를 조회한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchBookingInfoforComm(HashMap bkgMap) throws EventException;
	
	/**
	 * S/A Date를 구한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchAGTSADate(HashMap bkgMap) throws EventException;
	
	/**
	 * SC NO, RFA NO, PPD OFFICE, CCT OFFICE, ACTUAL CUSTOMER, CGO_RCV_DT 구한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchAGTContractInfo(HashMap bkgMap) throws EventException;
	
	/**
	 * Booking QTY물량을 구한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchBKGQTYInfo(HashMap bkgMap) throws EventException;
	
	/**
	 * Revenue Lane과 Revenue VVD를 구한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchRevLanebndInfo(HashMap bkgMap) throws EventException;
	
	/**
	 * 대리점/Brokerage/FAC 계산전에 Booking Commission 정보 테이블에 저장한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @exception EventException
	 */
	public void createBKGMasterInfo(HashMap bkgMap) throws EventException;
	
    /**
     * ESM_AGT_015 화면에서 Recalculation 처리<br>
     * 
     * @param  Event e
     * @throws EventException
     */
    public void reCalcBRKGComm(Event e) throws EventException;
	
	/**
	 * 수동 Batch용 Agent, Brog, Fac Commission Calculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @param String interFlag
	 * @return int ( 정상 : cost 테이블 update 갯수, 실패 : -1)
	 * @exception EventException
	 */
	public int agtCalculationOne(String bkg_no, String interFlag) throws EventException;
	
	/**
	 * Brokerage Cancel 처리한다.<br>
	 * 
	 * @param String bkg_no
	 * @param String FLG0507
	 * @exception EventException
	 */
	public void processBrokerageCancel(String bkg_no, String FLG0507) throws EventException;
	/**
	 * Brokerage비 계산 배치 처리<br>
	 * 
	 * @param HashMap bkgMap
	 * @return String
	 * @exception EventException
	 */
	public String createActualBRKGComm(HashMap bkgMap) throws EventException;	
}
///**
// * test 호출<br>
// * @param String cost_yrmon
// * @return DBRowSet
// * @exception EventException
// */
//public DBRowSet testAgentComm(String cost_yrmon) throws EventException;
//
///**
// * AGT_BKG_REV_VVD_PRC Procedure 호출<br>
// * 
// * @param String bkg_no
// * @exception EventException
// */
//public void callProcedure(String bkg_no) throws EventException;
