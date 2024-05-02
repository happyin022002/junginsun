/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementDBDAO.java
*@FileTitle : Owner's Account to Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.25 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration.CARIssueTransferSlipManageDBDAOPrintComCsrBodyInfoRSQL;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration.CARIssueTransferSlipManageDBDAOPrintComCsrHeaderInfoRSQL;
import com.hanjin.apps.alps.esm.fms.ownersaccount.integration.OwnersAccountDBDAOModifyOwnrAcctSlpUSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondReverseCsrForSubletVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchInterfaceStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchInvoiceNoVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSubletRevenueVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomArSlipApprovalDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomArSlipApprovalHeaderVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpSeqVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomInterfaceStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalHeaderVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipInterfaceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApVatSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchBrokerageListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchCustomerCodeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInterfaceStatusDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInterfaceStatusListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInvoiceNoListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchManualSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchPaymentSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletSaveListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalBillDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalBillVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOfficeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOwnerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalTaxDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalTaxVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletReveuneDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxDetailEvidenceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxMasterEvidenceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchVvdListByManualSlipVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalCsrVO;

/**
 * NIS2010 TCharterIOConsultationDBDAO <br>
 * - NIS2010-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon, Seyeong 
 * @see TCharterIOConsultationBCImpl 참조
 * @since J2EE 1.6
 */
public class TCharterIOConsultationDBDAO extends DBDAOSupport {

