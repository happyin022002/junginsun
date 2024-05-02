/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SOInquiryBCImpl.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.30
*@LastModifier : 최 선
*@LastVersion : 1.8
* 2006.11.10 juhyun
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2010.09.30 최 선    1.1 [] SO Inquiry 엑셀 다운로드 수정
* 2011.01.03 이윤정  1.2 [CHM-201007768-01] DMDT 관련 컬럼 추가
* 2011.06.08 손은주  1.3 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.07.14 김영철  1.4 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청 - SO화면에서 Bundling Data를 보여줌.
* 2011.07.21 손은주   1.5 [CHM-201111573-01]	[TRS] S/O history function 추가 요청
* 2011.10.21 이수진  1.6 [CHM-201113210] [TRS] Feeder Term 표기 칼럼 추가 요청 - Receiving, Delivery 항목 추가
* 2011.11.30 유선오  1.7 [CHM-201114748] [TRS] S/O inquiry 상에 보이는 VVD lane 정보 칼럼 변경/추가 요청
* 2011.12.06 변종건  1.8 [CHM-201114914-01] [TRS] S/O, Invoice Inquiry table 상 칼럼 추가 요청
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.basic;

import com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.event.EsdTrs0019Event;
import com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.integration.SOInquiryDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.component.message.ErrorHandler;

