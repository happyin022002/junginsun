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
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.ArMstRevVvdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondReverseCsrForSubletVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchInvoiceNoVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSubletRevenueVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomArSlipApprovalDetailVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomArSlipApprovalHeaderVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpSeqVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalDetailVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalHeaderVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipInterfaceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApVatSlipListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchBrokerageListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchCustomerCodeVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInvoiceNoListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchManualSlipListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchPaymentSlipListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchPaymentSlipMasterVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletSaveListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalBillDetailVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalBillVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOfficeVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOwnerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalTaxDetailVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalTaxVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueSlipListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletReveuneDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxDetailEvidenceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxMasterEvidenceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchVvdListByManualSlipVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS TCharterIOConsultationDBDAO <br>
 * - OPUS-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon, Seyeong
 * @see TCharterIOConsultationBCImpl 참조
 * @since J2EE 1.6
 */
public class TCharterIOConsultationDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Sublet Revenue slip(대선 전표)를 조건으로 해서 대선 전표 계정 자료를 조회한다<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchDeliveryScheduleListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * AP 전표 Detail 계정 항목들을 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchApSlipDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * Payment Slip 정보를 조회한다<br>
	 * 
	 * @param String csrNo
	 * @return List<SearchPaymentSlipListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * 용/ 대선료 관련 비용 이외에 선박계약(Agreement Creation)과 상관없이 현업에서 처리해야 할 관련 제반 비용을 조회한다<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchManualSlipListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * Cumstomer Code를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchCustomerCodeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * AP 전표의 VAT 정보를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchApSlipDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * AR Reverse 전표 Detail 계정 항목들을 조회한다<br>
	 * 
	 * @param csrNo String
	 * @param acctCdList List<String>
	 * @return List<SearchArSlipDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchArSlipDetailListVO> searchArRvsSlipDetailList (String csrNo, List<String> acctCdList) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchArSlipDetailListVO> searchArSlipDetailListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
			velParam.put("acct_cds", acctCdList.iterator());
	
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
	 * AR 전표 Detail 계정 항목들을 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchArSlipDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * @param debitAcctCd String
	 * @return List<SearchArSlipDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchArSlipDetailListVO> searchArBunkerSlipDetailList (String csrNo, String debitAcctCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchArSlipDetailListVO> searchArSlipDetailListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
			param.put("debit_acct_cd", debitAcctCd);
	
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
	 * 재무 항차 검사한다.<br>
	 * 
	 * @param vvdCd String
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ArMstRevVvdVO> searchCheckMdmVvdCode(String vvdCd) throws DAOException {
		DBRowSet dbRowset = null;
		//String result = "";
		List<ArMstRevVvdVO> arMstRevVvdVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			param.put("vvd_cd", vvdCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchCheckMdmVvdCodeRSQL(), param, null);
			arMstRevVvdVO = (List)RowSetUtil.rowSetToVOs(dbRowset, ArMstRevVvdVO.class);
			/*if(dbRowset.next()) {
				result = dbRowset.getString("slan_cd");
			}*/
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arMstRevVvdVO;
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * @param usrId String
	 * @param ofcCd String
	 * @return List<SearchSlipApprovalOfficeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchSlipApprovalOfficeVO> searchSlipApprovalOffice (String usrId, String ofcCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			param.put("ofc_cd", ofcCd);
			param.put("usr_id", usrId);
	
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
	 * ERP AP 전송하기 위한 세금 계산서 정보 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipApprovalTaxVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * ERP AP 전송하기 위한 세금 계산서 Detail 정보 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipApprovalTaxDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * ERP AP 전송하기 위한 계산서 정보 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipApprovalBillVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * ERP AP 전송하기 위한 계산서 Detail 정보 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipApprovalBillDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * AP 전표 Interface할 데이터를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchApSlipInterfaceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * 작성된 채권에 대한 채권 계상액 History 조회한다<br>
	 * 
	 * @param condSearchSubletRevenueVO CondSearchSubletRevenueVO
	 * @return List<SearchSubletRevenueListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * 작성된 전표의 조건별 Slip Inquiry Master 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchSlipApprovalListVO> searchSlipApprovalList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws DAOException {
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
	 * 작성된 채권에 대한 채권 계상액 Detail History 조회한다<br>
	 * 
	 * @param toInvNo String
	 * @param csrNo String
	 * @return List<SearchSubletReveuneDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchSubletReveuneDetailListVO> searchSubletReveuneDetailList(String toInvNo, String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSubletReveuneDetailListVO> searchSubletReveuneDetailListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("to_inv_no", toInvNo);
			param.put("csr_no", csrNo);

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
	 * 작성된 전표의 조건별 Slip Correction - Master 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipCorrectionListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchSlipApprovalListRSQL(), param, velParam);
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
	 * 자발적, 비자발적 오류 처리할 전표를 조회한다<br>
	 * 
	 * @param condReverseCsrForSubletVO CondReverseCsrForSubletVO
	 * @return List<SearchReverseCsrForSubletListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * 수입 채권 차감 분을 작성하기 위한 기 생성 채권을 Invoice 조건으로 조회한다<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchReverseCsrForSubletSaveListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * 생성된 Brokerage를 Manual 전표에서 처리하기 위해 조회한다<br>
	 * 
	 * @param currCd String
	 * @return List<SearchBrokerageListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * Manual Slip에서 재무 항차 조회한다<br>
	 * 
	 * @param String fletCtrtNo
	 * @param String fmDt
	 * @param String toDt
	 * @return List<SearchVvdListByManualSlipVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * 기 결제된 채권번호를 조회한다<br>
	 * 
	 * @param condSearchInvoiceNoVO CondSearchInvoiceNoVO
	 * @return List<SearchInvoiceNoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * 작성된 전표의 조건별 Slip Inquiry Detail 정보를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * 작성된 전표의 조건별 Slip Correction - Detail 정보를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipCorrectionDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * 작성된 전표의 Slip Inquiry 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchSlipApprovalListVO> searchConsultationSlipList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws DAOException {
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchConsultationSlipListRSQL(), param, velParam);
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
	 * CSR No. 에 해당하는 Consultation Master 데이타 조회<br>
	 * 
	 * @param csrNo String
	 * @return SearchPaymentSlipMasterVO
	 * @exception EventException
	 */
	public SearchPaymentSlipMasterVO searchPaymentSlipMaster(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchPaymentSlipMasterVO searchPaymentSlipMasterVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			param.put("csr_no", csrNo);
			
			velParam.put("csr_no", csrNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOSearchPaymentSlipMasterRSQL(), param, velParam);
			
			if(dbRowset.next()) {
				dbRowset.beforeFirst();
				searchPaymentSlipMasterVO = (SearchPaymentSlipMasterVO)RowSetUtil.rowSetToVOs(dbRowset, SearchPaymentSlipMasterVO.class ).get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchPaymentSlipMasterVO;
	}
	
}