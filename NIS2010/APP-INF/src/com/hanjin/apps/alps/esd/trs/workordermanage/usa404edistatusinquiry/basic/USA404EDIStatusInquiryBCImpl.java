/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USA404EDIStatusInquiryBCImpl.java
*@FileTitle : USA 404 EDI Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.13
*@LastModifier : 최 선
*@LastVersion : 1.31
* 2006.11.28 kim_sang_geun
* 1.0 최초 생성 
* 1.95 N200905250130 [TRS]US RAIL EDI 발송시 RF CNTR Temp 체크 로직 추가
* N200906020130 2009-06-09 [TRS-Rail EDI] DG 정보 오전송에 따른 보완
* 1.26 2010.11.23 이재위 [] [TRS] OPMS Design/Development Verification 을 위한 소스 점검
* 1.30 2011.12.19 김종호 [CHM-201114938] [TRS] USLGBPT Inter-Terminal operation 404 중복 생성 요청 (USLAXM2관련)
* 1.31 2012.07.13 최 선 [CHM-201218429] [TRS] 404 Flat File 관련 HAZMAT 정보 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.basic;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ServerExportException;

import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.integration.USA404EDIStatusInquiryDBDAO;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.integration.USA404EDIStatusInquiryEAIDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
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
 * @author kim_sang_geun
 * @see ESD_TRS_028EventResponse,USA404EDIStatusInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class USA404EDIStatusInquiryBCImpl   extends BasicCommandSupport implements USA404EDIStatusInquiryBC
{

	// Database Access Object
	private transient USA404EDIStatusInquiryDBDAO dbDao=null;
	private transient USA404EDIStatusInquiryEAIDAO eaiDao=null;

	/**
	 * USA404EDIStatusInquiryBCImpl 객체 생성<br>
	 * USA404EDIStatusInquiryDBDAO를 생성한다.<br>
	 */
	public USA404EDIStatusInquiryBCImpl(){
		dbDao = new USA404EDIStatusInquiryDBDAO();
		eaiDao = new USA404EDIStatusInquiryEAIDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSA404EDIStatusInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event=(EsdTrs0028Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet = dbDao.searchUSA404EDIStatusInquiry(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리 <br>
	 * USA404EDIStatusInquiry화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	public EventResponse search02USA404EDIStatusInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event=(EsdTrs0028Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;

		try {
			rowSet=dbDao.search02USA404EDIStatusInquiry(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 조회 이벤트 처리<br>
	 * COP EDI 전
	 * 
	 * @param list
	 * @return
	 * @exception EventException
	 */
	public EventResponse search03USA404EDIStatusSend(List<Object> list) throws EventException {
		DBRowSet rowSet	= null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet = dbDao.search03USA404EDIStatusSend(list);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 조회 이벤트 처리<br>
	 * COP EDI 전
	 * 
	 * @param list
	 * @return
	 * @exception EventException
	 */
	public EventResponse searchUS404EDIResendList(List<Object> list) throws EventException {
		DBRowSet rowSet		= null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			rowSet 	= dbDao.searchUS404EDIResendList(list);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 조회 이벤트 처리<br>
	 * COP EDI 전
	 * 
	 * @param rowSet
	 * @exception EventException
	 */
	public void search03SubUSA404EDIStatusSend(DBRowSet rowSet) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String sVndrEdi2 = "";
		String sAppMahaEdi2  = "";
		String sAppMtc2  = "";
		String sAppSsofa2  = "";
		String sAppIts2  = "";
		String sAppMtclax2  = "";
		String sAppMtcla2  = ""; //CHM-201325385 [TRS] 404 EDI terminal setup
		String sAppEtslax2  = ""; //CHM-201538922 RailBilling EDI (404 & 998) 중복 생성 요청
		String sAppMtchan2  = "";
		String sAppMtchanint2  = "";
		String sAppNwcs310_2  = "";
//		String sApp3105488232_2  = "";
		
		StringBuffer sb_send = new StringBuffer();
		StringBuffer sb_send_mtc = new StringBuffer();
		StringBuffer sb_send_maha = new StringBuffer();
		StringBuffer sb_send_ptxx = new StringBuffer();
		StringBuffer sb_send_vitusbrail = new StringBuffer();
		StringBuffer sb_send_ssofa = new StringBuffer();
		StringBuffer sb_send_its = new StringBuffer();
		StringBuffer sb_send_mtclax = new StringBuffer();
		StringBuffer sb_send_mtcla = new StringBuffer(); //CHM-201325385 [TRS] 404 EDI terminal setup
		StringBuffer sb_send_etslax = new StringBuffer(); //CHM-201538922 RailBilling EDI (404 & 998) 중복 생성 요청
		StringBuffer sb_send_mtchan = new StringBuffer();
		StringBuffer sb_send_mtchanint = new StringBuffer();
		StringBuffer sb_send_nwcs310 = new StringBuffer();
		StringBuffer sb_send_3105488232 = new StringBuffer();
		
		int i = 1;
		
		try {
			USA404EDIStatusInquiryEAIDAO usa404EdiStatusInquiryEai = new USA404EDIStatusInquiryEAIDAO();
			
			if( rowSet != null ) {
				while( rowSet.next() ) {
					//Insert 파라미터
					String sVndrEdi    = JSPUtil.getNull(rowSet.getString("APPRECV_C"));
					String sAppMahaEdi = JSPUtil.getNull(rowSet.getString("APP_MAHA"));
					String sAppMtcEdi1 = JSPUtil.getNull(rowSet.getString("APP_MTC1"));
					String sAppMtcEdi2 = JSPUtil.getNull(rowSet.getString("APP_MTC2"));
					String sAppPtxx	   = JSPUtil.getNull(rowSet.getString("APP_PTXX"));
					String sRailCmb    = JSPUtil.getNull(rowSet.getString("RAIL_CMB"));
					String sAppVitusbrail = JSPUtil.getNull(rowSet.getString("APP_VITUSBRAIL"));
					String sAppSsofa = JSPUtil.getNull(rowSet.getString("APP_SSOFA"));
					String sAppIts = JSPUtil.getNull(rowSet.getString("APP_ITS"));
					String sAppMtclax = JSPUtil.getNull(rowSet.getString("APP_MTCLAX"));
					String sAppMtcla = JSPUtil.getNull(rowSet.getString("APP_MTCLA")); //CHM-201325385 [TRS] 404 EDI terminal setup
					String sAppEtslax = JSPUtil.getNull(rowSet.getString("APP_ETSLAX")); //CHM-201538922 RailBilling EDI (404 & 998) 중복 생성 요청
					String sAppMtchan = JSPUtil.getNull(rowSet.getString("APP_MTCHAN"));
					String sAppMtchanint = JSPUtil.getNull(rowSet.getString("APP_MTCHANINT"));
					String sAppNwcs310 = JSPUtil.getNull(rowSet.getString("APP_NWCS310")); //CSR CHM-201539465 404 & 998 EDI 중복 생성 요청 (NWCS)
					String sAppMtc     = "";
					
					
					if( !sAppMtcEdi1.equals("") ) {
						sAppMtc = sAppMtcEdi1;
					} else if( !sAppMtcEdi2.equals("") ) {
						sAppMtc = sAppMtcEdi2;
					}
					String sApp3105488232 = JSPUtil.getNull(rowSet.getString("APP_3105488232"));

					/*
				     * * N200902230090 2009-03-10 [EDI] 미주 Rail 998, 404 FF 통합
				     * * N200905270080 [TRS]US RAIL EDI  DG CGO에 대한 Flash point 추가 전송관련 보완
				     */
					StringBuffer eh = new StringBuffer();
					eh.append("{CNTR\n");
					StringBuffer eb = new StringBuffer();
					eb.append("TYPE:"+JSPUtil.getNull(rowSet.getString("TYPE"))+"\n")
					.append("SHIPQLF_C:"+JSPUtil.getNull(rowSet.getString("SHIPQLF_C"))+"\n")
					.append("BKGNO:"+JSPUtil.getNull(rowSet.getString("BKGNO"))+"\n")
					.append("BLNO:"+JSPUtil.getNull(rowSet.getString("BLNO"))+"\n")
					.append("BKG_SCNO:"+JSPUtil.getNull(rowSet.getString("BKG_SCNO"))+"\n")
					.append("VSLCODE:"+JSPUtil.getNull(rowSet.getString("VSLCODE"))+"\n")
					.append("VOYAGE:"+JSPUtil.getNull(rowSet.getString("VOYAGE"))+"\n")
					.append("VSLNAME:"+JSPUtil.getNull(rowSet.getString("VSLNAME"))+"\n")
					.append("VSLCUTOFF:"+JSPUtil.getNull(rowSet.getString("VSLCUTOFF"))+"\n")
					.append("LLOYD:"+JSPUtil.getNull(rowSet.getString("LLOYD"))+"\n")
					.append("HUBETA:"+JSPUtil.getNull(rowSet.getString("HUBETA"))+"\n")
					.append("POL:"+JSPUtil.getNull(rowSet.getString("POL"))+"\n")
					.append("POD:"+JSPUtil.getNull(rowSet.getString("POD"))+"\n")
					.append("CONTRACT:"+JSPUtil.getNull(rowSet.getString("CONTRACT"))+"\n");

					// MTC 일 때 CREDIT prefix 'M'
					StringBuffer vndrCredit = new StringBuffer();
					StringBuffer mtcCredit = new StringBuffer();
					vndrCredit.append("CREDIT:"+ JSPUtil.getNull(rowSet.getString("CREDIT"))  +"\n");
					mtcCredit.append("CREDIT:"+ JSPUtil.getNull(rowSet.getString("MTC_CREDIT")) +"\n");

					StringBuffer eb1 = new StringBuffer();
					eb1.append("IMTRANSNO:"+JSPUtil.getNull(rowSet.getString("IMTRANSNO"))+"\n")
					.append("TRANSEXPNO:"+JSPUtil.getNull(rowSet.getString("TRANSEXPNO"))+"\n")
					.append("DOCK:"+JSPUtil.getNull(rowSet.getString("DOCK"))+"\n")
					.append("FFDESC:"+JSPUtil.getNull(rowSet.getString("FFDESC"))+"\n")
					.append("EQNISTS:"+JSPUtil.getNull(rowSet.getString("EQNISTS"))+"\n")
					.append("EQINIT:"+JSPUtil.getNull(rowSet.getString("EQINIT"))+"\n")
					.append("EQNO:"+JSPUtil.getNull(rowSet.getString("EQNO"))+"\n")
					.append("WGT:"+JSPUtil.getNull(rowSet.getString("WGT"))+"\n")
					.append("EQDESC_C:"+JSPUtil.getNull(rowSet.getString("EQDESC_C"))+"\n")
					.append("EQLTH_C:"+JSPUtil.getNull(rowSet.getString("EQLTH_C"))+"\n")
					.append("EQCHK:"+JSPUtil.getNull(rowSet.getString("EQCHK"))+"\n")
					.append("SEALNO:"+JSPUtil.getNull(rowSet.getString("SEALNO"))+"\n")
					.append("SPCHAND_C:"+JSPUtil.getNull(rowSet.getString("SPCHAND_C"))+"\n")
					.append("ILTRANS_C:"+JSPUtil.getNull(rowSet.getString("ILTRANS_C"))+"\n")
					.append("CUSTENTTP_C:"+JSPUtil.getNull(rowSet.getString("CUSTENTTP_C"))+"\n")
					.append("CUSTENTNO:"+JSPUtil.getNull(rowSet.getString("CUSTENTNO"))+"\n")
					.append("CUSTTYPE:"+JSPUtil.getNull(rowSet.getString("CUSTTYPE"))+"\n")
					.append("CUSTLOC:"+JSPUtil.getNull(rowSet.getString("CUSTLOC"))+"\n")
					.append("CARGOWGT:"+JSPUtil.getNull(rowSet.getString("CARGOWGT"))+"\n")
					.append("ORGCTY:"+JSPUtil.getNull(rowSet.getString("ORGCTY"))+"\n")
					.append("ORGSTATE:"+JSPUtil.getNull(rowSet.getString("ORGSTATE"))+"\n")
					.append("ORGLOC:"+JSPUtil.getNull(rowSet.getString("ORGLOC"))+"\n")
					.append("ORGYD:"+JSPUtil.getNull(rowSet.getString("ORGYD"))+"\n")
					.append("DSTCTY:"+JSPUtil.getNull(rowSet.getString("DSTCTY"))+"\n")
					.append("DSTSTATE:"+JSPUtil.getNull(rowSet.getString("DSTSTATE"))+"\n")
					.append("DSTLOC:"+JSPUtil.getNull(rowSet.getString("DSTLOC"))+"\n")
					.append("DSTYD:"+JSPUtil.getNull(rowSet.getString("DSTYD"))+"\n")
					.append("SHPR_N:"+JSPUtil.getNull(rowSet.getString("SHPR_N"))+"\n")
					.append("SHPR_A:"+JSPUtil.getNull(rowSet.getString("SHPR_A"))+"\n")
					.append("SHPR_C:"+JSPUtil.getNull(rowSet.getString("SHPR_C"))+"\n")
					.append("SHPR_S:"+JSPUtil.getNull(rowSet.getString("SHPR_S"))+"\n")
					.append("SHPR_P:"+JSPUtil.getNull(rowSet.getString("SHPR_P"))+"\n")
					.append("SHPR_CN:"+JSPUtil.getNull(rowSet.getString("SHPR_CN"))+"\n");

					StringBuffer eb2 = new StringBuffer(); //MTC가 아닌 경우
					eb2.append("ASHPR_CODE:"+JSPUtil.getNull(rowSet.getString("ASHPR_CODE"))+"\n")
					.append("ASHPR_N:"+JSPUtil.getNull(rowSet.getString("ASHPR_N"))+"\n")
					.append("ASHPR_A:"+JSPUtil.getNull(rowSet.getString("ASHPR_A"))+"\n")
					.append("ASHPR_C:"+JSPUtil.getNull(rowSet.getString("ASHPR_C"))+"\n")
					.append("ASHPR_S:"+JSPUtil.getNull(rowSet.getString("ASHPR_S"))+"\n")
					.append("ASHPR_P:"+JSPUtil.getNull(rowSet.getString("ASHPR_P"))+"\n")
					.append("ASHPR_CN:"+JSPUtil.getNull(rowSet.getString("ASHPR_CN"))+"\n");
					StringBuffer eb2_1 = new StringBuffer(); //MTC 일경우만.
					eb2_1.append("ASHPR_CODE:\n")
					.append("ASHPR_N:\n")
					.append("ASHPR_A:\n")
					.append("ASHPR_C:\n")
					.append("ASHPR_S:\n")
					.append("ASHPR_P:\n")
					.append("ASHPR_CN:\n");

					StringBuffer eb3 = new StringBuffer();
					eb3.append("CNEE_N:"+JSPUtil.getNull(rowSet.getString("CNEE_N"))+"\n")
					.append("CNEE_A:"+JSPUtil.getNull(rowSet.getString("CNEE_A"))+"\n")
					.append("CNEE_C:"+JSPUtil.getNull(rowSet.getString("CNEE_C"))+"\n")
					.append("CNEE_S:"+JSPUtil.getNull(rowSet.getString("CNEE_S"))+"\n")
					.append("CNEE_P:"+JSPUtil.getNull(rowSet.getString("CNEE_P"))+"\n")
					.append("CNEE_CN:"+JSPUtil.getNull(rowSet.getString("CNEE_CN"))+"\n")
					.append("NTFY_N:"+JSPUtil.getNull(rowSet.getString("NTFY_N"))+"\n")
					.append("NTFY_T:"+JSPUtil.getNull(rowSet.getString("NTFY_T"))+"\n")
					.append("CARE_N:"+JSPUtil.getNull(rowSet.getString("CARE_N"))+"\n")
					.append("CARE_A:"+JSPUtil.getNull(rowSet.getString("CARE_A"))+"\n")
					.append("CARE_C:"+JSPUtil.getNull(rowSet.getString("CARE_C"))+"\n")
					.append("CARE_S:"+JSPUtil.getNull(rowSet.getString("CARE_S"))+"\n")
					.append("CARE_P:"+JSPUtil.getNull(rowSet.getString("CARE_P"))+"\n")
					.append("CARE_CN:"+JSPUtil.getNull(rowSet.getString("CARE_CN"))+"\n")
					.append("BILL_N:"+JSPUtil.getNull(rowSet.getString("BILL_N"))+"\n")
					.append("BILL_A:"+JSPUtil.getNull(rowSet.getString("BILL_A"))+"\n")
					.append("BILL_C:"+JSPUtil.getNull(rowSet.getString("BILL_C"))+"\n")
					.append("BILL_S:"+JSPUtil.getNull(rowSet.getString("BILL_S"))+"\n")
					.append("BILL_P:"+JSPUtil.getNull(rowSet.getString("BILL_P"))+"\n")
					.append("BILL_CN:"+JSPUtil.getNull(rowSet.getString("BILL_CN"))+"\n")
					.append("UTCN_CODE:"+JSPUtil.getNull(rowSet.getString("UTCN_CODE"))+"\n")
					.append("UTCN_N:"+JSPUtil.getNull(rowSet.getString("UTCN_N"))+"\n");

					StringBuffer eb4 = new StringBuffer(); //MTC가 아닌 경우
					eb4.append("UTCN_A:"+JSPUtil.getNull(rowSet.getString("UTCN_A"))+"\n")
					.append("UTCN_C:"+JSPUtil.getNull(rowSet.getString("UTCN_C"))+"\n")
					.append("UTCN_S:"+JSPUtil.getNull(rowSet.getString("UTCN_S"))+"\n")
					.append("UTCN_P:"+JSPUtil.getNull(rowSet.getString("UTCN_P"))+"\n")
					.append("UTCN_CN:"+JSPUtil.getNull(rowSet.getString("UTCN_CN"))+"\n");
					StringBuffer eb4_1 = new StringBuffer();  //MTC 일경우만.
					eb4_1.append("UTCN_A:\n")
					.append("UTCN_C:\n")
					.append("UTCN_S:\n")
					.append("UTCN_P:\n")
					.append("UTCN_CN:\n");

					StringBuffer eb5 = new StringBuffer();
					eb5.append("RECV_N:"+JSPUtil.getNull(rowSet.getString("RECV_N"))+"\n")
					.append("RECV_A:"+JSPUtil.getNull(rowSet.getString("RECV_A"))+"\n")
					.append("RECV_C:"+JSPUtil.getNull(rowSet.getString("RECV_C"))+"\n")
					.append("RECV_S:"+JSPUtil.getNull(rowSet.getString("RECV_S"))+"\n")
					.append("RECV_P:"+JSPUtil.getNull(rowSet.getString("RECV_P"))+"\n")
					.append("RECV_CN:"+JSPUtil.getNull(rowSet.getString("RECV_CN"))+"\n")
					.append("ADMC_C:"+JSPUtil.getNull(rowSet.getString("ADMC_C"))+"\n")
					.append("FDA_IND:"+JSPUtil.getNull(rowSet.getString("FDA_IND"))+"\n")
					.append("CUST_F:"+JSPUtil.getNull(rowSet.getString("CUST_F"))+"\n")
					.append("CUST_E:"+JSPUtil.getNull(rowSet.getString("CUST_E"))+"\n")
					.append("TEMP:"+JSPUtil.getNull(rowSet.getString("TEMP"))+"\n")
					.append("TUN:"+JSPUtil.getNull(rowSet.getString("TUN"))+"\n")
					.append("VENT:"+JSPUtil.getNull(rowSet.getString("VENT"))+"\n")
					.append("HUMID:"+JSPUtil.getNull(rowSet.getString("HUMID"))+"\n")
					.append("GENSET:"+JSPUtil.getNull(rowSet.getString("GENSET"))+"\n")
					.append("{REF\n")
					.append("REFID:"+JSPUtil.getNull(rowSet.getString("REFID"))+"\n")
					.append("REFVAL:"+JSPUtil.getNull(rowSet.getString("REFVAL"))+"\n")
					.append("}REF\n");
					
					/*
					 * N200906100030 2009-06-15 [EDI-TRS/Dom. EDI-404] Rail Interchage에 대한 Contract no 보완
					 */
					if( sRailCmb.equals("C1T") || sRailCmb.equals("S2R") || sRailCmb.equals("S3R") ) {
						eb5.append("{ROUTE\n")
						.append("ROUTCARR:"+JSPUtil.getNull(rowSet.getString("ROUTCARR"))+"\n")
						.append("ROUTSEQ:"+JSPUtil.getNull(rowSet.getString("ROUTSEQ"))+"\n")
						.append("ROUTCITY:"+JSPUtil.getNull(rowSet.getString("ROUTCITY"))+"\n")
						.append("INTMOSVR:"+JSPUtil.getNull(rowSet.getString("INTMOSVR"))+"\n")
						.append("TRANSTP:"+JSPUtil.getNull(rowSet.getString("TRANSTP"))+"\n")
						.append("TOYD:"+JSPUtil.getNull(rowSet.getString("TO_YARD_CD"))+"\n")
						.append("CONTRACT:"+JSPUtil.getNull(rowSet.getString("CONTRACT"))+"\n")
						.append("}ROUTE\n");
					} else {
						eb5.append("{ROUTE\n")
						.append("ROUTCARR:"+JSPUtil.getNull(rowSet.getString("ROUTCARR"))+"\n")
						.append("ROUTSEQ:"+JSPUtil.getNull(rowSet.getString("ROUTSEQ"))+"\n")
						.append("ROUTCITY:"+JSPUtil.getNull(rowSet.getString("ROUTCITY"))+"\n")
						.append("INTMOSVR:"+JSPUtil.getNull(rowSet.getString("INTMOSVR"))+"\n")
						.append("TRANSTP:"+JSPUtil.getNull(rowSet.getString("TRANSTP"))+"\n")
						.append("TOYD:"+JSPUtil.getNull(rowSet.getString("TO_YARD_CD"))+"\n")
						.append("CONTRACT:"+JSPUtil.getNull(rowSet.getString("CONTRACT"))+"\n")
						.append("}ROUTE\n")
						.append("{ROUTE\n")
						.append("ROUTCARR:"+JSPUtil.getNull(rowSet.getString("ROUTCARR2"))+"\n")
						.append("ROUTSEQ:"+JSPUtil.getNull(rowSet.getString("ROUTSEQ2"))+"\n")
						.append("ROUTCITY:"+JSPUtil.getNull(rowSet.getString("ROUTCITY2"))+"\n")
						.append("INTMOSVR:"+JSPUtil.getNull(rowSet.getString("INTMOSVR2"))+"\n")
						.append("TRANSTP:"+JSPUtil.getNull(rowSet.getString("TRANSTP2"))+"\n")
						.append("TOYD:"+JSPUtil.getNull(rowSet.getString("TO_YARD_CD2"))+"\n")
						.append("CONTRACT:"+JSPUtil.getNull(rowSet.getString("CONTRACT2"))+"\n")
						.append("}ROUTE\n");
						if( sRailCmb.equals("C3T") || sRailCmb.equals("C3R") || sRailCmb.equals("C3S") ) {
							eb5.append("{ROUTE\n")
							.append("ROUTCARR:"+JSPUtil.getNull(rowSet.getString("ROUTCARR3"))+"\n")
							.append("ROUTSEQ:"+JSPUtil.getNull(rowSet.getString("ROUTSEQ3"))+"\n")
							.append("ROUTCITY:"+JSPUtil.getNull(rowSet.getString("ROUTCITY3"))+"\n")
							.append("INTMOSVR:"+JSPUtil.getNull(rowSet.getString("INTMOSVR3"))+"\n")
							.append("TRANSTP:"+JSPUtil.getNull(rowSet.getString("TRANSTP3"))+"\n")
							.append("TOYD:"+JSPUtil.getNull(rowSet.getString("TO_YARD_CD3"))+"\n")
							.append("CONTRACT:"+JSPUtil.getNull(rowSet.getString("CONTRACT3"))+"\n")
							.append("}ROUTE\n");
						}
					}
					eb5.append("INBOND:"+JSPUtil.getNull(rowSet.getString("INBOND"))+"\n")
					.append("{LADE\n")
					.append("LADELINE:"+JSPUtil.getNull(rowSet.getString("LADELINE1"))+"\n")
					.append("LADEDESC:"+JSPUtil.getNull(rowSet.getString("LADEDESC1"))+"\n")
					.append("COMMCODE:"+JSPUtil.getNull(rowSet.getString("COMMCODE1"))+"\n")
					.append("NISCOMM:"+JSPUtil.getNull(rowSet.getString("NISCOMM1"))+"\n")
					.append("NISREP:"+JSPUtil.getNull(rowSet.getString("NISRETP1"))+"\n")
					.append("}LADE\n");
					String slade_line = JSPUtil.getNull(rowSet.getString("LADELINE2")); //이 값이 있으면, OK
					if( !slade_line.equals("") ) {
						eb5.append("{LADE\n")
						.append("LADELINE:"+slade_line+"\n")
						.append("LADEDESC:"+JSPUtil.getNull(rowSet.getString("LADEDESC2"))+"\n")
						.append("COMMCODE:"+JSPUtil.getNull(rowSet.getString("COMMCODE2"))+"\n")
						.append("NISCOMM:"+JSPUtil.getNull(rowSet.getString("NISCOMM2"))+"\n")
						.append("NISREP:"+JSPUtil.getNull(rowSet.getString("NISRETP2"))+"\n")
						.append("}LADE\n");
					}
					slade_line = JSPUtil.getNull(rowSet.getString("LADELINE3"));
					if( !slade_line.equals("") ) {
						eb5.append("{LADE\n")
						.append("LADELINE:"+slade_line+"\n")
						.append("LADEDESC:"+JSPUtil.getNull(rowSet.getString("LADEDESC3"))+"\n")
						.append("COMMCODE:"+JSPUtil.getNull(rowSet.getString("COMMCODE3"))+"\n")
						.append("NISCOMM:"+JSPUtil.getNull(rowSet.getString("NISCOMM3"))+"\n")
						.append("NISREP:"+JSPUtil.getNull(rowSet.getString("NISRETP3"))+"\n")
						.append("}LADE\n");
					}
					slade_line = JSPUtil.getNull(rowSet.getString("LADELINE4"));
					if( !slade_line.equals("") ) {
						eb5.append("{LADE\n")
						.append("LADELINE:"+slade_line+"\n")
						.append("LADEDESC:"+JSPUtil.getNull(rowSet.getString("LADEDESC4"))+"\n")
						.append("COMMCODE:"+JSPUtil.getNull(rowSet.getString("COMMCODE4"))+"\n")
						.append("NISCOMM:"+JSPUtil.getNull(rowSet.getString("NISCOMM4"))+"\n")
						.append("NISREP:"+JSPUtil.getNull(rowSet.getString("NISRETP4"))+"\n")
						.append("}LADE\n");
					}
					slade_line = JSPUtil.getNull(rowSet.getString("LADELINE5"));
					if( !slade_line.equals("") ) {
						eb5.append("{LADE\n")
						.append("LADELINE:"+slade_line+"\n")
						.append("LADEDESC:"+JSPUtil.getNull(rowSet.getString("LADEDESC5"))+"\n")
						.append("COMMCODE:"+JSPUtil.getNull(rowSet.getString("COMMCODE5"))+"\n")
						.append("NISCOMM:"+JSPUtil.getNull(rowSet.getString("NISCOMM5"))+"\n")
						.append("NISREP:"+JSPUtil.getNull(rowSet.getString("NISRETP5"))+"\n")
						.append("}LADE\n");
					}
					/*
					 * * N200904030180 2009-04-15 [TRS_Rail EDI] DG 관련 항목 추가 및 Shipper 정보 누락관련 보완요청
					 */
					eb5.append("LADEQTY:"+JSPUtil.getNull(rowSet.getString("LADEQTY"))+"\n")
					.append("PACKFORM:"+JSPUtil.getNull(rowSet.getString("PACKFORM"))+"\n");
					
//					if("2".equals(rowSet.getString("DG_MAX_SEQ"))){
//						param.put("dgBkgNo", rowSet.getString("DG_BKG_NO"));
//						velParam.put("dgBkgNo", rowSet.getString("DG_BKG_NO"));
//						
//						param.put("dgEqNo", rowSet.getString("DG_EQ_NO"));
//						velParam.put("dgEqNo", rowSet.getString("DG_EQ_NO"));
//						
//						dbRowset = dbDao.search03SubUSA404EDIStatusSend(param, velParam);
//						
//						while(dbRowset.next()){
//							eb5.append("{DG\n")
//							.append("DG_STCC:"+JSPUtil.getNull(dbRowset.getString("DG_STCC"))+"\n")
//							.append("DG_UN:"+JSPUtil.getNull(dbRowset.getString("DG_UN"))+"\n")
//							.append("DG_NAME:"+JSPUtil.getNull(dbRowset.getString("DG_NAME"))+"\n")
//							.append("DG_CONTENTS:"+JSPUtil.getNull(dbRowset.getString("DG_CONTENTS"))+"\n")
//							.append("DG_CLASS:"+JSPUtil.getNull(dbRowset.getString("DG_CLASS"))+"\n")
//							.append("DG_PGRP:"+JSPUtil.getNull(dbRowset.getString("DG_PGRP"))+"\n")
//							.append("DG_QTY:"+JSPUtil.getNull(dbRowset.getString("DG_QTY"))+"\n")
//							.append("DG_QUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_QUNIT"))+"\n")
//							.append("DG_WEIGHT:"+JSPUtil.getNull(dbRowset.getString("DG_WEIGHT"))+"\n")
//							.append("DG_WUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_WUNIT"))+"\n")
//							.append("DG_FLASHTEMP:"+JSPUtil.getNull(dbRowset.getString("DG_FLASHTEMP"))+"\n")
//							.append("DG_TEL:"+JSPUtil.getNull(dbRowset.getString("DG_TEL"))+"\n")
//							.append("}DG\n");
//						}
//					}else{
//						eb5.append("{DG\n")
//						.append("DG_STCC:"+JSPUtil.getNull(rowSet.getString("DG_STCC"))+"\n")
//						.append("DG_UN:"+JSPUtil.getNull(rowSet.getString("DG_UN"))+"\n")
//						.append("DG_NAME:"+JSPUtil.getNull(rowSet.getString("DG_NAME"))+"\n")
//						.append("DG_CONTENTS:"+JSPUtil.getNull(rowSet.getString("DG_CONTENTS"))+"\n")
//						.append("DG_CLASS:"+JSPUtil.getNull(rowSet.getString("DG_CLASS"))+"\n")
//						.append("DG_PGRP:"+JSPUtil.getNull(rowSet.getString("DG_PGRP"))+"\n")
//						.append("DG_QTY:"+JSPUtil.getNull(rowSet.getString("DG_QTY"))+"\n")
//						.append("DG_QUNIT:"+JSPUtil.getNull(rowSet.getString("DG_QUNIT"))+"\n")
//						.append("DG_WEIGHT:"+JSPUtil.getNull(rowSet.getString("DG_WEIGHT"))+"\n")
//						.append("DG_WUNIT:"+JSPUtil.getNull(rowSet.getString("DG_WUNIT"))+"\n")
//						.append("DG_FLASHTEMP:"+JSPUtil.getNull(rowSet.getString("DG_FLASHTEMP"))+"\n")
//						.append("DG_TEL:"+JSPUtil.getNull(rowSet.getString("DG_TEL"))+"\n")
//						.append("}DG\n");
//					}								
					
					// 20100716 dg 관련 수정 S---------------------------------------------------
					param.put("dgBkgNo", rowSet.getString("DG_BKG_NO"));
					velParam.put("dgBkgNo", rowSet.getString("DG_BKG_NO"));
					
					param.put("dgEqNo", rowSet.getString("DG_EQ_NO"));
					velParam.put("dgEqNo", rowSet.getString("DG_EQ_NO"));
					dbRowset = dbDao.search03SubUSA404EDIStatusSend(param, velParam);
					log.debug("DG dbRowset.getRowCount() :"+dbRowset.getRowCount());
					if (dbRowset.getRowCount() > 0) {
						while(dbRowset.next()){
							eb5.append("{DG\n")					
							.append("DG_STCC:"+JSPUtil.getNull(dbRowset.getString("DG_STCC"))+"\n")
							.append("DG_UN:"+JSPUtil.getNull(dbRowset.getString("DG_UN"))+"\n")
							.append("DG_NAME:"+JSPUtil.getNull(dbRowset.getString("DG_NAME"))+"\n")
							.append("DG_CONTENTS:"+JSPUtil.getNull(dbRowset.getString("DG_CONTENTS"))+"\n")
							.append("DG_CLASS:"+JSPUtil.getNull(dbRowset.getString("DG_CLASS"))+"\n")
							.append("DG_PGRP:"+JSPUtil.getNull(dbRowset.getString("DG_PGRP"))+"\n")
							.append("DG_PSAGRP:"+JSPUtil.getNull(dbRowset.getString("DG_PSAGRP"))+"\n")
							.append("DG_MP:"+JSPUtil.getNull(dbRowset.getString("DG_MP"))+"\n")
							.append("DG_FLSHTEMP:"+JSPUtil.getNull(dbRowset.getString("DG_FLSHTEMP"))+"\n")
							.append("DG_FLSHUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_FLSHUNIT"))+"\n")
							.append("DG_QTY:"+JSPUtil.getNull(dbRowset.getString("DG_QTY"))+"\n")
							.append("DG_QUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_QUNIT"))+"\n")
							.append("DG_WEIGHT:"+JSPUtil.getNull(dbRowset.getString("DG_WEIGHT"))+"\n")
							.append("DG_WUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_WUNIT"))+"\n")
							.append("DG_FLASHTEMP:"+JSPUtil.getNull(dbRowset.getString("DG_FLASHTEMP"))+"\n")
							.append("DG_CLASS1NEW:"+JSPUtil.getNull(dbRowset.getString("DG_CLASS1NEW"))+"\n")
							.append("DG_CLASS1NEWUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_CLASS1NEWUNIT"))+"\n")
							.append("DG_TEL:"+JSPUtil.getNull(dbRowset.getString("DG_TEL"))+"\n")
							.append("DG_CONTACT:"+JSPUtil.getNull(dbRowset.getString("DG_CONTACT"))+"\n")
							.append("}DG\n");
					    }						
					} else {
						eb5.append("{DG\n")
						.append("DG_STCC:"+"\n")
						.append("DG_UN:"+"\n")
						.append("DG_NAME:"+"\n")
						.append("DG_CONTENTS:"+"\n")
						.append("DG_CLASS:"+"\n")
						.append("DG_PGRP:"+"\n")
						.append("DG_PSAGRP:"+"\n")
						.append("DG_MP:"+"\n")
						.append("DG_FLSHTEMP:"+"\n")
						.append("DG_FLSHUNIT:"+"\n")
						.append("DG_QTY:"+"\n")
						.append("DG_QUNIT:"+"\n")
						.append("DG_WEIGHT:"+"\n")
						.append("DG_WUNIT:"+"\n")
						.append("DG_FLASHTEMP:"+"\n")
						.append("DG_CLASS1NEW:"+"\n")
						.append("DG_CLASS1NEWUNIT:"+"\n")
						.append("DG_TEL:"+"\n")
						.append("DG_CONTACT:"+"\n")
						.append("}DG\n");
					}

					// 20100716 dg 관련 수정 E---------------------------------------------------
					
					// 2008.01.04 추가 EDI FLATFILE 수정. SANGROG LEE. MULTI BL_NO 관련
					// 2012.11.26 MULTI BL_NO 5개가 Max였기만 쿼리문에서 100개로 늘림
					String mbl_no = JSPUtil.getNull(rowSet.getString("BL_NO1"));
					if( !mbl_no.equals("") ) {
						eb5.append(mbl_no+"\n");
					}
					eb5.append("}CNTR\n");

					String ediVndr = eh.toString() + "APPRECV_C:"+sVndrEdi+"\n" + eb.toString() + vndrCredit.toString() + eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					String ediMtc  = "";
					String ediMaha = "";
					String ediPtxx = "";
					String ediVitusbrail = "";
					String ediSsofa = "";
					String ediIts = "";
					String ediMtclax = "";
					String ediMtcla = ""; //CHM-201325385 [TRS] 404 EDI terminal setup
					String ediEtslax = ""; //CHM-201538922 RailBilling EDI (404 & 998) 중복 생성 요청
					String ediMtchan = "";
					String ediMtchanint = "";
					String edi3105488232 = "";
					String ediNwcs310 = "";
					if( !sAppMtc.equals("") ) {
						ediMtc  = eh.toString() + "APPRECV_C:"+sAppMtc+"\n" + eb.toString() + mtcCredit.toString() + eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppMahaEdi.equals("") ) {
						ediMaha = eh.toString() + "APPRECV_C:"+sAppMahaEdi+"\n" + eb.toString() + vndrCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppPtxx.equals("") ) {
						ediPtxx = eh.toString() + "APPRECV_C:"+sAppPtxx+"\n" + eb.toString() + vndrCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppVitusbrail.equals("") ) {
						ediVitusbrail = eh.toString() + "APPRECV_C:"+sAppVitusbrail+"\n" + eb.toString() + vndrCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppSsofa.equals("") ) {
						ediSsofa = eh.toString() + "APPRECV_C:"+sAppSsofa+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppIts.equals("") ) {
						ediIts = eh.toString() + "APPRECV_C:"+sAppIts+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppMtclax.equals("") ) {
						ediMtclax = eh.toString() + "APPRECV_C:"+sAppMtclax+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppMtcla.equals("") ) { //CHM-201325385 [TRS] 404 EDI terminal setup
						ediMtcla = eh.toString() + "APPRECV_C:"+sAppMtcla+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppEtslax.equals("") ) { //CHM-201538922 RailBilling EDI (404 & 998) 중복 생성 요청
						ediEtslax = eh.toString() + "APPRECV_C:"+sAppEtslax+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppMtchan.equals("") ) {
						ediMtchan = eh.toString() + "APPRECV_C:"+sAppMtchan+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppMtchanint.equals("") ) {
						ediMtchanint = eh.toString() + "APPRECV_C:"+sAppMtchanint+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sApp3105488232.equals("") ) {
						edi3105488232 = eh.toString() + "APPRECV_C:"+sApp3105488232+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppNwcs310.equals("") ) {
						ediNwcs310 = eh.toString() + "APPRECV_C:"+sAppNwcs310+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}

					// log.info("\n SQL :" + ediVndr.toString());

					// Localhost Test
					if("".equals(rowSet.getString("DG_UN")) || (!"".equals(rowSet.getString("DG_UN")) && !"CPRS".equals(sVndrEdi)) 
							|| (!"".equals(rowSet.getString("DG_UN")) && "CPRS".equals(sVndrEdi) && "USDETR5".equals(rowSet.getString("ORGYD")))){
						if( i == 1 || sVndrEdi.equals(sVndrEdi2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
							sb_send.append(ediVndr);
							if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
								usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send.toString());
							}
						} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
							usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send.toString());							

							//send data delete.
							sb_send.delete(0, sb_send.length());							

							//put data
							sb_send.append(ediVndr);							
							if( rowSet.getRowCount() == i ) {
								usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send.toString());								
							}
						}						
					}			
					
					if( i == 1 || sAppMahaEdi.equals(sAppMahaEdi2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_maha.append(ediMaha);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.							
							if( sb_send_maha.length() > 100 ) usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_maha.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.						
						if( sb_send_maha.length() > 100 ) usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_maha.toString());

						//send data delete.						
						sb_send_maha.delete(0, sb_send_maha.length());

						//put data						
						sb_send_maha.append(ediMaha);
						if( rowSet.getRowCount() == i ) {							
							if( sb_send_maha.length() > 100 ) usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_maha.toString());
						}
					}		

					// terminal
					if( i == 1 || sAppMtc.equals(sAppMtc2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_mtc.append(ediMtc);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_mtc.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtc.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_mtc.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtc.toString());
						//send data delete.
						sb_send_mtc.delete(0, sb_send_mtc.length());

						//put data
						sb_send_mtc.append(ediMtc);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_mtc.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtc.toString());
						}
					}
					
					// PTXX
					if( !"".equals(sAppPtxx) ) {   // 모두 merge
						sb_send_ptxx.append(ediPtxx);
					}
					
					if( rowSet.getRowCount() == i && sb_send_ptxx.length() > 100) {   //마지막 Row에 닿으면 Merge 된 data 를 edi send.
						usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_ptxx.toString());
					}
					
					// VITUSBRAIL
					if( !"".equals(sAppVitusbrail) ) {   // 모두 merge
						sb_send_vitusbrail.append(ediVitusbrail);
					}
					
					if( rowSet.getRowCount() == i && sb_send_vitusbrail.length() > 100) {   //마지막 Row에 닿으면 Merge 된 data 를 edi send.
						usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_vitusbrail.toString());
					}
					
					// SSOFA
					if( i == 1 || sAppSsofa.equals(sAppSsofa2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_ssofa.append(ediSsofa);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_ssofa.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_ssofa.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_ssofa.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_ssofa.toString());
						//send data delete.
						sb_send_ssofa.delete(0, sb_send_ssofa.length());

						//put data
						sb_send_ssofa.append(ediSsofa);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_ssofa.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_ssofa.toString());
						}
					}
					
					// ITS
					if( i == 1 || sAppIts.equals(sAppIts2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_its.append(ediIts);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_its.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_its.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_its.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_its.toString());
						//send data delete.
						sb_send_its.delete(0, sb_send_its.length());

						//put data
						sb_send_its.append(ediIts);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_its.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_its.toString());
						}
					}
					
					// MTCLAX
					if( i == 1 || sAppMtclax.equals(sAppMtclax2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_mtclax.append(ediMtclax);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_mtclax.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtclax.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_mtclax.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtclax.toString());
						//send data delete.
						sb_send_mtclax.delete(0, sb_send_mtclax.length());

						//put data
						sb_send_mtclax.append(ediMtclax);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_mtclax.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtclax.toString());
						}
					}
					
					// CHM-201325385 [TRS] 404 EDI terminal setup					
					log.error("\n [MTCLA] - bbbbb  \n");
					// MTCLA
					if( i == 1 || sAppMtcla.equals(sAppMtcla2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						log.error("\n [MTCLA] - 1  \n");
						sb_send_mtcla.append(ediMtcla);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_mtcla.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtcla.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						log.error("\n [MTCLA] - 2  \n");
						if( sb_send_mtcla.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtcla.toString());
						//send data delete.
						sb_send_mtcla.delete(0, sb_send_mtcla.length());

						//put data
						sb_send_mtcla.append(ediMtcla);
						if( rowSet.getRowCount() == i ) {
							log.error("\n [MTCLA] - 3  \n");
							if( sb_send_mtcla.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtcla.toString());
						}
					}
					log.error("\n [MTCLA] - eeeee  \n");
						
					// CHM-201538922 RailBilling EDI (404 & 998) 중복 생성 요청		
					log.error("\n [ETSLAX] - Start  \n");
					// ETSLAX
					if( i == 1 || sAppEtslax.equals(sAppEtslax2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						log.error("\n [ETSLAX] - 1  \n");
						sb_send_etslax.append(ediEtslax);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_etslax.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_etslax.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						log.error("\n [ETSLAX] - 2  \n");
						if( sb_send_etslax.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_etslax.toString());
						//send data delete.
						sb_send_etslax.delete(0, sb_send_etslax.length());

						//put data
						sb_send_etslax.append(ediEtslax);
						if( rowSet.getRowCount() == i ) {
							log.error("\n [ETSLAX] - 3  \n");
							if( sb_send_etslax.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_etslax.toString());
						}
					}
					log.error("\n [ETSLAX] - End  \n");
					
					// MTCHANINT
					if( i == 1 || sAppMtchanint.equals(sAppMtchanint2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_mtchanint.append(ediMtchanint);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_mtchanint.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtchanint.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_mtchanint.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtchanint.toString());
						//send data delete.
						sb_send_mtchanint.delete(0, sb_send_mtchanint.length());

						//put data
						sb_send_mtchanint.append(ediMtchanint);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_mtchanint.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtchanint.toString());
						}
					}
					
					// MTCHAN
					if( i == 1 || sAppMtchan.equals(sAppMtchan2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_mtchan.append(ediMtchan);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_mtchan.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtchan.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_mtchan.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtchan.toString());
						//send data delete.
						sb_send_mtchan.delete(0, sb_send_mtchan.length());

						//put data
						sb_send_mtchan.append(ediMtchan);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_mtchan.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtchan.toString());
						}
					}
					
					
					//NWCS310 CHM-201539465 404 & 998 EDI 중복 생성 요청 (NWCS)
					if( i == 1 || sAppNwcs310.equals(sAppNwcs310_2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_nwcs310.append(ediNwcs310);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_nwcs310.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_nwcs310.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_nwcs310.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_nwcs310.toString());
						//send data delete.
						sb_send_nwcs310.delete(0, sb_send_nwcs310.length());

						//put data
						sb_send_nwcs310.append(ediNwcs310);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_nwcs310.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_nwcs310.toString());
						}
					}
					
					
					//3105488232
					if( !"".equals(sApp3105488232) ) {   // 모두 merge
						sb_send_3105488232.append(edi3105488232);
					}
					
					if( rowSet.getRowCount() == i && sb_send_3105488232.length() > 100) {   //마지막 Row에 닿으면 Merge 된 data 를 edi send.
						usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_3105488232.toString());
					}
					
					sVndrEdi2 = sVndrEdi; //EDI Data 비교
					if( !sAppMahaEdi.equals("") ) sAppMahaEdi2 = sAppMahaEdi; //EDI Data 비교
					if( !sAppMtc.equals("") ) sAppMtc2 = sAppMtc; //EDI Data 비교
					if( !sAppSsofa.equals("") ) sAppSsofa2 = sAppSsofa; //EDI Data 비교
					if( !sAppIts.equals("") ) sAppIts2 = sAppIts; //EDI Data 비교
					if( !sAppMtclax.equals("") ) sAppMtclax2 = sAppMtclax; //EDI Data 비교
					if( !sAppMtcla.equals("") ) sAppMtcla2 = sAppMtcla; //EDI Data 비교	CHM-201325385 [TRS] 404 EDI terminal setup
					if( !sAppEtslax.equals("") ) sAppEtslax2 = sAppEtslax; //EDI Data 비교	CHM-201538922 RailBilling EDI (404 & 998) 중복 생성 요청
					if( !sAppMtchanint.equals("") ) sAppMtchanint2 = sAppMtchanint; //EDI Data 비교
					if( !sAppMtchan.equals("") ) sAppMtchan2 = sAppMtchan; //EDI Data 비교
					if( !sAppNwcs310.equals("") ) sAppNwcs310_2 = sAppNwcs310; //EDI Data 비교
