/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAO.java
*@FileTitle : Owner's Account
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.02.18 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.vo.FileUploadListVO;
import com.hanjin.apps.alps.esm.fms.fmscommonutil.BizComFmsUtil;
import com.hanjin.apps.alps.esm.fms.ownersaccount.basic.OwnersAccountBCImpl;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.CondOwnrAcctForCnclVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsConsultationVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsOwnrAcctSlpVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrAcctListVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrAcctVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrCurrVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.SearchApSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.SearchOwnrAcctForCnclListVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.searchFinancialVVDForOtherOffcVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAOCsulSlpSeqCSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAOCsulSlpSeqRSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAOCsulSlpSeqUSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ApInvHdrVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;


/**
 * ALPS OwnersAccountDBDAO <br>
 * - ALPS-OwnersAccount system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Son, Jin-Hwan
 * @see OwnersAccountBCImpl 참조
 * @since J2EE 1.6
 */
public class OwnersAccountDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * 전표 생성시 Seq. No. 조회<br>
	 * 
	 * @param slpTpCd String
	 * @param slpFuncCd String
	 * @param slpOfcCd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCsulSlpSeq(String slpTpCd, String slpFuncCd, String slpOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String slpSerNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("slp_tp_cd", slpTpCd);
			param.put("slp_func_cd", slpFuncCd);
			param.put("slp_ofc_cd", slpOfcCd);	//Office Code
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOCsulSlpSeqRSQL(), param, null);
			if(dbRowset.next()) {
				slpSerNo = dbRowset.getString("slp_ser_no");
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return slpSerNo;
	}
	
	/**
	 * 전표번호 생성시 등록.<br>
	 * 
	 * @param slpTpCd String
	 * @param slpFuncCd String
	 * @param slpOfcCd String
	 * @param slpSerNo String
	 * @param usrId String
	 * @throws DAOException
	 */
	public void addCsulSlpSeq(String slpTpCd, String slpFuncCd, String slpOfcCd, String slpSerNo ,String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("slp_tp_cd", slpTpCd);
			param.put("slp_func_cd", slpFuncCd);
			param.put("slp_ofc_cd", slpOfcCd);
			param.put("slp_ser_no", slpSerNo);
			param.put("cre_usr_id", usrId);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOCsulSlpSeqCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 전표번호 생성시 수정.<br>
	 * 
	 * @param slpTpCd String
	 * @param slpFuncCd String
	 * @param slpOfcCd String
	 * @param slpSerNo String
	 * @param usrId String
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCsulSlpSeq(String slpTpCd, String slpFuncCd, String slpOfcCd, String slpSerNo ,String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {

			param.put("slp_tp_cd", slpTpCd);
			param.put("slp_func_cd", slpFuncCd);
			param.put("slp_ofc_cd", slpOfcCd);
			param.put("slp_ser_no", slpSerNo);
			param.put("upd_usr_id", usrId);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOCsulSlpSeqUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * [Owner's Account Consultation]을 [Save] 합니다.<br>
	 * 
	 * @param FmsConsultationVO fmsConsultationVO
	 * @exception DAOException
	 */
	public void addOwnersAccountMaster(FmsConsultationVO fmsConsultationVO) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//FMS_CONSULTATION
			Map<String, String> mapVO = fmsConsultationVO.getColumnValues();
		
			param.putAll(mapVO);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountConsultationCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Owner's Account Consultation Cancellation]을 [Save] 합니다.<br>
	 * 
	 * @param FmsConsultationVO fmsConsultationVO
	 * @param String vndrSeq
	 * @exception DAOException
	 */
	public void addOwnersAccountMasterCancellation(FmsConsultationVO fmsConsultationVO, String vndrSeq) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//FMS_CONSULTATION
			Map<String, String> mapVO = fmsConsultationVO.getColumnValues();
		
			param.putAll(mapVO);
			param.put("vndr_seq", vndrSeq);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountConsultationCancellationCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Owner's Account Consultation]을 [Update] 합니다.<br>
	 * 
	 * @param FmsConsultationVO fmsConsultationVO
	 * @exception DAOException
	 */
	public void modifyOwnersAccountMaster(FmsConsultationVO fmsConsultationVO) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//FMS_CONSULTATION
			Map<String, String> mapVO = fmsConsultationVO.getColumnValues();
		
			param.putAll(mapVO);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountConsultationUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Owner's Account Slip]을 [Save] 합니다. 다건 처리용<br>
	 * 
	 * @param List<FmsCsulSlpVO> fmsCsulSlpVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addOwnersAccountSlips(List<FmsCsulSlpVO> fmsCsulSlpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(fmsCsulSlpVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountCsulSlpCSQL(), fmsCsulSlpVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + "SQL");					
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Owner's Account Slip]을 [Save] 합니다. 단건 처리용<br>
	 * 
	 * @param FmsCsulSlpVO fmsCsulSlpVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addOwnersAccountSlip(FmsCsulSlpVO fmsCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//FMS_CSUL_SLP
			Map<String, String> mapVO = fmsCsulSlpVO.getColumnValues();
		
			param.putAll(mapVO);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountCsulSlpCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Owner's Account Slip]을 [Save] 합니다. FMS_OWNR_ACCT_SLP<br>
	 * 
	 * @param String csrNo
	 * @param String srcCurrCd
	 * @param String orgCsrAmt
	 * @param String usrId
	 * @exception DAOException
	 */
	public void addOwnersAccountSlip(String csrNo, String srcCurrCd, String orgCsrAmt, String usrId) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("csr_no", csrNo);
			param.put("src_curr_cd", srcCurrCd);
			param.put("org_csr_amt", orgCsrAmt);
			param.put("usr_id", usrId);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountSlpCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Owner's Account Slip] Pair CSR_NO를 [Update] 합니다. <br>
	 * 
	 * @param FmsCsulSlpVO fmsCsulSlpVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyOwnersAccountSlipPairCsrNo(FmsCsulSlpVO fmsCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = fmsCsulSlpVO.getColumnValues();
			param.putAll(mapVO);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountCsulSlpPairCsrNoUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Owner's Account Slip] 정보를 [Update] 합니다. 다건 처리용<br>
	 * 
	 * @param List<FmsCsulSlpVO> fmsCsulSlpVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyOwnersAccountSlips(List<FmsCsulSlpVO> fmsCsulSlpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(fmsCsulSlpVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountCsulSlpsUSQL(), fmsCsulSlpVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + "SQL");					
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [Owner's Account Slip] 정보를 [Update] 합니다. 단건 처리용<br>
	 * 
	 * @param FmsCsulSlpVO fmsCsulSlpVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyOwnersAccountSlip(FmsCsulSlpVO fmsCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = fmsCsulSlpVO.getColumnValues();
			param.putAll(mapVO);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountCsulSlpUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Owner's Account Slip] 정보를 [Delete] 합니다. 다건 처리용<br>
	 * 
	 * @param List<FmsCsulSlpVO> fmsCsulSlpVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void deleteOwnersAccountSlips(List<FmsCsulSlpVO> fmsCsulSlpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(fmsCsulSlpVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountCsulSlpsDSQL(), fmsCsulSlpVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + "SQL");					
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Owner's Account Consulation]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @param String sFlg
	 * @return FmsConsultationVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public FmsConsultationVO searchOwnersAccountConsultation(String csrNo, String sFlg) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		FmsConsultationVO rsVO = new FmsConsultationVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if("R1".equals(sFlg)) {
				csrNo = csrNo.substring(0, csrNo.length() - 4);
			}
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountConsultationRSQL(), param, null);
			if(dbRowset.next()) {
				rsVO.setSlpTpCd(dbRowset.getString("SLP_TP_CD"));
				rsVO.setSlpFuncCd(dbRowset.getString("SLP_FUNC_CD"));
				rsVO.setSlpOfcCd(dbRowset.getString("SLP_OFC_CD"));
				rsVO.setSlpIssDt(dbRowset.getString("SLP_ISS_DT"));
				rsVO.setSlpSerNo(dbRowset.getString("SLP_SER_NO"));
				rsVO.setCsrCurrCd(dbRowset.getString("CSR_CURR_CD"));
				rsVO.setCsrAmt(dbRowset.getString("T_CSR_AMT"));
				rsVO.setOaInvDt(dbRowset.getString("OA_INV_DT"));
				rsVO.setEffDt(dbRowset.getString("EFF_DT"));
				rsVO.setRqstDt(dbRowset.getString("RQST_DT"));
				rsVO.setCsrDesc(dbRowset.getString("T_CSR_DESC"));
				rsVO.setOaInterMmDesc(dbRowset.getString("OA_INTER_MM_DESC"));
				rsVO.setEvidTpCd(dbRowset.getString("EVID_TP_CD"));			// 추가
				rsVO.setAsaNo(dbRowset.getString("ASA_NO"));						// 추가
				rsVO.setVatCsrNo(dbRowset.getString("VAT_CSR_NO"));						// 추가			
				rsVO.setAproRqstNo(dbRowset.getString("APRO_RQST_NO"));						// 추가				
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}	
	
	/**
	 * [Owner's Account Slip]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @param String sFlg
	 * @return List<FmsCsulSlpVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<FmsCsulSlpVO> searchOwnersAccountCsulSlps(String csrNo, String sFlg) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<FmsCsulSlpVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("csr_no", csrNo);
			velParam.put("s_flg", sFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountCsulSlpsRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FmsCsulSlpVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	/**
	 * [O/A Cancellation에서 취소를 위해 선택한 전표]을 [조회]합니다.<br>
	 * 
	 * @param String csrNo
	 * @return List<FmsCsulSlpVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<FmsCsulSlpVO> searchOwnersAccountCancellationSlip(String csrNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<FmsCsulSlpVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			List<String> csrNos = new ArrayList<String>();
			String[] arrCsrNo = csrNo.split(",");
			for(int i = 0; i < arrCsrNo.length; i++) {
				csrNos.add(arrCsrNo[i]);
			}
			param.put("csrNos", csrNos);
			velParam.put("csrNos", csrNos);
			velParam.put("s_csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchOwnersAccountCancellationSlipRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FmsCsulSlpVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * [Owner's Account Slip 자동생성 전표내용]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @param String slpSerNo1
	 * @param String slpSerNo2
	 * @return List<FmsCsulSlpVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<FmsCsulSlpVO> searchAutoGenSlps(String csrNo, String slpSerNo1, String slpSerNo2) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<FmsCsulSlpVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("csr_no", csrNo);
			param.put("slp_ser_no1", slpSerNo1);
			param.put("slp_ser_no2", slpSerNo2);
			
			if("".equals(slpSerNo2)){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchAutoGenSlpsLclUSDRSQL(), param, null);
			}else{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchAutoGenSlpsRSQL(), param, null);
			}
	
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FmsCsulSlpVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [Approval Type ( GW or ALPS) ]을 [Search] 합니다.<br>
	 * 
	 * @param String orgCur
	 * @param String orgAmt
	 * @return String
	 * @exception EventException
	 */
	public String searchApprovalType(String orgCur, String orgAmt) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String aproType = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("org_cur", orgCur);
			param.put("org_amt", orgAmt);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchApprovalTypeRSQL(), param, null);
			if(dbRowset.next()) {
				aproType = dbRowset.getString("APRO_TYPE");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return aproType;
	}
	
	/**
	 * [G/L Date ]을 [Search] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchGlDate(String ofcCd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String effDt = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("ofc_cd", ofcCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchGlDateRSQL(), param, null);
			if(dbRowset.next()) {
				effDt = dbRowset.getString("EFF_DT");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return effDt;
	}
	
	/**
	 * [G/L Date Payments Slip]을 [Search] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchGlDate2(String ofcCd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String effDt = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("ofc_cd", ofcCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchGlDate2RSQL(), param, null);
			if(dbRowset.next()) {
				effDt = dbRowset.getString("EFF_DT");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return effDt;
	}
	
	/**
	 * [Local Currency의 CSR_AMT]를 [경리환율 적용] 합니다.<br>
	 * 
	 * @param String orgCur
	 * @param String orgAmt
	 * @return String
	 * @exception EventException
	 */
	public String frgnExchangeAmount(String orgCur, String orgAmt) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String usdAmt = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("org_cur", orgCur);
			param.put("org_amt", orgAmt);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchFRGNExchangeAmountRSQL(), param, null);
			if(dbRowset.next()) {
				usdAmt = dbRowset.getString("USD_AMT");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return usdAmt;
	}
	
	/**
	 * AP 전표 Detail 계정 항목들을 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchApSlipDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchApSlipDetailListVO> searchApSlipDetailList (String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchApSlipDetailListVO> searchApSlipDetailListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchApSlipDetailListVORSQL(), param, null);
			searchApSlipDetailListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchApSlipDetailListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchApSlipDetailListVO;
	}
	
	/**
	 * AR Detail 테이블에 생성된다.<br>
	 * 
	 * @param customSlipApprovalDetailVOs List<CustomSlipApprovalDetailVO>
	 * @throws DAOException
	 */
	public void addApSlipApprovalDetails(List<CustomSlipApprovalDetailVO> customSlipApprovalDetailVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			//AP_INV_DTRB 저장
			if(customSlipApprovalDetailVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OwnersAccountDBDAOCustomSlipApprovalDetailVOCSQL(), customSlipApprovalDetailVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("AP_INV_DTRB : Fail to insert No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [AP_INV_HDR테이블에 데이터 존재하는지]을 [Search] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @return List<ApInvHdrVO>
	 * @exception EventException
	 */
	public List<ApInvHdrVO> searchApInvCsrNo(String csrNo) throws DAOException {
		List<ApInvHdrVO> list = null;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchApInvCsrNoRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ApInvHdrVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [AP_INV_HDR테이블에 APRO_FLG]을 ["N" Update] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @exception EventException
	 */
	public void modifyApInvHdr(String csrNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("csr_no", csrNo);
	
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOmodifyApInvHdrUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [FMS_OWNR_ACCT_SLP]을 [Search] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @return FmsOwnrAcctSlpVO
	 * @exception EventException
	 */
	public FmsOwnrAcctSlpVO searchOwnrAcctSlp(String csrNo) throws DAOException {
		FmsOwnrAcctSlpVO fmsOwnrAcctSlpVO = new FmsOwnrAcctSlpVO();
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchOwnrAcctSlpRSQL(), param, null);
			if(dbRowset.next()) {
				fmsOwnrAcctSlpVO.setCsrSlpFlg(dbRowset.getString("csr_slp_flg"));
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fmsOwnrAcctSlpVO;
	}
	
	/**
	 * [FMS_OWNR_ACCT_SLP테이블에 OA_STL_STS_CD]를 [Update] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @param String oaStlStsCd
	 * @exception EventException
	 */
	public void modifyOwnrAcctSlp(String csrNo, String oaStlStsCd) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("csr_no", csrNo);
			param.put("oa_stl_sts_cd", oaStlStsCd);
	
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOModifyOwnrAcctSlpUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [FMS_OWNR_ACCT_SLP]을 [Delete] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @exception EventException
	 */
	public void deleteOwnrAcctSlp(String csrNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("csr_no", csrNo);
	
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAODeleteOwnrAcctSlpDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Owner's Account 목록을 조회한다.<br>
	 * 
	 * @param OwnrAcctVO ownrAcctVO
	 * @param String offCd
	 * @return List<OwnrAcctListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<OwnrAcctListVO> searchOwnersAccountList(OwnrAcctVO ownrAcctVO, String offCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<OwnrAcctListVO> ownrAcctList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ownrAcctVO != null){
				Map<String, String> mapVO = ownrAcctVO.getColumnValues();
				
				param.putAll(mapVO);
				param.put("off_cd", offCd);
				
				velParam.putAll(mapVO);
				velParam.put("off_cd", offCd);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountListRSQL(), param, velParam);
			ownrAcctList = (List)RowSetUtil.rowSetToVOs(dbRowset, OwnrAcctListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ownrAcctList;
	}
	
	/**
	 * Office 코드List를 조회한다.
	 * 
	 * @param String offCd
	 * @return List<OwnrAcctVO>
	 * @throws EventException
	 */	
	public List<OwnrAcctVO> searchOwnOfficeList(String offCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<OwnrAcctVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {			
			param.put("off_cd", offCd);
			velParam.put("off_cd", offCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnersAccountDBDAOOwnOfficeListRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OwnrAcctVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Currency 코드List를 조회한다.
	 * 
	 * @param String offCd
	 * @return List<OwnrCurrVO>
	 * @throws EventException
	 */
	public List<OwnrCurrVO> searchOwnCurrList(String offCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<OwnrCurrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {			
			param.put("ofc_cd", offCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnersAccountDBDAOOwnCurrListRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OwnrCurrVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
 	/**
	 * Invoice No 중복 체크<br>
	 * 
	 * @param String vndrSeq
	 * @param String toInvNo
	 * @param String csrNo
	 * @param String vvd
	 * @return Boolean
	 * @exception EventException
	 */
	public Boolean checkInvNo(String vndrSeq, String toInvNo, String csrNo, String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean dup = false;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			param.put("vndr_seq", vndrSeq);
			param.put("to_inv_no", toInvNo);
			param.put("csr_no", csrNo);
			param.put("vvd", vvd);
			velParam.put("csr_no", csrNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnersAccountDBDAOCheckInvNoRSQL(), param, velParam);
			if(dbRowset.next()) {
				dup = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dup;
	}
	
 	/**
	 * Local Currency 조회<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalCurrency(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String currCd = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		try {			
			param.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnersAccountDBDAOLocalCurrCdRSQL(), param, null);
			if(dbRowset.next()) {
				currCd = dbRowset.getString("ar_curr_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return currCd;
	}
	
	/**
	 * Owner's Account For Cancellation 정보를 조회한다<br>
	 * [ESM_FMS_0101] O/A Inquiry for Cancellation
	 * 
	 * @param CondOwnrAcctForCnclVO condOwnrAcctForCnclVO
	 * @return List<SearchOwnrAcctForCnclListVO>
	 * @exception EventException
	 */
	public List<SearchOwnrAcctForCnclListVO> searchOwnrsAccntForCnclList(CondOwnrAcctForCnclVO condOwnrAcctForCnclVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<SearchOwnrAcctForCnclListVO> searchOwnrAcctForCnclListVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condOwnrAcctForCnclVO != null) {
				condOwnrAcctForCnclVO.setCsrFrDt(condOwnrAcctForCnclVO.getCsrFrDt().replaceAll("-",""));
				condOwnrAcctForCnclVO.setCsrToDt(condOwnrAcctForCnclVO.getCsrToDt().replaceAll("-",""));
				
				Map<String, String> mapVO = condOwnrAcctForCnclVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String strAcctItmSeq = condOwnrAcctForCnclVO.getAcctItmSeq();
				
				velParam.put("vel_acct_itm_seq", (strAcctItmSeq == null || strAcctItmSeq.equals("") || strAcctItmSeq.equals("null")) ? "" : strAcctItmSeq);
				List<String> listAcctItmSeq = new ArrayList<String>();
				
				
				if(strAcctItmSeq != null && !strAcctItmSeq.equals("")) {
					listAcctItmSeq = BizComFmsUtil.getSeperationParameter(strAcctItmSeq, ",");
				}
				
				
				velParam.put("list_acct_itm_seq", listAcctItmSeq.iterator());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchOwnrAcctForCnclListRSQL(), param, velParam);
			searchOwnrAcctForCnclListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnrAcctForCnclListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchOwnrAcctForCnclListVOs;
	}
	
	/**
	 * Owner's Account Exchange Consultation / Slip의 File을 저장한다.<br>
	 * 
	 * @param String csrNo
	 * @param String vvd
	 * @param int slpSeqno
	 * @param int atchFileOaLnkSeq
	 * @param String fileSavId
	 * @param String usrId
	 * @throws DAOException
	 */
	public void addFmsOwnrAcctAtchFile(String csrNo, String vvd, int slpSeqno, int atchFileOaLnkSeq, String fileSavId, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("csr_no", csrNo);
			param.put("vvd", vvd);
			param.put("slp_seq_no", slpSeqno);
			param.put("atch_file_oa_lnk_seq", atchFileOaLnkSeq);
			param.put("file_sav_id", fileSavId);
			param.put("usr_id", usrId);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOFmsOwnrAcctAtchFileCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Owner's Account Exchange Consultation / Slip의 File을 저장한다.<br>
	 * 
	 * @param String csrNo
	 * @param String newCsrNo
	 * @param String atchFileLnkId
	 * @param String atchFileLnkSeq
	 * @param String usrId
	 * @throws DAOException
	 */
	public void addFmsOwnrAcctAtchFileCancel(String csrNo, String newCsrNo, String atchFileLnkId, String atchFileLnkSeq, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("csr_no", csrNo);
			param.put("new_csr_no", newCsrNo);
			param.put("atch_file_oa_lnk_id", atchFileLnkId);
			param.put("atch_file_oa_lnk_seq", atchFileLnkSeq);
			param.put("usr_id", usrId);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOFmsOwnrAcctAtchFileCancelCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Owner's Account Consultation / Slip의 File을 삭제한다.<br>
	 * 
	 * @param String atchFileOaLnkId
	 * @throws DAOException
	 */
	public void removeAtchFile(String atchFileOaLnkId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			param.put("atch_file_oa_lnk_id", atchFileOaLnkId);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAORemoveAtchFileDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Owner's Account FMS_CSUL_SLP 삭제한다.<br>
	 * 
	 * @param String csrNo
	 * @throws DAOException
	 */
	public void removeFmsCsulSlp(String csrNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			param.put("csr_no", csrNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAORemoveFmsCsulSlpDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Owner's Account FMS_CONSULTATION 삭제한다.<br>
	 * 
	 * @param String csrNo
	 * @throws DAOException
	 */
	public void removeFmsConsultation(String csrNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			
			param.put("csr_no", csrNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAORemoveFmsConsultationDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * CSR_NO에 해당하는 첨부파일 조회<br>
	 * 
	 * @param String csrNo
	 * @return List<FileUploadListVO>
	 * @throws DAOException
	 */
	public List<FileUploadListVO> searchOwnersAccountAtchFile(String csrNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<FileUploadListVO> fileUploadListVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("csr_no", csrNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchAtchFileListRSQL(), param, null);
			fileUploadListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, FileUploadListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return fileUploadListVOs;
	}
	
	/**
	 * [ESM_FSM_B002 CsulSlpOAIf] 로 부터 호출, FMS_CONSULTATION update. <br>
	 * 
	 * @param FmsCsulSlpVO fmsCsulSlpVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyOriOASlp(FmsCsulSlpVO fmsCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = fmsCsulSlpVO.getColumnValues();
			param.putAll(mapVO);

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountOriCsulSlpUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_FMS_0095 : [COMMAND02]<br>
	 * [운항팀(PUSMOV)을 제외한 Office의 재무항차와 ETD를 [조회]합니다.<br>
	 *
	 * @param String vvdCd
	 * @param String oaLocCd
	 * @return searchFinancialVVDForOtherOffcVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public searchFinancialVVDForOtherOffcVO searchFinancialVVDForOtherOffc(String vvdCd, String oaLocCd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		searchFinancialVVDForOtherOffcVO rsVo = null;
		
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vvd_cd", vvdCd);
			param.put("oa_loc_cd", oaLocCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOsearchFinancialVVDForOtherOffcRSQL(), param, null);
			List<searchFinancialVVDForOtherOffcVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, searchFinancialVVDForOtherOffcVO.class);
			
			if(list==null || list.size()==0){
				rsVo = new searchFinancialVVDForOtherOffcVO();
			}else{
				rsVo = list.get(0);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	

	/**
	 * 전표 생성시 Current Date 조회<br>
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchSystemCurrentDate() throws DAOException {
		DBRowSet dbRowset = null;
		String currDt = "";
	
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOsearchCurrDateRSQL(), null, null);
			if(dbRowset.next()) {
				currDt = dbRowset.getString("curr_dt");
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return currDt;
	}
	
	/**
	 * 전표 생성시 AP OFC CD 조회<br>
	 * 
	 * @param String ofcCd
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String searchApOfcCd(String ofcCd, String usrId) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String apOfcCd = "";
		
		try{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("ofc_cd", ofcCd);
			param.put("usr_id", usrId);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchApOfcCdRSQL(), param, null);

			if(dbRowset.next()) {
				apOfcCd = dbRowset.getString("ap_ofc_cd");
			}
			
			if (apOfcCd.equals("")) {	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchApOfcCd2RSQL(), param, null);
				
				if(dbRowset.next()) {
					apOfcCd = dbRowset.getString("ap_ofc_cd");
				}
			}
			
			log.debug("AAAAA " + apOfcCd);
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return apOfcCd;
	}
	
	/**
	 * 전표 생성시 AP OFC CD 2조회<br>
	 * 
	 * @param String ofcCd
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String searchApOfcCd2(String ofcCd, String usrId) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String apOfcCd = "";
		
		try{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("ofc_cd", ofcCd);
			param.put("usr_id", usrId);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchApOfcCd2RSQL(), param, null);

			if(dbRowset.next()) {
				apOfcCd = dbRowset.getString("ap_ofc_cd");
			}
			
			log.debug("AAAAA " + apOfcCd);
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return apOfcCd;
	}
	
	/**
	 * [Custom Tax]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @return List<CustomTaxVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CustomTaxVO> searchCustomTax(String csrNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CustomTaxVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("csr_no", csrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOCustomTaxRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomTaxVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * [Custom Tax Dtail]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @return List<CustomTaxDtlVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CustomTaxDtlVO> searchCustomTaxDtl(String csrNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CustomTaxDtlVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("csr_no", csrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOCustomTaxDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomTaxDtlVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	
	/**
	 * [Tax] 정보를 [Delete] 합니다. 다건 처리용<br>
	 * 
	 * @param String slpTpCd 
	 * @param String slpFuncCd 
	 * @param String slpOfcCd
	 * @param String slpIssDt
	 * @param String slpSerNo
	 * @exception DAOException
	 * @exception Exception
	 */	
	public void deleteTax(String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("slp_tp_cd", slpTpCd);
			param.put("slp_func_cd", slpFuncCd);
			param.put("slp_ofc_cd", slpOfcCd);
			param.put("slp_iss_dt", slpIssDt);						
			param.put("slp_ser_no", slpSerNo);
						
			SQLExecuter sqlExe = new SQLExecuter("");			
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOTaxDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * [Tax Detail] 정보를 [Delete] 합니다. 다건 처리용<br>
	 * 
	 * @param slpTpCd String
	 * @param slpFuncCd String
	 * @param slpOfcCd String
	 * @param slpIssDt String
	 * @param slpSerNo String
	 * @exception DAOException
	 * @exception Exception
	 */
	public void deleteTaxDtl(String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			param.put("slp_tp_cd", slpTpCd);
			param.put("slp_func_cd", slpFuncCd);
			param.put("slp_ofc_cd", slpOfcCd);
			param.put("slp_iss_dt", slpIssDt);			
			param.put("slp_ser_no", slpSerNo);
						
			SQLExecuter sqlExe = new SQLExecuter("");			
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOTaxDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");									
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Owner's Account Exchange Consultation / Slip의 File을 저장한다.<br>
	 * 
	 * @param String csrNo
	 * @param String newCsrNo
	 * @param String atchFileLnkId
	 * @param String atchFileLnkSeq
	 * @param int fileSeq
	 * @param int seqNo
	 * @param String usrId
	 * @throws DAOException
	 */
	public void addFmsOwnrAcctAtchFileCancel2(String csrNo, String newCsrNo, String atchFileLnkId, String atchFileLnkSeq, int fileSeq, int seqNO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("csr_no", csrNo);
			param.put("new_csr_no", newCsrNo);
			param.put("atch_file_oa_lnk_id", atchFileLnkId);
			param.put("atch_file_oa_lnk_seq", atchFileLnkSeq);
			param.put("usr_id", usrId);
			param.put("file_seq", fileSeq);			
			param.put("seq_no", seqNO);
						
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOFmsOwnrAcctAtchFileCancelMultiCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	/**
	 * CSR_NO에 해당하는 첨부파일 개수 조회<br>
	 * 
	 * @param String csrNo
	 * @return int
	 * @throws DAOException
	 */	
	public int searchFileCnt(String csrNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int fileCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOSearchAtchFileCntRSQL(), param, null);
			if(dbRowset.next()) {
				fileCnt = dbRowset.getInt("ATCH_FILE_CNT");
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fileCnt;
	}		
	
	/**
	 * AR_INV_HDR 의  RQST_APRO_STEP_FLG 업데이트<br>
	 * 
	 * @param csr_no String
	 * @throws DAOException
	 */
	public void updateApInvHdr(String csr_no) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {				
			param.put("csr_no", csr_no);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOUpdateApInvHdrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}  
	
	/**
	 * [Owner's Account Slip]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @return String
	 * @exception DAOException
	 * @exception Exception
	 */
	public String searchOwnersAccountCsulSlpLineNo(String csrNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String lineNo = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("csr_no", csrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnersAccountDBDAOOwnersAccountCsulSlpLineNoRSQL(), param, null);
			
			if(dbRowset.next()) {
				lineNo = dbRowset.getString("line_no");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return lineNo;
	}
	
	/**
	 * FMS_CSUL_SLP 취소전표 인 경우 원전표에 해당된 Pair 전표 칼럼  Null 처리.<br>
	 * 
	 * @param String csrNo
	 * @throws DAOException
	 */
	public void modifyFmsCsulSlp(String csrNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			param.put("csr_no", csrNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOModifyFmsCsulSlpUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * FMS_OWNR_ACCT_SLP 취소전표 인 경우 원전표에 해당된 Pair 전표 칼럼  Null 처리.<br>
	 * 
	 * @param String csrNo
	 * @throws DAOException
	 */
	public void modifyFmsOwnrAcctSlp(String csrNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			param.put("csr_no", csrNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnersAccountDBDAOModifyFmsOwnrAcctSlpUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
}