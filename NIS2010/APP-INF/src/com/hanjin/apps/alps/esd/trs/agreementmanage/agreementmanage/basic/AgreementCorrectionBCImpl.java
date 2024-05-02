/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementCorrectionBCImpl.java
*@FileTitle : Agreement File Import
*Open Issues :
*Change history :
*@LastModifyDate : 2010-04-05
*@LastModifier : agreement
*@LastVersion : 1.0
* 2010-04-05 agreement
* 1.0 최초 생성
-------------------------
* 2014.05.28 최종혁 [CHM-201430241] AGMT Confirm 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0224Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0226Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0229Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration.AgreementCorrectionDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author agreement
 * @see ESD_TRS_061EventResponse,AgreementCorrectionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AgreementCorrectionBCImpl   extends BasicCommandSupport implements AgreementCorrectionBC {

	// Database Access Object
	private transient AgreementCorrectionDBDAO dbDao=null;

	/**
	 * AgreementCorrectionBCImpl 객체 생성<br>
	 * AgreementImportDBDAO를 생성한다.<br>
	 */
	public AgreementCorrectionBCImpl(){
		dbDao = new AgreementCorrectionDBDAO();
	}

	/**
	 * Agreement Rate정보 조회<br>
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchCorrSumAgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0224Event event=(EsdTrs0224Event)e;
		try {
			rowSet=dbDao.searchCorrSumAgmt(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());		
		}
	}
	
	/**
	 * Agreement Rate정보 삭제 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteCorrSumAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0224Event 	event	= (EsdTrs0224Event)e;
		try {
			dbDao.deleteCorrSumAgmt(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		return eventResponse;
	}
	
	/**
	 * Agreement Rate정보 조회<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCorrRateAgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSetTot=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0226Event event=(EsdTrs0226Event)e;
		String page_cnt = "";
		try {
			page_cnt = event.getCur_page_cnt();
			rowSet=dbDao.searchCorrRateAgmt(event);
			if(page_cnt.equals("1")){
			    rowSetTot=dbDao.searchCorrRateAgmtTot(event);
			    if(rowSetTot.next()){
					eventResponse.setETCData("TOT_CNT", rowSetTot.getString("TOT_CNT"));
				}else{
					eventResponse.setETCData("TOT_CNT", "");
			    }
			}else{
				eventResponse.setETCData("TOT_CNT", "");
			}

			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());		
		}
	}
	
	/**
	 * Agreement Surcharge Rate정보 조회<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCorrScgAgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSetTot=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0229Event event=(EsdTrs0229Event)e;
		String page_cnt = "";
		try {
			page_cnt = event.getCur_page_cnt();
			rowSet=dbDao.searchCorrScgAgmt(event);
			if(page_cnt.equals("1")){
			    rowSetTot=dbDao.searchCorrScgAgmtTot(event);
			    if(rowSetTot.next()){
					eventResponse.setETCData("TOT_CNT", rowSetTot.getString("TOT_CNT"));
				}else{
					eventResponse.setETCData("TOT_CNT", "");
			    }
			}else{
				eventResponse.setETCData("TOT_CNT", "");
			}

			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());		
		}
	}
	
	/**
	 * Agreement Summary 화면의 Agreement Confirm<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmAgmt(Event e, SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0224Event 	event	= (EsdTrs0224Event)e;
		try {
			dbDao.confirmAgmt(event, account);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		return eventResponse;
	}
	
	/**
	 * Agreement Summary 화면의 Agreement Confirm Button 활성화<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount 
	 * @return String
	 * @exception EventException
	 */
	public String confirmAgmtBtn(Event e, SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0224Event 	event	= (EsdTrs0224Event)e;
		String btnConfirm = "F";
		try {
			btnConfirm = dbDao.confirmAgmtBtn(event, account);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
//		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		return btnConfirm;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Surcharge Rate Inquiry화면에 대한 Down Excel 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return DBRowSet 
	 * @exception EventException
	 */
	public DBRowSet getRowSet1(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0229Event event=(EsdTrs0229Event)e;
		try {
			return rowSet=dbDao.searchCorrScgAgmt(event);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	

	@Override
	public String[] getColumns1(String fm_eq_knd_cd) {
		String[] titleField = null ;

		// 컬럼헤더와 매핑되는 DB Column 명 정의
		if(fm_eq_knd_cd.equals("U")){
			titleField = new String[67];
			int i = 0;
			titleField[i++] = " "       ;
			titleField[i++] = "TRSP_SCG_CD"       ;
			titleField[i++] = "TRSP_COST_MOD_CD"  ;
			titleField[i++] = "AGMT_TRSP_TP_CD"   ;
			titleField[i++] = "CGO_TP_CD"         ;
			titleField[i++] = "CUST_NOMI_TRKR_IND_CD" ;
			titleField[i++] = "CUST_CD"           ;
			titleField[i++] = "CMDT_GRP_CD"       ;
			titleField[i++] = "RAIL_SVC_TP_CD"    ;
			titleField[i++] = "EFF_FM_DT"         ;  
			titleField[i++] = "EFF_TO_DT"         ;
			titleField[i++] = "AGMT_ROUT_ALL_FLG" ;
			titleField[i++] = "FM_NOD_CD"         ;
			titleField[i++] = "FM_NOD_YD"         ;
			titleField[i++] = "VIA_NOD_CD"        ;
			titleField[i++] = "VIA_NOD_YD"        ;
			titleField[i++] = "DOR_NOD_CD"        ;
			titleField[i++] = "DOR_NOD_YD"        ;
			titleField[i++] = "TO_NOD_CD"         ;
			titleField[i++] = "TO_NOD_YD"         ;
			titleField[i++] = "TRS_AGMT_SCG_RT"   ;
			titleField[i++] = "CURR_CD"           ;
			titleField[i++] = "TRSP_ONE_WY_RT"    ;
			titleField[i++] = "TRSP_RND_RT"       ;
			titleField[i++] = "EQ_ALAL"           ; 
			titleField[i++] = "EQ_DAL"            ; 
			titleField[i++] = "EQ_RAL"            ; 
			titleField[i++] = "EQ_AAL"            ; 
			titleField[i++] = "EQ_FAL"            ; 
			titleField[i++] = "EQ_TAL"            ; 
			titleField[i++] = "EQ_SAL"            ; 
			titleField[i++] = "EQ_OAL"            ; 
			titleField[i++] = "EQ_PAL"            ; 
			titleField[i++] = "EQ_AL2"            ; 
			titleField[i++] = "EQ_AL4"            ; 
			titleField[i++] = "EQ_AL5"            ; 
			titleField[i++] = "EQ_AL7"            ; 
			titleField[i++] = "EQ_AL9"            ; 
			titleField[i++] = "EQ_D2"             ; 
			titleField[i++] = "EQ_D4"             ; 
			titleField[i++] = "EQ_D5"             ; 
			titleField[i++] = "EQ_D7"             ; 
			titleField[i++] = "EQ_R2"             ; 
			titleField[i++] = "EQ_R4"             ; 
			titleField[i++] = "EQ_R5"             ; 
			titleField[i++] = "EQ_R7"             ; 			
			titleField[i++] = "EQ_R8"             ; 
			titleField[i++] = "EQ_R9"             ; 			
			titleField[i++] = "EQ_A2"             ; 
			titleField[i++] = "EQ_A4"             ;
			titleField[i++] = "EQ_A5"             ; 
			titleField[i++] = "EQ_F2"             ; 
			titleField[i++] = "EQ_F4"             ; 
			titleField[i++] = "EQ_F5"             ; 
			titleField[i++] = "EQ_T2"             ; 
			titleField[i++] = "EQ_T4"             ; 
			titleField[i++] = "EQ_S2"             ; 
			titleField[i++] = "EQ_S4"             ; 
			titleField[i++] = "EQ_O2"             ; 
			titleField[i++] = "EQ_O4"             ; 
			titleField[i++] = "EQ_O5"             ;
			titleField[i++] = "EQ_O7"             ;
			titleField[i++] = "EQ_P2"             ; 
			titleField[i++] = "EQ_P4"             ; 
			titleField[i++] = "TO_WGT"            ;
			titleField[i++] = "WGT_MEAS_UT_CD"    ;	
			titleField[i++] = "CFM_FLG"    		  ;	
		} else if (fm_eq_knd_cd.equals("Z")){
			titleField = new String[45];
			int i = 0;
			titleField[i++] = " " ;
			titleField[i++] = "TRSP_SCG_CD" ;
			titleField[i++] = "TRSP_COST_MOD_CD" ;
			titleField[i++] = "AGMT_TRSP_TP_CD" ;
			titleField[i++] = "CGO_TP_CD" ;
			titleField[i++] = "CUST_CD" ;
			titleField[i++] = "CMDT_GRP_CD" ;
			titleField[i++] = "RAIL_SVC_TP_CD" ;
			titleField[i++] = "EFF_FM_DT" ;
			titleField[i++] = "EFF_TO_DT" ;
			titleField[i++] = "AGMT_ROUT_ALL_FLG" ;
			titleField[i++] = "FM_NOD_CD" ;
			titleField[i++] = "FM_NOD_YD" ;
			titleField[i++] = "VIA_NOD_CD" ;
			titleField[i++] = "VIA_NOD_YD" ;
			titleField[i++] = "DOR_NOD_CD" ;
			titleField[i++] = "DOR_NOD_YD" ;
			titleField[i++] = "TO_NOD_CD" ;
			titleField[i++] = "TO_NOD_YD" ;
			titleField[i++] = "TRS_AGMT_SCG_RT" ;
			titleField[i++] = "CURR_CD" ;
			titleField[i++] = "TRSP_ONE_WY_RT" ;
			titleField[i++] = "TRSP_RND_RT" ;
			titleField[i++] = "EQ_ALAL" ;
			titleField[i++] = "EQ_SFAL" ;
			titleField[i++] = "EQ_SLAL" ;
			titleField[i++] = "EQ_TAAL" ;
			titleField[i++] = "EQ_GNAL" ;
			titleField[i++] = "EQ_EGAL" ;
			titleField[i++] = "EQ_AL2" ;
			titleField[i++] = "EQ_AL4" ;
			titleField[i++] = "EQ_AL5" ;
			titleField[i++] = "EQ_AL8" ;
			titleField[i++] = "EQ_SF2" ;
			titleField[i++] = "EQ_SF4" ;
			titleField[i++] = "EQ_SL2" ;
			titleField[i++] = "EQ_TA2" ;
			titleField[i++] = "EQ_GN4" ;
			titleField[i++] = "EQ_GN5" ;
			titleField[i++] = "EQ_EG5" ;
			titleField[i++] = "EQ_EG8" ;
			titleField[i++] = "EQ_ZT4" ;
			titleField[i++] = "EQ_CB4" ;
			titleField[i++] = "TO_WGT" ;
			titleField[i++] = "WGT_MEAS_UT_CD" ;
		} else if (fm_eq_knd_cd.equals("G")){
			titleField = new String[28];
			int i = 0;
			titleField[i++] = " " ;
			titleField[i++] = "TRSP_SCG_CD" ;
			titleField[i++] = "TRSP_COST_MOD_CD" ;
			titleField[i++] = "AGMT_TRSP_TP_CD" ;
			titleField[i++] = "CGO_TP_CD" ;
			titleField[i++] = "CUST_CD" ;
			titleField[i++] = "CMDT_GRP_CD" ;
			titleField[i++] = "RAIL_SVC_TP_CD" ;
			titleField[i++] = "EFF_FM_DT" ;
			titleField[i++] = "EFF_TO_DT" ;
			titleField[i++] = "AGMT_ROUT_ALL_FLG" ;
			titleField[i++] = "FM_NOD_CD" ;
			titleField[i++] = "FM_NOD_YD" ;
			titleField[i++] = "VIA_NOD_CD" ;
			titleField[i++] = "VIA_NOD_YD" ;
			titleField[i++] = "DOR_NOD_CD" ;
			titleField[i++] = "DOR_NOD_YD" ;
			titleField[i++] = "TO_NOD_CD" ;
			titleField[i++] = "TO_NOD_YD" ;
			titleField[i++] = "TRS_AGMT_SCG_RT" ;
			titleField[i++] = "CURR_CD" ;
			titleField[i++] = "TRSP_ONE_WY_RT" ;
			titleField[i++] = "TRSP_RND_RT" ;
			titleField[i++] = "EQ_ALAL" ;
			titleField[i++] = "EQ_CG" ;
			titleField[i++] = "EQ_UG" ;
			titleField[i++] = "TO_WGT" ;
			titleField[i++] = "WGT_MEAS_UT_CD" ;
		}

		return titleField;
	}	
	
	@Override
	public String[] getTitle1(String fm_eq_knd_cd) {
		String[] title = null;
		// 엑셀의 컬럼헤더 정의
		if(fm_eq_knd_cd.equals("U")){
			title = new String[67];
			int i = 0;
			title[i++] = "Seq.";
			title[i++] = "Surcharge";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "EffectiveDate";
			title[i++] = "EffectiveDate";
			title[i++] = "AllRoute";
			title[i++] = "From";
			title[i++] = "From";
			title[i++] = "Via";
			title[i++] = "Via";
			title[i++] = "Door";
			title[i++] = "Door";
			title[i++] = "To";
			title[i++] = "To";
			title[i++] = "Fixed Ratio Div";
			title[i++] = "Currency";
			title[i++] = "One Way";
			title[i++] = "Round Trip";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "Weight Tier";
			title[i++] = "UOM";
			title[i++] = "Confirm(Manager Level)";
		} else if (fm_eq_knd_cd.equals("Z")){
			title = new String[45];
			int i = 0;
			title[i++] = "Seq.";
			title[i++] = "Surcharge";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "EffectiveDate";
			title[i++] = "EffectiveDate";
			title[i++] = "AllRoute";
			title[i++] = "From";
			title[i++] = "From";
			title[i++] = "Via";
			title[i++] = "Via";
			title[i++] = "Door";
			title[i++] = "Door";
			title[i++] = "To";
			title[i++] = "To";
			title[i++] = "Fixed Ratio Div";
			title[i++] = "Currency";
			title[i++] = "One Way";
			title[i++] = "Round Trip";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "Weight Tier";
			title[i++] = "UOM";	
		} else if (fm_eq_knd_cd.equals("G")){	
			title = new String[28];
			int i = 0;
			title[i++] = "Seq.";
			title[i++] = "Surcharge";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "RateType";
			title[i++] = "EffectiveDate";
			title[i++] = "EffectiveDate";
			title[i++] = "AllRoute";
			title[i++] = "From";
			title[i++] = "From";
			title[i++] = "Via";
			title[i++] = "Via";
			title[i++] = "Door";
			title[i++] = "Door";
			title[i++] = "To";
			title[i++] = "To";
			title[i++] = "Fixed Ratio Div";
			title[i++] = "Currency";
			title[i++] = "One Way";
			title[i++] = "Round Trip";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "EQType/Size";
			title[i++] = "Weight Tier";
			title[i++] = "UOM";
		}

		return title;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Surcharge Rate Inquiry화면에 대한 Down Excel 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return DBRowSet 
	 * @exception EventException
	 */
	public DBRowSet getRowSet2(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0226Event event=(EsdTrs0226Event)e;
		try {
			return rowSet=dbDao.searchCorrRateAgmt(event);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	

	public String[] getColumns2(String fm_eq_knd_cd) {
		String[] titleField = null ;
		
		// 컬럼헤더와 매핑되는 DB Column 명 정의
		if(fm_eq_knd_cd.equals("U")){
			titleField = new String[73];
			int i = 0;
			titleField[i++] = " ";
			titleField[i++] = "TRSP_COST_MOD_CD";
			titleField[i++] = "AGMT_TRSP_TP_CD";
			titleField[i++] = "CGO_TP_CD";
			titleField[i++] = "CUST_NOMI_TRKR_IND_CD";
			titleField[i++] = "CUST_CD";
			titleField[i++] = "CMDT_GRP_CD";
			titleField[i++] = "RAIL_SVC_TP_CD";
			titleField[i++] = "FM_NOD_CD";
			titleField[i++] = "FM_NOD_YD";
			titleField[i++] = "VIA_NOD_CD";
			titleField[i++] = "VIA_NOD_YD";
			titleField[i++] = "DOR_NOD_CD";
			titleField[i++] = "DOR_NOD_YD";
			titleField[i++] = "TO_NOD_CD";
			titleField[i++] = "TO_NOD_YD";
			titleField[i++] = "TRSP_DIST_TP_CD";
			titleField[i++] = "TRSP_AGMT_DIST";
			titleField[i++] = "DIST_MEAS_UT_CD";
			titleField[i++] = "CURR_CD";
			titleField[i++] = "TRSP_ONE_WY_RT";
			titleField[i++] = "TRSP_RND_RT";
			titleField[i++] = "EQ_ALAL";
			titleField[i++] = "EQ_DAL";
			titleField[i++] = "EQ_RAL";
			titleField[i++] = "EQ_AAL";
			titleField[i++] = "EQ_FAL";
			titleField[i++] = "EQ_TAL";
			titleField[i++] = "EQ_SAL";
			titleField[i++] = "EQ_OAL";
			titleField[i++] = "EQ_PAL";
			titleField[i++] = "EQ_AL2";
			titleField[i++] = "EQ_AL4";
			titleField[i++] = "EQ_AL5";
			titleField[i++] = "EQ_AL7";
			titleField[i++] = "EQ_D2";
			titleField[i++] = "EQ_D4";
			titleField[i++] = "EQ_D5";
			titleField[i++] = "EQ_D7";
			titleField[i++] = "EQ_R2";
			titleField[i++] = "EQ_R4";
			titleField[i++] = "EQ_R5";
			titleField[i++] = "EQ_R7";
			titleField[i++] = "EQ_R8"; 
			titleField[i++] = "EQ_R9"; 				
			titleField[i++] = "EQ_A2";
			titleField[i++] = "EQ_A4";
			titleField[i++] = "EQ_A5";
			titleField[i++] = "EQ_F2";
			titleField[i++] = "EQ_F4";
			titleField[i++] = "EQ_F5";
			titleField[i++] = "EQ_T2";
			titleField[i++] = "EQ_T4";
			titleField[i++] = "EQ_S2";
			titleField[i++] = "EQ_S4";
			titleField[i++] = "EQ_O2";
			titleField[i++] = "EQ_O4";
			titleField[i++] = "EQ_O5";
			titleField[i++] = "EQ_O7";
			titleField[i++] = "EQ_P2";
			titleField[i++] = "EQ_P4";
			titleField[i++] = "WTR_RCV_TERM_CD";
			titleField[i++] = "WTR_DE_TERM_CD";
			titleField[i++] = "TRSP_AGMT_BDL_QTY";
			titleField[i++] = "TO_WGT";
			titleField[i++] = "WGT_MEAS_UT_CD";
			titleField[i++] = "TRSP_RVS_APLY_FLG";
			titleField[i++] = "EFF_FM_DT";
			titleField[i++] = "EFF_TO_DT";
			titleField[i++] = "AGMT_APRO_DT";
			titleField[i++] = "UPD_DT";
			titleField[i++] = "DT_GAP";
			titleField[i++] = "CFM_FLG";
		} else if (fm_eq_knd_cd.equals("Z")){
			titleField = new String[47];
			int i = 0;
			titleField[i++] = " " ;
			titleField[i++] = "TRSP_COST_MOD_CD" ;
			titleField[i++] = "AGMT_TRSP_TP_CD" ;
			titleField[i++] = "CGO_TP_CD" ;
			titleField[i++] = "CUST_CD" ;
			titleField[i++] = "CMDT_GRP_CD" ;
			titleField[i++] = "RAIL_SVC_TP_CD" ;
			titleField[i++] = "FM_NOD_CD" ;
			titleField[i++] = "FM_NOD_YD" ;
			titleField[i++] = "VIA_NOD_CD" ;
			titleField[i++] = "VIA_NOD_YD" ;
			titleField[i++] = "DOR_NOD_CD" ;
			titleField[i++] = "DOR_NOD_YD" ;
			titleField[i++] = "TO_NOD_CD" ;
			titleField[i++] = "TO_NOD_YD" ;
			titleField[i++] = "TRSP_DIST_TP_CD" ;
			titleField[i++] = "TRSP_AGMT_DIST" ;
			titleField[i++] = "DIST_MEAS_UT_CD" ;
			titleField[i++] = "CURR_CD" ;
			titleField[i++] = "TRSP_ONE_WY_RT" ;
			titleField[i++] = "TRSP_RND_RT" ;
			titleField[i++] = "EQ_ALAL" ;
			titleField[i++] = "EQ_SFAL" ;
			titleField[i++] = "EQ_SLAL" ;
			titleField[i++] = "EQ_TAAL" ;
			titleField[i++] = "EQ_GNAL" ;
			titleField[i++] = "EQ_EGAL" ;
			titleField[i++] = "EQ_AL2" ;
			titleField[i++] = "EQ_AL4" ;
			titleField[i++] = "EQ_AL5" ;
			titleField[i++] = "EQ_AL8" ;
			titleField[i++] = "EQ_SF2" ;
			titleField[i++] = "EQ_SF4" ;
			titleField[i++] = "EQ_SL2" ;
			titleField[i++] = "EQ_TA2" ;
			titleField[i++] = "EQ_GN4" ;
			titleField[i++] = "EQ_GN5" ;
			titleField[i++] = "EQ_EG5" ;
			titleField[i++] = "EQ_EG8" ;
			titleField[i++] = "EQ_ZT4" ;
			titleField[i++] = "EQ_CB4" ;
			titleField[i++] = "WTR_RCV_TERM_CD" ;
			titleField[i++] = "WTR_DE_TERM_CD" ;
			titleField[i++] = "TRSP_AGMT_BDL_QTY" ;
			titleField[i++] = "TRSP_RVS_APLY_FLG" ;
			titleField[i++] = "EFF_FM_DT" ;
			titleField[i++] = "EFF_TO_DT" ;
			
		} else if (fm_eq_knd_cd.equals("G")){
			titleField = new String[30];
			int i = 0;
			titleField[i++] = " " ;
			titleField[i++] = "TRSP_COST_MOD_CD" ;
			titleField[i++] = "AGMT_TRSP_TP_CD" ;
			titleField[i++] = "CGO_TP_CD" ;
			titleField[i++] = "CUST_CD" ;
			titleField[i++] = "CMDT_GRP_CD" ;
			titleField[i++] = "RAIL_SVC_TP_CD" ;
			titleField[i++] = "FM_NOD_CD" ;
			titleField[i++] = "FM_NOD_YD" ;
			titleField[i++] = "VIA_NOD_CD" ;
			titleField[i++] = "VIA_NOD_YD" ;
			titleField[i++] = "DOR_NOD_CD" ;
			titleField[i++] = "DOR_NOD_YD" ;
			titleField[i++] = "TO_NOD_CD" ;
			titleField[i++] = "TO_NOD_YD" ;
			titleField[i++] = "TRSP_DIST_TP_CD" ;
			titleField[i++] = "TRSP_AGMT_DIST" ;
			titleField[i++] = "DIST_MEAS_UT_CD" ;
			titleField[i++] = "CURR_CD" ;
			titleField[i++] = "TRSP_ONE_WY_RT" ;
			titleField[i++] = "TRSP_RND_RT" ;
			titleField[i++] = "EQ_ALAL" ;
			titleField[i++] = "EQ_CG" ;
			titleField[i++] = "EQ_UG" ;
			titleField[i++] = "WTR_RCV_TERM_CD" ;
			titleField[i++] = "WTR_DE_TERM_CD" ;
			titleField[i++] = "TRSP_AGMT_BDL_QTY" ;
			titleField[i++] = "TRSP_RVS_APLY_FLG" ;
			titleField[i++] = "EFF_FM_DT" ;
			titleField[i++] = "EFF_TO_DT" ;
		}
		
		return titleField;
	}	
	
	@Override
	public String[] getTitle2(String fm_eq_knd_cd) {
		String[] title = null;
		// 엑셀의 컬럼헤더 정의
		if(fm_eq_knd_cd.equals("U")){
			title = new String[73];
			int i = 0;
			title[i++] = "Seq.";
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "From" ;
			title[i++] = "From" ;
			title[i++] = "Via" ;
			title[i++] = "Via" ;
			title[i++] = "Door" ;
			title[i++] = "Door" ;
			title[i++] = "To" ;
			title[i++] = "To" ;
			title[i++] = "Fixed or Per Distance" ;
			title[i++] = "To Distance" ;
			title[i++] = "To Distance" ;
			title[i++] = "Currency" ;
			title[i++] = "One Way" ;
			title[i++] = "Round Trip" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "Feeder Term" ;
			title[i++] = "Feeder Term" ;
			title[i++] = "No of Container" ;
			title[i++] = "Weight Tier" ;
			title[i++] = "UOM" ;
			title[i++] = "Reverse" ;
			title[i++] = "Effective Date" ;
			title[i++] = "Effective Date" ;			
			title[i++] = "AGMT Approval Date" ;
			title[i++] = "Update Date" ;
			title[i++] = "Date Gap" ;	
			title[i++] = "Confirm(Manager Level)";
		} else if (fm_eq_knd_cd.equals("Z")){
			title = new String[47];
			int i = 0;
			title[i++] = "Seq.";
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "From" ;
			title[i++] = "From" ;
			title[i++] = "Via" ;
			title[i++] = "Via" ;
			title[i++] = "Door" ;
			title[i++] = "Door" ;
			title[i++] = "To" ;
			title[i++] = "To" ;
			title[i++] = "Fixed or Per Distance" ;
			title[i++] = "To Distance" ;
			title[i++] = "To Distance" ;
			title[i++] = "Currency" ;
			title[i++] = "One Way" ;
			title[i++] = "Round Trip" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "Feeder Term" ;
			title[i++] = "Feeder Term" ;
			title[i++] = "No of Chassis" ;
			title[i++] = "Reverse" ;
			title[i++] = "Effective Date" ;
			title[i++] = "Effective Date" ;
		} else if (fm_eq_knd_cd.equals("G")){	
			title = new String[30];
			int i = 0;
			title[i++] = "Seq.";
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "Rate Type" ;
			title[i++] = "From" ;
			title[i++] = "From" ;
			title[i++] = "Via" ;
			title[i++] = "Via" ;
			title[i++] = "Door" ;
			title[i++] = "Door" ;
			title[i++] = "To" ;
			title[i++] = "To" ;
			title[i++] = "Fixed or Per Distance" ;
			title[i++] = "To Distance" ;
			title[i++] = "To Distance" ;
			title[i++] = "Currency" ;
			title[i++] = "One Way" ;
			title[i++] = "Round Trip" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "EQ Type/Size" ;
			title[i++] = "Feeder Term" ;
			title[i++] = "Feeder Term" ;
			title[i++] = "No of Genset" ;
			title[i++] = "Reverse" ;
			title[i++] = "Effective Date" ;
			title[i++] = "Effective Date" ;
		}
		
		return title;
	}	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * AgreementFileImport업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}