//					if( !sApp3105488232.equals("") ) sApp3105488232_2 = sApp3105488232; //EDI Data 비교
					
					i++;
				} //while-End
			} //if-End
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage()); 
		}	
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 조회 이벤트 처리<br>
	 * COP EDI 전
	 * 
	 * @param rowSet
	 * @exception EventException
	 */
	public void resendUS404EDIResend(DBRowSet rowSet) throws EventException {
		/*****************************************************************
		 * SEND 			vs Resend 비교
		 * --------------------------------------------------------------
		 * RAIL VENDOR		: X 	(Always)
		 * MTC				: MTC  	(EDI CC FM/TO, POL/POD에 따라)
		 * MAHERTP			: X 	(EDI CC FM/TO:'USNYCDS' Only)
		 */		

		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		/*
	     * * N200903170080 2009-03-27 [EDI] CPRS 404 EDI 보완 요청
	     * * N200905270080 [TRS]US RAIL EDI  DG CGO에 대한 Flash point 추가 전송관련 보완
	     * * N200906020130 2009-06-09 [TRS-Rail EDI] DG 정보 오전송에 따른 보완
	     */
		String sAppMahaEdi2 = "";		
		String sAppMtc2  = "";
		String sAppSsofa2  = "";
		String sAppIts2  = "";
		String sAppMtclax2  = "";
		String sAppMtcla2  = "";  //CHM-201325385 [TRS] 404 EDI terminal setup
		String sAppMtchan2  = "";
		String sAppMtchanint2  = "";
//		String sApp3105488232_2  = "";
		StringBuffer sb_send_mtc = new StringBuffer();
		StringBuffer sb_send_maha = new StringBuffer();
		StringBuffer sb_send_ptxx = new StringBuffer();
		StringBuffer sb_send_ssofa = new StringBuffer();
		StringBuffer sb_send_its = new StringBuffer();
		StringBuffer sb_send_mtclax = new StringBuffer();
		StringBuffer sb_send_mtcla = new StringBuffer();	//CHM-201325385 [TRS] 404 EDI terminal setup
		StringBuffer sb_send_mtchan = new StringBuffer();
		StringBuffer sb_send_mtchanint = new StringBuffer();
		StringBuffer sb_send_3105488232 = new StringBuffer();

		int i = 1;
		
		try {
			USA404EDIStatusInquiryEAIDAO usa404EdiStatusInquiryEai = new USA404EDIStatusInquiryEAIDAO();
			
			if( rowSet != null ) {
				while( rowSet.next() ) {
					//Insert 파라미터
					String sVndrEdi    		= JSPUtil.getNull(rowSet.getString("APPRECV_C"));
					String sAppMahaEdi 		= JSPUtil.getNull(rowSet.getString("APP_MAHA"));
					String sAppMtcEdi1 		= JSPUtil.getNull(rowSet.getString("APP_MTC1"));
					String sAppMtcEdi2 		= JSPUtil.getNull(rowSet.getString("APP_MTC2"));
					String sAppPtxx 		= JSPUtil.getNull(rowSet.getString("APP_PTXX"));
					String sRailCmb    		= JSPUtil.getNull(rowSet.getString("RAIL_CMB"));
					String sAppSsofa   		= JSPUtil.getNull(rowSet.getString("APP_SSOFA"));
					String sAppIts    		= JSPUtil.getNull(rowSet.getString("APP_ITS"));
					String sAppMtclax  		= JSPUtil.getNull(rowSet.getString("APP_MTCLAX"));
					String sAppMtcla  		= JSPUtil.getNull(rowSet.getString("APP_MTCLA")); // 2013-06-24 신규로 추가  CHM-201325385 [TRS] 404 EDI terminal setup
					String sAppMtchan  		= JSPUtil.getNull(rowSet.getString("APP_MTCHAN"));
					String sAppMtchanint    = JSPUtil.getNull(rowSet.getString("APP_MTCHANINT"));
					String sAppMtc     		= "";

					if( !sAppMtcEdi1.equals("") ) {
						sAppMtc = sAppMtcEdi1;
					} else if( !sAppMtcEdi2.equals("") ) {
						sAppMtc = sAppMtcEdi2;
					}
					String sApp3105488232    = JSPUtil.getNull(rowSet.getString("APP_3105488232"));

					/*
				     * * N200902230090 2009-03-10 [EDI] 미주 Rail 998, 404 FF 통합
				     */
					StringBuffer 	eh 			= new StringBuffer();
					eh.append("{CNTR\n");
					StringBuffer 	eb 			= new StringBuffer();
					eb.append("TYPE:"+JSPUtil.getNull(rowSet.getString("TYPE"))+"\n")
					.append("SHIPQLF_C:"		+JSPUtil.getNull(rowSet.getString("SHIPQLF_C"))+"\n")
					.append("BKGNO:"			+JSPUtil.getNull(rowSet.getString("BKGNO"))+"\n")
					.append("BLNO:"				+JSPUtil.getNull(rowSet.getString("BLNO"))+"\n")
					.append("BKG_SCNO:"			+JSPUtil.getNull(rowSet.getString("BKG_SCNO"))+"\n")
					.append("VSLCODE:"			+JSPUtil.getNull(rowSet.getString("VSLCODE"))+"\n")
					.append("VOYAGE:"			+JSPUtil.getNull(rowSet.getString("VOYAGE"))+"\n")
					.append("VSLNAME:"			+JSPUtil.getNull(rowSet.getString("VSLNAME"))+"\n")
					.append("VSLCUTOFF:"		+JSPUtil.getNull(rowSet.getString("VSLCUTOFF"))+"\n")
					.append("LLOYD:"			+JSPUtil.getNull(rowSet.getString("LLOYD"))+"\n")
					.append("HUBETA:"			+JSPUtil.getNull(rowSet.getString("HUBETA"))+"\n")
					.append("POL:"				+JSPUtil.getNull(rowSet.getString("POL"))+"\n")
					.append("POD:"				+JSPUtil.getNull(rowSet.getString("POD"))+"\n")
					.append("CONTRACT:"			+JSPUtil.getNull(rowSet.getString("CONTRACT"))+"\n");

					// MTC 일 때 CREDIT prefix 'M'
					StringBuffer 	vndrCredit 	= new StringBuffer();
					StringBuffer 	mtcCredit 	= new StringBuffer();

					vndrCredit.append("CREDIT:"	+ JSPUtil.getNull(rowSet.getString("CREDIT"))  +"\n");
					mtcCredit.append("CREDIT:"	+ JSPUtil.getNull(rowSet.getString("MTC_CREDIT")) +"\n");

					StringBuffer eb1 = new StringBuffer();
					eb1.append("IMTRANSNO:"		+JSPUtil.getNull(rowSet.getString("IMTRANSNO"))+"\n")
					.append("TRANSEXPNO:"		+JSPUtil.getNull(rowSet.getString("TRANSEXPNO"))+"\n")
					.append("DOCK:"				+JSPUtil.getNull(rowSet.getString("DOCK"))+"\n")
					.append("FFDESC:"			+JSPUtil.getNull(rowSet.getString("FFDESC"))+"\n")
					.append("EQNISTS:"			+JSPUtil.getNull(rowSet.getString("EQNISTS"))+"\n")
					.append("EQINIT:"			+JSPUtil.getNull(rowSet.getString("EQINIT"))+"\n")
					.append("EQNO:"				+JSPUtil.getNull(rowSet.getString("EQNO"))+"\n")
					.append("WGT:"				+JSPUtil.getNull(rowSet.getString("WGT"))+"\n")
					.append("EQDESC_C:"			+JSPUtil.getNull(rowSet.getString("EQDESC_C"))+"\n")
					.append("EQLTH_C:"			+JSPUtil.getNull(rowSet.getString("EQLTH_C"))+"\n")
					.append("EQCHK:"			+JSPUtil.getNull(rowSet.getString("EQCHK"))+"\n")
					.append("SEALNO:"			+JSPUtil.getNull(rowSet.getString("SEALNO"))+"\n")
					.append("SPCHAND_C:"		+JSPUtil.getNull(rowSet.getString("SPCHAND_C"))+"\n")
					.append("ILTRANS_C:"		+JSPUtil.getNull(rowSet.getString("ILTRANS_C"))+"\n")
					.append("CUSTENTTP_C:"		+JSPUtil.getNull(rowSet.getString("CUSTENTTP_C"))+"\n")
					.append("CUSTENTNO:"		+JSPUtil.getNull(rowSet.getString("CUSTENTNO"))+"\n")
					.append("CUSTTYPE:"			+JSPUtil.getNull(rowSet.getString("CUSTTYPE"))+"\n")
					.append("CUSTLOC:"			+JSPUtil.getNull(rowSet.getString("CUSTLOC"))+"\n")
					.append("CARGOWGT:"			+JSPUtil.getNull(rowSet.getString("CARGOWGT"))+"\n")
					.append("ORGCTY:"			+JSPUtil.getNull(rowSet.getString("ORGCTY"))+"\n")
					.append("ORGSTATE:"			+JSPUtil.getNull(rowSet.getString("ORGSTATE"))+"\n")
					.append("ORGLOC:"			+JSPUtil.getNull(rowSet.getString("ORGLOC"))+"\n")
					.append("ORGYD:"			+JSPUtil.getNull(rowSet.getString("ORGYD"))+"\n")
					.append("DSTCTY:"			+JSPUtil.getNull(rowSet.getString("DSTCTY"))+"\n")
					.append("DSTSTATE:"			+JSPUtil.getNull(rowSet.getString("DSTSTATE"))+"\n")
					.append("DSTLOC:"			+JSPUtil.getNull(rowSet.getString("DSTLOC"))+"\n")
					.append("DSTYD:"			+JSPUtil.getNull(rowSet.getString("DSTYD"))+"\n")
					.append("SHPR_N:"			+JSPUtil.getNull(rowSet.getString("SHPR_N"))+"\n")
					.append("SHPR_A:"			+JSPUtil.getNull(rowSet.getString("SHPR_A"))+"\n")
					.append("SHPR_C:"			+JSPUtil.getNull(rowSet.getString("SHPR_C"))+"\n")
					.append("SHPR_S:"			+JSPUtil.getNull(rowSet.getString("SHPR_S"))+"\n")
					.append("SHPR_P:"			+JSPUtil.getNull(rowSet.getString("SHPR_P"))+"\n")
					.append("SHPR_CN:"			+JSPUtil.getNull(rowSet.getString("SHPR_CN"))+"\n");

					StringBuffer eb2 = new StringBuffer(); //MTC가 아닌 경우
					eb2.append("ASHPR_CODE:"	+JSPUtil.getNull(rowSet.getString("ASHPR_CODE"))+"\n")
					.append("ASHPR_N:"			+JSPUtil.getNull(rowSet.getString("ASHPR_N"))+"\n")
					.append("ASHPR_A:"			+JSPUtil.getNull(rowSet.getString("ASHPR_A"))+"\n")
					.append("ASHPR_C:"			+JSPUtil.getNull(rowSet.getString("ASHPR_C"))+"\n")
					.append("ASHPR_S:"			+JSPUtil.getNull(rowSet.getString("ASHPR_S"))+"\n")
					.append("ASHPR_P:"			+JSPUtil.getNull(rowSet.getString("ASHPR_P"))+"\n")
					.append("ASHPR_CN:"			+JSPUtil.getNull(rowSet.getString("ASHPR_CN"))+"\n");

					StringBuffer eb2_1 = new StringBuffer(); //MTC 일경우만.
					eb2_1.append("ASHPR_CODE:\n")
					.append("ASHPR_N:\n")
					.append("ASHPR_A:\n")
					.append("ASHPR_C:\n")
					.append("ASHPR_S:\n")
					.append("ASHPR_P:\n")
					.append("ASHPR_CN:\n");

					StringBuffer eb3 = new StringBuffer();
					eb3.append("CNEE_N:"		+JSPUtil.getNull(rowSet.getString("CNEE_N"))+"\n")
					.append("CNEE_A:"			+JSPUtil.getNull(rowSet.getString("CNEE_A"))+"\n")
					.append("CNEE_C:"			+JSPUtil.getNull(rowSet.getString("CNEE_C"))+"\n")
					.append("CNEE_S:"			+JSPUtil.getNull(rowSet.getString("CNEE_S"))+"\n")
					.append("CNEE_P:"			+JSPUtil.getNull(rowSet.getString("CNEE_P"))+"\n")
					.append("CNEE_CN:"			+JSPUtil.getNull(rowSet.getString("CNEE_CN"))+"\n")
					.append("NTFY_N:"			+JSPUtil.getNull(rowSet.getString("NTFY_N"))+"\n")
					.append("NTFY_T:"			+JSPUtil.getNull(rowSet.getString("NTFY_T"))+"\n")
					.append("CARE_N:"			+JSPUtil.getNull(rowSet.getString("CARE_N"))+"\n")
					.append("CARE_A:"			+JSPUtil.getNull(rowSet.getString("CARE_A"))+"\n")
					.append("CARE_C:"			+JSPUtil.getNull(rowSet.getString("CARE_C"))+"\n")
					.append("CARE_S:"			+JSPUtil.getNull(rowSet.getString("CARE_S"))+"\n")
					.append("CARE_P:"			+JSPUtil.getNull(rowSet.getString("CARE_P"))+"\n")
					.append("CARE_CN:"			+JSPUtil.getNull(rowSet.getString("CARE_CN"))+"\n")
					.append("BILL_N:"			+JSPUtil.getNull(rowSet.getString("BILL_N"))+"\n")
					.append("BILL_A:"			+JSPUtil.getNull(rowSet.getString("BILL_A"))+"\n")
					.append("BILL_C:"			+JSPUtil.getNull(rowSet.getString("BILL_C"))+"\n")
					.append("BILL_S:"			+JSPUtil.getNull(rowSet.getString("BILL_S"))+"\n")
					.append("BILL_P:"			+JSPUtil.getNull(rowSet.getString("BILL_P"))+"\n")
					.append("BILL_CN:"			+JSPUtil.getNull(rowSet.getString("BILL_CN"))+"\n")
					.append("UTCN_CODE:"		+JSPUtil.getNull(rowSet.getString("UTCN_CODE"))+"\n")					
					.append("UTCN_N:"			+JSPUtil.getNull(rowSet.getString("UTCN_N"))+"\n");

					StringBuffer eb4 = new StringBuffer(); //MTC가 아닌 경우
					eb4.append("UTCN_A:"			+JSPUtil.getNull(rowSet.getString("UTCN_A"))+"\n")
					.append("UTCN_C:"			+JSPUtil.getNull(rowSet.getString("UTCN_C"))+"\n")
					.append("UTCN_S:"			+JSPUtil.getNull(rowSet.getString("UTCN_S"))+"\n")
					.append("UTCN_P:"			+JSPUtil.getNull(rowSet.getString("UTCN_P"))+"\n")
					.append("UTCN_CN:"			+JSPUtil.getNull(rowSet.getString("UTCN_CN"))+"\n");

					StringBuffer eb4_1 = new StringBuffer();  //MTC 일경우만.
					eb4_1.append("UTCN_A:\n")
					.append("UTCN_C:\n")
					.append("UTCN_S:\n")
					.append("UTCN_P:\n")
					.append("UTCN_CN:\n");

					StringBuffer eb5 = new StringBuffer();
					eb5.append("RECV_N:"		+JSPUtil.getNull(rowSet.getString("RECV_N"))+"\n")
					.append("RECV_A:"			+JSPUtil.getNull(rowSet.getString("RECV_A"))+"\n")
					.append("RECV_C:"			+JSPUtil.getNull(rowSet.getString("RECV_C"))+"\n")
					.append("RECV_S:"			+JSPUtil.getNull(rowSet.getString("RECV_S"))+"\n")
					.append("RECV_P:"			+JSPUtil.getNull(rowSet.getString("RECV_P"))+"\n")
					.append("RECV_CN:"			+JSPUtil.getNull(rowSet.getString("RECV_CN"))+"\n")
					.append("ADMC_C:"			+JSPUtil.getNull(rowSet.getString("ADMC_C"))+"\n")
					.append("FDA_IND:"			+JSPUtil.getNull(rowSet.getString("FDA_IND"))+"\n")
					.append("CUST_F:"			+JSPUtil.getNull(rowSet.getString("CUST_F"))+"\n")
					.append("CUST_E:"			+JSPUtil.getNull(rowSet.getString("CUST_E"))+"\n")
					.append("TEMP:"				+JSPUtil.getNull(rowSet.getString("TEMP"))+"\n")
					.append("TUN:"				+JSPUtil.getNull(rowSet.getString("TUN"))+"\n")
					.append("VENT:"				+JSPUtil.getNull(rowSet.getString("VENT"))+"\n")
					.append("HUMID:"			+JSPUtil.getNull(rowSet.getString("HUMID"))+"\n")
					.append("GENSET:"			+JSPUtil.getNull(rowSet.getString("GENSET"))+"\n")
					.append("{REF\n")
					.append("REFID:"			+JSPUtil.getNull(rowSet.getString("REFID"))+"\n")
					.append("REFVAL:"			+JSPUtil.getNull(rowSet.getString("REFVAL"))+"\n")
					.append("}REF\n");

					/*
					 * N200906100030 2009-06-15 [EDI-TRS/Dom. EDI-404] Rail Interchage에 대한 Contract no 보완
					 */
					if( sRailCmb.equals("C1T") || sRailCmb.equals("S2R") || sRailCmb.equals("S3R") ) {
						eb5.append("{ROUTE\n")
						.append("ROUTCARR:"		+JSPUtil.getNull(rowSet.getString("ROUTCARR"))+"\n")
						.append("ROUTSEQ:"		+JSPUtil.getNull(rowSet.getString("ROUTSEQ"))+"\n")
						.append("ROUTCITY:"		+JSPUtil.getNull(rowSet.getString("ROUTCITY"))+"\n")
						.append("INTMOSVR:"		+JSPUtil.getNull(rowSet.getString("INTMOSVR"))+"\n")
						.append("TRANSTP:"		+JSPUtil.getNull(rowSet.getString("TRANSTP"))+"\n")
						.append("TOYD:"			+JSPUtil.getNull(rowSet.getString("TO_YARD_CD"))+"\n")
						.append("CONTRACT:"		+JSPUtil.getNull(rowSet.getString("CONTRACT"))+"\n")
						.append("}ROUTE\n");
					} else {
						eb5.append("{ROUTE\n")
						.append("ROUTCARR:"		+JSPUtil.getNull(rowSet.getString("ROUTCARR"))+"\n")
						.append("ROUTSEQ:"		+JSPUtil.getNull(rowSet.getString("ROUTSEQ"))+"\n")
						.append("ROUTCITY:"		+JSPUtil.getNull(rowSet.getString("ROUTCITY"))+"\n")
						.append("INTMOSVR:"		+JSPUtil.getNull(rowSet.getString("INTMOSVR"))+"\n")
						.append("TRANSTP:"		+JSPUtil.getNull(rowSet.getString("TRANSTP"))+"\n")
						.append("TOYD:"			+JSPUtil.getNull(rowSet.getString("TO_YARD_CD"))+"\n")
						.append("CONTRACT:"		+JSPUtil.getNull(rowSet.getString("CONTRACT"))+"\n")
						.append("}ROUTE\n")
						.append("{ROUTE\n")
						.append("ROUTCARR:"		+JSPUtil.getNull(rowSet.getString("ROUTCARR2"))+"\n")
						.append("ROUTSEQ:"		+JSPUtil.getNull(rowSet.getString("ROUTSEQ2"))+"\n")
						.append("ROUTCITY:"		+JSPUtil.getNull(rowSet.getString("ROUTCITY2"))+"\n")
						.append("INTMOSVR:"		+JSPUtil.getNull(rowSet.getString("INTMOSVR2"))+"\n")
						.append("TRANSTP:"		+JSPUtil.getNull(rowSet.getString("TRANSTP2"))+"\n")
						.append("TOYD:"			+JSPUtil.getNull(rowSet.getString("TO_YARD_CD2"))+"\n")
						.append("CONTRACT:"		+JSPUtil.getNull(rowSet.getString("CONTRACT2"))+"\n")
						.append("}ROUTE\n");

						if( sRailCmb.equals("C3T") || sRailCmb.equals("C3R") || sRailCmb.equals("C3S") ) {
							eb5.append("{ROUTE\n")
							.append("ROUTCARR:"	+JSPUtil.getNull(rowSet.getString("ROUTCARR3"))+"\n")
							.append("ROUTSEQ:"	+JSPUtil.getNull(rowSet.getString("ROUTSEQ3"))+"\n")
							.append("ROUTCITY:"	+JSPUtil.getNull(rowSet.getString("ROUTCITY3"))+"\n")
							.append("INTMOSVR:"	+JSPUtil.getNull(rowSet.getString("INTMOSVR3"))+"\n")
							.append("TRANSTP:"	+JSPUtil.getNull(rowSet.getString("TRANSTP3"))+"\n")
							.append("TOYD:"		+JSPUtil.getNull(rowSet.getString("TO_YARD_CD3"))+"\n")
							.append("CONTRACT:"		+JSPUtil.getNull(rowSet.getString("CONTRACT3"))+"\n")
							.append("}ROUTE\n");
						}
					}

					eb5.append("INBOND:"		+JSPUtil.getNull(rowSet.getString("INBOND"))+"\n")
					.append("{LADE\n")
					.append("LADELINE:"			+JSPUtil.getNull(rowSet.getString("LADELINE1"))+"\n")
					.append("LADEDESC:"			+JSPUtil.getNull(rowSet.getString("LADEDESC1"))+"\n")
					.append("COMMCODE:"			+JSPUtil.getNull(rowSet.getString("COMMCODE1"))+"\n")
					.append("NISCOMM:"			+JSPUtil.getNull(rowSet.getString("NISCOMM1"))+"\n")
					.append("NISREP:"			+JSPUtil.getNull(rowSet.getString("NISRETP1"))+"\n")
					.append("}LADE\n");
					String slade_line = JSPUtil.getNull(rowSet.getString("LADELINE2")); //이 값이 있으면, OK

					if( !slade_line.equals("") ) {
						eb5.append("{LADE\n")
						.append("LADELINE:"		+slade_line+"\n")
						.append("LADEDESC:"		+JSPUtil.getNull(rowSet.getString("LADEDESC2"))+"\n")
						.append("COMMCODE:"		+JSPUtil.getNull(rowSet.getString("COMMCODE2"))+"\n")
						.append("NISCOMM:"		+JSPUtil.getNull(rowSet.getString("NISCOMM2"))+"\n")
						.append("NISREP:"		+JSPUtil.getNull(rowSet.getString("NISRETP2"))+"\n")
						.append("}LADE\n");
					}
					slade_line = JSPUtil.getNull(rowSet.getString("LADELINE3"));
					if( !slade_line.equals("") ) {
						eb5.append("{LADE\n")
						.append("LADELINE:"		+slade_line+"\n")
						.append("LADEDESC:"		+JSPUtil.getNull(rowSet.getString("LADEDESC3"))+"\n")
						.append("COMMCODE:"		+JSPUtil.getNull(rowSet.getString("COMMCODE3"))+"\n")
						.append("NISCOMM:"		+JSPUtil.getNull(rowSet.getString("NISCOMM3"))+"\n")
						.append("NISREP:"		+JSPUtil.getNull(rowSet.getString("NISRETP3"))+"\n")
						.append("}LADE\n");
					}
					slade_line = JSPUtil.getNull(rowSet.getString("LADELINE4"));
					if( !slade_line.equals("") ) {
						eb5.append("{LADE\n")
						.append("LADELINE:"		+slade_line+"\n")
						.append("LADEDESC:"		+JSPUtil.getNull(rowSet.getString("LADEDESC4"))+"\n")
						.append("COMMCODE:"		+JSPUtil.getNull(rowSet.getString("COMMCODE4"))+"\n")
						.append("NISCOMM:"		+JSPUtil.getNull(rowSet.getString("NISCOMM4"))+"\n")
						.append("NISREP:"		+JSPUtil.getNull(rowSet.getString("NISRETP4"))+"\n")
						.append("}LADE\n");
					}
					slade_line = JSPUtil.getNull(rowSet.getString("LADELINE5"));
					if( !slade_line.equals("") ) {
						eb5.append("{LADE\n")
						.append("LADELINE:"		+slade_line+"\n")
						.append("LADEDESC:"		+JSPUtil.getNull(rowSet.getString("LADEDESC5"))+"\n")
						.append("COMMCODE:"		+JSPUtil.getNull(rowSet.getString("COMMCODE5"))+"\n")
						.append("NISCOMM:"		+JSPUtil.getNull(rowSet.getString("NISCOMM5"))+"\n")
						.append("NISREP:"		+JSPUtil.getNull(rowSet.getString("NISRETP5"))+"\n")
						.append("}LADE\n");
					}
					/*
					 * * N200904030180 2009-04-15 [TRS_Rail EDI] DG 관련 항목 추가 및 Shipper 정보 누락관련 보완요청
					 */
					eb5.append("LADEQTY:"		+JSPUtil.getNull(rowSet.getString("LADEQTY"))+"\n")
					.append("PACKFORM:"			+JSPUtil.getNull(rowSet.getString("PACKFORM"))+"\n");
					
					if("2".equals(rowSet.getString("DG_MAX_SEQ"))){
						param.put("dgBkgNo", rowSet.getString("DG_BKG_NO"));
						velParam.put("dgBkgNo", rowSet.getString("DG_BKG_NO"));
						
						param.put("dgEqNo", rowSet.getString("DG_EQ_NO"));
						velParam.put("dgEqNo", rowSet.getString("DG_EQ_NO"));
						
						dbRowset = dbDao.resendUS404EDIResend(param, velParam);	
						
						while(dbRowset.next()){
							eb5.append("{DG\n")
							.append("DG_STCC:"+JSPUtil.getNull(dbRowset.getString("DG_STCC"))+"\n")
							.append("DG_UN:"+JSPUtil.getNull(dbRowset.getString("DG_UN"))+"\n")
							.append("DG_NAME:"+JSPUtil.getNull(dbRowset.getString("DG_NAME"))+"\n")
							.append("DG_CONTENTS:"+JSPUtil.getNull(dbRowset.getString("DG_CONTENTS"))+"\n")
							.append("DG_CLASS:"+JSPUtil.getNull(dbRowset.getString("DG_CLASS"))+"\n")
							.append("DG_PGRP:"+JSPUtil.getNull(dbRowset.getString("DG_PGRP"))+"\n")
							.append("DG_PSAGRP:"+JSPUtil.getNull(dbRowset.getString("DG_PSAGRP"))+"\n")
							.append("DG_MP:"+JSPUtil.getNull(dbRowset.getString("DG_MP"))+"\n")
							.append("DG_FLSHTEMP:"+JSPUtil.getNull(dbRowset.getString("DG_FLSHTEMP"))+"\n")
							.append("DG_FLSHUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_FLSHUNIT"))+"\n")
							.append("DG_QTY:"+JSPUtil.getNull(dbRowset.getString("DG_QTY"))+"\n")
							.append("DG_QUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_QUNIT"))+"\n")
							.append("DG_WEIGHT:"+JSPUtil.getNull(dbRowset.getString("DG_WEIGHT"))+"\n")
							.append("DG_WUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_WUNIT"))+"\n")
							.append("DG_FLASHTEMP:"+JSPUtil.getNull(dbRowset.getString("DG_FLASHTEMP"))+"\n")
							.append("DG_TEL:"+JSPUtil.getNull(dbRowset.getString("DG_TEL"))+"\n")
							.append("DG_CONTACT:"+JSPUtil.getNull(dbRowset.getString("DG_CONTACT"))+"\n")
							.append("}DG\n");
						}
					}else{
						eb5.append("{DG\n")
						.append("DG_STCC:"			+JSPUtil.getNull(rowSet.getString("DG_STCC"))+"\n")
						.append("DG_UN:"			+JSPUtil.getNull(rowSet.getString("DG_UN"))+"\n")
						.append("DG_NAME:"			+JSPUtil.getNull(rowSet.getString("DG_NAME"))+"\n")
						.append("DG_CONTENTS:"		+JSPUtil.getNull(rowSet.getString("DG_CONTENTS"))+"\n")
						.append("DG_CLASS:"			+JSPUtil.getNull(rowSet.getString("DG_CLASS"))+"\n")
						.append("DG_PGRP:"			+JSPUtil.getNull(rowSet.getString("DG_PGRP"))+"\n")
						.append("DG_PSAGRP:"		+JSPUtil.getNull(rowSet.getString("DG_PSAGRP"))+"\n")
						.append("DG_MP:"			+JSPUtil.getNull(rowSet.getString("DG_MP"))+"\n")
						.append("DG_FLSHTEMP:"		+JSPUtil.getNull(rowSet.getString("DG_FLSHTEMP"))+"\n")
						.append("DG_FLSHUNIT:"		+JSPUtil.getNull(rowSet.getString("DG_FLSHUNIT"))+"\n")
						.append("DG_QTY:"			+JSPUtil.getNull(rowSet.getString("DG_QTY"))+"\n")
						.append("DG_QUNIT:"			+JSPUtil.getNull(rowSet.getString("DG_QUNIT"))+"\n")
						.append("DG_WEIGHT:"		+JSPUtil.getNull(rowSet.getString("DG_WEIGHT"))+"\n")
						.append("DG_WUNIT:"			+JSPUtil.getNull(rowSet.getString("DG_WUNIT"))+"\n")
						.append("DG_FLASHTEMP:"		+JSPUtil.getNull(rowSet.getString("DG_FLASHTEMP"))+"\n")
						.append("DG_TEL:"			+JSPUtil.getNull(rowSet.getString("DG_TEL"))+"\n")
						.append("DG_CONTACT:"		+JSPUtil.getNull(rowSet.getString("DG_CONTACT"))+"\n")
						.append("}DG\n");						
					}

					// 2008.01.04 추가 EDI FLATFILE 수정. SANGROG LEE. MULTI BL_NO 관련
					// 2012.11.26 MULTI BL_NO 5개가 Max였기만 쿼리문에서 100개로 늘림
					String mbl_no = JSPUtil.getNull(rowSet.getString("BL_NO1"));
					if( !mbl_no.equals("") ) {
						eb5.append(mbl_no+"\n");
					}
					eb5.append("}CNTR\n");

					String ediMtc  = "";
					String ediMaha = "";
					String ediPtxx = "";
					String ediSsofa = "";
					String ediIts = "";
					String ediMtclax = "";
					String ediMtcla = ""; //CHM-201325385 [TRS] 404 EDI terminal setup
					String ediMtchan = "";
					String ediMtchanint = "";
					String edi3105488232 = "";
					if( !sAppMtc.equals("") ) {
						ediMtc  = eh.toString() + "APPRECV_C:"+sAppMtc+"\n" + eb.toString() + mtcCredit.toString() + eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppMahaEdi.equals("") ) {
						ediMaha = eh.toString() + "APPRECV_C:"+sAppMahaEdi+"\n" + eb.toString() + vndrCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppPtxx.equals("") ) {
						ediPtxx = eh.toString() + "APPRECV_C:"+sAppPtxx+"\n" + eb.toString() + vndrCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppSsofa.equals("") ) {
						ediSsofa = eh.toString() + "APPRECV_C:"+sAppSsofa+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppIts.equals("") ) {
						ediIts = eh.toString() + "APPRECV_C:"+sAppIts+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppMtclax.equals("") ) {
						ediMtclax = eh.toString() + "APPRECV_C:"+sAppMtclax+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					//CHM-201325385 [TRS] 404 EDI terminal setup
					if( !sAppMtcla.equals("") ) {
						ediMtcla = eh.toString() + "APPRECV_C:"+sAppMtcla+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppMtchan.equals("") ) {
						ediMtchan = eh.toString() + "APPRECV_C:"+sAppMtchan+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sAppMtchanint.equals("") ) {
						ediMtchanint = eh.toString() + "APPRECV_C:"+sAppMtchanint+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					if( !sApp3105488232.equals("") ) {
						edi3105488232 = eh.toString() + "APPRECV_C:"+sApp3105488232+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString();
					}
					



					// Localhost Test
					if("".equals(rowSet.getString("DG_UN")) || (!"".equals(rowSet.getString("DG_UN")) && !"CPRS".equals(sVndrEdi)) 
							|| (!"".equals(rowSet.getString("DG_UN")) && "CPRS".equals(sVndrEdi) && "USDETR5".equals(rowSet.getString("ORGYD")))){
						if( i == 1 || sAppMahaEdi.equals(sAppMahaEdi2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
							sb_send_maha.append(ediMaha);
							if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
								if( sb_send_maha.length() > 100 ) usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_maha.toString());
							}
						} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
							if( sb_send_maha.length() > 100 ) usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_maha.toString());

							//send data delete.
							sb_send_maha.delete(0, sb_send_maha.length());

							//put data
							sb_send_maha.append(ediMaha);
							if( rowSet.getRowCount() == i ) {
								if( sb_send_maha.length() > 100 ) usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_maha.toString());
							}
						}					
					}	

					// terminal
					if( i == 1 || sAppMtc.equals(sAppMtc2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_mtc.append(ediMtc);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_mtc.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtc.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_mtc.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtc.toString());
						//send data delete.
						sb_send_mtc.delete(0, sb_send_mtc.length());

						//put data
						sb_send_mtc.append(ediMtc);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_mtc.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtc.toString());
						}
					}
					
					// PTXX
					if( !"".equals(sAppPtxx) ) {   // 모두 merge
						sb_send_ptxx.append(ediPtxx);
					}
					
					if( rowSet.getRowCount() == i && sb_send_ptxx.length() > 100) {   //마지막 Row에 닿으면 Merge 된 data 를 edi send.
						usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_ptxx.toString());
					}
					
					// SSOFA
					if( i == 1 || sAppSsofa.equals(sAppSsofa2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_ssofa.append(ediSsofa);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_ssofa.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_ssofa.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_ssofa.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_ssofa.toString());
						//send data delete.
						sb_send_ssofa.delete(0, sb_send_ssofa.length());

						//put data
						sb_send_ssofa.append(ediSsofa);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_ssofa.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_ssofa.toString());
						}
					}
					
					// ITS
					if( i == 1 || sAppIts.equals(sAppIts2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_its.append(ediIts);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_its.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_its.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_its.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_its.toString());
						//send data delete.
						sb_send_its.delete(0, sb_send_its.length());

						//put data
						sb_send_its.append(ediIts);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_its.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_its.toString());
						}
					}
					
					// MTCLAX
					if( i == 1 || sAppMtclax.equals(sAppMtclax2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_mtclax.append(ediMtclax);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_mtclax.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtclax.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_mtclax.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtclax.toString());
						//send data delete.
						sb_send_mtclax.delete(0, sb_send_mtclax.length());

						//put data
						sb_send_mtclax.append(ediMtclax);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_mtclax.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtclax.toString());
						}
					}
					//CHM-201325385 [TRS] 404 EDI terminal setup
					// MTCLA
					if( i == 1 || sAppMtcla.equals(sAppMtcla2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_mtcla.append(ediMtcla);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_mtcla.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtcla.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_mtcla.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtcla.toString());
						//send data delete.
						sb_send_mtcla.delete(0, sb_send_mtcla.length());

						//put data
						sb_send_mtcla.append(ediMtcla);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_mtcla.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtcla.toString());
						}
					}
					
					// MTCHANINT
					if( i == 1 || sAppMtchanint.equals(sAppMtchanint2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_mtchanint.append(ediMtchanint);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_mtchanint.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtchanint.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_mtchanint.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtchanint.toString());
						//send data delete.
						sb_send_mtchanint.delete(0, sb_send_mtchanint.length());

						//put data
						sb_send_mtchanint.append(ediMtchanint);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_mtchanint.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtchanint.toString());
						}
					}
					
					// MTCHAN
					if( i == 1 || sAppMtchan.equals(sAppMtchan2) ) {   // VNDREDI 가 같으면 한 FlatFile 로 merge 시켜서 전송하므로, IF 로 분기
						sb_send_mtchan.append(ediMtchan);
						if( rowSet.getRowCount() == 1 || rowSet.getRowCount() == i ) {   // 1개 Row 만 edi send 할 경우거나, 마지막 Row 에 닿으면 Merge 된 data 를 edi send.
							if( sb_send_mtchan.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtchan.toString());
						}
					} else {   //  VNDREDI 가 달라지면, 바로바로 EDI SEND 로직 태움.
						if( sb_send_mtchan.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtchan.toString());
						//send data delete.
						sb_send_mtchan.delete(0, sb_send_mtchan.length());

						//put data
						sb_send_mtchan.append(ediMtchan);
						if( rowSet.getRowCount() == i ) {
							if( sb_send_mtchan.length() > 100 )     usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_mtchan.toString());
						}
					}
					
					//3105488232
					if( !"".equals(sApp3105488232) ) {   // 모두 merge
						sb_send_3105488232.append(edi3105488232);
					}
					
					if( rowSet.getRowCount() == i && sb_send_3105488232.length() > 100) {   //마지막 Row에 닿으면 Merge 된 data 를 edi send.
						usa404EdiStatusInquiryEai.return404EDIsent("IFNIS2EDI!RAILO!\n"+sb_send_3105488232.toString());
					}
					

					if( !sAppMahaEdi.equals("") ) sAppMahaEdi2 = sAppMahaEdi; //EDI Data 비교
					if( !sAppMtc.equals("") ) sAppMtc2 = sAppMtc; //EDI Data 비교
					if( !sAppSsofa.equals("") ) sAppSsofa2 = sAppSsofa; //EDI Data 비교
					if( !sAppIts.equals("") ) sAppIts2 = sAppIts; //EDI Data 비교
					if( !sAppMtclax.equals("") ) sAppMtclax2 = sAppMtclax; //EDI Data 비교
					if( !sAppMtcla.equals("") ) sAppMtcla2 = sAppMtcla; //EDI Data 비교 CHM-201325385 [TRS] 404 EDI terminal setup
					if( !sAppMtchanint.equals("") ) sAppMtchanint2 = sAppMtchanint; //EDI Data 비교
					if( !sAppMtchan.equals("") ) sAppMtchan2 = sAppMtchan; //EDI Data 비교	
