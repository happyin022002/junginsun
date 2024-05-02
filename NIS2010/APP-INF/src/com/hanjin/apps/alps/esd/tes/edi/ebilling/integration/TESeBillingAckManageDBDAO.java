/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESInterfaceManageDBDAO.java
*@FileTitle : TDR_RESTOW Data Interface to VSK_TDR_RHND
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
*2012-01-04
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiAckSndLogVO;
import com.hanjin.syscommon.common.table.TesEdiAckSndLogInvVO;
//import com.hanjin.syscommon.common.table.TesEdiAckSndLogVO;
import com.hanjin.syscommon.common.table.TesEdiSndAckMnRuleVO;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;

/**
 * ALPS-ESD에 대한 DB 처리를 담당<br>
 * - ALPS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see TESInterfaceManageBCImpl 참조
 * @since J2EE 1.4
 */
public class TESeBillingAckManageDBDAO extends DBDAOSupport {

	/**
	 * ACK 전송 규칙 정보 조회
	 * @param ack_act_tp_cd
	 * @return List<TesEdiSndAckMnRuleVO>
	 * @throws DAOException
	 */
	public List<TesEdiSndAckMnRuleVO> getAckSendAckMainRule(String ack_act_tp_cd) throws DAOException {
		log.debug("\n BBB -  TESeBillingAckManageDBDAO.getAckSendAckMainRule - ########################################### ");
		
		List<TesEdiSndAckMnRuleVO> tesEdiSndAckMnRuleVOList = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ack_act_tp_cd", JSPUtil.getNull(ack_act_tp_cd));
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingAckManageDBDAOGetAckSendAckMainRuleRSQL(), param, velParam);
			if (dbRowset!=null){
				tesEdiSndAckMnRuleVOList = (List)RowSetUtil.rowSetToVOs(dbRowset,TesEdiSndAckMnRuleVO.class);
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
		log.debug("\n EEE -  TESeBillingAckManageDBDAO.getAckSendAckMainRule - ########################################### ");
		
		return tesEdiSndAckMnRuleVOList;		
	}
	
	/**
	 * ACK SEND LOG의 SEQ 생성
	 * @return String
	 * @throws DAOException
	 */
	public String createAckSendSeq() throws DAOException {	
		log.debug("\n BBB -  TESeBillingAckManageDBDAO.createAckSendSeq - ########################################### ");
		
		DBRowSet dbRowset = null;
		String so_seq = null;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingAckManageDBDAOCreateAckSendSeqRSQL(), null, null);
			if (dbRowset != null && dbRowset.next()){
				so_seq = dbRowset.getString("ACK_EDI_LOG_HDR_SEQ");
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
		log.debug("\n EEE -  TESeBillingAckManageDBDAO.createAckSendSeq - ########################################### ");
		
		return so_seq;
	}
	
	/**
	 * ACK SEND LOG의 FILE SEQ 생성
	 * @return String
	 * @throws DAOException
	 */
	public String createAckSendFileSeq() throws DAOException {	
		log.debug("\n BBB -  TESeBillingAckManageDBDAO.createAckSendFileSeq - ########################################### ");
		
		DBRowSet dbRowset = null;
		String so_seq = null;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingAckManageDBDAOCreateAckSendFileSeqRSQL(), null, null);
			if (dbRowset != null && dbRowset.next()){
				so_seq = dbRowset.getString("ACK_EDI_LOG_FILE_SEQ");
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
		log.debug("\n EEE -  TESeBillingAckManageDBDAO.createAckSendFileSeq - ########################################### ");
		
		return so_seq;
	}
	
