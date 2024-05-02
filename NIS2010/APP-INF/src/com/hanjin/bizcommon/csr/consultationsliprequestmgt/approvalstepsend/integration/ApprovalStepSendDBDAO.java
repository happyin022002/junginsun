/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ApprovalStepSendDBDAO.java
*@FileTitle : ERP A/P로 I/F된 CSR에 대한 Approval Step 정보 I/F 처리
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
*2013-03-08
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration;

import java.sql.SQLException;
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

import com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.vo.ComComAproSndLogVO;
import com.hanjin.syscommon.common.table.ApInvHdrVO;
import com.hanjin.syscommon.common.table.ComCsrErrLogVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.syscommon.common.table.ComAproSndMnRuleVO;


/**
 * ALPS-ESD에 대한 DB 처리를 담당<br>
 * - ALPS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see ApprovalStepSendBCImpl 참조
 * @since J2EE 1.4
 */
public class ApprovalStepSendDBDAO extends DBDAOSupport {

	/**
	 * AproStep 전송 규칙 정보 조회
	 * @param act_tp_cd
	 * @return List<ComAproSndMnRuleVO>
	 * @throws DAOException
	 */
	public List<ComAproSndMnRuleVO> getAproStepSendMainRule(String act_tp_cd) throws DAOException {
		log.debug("\n BBB -  ApprovalStepSendDBDAO.getAproStepSendMainRule - ########################################### ");
		
		List<ComAproSndMnRuleVO> aproSndMnRuleVOList = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("act_tp_cd", JSPUtil.getNull(act_tp_cd));
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepSendDBDAOGetAproStepSendMainRuleRSQL(), param, velParam);
			if (dbRowset!=null){
				aproSndMnRuleVOList = (List)RowSetUtil.rowSetToVOs(dbRowset,ComAproSndMnRuleVO.class);
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
		log.debug("\n EEE -  ApprovalStepSendDBDAO.getAproStepSendMainRule - ########################################### ");
		
		return aproSndMnRuleVOList;		
	}
	
	/**
	 * AproStep SEND LOG의 SEQ 생성
	 * @return String
	 * @throws DAOException
	 */
	public String createAproStepSendSeq() throws DAOException {	
		log.debug("\n BBB -  ApprovalStepSendDBDAO.createAproStepSendSeq - ########################################### ");
		
		DBRowSet dbRowset = null;
		String so_seq = null;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepSendDBDAOCreateAproStepSendSeqRSQL(), null, null);
			if (dbRowset != null && dbRowset.next()){
				so_seq = dbRowset.getString("APRO_STEP_SEND_LOG_HDR_SEQ");
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
		log.debug("\n EEE -  ApprovalStepSendDBDAO.createAproStepSendSeq - ########################################### ");
		
		return so_seq;
	}
	