//					if( !sApp3105488232.equals("") ) sApp3105488232_2 = sApp3105488232; //EDI Data 비교

					i++;

				} //while-End

			} //if-End
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage()); 
		}	
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 조회 이벤트 처리<br>
	 * COP EDI 전
	 * 
	 * @param list
	 * @return
	 * @exception EventException
	 */
	public EventResponse search04USA404EDIStatusSend(List<Object> list) throws EventException {
		DBRowSet rowSet	= null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet = dbDao.search04USA404EDIStatusSend(list);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 조회 이벤트 처리<br>
	 * COP EDI 전
	 * 
	 * @param rowSet
	 * @exception EventException
	 */
	public void search04SubUSA404EDIStatusSend(DBRowSet rowSet) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String sVndr_send = "";
		String sMtc_send = "";
		String sMaha_send = "";
		String sSsofa_send = "";
		String sIts_send = "";
		String sMtclax_send = "";
		String sMtcla_send = "";	//CHM-201325385 [TRS] 404 EDI terminal setup
		String sEtslax_send  = ""; //CHM-201538922 RailBilling EDI (404 & 998) 중복 생성 요청
		String sMtchan_send = "";
		String sMtchanint_send = "";
		String sNwcs310_send = "";
		String s3105488232_send = "";
		String sApp_vndr = "";
		String sApp_maha = ""; //APP_MAHA
		String sApp_mtc = ""; //APP_MTC
		String sApp_ssofa = ""; //APP_SSOFA
		String sApp_its = ""; //APP_ITS
		String sApp_mtclax = ""; //APP_MTCLAX
		String sApp_mtcla = ""; //APP_MTCLA  //CHM-201325385 [TRS] 404 EDI terminal setup
		String sApp_etslax = ""; //APP_ETSLAX  //CHM-201538922 RailBilling EDI (404 & 998) 중복 생성 요청
		String sApp_mtchan = ""; //APP_MTCHAN
		String sApp_mtchanint = ""; //APP_MTCHANINT
		String sApp_nwcs310 = ""; //APP_NWCS310 CHM-201539465 404 & 998 EDI 중복 생성 요청 (NWCS) 
		String sApp_3105488232 = ""; //APP_3105488232
		String sRailCmb = "";
		
		try {
			USA404EDIStatusInquiryEAIDAO usa404EdiStatusInquiryEai = new USA404EDIStatusInquiryEAIDAO();
			
			while( rowSet.next() ) {
				sApp_vndr = JSPUtil.getNull(rowSet.getString("APPRECV_C")); //APP_VNDR
				sApp_maha = JSPUtil.getNull(rowSet.getString("APP_MAHA")); //APP_MAHA
				sApp_mtc = JSPUtil.getNull(rowSet.getString("APP_MTC")); //APP_MTC
				sRailCmb    = JSPUtil.getNull(rowSet.getString("RAIL_CMB"));
				sApp_ssofa = JSPUtil.getNull(rowSet.getString("APP_SSOFA")); //APP_SSOFA
				sApp_its = JSPUtil.getNull(rowSet.getString("APP_ITS")); //APP_ITS
				sApp_mtclax = JSPUtil.getNull(rowSet.getString("APP_MTCLAX")); //APP_MTCLAX
				sApp_mtcla = JSPUtil.getNull(rowSet.getString("APP_MTCLA")); //APP_MTCLA  CHM-201325385 [TRS] 404 EDI terminal setup
				sApp_etslax = JSPUtil.getNull(rowSet.getString("APP_ETSLAX")); //APP_ETSLAX CHM-201538922 RailBilling EDI (404 & 998) 중복 생성 요청
				sApp_mtchan = JSPUtil.getNull(rowSet.getString("APP_MTCHAN")); //APP_MTCHAN
				sApp_mtchanint = JSPUtil.getNull(rowSet.getString("APP_MTCHANINT")); //APP_MTCHANINT
				sApp_nwcs310 = JSPUtil.getNull(rowSet.getString("APP_NWCS310")); //APP_NWCS310 CHM-201539465 404 & 998 EDI 중복 생성 요청 (NWCS) 
				sApp_3105488232 = JSPUtil.getNull(rowSet.getString("APP_3105488232")); //APP_3105488232
				
				StringBuffer eh = new StringBuffer();
				eh.append("IFNIS2EDI!RAILO!\n")
				.append("{CNTR\n");
								
				StringBuffer eb = new StringBuffer();
				eb.append("TYPE:"+JSPUtil.getNull(rowSet.getString("TYPE"))+"\n")				
				.append("SHIPQLF_C:"+JSPUtil.getNull(rowSet.getString("SHIPQLF_C"))+"\n")
				.append("BKGNO:"+JSPUtil.getNull(rowSet.getString("BKGNO"))+"\n")
				.append("BLNO:"+JSPUtil.getNull(rowSet.getString("BLNO"))+"\n")
				.append("BKG_SCNO:"+JSPUtil.getNull(rowSet.getString("BKG_SCNO"))+"\n")
				.append("VSLCODE:"+JSPUtil.getNull(rowSet.getString("VSLCODE"))+"\n")
				.append("VOYAGE:"+JSPUtil.getNull(rowSet.getString("VOYAGE"))+"\n")
				.append("VSLNAME:"+JSPUtil.getNull(rowSet.getString("VSLNAME"))+"\n")
				.append("VSLCUTOFF:"+JSPUtil.getNull(rowSet.getString("VSLCUTOFF"))+"\n")
				.append("LLOYD:"+JSPUtil.getNull(rowSet.getString("LLOYD"))+"\n")
				.append("HUBETA:"+JSPUtil.getNull(rowSet.getString("HUBETA"))+"\n") 
				.append("POL:"+JSPUtil.getNull(rowSet.getString("POL"))+"\n")
				.append("POD:"+JSPUtil.getNull(rowSet.getString("POD"))+"\n")
				.append("CONTRACT:"+JSPUtil.getNull(rowSet.getString("CONTRACT"))+"\n");

				// MTC 일 때 CREDIT prefix 'M'
				StringBuffer vndrCredit = new StringBuffer();
				StringBuffer mtcCredit = new StringBuffer();
				vndrCredit.append("CREDIT:X"+ JSPUtil.getNull(rowSet.getString("CREDIT"))  +"\n");
				mtcCredit.append("CREDIT:Z"+ JSPUtil.getNull(rowSet.getString("CREDIT")) +"\n");

				StringBuffer eb1 = new StringBuffer();
				eb1.append("IMTRANSNO:"+JSPUtil.getNull(rowSet.getString("IMTRANSNO"))+"\n")
				.append("TRANSEXPNO:"+JSPUtil.getNull(rowSet.getString("TRANSEXPNO"))+"\n")
				.append("DOCK:"+JSPUtil.getNull(rowSet.getString("DOCK"))+"\n")
				.append("FFDESC:"+JSPUtil.getNull(rowSet.getString("FFDESC"))+"\n")
				.append("EQNISTS:"+JSPUtil.getNull(rowSet.getString("EQNISTS"))+"\n")
				.append("EQINIT:"+JSPUtil.getNull(rowSet.getString("EQINIT"))+"\n")
				.append("EQNO:"+JSPUtil.getNull(rowSet.getString("EQNO"))+"\n")
				.append("WGT:"+JSPUtil.getNull(rowSet.getString("WGT"))+"\n")
				.append("EQDESC_C:"+JSPUtil.getNull(rowSet.getString("EQDESC_C"))+"\n")
				.append("EQLTH_C:"+JSPUtil.getNull(rowSet.getString("EQLTH_C"))+"\n")
				.append("EQCHK:"+JSPUtil.getNull(rowSet.getString("EQCHK"))+"\n")
				.append("SEALNO:"+JSPUtil.getNull(rowSet.getString("SEALNO"))+"\n")
				.append("SPCHAND_C:"+JSPUtil.getNull(rowSet.getString("SPCHAND_C"))+"\n")
				.append("ILTRANS_C:"+JSPUtil.getNull(rowSet.getString("ILTRANS_C"))+"\n")
				.append("CUSTENTTP_C:"+JSPUtil.getNull(rowSet.getString("CUSTENTTP_C"))+"\n")
				.append("CUSTENTNO:"+JSPUtil.getNull(rowSet.getString("CUSTENTNO"))+"\n")
				.append("CUSTTYPE:"+JSPUtil.getNull(rowSet.getString("CUSTTYPE"))+"\n")
				.append("CUSTLOC:"+JSPUtil.getNull(rowSet.getString("CUSTLOC"))+"\n")
				.append("CARGOWGT:"+JSPUtil.getNull(rowSet.getString("CARGOWGT"))+"\n")
				.append("ORGCTY:"+JSPUtil.getNull(rowSet.getString("ORGCTY"))+"\n")
				.append("ORGSTATE:"+JSPUtil.getNull(rowSet.getString("ORGSTATE"))+"\n")
				.append("ORGLOC:"+JSPUtil.getNull(rowSet.getString("ORGLOC"))+"\n")
				.append("ORGYD:"+JSPUtil.getNull(rowSet.getString("ORGYD"))+"\n")
				.append("DSTCTY:"+JSPUtil.getNull(rowSet.getString("DSTCTY"))+"\n")
				.append("DSTSTATE:"+JSPUtil.getNull(rowSet.getString("DSTSTATE"))+"\n")
				.append("DSTLOC:"+JSPUtil.getNull(rowSet.getString("DSTLOC"))+"\n")
				.append("DSTYD:"+JSPUtil.getNull(rowSet.getString("DSTYD"))+"\n")
				.append("SHPR_N:"+JSPUtil.getNull(rowSet.getString("SHPR_N"))+"\n")
				.append("SHPR_A:"+JSPUtil.getNull(rowSet.getString("SHPR_A"))+"\n")
				.append("SHPR_C:"+JSPUtil.getNull(rowSet.getString("SHPR_C"))+"\n")
				.append("SHPR_S:"+JSPUtil.getNull(rowSet.getString("SHPR_S"))+"\n")
				.append("SHPR_P:"+JSPUtil.getNull(rowSet.getString("SHPR_P"))+"\n")
				.append("SHPR_CN:"+JSPUtil.getNull(rowSet.getString("SHPR_CN"))+"\n");

				StringBuffer eb2 = new StringBuffer(); //MTC가 아닌 경우
				eb2.append("ASHPR_CODE:"+JSPUtil.getNull(rowSet.getString("ASHPR_CODE"))+"\n")
				.append("ASHPR_N:"+JSPUtil.getNull(rowSet.getString("ASHPR_N"))+"\n")
				.append("ASHPR_A:"+JSPUtil.getNull(rowSet.getString("ASHPR_A"))+"\n")
				.append("ASHPR_C:"+JSPUtil.getNull(rowSet.getString("ASHPR_C"))+"\n")
				.append("ASHPR_S:"+JSPUtil.getNull(rowSet.getString("ASHPR_S"))+"\n")
				.append("ASHPR_P:"+JSPUtil.getNull(rowSet.getString("ASHPR_P"))+"\n")
				.append("ASHPR_CN:"+JSPUtil.getNull(rowSet.getString("ASHPR_CN"))+"\n");

				StringBuffer eb3 = new StringBuffer();
				eb3.append("CNEE_N:"+JSPUtil.getNull(rowSet.getString("CNEE_N"))+"\n")
				.append("CNEE_A:"+JSPUtil.getNull(rowSet.getString("CNEE_A"))+"\n")
				.append("CNEE_C:"+JSPUtil.getNull(rowSet.getString("CNEE_C"))+"\n")
				.append("CNEE_S:"+JSPUtil.getNull(rowSet.getString("CNEE_S"))+"\n")
				.append("CNEE_P:"+JSPUtil.getNull(rowSet.getString("CNEE_P"))+"\n")
				.append("CNEE_CN:"+JSPUtil.getNull(rowSet.getString("CNEE_CN"))+"\n")
				.append("NTFY_N:"+JSPUtil.getNull(rowSet.getString("NTFY_N"))+"\n")
				.append("NTFY_T:"+JSPUtil.getNull(rowSet.getString("NTFY_T"))+"\n")
				.append("CARE_N:"+JSPUtil.getNull(rowSet.getString("CARE_N"))+"\n")
				.append("CARE_A:"+JSPUtil.getNull(rowSet.getString("CARE_A"))+"\n")
				.append("CARE_C:"+JSPUtil.getNull(rowSet.getString("CARE_C"))+"\n")
				.append("CARE_S:"+JSPUtil.getNull(rowSet.getString("CARE_S"))+"\n")
				.append("CARE_P:"+JSPUtil.getNull(rowSet.getString("CARE_P"))+"\n")
				.append("CARE_CN:"+JSPUtil.getNull(rowSet.getString("CARE_CN"))+"\n")
				.append("BILL_N:"+JSPUtil.getNull(rowSet.getString("BILL_N"))+"\n")
				.append("BILL_A:"+JSPUtil.getNull(rowSet.getString("BILL_A"))+"\n")
				.append("BILL_C:"+JSPUtil.getNull(rowSet.getString("BILL_C"))+"\n")
				.append("BILL_S:"+JSPUtil.getNull(rowSet.getString("BILL_S"))+"\n")
				.append("BILL_P:"+JSPUtil.getNull(rowSet.getString("BILL_P"))+"\n")
				.append("BILL_CN:"+JSPUtil.getNull(rowSet.getString("BILL_CN"))+"\n")
				.append("UTCN_CODE:"+JSPUtil.getNull(rowSet.getString("UTCN_CODE"))+"\n")
				.append("UTCN_N:"+JSPUtil.getNull(rowSet.getString("UTCN_N"))+"\n");

				StringBuffer eb4 = new StringBuffer(); //MTC가 아닌 경우
				eb4.append("UTCN_A:"+JSPUtil.getNull(rowSet.getString("UTCN_A"))+"\n")
				.append("UTCN_C:"+JSPUtil.getNull(rowSet.getString("UTCN_C"))+"\n")
				.append("UTCN_S:"+JSPUtil.getNull(rowSet.getString("UTCN_S"))+"\n")
				.append("UTCN_P:"+JSPUtil.getNull(rowSet.getString("UTCN_P"))+"\n")
				.append("UTCN_CN:"+JSPUtil.getNull(rowSet.getString("UTCN_CN"))+"\n");
				StringBuffer eb4_1 = new StringBuffer();  //MTC 일경우만.
				eb4_1.append("UTCN_A:\n")
				.append("UTCN_C:\n")
				.append("UTCN_S:\n")
				.append("UTCN_P:\n")
				.append("UTCN_CN:\n");

				StringBuffer eb5 = new StringBuffer();
				eb5.append("RECV_N:"+JSPUtil.getNull(rowSet.getString("RECV_N"))+"\n")
				.append("RECV_A:"+JSPUtil.getNull(rowSet.getString("RECV_A"))+"\n")
				.append("RECV_C:"+JSPUtil.getNull(rowSet.getString("RECV_C"))+"\n")
				.append("RECV_S:"+JSPUtil.getNull(rowSet.getString("RECV_S"))+"\n")
				.append("RECV_P:"+JSPUtil.getNull(rowSet.getString("RECV_P"))+"\n")
				.append("RECV_CN:"+JSPUtil.getNull(rowSet.getString("RECV_CN"))+"\n")
				.append("ADMC_C:"+JSPUtil.getNull(rowSet.getString("ADMC_C"))+"\n")
				.append("FDA_IND:"+JSPUtil.getNull(rowSet.getString("FDA_IND"))+"\n")
				.append("CUST_F:"+JSPUtil.getNull(rowSet.getString("CUST_F"))+"\n")
				.append("CUST_E:"+JSPUtil.getNull(rowSet.getString("CUST_E"))+"\n")
				.append("TEMP:"+JSPUtil.getNull(rowSet.getString("TEMP"))+"\n")
				.append("TUN:"+JSPUtil.getNull(rowSet.getString("TUN"))+"\n")
				.append("VENT:"+JSPUtil.getNull(rowSet.getString("VENT"))+"\n")
				.append("HUMID:"+JSPUtil.getNull(rowSet.getString("HUMID"))+"\n")
				.append("GENSET:"+JSPUtil.getNull(rowSet.getString("GENSET"))+"\n")
				.append("{REF\n")
				.append("REFID:"+JSPUtil.getNull(rowSet.getString("REFID"))+"\n")
				.append("REFVAL:"+JSPUtil.getNull(rowSet.getString("REFVAL"))+"\n")
				.append("}REF\n");		
				eb5.append("{OLD\n")
				.append("APPRECV_C_OLD:"+JSPUtil.getNull(rowSet.getString("APPRECV_C_OLD"))+"\n")
				.append("BKGNO_OLD:"+JSPUtil.getNull(rowSet.getString("BKGNO_OLD"))+"\n")
				.append("BLNO_OLD:"+JSPUtil.getNull(rowSet.getString("BLNO_OLD"))+"\n");
				
				
				//Only NWCS310 CHM-201539465 404 & 998 EDI 중복 생성 요청 (NWCS)
				StringBuffer eb7 = new StringBuffer();
				eb7.append("RECV_N:"+JSPUtil.getNull(rowSet.getString("RECV_N"))+"\n")
				.append("RECV_A:"+JSPUtil.getNull(rowSet.getString("RECV_A"))+"\n")
				.append("RECV_C:"+JSPUtil.getNull(rowSet.getString("RECV_C"))+"\n")
				.append("RECV_S:"+JSPUtil.getNull(rowSet.getString("RECV_S"))+"\n")
				.append("RECV_P:"+JSPUtil.getNull(rowSet.getString("RECV_P"))+"\n")
				.append("RECV_CN:"+JSPUtil.getNull(rowSet.getString("RECV_CN"))+"\n")
				.append("ADMC_C:"+JSPUtil.getNull(rowSet.getString("ADMC_C"))+"\n")
				.append("FDA_IND:"+JSPUtil.getNull(rowSet.getString("FDA_IND"))+"\n")
				.append("CUST_F:"+JSPUtil.getNull(rowSet.getString("CUST_F"))+"\n")
				.append("CUST_E:"+JSPUtil.getNull(rowSet.getString("CUST_E"))+"\n")
				.append("TEMP:"+JSPUtil.getNull(rowSet.getString("TEMP"))+"\n")
				.append("TUN:"+JSPUtil.getNull(rowSet.getString("TUN"))+"\n")
				.append("VENT:"+JSPUtil.getNull(rowSet.getString("VENT"))+"\n")
				.append("HUMID:"+JSPUtil.getNull(rowSet.getString("HUMID"))+"\n")
				.append("GENSET:"+JSPUtil.getNull(rowSet.getString("GENSET"))+"\n")
				.append("{REF\n")
				.append("REFID:"+JSPUtil.getNull(rowSet.getString("REFID"))+"\n")
				.append("REFVAL:"+JSPUtil.getNull(rowSet.getString("REFVAL"))+"\n")
				.append("}REF\n");		
				eb7.append("{OLD\n")
				.append("APPRECV_C_OLD:"+JSPUtil.getNull(rowSet.getString("APP_NWCS310"))+"\n")
				.append("BKGNO_OLD:"+JSPUtil.getNull(rowSet.getString("BKGNO_OLD"))+"\n")
				.append("BLNO_OLD:"+JSPUtil.getNull(rowSet.getString("BLNO_OLD"))+"\n");
								
				// MTC 일 때 CREDIT prefix 'M'
				StringBuffer vndrCreditOld = new StringBuffer();
				StringBuffer mtcCreditOld = new StringBuffer();
				vndrCreditOld.append("CREDIT_OLD:X"+ JSPUtil.getNull(rowSet.getString("CREDIT_OLD"))  +"\n");
				mtcCreditOld.append("CREDIT_OLD:Z"+ JSPUtil.getNull(rowSet.getString("CREDIT_OLD")) +"\n");				
				
				StringBuffer eb6 = new StringBuffer();
				eb6.append("EQINIT_OLD:"+JSPUtil.getNull(rowSet.getString("EQINIT_OLD"))+"\n")
				.append("EQNO_OLD:"+JSPUtil.getNull(rowSet.getString("EQNO_OLD"))+"\n")
				.append("SNDDT_OLD:"+JSPUtil.getNull(rowSet.getString("SNDDT_OLD"))+"\n")
				.append("}OLD\n");
				
				/*
				 * N200906100030 2009-06-15 [EDI-TRS/Dom. EDI-404] Rail Interchage에 대한 Contract no 보완
				 */
				if( sRailCmb.equals("C1T") || sRailCmb.equals("S2R") || sRailCmb.equals("S3R") ) {
					eb6.append("{ROUTE\n")
					.append("ROUTCARR:"+JSPUtil.getNull(rowSet.getString("ROUTCARR"))+"\n")
					.append("ROUTSEQ:"+JSPUtil.getNull(rowSet.getString("ROUTSEQ"))+"\n")
					.append("ROUTCITY:"+JSPUtil.getNull(rowSet.getString("ROUTCITY"))+"\n")
					.append("INTMOSVR:"+JSPUtil.getNull(rowSet.getString("INTMOSVR"))+"\n")
					.append("TRANSTP:"+JSPUtil.getNull(rowSet.getString("TRANSTP"))+"\n")
					.append("TOYD:"+JSPUtil.getNull(rowSet.getString("TO_YARD_CD"))+"\n")
					.append("CONTRACT:"+JSPUtil.getNull(rowSet.getString("CONTRACT"))+"\n")
					.append("}ROUTE\n");
				} else {
					eb6.append("{ROUTE\n")
					.append("ROUTCARR:"+JSPUtil.getNull(rowSet.getString("ROUTCARR"))+"\n")
					.append("ROUTSEQ:"+JSPUtil.getNull(rowSet.getString("ROUTSEQ"))+"\n")
					.append("ROUTCITY:"+JSPUtil.getNull(rowSet.getString("ROUTCITY"))+"\n")
					.append("INTMOSVR:"+JSPUtil.getNull(rowSet.getString("INTMOSVR"))+"\n")
					.append("TRANSTP:"+JSPUtil.getNull(rowSet.getString("TRANSTP"))+"\n")
					.append("TOYD:"+JSPUtil.getNull(rowSet.getString("TO_YARD_CD"))+"\n")
					.append("CONTRACT:"+JSPUtil.getNull(rowSet.getString("CONTRACT"))+"\n")
					.append("}ROUTE\n")
					.append("{ROUTE\n")
					.append("ROUTCARR:"+JSPUtil.getNull(rowSet.getString("ROUTCARR2"))+"\n")
					.append("ROUTSEQ:"+JSPUtil.getNull(rowSet.getString("ROUTSEQ2"))+"\n")
					.append("ROUTCITY:"+JSPUtil.getNull(rowSet.getString("ROUTCITY2"))+"\n")
					.append("INTMOSVR:"+JSPUtil.getNull(rowSet.getString("INTMOSVR2"))+"\n")
					.append("TRANSTP:"+JSPUtil.getNull(rowSet.getString("TRANSTP2"))+"\n")
					.append("TOYD:"+JSPUtil.getNull(rowSet.getString("TO_YARD_CD2"))+"\n")
					.append("CONTRACT:"+JSPUtil.getNull(rowSet.getString("CONTRACT2"))+"\n")
					.append("}ROUTE\n");
					if( sRailCmb.equals("C3T") || sRailCmb.equals("C3R") || sRailCmb.equals("C3S") ) {
						eb6.append("{ROUTE\n")
						.append("ROUTCARR:"+JSPUtil.getNull(rowSet.getString("ROUTCARR3"))+"\n")
						.append("ROUTSEQ:"+JSPUtil.getNull(rowSet.getString("ROUTSEQ3"))+"\n")
						.append("ROUTCITY:"+JSPUtil.getNull(rowSet.getString("ROUTCITY3"))+"\n")
						.append("INTMOSVR:"+JSPUtil.getNull(rowSet.getString("INTMOSVR3"))+"\n")
						.append("TRANSTP:"+JSPUtil.getNull(rowSet.getString("TRANSTP3"))+"\n")
						.append("TOYD:"+JSPUtil.getNull(rowSet.getString("TO_YARD_CD3"))+"\n")
						.append("CONTRACT:"+JSPUtil.getNull(rowSet.getString("CONTRACT3"))+"\n")
						.append("}ROUTE\n");
					}
				}
				eb6.append("INBOND:"+JSPUtil.getNull(rowSet.getString("INBOND"))+"\n")
				.append("{LADE\n")
				.append("LADELINE:"+JSPUtil.getNull(rowSet.getString("LADELINE1"))+"\n")
				.append("LADEDESC:"+JSPUtil.getNull(rowSet.getString("LADEDESC1"))+"\n")
				.append("COMMCODE:"+JSPUtil.getNull(rowSet.getString("COMMCODE1"))+"\n")
				.append("NISCOMM:"+JSPUtil.getNull(rowSet.getString("NISCOMM1"))+"\n")
				.append("NISREP:"+JSPUtil.getNull(rowSet.getString("NISRETP1"))+"\n")
				.append("}LADE\n");
				String slade_line = JSPUtil.getNull(rowSet.getString("LADELINE2")); //이 값이 있으면, OK
				if( !slade_line.equals("") ) {
					eb6.append("{LADE\n")
					.append("LADELINE:"+slade_line+"\n")
					.append("LADEDESC:"+JSPUtil.getNull(rowSet.getString("LADEDESC2"))+"\n")
					.append("COMMCODE:"+JSPUtil.getNull(rowSet.getString("COMMCODE2"))+"\n")
					.append("NISCOMM:"+JSPUtil.getNull(rowSet.getString("NISCOMM2"))+"\n")
					.append("NISREP:"+JSPUtil.getNull(rowSet.getString("NISRETP2"))+"\n")
					.append("}LADE\n");
				}
				slade_line = JSPUtil.getNull(rowSet.getString("LADELINE3"));
				if( !slade_line.equals("") ) {
					eb6.append("{LADE\n")
					.append("LADELINE:"+slade_line+"\n")
					.append("LADEDESC:"+JSPUtil.getNull(rowSet.getString("LADEDESC3"))+"\n")
					.append("COMMCODE:"+JSPUtil.getNull(rowSet.getString("COMMCODE3"))+"\n")
					.append("NISCOMM:"+JSPUtil.getNull(rowSet.getString("NISCOMM3"))+"\n")
					.append("NISREP:"+JSPUtil.getNull(rowSet.getString("NISRETP3"))+"\n")
					.append("}LADE\n");
				}
				slade_line = JSPUtil.getNull(rowSet.getString("LADELINE4"));
				if( !slade_line.equals("") ) {
					eb6.append("{LADE\n")
					.append("LADELINE:"+slade_line+"\n")
					.append("LADEDESC:"+JSPUtil.getNull(rowSet.getString("LADEDESC4"))+"\n")
					.append("COMMCODE:"+JSPUtil.getNull(rowSet.getString("COMMCODE4"))+"\n")
					.append("NISCOMM:"+JSPUtil.getNull(rowSet.getString("NISCOMM4"))+"\n")
					.append("NISREP:"+JSPUtil.getNull(rowSet.getString("NISRETP4"))+"\n")
					.append("}LADE\n");
				}
				slade_line = JSPUtil.getNull(rowSet.getString("LADELINE5"));
				if( !slade_line.equals("") ) {
					eb6.append("{LADE\n")
					.append("LADELINE:"+slade_line+"\n")
					.append("LADEDESC:"+JSPUtil.getNull(rowSet.getString("LADEDESC5"))+"\n")
					.append("COMMCODE:"+JSPUtil.getNull(rowSet.getString("COMMCODE5"))+"\n")
					.append("NISCOMM:"+JSPUtil.getNull(rowSet.getString("NISCOMM5"))+"\n")
					.append("NISREP:"+JSPUtil.getNull(rowSet.getString("NISRETP5"))+"\n")
					.append("}LADE\n");
				}
				/*
			     * * N200904030180 2009-04-15 [TRS_Rail EDI] DG 관련 항목 추가 및 Shipper 정보 누락관련 보완요청
			     */
				eb6.append("LADEQTY:"+JSPUtil.getNull(rowSet.getString("LADEQTY"))+"\n")
				.append("PACKFORM:"+JSPUtil.getNull(rowSet.getString("PACKFORM"))+"\n");
				
//				if("2".equals(rowSet.getString("DG_MAX_SEQ"))){
					param.put("dgBkgNo", rowSet.getString("DG_BKG_NO"));
					velParam.put("dgBkgNo", rowSet.getString("DG_BKG_NO"));
					
					param.put("dgEqNo", rowSet.getString("DG_EQ_NO"));
					velParam.put("dgEqNo", rowSet.getString("DG_EQ_NO"));
					
					// 404 EDI FF 생성
					dbRowset = dbDao.search04SubUSA404EDIStatusSend(param, velParam);
					
					while(dbRowset.next()){						
						eb6.append("{DG\n")			
						.append("DG_STCC:"+JSPUtil.getNull(dbRowset.getString("DG_STCC"))+"\n")
						.append("DG_UN:"+JSPUtil.getNull(dbRowset.getString("DG_UN"))+"\n")
						.append("DG_NAME:"+JSPUtil.getNull(dbRowset.getString("DG_NAME"))+"\n")
						.append("DG_CONTENTS:"+JSPUtil.getNull(dbRowset.getString("DG_CONTENTS"))+"\n")
						.append("DG_CLASS:"+JSPUtil.getNull(dbRowset.getString("DG_CLASS"))+"\n")
						.append("DG_PGRP:"+JSPUtil.getNull(dbRowset.getString("DG_PGRP"))+"\n")
						.append("DG_PSAGRP:"+JSPUtil.getNull(dbRowset.getString("DG_PSAGRP"))+"\n")
						.append("DG_MP:"+JSPUtil.getNull(dbRowset.getString("DG_MP"))+"\n")
						.append("DG_FLSHTEMP:"+JSPUtil.getNull(dbRowset.getString("DG_FLSHTEMP"))+"\n")
						.append("DG_FLSHUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_FLSHUNIT"))+"\n")
						.append("DG_QTY:"+JSPUtil.getNull(dbRowset.getString("DG_QTY"))+"\n")
						.append("DG_QUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_QUNIT"))+"\n")
						.append("DG_WEIGHT:"+JSPUtil.getNull(dbRowset.getString("DG_WEIGHT"))+"\n")
						.append("DG_WUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_WUNIT"))+"\n")
						.append("DG_FLASHTEMP:"+JSPUtil.getNull(dbRowset.getString("DG_FLASHTEMP"))+"\n")
						.append("DG_CLASS1NEW:"+JSPUtil.getNull(dbRowset.getString("DG_CLASS1NEW"))+"\n")
						.append("DG_CLASS1NEWUNIT:"+JSPUtil.getNull(dbRowset.getString("DG_CLASS1NEWUNIT"))+"\n")
						.append("DG_TEL:"+JSPUtil.getNull(dbRowset.getString("DG_TEL"))+"\n")
						.append("DG_CONTACT:"+JSPUtil.getNull(dbRowset.getString("DG_CONTACT"))+"\n")
						.append("}DG\n");					
					}					