	/**
	 * ACK SEND 생성 대상 EDI invoice 목록 조회
	 * @param tesEdiSndAckMainRuleVO
	 * @return List<TesEdiSoHdrVO>
	 * @throws DAOException
	 */
	public List<TesEdiSoHdrVO> getAckSendEDIInvoiceList(TesEdiSndAckMnRuleVO tesEdiSndAckMainRuleVO) throws DAOException {
		log.debug("\n BBB -  TESeBillingAckManageDBDAO.getAckSendEDIInvoiceList - ########################################### ");
		
		List<TesEdiSoHdrVO> tesEdiSoHdrVOLst = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tesEdiSndAckMainRuleVO!=null){
				param.put("vndr_seq", JSPUtil.getNull(tesEdiSndAckMainRuleVO.getEdiVndrSeq() ));
				param.put("ofc_cd", JSPUtil.getNull(tesEdiSndAckMainRuleVO.getInvOfcCd()));
				param.put("lmt_knt", JSPUtil.getNull(tesEdiSndAckMainRuleVO.getExeRowKnt()));
				param.put("ack_act_tp_cd", JSPUtil.getNull(tesEdiSndAckMainRuleVO.getAckActTpCd()));
				param.put("cfm_dt", JSPUtil.getNull(tesEdiSndAckMainRuleVO.getCfmDt()));
				velParam.put("lmt_knt", JSPUtil.getNull(tesEdiSndAckMainRuleVO.getExeRowKnt()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingAckManageDBDAOGetAckSendEDIInvoiceListRSQL(), param, velParam);
				if (dbRowset!=null){
					tesEdiSoHdrVOLst = (List)RowSetUtil.rowSetToVOs(dbRowset,TesEdiSoHdrVO.class);
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
		log.debug("\n EEE -  TESeBillingAckManageDBDAO.getAckSendEDIInvoiceList - ########################################### ");
		
		return tesEdiSoHdrVOLst;
	}
	
	/**
	 * ACK EDI LOG 정보 넣기
	 * @param tesEdiAckSndLogVO
	 * @return String
	 * @throws DAOException
	 */
	public String creategAckEdiLog(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws DAOException{
		log.debug("\n BEGIN - TESeBillingAckManageDBDAO.creategAckEdiLog - ########################################### ");

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tesEdiAckSndLogVO!=null){
				param.put("edi_snd_dt", tesEdiAckSndLogVO.getEdiSndDt());
				param.put("snd_log_seq", tesEdiAckSndLogVO.getSndLogSeq());
				param.put("ack_snd_sts_cd", tesEdiAckSndLogVO.getAckSndStsCd());
				param.put("ack_act_tp_cd", tesEdiAckSndLogVO.getAckActTpCd());
				param.put("edi_msg", tesEdiAckSndLogVO.getEdiMsg());
				param.put("rcvr_id", tesEdiAckSndLogVO.getRcvrId());
				param.put("sndr_id", tesEdiAckSndLogVO.getSndrId());
				param.put("file_seq", tesEdiAckSndLogVO.getFileSeq());
				param.put("vndr_seq", tesEdiAckSndLogVO.getVndrSeq());
				param.put("ofc_cd", tesEdiAckSndLogVO.getOfcCd());
				param.put("edi_rmk", "");
				
				int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingAckManageDBDAOCreategAckEdiLogCSQL(), param, velParam);			
				if (insCnt > 0){
					return "Y";
				} else {
					throw new DAOException(new ErrorHandler("COM11001").getMessage());//데이터 반영에 실패하였습니다.
				}
			} else {
				throw new DAOException(new ErrorHandler("COM11001").getMessage());//데이터 반영에 실패하였습니다.
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
	}
	
	/**
	 * ACK EDI LOG INVOICE 정보 넣기
	 * @param tesEdiAckSndLogInvVOLst
	 * @throws DAOException
	 */
	public void creategAckEdiLogInv(List<TesEdiAckSndLogInvVO> tesEdiAckSndLogInvVOLst) throws DAOException {
		log.debug("\n BEGIN - TESeBillingAckManageDBDAO.creategAckEdiLogInv - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt[] = null;		
		
		try {
			if (tesEdiAckSndLogInvVOLst.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TESeBillingAckManageDBDAOCreategAckEdiLogInvCSQL(), tesEdiAckSndLogInvVOLst, velParam, param);
				for (int i = 0; i < insCnt.length; i++){
					if (insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
		log.debug("\n END - TESeBillingAckManageDBDAO.creategAckEdiLogInv - ########################################### ");
	}
	
	/**
	 * ACK SEND F/F 생성 대상 EDI invoice 목록 조회
	 * @param tesEdiSndAckMainRuleVO
	 * @return List<ComTesEdiAckSndLogVO>
	 * @throws DAOException
	 */
	public List<ComTesEdiAckSndLogVO> getAckFFLogList(TesEdiSndAckMnRuleVO tesEdiSndAckMainRuleVO) throws DAOException {
		log.debug("\n BBB -  TESeBillingAckManageDBDAO.getAckFFLogList - ########################################### ");

		List<ComTesEdiAckSndLogVO> tesEdiAckSndLogVOLst = null;
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tesEdiSndAckMainRuleVO!=null){
				param.put("vndr_seq", JSPUtil.getNull(tesEdiSndAckMainRuleVO.getEdiVndrSeq()));
				param.put("ofc_cd", JSPUtil.getNull(tesEdiSndAckMainRuleVO.getInvOfcCd()));
				param.put("ack_act_tp_cd", JSPUtil.getNull(tesEdiSndAckMainRuleVO.getAckActTpCd()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingAckManageDBDAOGetAckFFLogListRSQL(), param, velParam);
				if (dbRowset!=null){
					tesEdiAckSndLogVOLst = (List)RowSetUtil.rowSetToVOs(dbRowset,ComTesEdiAckSndLogVO.class);
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
		log.debug("\n EEE -  TESeBillingAckManageDBDAO.getAckFFLogList - ########################################### ");
		
		return tesEdiAckSndLogVOLst;
	}
	
	/**
	 * ACK 대상 EDI invoice 대상 조회
	 * @param tesEdiAckSndLogVO
	 * @return List<TesEdiSoHdrVO>
	 * @throws DAOException
	 */
	public List<TesEdiSoHdrVO> getAckFFLogInvList(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws DAOException {
		log.debug("\n BBB -  TESeBillingAckManageDBDAO.getAckFFLogInvList - ########################################### ");

		List<TesEdiSoHdrVO> tesEdiSoHdrVOLst = null;
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tesEdiAckSndLogVO!=null){
				param.put("edi_snd_dt", JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt()));
				param.put("snd_log_seq", JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq()));
				param.put("ack_act_tp_cd", JSPUtil.getNull(tesEdiAckSndLogVO.getAckActTpCd()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingAckManageDBDAOGetAckFFLogInvListRSQL(), param, velParam);
				if (dbRowset!=null){
					tesEdiSoHdrVOLst = (List)RowSetUtil.rowSetToVOs(dbRowset,TesEdiSoHdrVO.class);
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
		log.debug("\n EEE -  TESeBillingAckManageDBDAO.getAckFFLogInvList - ########################################### ");
		
		return tesEdiSoHdrVOLst;
	}
	
	/**
	 * ACK 전송 후 완료 표시하기
	 * @param tesEdiAckSndLogVO
	 * @throws DAOException
	 */
	public void completeAckEdiSndLogSts(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws DAOException {
		log.debug("\n BEGIN - TESeBillingAckManageDBDAO.completeAckEdiSndLogSts - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (tesEdiAckSndLogVO!=null){
				param.put("edi_snd_dt", JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt()));
				param.put("snd_log_seq", JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq()));
				int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingAckManageDBDAOCompleteAckEdiSndLogStsUSQL(), param, velParam);			
				if (insCnt <= 0){
					throw new DAOException(new ErrorHandler("COM11001").getMessage());//데이터 반영에 실패하였습니다.
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
		log.debug("\n END - TESeBillingAckManageDBDAO.completeAckEdiSndLogSts - ########################################### ");
	}
	
	/**
	 * ACK 대상 전송 전 DB에서의 전송 대기 가능 상태 조회
	 * @param tesEdiAckSndLogVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkAckEDILogB4Send(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws DAOException {
		log.debug("\n BEGIN - TESeBillingAckManageDBDAO.checkAckEDILogB4Send - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String retval = "E";
		
		try {
			if (tesEdiAckSndLogVO!=null){
				param.put("edi_snd_dt", JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt()));
				param.put("snd_log_seq", JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingAckManageDBDAOCheckAckEDILogB4SendRSQL(), param, velParam);
				if (dbRowset != null && dbRowset.next()){
					retval = dbRowset.getString("ACK_SND_STS_CD");
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
		log.debug("\n END - TESeBillingAckManageDBDAO.checkAckEDILogB4Send - ########################################### ");
		return retval;
	}
	
	/**
	 * Error 남기기
	 * @param tesEdiAckSndLogVO
	 * @throws DAOException
	 */
	public void logAckEDIErrMsg(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws DAOException {
		log.debug("\n BEGIN - TESeBillingAckManageDBDAO.logAckEDIErrMsg - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (tesEdiAckSndLogVO!=null){
				param.put("edi_snd_dt", JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt()));
				param.put("snd_log_seq", JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq()));
				param.put("edi_rmk", JSPUtil.getNull(tesEdiAckSndLogVO.getEdiRmk()));
				int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingAckManageDBDAOLogEDIErrMsgUSQL(), param, velParam);			
				if (insCnt <= 0){
					throw new DAOException(new ErrorHandler("COM11001").getMessage());//데이터 반영에 실패하였습니다.
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
		log.debug("\n END - TESeBillingAckManageDBDAO.logAckEDIErrMsg - ########################################### ");
	}
}