	/**
	 * AproStep SEND 생성 대상 조회
	 * @param aproSndMnRuleVO
	 * @return List<ApInvHdrVO>
	 * @throws DAOException
	 */
	public List<ApInvHdrVO> getAproStepSendCsrList(ComAproSndMnRuleVO aproSndMnRuleVO) throws DAOException {
		log.debug("\n BBB -  ApprovalStepSendDBDAO.getAproStepSendCsrList - ########################################### ");
		
		List<ApInvHdrVO> apInvHdrVOLst = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (aproSndMnRuleVO!=null){
				param.put("src_ctnt", JSPUtil.getNull(aproSndMnRuleVO.getSrcCtnt()));
				param.put("lmt_knt", JSPUtil.getNull(aproSndMnRuleVO.getExeRowKnt()));
				param.put("act_tp_cd", JSPUtil.getNull(aproSndMnRuleVO.getExeActTpCd()));
				param.put("cfm_dt", JSPUtil.getNull(aproSndMnRuleVO.getCfmDt()));
				velParam.put("lmt_knt", JSPUtil.getNull(aproSndMnRuleVO.getExeRowKnt()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepSendDBDAOGetApprovalStepSendCsrListRSQL(), param, velParam);
				if (dbRowset!=null){
					apInvHdrVOLst = (List)RowSetUtil.rowSetToVOs(dbRowset,ApInvHdrVO.class);
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
		log.debug("\n EEE -  ApprovalStepSendDBDAO.getAproStepSendCsrList - ########################################### ");
		
		return apInvHdrVOLst;
	}
	
	/**
	 * Approval Step info 조회
	 * @param csr_no
	 * @return ComAproRqstRoutVO
	 * @throws DAOException
	 */
	public ComAproRqstRoutVO getAproStepInfo(String csr_no) throws DAOException {
		log.debug("\n BBB -  ApprovalStepSendDBDAO.getAproStepInfo - ########################################### ");

		List<ComAproRqstRoutVO> comAproRqstRoutVOLst = null;
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (csr_no!=null && !csr_no.trim().equals("")){
				param.put("csr_no", JSPUtil.getNull(csr_no));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepSendDBDAOGetAproStepInfoRSQL(), param, velParam);
				if (dbRowset!=null){
					comAproRqstRoutVOLst = (List)RowSetUtil.rowSetToVOs(dbRowset,ComAproRqstRoutVO.class);
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
		log.debug("\n EEE -  ApprovalStepSendDBDAO.getAproStepInfo - ########################################### ");
		
		return comAproRqstRoutVOLst!=null&&comAproRqstRoutVOLst.size()>0?comAproRqstRoutVOLst.get(0):null;
	}
	
	/**
	 * EAI 형식에 맞게 AproStep 상세 정보 조회
	 * @param aproSndLogVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet getAproStepInfoEAIformat(ComComAproSndLogVO aproSndLogVO) throws DAOException {
		log.debug("\n BBB -  ApprovalStepSendDBDAO.getAproStepInfoEAIformat - ########################################### ");

		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<ComComAproSndLogVO> aproSndLogVOLst = null;
		
		try {
			if (aproSndLogVO!=null){
				param.put("csr_no", JSPUtil.getNull(aproSndLogVO.getCsrNo()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepSendDBDAOGetAproStepInfoEAIformatRSQL(), param, velParam);
				if (dbRowset!=null){
					aproSndLogVOLst = (List)RowSetUtil.rowSetToVOs(dbRowset,ComComAproSndLogVO.class);
					dbRowset.beforeFirst();
				}
				if (!(aproSndLogVOLst!=null && aproSndLogVOLst.size()>0)){
					dbRowset = null;
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
		log.debug("\n EEE -  ApprovalStepSendDBDAO.getAproStepInfoEAIformat - ########################################### ");
		
		return dbRowset;
	}
	
	/**
	 * AproStep Send LOG 정보 넣기
	 * @param aproSndLogVO
	 * @return String
	 * @throws DAOException
	 */
	public String createAproStepSendLog(ComComAproSndLogVO aproSndLogVO) throws DAOException{
		log.debug("\n BEGIN - ApprovalStepSendDBDAO.createAproStepSendLog - ########################################### ");

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (aproSndLogVO!=null){
				param.put("snd_log_seq", aproSndLogVO.getSndLogSeq());
				param.put("csr_no", aproSndLogVO.getCsrNo());
				param.put("src_ctnt", aproSndLogVO.getSrcCtnt());
				param.put("exe_sts_cd", aproSndLogVO.getExeStsCd());
				param.put("act_tp_cd", aproSndLogVO.getExeActTpCd());
				param.put("snd_rmk", aproSndLogVO.getSndRmk());
				param.put("csr_tp_cd", aproSndLogVO.getCsrTpCd());
				param.put("apro_usr_id", aproSndLogVO.getAproUsrId());
				param.put("apro_ofc_cd", aproSndLogVO.getAproOfcCd());
				param.put("apro_dt", aproSndLogVO.getAproDt());
				int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalStepSendDBDAOCreateAproStepSendLogCSQL(), param, velParam);			
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
	 * AproStep SEND docReq 생성 대상 조회
	 * @param aproSndMnRuleVO
	 * @return List<ComComAproSndLogVO>
	 * @throws DAOException
	 */
	public List<ComComAproSndLogVO> getAproStepSendLogList(ComAproSndMnRuleVO aproSndMnRuleVO) throws DAOException {
		log.debug("\n BBB -  ApprovalStepSendDBDAO.getAproStepSendLogList - ########################################### ");

		List<ComComAproSndLogVO> aproSndLogVOLst = null;
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (aproSndMnRuleVO!=null){
				param.put("src_ctnt", JSPUtil.getNull(aproSndMnRuleVO.getSrcCtnt()));
				param.put("act_tp_cd", JSPUtil.getNull(aproSndMnRuleVO.getExeActTpCd()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepSendDBDAOGetAproStepSendLogListRSQL(), param, velParam);
				if (dbRowset!=null){
					aproSndLogVOLst = (List)RowSetUtil.rowSetToVOs(dbRowset,ComComAproSndLogVO.class);
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
		log.debug("\n EEE -  ApprovalStepSendDBDAO.getAproStepSendLogList - ########################################### ");
		
		return aproSndLogVOLst;
	}
	
	/**
	 * AproStep 전송 후 완료 표시하기
	 * @param aproSndLogVO
	 * @throws DAOException
	 */
	public void completeAproStepSndLogSts(ComComAproSndLogVO aproSndLogVO) throws DAOException {
		log.debug("\n BEGIN - ApprovalStepSendDBDAO.completeAproStepSndLogSts - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (aproSndLogVO!=null){
				param.put("snd_log_seq", JSPUtil.getNull(aproSndLogVO.getSndLogSeq()));
				int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalStepSendDBDAOCompleteAproStepSndLogStsUSQL(), param, velParam);			
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
		log.debug("\n END - ApprovalStepSendDBDAO.completeAproStepSndLogSts - ########################################### ");
	}
	
	/**
	 * AproStep 대상 전송 전 DB에서의 전송 대기 가능 상태 조회
	 * @param aproSndLogVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkAproStepB4Send(ComComAproSndLogVO aproSndLogVO) throws DAOException {
		log.debug("\n BEGIN - ApprovalStepSendDBDAO.checkAproStepB4Send - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String retval = "E";
		
		try {
			if (aproSndLogVO!=null){
				param.put("snd_log_seq", JSPUtil.getNull(aproSndLogVO.getSndLogSeq()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepSendDBDAOCheckAproStepB4SendRSQL(), param, velParam);
				if (dbRowset != null && dbRowset.next()){
					retval = dbRowset.getString("EXE_STS_CD");
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
		log.debug("\n END - ApprovalStepSendDBDAO.checkAproStepB4Send - ########################################### ");
		return retval;
	}
	
	/**
	 * AproStep Log관리 table에 Error 남기기
	 * @param aproSndLogVO
	 * @throws DAOException
	 */
	public void logAproStepEAIErrMsg(ComComAproSndLogVO aproSndLogVO) throws DAOException {
		log.debug("\n BEGIN - ApprovalStepSendDBDAO.logAproStepEAIErrMsg - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (aproSndLogVO!=null){
				param.put("snd_log_seq", JSPUtil.getNull(aproSndLogVO.getSndLogSeq()));
				param.put("snd_rmk", JSPUtil.getNull(aproSndLogVO.getSndRmk()));
				int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalStepSendDBDAOLogAproStepEAIErrMsgUSQL(), param, velParam);			
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
		log.debug("\n END - ApprovalStepSendDBDAO.logAproStepEAIErrMsg - ########################################### ");
	}
	
	/**
	 * 공통 Error table에 Error 남기기
	 * @param csrComErrLogVO
	 * @throws DAOException
	 */
	public void logAproCommErrMsg(ComCsrErrLogVO csrComErrLogVO) throws DAOException {
		log.debug("\n BEGIN - ApprovalStepSendDBDAO.logAproStepEAIErrMsg - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (csrComErrLogVO!=null){
				param.put("csr_err_tp_cd", JSPUtil.getNull(csrComErrLogVO.getCsrErrTpCd()));
				param.put("err_log_rmk", JSPUtil.getNull(csrComErrLogVO.getErrLogRmk()));
				int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalStepSendDBDAOLogAproCommErrMsgCSQL(), param, velParam);			
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
		log.debug("\n END - ApprovalStepSendDBDAO.logAproStepEAIErrMsg - ########################################### ");
	}	
}