/** 
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author juhyun
 * @see ESD_TRS_019EventResponse,SOInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public  class SOInquiryBCImpl   extends BasicCommandSupport implements SOInquiryBC {

	// Database Access Object
	private transient SOInquiryDBDAO dbDao=null;
	
	/**
	 * ChassisGensetSOManageBCImpl 객체 생성<br>
	 * ChassisGensetSOManageDBDAO를 생성한다.<br>
	 */
	public SOInquiryBCImpl(){
		dbDao = new SOInquiryDBDAO();
	}


	/**
	 * 조회 이벤트 처리<br>
	 * SOInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_019Event
	 * @param soffice_cd
	 * @return EventResponse ESD_TRS_019EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSOInquiry(Event e, String soffice_cd) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0019Event event=(EsdTrs0019Event)e;
		
		try {
			rowSet=dbDao.searchSOInquiry(event,soffice_cd);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry화면에 대한 Down Excel 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_028Event
	 * @return EventResponse ESD_TRS_028EventResponse
	 * @exception EventException
	 */
	 @SuppressWarnings("unused")
	public DBRowSet getRowSet(Event e, String soffice_cd) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0019Event event=(EsdTrs0019Event)e;
		try {
			return rowSet=dbDao.searchSOInquiry(event,soffice_cd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 *  office체크  이벤트 처리<br>
	 * SOInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return 
	 * @exception EventException
	 */
	public EventResponse search_office(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0019Event event=(EsdTrs0019Event)e;

		try {
			rowSet=dbDao.search_office(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SOHistory화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_019Event
	 * @return EventResponse ESD_TRS_019EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSOHistory(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0019Event event=(EsdTrs0019Event)e;
		
		try {
			rowSet=dbDao.searchSOHistory(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	@Override
	public String[] getColumns(Event e) {
		EsdTrs0019Event event=(EsdTrs0019Event)e;
		String hidUsRail      = event.getHidUsRail();
		String hidUsdropnpull = event.getHidUsDropNPull();
		String hidDomUsrail      = event.getHidDomUsrail();

		int sizeofarray = 162;
		// 컬럼헤더와 매핑되는 DB Column 명 정의
		if(hidUsRail.equalsIgnoreCase("Y") || hidDomUsrail.equalsIgnoreCase("Y")){
			sizeofarray = sizeofarray+3;
		}
		if(hidUsdropnpull.equalsIgnoreCase("Y")){
			sizeofarray = sizeofarray+10;
		}
		if(hidUsRail.equalsIgnoreCase("N") && hidDomUsrail.equalsIgnoreCase("N")){
			sizeofarray = sizeofarray+1;
		}
		String[] titleField = new String[sizeofarray];
		
		
		int i = 0;
		titleField[i++] = " "                	  ;
		titleField[i++] = "EQ_NO"                 ;
		titleField[i++] = "EQ_TPSZ"               ;
		titleField[i++] = "ORG_EQ_TPSZ"           ;
		titleField[i++] = "TRSP_COST_DTL_MOD_CD"  ;
		titleField[i++] = "TRSP_CRR_MOD_CD"       ;
		titleField[i++] = "TRSP_SO_TP_CD"         ;
		titleField[i++] = "UPLN_SO_FLG"           ;
		titleField[i++] = "PRE_PULL_FLG"          ;
		titleField[i++] = "BKG_CNTR_CMB_SEQ"      ;
		titleField[i++] = "TRSP_FRST_FLG"         ;
		titleField[i++] = "BLCK_STWG"            ;
		titleField[i++] = "SO_NO"                ;
		titleField[i++] = "SO_CRE_DT1"           ;
		titleField[i++] = "SO_DEL_FLG"           ;
		titleField[i++] = "SO_DEL_DT"            ;
		titleField[i++] = "UPD_USR_NM"           ;
		titleField[i++] = "WO_NO"                ;
		titleField[i++] = "WO_ISS_STS_CD"        ;
		titleField[i++] = "WO_ISS_WK"            ;
		titleField[i++] = "WO_ISS_DT"            ;
		titleField[i++] = "WO_ISS_TP"            ;
		titleField[i++] = "WO_ISS_OFC_CD"        ;
		titleField[i++] = "WO_ISS_NM"            ;
//		titleField[i++] = "AGMT_CNT_FLG"		 ;
//		titleField[i++] = "AGMT_CNT_TP_CD"		 ;
//		titleField[i++] = "CNT_FLG"				 ;
//		titleField[i++] = "CNT_TP_CD"			 ;
//		titleField[i++] = "CTRT_CNT"			 ;
		titleField[i++] = "FM_NOD_CD"            ;
		titleField[i++] = "VIA_NOD_CD"           ;
		titleField[i++] = "TO_NOD_CD"            ;
		titleField[i++] = "DOOR"                 ;
		titleField[i++] = "TTL_DIST"             ;
		titleField[i++] = "LNK_DIST_DIV_CD"      ;
		titleField[i++] = "SPOT_BID_FLG"      	 ;
		titleField[i++] = "SPOT_BID_NO"      	 ;
		titleField[i++] = "SPOT_BID_DUE_DT"      ;
		titleField[i++] = "SPOT_BID_DUE_DT_HMS"  ;
		titleField[i++] = "DOOR_ACT_CUST"        ;
		titleField[i++] = "DOOR_FCTRY_NM"        ;
		titleField[i++] = "DOOR_ZIP"             ;
		titleField[i++] = "DOR_DE_ADDR"          ;
		titleField[i++] = "DOOR_TEL"             ;
		titleField[i++] = "DOOR_FAX"             ;
		titleField[i++] = "DOOR_PIC"             ;
		titleField[i++] = "USA_DO_USR_INFO"      ;
		titleField[i++] = "DO_CRE_DATE"          ;
		titleField[i++] = "DO_CRE_TIME"          ;
//		titleField[i++] = "VNDR_TP_CD"           ;
		titleField[i++] = "VNDR_CD"              ;
		titleField[i++] = "VNDR_ABBR_NM"         ;
		titleField[i++] = "PVNDR_CD"             ;
		titleField[i++] = "PVNDR_NM"             ;
		titleField[i++] = "WO_RCV_DT"            ;
		titleField[i++] = "APPT_TIME"            ;
		titleField[i++] = "DELIV_TIME"           ;
		titleField[i++] = "WTR_RCV_TERM_CD"      ;
		titleField[i++] = "WTR_DE_TERM_CD"       ;
		titleField[i++] = "N3PTY_BIL_FLG"        ;
		titleField[i++] = "COST_OFC_CD"          ;
		titleField[i++] = "TRSP_AGMT_WY_TP_NM"   ;
		titleField[i++] = "AGMT_CNT_TP_CD"       ;
		titleField[i++] = "WO_CURR_CD"           ;
		titleField[i++] = "WO_BZC_AMT"           ;
		titleField[i++] = "WO_NEGO_AMT"          ;
		titleField[i++] = "WO_FUEL_SCG_AMT"      ;
		titleField[i++] = "WO_VAT_SCG_AMT"       ;
		if(hidUsRail.equalsIgnoreCase("N") && hidDomUsrail.equalsIgnoreCase("N")){
			titleField[i++] = "WO_TOLL_FEE_AMT"  ;
		}
		titleField[i++] = "WO_ETC_ADD_AMT"       ;
		//----------------
		if(hidUsRail.equalsIgnoreCase("Y") || hidDomUsrail.equalsIgnoreCase("Y")){
			titleField[i++] = "WO_HZD_MTRL_SCG_AMT"  ;
			titleField[i++] = "WO_OVR_WGT_SCG_AMT"   ;
			titleField[i++] = "WO_USA_TTL_AMT"       ;
		}
		titleField[i++] = "WO_TOT_AMT"           ;
		titleField[i++] = "WO_TOT_AMT_USD"       ;
		titleField[i++] = "INV_XCH_RT"           ;
		titleField[i++] = "INV_CALC_LGC_TP_CD"   ;
		titleField[i++] = "INV_CURR_CD"          ;
		titleField[i++] = "INV_BZC_AMT"          ;
		titleField[i++] = "INV_ETC_ADD_AMT"      ;
		titleField[i++] = "INV_TOT_AMT"          ;
		titleField[i++] = "INV_TOT_AMT_USD"      ;
		titleField[i++] = "INV_VNDR_CD"          ;
		titleField[i++] = "INV_VNDR_NM"          ;
		titleField[i++] = "INV_NO"               ;
		titleField[i++] = "INV_STS_CD"           ;
		titleField[i++] = "INV_CFM_DT"           ;
		titleField[i++] = "CAR_NO"               ;
		titleField[i++] = "INV_IF_DT"            ;
		titleField[i++] = "INV_CFM_OFC_CD"       ;
		titleField[i++] = "INV_CRE_USR_NM"       ;
		titleField[i++] = "INV_RMK"              ;
		titleField[i++] = "N1ST_NOD_PLN_DT"      ;
		titleField[i++] = "LST_NOD_PLN_DT"       ;
		titleField[i++] = "DOR_NOD_PLN_DT"       ;
		titleField[i++] = "DOR_ARR_DT"           ;
		titleField[i++] = "COP_NO"               ;
		titleField[i++] = "AG_SEQ"               ;
		titleField[i++] = "AG_CODE"              ;
		titleField[i++] = "BKG_NO"               ;
		titleField[i++] = "BL_NO"                ;
		titleField[i++] = "TRSP_BND_CD"          ;
		titleField[i++] = "TERM"                 ;
		titleField[i++] = "TRO_SEQ"              ;
		titleField[i++] = "TRO_CNFM"             ;
		titleField[i++] = "TRO_CFM_OFC"          ;
		titleField[i++] = "TRO_CFM_USR"          ;
		titleField[i++] = "TRO_CFM_UPD"          ;
		titleField[i++] = "T1_DOC_FLG"           ;
		titleField[i++] = "TRO_REV_CUR"          ;
		titleField[i++] = "EUR_TRO_REV"          ;
		titleField[i++] = "MANIFESTED"           ;
		titleField[i++] = "TRO_LOD_REF"          ;
		titleField[i++] = "BKG_QTY"              ;
		titleField[i++] = "POR_CD"               ;
		titleField[i++] = "POL_CD"               ;
		titleField[i++] = "POD_CD"               ;
		titleField[i++] = "DEL_CD"               ;
		titleField[i++] = "T_VVD"                ;
		titleField[i++] = "SLAN_CD"              ;
		titleField[i++] = "IB_VVD_CD"            ;
		titleField[i++] = "IB_SLAN_CD"           ;
		titleField[i++] = "OB_VVD_CD"            ;
		titleField[i++] = "OB_SLAN_CD"           ;
		titleField[i++] = "CGO_TP_CD"           ;
		titleField[i++] = "BKG_SPE"             ;
		titleField[i++] = "USED"                ;
		titleField[i++] = "LT"                  ;
		titleField[i++] = "I_EXIT"              ;
		titleField[i++] = "LT_EXP"              ;
		titleField[i++] = "SEAL_NO"             ;
		titleField[i++] = "SEAL_NO2"            ;
		titleField[i++] = "WEIGHT_KGS"          ;
		titleField[i++] = "WEIGHT_LBS"          ;
		titleField[i++] = "NO_PKG"              ;
		titleField[i++] = "PKG_CD"              ;
		titleField[i++] = "CMDT_NM"             ;
		titleField[i++] = "C_LOC"               ;
		titleField[i++] = "USA_LAST_CITY"       ;
		titleField[i++] = "F"                   ;
		titleField[i++] = "O"                   ;
		titleField[i++] = "C"                   ;
		titleField[i++] = "IT_NO"               ;
		titleField[i++] = "PICKUP_NO"           ;
		titleField[i++] = "PU_YARD_CD"          ;
		titleField[i++] = "AVAILABLE_DT"        ;
		titleField[i++] = "LAST_FREE_DT"        ;
		titleField[i++] = "SC_NO"               ;
		titleField[i++] = "RFA_NO"              ;
		titleField[i++] = "CTRC_CUST_NM"            ;
		titleField[i++] = "DOOR_SVC_TP"         ;
		titleField[i++] = "PKUP_CNTR"           ;
		titleField[i++] = "SHIPPER"             ;
		titleField[i++] = "CONSIGNEE"           ;
		titleField[i++] = "NOTIFY"              ;
		titleField[i++] = "REF_BKG_NO"          ;
		titleField[i++] = "REF_BL_NO"           ;
		titleField[i++] = "ORG_GATE_OUT_DT"     ;
		titleField[i++] = "DEST_GATE_IN_DT"     ;
		titleField[i++] = "MTY_REF_ID"          ;
		titleField[i++] = "TRSP_PURP_RSN"       ;
		titleField[i++] = "INTER_RMK"           ;
		titleField[i++] = "NEGO_RMK"            ;
		titleField[i++] = "CNG_RSN_DESC"        ;
		titleField[i++] = "SPCL_INSTR_RMK"      ;
		titleField[i++] = "WO_INSTR_RMK"        ;
		titleField[i++] = "CHZ_BUNDLE_SEQ"      ;
		titleField[i++] = "TRSP_SPL_SO_TP_CD"   ;
		
		if(hidUsdropnpull.equalsIgnoreCase("Y")){
			titleField[i++] = "FM_DT"   			;
			titleField[i++] = "FM_YD"   			;
			titleField[i++] = "FM_STS"   			;
			titleField[i++] = "TO_DT"   			;
			titleField[i++] = "TO_YD"   			;
			titleField[i++] = "TO_STS"   			;
			titleField[i++] = "MT_DT"   			;
			titleField[i++] = "MT_YD"   			;
			titleField[i++] = "WEB_MT_DT"   		;
			titleField[i++] = "GRACE_END"   		;
		}
		titleField[i++] = "MCNTR_BDL_GRP_SEQ"       ;
		titleField[i++] = "MCNTR_BDL_SEQ"           ;
		titleField[i++] = "HJL_NO"                  ;
		titleField[i++] = "WO_HJL_HNDL_AMT"         ;

		return titleField;
	}
	
	@Override
	public String[] getTitle(Event e) {
		EsdTrs0019Event event=(EsdTrs0019Event)e;
		String hidUsRail = event.getHidUsRail();
		String hidDomUsrail = event.getHidDomUsrail();
		String hidUsdropnpull = event.getHidUsDropNPull();
		int sizeofarray = 162;
		// 컬럼헤더와 매핑되는 DB Column 명 정의

		if(hidUsRail.equalsIgnoreCase("Y") || hidDomUsrail.equalsIgnoreCase("Y")){
			sizeofarray = sizeofarray+3;
		}
		if(hidUsdropnpull.equalsIgnoreCase("Y")){
			sizeofarray = sizeofarray+10;
		}
		if(hidUsRail.equalsIgnoreCase("N") && hidDomUsrail.equalsIgnoreCase("N")){
			sizeofarray = sizeofarray+1;
		}
		String[] title = new String[sizeofarray];

		int j = 0;
		title[j++] = "Seq.";
		title[j++] = "EQ No.";
		title[j++] = "TP/SZ";
		title[j++] = "Org TP/SZ";
		title[j++] = "Cost Mode";
		title[j++] = "Trans Mode";
		title[j++] = "S/O TP";
		title[j++] = "Unplanned";
		title[j++] = "Pre-Pull";
		title[j++] = "CB";
		title[j++] = "Frustrated";
		title[j++] = "Block Stowage";
		title[j++] = "S/O No.";
		title[j++] = "S/O CRE DT ";
		title[j++] = "S/O DEL";
		title[j++] = "S/O DEL DT ";
		title[j++] = "S/O UPD Name ";
		title[j++] = "W/O No.";
		title[j++] = "W/O Iss STS";
		title[j++] = "W/O Iss WK ";
		title[j++] = "W/O Iss DT ";
		title[j++] = "W/O ISS TP ";
		title[j++] = "W/O ISS OFC";
		title[j++] = "W/O ISS Name ";
//		title[j++] = "CNT(Agreement)";
//		title[j++] = "CNT(Agreement)";
//		title[j++] = "CNT(CNT Approval)";
//		title[j++] = "CNT(CNT Approval)";
//		title[j++] = "CNT(CNT Approval)";
		title[j++] = "From";
		title[j++] = "Via";
		title[j++] = "To";
		title[j++] = "Door ";
		title[j++] = "Distance ";
		title[j++] = "Distance ";
		title[j++] = "Spot ";
		title[j++] = "Spot ";
		title[j++] = "Spot ";
		title[j++] = "Spot ";
		title[j++] = "Door Information";
		title[j++] = "Door Information";
		title[j++] = "Door Information";
		title[j++] = "Door Information";
		title[j++] = "Door Information";
		title[j++] = "Door Information";
		title[j++] = "Door Information";
		title[j++] = "Web D/O";
		title[j++] = "Web D/O";
		title[j++] = "Web D/O";
//		title[j++] = "W/O S/P";
		title[j++] = "W/O S/P";
		title[j++] = "W/O S/P";
		title[j++] = "Parent S/P";
		title[j++] = "Parent S/P";
		title[j++] = "W/O RCV DT";
		title[j++] = "Appt. Time";
		title[j++] = "Deliv. Time";
		title[j++] = "Feeder Term";
		title[j++] = "Feeder Term";
		title[j++] = "3rd Party";
		title[j++] = "Cost OFC";
		title[j++] = "Rate Type";		
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		title[j++] = "Work Order Amount";
		if(hidUsRail.equalsIgnoreCase("N") && hidDomUsrail.equalsIgnoreCase("N")){	
			title[j++] = "Work Order Amount";
		}
		title[j++] = "Work Order Amount";
		//----
		if(hidUsRail.equalsIgnoreCase("Y") || hidDomUsrail.equalsIgnoreCase("Y")){
			title[j++] = "Work Order Amount";
			title[j++] = "Work Order Amount";
			title[j++] = "Work Order Amount";
		}
		title[j++] = "Exchange Rate";
		title[j++] = "Calculation Logic";
		title[j++] = "Invoice Amount";
		title[j++] = "Invoice Amount";
		title[j++] = "Invoice Amount";
		title[j++] = "Invoice Amount";
		title[j++] = "Invoice Amount";
		title[j++] = "Invoice S/P";
		title[j++] = "Invoice S/P";
		title[j++] = "Invoice No.";
		title[j++] = "INV STS";
		title[j++] = "INV CNFM DT";
		title[j++] = "CSR No.";
		title[j++] = "INV I/F DT ";
		title[j++] = "INV OFC";
		title[j++] = "INV User ";
		title[j++] = "Invoice Remark";
		title[j++] = "Estimated Time";
		title[j++] = "Estimated Time";
		title[j++] = "Estimated Time";
		title[j++] = "Estimated Time";
		title[j++] = "COP No.";
		title[j++] = "A/G SEQ";
		title[j++] = "A/G Code ";
		title[j++] = "BKG No.";
		title[j++] = "BL No. ";
		title[j++] = "BND";
		title[j++] = "Term ";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "TRO Information";
		title[j++] = "BKG QTY";
		title[j++] = "POR";
		title[j++] = "POL";
		title[j++] = "POD";
		title[j++] = "DEL";
		title[j++] = "T.VVD";
		title[j++] = "Lane";
		title[j++] = "In VVD";
		title[j++] = "In VVD Lane";
		title[j++] = "Out VVD";
		title[j++] = "Out VVD Lane";
		title[j++] = "CGO TP";
		title[j++] = "CNTR SPE";
		title[j++] = "Used";
		title[j++] = "L/T";
		title[j++] = "I.Exit";
		title[j++] = "L/T EXP";
		title[j++] = "Seal No.1";
		title[j++] = "Seal No.2";
		title[j++] = "Weight(KGS)";
		title[j++] = "Weight(LBS)";
		title[j++] = "No of PKG";
		title[j++] = "PKG CD";
		title[j++] = "Commodity DESC";
		title[j++] = "C.LOC";
		title[j++] = "USA Last City";
		title[j++] = "F";
		title[j++] = "O";
		title[j++] = "C";
		title[j++] = "IT No";
		title[j++] = "Pickup No.";
		title[j++] = "PU Yard";
		title[j++] = "Available DT";
		title[j++] = "Last Free DT";
		title[j++] = "S/C No.";
		title[j++] = "RFA No.";
		title[j++] = "Contract Customer Name";
		title[j++] = "Door SVC TP";
		title[j++] = "Pickup CNTR";
		title[j++] = "Shipper";
		title[j++] = "Consignee";
		title[j++] = "Notify ";
		title[j++] = "Ref.BKG No ";
		title[j++] = "Ref.BL No";
		title[j++] = "Outgate Date ";
		title[j++] = "Ingate Date";
		title[j++] = "MTY Reference No ";
		title[j++] = "Reason ";
		title[j++] = "Internal Remark";
		title[j++] = "Nego. Remark";
		title[j++] = "Reason of Node Change";
		title[j++] = "Special Instruction";
		title[j++] = "W/O Instruction";
		title[j++] = "CHZ Bundle";
		title[j++] = "Supplement Kind";
		
		if(hidUsdropnpull.equalsIgnoreCase("Y")){
			title[j++] = "From(ID)";
			title[j++] = "From(ID)";
			title[j++] = "From(ID)";
			title[j++] = "To";
			title[j++] = "To";
			title[j++] = "To";
			title[j++] = "MT Info.";
			title[j++] = "MT Info.";
			title[j++] = "Web Mty";
			title[j++] = "Grace End";
		}

		title[j++] = "GP ID";
		title[j++] = "GP Seq";
		title[j++] = "ETS";
		title[j++] = "HJL Handling Fee";

		return title;
	}	
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SOInquiry업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}