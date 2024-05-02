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
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0224Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0226Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0229Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0238Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration.AgreementCorrectionDBDAO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.AgmtAttachFileListVO;
import com.clt.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

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
	 * @param e
	 * @return response GeneralEventResponse
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
	 * @param e
	 * @return response ESD_TRS_0224EventResponse
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
	 * @param e
	 * @return response ESD_TRS_0226EventResponse
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
	 * @param e
	 * @return response ESD_TRS_0229EventResponse
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
	 * Inquiring Surcharge Rate of WorkOrder Issue More Candidate popup<br>
	 * 
	 * @param e ESD_TRS_0229Event
	 * @return event EsdTrs0229Event
	 * @exception EventException
	 */
	public EventResponse searchMoreCadidateScgAgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0229Event event=(EsdTrs0229Event)e;
		try {
			rowSet=dbDao.searchMoreCadidateScgAgmt(event);

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
	 * Inquires attach file of corresponding agreement.
	 * 
	 * @param e ESD_TRS_0238Event
	 * @return EsdTrs0238Event
	 * @throws EventException
	 */
	public EventResponse searchAgmtAtchFileList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		EsdTrs0238Event event = (EsdTrs0238Event)e;
		try {
			List<AgmtAttachFileListVO> list = new ArrayList<AgmtAttachFileListVO>();
			list = dbDao.searchAgmtAtchFileList(event);
			eventResponse.setRsVoList(list);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());		
		}
		return eventResponse;
	}
	
	/**
	 * ESD_TRS_0238 멀티 이벤트 처리<br>
	 * ESD_TRS_0238 화면에 대한 멀티 이벤트 처리<br>
	 * //1.UPDATE 상태를 확인한다.
	 * //1-1 delete List 추가
	 * //1-1-1 UpdateFileMetaInfo
	 * file_meta 정보 삭제 (FILE_SAVE_ID)
	 * //1-2 insert List 추가
	 * //2. DELETE 상태를 확인
	 * //2-1 delete List 추가
	 * //2-1-1 UpdateFileMetaInfo file_meta 정보 삭제
	 * (FILE_SAVE_ID)
	 * //3. INSERT 상태를 확인
	 * //3-1 insert List 추가
	 * //4. 삭제먼저 수행하고 추가를수행한다.
	 * //5. 맨마지막에 일괄 com_upload 테이블과 동기화 쿼리
	 * @param e
	 * @throws EventException
	 */
	public void manageAgmtAtchFileList(Event e) throws EventException {
		log.debug("[START:: AgreementCorrectionBCImpl == manageAgmtAtchFileList  ]==========");
		EsdTrs0238Event event = (EsdTrs0238Event)e;
		AgmtAttachFileListVO[] agmtAttachFileListVO = event.getAgmtAttachFileListVOs();
		String[] fileSavId = event.getKeys();

		try {
			List<AgmtAttachFileListVO> insertVoList = new ArrayList<AgmtAttachFileListVO>();
			List<AgmtAttachFileListVO> deleteVoList = new ArrayList<AgmtAttachFileListVO>();
			List<AgmtAttachFileListVO> updateVoList = new ArrayList<AgmtAttachFileListVO>();
			int save_id_cnt = 0;
			for (int i = 0; i < agmtAttachFileListVO.length; i++) {
				if (agmtAttachFileListVO[i].getIbflag().equals("U")) {
					log.debug("[START:: AgreementCorrectionBCImpl]updateVoList=====" + agmtAttachFileListVO[i].getFileSavId());
					deleteVoList.add(agmtAttachFileListVO[i]);
					agmtAttachFileListVO[i].setIbflag("I");
				}

				if (agmtAttachFileListVO[i].getIbflag().equals("D")) {
					log.debug("[START:: AgreementCorrectionBCImpl]deleteVoList=====" + agmtAttachFileListVO[i].getFileSavId());
					agmtAttachFileListVO[i].setAgmtNo(event.getAgmtNo());
					deleteVoList.add(agmtAttachFileListVO[i]);
					UpdateFileMetaInfo.delete(agmtAttachFileListVO[i].getFileSavId());
				} else if (agmtAttachFileListVO[i].getIbflag().equals("I")) {
					log.debug("[START:: AgreementCorrectionBCImpl]insertVoList=====" + agmtAttachFileListVO[i].getFileSavId());
					if (agmtAttachFileListVO[i].getFileSavId() == null || agmtAttachFileListVO[i].getFileSavId().length() == 0) {
						agmtAttachFileListVO[i].setFileSavId(fileSavId[save_id_cnt++]);
					}
					agmtAttachFileListVO[i].setAgmtNo(event.getAgmtNo());
					agmtAttachFileListVO[i].setRgstOfcCd(event.getOfcCd());
					agmtAttachFileListVO[i].setCreUsrId(event.getUsrId());
					agmtAttachFileListVO[i].setUpdUsrId(event.getUsrId());
					insertVoList.add(agmtAttachFileListVO[i]);
				}
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeAgmtAtchFileList(deleteVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addAgmtAtchFileList(insertVoList);

				// insert 있는 경우만 마지막처리 com_upload 테이블과 sync 맞추기
				updateVoList.add(agmtAttachFileListVO[0]);
				dbDao.modifyAgmtAtchFileList(updateVoList);
			}
		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		log.debug("[END::]==========");
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Surcharge Rate Inquiry화면에 대한 Down Excel 이벤트 처리<br>
	 *
	 * @param e EsdTrs0229Event
	 * @return EventResponse EsdTrs0229EventEventResponse
	 * @exception EventException
	 */
	public DBRowSet getRowSet1(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0229Event event=(EsdTrs0229Event)e;
		try {
			rowSet=dbDao.searchCorrScgAgmt(event);
			return rowSet;
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
			titleField = new String[60];
			titleField[0] = " "       ;
			titleField[1] = "TRSP_SCG_CD"       ;
			titleField[2] = "TRSP_COST_MOD_CD"  ;
			titleField[3] = "AGMT_TRSP_TP_CD"   ;
			titleField[4] = "CGO_TP_CD"         ;
			titleField[5] = "CUST_CD"           ;
			titleField[6] = "CMDT_GRP_CD"       ;
			titleField[7] = "RAIL_SVC_TP_CD"    ;
			titleField[8] = "EFF_FM_DT"         ;  
			titleField[9] = "EFF_TO_DT"         ;
			titleField[10] = "AGMT_ROUT_ALL_FLG" ;
			titleField[11] = "FM_NOD_CD"         ;
			titleField[12] = "FM_NOD_YD"         ;
			titleField[13] = "VIA_NOD_CD"        ;
			titleField[14] = "VIA_NOD_YD"        ;
			titleField[15] = "DOR_NOD_CD"        ;
			titleField[16] = "DOR_NOD_YD"        ;
			titleField[17] = "TO_NOD_CD"         ;
			titleField[18] = "TO_NOD_YD"         ;
			titleField[19] = "TRS_AGMT_SCG_RT"   ;
			titleField[20] = "CURR_CD"           ;
			titleField[21] = "TRSP_ONE_WY_RT"    ;
			titleField[22] = "TRSP_RND_RT"       ;
			titleField[23] = "EQ_ALAL"           ; 
			titleField[24] = "EQ_DAL"            ; 
			titleField[25] = "EQ_RAL"            ; 
			titleField[26] = "EQ_AAL"            ; 
			titleField[27] = "EQ_FAL"            ; 
			titleField[28] = "EQ_TAL"            ; 
			titleField[29] = "EQ_SAL"            ; 
			titleField[30] = "EQ_OAL"            ; 
			titleField[31] = "EQ_PAL"            ; 
			titleField[32] = "EQ_AL2"            ; 
			titleField[33] = "EQ_AL4"            ; 
			titleField[34] = "EQ_AL5"            ; 
			titleField[35] = "EQ_AL7"            ; 
			titleField[36] = "EQ_AL9"            ; 
			titleField[37] = "EQ_D2"             ; 
			titleField[38] = "EQ_D4"             ; 
			titleField[39] = "EQ_D5"             ; 
			titleField[40] = "EQ_D7"             ; 
			titleField[41] = "EQ_R2"             ; 
			titleField[42] = "EQ_R4"             ; 
			titleField[43] = "EQ_R5"             ; 
			titleField[44] = "EQ_R7"             ; 
			titleField[45] = "EQ_A2"             ; 
			titleField[46] = "EQ_A4"             ; 
			titleField[47] = "EQ_F2"             ; 
			titleField[48] = "EQ_F4"             ; 
			titleField[49] = "EQ_F5"             ; 
			titleField[50] = "EQ_T2"             ; 
			titleField[51] = "EQ_T4"             ; 
			titleField[52] = "EQ_S2"             ; 
			titleField[53] = "EQ_S4"             ; 
			titleField[54] = "EQ_O2"             ; 
			titleField[55] = "EQ_O4"             ; 
			titleField[56] = "EQ_P2"             ; 
			titleField[57] = "EQ_P4"             ; 
			titleField[58] = "TO_WGT"            ;
			titleField[59] = "WGT_MEAS_UT_CD"    ;
			
		} else if (fm_eq_knd_cd.equals("Z")){
			titleField = new String[45];
			titleField[0] = " " ;
			titleField[1] = "TRSP_SCG_CD" ;
			titleField[2] = "TRSP_COST_MOD_CD" ;
			titleField[3] = "AGMT_TRSP_TP_CD" ;
			titleField[4] = "CGO_TP_CD" ;
			titleField[5] = "CUST_CD" ;
			titleField[6] = "CMDT_GRP_CD" ;
			titleField[7] = "RAIL_SVC_TP_CD" ;
			titleField[8] = "EFF_FM_DT" ;
			titleField[9] = "EFF_TO_DT" ;
			titleField[10] = "AGMT_ROUT_ALL_FLG" ;
			titleField[11] = "FM_NOD_CD" ;
			titleField[12] = "FM_NOD_YD" ;
			titleField[13] = "VIA_NOD_CD" ;
			titleField[14] = "VIA_NOD_YD" ;
			titleField[15] = "DOR_NOD_CD" ;
			titleField[16] = "DOR_NOD_YD" ;
			titleField[17] = "TO_NOD_CD" ;
			titleField[18] = "TO_NOD_YD" ;
			titleField[19] = "TRS_AGMT_SCG_RT" ;
			titleField[20] = "CURR_CD" ;
			titleField[21] = "TRSP_ONE_WY_RT" ;
			titleField[22] = "TRSP_RND_RT" ;
			titleField[23] = "EQ_ALAL" ;
			titleField[24] = "EQ_SFAL" ;
			titleField[25] = "EQ_SLAL" ;
			titleField[26] = "EQ_TAAL" ;
			titleField[27] = "EQ_GNAL" ;
			titleField[28] = "EQ_EGAL" ;
			titleField[29] = "EQ_AL2" ;
			titleField[30] = "EQ_AL4" ;
			titleField[31] = "EQ_AL5" ;
			titleField[32] = "EQ_AL8" ;
			titleField[33] = "EQ_SF2" ;
			titleField[34] = "EQ_SF4" ;
			titleField[35] = "EQ_SL2" ;
			titleField[36] = "EQ_TA2" ;
			titleField[37] = "EQ_GN4" ;
			titleField[38] = "EQ_GN5" ;
			titleField[39] = "EQ_EG5" ;
			titleField[40] = "EQ_EG8" ;
			titleField[41] = "EQ_ZT4" ;
			titleField[42] = "EQ_CB4" ;
			titleField[43] = "TO_WGT" ;
			titleField[44] = "WGT_MEAS_UT_CD" ;

		} else if (fm_eq_knd_cd.equals("G")){
			titleField = new String[28];
			titleField[0] = " " ;
			titleField[1] = "TRSP_SCG_CD" ;
			titleField[2] = "TRSP_COST_MOD_CD" ;
			titleField[3] = "AGMT_TRSP_TP_CD" ;
			titleField[4] = "CGO_TP_CD" ;
			titleField[5] = "CUST_CD" ;
			titleField[6] = "CMDT_GRP_CD" ;
			titleField[7] = "RAIL_SVC_TP_CD" ;
			titleField[8] = "EFF_FM_DT" ;
			titleField[9] = "EFF_TO_DT" ;
			titleField[10] = "AGMT_ROUT_ALL_FLG" ;
			titleField[11] = "FM_NOD_CD" ;
			titleField[12] = "FM_NOD_YD" ;
			titleField[13] = "VIA_NOD_CD" ;
			titleField[14] = "VIA_NOD_YD" ;
			titleField[15] = "DOR_NOD_CD" ;
			titleField[16] = "DOR_NOD_YD" ;
			titleField[17] = "TO_NOD_CD" ;
			titleField[18] = "TO_NOD_YD" ;
			titleField[19] = "TRS_AGMT_SCG_RT" ;
			titleField[20] = "CURR_CD" ;
			titleField[21] = "TRSP_ONE_WY_RT" ;
			titleField[22] = "TRSP_RND_RT" ;
			titleField[23] = "EQ_ALAL" ;
			titleField[24] = "EQ_CG" ;
			titleField[25] = "EQ_UG" ;
			titleField[26] = "TO_WGT" ;
			titleField[27] = "WGT_MEAS_UT_CD" ;
		}

		return titleField;
	}	
	
	@Override
	public String[] getTitle1(String fm_eq_knd_cd) {
		String[] title = null;
		// 엑셀의 컬럼헤더 정의
		if(fm_eq_knd_cd.equals("U")){
			title = new String[60];
			title[0] = "Seq.";
			title[1] = "Surcharge";
			title[2] = "RateType";
			title[3] = "RateType";
			title[4] = "RateType";
			title[5] = "RateType";
			title[6] = "RateType";
			title[7] = "RateType";
			title[8] = "EffectiveDate";
			title[9] = "EffectiveDate";
			title[10] = "AllRoute";
			title[11] = "From";
			title[12] = "From";
			title[13] = "Via";
			title[14] = "Via";
			title[15] = "Door";
			title[16] = "Door";
			title[17] = "To";
			title[18] = "To";
			title[19] = "Fixed Ratio Div";
			title[20] = "Currency";
			title[21] = "One Way";
			title[22] = "Round Trip";
			title[23] = "EQType/Size";
			title[24] = "EQType/Size";
			title[25] = "EQType/Size";
			title[26] = "EQType/Size";
			title[27] = "EQType/Size";
			title[28] = "EQType/Size";
			title[29] = "EQType/Size";
			title[30] = "EQType/Size";
			title[31] = "EQType/Size";
			title[32] = "EQType/Size";
			title[33] = "EQType/Size";
			title[34] = "EQType/Size";
			title[35] = "EQType/Size";
			title[36] = "EQType/Size";
			title[37] = "EQType/Size";
			title[38] = "EQType/Size";
			title[39] = "EQType/Size";
			title[40] = "EQType/Size";
			title[41] = "EQType/Size";
			title[42] = "EQType/Size";
			title[43] = "EQType/Size";
			title[44] = "EQType/Size";
			title[45] = "EQType/Size";
			title[46] = "EQType/Size";
			title[47] = "EQType/Size";
			title[48] = "EQType/Size";
			title[49] = "EQType/Size";
			title[50] = "EQType/Size";
			title[51] = "EQType/Size";
			title[52] = "EQType/Size";
			title[53] = "EQType/Size";
			title[54] = "EQType/Size";
			title[55] = "EQType/Size";
			title[56] = "EQType/Size";
			title[57] = "EQType/Size";
			title[58] = "Weight Tier";
			title[59] = "UOM";

		} else if (fm_eq_knd_cd.equals("Z")){
			title = new String[45];
			title[0] = "Seq.";
			title[1] = "Surcharge";
			title[2] = "RateType";
			title[3] = "RateType";
			title[4] = "RateType";
			title[5] = "RateType";
			title[6] = "RateType";
			title[7] = "RateType";
			title[8] = "EffectiveDate";
			title[9] = "EffectiveDate";
			title[10] = "AllRoute";
			title[11] = "From";
			title[12] = "From";
			title[13] = "Via";
			title[14] = "Via";
			title[15] = "Door";
			title[16] = "Door";
			title[17] = "To";
			title[18] = "To";
			title[19] = "Fixed Ratio Div";
			title[20] = "Currency";
			title[21] = "One Way";
			title[22] = "Round Trip";
			title[23] = "EQType/Size";
			title[24] = "EQType/Size";
			title[25] = "EQType/Size";
			title[26] = "EQType/Size";
			title[27] = "EQType/Size";
			title[28] = "EQType/Size";
			title[29] = "EQType/Size";
			title[30] = "EQType/Size";
			title[31] = "EQType/Size";
			title[32] = "EQType/Size";
			title[33] = "EQType/Size";
			title[34] = "EQType/Size";
			title[35] = "EQType/Size";
			title[36] = "EQType/Size";
			title[37] = "EQType/Size";
			title[38] = "EQType/Size";
			title[39] = "EQType/Size";
			title[40] = "EQType/Size";
			title[41] = "EQType/Size";
			title[42] = "EQType/Size";
			title[43] = "Weight Tier";
			title[44] = "UOM";			
			
		} else if (fm_eq_knd_cd.equals("G")){	
			title = new String[28];
			title[0] = "Seq.";
			title[1] = "Surcharge";
			title[2] = "RateType";
			title[3] = "RateType";
			title[4] = "RateType";
			title[5] = "RateType";
			title[6] = "RateType";
			title[7] = "RateType";
			title[8] = "EffectiveDate";
			title[9] = "EffectiveDate";
			title[10] = "AllRoute";
			title[11] = "From";
			title[12] = "From";
			title[13] = "Via";
			title[14] = "Via";
			title[15] = "Door";
			title[16] = "Door";
			title[17] = "To";
			title[18] = "To";
			title[19] = "Fixed Ratio Div";
			title[20] = "Currency";
			title[21] = "One Way";
			title[22] = "Round Trip";
			title[23] = "EQType/Size";
			title[24] = "EQType/Size";
			title[25] = "EQType/Size";
			title[26] = "Weight Tier";
			title[27] = "UOM";
		}

		return title;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Surcharge Rate Inquiry화면에 대한 Down Excel 이벤트 처리<br>
	 *
	 * @param e EsdTrs0226Event
	 * @return EventResponse EsdTrs0226EventEventResponse
	 * @exception EventException
	 */
	public DBRowSet getRowSet2(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0226Event event=(EsdTrs0226Event)e;
		try {
			rowSet=dbDao.searchCorrRateAgmt(event);
			return rowSet;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	@Override
	public String[] getColumns2(String fm_eq_knd_cd) {
		String[] titleField = null ;
		
		// 컬럼헤더와 매핑되는 DB Column 명 정의
		if(fm_eq_knd_cd.equals("U")){
			titleField = new String[64];
			titleField[0] = " ";
			titleField[1] = "TRSP_COST_MOD_CD";
			titleField[2] = "AGMT_TRSP_TP_CD";
			titleField[3] = "CGO_TP_CD";
			titleField[4] = "CUST_CD";
			titleField[5] = "CMDT_GRP_CD";
			titleField[6] = "RAIL_SVC_TP_CD";
			titleField[7] = "FM_NOD_CD";
			titleField[8] = "FM_NOD_YD";
			titleField[9] = "VIA_NOD_CD";
			titleField[10] = "VIA_NOD_YD";
			titleField[11] = "DOR_NOD_CD";
			titleField[12] = "DOR_NOD_YD";
			titleField[13] = "TO_NOD_CD";
			titleField[14] = "TO_NOD_YD";
			titleField[15] = "TRSP_DIST_TP_CD";
			titleField[16] = "TRSP_AGMT_DIST";
			titleField[17] = "DIST_MEAS_UT_CD";
			titleField[18] = "CURR_CD";
			titleField[19] = "EQ_ALAL";
			titleField[20] = "EQ_DAL";
			titleField[21] = "EQ_RAL";
			titleField[22] = "EQ_AAL";
			titleField[23] = "EQ_FAL";
			titleField[24] = "EQ_TAL";
			titleField[25] = "EQ_SAL";
			titleField[26] = "EQ_OAL";
			titleField[27] = "EQ_PAL";
			titleField[28] = "EQ_AL2";
			titleField[29] = "EQ_AL4";
			titleField[30] = "EQ_AL5";
			titleField[31] = "EQ_AL7";
			titleField[32] = "EQ_AL9";
			titleField[33] = "EQ_D2";
			titleField[34] = "EQ_D4";
			titleField[35] = "EQ_D5";
			titleField[36] = "EQ_D7";
			titleField[37] = "EQ_R2";
			titleField[38] = "EQ_R4";
			titleField[39] = "EQ_R5";
			titleField[40] = "EQ_R7";
			titleField[41] = "EQ_A2";
			titleField[42] = "EQ_A4";
			titleField[43] = "EQ_F2";
			titleField[44] = "EQ_F4";
			titleField[45] = "EQ_F5";
			titleField[46] = "EQ_T2";
			titleField[47] = "EQ_T4";
			titleField[48] = "EQ_S2";
			titleField[49] = "EQ_S4";
			titleField[50] = "EQ_O2";
			titleField[51] = "EQ_O4";
			titleField[52] = "EQ_P2";
			titleField[53] = "EQ_P4";
			titleField[54] = "TRSP_ONE_WY_RT";
			titleField[55] = "TRSP_RND_RT";
			titleField[56] = "WTR_RCV_TERM_CD";
			titleField[57] = "WTR_DE_TERM_CD";
			titleField[58] = "TRSP_AGMT_BDL_QTY";
			titleField[59] = "TO_WGT";
			titleField[60] = "WGT_MEAS_UT_CD";
			titleField[61] = "TRSP_RVS_APLY_FLG";
			titleField[62] = "EFF_FM_DT";
			titleField[63] = "EFF_TO_DT";
			
		} else if (fm_eq_knd_cd.equals("Z")){
			titleField = new String[47];
			titleField[0] = " " ;
			titleField[1] = "TRSP_COST_MOD_CD" ;
			titleField[2] = "AGMT_TRSP_TP_CD" ;
			titleField[3] = "CGO_TP_CD" ;
			titleField[4] = "CUST_CD" ;
			titleField[5] = "CMDT_GRP_CD" ;
			titleField[6] = "RAIL_SVC_TP_CD" ;
			titleField[7] = "FM_NOD_CD" ;
			titleField[8] = "FM_NOD_YD" ;
			titleField[9] = "VIA_NOD_CD" ;
			titleField[10] = "VIA_NOD_YD" ;
			titleField[11] = "DOR_NOD_CD" ;
			titleField[12] = "DOR_NOD_YD" ;
			titleField[13] = "TO_NOD_CD" ;
			titleField[14] = "TO_NOD_YD" ;
			titleField[15] = "TRSP_DIST_TP_CD" ;
			titleField[16] = "TRSP_AGMT_DIST" ;
			titleField[17] = "DIST_MEAS_UT_CD" ;
			titleField[18] = "CURR_CD" ;
			titleField[19] = "EQ_ALAL" ;
			titleField[20] = "EQ_SFAL" ;
			titleField[21] = "EQ_SLAL" ;
			titleField[22] = "EQ_TAAL" ;
			titleField[23] = "EQ_GNAL" ;
			titleField[24] = "EQ_EGAL" ;
			titleField[25] = "EQ_AL2" ;
			titleField[26] = "EQ_AL4" ;
			titleField[27] = "EQ_AL5" ;
			titleField[28] = "EQ_AL8" ;
			titleField[29] = "EQ_SF2" ;
			titleField[30] = "EQ_SF4" ;
			titleField[31] = "EQ_SL2" ;
			titleField[32] = "EQ_TA2" ;
			titleField[33] = "EQ_GN4" ;
			titleField[34] = "EQ_GN5" ;
			titleField[35] = "EQ_EG5" ;
			titleField[36] = "EQ_EG8" ;
			titleField[37] = "EQ_ZT4" ;
			titleField[38] = "EQ_CB4" ;
			titleField[39] = "TRSP_ONE_WY_RT" ;
			titleField[40] = "TRSP_RND_RT" ;
			titleField[41] = "WTR_RCV_TERM_CD" ;
			titleField[42] = "WTR_DE_TERM_CD" ;
			titleField[43] = "TRSP_AGMT_BDL_QTY" ;
			titleField[44] = "TRSP_RVS_APLY_FLG" ;
			titleField[45] = "EFF_FM_DT" ;
			titleField[46] = "EFF_TO_DT" ;
			
		} else if (fm_eq_knd_cd.equals("G")){
			titleField = new String[30];
			titleField[0] = " " ;
			titleField[1] = "TRSP_COST_MOD_CD" ;
			titleField[2] = "AGMT_TRSP_TP_CD" ;
			titleField[3] = "CGO_TP_CD" ;
			titleField[4] = "CUST_CD" ;
			titleField[5] = "CMDT_GRP_CD" ;
			titleField[6] = "RAIL_SVC_TP_CD" ;
			titleField[7] = "FM_NOD_CD" ;
			titleField[8] = "FM_NOD_YD" ;
			titleField[9] = "VIA_NOD_CD" ;
			titleField[10] = "VIA_NOD_YD" ;
			titleField[11] = "DOR_NOD_CD" ;
			titleField[12] = "DOR_NOD_YD" ;
			titleField[13] = "TO_NOD_CD" ;
			titleField[14] = "TO_NOD_YD" ;
			titleField[15] = "TRSP_DIST_TP_CD" ;
			titleField[16] = "TRSP_AGMT_DIST" ;
			titleField[17] = "DIST_MEAS_UT_CD" ;
			titleField[18] = "CURR_CD" ;
			titleField[19] = "EQ_ALAL" ;
			titleField[20] = "EQ_CG" ;
			titleField[21] = "EQ_UG" ;
			titleField[22] = "TRSP_ONE_WY_RT" ;
			titleField[23] = "TRSP_RND_RT" ;
			titleField[24] = "WTR_RCV_TERM_CD" ;
			titleField[25] = "WTR_DE_TERM_CD" ;
			titleField[26] = "TRSP_AGMT_BDL_QTY" ;
			titleField[27] = "TRSP_RVS_APLY_FLG" ;
			titleField[28] = "EFF_FM_DT" ;
			titleField[29] = "EFF_TO_DT" ;

		}
		
		return titleField;
	}	
	
	@Override
	public String[] getTitle2(String fm_eq_knd_cd) {
		String[] title = null;
		// 엑셀의 컬럼헤더 정의
		if(fm_eq_knd_cd.equals("U")){
			title = new String[64];
			title[0] = "Seq.";
			title[1] = "Rate Type" ;
			title[2] = "Rate Type" ;
			title[3] = "Rate Type" ;
			title[4] = "Rate Type" ;
			title[5] = "Rate Type" ;
			title[6] = "Rate Type" ;
			title[7] = "From" ;
			title[8] = "From" ;
			title[9] = "Via" ;
			title[10] = "Via" ;
			title[11] = "Door" ;
			title[12] = "Door" ;
			title[13] = "To" ;
			title[14] = "To" ;
			title[15] = "Fixed or Per Distance" ;
			title[16] = "To Distance" ;
			title[17] = "To Distance" ;
			title[18] = "Currency" ;
			title[19] = "EQ Type/Size" ;
			title[20] = "EQ Type/Size" ;
			title[21] = "EQ Type/Size" ;
			title[22] = "EQ Type/Size" ;
			title[23] = "EQ Type/Size" ;
			title[24] = "EQ Type/Size" ;
			title[25] = "EQ Type/Size" ;
			title[26] = "EQ Type/Size" ;
			title[27] = "EQ Type/Size" ;
			title[28] = "EQ Type/Size" ;
			title[29] = "EQ Type/Size" ;
			title[30] = "EQ Type/Size" ;
			title[31] = "EQ Type/Size" ;
			title[32] = "EQ Type/Size" ;
			title[33] = "EQ Type/Size" ;
			title[34] = "EQ Type/Size" ;
			title[35] = "EQ Type/Size" ;
			title[36] = "EQ Type/Size" ;
			title[37] = "EQ Type/Size" ;
			title[38] = "EQ Type/Size" ;
			title[39] = "EQ Type/Size" ;
			title[40] = "EQ Type/Size" ;
			title[41] = "EQ Type/Size" ;
			title[42] = "EQ Type/Size" ;
			title[43] = "EQ Type/Size" ;
			title[44] = "EQ Type/Size" ;
			title[45] = "EQ Type/Size" ;
			title[46] = "EQ Type/Size" ;
			title[47] = "EQ Type/Size" ;
			title[48] = "EQ Type/Size" ;
			title[49] = "EQ Type/Size" ;
			title[50] = "EQ Type/Size" ;
			title[51] = "EQ Type/Size" ;
			title[52] = "EQ Type/Size" ;
			title[53] = "EQ Type/Size" ;
			title[54] = "One Way" ;
			title[55] = "Round Trip" ;
			title[56] = "Feeder Term" ;
			title[57] = "Feeder Term" ;
			title[58] = "No of Container" ;
			title[59] = "Weight Tier" ;
			title[60] = "UOM" ;
			title[61] = "Reverse" ;
			title[62] = "Effective Date" ;
			title[63] = "Effective Date" ;
			
		} else if (fm_eq_knd_cd.equals("Z")){
			title = new String[47];
			title[0] = "Seq.";
			title[1] = "Rate Type" ;
			title[2] = "Rate Type" ;
			title[3] = "Rate Type" ;
			title[4] = "Rate Type" ;
			title[5] = "Rate Type" ;
			title[6] = "Rate Type" ;
			title[7] = "From" ;
			title[8] = "From" ;
			title[9] = "Via" ;
			title[10] = "Via" ;
			title[11] = "Door" ;
			title[12] = "Door" ;
			title[13] = "To" ;
			title[14] = "To" ;
			title[15] = "Fixed or Per Distance" ;
			title[16] = "To Distance" ;
			title[17] = "To Distance" ;
			title[18] = "Currency" ;
			title[19] = "EQ Type/Size" ;
			title[20] = "EQ Type/Size" ;
			title[21] = "EQ Type/Size" ;
			title[22] = "EQ Type/Size" ;
			title[23] = "EQ Type/Size" ;
			title[24] = "EQ Type/Size" ;
			title[25] = "EQ Type/Size" ;
			title[26] = "EQ Type/Size" ;
			title[27] = "EQ Type/Size" ;
			title[28] = "EQ Type/Size" ;
			title[29] = "EQ Type/Size" ;
			title[30] = "EQ Type/Size" ;
			title[31] = "EQ Type/Size" ;
			title[32] = "EQ Type/Size" ;
			title[33] = "EQ Type/Size" ;
			title[34] = "EQ Type/Size" ;
			title[35] = "EQ Type/Size" ;
			title[36] = "EQ Type/Size" ;
			title[37] = "EQ Type/Size" ;
			title[38] = "EQ Type/Size" ;
			title[39] = "One Way" ;
			title[40] = "Round Trip" ;
			title[41] = "Feeder Term" ;
			title[42] = "Feeder Term" ;
			title[43] = "No of Chassis" ;
			title[44] = "Reverse" ;
			title[45] = "Effective Date" ;
			title[46] = "Effective Date" ;		
			
		} else if (fm_eq_knd_cd.equals("G")){	
			title = new String[30];
			title[0] = "Seq.";
			title[1] = "Rate Type" ;
			title[2] = "Rate Type" ;
			title[3] = "Rate Type" ;
			title[4] = "Rate Type" ;
			title[5] = "Rate Type" ;
			title[6] = "Rate Type" ;
			title[7] = "From" ;
			title[8] = "From" ;
			title[9] = "Via" ;
			title[10] = "Via" ;
			title[11] = "Door" ;
			title[12] = "Door" ;
			title[13] = "To" ;
			title[14] = "To" ;
			title[15] = "Fixed or Per Distance" ;
			title[16] = "To Distance" ;
			title[17] = "To Distance" ;
			title[18] = "Currency" ;
			title[19] = "EQ Type/Size" ;
			title[20] = "EQ Type/Size" ;
			title[21] = "EQ Type/Size" ;
			title[22] = "One Way" ;
			title[23] = "Round Trip" ;
			title[24] = "Feeder Term" ;
			title[25] = "Feeder Term" ;
			title[26] = "No of Genset" ;
			title[27] = "Reverse" ;
			title[28] = "Effective Date" ;
			title[29] = "Effective Date" ;
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