//				}else{
//					eb6.append("{DG\n")
//					.append("DG_STCC:"+JSPUtil.getNull(rowSet.getString("DG_STCC"))+"\n")
//					.append("DG_UN:"+JSPUtil.getNull(rowSet.getString("DG_UN"))+"\n")
//					.append("DG_NAME:"+JSPUtil.getNull(rowSet.getString("DG_NAME"))+"\n")
//					.append("DG_CONTENTS:"+JSPUtil.getNull(rowSet.getString("DG_CONTENTS"))+"\n")
//					.append("DG_CLASS:"+JSPUtil.getNull(rowSet.getString("DG_CLASS"))+"\n")
//					.append("DG_PGRP:"+JSPUtil.getNull(rowSet.getString("DG_PGRP"))+"\n")
//					.append("DG_PSAGRP:"+JSPUtil.getNull(rowSet.getString("DG_PSAGRP"))+"\n")
//					.append("DG_MP:"+JSPUtil.getNull(rowSet.getString("DG_MP"))+"\n")
//					.append("DG_FLSHTEMP:"+JSPUtil.getNull(rowSet.getString("DG_FLSHTEMP"))+"\n")
//					.append("DG_FLSHUNIT:"+JSPUtil.getNull(rowSet.getString("DG_FLSHUNIT"))+"\n")
//					.append("DG_QTY:"+JSPUtil.getNull(rowSet.getString("DG_QTY"))+"\n")
//					.append("DG_QUNIT:"+JSPUtil.getNull(rowSet.getString("DG_QUNIT"))+"\n")
//					.append("DG_WEIGHT:"+JSPUtil.getNull(rowSet.getString("DG_WEIGHT"))+"\n")
//					.append("DG_WUNIT:"+JSPUtil.getNull(rowSet.getString("DG_WUNIT"))+"\n")
//					.append("DG_FLASHTEMP:"+JSPUtil.getNull(rowSet.getString("DG_FLASHTEMP"))+"\n")
//					.append("DG_CLASS1NEW:"+JSPUtil.getNull(rowSet.getString("DG_CLASS1NEW"))+"\n")
//					.append("DG_CLASS1NEWUNIT:"+JSPUtil.getNull(rowSet.getString("DG_CLASS1NEWUNIT"))+"\n")
//					.append("DG_TEL:"+JSPUtil.getNull(rowSet.getString("DG_TEL"))+"\n")
//					.append("DG_CONTACT:"+JSPUtil.getNull(rowSet.getString("DG_CONTACT"))+"\n")
//					.append("}DG\n");					
//				}

				//	2008.01.04 추가 EDI FLATFILE 수정. SANGROG LEE. MULTI BL_NO 관련
				// 2012.11.26 MULTI BL_NO 5개가 Max였기만 쿼리문에서 100개로 늘림
				String mbl_no = JSPUtil.getNull(rowSet.getString("BL_NO1"));
				if( !mbl_no.equals("") ) {
					eb6.append(mbl_no+"\n");
				}

				eb6.append("}CNTR\n");
				
				sVndr_send = eh.toString() + "APPRECV_C:"+sApp_vndr+"\n" + eb.toString() + vndrCredit.toString() + eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + vndrCreditOld.toString() + eb6.toString();
				sMaha_send = eh.toString() + "APPRECV_C:"+sApp_maha+"\n" + eb.toString() + vndrCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + vndrCreditOld.toString() + eb6.toString();
				sMtc_send = eh.toString() + "APPRECV_C:"+sApp_mtc+"\n" + eb.toString() + mtcCredit.toString() + eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + mtcCreditOld.toString() + eb6.toString();
				sSsofa_send = eh.toString() + "APPRECV_C:"+sApp_ssofa+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + mtcCreditOld.toString() + eb6.toString();
				sIts_send = eh.toString() + "APPRECV_C:"+sApp_its+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + mtcCreditOld.toString() + eb6.toString();
				sMtclax_send = eh.toString() + "APPRECV_C:"+sApp_mtclax+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + mtcCreditOld.toString() + eb6.toString();
				sMtcla_send = eh.toString() + "APPRECV_C:"+sApp_mtcla+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + mtcCreditOld.toString() + eb6.toString();  //CHM-201325385 [TRS] 404 EDI terminal setup
				sEtslax_send = eh.toString() + "APPRECV_C:"+sApp_etslax+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + mtcCreditOld.toString() + eb6.toString();  //CHM-201325385 [TRS] 404 EDI terminal setup
				sMtchan_send = eh.toString() + "APPRECV_C:"+sApp_mtchan+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + mtcCreditOld.toString() + eb6.toString();
				sMtchanint_send = eh.toString() + "APPRECV_C:"+sApp_mtchanint+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + mtcCreditOld.toString() + eb6.toString();
				sNwcs310_send =  eh.toString() + "APPRECV_C:"+sApp_nwcs310+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb7.toString() + mtcCreditOld.toString() + eb6.toString();
				s3105488232_send = eh.toString() + "APPRECV_C:"+sApp_3105488232+"\n" + eb.toString() + mtcCredit.toString() +eb1.toString() + eb2.toString() + eb3.toString() + eb4.toString() + eb5.toString() + mtcCreditOld.toString() + eb6.toString();
				
				if("".equals(rowSet.getString("DG_UN")) || (!"".equals(rowSet.getString("DG_UN")) && !"CPRS".equals(sApp_vndr)) 
						|| (!"".equals(rowSet.getString("DG_UN")) && "CPRS".equals(sApp_vndr) && "USDETR5".equals(rowSet.getString("ORGYD")))){
					usa404EdiStatusInquiryEai.cancelReturn4040EDIsend(sVndr_send);					
				}
				
				if( !sApp_maha.equals("") ) {
					usa404EdiStatusInquiryEai.cancelReturn4040EDIsend(sMaha_send);
				}
				if( !sApp_mtc.equals("") ) {
					usa404EdiStatusInquiryEai.cancelReturn4040EDIsend(sMtc_send);
				}
				if( !sApp_ssofa.equals("") ) {
					usa404EdiStatusInquiryEai.cancelReturn4040EDIsend(sSsofa_send);
				}
				if( !sApp_its.equals("") ) {
					usa404EdiStatusInquiryEai.cancelReturn4040EDIsend(sIts_send);
				}
				if( !sApp_mtclax.equals("") ) {
					usa404EdiStatusInquiryEai.cancelReturn4040EDIsend(sMtclax_send);
				}
				// CHM-201325385 [TRS] 404 EDI terminal setup
				if( !sApp_mtcla.equals("") ) {
					usa404EdiStatusInquiryEai.cancelReturn4040EDIsend(sMtcla_send);
				}
				// CHM-201325385 [TRS] 404 EDI terminal setup
				if( !sApp_etslax.equals("") ) {
					usa404EdiStatusInquiryEai.cancelReturn4040EDIsend(sEtslax_send);
				}	
				if( !sApp_mtchanint.equals("") ) {
					usa404EdiStatusInquiryEai.cancelReturn4040EDIsend(sMtchanint_send);
				}
				if( !sApp_mtchan.equals("") ) {
					usa404EdiStatusInquiryEai.cancelReturn4040EDIsend(sMtchan_send);
				}
				//NWCS310 CHM-201539465 404 & 998 EDI 중복 생성 요청 (NWCS)
				if( !sApp_nwcs310.equals("") ) {
					usa404EdiStatusInquiryEai.cancelReturn4040EDIsend(sNwcs310_send);
				}
				
				if( !sApp_3105488232.equals("") ) {
					usa404EdiStatusInquiryEai.cancelReturn4040EDIsend(s3105488232_send);
				}
				
			}
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage()); 
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send Cop
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse multiUSA404EDIStatusInquiry(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event=(EsdTrs0028Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArrayList arr_edi_snd_no = null;

		try {
			arr_edi_snd_no = dbDao.multiTrsTrspEdiRailOrderVos(event);
			eventResponse.setRsVoList(arr_edi_snd_no);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send Cop
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse modifyUS404EDIResendRailBilOrd(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event = (EsdTrs0028Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArrayList arr_edi_snd_no = null;

		try {
			arr_edi_snd_no 	= dbDao.modifyUS404EDIResendRailBilOrd(event);
			eventResponse.setRsVoList(arr_edi_snd_no);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send
	 * 
	 * @param e ESD_TRS_028Event
	 * @exception EventException
	 */
	public void multiUSA404EDIRollbackInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event=(EsdTrs0028Event)e;

		try {
			dbDao.multiRollbackTrsTrspEdiRailOrderVos(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send
	 * 
	 * @param e ESD_TRS_028Event
	 * @exception EventException
	 */
	public void addUSA404EDIResendRollback(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event=(EsdTrs0028Event)e;

		try {
			dbDao.addUSA404EDIResendRollback(event);		//multiRollbackTRS_TRSP_EDI_RAIL_ORDER_VO
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}	

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Confirm Message Send
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	public EventResponse multi01USA404EDIStatusInquiry(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event=(EsdTrs0028Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multi01USA404EDIStatusInquiry(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Cancellation EDI Send
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse multi02USA404EDIStatusInquiry(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event=(EsdTrs0028Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArrayList arr_edi_snd_no = null;

		try {
			arr_edi_snd_no = dbDao.multi02TrsTrspEdiRailOrderVos(event);
			eventResponse.setRsVoList(arr_edi_snd_no);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param e ESD_TRS_028Event
	 * @exception EventException
	 */
	public void multi02USA404EDIStatusInquiryRBB(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event=(EsdTrs0028Event)e;

		try {
			dbDao.multi02TrsTrspEdiRailOrderVoRbb(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param e ESD_TRS_028Event
	 * @param row
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse multi02USA404EDIStatusInquiryForSpp(Event e, int row) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event=(EsdTrs0028Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArrayList arr_edi_snd_no = null;

		try {
			arr_edi_snd_no = dbDao.multi02TrsTrspEdiRailOrderVoForSpp(event, row);
			eventResponse.setRsVoList(arr_edi_snd_no);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param e ESD_TRS_028Event
	 * @exception EventException
	 */
	public void multi03USA404EDIStatusInquiry(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event=(EsdTrs0028Event)e;
		try {
			dbDao.multi03TrsTrspEdiRailOrderVos(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_028 화면에 대한 멀티 이벤트 처리<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param sOfc_cty_cd
	 * @param sSo_seq
	 * @return ArrayList
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList batchUSA404ComfirmedMessageSend(String sOfc_cty_cd, String sSo_seq) throws EventException{
		ArrayList arrResponse = null;
		try {
			arrResponse = dbDao.batchUSA404ComfirmedMessageAuto(sOfc_cty_cd, sSo_seq);
			return arrResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 조회 이벤트 처리<br>
	 * COP EDI 전
	 * 
	 * @param e ESD_TRS_028Event
	 * @return
	 * @exception EventException
	 */
	public EventResponse verifyObReeferCntr(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event=(EsdTrs0028Event)e;
		try {
			dbDao.verifyObReeferCntr(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 조회 이벤트 처리<br>
	 * COP EDI 전
	 * 
	 * @param e ESD_TRS_028Event
	 * @return
	 * @exception EventException
	 */
	public EventResponse verifyObDgCntr(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event=(EsdTrs0028Event)e;
		try {
			dbDao.verifyObDgCntr(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * 404EDI CONFIM MESSAGE Send FAX
	 * 
	 * @param event
	 * @exception EventException
	 */
	public void faxEdiSend(EsdTrs0028Event event) throws EventException {
		try{	
			eaiDao.faxEdiSend(event);
		} catch (ServerExportException de) {
			log.error(de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * 404EDI CONFIM MESSAGE Send E-mail
	 * 
	 * @param event
	 * @exception EventException
	 */
	public void emailEdiSend(EsdTrs0028Event event) throws EventException {
		try{	
			eaiDao.emailEdiSend(event);
		} catch (ServerExportException de) {
			log.error(de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * USA404EDIStatusInquiry업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}