	/**
	 * Owner'sAccount Expense 데이터를 등록한다.<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVO List<CustomCsulSlpVO>
	 * @throws DAOException
	 */
	public void addOwnerAccountExpenses(CustomConsultationVO customConsultationVO, List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			//FMS_CONSULTATION 저장
			Map<String, String> mapVO = customConsultationVO.getColumnValues();
			
			param.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOCustomConsultationVOCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
			//FMS_CSUL_SLP 저장
			if(customCsulSlpVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOCustomCsulSlpVOCSQL(), customCsulSlpVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("FMS_CSUL_SLP : Fail to insert No"+ i + " SQL");
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
	 * 전표 생성시 Seq. No. 조회<br>
	 * 
	 * @param slpTpCd String
	 * @param slpFuncCd String
	 * @param slpOfcCd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCsulSlpSeq (String slpTpCd, String slpFuncCd, String slpOfcCd) throws DAOException {
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
	 * 전표 생성시 Seq. No. 조회<br>
	 * 
	 * @param slpTpCd String
	 * @param slpFuncCd String
	 * @param slpOfcCd String
	 *  @param slpIssDt String
	 *   @param slpSerNo String
	 * @return String
	 * @throws DAOException
	 */
	public String searchArCsrNo (String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo) throws DAOException {
		DBRowSet dbRowset = null;
		String pcsrNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("slp_tp_cd", slpTpCd);
			param.put("slp_func_cd", slpFuncCd);
			param.put("slp_ofc_cd", slpOfcCd);
			param.put("slp_iss_dt", slpIssDt);
			param.put("slp_ser_no", slpSerNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOArCsrNoRSQL(), param, null);
			if(dbRowset.next()) {
				pcsrNo = dbRowset.getString("pcsr_no");
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return pcsrNo;
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
	 * Sublet Revenue slip(대선 전표)를 Master에 생성한다<br>
	 * 
	 * @param customConsultationVO List<CustomConsultationVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void addMasterSubletRevenueSlip(CustomConsultationVO customConsultationVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		
		try {
			Map<String, String> mapVO = customConsultationVO.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOFmsMasterSubletRevenueSlipCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Sublet Revenue slip(대선 전표)를 생성한다<br>
	 * 
	 * @param customCsulSlpVO List<CustomCsulSlpVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void addSubletRevenueSlips(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customCsulSlpVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOFmsSubletRevenueSlipsCSQL(), customCsulSlpVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Sublet Revenue slip(대선 전표)를 조건으로 해서 대선 전표 계정 자료를 조회한다<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchDeliveryScheduleListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSubletRevenueSlipListVO> searchSubletRevenueSlipList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSubletRevenueSlipListVO> searchSubletRevenueSlipListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(customCsulSlpSeqVO != null){
				Map<String, String> mapVO = customCsulSlpSeqVO.getColumnValues();
				
				param.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOFmsSubletRevenueSlipListRSQL(), param, null);
			searchSubletRevenueSlipListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSubletRevenueSlipListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSubletRevenueSlipListVO;
	}

	/**
	 * 자발적, 비자발적 오류 처리할 전표를 조회한다<br>
	 * 
	 * @param condSearchInterfaceStatusVO CondSearchInterfaceStatusVO
	 * @return List<SearchInterfaceStatusListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchInterfaceStatusListVO> searchInterfaceStatusList (CondSearchInterfaceStatusVO condSearchInterfaceStatusVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInterfaceStatusListVO> searchInterfaceStatusListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchInterfaceStatusVO != null){
				Map<String, String> mapVO = condSearchInterfaceStatusVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchInterfaceStatusListVORSQL(), param, velParam);
			searchInterfaceStatusListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInterfaceStatusListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchInterfaceStatusListVO;
	}

	/**
	 * 자발적, 비자발적 오류 처리할 전표를 계정별 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchInterfaceStatusDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchInterfaceStatusDetailListVO> searchInterfaceStatusDetailList (String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInterfaceStatusDetailListVO> searchInterfaceStatusDetailListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchInterfaceStatusDetailListVORSQL(), param, null);
			searchInterfaceStatusDetailListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInterfaceStatusDetailListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchInterfaceStatusDetailListVO;
	}
	
	/**
	 * 작성된 채권에 대한 채권 계상액 History 조회한다<br>
	 * 
	 * @param condSearchSubletRevenueVO CondSearchSubletRevenueVO
	 * @return List<SearchSubletRevenueListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSubletRevenueListVO> searchSubletReveuneList(CondSearchSubletRevenueVO condSearchSubletRevenueVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSubletRevenueListVO> searchSubletRevenueListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchSubletRevenueVO != null){
				Map<String, String> mapVO = condSearchSubletRevenueVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOFmsSubletReveuneListRSQL(), param, velParam);
			searchSubletRevenueListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSubletRevenueListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSubletRevenueListVO;
	}
	
	/**
	 * 작성된 채권에 대한 채권 계상액 Detail History 조회한다<br>
	 * 
	 * @param toInvNo String
	 * @return List<SearchSubletReveuneDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSubletReveuneDetailListVO> searchSubletReveuneDetailList(String toInvNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSubletReveuneDetailListVO> searchSubletReveuneDetailListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("to_inv_no", toInvNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOFmsSubletReveuneDetailListRSQL(), param, null);
			searchSubletReveuneDetailListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSubletReveuneDetailListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSubletReveuneDetailListVO;
	}

	/**
	 * 기 지급한 선급금을 실제 비용 계정으로 정리하여 전표를 Master 생성한다.<br>
	 * 
	 * @param customConsultationVO List<CustomConsultationVO>
	 * @throws DAOException
	 */
	public void addPrepaymentSettlementMaster(CustomConsultationVO customConsultationVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
	
			//FMS_CONSULTATION 저장
			Map<String, String> mapVO = customConsultationVO.getColumnValues();
			
			param.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOCustomConsultationPPayCSQL(), param, null);
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
	 * 기 지급한 선급금을 실제 비용 계정으로 정리하여 전표를 생성한다<br>
	 * 
	 * @param customCsulSlpVO List<CustomCsulSlpVO>
	 * @throws DAOException
	 */
	public void addPrepaymentSettlementSlips(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			//FMS_CSUL_SLP 저장
			if(customCsulSlpVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOCustomCsulSlpPPayCSQL(), customCsulSlpVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("FMS_CSUL_SLP : Fail to insert No"+ i + " SQL");
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
	 * 기 지급한 선급금을 실제 비용 계정으로 정리한 원본 전표에 STL_FLG = 'Y' 로 변경한다.<br>
	 * 
	 * @param customCsulSlpVO List<CustomCsulSlpVO>
	 * @throws DAOException
	 */
	public void modifyPrepaymentSettlements(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			//FMS_CSUL_SLP 저장
			if(customCsulSlpVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOCustomCsulSlpVOUSQL(), customCsulSlpVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("FMS_CSUL_SLP : Fail to insert No"+ i + " SQL");
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
	 * 작성된 전표의 조건별 Slip Approval Master 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @param String userId
	 * @return List<SearchSlipApprovalListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipApprovalListVO> searchSlipApprovalList(CondSearchSlipApprovalVO condSearchSlipApprovalVO, String userId) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipApprovalListVO> searchSlipApprovalListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchSlipApprovalVO != null){
				Map<String, String> mapVO = condSearchSlipApprovalVO.getColumnValues();
				
				param.putAll(mapVO);
				param.put("usr_id", userId);
				
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipApprovalListRSQL(), param, velParam);
			searchSlipApprovalListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipApprovalListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipApprovalListVO;
	}

	/**
	 * 작성된 전표의 조건별 Submit to GW 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipApprovalListVO> searchSlipSubmitToGWList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipApprovalListVO> searchSlipApprovalListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchSlipApprovalVO != null){
				Map<String, String> mapVO = condSearchSlipApprovalVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSubmitToGWListRSQL(), param, velParam);
			searchSlipApprovalListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipApprovalListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipApprovalListVO;
	}
	
	/**
	 * 작성된 전표의 조건별 Slip Inquiry Master 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipApprovalListVO> searchSlipInquiryList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipApprovalListVO> searchSlipApprovalListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchSlipApprovalVO != null){
				Map<String, String> mapVO = condSearchSlipApprovalVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipInquiryListRSQL(), param, velParam);
			searchSlipApprovalListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipApprovalListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipApprovalListVO;
	}
	
	/**
	 * 기 결제된 채권번호를 조회한다<br>
	 * 
	 * @param condSearchInvoiceNoVO CondSearchInvoiceNoVO
	 * @return List<SearchInvoiceNoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchInvoiceNoListVO> searchInvoiceNoList(CondSearchInvoiceNoVO condSearchInvoiceNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInvoiceNoListVO> searchInvoiceNoListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(condSearchInvoiceNoVO != null){
				Map<String, String> mapVO = condSearchInvoiceNoVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOFmsInvoiceNoListRSQL(), param, velParam);
			searchInvoiceNoListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceNoListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchInvoiceNoListVO;
	}

	/**
	 * A/P에서 취소 했을 경우 전표에 대한 취소 전표를 Master 생성한다.<br>
	 * 
	 * @param customInterfaceStatusVO List<CustomInterfaceStatusVO>
	 * @throws DAOException
	 */
	public void addInterfaceStatusRefectCsrMaster(CustomInterfaceStatusVO customInterfaceStatusVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	
			//FMS_CONSULTATION 저장
			Map<String, String> mapVO = customInterfaceStatusVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOCustomInterfaceStatusVOCSQL(), param, velParam);
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
	 * A/P에서 취소 했을 경우 전표에 대한 취소 전표를 Slip별 생성한다<br>
	 * 
	 * @param customInterfaceStatusVO List<CustomInterfaceStatusVO>
	 * @throws DAOException
	 */
	public void addInterfaceStatusRefectCsrSlip(List<CustomInterfaceStatusVO> customInterfaceStatusVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
		
			//FMS_CSUL_SLP 저장
			if(customInterfaceStatusVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOCustomCsulSlpInterfaceCSQL(), customInterfaceStatusVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("FMS_CSUL_SLP : Fail to insert No"+ i + " SQL");
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
	 * A/P에서 취소 했을 경우 전표에 대한 취소 전표를 20T Slip별 생성한다<br>
	 * 
	 * @param customInterfaceStatusVO List<CustomInterfaceStatusVO>
	 * @throws DAOException
	 */
	public void addInterfaceStatusRefectCsrSlip2(List<CustomInterfaceStatusVO> customInterfaceStatusVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
		
			//FMS_CSUL_SLP 저장
			if(customInterfaceStatusVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOCustomCsulSlpInterface2CSQL(), customInterfaceStatusVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("FMS_CSUL_SLP : Fail to insert No"+ i + " SQL");
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
	 * 자발적, 비자발적 오류 처리할 전표에 대한 취소 작업을 진행한다.<br>
	 * 
	 * @param customInterfaceStatusVO CustomInterfaceStatusVO
	 * @throws DAOException
	 */
	public void modifyInterfaceStatusCsrCancel(CustomInterfaceStatusVO customInterfaceStatusVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
	
			//FMS_CONSULTATION 저장
			Map<String, String> mapVO = customInterfaceStatusVO.getColumnValues();
			
			param.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOCustomInterfaceStatusVOUSQL(), param, null);
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
	 * 작성된 전표의 조건별 Slip Inquiry Detail 정보를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipDetailListVO> searchSlipDetailList(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipDetailListVO> searchSlipDetailListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
				
			param.put("csr_no", csrNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipDetailListRSQL(), param, null);
			
			searchSlipDetailListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipDetailListVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipDetailListVO;
	}
	
	/**
	 * 작성된 전표의 조건별 Slip Correction - Master 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipCorrectionListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipCorrectionListVO> searchSlipCorrectionList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipCorrectionListVO> searchSlipCorrectionListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchSlipApprovalVO != null){
				Map<String, String> mapVO = condSearchSlipApprovalVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipInquiryListRSQL(), param, velParam);
			searchSlipCorrectionListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipCorrectionListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipCorrectionListVO;
	}
	
	/**
	 * Slip Correction 에서 Slip Master 의 Description 를 수정한다(단건-FMS_CONSULTATION)<br>
	 * 
	 * @param csrNo String
	 * @param csrDesc String
	 * @param usrId String
	 * @throws DAOException, Exception
	 */
	public void modifySlipCorrection(String csrNo, String csrDesc, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		
		try {
			param.put("csr_no", csrNo);
			param.put("csr_desc", csrDesc);
			param.put("usr_id", usrId);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOModifySlipCorrectionUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 작성된 전표의 조건별 Slip Correction - Detail 정보를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipCorrectionDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipCorrectionDetailListVO> searchSlipCorrectionDetailList(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipCorrectionDetailListVO> searchSlipCorrectionDetailListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
				
			param.put("csr_no", csrNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipDetailListRSQL(), param, null);
			
			searchSlipCorrectionDetailListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipCorrectionDetailListVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipCorrectionDetailListVO;
	}
	
	/**
	 * 자발적, 비자발적 오류 처리할 전표를 조회한다<br>
	 * 
	 * @param condReverseCsrForSubletVO CondReverseCsrForSubletVO
	 * @return List<SearchReverseCsrForSubletListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchReverseCsrForSubletListVO> searchReverseCsrForSubletList(CondReverseCsrForSubletVO condReverseCsrForSubletVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchReverseCsrForSubletListVO> searchReverseCsrForSubletListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condReverseCsrForSubletVO != null){
				Map<String, String> mapVO = condReverseCsrForSubletVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOFmsReverseCsrForSubletListRSQL(), param, velParam);
			searchReverseCsrForSubletListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchReverseCsrForSubletListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchReverseCsrForSubletListVO;
	}
	
	/**
	 * Slip Correction 에서 Slip Detail 의 Description 를 수정한다(다건-FMS_CSUL_SLP)<br>
	 * 
	 * @param customCsulSlpVO List<CustomCsulSlpVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void modifySlipDetailCorrection(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customCsulSlpVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOModifySlipDetailCorrectionUSQL(), customCsulSlpVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 수입 채권 차감 분을 작성하기 위한 기 생성 채권을 Master 생성한다<br>
	 * 
	 * @param customConsultationVO List<CustomConsultationVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void addMasterReverseCsrForSublet(CustomConsultationVO customConsultationVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		
		try {
			Map<String, String> mapVO = customConsultationVO.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOFmsMasterReverseCsrForSubletCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 수입 채권 차감 분을 작성하기 위한 기 생성 채권을 생성한다<br>
	 * 
	 * @param customCsulSlpVO List<CustomCsulSlpVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void addReverseCsrForSubletSlips(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customCsulSlpVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOFmsReverseCsrForSubletSlipsCSQL(), customCsulSlpVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 자발적, 비자발적 오류 처리할 전표에 대한 취소 작업 진행한다<br>
	 * 
	 * @param customInterfaceStatusVO List<CustomInterfaceStatusVO>
	 * @throws DAOException
	 */
	public void modifyInterfaceStatusSlip(List<CustomInterfaceStatusVO> customInterfaceStatusVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			//FMS_CSUL_SLP 선급금 원전표의 정산 취소
			if(customInterfaceStatusVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOCustomCsulSlpInterfaceVOUSQL(), customInterfaceStatusVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("FMS_CSUL_SLP : Fail to insert No"+ i + " SQL");
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
	 * Center Code / City Code 값 조회<br>
	 * 
	 * @param ctrCd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckCenterCode(String ctrCd) throws DAOException {
		DBRowSet dbRowset = null;
		String slpLocCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("ctr_cd", ctrCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchCheckCenterCodeRSQL(), param, null);
			if(dbRowset.next()) {
				slpLocCd = dbRowset.getString("slp_loc_cd");
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return slpLocCd;
	}
	
	/**
	 * Bunker Vvd 값 조회<br>
	 * 
	 * @param bunkerVvd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckVvdCode(String bunkerVvd) throws DAOException {
		DBRowSet dbRowset = null;
		String dbBunkerVvd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("bunker_vvd", bunkerVvd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchCheckVvdCodeRSQL(), param, null);
			if(dbRowset.next()) {
				dbBunkerVvd = dbRowset.getString("bunker_vvd");
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbBunkerVvd;
	}
	
	/**
	 * 수입 채권 차감 분을 작성하기 위한 기 생성 채권을 Invoice 조건으로 조회한다<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchReverseCsrForSubletSaveListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchReverseCsrForSubletSaveListVO> searchReverseCsrForSubletSaveList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchReverseCsrForSubletSaveListVO> searchReverseCsrForSubletSaveListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(customCsulSlpSeqVO != null){
				Map<String, String> mapVO = customCsulSlpSeqVO.getColumnValues();

				param.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOFmsReverseCsrForSubletSaveListRSQL(), param, null);
			searchReverseCsrForSubletSaveListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchReverseCsrForSubletSaveListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchReverseCsrForSubletSaveListVO;
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
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchApSlipDetailListVORSQL(), param, null);
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
	 * 재무 항차 검사한다.<br>
	 * 
	 * @param vvdCd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckMdmVvdCode(String vvdCd) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			param.put("vvd_cd", vvdCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchCheckMdmVvdCodeRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getString("vsl_cd");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 회계일자 검사한다.<br>
	 * 
	 * @param slpOfcCd String
	 * @param effDt String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckEffectiveDate(String slpOfcCd, String effDt) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("eff_yrmon", effDt.substring(0,6));		//Effective Date
			param.put("slp_ofc_cd", slpOfcCd);					//Office Code
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchCheckEffectiveDateRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getString("eff_yrmon");
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * AR 회계일자 검사한다.<br>
	 * 
	 * @param slpOfcCd String
	 * @param effDt String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckEffectiveDate2(String slpOfcCd, String effDt) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("eff_yrmon", effDt.substring(0,6));		//Effective Date
			param.put("slp_ofc_cd", slpOfcCd);					//Office Code
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchCheckEffectiveArDateRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getString("eff_yrmon");
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Slip Approval 승인 시에 Vendor/Owner Code 존재 검사한다<br>
	 * 
	 * @param vndrSeq String
	 * @param custCntCd String
	 * @param custSeq String
	 * @return List<SearchSlipApprovalOwnerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipApprovalOwnerVO> searchSlipApprovalOwner (String vndrSeq ,String custCntCd ,String custSeq ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipApprovalOwnerVO> searchSlipApprovalOwnerVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();
		
		try{
			
			param.put("vndr_seq", vndrSeq);
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);
	
			vparam.put("vndr_seq", vndrSeq);
			vparam.put("cust_seq", custSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipApprovalOwnerVORSQL(), param, vparam);
			searchSlipApprovalOwnerVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipApprovalOwnerVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipApprovalOwnerVO;
	}

	/**
	 * Slip Approval 승인 시에 Office 및 User 테이블에서 필요 항목 조회한다<br>
	 * 
	 * @param String csrNo 
	 * @return List<SearchSlipApprovalOfficeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipApprovalOfficeVO> searchSlipApprovalOffice (String csrNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipApprovalOfficeRSQL(), param, null);
			searchSlipApprovalOfficeVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipApprovalOfficeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipApprovalOfficeVO;
	}
	
	
	/**
	 * Slip Approval 승인 시에 Office 및 User 테이블에서 필요 항목 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipApprovalOfficeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipApprovalOfficeVO> searchSlipArApprovalOffice (String csrNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipArApprovalOfficeRSQL(), param, null);
			searchSlipApprovalOfficeVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipApprovalOfficeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipApprovalOfficeVO;
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
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOCustomSlipApprovalDetailVOCSQL(), customSlipApprovalDetailVOs,null);
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
	 * AR Header 테이블에 생성된다.<br>
	 * 
	 * @param customArSlipApprovalHeaderVO List<CustomArSlipApprovalHeaderVO>
	 * @throws DAOException
	 */
	public void addArSlipApprovalHeader(List<CustomArSlipApprovalHeaderVO> customArSlipApprovalHeaderVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			//JOO_AR_MN 저장
			if(customArSlipApprovalHeaderVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOCustomArSlipApprovalHeaderVOCSQL(), customArSlipApprovalHeaderVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("JOO_AR_CHG : Fail to insert No"+ i + " SQL");
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
	 * ERP AP 전송하기 위한 세금 계산서 정보 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipApprovalTaxVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipApprovalTaxVO> searchSlipApprovalTax (String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipApprovalTaxVO> searchSlipApprovalTaxVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipApprovalTaxRSQL(), param, null);
			searchSlipApprovalTaxVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipApprovalTaxVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipApprovalTaxVO;
	}

	/**
	 * ERP AP 전송하기 위한 계산서 정보 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipApprovalBillVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipApprovalBillVO> searchSlipApprovalBill (String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipApprovalBillVO> searchSlipApprovalBillVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipApprovalBillRSQL(), param, null);
			searchSlipApprovalBillVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipApprovalBillVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipApprovalBillVO;
	}

	/**
	 * 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다<br>
	 * 대선인 경우 전표가 승인되면 ERP A/R 로 전송된다
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @throws DAOException
	 */
	public void modifySlipApprovalConsultation (String csrNo ,String usrId ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//velocity parameter
			Map<String, Object> vparam = new HashMap<String, Object>();
	
			//FMS_CONSULTATION 저장
			param.put("csr_no", csrNo);
			param.put("upd_usr_id", usrId);
			
			vparam.put("modify_type", "Approval");

			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOCustomConsultationVOUSQL(), param, vparam);
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
	 * 취소 시 Consultation 에 취소 변경한다
	 * 
	 * @param csrNo String
	 * @param cxlDesc String
	 * @param usrId String
	 * @throws DAOException
	 */
	public void modifySlipApprovalCancelConsultation (String csrNo ,String cxlDesc, String usrId ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//velocity parameter
			Map<String, Object> vparam = new HashMap<String, Object>();
	
			//FMS_CONSULTATION 저장
			param.put("csr_no", csrNo);
			param.put("cxl_desc", cxlDesc);
			param.put("upd_usr_id", usrId);
			
			vparam.put("modify_type", "Cancel");
	
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOCustomConsultationVOUSQL(), param, vparam);
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
	 * 취소 시 원전표의 Consultation 에 취소 변경한다
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @throws DAOException
	 */
	public void modifySlipApprovalCancelOrginConsultation (String csrNo ,String usrId ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//velocity parameter
			Map<String, Object> vparam = new HashMap<String, Object>();
	
			//FMS_CONSULTATION 저장
			param.put("csr_no", csrNo);
			param.put("upd_usr_id", usrId);
			
			vparam.put("modify_type", "CancelOrigin");
	
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOCustomConsultationVOUSQL(), param, vparam);
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
	 * AR Detail 테이블에 생성된다.<br>
	 * 
	 * @param customArSlipApprovalDetailVOs List<CustomArSlipApprovalDetailVO>
	 * @throws DAOException
	 */
	public void addArSlipApprovalDetails(List<CustomArSlipApprovalDetailVO> customArSlipApprovalDetailVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			//JOO_AR_CHG 저장
			if(customArSlipApprovalDetailVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOCustomArSlipApprovalDetailVOCSQL(), customArSlipApprovalDetailVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("JOO_AR_CHG : Fail to insert No"+ i + " SQL");
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
	 * AP Header 테이블에 생성된다.<br>
	 * 
	 * @param customSlipApprovalHeaderVO CustomSlipApprovalHeaderVO
	 * @throws DAOException
	 */
	public void addApSlipApprovalHeader(CustomSlipApprovalHeaderVO customSlipApprovalHeaderVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
	
			//AP_INV_HDR 저장
			Map<String, String> mapVO = customSlipApprovalHeaderVO.getColumnValues();
			
			param.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOCustomSlipApprovalHeaderVOCSQL(), param, null);
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
	 * AR 전표 Detail 계정 항목들을 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchArSlipDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchArSlipDetailListVO> searchArSlipDetailList (String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchArSlipDetailListVO> searchArSlipDetailListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchArSlipDetailListRSQL(), param, null);
			searchArSlipDetailListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchArSlipDetailListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchArSlipDetailListVO;
	}
	
	/**
	 * AR Bunker 전표 Detail 계정 항목들을 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchArSlipDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchArSlipDetailListVO> searchArBunkerSlipDetailList (String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchArSlipDetailListVO> searchArSlipDetailListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchArBunkerSlipDetailListRSQL(), param, null);
			searchArSlipDetailListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchArSlipDetailListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchArSlipDetailListVO;
	}

	/**
	 * ERP AP 전송하기 위한 계산서 Detail 정보 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipApprovalBillDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipApprovalBillDetailVO> searchSlipApprovalBillDetail (String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipApprovalBillDetailVO> searchSlipApprovalBillDetailVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipApprovalBillDetailRSQL(), param, null);
			searchSlipApprovalBillDetailVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipApprovalBillDetailVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipApprovalBillDetailVO;
	}

	/**
	 * ERP AP 전송하기 위한 세금 계산서 Detail 정보 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipApprovalTaxDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSlipApprovalTaxDetailVO> searchSlipApprovalTaxDetail (String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipApprovalTaxDetailVO> searchSlipApprovalTaxDetailVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipApprovalTaxDetailRSQL(), param, null);
			searchSlipApprovalTaxDetailVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipApprovalTaxDetailVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchSlipApprovalTaxDetailVO;
	}

	/**
	 * AP 전표의 VAT 정보를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchApSlipDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchApVatSlipListVO> searchApVatSlipList (String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchApVatSlipListVO> searchApVatSlipListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchApVatSlipListVORSQL(), param, null);
			searchApVatSlipListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchApVatSlipListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchApVatSlipListVO;
	}

	/**
	 * Manual Slip에서 재무 항차 조회한다<br>
	 * 
	 * @param String fletCtrtNo
	 * @param String fmDt
	 * @param String toDt
	 * @return List<SearchVvdListByManualSlipVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchVvdListByManualSlipVO> searchVvdListByManualSlip(String fletCtrtNo, String fmDt, String toDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVvdListByManualSlipVO> searchVvdListByManualSlipVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("eff_dt", fmDt);
			param.put("exp_dt", toDt);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOFmsVvdListByManualSlipRSQL(), param, null);
			searchVvdListByManualSlipVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVvdListByManualSlipVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchVvdListByManualSlipVO;
	}

	/**
	 * 생성된 Brokerage를 Manual 전표에서 처리하기 위해 조회한다<br>
	 * 
	 * @param currCd String
	 * @return List<SearchBrokerageListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBrokerageListVO> searchBrokerageList(String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBrokerageListVO> searchBrokerageListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("curr_cd", currCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOFmsBrokerageListRSQL(), param, null);
			searchBrokerageListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBrokerageListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchBrokerageListVO;
	}
	
	/**
	 * Payments Slip - Master 정보를 입력한다(다건)<br>
	 * 
	 * @param customPamConsultationVO List<CustomPamConsultationVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void addPaymentSlipMasters(List<CustomPamConsultationVO> customPamConsultationVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customPamConsultationVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOAddPaymentSlipMastersCSQL(), customPamConsultationVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Payments Slip - Detail 정보를 입력한다(다건)<br>
	 * 
	 * @param customPamCsulSlpVO List<CustomPamCsulSlpVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void addPaymentSlipDetails(List<CustomPamCsulSlpVO> customPamCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customPamCsulSlpVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOAddPaymentSlipDetailsCSQL(), customPamCsulSlpVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Payments Tax - Master 정보를 입력한다(다건-FMS_TAX)<br>
	 * 
	 * @param customTaxVO List<CustomTaxVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void addPaymentTaxMasters(List<CustomTaxVO> customTaxVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customTaxVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOAddPaymentTaxMasterCSQL(), customTaxVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Payments Tax - Detail 정보를 입력한다(다건-FMS_TAX_DTL)<br>
	 * 
	 * @param customTaxDtlVO List<CustomTaxDtlVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void addPaymentTaxDtls(List<CustomTaxDtlVO> customTaxDtlVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customTaxDtlVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOAddPaymentTaxDtlsCSQL(), customTaxDtlVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Payments Bill - Master 정보를 입력한다(다건-FMS_BILL)<br>
	 * 
	 * @param customTaxVO List<CustomTaxVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void addPaymentBillMasters(List<CustomTaxVO> customTaxVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customTaxVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOAddPaymentBillMasterCSQL(), customTaxVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Payments Bil - Detail 정보를 입력한다(다건-FMS_BIL_DTL)<br>
	 * 
	 * @param customTaxDtlVO List<CustomTaxDtlVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void addPaymentBilDtls(List<CustomTaxDtlVO> customTaxDtlVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customTaxDtlVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOAddPaymentBilDtlsCSQL(), customTaxDtlVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Payment Slip 정보를 조회한다<br>
	 * 
	 * @param String csrNo
	 * @return List<SearchPaymentSlipListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchPaymentSlipListVO> searchPaymentSlipList(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPaymentSlipListVO> searchPaymentSlipListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("csr_no", csrNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchPaymentSlipListRSQL(), param, null);
			searchPaymentSlipListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPaymentSlipListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchPaymentSlipListVO;
	}

	/**
	 * 용/ 대선료 관련 비용 이외에 선박계약(Agreement Creation)과 상관없이 현업에서 처리해야 할 관련 제반 비용을 Master 등록한다<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @throws DAOException, Exception
	 */
	public void addMasterManualSlip(CustomConsultationVO customConsultationVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		
		try {
			Map<String, String> mapVO = customConsultationVO.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOFmsMasterManualSlipCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 용/ 대선료 관련 비용 이외에 선박계약(Agreement Creation)과 상관없이 현업에서 처리해야 할 관련 제반 비용을 등록한다<br>
	 * 
	 * @param customCsulSlpVO List<CustomCsulSlpVO>
	 * @throws DAOException, Exception
	 */
	public void addManualSlips(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customCsulSlpVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOFmsManualSlipsCSQL(), customCsulSlpVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 용/ 대선료 관련 비용 이외에 선박계약(Agreement Creation)과 상관없이 현업에서 처리해야 할 관련 제반 비용을 조회한다<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchManualSlipListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchManualSlipListVO> searchManualSlipList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchManualSlipListVO> searchManualSlipListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(customCsulSlpSeqVO != null){
				Map<String, String> mapVO = customCsulSlpSeqVO.getColumnValues();
				param.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOFmsManualSlipListRSQL(), param, null);
			searchManualSlipListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchManualSlipListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchManualSlipListVO;
	}
	
	/**
	 * CSR No. 에 해당하는 Tax Master 데이타 조회<br>
	 * 
	 * @param csrNo String
	 * @return SearchTaxMasterEvidenceVO
	 * @exception EventException
	 */
	public SearchTaxMasterEvidenceVO searchTaxMasterEvidence(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchTaxMasterEvidenceVO searchTaxMasterEvidenceVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchTaxMasterEvidenceRSQL(), param, null);
			
			if(dbRowset.next()) {
				dbRowset.beforeFirst();
				searchTaxMasterEvidenceVO = (SearchTaxMasterEvidenceVO)RowSetUtil.rowSetToVOs(dbRowset, SearchTaxMasterEvidenceVO.class ).get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchTaxMasterEvidenceVO;
	}
	
	/**
	 * CSR No. 에 해당하는 Tax Detail 데이타 조회<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchTaxDetailEvidenceListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTaxDetailEvidenceListVO> searchTaxDetailEvidenceList(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTaxDetailEvidenceListVO> searchTaxDetailEvidenceListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("csr_no", csrNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchTaxDetailEvidenceListRSQL(), param, null);
			searchTaxDetailEvidenceListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTaxDetailEvidenceListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchTaxDetailEvidenceListVO;
	}

	/**
	 * AP 전표 Interface할 데이터를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchApSlipInterfaceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchApSlipInterfaceListVO> searchApSlipInterfaceList (String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchApSlipInterfaceListVORSQL(), param, null);
			searchApSlipInterfaceListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchApSlipInterfaceListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchApSlipInterfaceListVO;
	}

	/**
	 * AR INTERFACE 결과를 업데이트 작업 진행한다
	 * 
	 * @param ifNo String
	 * @param ifResult String
	 * @param errorMsg String
	 * @throws DAOException
	 */
	public void receiveSlipApprovalToAR (String ifNo ,String ifResult ,String errorMsg ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
	
			//JOO_AR_MN 저장
			param.put("ar_if_no", ifNo);
			param.put("erp_if_flg", ifResult);
			param.put("err_msg", errorMsg);
	
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOCustomArSlipApprovalHeaderVOUSQL(), param, null);
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
	 * AR Reverse 전표 Detail 계정 항목들을 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchArSlipDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchArSlipDetailListVO> searchArRvsSlipDetailList (String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchArSlipDetailListVO> searchArSlipDetailListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchArRvcSlipDetailListRSQL(), param, null);
			searchArSlipDetailListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchArSlipDetailListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchArSlipDetailListVO;
	}

	/**
	 * Cumstomer Code를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchCustomerCodeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCustomerCodeVO> searchCustomerCode(String fletCtrtNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCustomerCodeVO> searchCustomerCodeVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOFmsCustomerCodeRSQL(), param, null);
			searchCustomerCodeVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerCodeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchCustomerCodeVO;
	}

	/**
	 * AR Interface 테이블에 생성된다.<br>
	 * 
	 * @param searchApSlipInterfaceListVO List<SearchApSlipInterfaceListVO>
	 * @throws DAOException
	 */
	public void addApSlipApprovalInterfaces(List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			//AP_INV_IF 저장
			if(searchApSlipInterfaceListVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOConsultationDBDAOSearchApSlipInterfaceListVOCSQL(), searchApSlipInterfaceListVO,null);
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
	 * 전표에 대한 Reject 취소 작업을 진행한다.<br>
	 * 
	 * @param customInterfaceStatusVO CustomInterfaceStatusVO
	 * @throws DAOException
	 */
	public void modifyInterfaceStatusApCsrCancel(CustomInterfaceStatusVO customInterfaceStatusVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
	
			//FMS_CONSULTATION 저장
			Map<String, String> mapVO = customInterfaceStatusVO.getColumnValues();
			
			param.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOCustomApInterfaceStatusVOUSQL(), param, null);
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
	 * groupware 전송 xmlData Agreement info<br>
	 *  
	 * @param String csrNo
     * @return List<ComCsrRequestAgmtVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComCsrRequestAgmtVO> printFmsCsrAgmtInfo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;     
        List<ComCsrRequestAgmtVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOPrintFmsCsrAgmtInfoRSQL(), param, velParam);          
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestAgmtVO.class);         
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }        
        return list;      
    }  	
    
    /**
	 * groupware 전송 xmlData Body info<br>
	 * 
	 * @param String csrNo
     * @return List<ComCsrRequestBodyVO 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComCsrRequestBodyVO> printComCsrBodyInfo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;     
        List<ComCsrRequestBodyVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("csr_no", csrNo);        	
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
                    
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOPrintComCsrBodyInfoRSQL(), param, velParam);          
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestBodyVO.class);         
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }        
        return list;      
    }      
    
    
    /**
	 * groupware 전송 xmlData Header info<br>
	 * 
	 * @param String csrNo
     * @return ComCsrRequestHeaderVO 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ComCsrRequestHeaderVO printComCsrHeaderInfo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;      
        List<ComCsrRequestHeaderVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOPrintComCsrHeaderInfoRSQL(), param, velParam);           
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestHeaderVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }      
    
	/**
	 * AR-GW결재 AR_INV_HDR 저장한다.<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @throws DAOException
	 */
	public void addArInvHdr(String csrNo, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
/*			
			ACCT_XCH_RT_YRMON 						VARCHAR2(6)        
			CSR_USD_AMT 									NUMBER(18,3)  기준이 되는 금액(계정을 고려하여 달러로 계산한 금액) 
			RQST_APRO_STEP_FLG 					VARCHAR2(1) 	CSR 생성시 'Y'로 업데이트, 다른 단계에선 ''로 업데이트 
			AP_ACCT_VER_NO 							VARCHAR2(14)   
			CSR_APRO_TP_CD 							VARCHAR2(2) 	결재구분 코드(GW:그룹웨어, AL:알프스) 
			CSR_APRO_STEP_ASGN_RQST_DT 		DATE 				CSR 생성 일시 
			CSR_APRO_STEP_ASGN_DT 				DATE 				기안 완료 일시 
			CSR_APRO_CMPL_DT 						DATE 				최종 승인 일시 
			CSR_CXL_DT 									DATE 				GW 결과값 'D'가 오는경우 사용할 예정이었으나 현재는 사용하지 않음 
			CSR_RJCT_DT 									DATE 				최종 reject 일시 
			GW_CSR_RQST_ID 								VARCHAR2(500) 	GW request_id 
			GW_APRO_URL_CTNT 						VARCHAR2(4000) 	GW url 
			APRO_USR_JB_TIT_CD 						VARCHAR2(1) 		최종결재자 구분 코드(N: 자유롭게 지정, B:본부장,P:PDT) 
			AGMT_DOC_CFM_CD 							VARCHAR2(1) 		ALPS 계약서 첨부 플래그 
			GW_AGMT_DOC_CFM_CD 					VARCHAR2(1) 		GW 계약서 첨부 플래그 
			AGMT_FILE_CFM_CD 							VARCHAR2(1) 		ALPS 파일 첨부 플래그 
			AGMT_EVID_CFM_FNL_CD 					VARCHAR2(1) 		GW 파일 첨부 플래그
			
			String csr_apro_tp_cd = "GW"; 			//결재 구분 코드(AL,GW)
			String jb_tit_cd = "";				//최종 결재자 구분 코드
			String ver_no = "1";					//버전 관리
			String csr_usd_amt = "";				//환율 변경 금액(기준 테이블 참조)
			String acct_xch_rt_yrmon = "";		//GL_DT						 
*/								
			param.put("csr_no", csrNo);
			param.put("cre_usr_id", usrId);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOAddArInvHdrCSQL(), param, velParam);
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
	 * AR-GW결재 AR_INV_HDR 삭제한다.<br>
	 * 
	 * @param csrNo String
	 * @throws DAOException
	 */
	public void delArInvHdr(String csrNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("csr_no", csrNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAODelArInvHdrDSQL(), param, velParam);
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
	 * GW에서 결과 값 전송<br>
	 * AR_INV_HDR 의  GW Url, Request_id 업데이트<br>
	 * 
	 * @param csr_no String
	 * @param request_id String
	 * @param gw_url String
	 * @throws DAOException
	 */
	public void updateAproGwUrl(String csr_no, String request_id, String gw_url) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {				
			param.put("csr_no", csr_no);
			param.put("request_id", request_id);
			param.put("gw_url", gw_url);

			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOUpdateAproGwUrlUSQL(), param, velParam);
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
	 * 작성된 전표의 조건별 Slip Approval Master 정보를 조회한다<br>
	 * 
	 * @param String csrNo
	 * @param String usrId
	 * @return SearchSlipApprovalCsrVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SearchSlipApprovalCsrVO searchAproRqstNo(String csrNo, String usrId) throws DAOException {
	   	DBRowSet dbRowset = null;      
        List<SearchSlipApprovalCsrVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	param.put("csr_no", csrNo);
        	param.put("usr_id", usrId);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOAproRqstRSQL(), param, velParam);           
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSlipApprovalCsrVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
	}
	
	/**
	 * COM_APRO_RQST_HDR에 UPDATE 한다.
	 * @param SearchSlipApprovalCsrVO searchSlipApprovalCsrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyComAproRqstHdr(SearchSlipApprovalCsrVO searchSlipApprovalCsrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = searchSlipApprovalCsrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOAproRqstHdrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * COM_APRO_RQST_ROUT에 UPDATE 한다.
	 * 
	 * @param SearchSlipApprovalCsrVO searchSlipApprovalCsrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyComAproRqstRout(SearchSlipApprovalCsrVO searchSlipApprovalCsrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = searchSlipApprovalCsrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOAproRqstRoutUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * CSR No.로 Agreement Doc 존재여부를 조회한다. <br>
	 * 
	 * @param String csrNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchAgmtCfmCd(String csrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnVal = "";		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			 param.put("csr_no", csrNo);           
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOConsultationDBDAOAgmtCfmCdRSQL(),param, velParam);
			
             if(dbRowset.next()){
                rtnVal = dbRowset.getString("AGMT_CNT_YN");            	
             }    			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
	
	/**
	 * 962111계정 AP_INV_HDR생성 시 AGMT_FILE_CFM_CD = 'Y' 처리. <br> 
	 * 
	 * @param String csrNo
	 * @param String flg
	 * @throws DAOException
	 */
	public void modifyApInvHdrAgmtFileCd(String csrNo, String flg) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("csr_no", csrNo);
			param.put("flg", flg);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOApInvHdrAgmtFileCdUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Office Code로 Country Code를 조회한다. <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCountryCodeByOfcCd(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnVal = "";		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			 param.put("ofc_cd", ofcCd);           
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOConsultationDBDAOCountryCdbyOfcCdRSQL(),param, velParam);
			
             if(dbRowset.next()){
                rtnVal = dbRowset.getString("CNT_CD");            	
             }    			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
	
    /**
	 * groupware 전송 xmlData File info<br>
	 * @param String csrNo
     * @return List<ComCsrRequestFileVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComCsrRequestFileVO> printComCsrFileInfo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;     
        List<ComCsrRequestFileVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralInvoiceAuditDBDAOSearchGwApprFileAttachRSQL(), param, velParam);          
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestFileVO.class);         
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }        
        return list;
    }
    
	/**
	 * Owner Account Settlement Status Code <br>
	 * Owner Account Settlement Status Code
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @throws DAOException
	 */
	public void modifySlipApprovalOwnereAccount (String csrNo ,String usrId ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
				
			//FMS_CONSULTATION 저장
			param.put("csr_no", csrNo);
			param.put("upd_usr_id", usrId);

			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAOOwnerAccountUSQL(), param, null);
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
	 * [FMS_OWNR_ACCT_SLP테이블에 OA_STL_STS_CD]를 [Update] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @param String oaStlStsCd
	 * @exception EventException
	 */
	public void modifyOwnrAcctSlp2(String csrNo, String oaStlStsCd) throws DAOException {
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
	
	/** modifyApprovalStep
	 * 
	 * @param csr_no String
	 * @throws DAOException
	 */
	public void modifyApprovalStep(String csr_no) throws DAOException {
		log.debug("start modifyApprovalStep =============================");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csr_no);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OwnersAccountDBDAOModifyApprovalStepUpdateUSQL(), param, velParam);

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
	
	/** modifyApprovalStep2
	 * 
	 * @param csr_no String
	 * @throws DAOException
	 */
	public void modifyApprovalStep2(String csr_no) throws DAOException {
		log.debug("start modifyApprovalStep2 =============================");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csr_no);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OwnersAccountDBDAOModifyApprovalStepUpdate2USQL(), param, velParam);

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

	/** modifyApprovalStep3
	 * 
	 * @param csr_no String
	 * @throws DAOException
	 */
	public void modifyApprovalStep3(String csr_no) throws DAOException {
		log.debug("start modifyApprovalStep3 =============================");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csr_no);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OwnersAccountDBDAOModifyApprovalStepUpdate3USQL(), param, velParam);

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
	 * COM_APRO_RQST_HDR의 DELT_FLG = 'Y' 처리. <br> 
	 * 
	 * @param String csrNo
	 * @throws DAOException
	 */
	public void removeComAproRqstHdr(String csrNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("csr_no", csrNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAORemoveComAproRqstHdrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * COM_APRO_RQST_ROUT의 DELT_FLG = 'Y' 처리. <br> 
	 * 
	 * @param String csrNo
	 * @throws DAOException
	 */
	public void removeComAproRqstRout(String csrNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("csr_no", csrNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAORemoveComAproRqstRoutUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * COM_APRO_CSR_DTL의 DELT_FLG = 'Y' 처리. <br> 
	 * 
	 * @param String csrNo
	 * @throws DAOException
	 */
	public void removeComAproCsrDtl(String csrNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("csr_no", csrNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOConsultationDBDAORemoveComAproCsrDtlUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}