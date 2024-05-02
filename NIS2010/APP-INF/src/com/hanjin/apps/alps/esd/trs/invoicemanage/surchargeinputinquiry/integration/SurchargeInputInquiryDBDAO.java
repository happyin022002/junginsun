/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SurchargeInputInquiryDBDAO.java
*@FileTitle : surcharge 입력/수정/삭제화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-17
*@LastModifier : Bong-jun
*@LastVersion : 1.8
* 2006-11-21 poong_yeon
* 1.0 최초 생성
* 1.13 N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청 (09.03.17)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.basic.SurchargeInputInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.event.EsdTrs0918Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspWrkOrdInstrVO;


/**
 * ESD-InvoiceManage에 대한 DB 처리를 담당<br>
 * - ESD-InvoiceManage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong_yeon
 * @see SurchargeInputInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class SurchargeInputInquiryDBDAO extends DBDAOSupport {

	/**
	 * SurchargeInputInquiry의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSurchargeInputInquiryList(EsdTrs0918Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			String trsp_so_ofc_cty_cd = event.getTrspSoOfcCtyCd();
			String trsp_so_seq = event.getTrspSoSeq();
			
			param.put("TRSP_SO_OFC_CTY_CD", trsp_so_ofc_cty_cd);
			param.put("TRSP_SO_SEQ", trsp_so_seq);
			
			dRs = new SQLExecuter().executeQuery(new SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	   }

	/**
	 * surcharge의 모든 코드와 코드명을 가지고 온다 .<br>
	 * 
	 * @param event 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSurchargeCodeNameList(EsdTrs0918Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			dRs = new SQLExecuter().executeQuery(new SurchargeInputInquiryDBDAOsearchSurchargeCodeNameListRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	   }	

	/**
	 * 서차지 항목을 temp 에 추가.<br>
	 * 
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet addTempSurchargeList(EsdTrs0918Event event) throws DAOException {

		DBRowSet dRs = null;
		DBRowSet returnRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SurchargeVO[] scModels = event.getSurchargeVOs();
		SurchargeVO scModel = null;
		String groupSeq = "";
		
		try {
			/* TEMP GROUP SEQ SELECT */
			dRs = new SQLExecuter().executeQuery(new SurchargeInputInquiryDBDAOaddTempSurchargeListRSQL(), param,param);
			returnRs = dRs.createCopy();
			if(dRs.next()){
				groupSeq = dRs.getString("GROUP_SEQ");
			}
			
			/***** surcharge insert start  ****/
			if (scModels != null && scModels.length > 0){
				
				for(int i=0; i<scModels.length; i++){
					
					scModel = scModels[i];
					
					param.put("TRSP_SO_OFC_CTY_CD", scModel.getTrspSoOfcCtyCd());
					param.put("TRSP_SO_SEQ", scModel.getTrspSoSeq());
					param.put("LGS_COST_CD", scModel.getLgsCostCd());
					param.put("WO_PRV_GRP_SEQ", groupSeq);
					param.put("SCG_AMT", JSPUtil.removeCharacter(scModel.getScgAmt(),","));  
//					param.put("CHSS_MGST_TPSZ_CD", scModel.getChssMgstTpszCd());
					param.put("DRY_RUN_RLBL_PTY_TP_CD", scModel.getDryRunRlblPtyTpCd());
					param.put("FNE_CUZ_DESC", scModel.getFneCuzDesc());
					param.put("FUMG_COST_TP_CD", scModel.getFumgCostTpCd());
					param.put("MGST_TPSZ_CD", scModel.getMgstTpszCd());
					param.put("INSP_RF_PTI_CSTMS_TP_CD", scModel.getInspRfPtiCstmsTpCd());
					param.put("LFTG_KNT", scModel.getLftgKnt());
					param.put("LFTG_CUZ_DESC", scModel.getLftgCuzDesc());
					param.put("STOP_LOC_NOD_CD", scModel.getStopLocNodCd());
					param.put("GRS_WGT", JSPUtil.removeCharacter(scModel.getGrsWgt(),","));
					param.put("INCRT_DT", scModel.getIncrtDt());
					param.put("SCL_STOP_PLC_NOD_CD", scModel.getSclStopPlcNodCd());        //sclStopPlcNodCd
					param.put("STO_DYS", scModel.getStoDys());
					param.put("OB_BKG_NO", scModel.getObBkgNo());
					param.put("WT_HRS", scModel.getWtHrs());
					param.put("OTR_RMK", scModel.getOtrRmk());
					param.put("INV_SCG_AMT", JSPUtil.removeCharacter(scModel.getInvScgAmt(),","));                //invScgAmt
//					param.put("INV_CHSS_MGST_TPSZ_CD", scModel.getInvChssMgstTpszCd());      //invChssMgstTpszCd
					param.put("INV_DRY_RUN_RLBL_PTY_TP_CD", scModel.getInvDryRunRlblPtyTpCd()); //invDryRunRlblPtyTpCd
					param.put("INV_FNE_CUZ_DESC", scModel.getInvFneCuzDesc());           //invFneCuzDesc
					param.put("INV_FUMG_COST_TP_CD", scModel.getInvFumgCostTpCd());        //invFumgCostTpCd
					param.put("INV_MGST_TPSZ_CD", scModel.getInvMgstTpszCd());           //invMgstTpszCd
					param.put("INV_INSP_RF_PTI_CSTMS_TP_CD", scModel.getInvInspRfPtiCstmsTpCd());//invInspRfPtiCstmsTpCd
					param.put("INV_LFTG_KNT", scModel.getInvLftgKnt());               //invLftgKnt
					param.put("INV_LFTG_CUZ_DESC", scModel.getInvLftgCuzDesc());          //invLftgCuzDesc
					param.put("INV_STOP_LOC_NOD_CD", scModel.getInvStopLocNodCd());        //invStopLocNodCd
					param.put("INV_GRS_WGT", JSPUtil.removeCharacter(scModel.getInvGrsWgt(),","));                //invGrsWgt
					param.put("INV_INCRT_DT", scModel.getInvIncrtDt());               //invIncrtDt
					param.put("INV_SCL_STOP_PLC_NOD_CD", scModel.getInvSclStopPlcNodCd());    //invSclStopPlcNodCd
					param.put("INV_STO_DYS", scModel.getInvStoDys());                //invStoDys
					param.put("INV_OB_BKG_NO", scModel.getInvObBkgNo());              //invObBkgNo
					param.put("INV_WT_HRS", scModel.getInvWtHrs());                 //invWtHrs
					param.put("INV_OTR_RMK", scModel.getInvOtrRmk());                //invOtrRmk
					param.put("N3PTY_BIL_FLG", scModel.getN3ptyBilFlg());
					param.put("CUST_CNT_CD", scModel.getCustCntCd());
					param.put("CUST_SEQ", scModel.getCustSeq());
					param.put("N3PTY_VNDR_SEQ", scModel.getN3ptyVndrSeq());
					param.put("N3PTY_OFC_CD", scModel.getN3ptyOfcCd());
					param.put("N3PTY_AMT", JSPUtil.removeCharacter(scModel.getN3ptyAmt(),","));
					param.put("N3PTY_DESC", scModel.getN3ptyDesc());
					param.put("CRE_OFC_CD", event.getFormUsrOfcCd());
					param.put("CRE_USR_ID", event.getFormCreUsrId());
					param.put("UPD_USR_ID", event.getFormCreUsrId());
					param.put("FOR_USR_OFC_CD", event.getFormUsrOfcCd());
					// incurred date, chassis no 추가분
					param.put("INCUR_DT", scModel.getIncurDt());
					param.put("CHSS_NO", scModel.getChssNo());
					param.put("INV_INCUR_DT", scModel.getInvIncurDt());
					param.put("INV_CHSS_NO", scModel.getInvChssNo());
					
					param.put("RF_HNDL_FLG", 			scModel.getRfHndlFlg());
					param.put("RF_MGST_USG_FLG",		scModel.getRfMgstUsgFlg());
					param.put("TRI_AXL_FLG",			scModel.getTriAxlFlg());
					param.put("OVR_WGT_PRMT_FLG",		scModel.getOvrWgtPrmtFlg());
					param.put("OVR_WGT_OTR_FLG",		scModel.getOvrWgtOtrFlg());
					param.put("OVR_WGT_RMK",			scModel.getOvrWgtRmk());
					param.put("INV_RF_HNDL_FLG",		scModel.getInvRfHndlFlg());
					param.put("INV_RF_MGST_USG_FLG",	scModel.getInvRfMgstUsgFlg());
					param.put("INV_TRI_AXL_FLG",		scModel.getInvTriAxlFlg());
					param.put("INV_OVR_WGT_PRMT_FLG",	scModel.getInvOvrWgtPrmtFlg());
					param.put("INV_OVR_WGT_OTR_FLG",	scModel.getInvOvrWgtOtrFlg());
					param.put("INV_OVR_WGT_RMK",		scModel.getInvOvrWgtRmk());
					param.put("TRSP_AGMT_BFR_EXTD_FLG",	scModel.getTrspAgmtBfrExtdFlg());
					
					new SQLExecuter().executeUpdate(new SurchargeInputInquiryDBDAOaddTempSurchargeListCSQL(), param,param);
					
					
				}
			
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return returnRs;
	}
	
	
	/**
	 * SurchargeInputInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
//	public void multiSurchargeInputInquiry(EsdTrs0918Event event) throws DAOException {
//		// Connection Interface   
//		Connection con = null;
//		// INSERT를 수행하기 위한 SQL Statement
//		PreparedStatement insertPs  = null;
//		// UPDATE를 수행하기 위한 SQL Statement
//		PreparedStatement updatePs = null;
//		// DELETE를 수행하기 위한 SQL Statement
//		PreparedStatement deletePs = null;
//		// 수행 결과가 정상인지를 판별하기 위한 변수
//
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		
//		boolean isInsert = false ;
//		boolean isUpdate = false ;
//		boolean isDelete = false ;
//		
//		//입력
//		StringBuffer insertQuery = new StringBuffer();
//		StringBuffer updateQuery = new StringBuffer();
//		StringBuffer deleteQuery = new StringBuffer();
//	
//
//		try {
//			con = getConnection();
//			//			 Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				insertPs = new LoggableStatement(con, insertQuery.toString());
//				updatePs = new LoggableStatement(con, updateQuery.toString());
//				deletePs = new LoggableStatement(con, deleteQuery.toString());
//			} else {
//				insertPs = con.prepareStatement(insertQuery.toString());
//				updatePs = con.prepareStatement(updateQuery.toString());
//				deletePs = con.prepareStatement(deleteQuery.toString());
//			}
//
//			Collection models = event.getTrsTrspScgDtls();
//			Iterator itr = models.iterator();
//			TrsTrspWrkOrdInstrVO model = null;
//
//			while (itr.hasNext()) {
//				model = (TrsTrspWrkOrdInstrVO) itr.next();
//				i = 1;
//				if (model.getIbflag().length() > 0) {
//					if (model.getIbflag().equals("I")) {
//						isInsert = true;
//						insertPs.setString(i++, event.getFormUsrOfcCd()); // WO_INSTR_OFC_CD
//						insertPs.addBatch();
////						insertPs.clearWarnings();
////						insertPs.clearParameters();
//					} else if (model.getIbflag().equals("U")) {
//						isUpdate = true ;
//						updatePs.setString(i++, event.getFormCreUsrId()); // UPD_USR_ID
//						updatePs.addBatch();
////						updatePs.clearWarnings();
////						updatePs.clearParameters();
//					} else if (model.getIbflag().equals("D")) {
//						isDelete = true ;
//						deletePs.addBatch();
////						deletePs.clearWarnings();
////						deletePs.clearParameters();
//					}
//					i = 1;
//				}
//			}
//		
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				if( isInsert ) log.info("\n SQL :" + ((LoggableStatement)insertPs).getQueryString());
//				if( isUpdate ) log.info("\n SQL :" + ((LoggableStatement)updatePs).getQueryString());
//				if( isDelete ) log.info("\n SQL :" + ((LoggableStatement)deletePs).getQueryString());
//			} else {
//				if( isInsert ) log.info("\n SQL :" + insertQuery );
//				if( isUpdate ) log.info("\n SQL :" + updateQuery );
//				if( isDelete ) log.info("\n SQL :" + deleteQuery );
//			}
//
//			if( isInsert ) insertPs.executeBatch();
//			if( isUpdate ) updatePs.executeBatch();
//			if( isDelete ) deletePs.executeBatch();
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(),de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(insertPs);
//			closeStatement(updatePs);
//			closeStatement(deletePs);
//			closeConnection(con);
//		}
//	}
	
	/**
	 * SurchargeInputInquiry의 모든 목록을 가져온다.<br>
	 *  1.13 N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청 (09.03.17)
	 * 
	 * @param event 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTPBIfFlag(EsdTrs0918Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			String trsp_so_ofc_cty_cd = event.getTrspSoOfcCtyCd();
			String trsp_so_seq = event.getTrspSoSeq();
			log.info("TRSP_SO_OFC_CTY_CD::::::"+trsp_so_ofc_cty_cd+trsp_so_seq);
			
			param.put("TRSP_SO_OFC_CTY_CD", trsp_so_ofc_cty_cd);
			param.put("TRSP_SO_SEQ", trsp_so_seq);
			
			dRs = new SQLExecuter().executeQuery(new SurchargeInputInquiryDBDAOsearchTPBIfFlagRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	   }
	
	
}

