/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDAO.java
*@FileTitle : Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.13
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.13 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.fmscommonutil.BizComFmsUtil;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration.TCharterIOBasicRegisterDAOCustomOwnerVOUSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomOwnerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomInterfaceStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic.TCharterIOInvoiceBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCalOffhireInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCharterInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchCalPrepaymentInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchManhourListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOffhireInvoiceVmsVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerAccountVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceAutoMatchVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomManHrChgVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomManHrListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffHireExpenseInterfaceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffhExpnVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOwnerAccountInterfaceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOwnrAcctSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchBunkerPriceInterfaceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchChaterInvoiceSdmsListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchInvoiceListByRevenueSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourItemListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourItemRegistrationListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireExpensesListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceVmsListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireSelectionListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchNewOwnerAccountListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceAutoMatchListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentHireNoListSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentHireNoListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVesselCodeInvoiceInterfaceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByCharterVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByOffHireVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByPaymentSlipVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FmsVnorItmVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FmsVnorVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.integration.LaneSimulationDBDAOChkTurnPortIndRSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAOCustomSlipApprovalDetailVOCSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAOCustomSlipApprovalHeaderVOCSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAOSearchApSlipDetailListVORSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAOSearchCheckEffectiveDateRSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAOSearchCheckMdmVvdCodeRSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAOSearchSlipApprovalOfficeRSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalHeaderVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOfficeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOwnerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FrgnExchangeTransactionVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCsrInfoVO;
import com.hanjin.syscommon.common.table.FmsConsultationVO;
import com.hanjin.syscommon.common.table.FmsCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.OwnerAccountByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.vo.FileUploadListVO;

/**
 * NIS2010 TCharterIOInvoiceDAO <br>
 * - NIS2010-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jung Yoon-Tae
 * @see TCharterIOInvoiceBCImpl 참조 
 * @since J2EE 1.5 
 */
public class TCharterIOInvoiceDBDAO extends DBDAOSupport {

	/**
	 * Charterer's Account 화면에서 조회조건에 해당되는 값을 불러온다.<br>
	 * 용선주 비용에 관련된 계정을 조회한다
	 * @param condCharterInvoiceVO CondCharterInvoiceVO
	 * @return List<SearchCharterInvoiceListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCharterInvoiceListVO> searchCharterInvoiceList(CondCharterInvoiceVO condCharterInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchCharterInvoiceListVO> searchCharterInvoiceListVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condCharterInvoiceVO != null){
				Map<String, String> mapVO = condCharterInvoiceVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchCharterInvoiceListRSQL(), param, velParam);
			searchCharterInvoiceListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCharterInvoiceListVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchCharterInvoiceListVO;
	}
	 
	 /**
	 * Charterer's Account 화면에서 조회조건에 해당되는 값을 불러온다.<br>
	 * 용선주 비용에 관련된 계정을 조회한다
	 * @param condCharterInvoiceVO CondCharterInvoiceVO
	 * @return List<SearchCharterInvoiceSumVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCharterInvoiceSumVO> searchCharterInvoiceSum(CondCharterInvoiceVO condCharterInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchCharterInvoiceSumVO> searchCharterInvoiceSumVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condCharterInvoiceVO != null){
				Map<String, String> mapVO = condCharterInvoiceVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchCharterInvoiceSumRSQL(), param, velParam);
			searchCharterInvoiceSumVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCharterInvoiceSumVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchCharterInvoiceSumVO;
	}
	 
	/**
	 * fletCtrtNo와 bnkYrmon에 해당하는 항차 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @param revYrmon String
	 * @return List<SearchVvdListByCharterVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public List<SearchVvdListByCharterVO> searchVvdListByCharter(String fletCtrtNo, String revYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchVvdListByCharterVO> searchVvdListByCharterVO = null;

		try{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("rev_yrmon", revYrmon);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchVvdListByCharterRSQL(), param, null);
			searchVvdListByCharterVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVvdListByCharterVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchVvdListByCharterVO;
	}
		 
	/**
	 * 용선주 비용을 입력한다<br>
	 * 
	 * @param customInvoiceVO CustomInvoiceVO
	 * @throws DAOException, Exception
	 */
	public void addCharterInvoice(CustomInvoiceVO customInvoiceVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = customInvoiceVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDAOAddCharterInvoiceCSQL(), param, null);
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
	 * 용선주 비용을 입력한다<br>
	 * 
	 * @param customInvDtlVO List<CustomInvDtlVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void addCharterInvDtls(List<CustomInvDtlVO> customInvDtlVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customInvDtlVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOAddCharterInvDtlsCSQL(), customInvDtlVO, null);
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
	 * 용선주 비용을 변경한다<br>
	 * 
	 * @param customInvDtlVO List<CustomInvDtlVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void modifytCharterInvDtls(List<CustomInvDtlVO> customInvDtlVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customInvDtlVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOModifytCharterInvDtlsUSQL(), customInvDtlVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * 용선주 비용을 삭제한다<br>
	 * 
	 * @param customInvDtlVO List<CustomInvDtlVO> 데이터객체 배열
	 * @throws DAOException, Exception
	 */
	public void removeCharterInvDtls(List<CustomInvDtlVO> customInvDtlVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customInvDtlVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAORemoveCharterInvDtlsDSQL(), customInvDtlVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Owner Accout 정보를 조회한다<br>
	 * 
	 * @param condSearchOwnerInvoiceVO CondSearchOwnerInvoiceVO
	 * @return List<SearchOwnerInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOwnerInvoiceListVO> searchOwnerInvoiceList(CondSearchOwnerInvoiceVO condSearchOwnerInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOwnerInvoiceListVO> searchOwnerInvoiceListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchOwnerInvoiceVO != null){
				Map<String, String> mapVO = condSearchOwnerInvoiceVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsOwnrAcctSlpRSQL(), param, velParam);
			searchOwnerInvoiceListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnerInvoiceListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchOwnerInvoiceListVO;
	}

	/**
	 * Owner Accout 정보를 변경한다<br>
	 * 
	 * @param customOwnrAcctSlpVO List<CustomOwnrAcctSlpVO> 데이터객체 배열
	 * @throws DAOException
	 */
	public void modifyOwnerInvoices(List<CustomOwnrAcctSlpVO> customOwnrAcctSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customOwnrAcctSlpVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsOwnrAcctSlpUSQL(), customOwnrAcctSlpVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Owner's Account 비용에 관련된 차변/대변 금액을 기준으로 자동으로 Matching 하도록 조회를 한다<br>
	 * 
	 * @param condSearchOwnerInvoiceAutoMatchVO CondSearchOwnerInvoiceAutoMatchVO
	 * @return List<SearchOwnerInvoiceAutoMatchListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOwnerInvoiceAutoMatchListVO> searchOwnerInvoiceAutoMatchList(CondSearchOwnerInvoiceAutoMatchVO condSearchOwnerInvoiceAutoMatchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOwnerInvoiceAutoMatchListVO> searchOwnerInvoiceAutoMatchListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchOwnerInvoiceAutoMatchVO != null){
				Map<String, String> mapVO = condSearchOwnerInvoiceAutoMatchVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsOwnrAcctSlpAutoFilterRSQL(), param, velParam);
			searchOwnerInvoiceAutoMatchListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnerInvoiceAutoMatchListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchOwnerInvoiceAutoMatchListVO;
	}
	
	/**
	 * Off-Hire Expenses 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceList(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceListVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condCalOffhireInvoiceVO != null){
				Map<String, String> mapVO = condCalOffhireInvoiceVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchCalOffhireInvoiceListRSQL(), param, velParam);
			searchCalOffhireInvoiceListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCalOffhireInvoiceListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchCalOffhireInvoiceListVO;
	}

	
	/**
	 * Off-Hire Expenses 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceCheck(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceListVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condCalOffhireInvoiceVO != null){
				Map<String, String> mapVO = condCalOffhireInvoiceVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchCalOffhireInvoiceCheckRSQL(), param, velParam);
			searchCalOffhireInvoiceListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCalOffhireInvoiceListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchCalOffhireInvoiceListVO;
	}
	
	/**
	 * Off-Hire Expenses 화면에서 SUM 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSum(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSumVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condCalOffhireInvoiceVO != null){
				Map<String, String> mapVO = condCalOffhireInvoiceVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchCalOffhireInvoiceListSumRSQL(), param, velParam);
			searchCalOffhireInvoiceListSumVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCalOffhireInvoiceListSumVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchCalOffhireInvoiceListSumVO;
	}
	
	/**
	 * CtrtNo와 Duration 에 해당하는 항차 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @param effDt String
	 * @param expDt String
	 * @param vslCd String
	 * @return List<SearchVvdListByOffHireVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchVvdListByOffHireVO> searchVvdListByOffHire(String fletCtrtNo, String effDt, String expDt, String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchVvdListByOffHireVO> searchVvdListByOffHireVO = null;

		try{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("eff_dt", effDt);
			param.put("exp_dt", expDt);
			param.put("vsl_cd", vslCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchVvdListByOffHireRSQL(), param, null);
			searchVvdListByOffHireVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVvdListByOffHireVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchVvdListByOffHireVO;
	}

	/**
	 * Manhour Item Select - Pop Up 정보를 조회한다<br>
	 * 
	 * @return List<SearchManhourItemListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchManhourItemListVO> searchManhourItemList() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchManhourItemListVO> searchManhourItemListVO = null;
	
		try{
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchManhourItemListVORSQL(), null, null);
			searchManhourItemListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchManhourItemListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchManhourItemListVO;
	}
	
	/**
	 * Offhire Expenses 정보를 입력한다<br>
	 * 
	 * @param customOffInvoiceVO CustomOffInvoiceVO
	 * @throws DAOException, Exception
	 */
	public void addOffInvoice(CustomOffInvoiceVO customOffInvoiceVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = customOffInvoiceVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDAOAddOffInvoiceCSQL(), param, null);
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
	 * Offhire Expenses 정보를 변경한다<br>
	 * 
	 * @param customOffInvoiceVO CustomOffInvoiceVO
	 * @throws DAOException, Exception
	 */
	public void modifyOffInvoice(CustomOffInvoiceVO customOffInvoiceVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = customOffInvoiceVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDAOModifyOffInvoiceUSQL(), param, null);
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
	 * Offhire Expenses 정보를 입력한다<br>
	 * 
	 * @param customOffInvDtlVO List<CustomOffInvDtlVO>
	 * @throws DAOException, Exception
	 */
	public void addOffInvDtls(List<CustomOffInvDtlVO> customOffInvDtlVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customOffInvDtlVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOAddOffInvDtlsCSQL(), customOffInvDtlVO, null);
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
	 * InvDtlSeq 값을 가져온다<br>
	 * 
	 * @param String fletCtrtNo
	 * @param String invSeq
	 * @return int dtlSeq
	 * @throws DAOException
	 */
	public int searchInvDtlSeq(String fletCtrtNo, String invSeq) throws DAOException {
		DBRowSet dbRowset = null;
		int dtlSeq = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchInvDtlSeqRSQL(), param, null);
			if(dbRowset.next()) {
				dtlSeq = dbRowset.getInt("inv_dtl_seq");
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dtlSeq;
	}
	
	/**
	 * Offhire Expenses 정보를 변경한다<br>
	 * 
	 * @param customOffInvDtlVO List<CustomOffInvDtlVO>
	 * @throws DAOException, Exception
	 */
	public void modifytOffInvDtls(List<CustomOffInvDtlVO> customOffInvDtlVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customOffInvDtlVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOModifytOffInvDtlsUSQL(), customOffInvDtlVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Offhire Expenses 정보를 삭제한다<br>
	 * 
	 * @param customOffInvDtlVO List<CustomOffInvDtlVO>
	 * @throws DAOException, Exception
	 */
	public void removeOffInvDtls(List<CustomOffInvDtlVO> customOffInvDtlVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customOffInvDtlVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAORemoveOffInvDtlsDSQL(), customOffInvDtlVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Man Hour 항목 조회한다<br>
	 * 
	 * @param condSearchManhourListVO CondSearchManhourListVO
	 * @return List<SearchManhourListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchManhourListVO> searchManhourList(CondSearchManhourListVO condSearchManhourListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchManhourListVO> searchManhourListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(condSearchManhourListVO != null){
				Map<String, String> mapVO = condSearchManhourListVO.getColumnValues();

				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsManHrChgRSQL(), param, null);
			searchManhourListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchManhourListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchManhourListVO;
	}

	/**
	 * Man Hour Item Charge를 등록한다<br>
	 * 
	 * @param customManHrChgVO List<CustomManHrChgVO>
	 * @throws DAOException
	 */
	public void addManHrChgs(List<CustomManHrChgVO> customManHrChgVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customManHrChgVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsManHrChgCSQL(), customManHrChgVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Man Hour Item Charge를 변경한다<br>
	 * 
	 * @param customManHrChgVO List<CustomManHrChgVO>
	 * @throws DAOException
	 */
	public void modifyManHrChgs(List<CustomManHrChgVO> customManHrChgVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customManHrChgVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsManHrChgUSQL(), customManHrChgVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Man Hour Item Charge를 삭제한다<br>
	 * 
	 * @param customManHrChgVO List<CustomManHrChgVO>
	 * @throws DAOException
	 */
	public void removeManhrChgs(List<CustomManHrChgVO> customManHrChgVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customManHrChgVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsManHrChgDSQL(), customManHrChgVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Han Hour Charge 에서 생성 되면 FMS_OWNR_ACCT_SLP.MAN_HR_FLG = 'Y' Update 한다<br>
	 * 
	 * @param customManHrChgVO List<CustomManHrChgVO>
	 * @throws DAOException
	 */
	public void modifyOwnrAcctSlpManHrChgs(List<CustomManHrChgVO> customManHrChgVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customManHrChgVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsOwnrAcctSlpManHrFlgUSQL(), customManHrChgVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Off-Hire Expenses 화면에서 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @return List<SearchOffhireInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOffhireInvoiceListVO> searchOffhireInvoiceList(String fletCtrtNo, String invSeq) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchOffhireInvoiceListVO> searchOffhireInvoiceListVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchOffhireInvoiceListRSQL(), param, null);
			searchOffhireInvoiceListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOffhireInvoiceListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchOffhireInvoiceListVO;
	}
	
	/**
	 * Off-Hire Expenses 화면에서 SUM 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @return List<SearchCalOffhireInvoiceListSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCalOffhireInvoiceListSumVO> searchOffhireInvoiceListSum(String fletCtrtNo, String invSeq) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSumVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchOffhireInvoiceListSumRSQL(), param, null);
			searchCalOffhireInvoiceListSumVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCalOffhireInvoiceListSumVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchCalOffhireInvoiceListSumVO;
	}
	
	/**
	 * Offhire Selection 화면에서 Offhire 데이타 조회(POPUP)<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchOffhireSelectionListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOffhireSelectionListVO> searchOffhireSelectionList(String fletCtrtNo) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchOffhireSelectionListVO> searchOffhireSelectionListVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchOffhireSelectionListRSQL(), param, null);
			searchOffhireSelectionListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOffhireSelectionListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchOffhireSelectionListVO;
	}
	
	/**
	 * Offhire Expenses 정보를 삭제한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @throws DAOException, Exception
	 */
	public void removeOffhireInvDtls(String fletCtrtNo, String invSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDAORemoveOffhireInvDtlsDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Offhire Expenses 정보를 삭제한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @throws DAOException, Exception
	 */
	public void removeOffhireInvoice(String fletCtrtNo, String invSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDAORemoveOffhireInvoiceDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Manhour Item을 관리하는 항목이고  Item 별 자료를 조회한다<br>
	 * 
	 * @return List<SearchManhourItemRegistrationListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchManhourItemRegistrationListVO> searchManhourItemRegistrationList() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchManhourItemRegistrationListVO> searchManhourItemRegistrationListVO = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsManHrListRSQL(), null, null);
			searchManhourItemRegistrationListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchManhourItemRegistrationListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchManhourItemRegistrationListVO;
	}
	
	/**
	 * Man Hour Item Name을 등록한다<br>
	 * 
	 * @param customManHrListVO List<CustomManHrListVO>
	 * @throws DAOException
	 */
	public void addManHrLists(List<CustomManHrListVO> customManHrListVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customManHrListVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsManHrListCSQL(), customManHrListVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Manhour Item Name를 변경한다<br>
	 * 
	 * @param customManHrListVO List<CustomManHrListVO>
	 * @throws DAOException
	 */
	public void modifyManHrLists(List<CustomManHrListVO> customManHrListVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customManHrListVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsManHrListUSQL(), customManHrListVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Man Hour Item Name을 삭제한다<br>
	 * 
	 * @param customManHrListVO List<CustomManHrListVO>
	 * @throws DAOException
	 */
	public void removeManHrLists(List<CustomManHrListVO> customManHrListVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customManHrListVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsManHrListDSQL(), customManHrListVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Offhire Expenses from VMS 화면에서 데이타 조회(POPUP)<br>
	 * 
	 * @param condSearchOffhireInvoiceVmsVO CondSearchOffhireInvoiceVmsVO
	 * @return List<SearchOffhireInvoiceVmsListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOffhireInvoiceVmsListVO> searchOffhireInvoiceVmsList(CondSearchOffhireInvoiceVmsVO condSearchOffhireInvoiceVmsVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchOffhireInvoiceVmsListVO> searchOffhireInvoiceVmsListVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchOffhireInvoiceVmsVO != null){
				Map<String, String> mapVO = condSearchOffhireInvoiceVmsVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchOffhireInvoiceVmsListRSQL(), param, velParam);
			searchOffhireInvoiceVmsListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOffhireInvoiceVmsListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchOffhireInvoiceVmsListVO;
	}
	
	/**
	 * Offhire Expenses 정보를 변경한다<br>
	 * 
	 * @param customOffhExpnVO List<CustomOffhExpnVO>
	 * @throws DAOException, Exception
	 */
	public void modifyOffhireInvoiceVms(List<CustomOffhExpnVO> customOffhExpnVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customOffhExpnVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOModifyOffhireInvoiceVmsUSQL(), customOffhExpnVO, null);
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
	 * Prepayments 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceList(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceListVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchCalPrepaymentInvoiceListVO != null){
				Map<String, String> mapVO = condSearchCalPrepaymentInvoiceListVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceListRSQL(), param, velParam);
			searchCalPrepaymentInvoiceListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCalPrepaymentInvoiceListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchCalPrepaymentInvoiceListVO;
	}
	
	/**
	 * Prepayments 화면에서 SUM 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceListSum(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceListSumVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchCalPrepaymentInvoiceListVO != null){
				Map<String, String> mapVO = condSearchCalPrepaymentInvoiceListVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceListSumRSQL(), param, velParam);
			searchCalPrepaymentInvoiceListSumVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCalPrepaymentInvoiceListSumVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchCalPrepaymentInvoiceListSumVO;
	}
	
	/**
	 * Prepayments 정보를 입력한다<br>
	 * 
	 * @param customPreInvoiceVO CustomPreInvoiceVO
	 * @throws DAOException, Exception
	 */
	public void addPreInvoice(CustomPreInvoiceVO customPreInvoiceVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = customPreInvoiceVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDAOAddPreInvoiceCSQL(), param, null);
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
	 * Prepayments 정보를 입력한다<br>
	 * 
	 * @param customPreInvDtlVO List<CustomPreInvDtlVO>
	 * @throws DAOException, Exception
	 */
	public void addPreInvDtls(List<CustomPreInvDtlVO> customPreInvDtlVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customPreInvDtlVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOAddPreInvDtlsCSQL(), customPreInvDtlVO, null);
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
	 * Prepayments 정보를 변경한다<br>
	 * 
	 * @param customPreInvDtlVO List<CustomPreInvDtlVO>
	 * @throws DAOException, Exception
	 */
	public void modifytPreInvDtls(List<CustomPreInvDtlVO> customPreInvDtlVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customPreInvDtlVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOModifyPreInvDtlsUSQL(), customPreInvDtlVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Prepayments 정보를 삭제한다<br>
	 * 
	 * @param customPreInvDtlVO List<CustomPreInvDtlVO>
	 * @throws DAOException, Exception
	 */
	public void removePreInvDtls(List<CustomPreInvDtlVO> customPreInvDtlVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customPreInvDtlVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAORemovePreInvDtlsDSQL(), customPreInvDtlVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 *  Prepayments 화면에서 사선/용선/대선 정보를 가져온다(FMS_CONTRACT)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ppayHirNo String 
	 * @return searchPrepaymentInvoiceVO SearchPrepaymentInvoiceVO
	 * @throws DAOException
	 */
	public SearchPrepaymentInvoiceVO searchPrepaymentInvoice(String fletCtrtNo, String ppayHirNo) throws DAOException {
		
		SearchPrepaymentInvoiceVO searchPrepaymentInvoiceVO = null;
		
		try{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("ppay_hir_no", ppayHirNo);
			
			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharterIOInvoiceDAOSearchPrepaymentInvoiceRSQL(), param, null);
			searchPrepaymentInvoiceVO = (SearchPrepaymentInvoiceVO)RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentInvoiceVO.class ).get(0);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchPrepaymentInvoiceVO;
	}
	
	/**
	 * Prepayments 화면에서 HireNo에 해당하는 Invoice 정보를 가져온다(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ppayHirNo String
	 * @return List<SearchPrepaymentHireNoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchPrepaymentHireNoListVO> searchPrepaymentHireNoList(String fletCtrtNo, String ppayHirNo) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchPrepaymentHireNoListVO> searchPrepaymentHireNoListVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("ppay_hir_no", ppayHirNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchPrepaymentHireNoListRSQL(), param, null);
			searchPrepaymentHireNoListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentHireNoListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchPrepaymentHireNoListVO;
	}
	
	/**
	 * Prepayments 화면에서 HireNo에 해당하는 Invoice Sum 정보를 가져온다(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ppayHirNo String
	 * @return List<SearchPrepaymentHireNoListSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchPrepaymentHireNoListSumVO> searchPrepaymentHireNoListSum(String fletCtrtNo, String ppayHirNo) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchPrepaymentHireNoListSumVO> searchPrepaymentHireNoListSumVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("ppay_hir_no", ppayHirNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchPrepaymentHireNoListSumRSQL(), param, null);
			searchPrepaymentHireNoListSumVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentHireNoListSumVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchPrepaymentHireNoListSumVO;
	}
	
	/**
	 * Prepayments 정보를 삭제한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @throws DAOException, Exception
	 */
	public void removePrepaymentInvDtls(String fletCtrtNo, String invSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDAORemovePrepaymentInvDtlsDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Prepayment의 Invoice 정보를 삭제한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @throws DAOException, Exception
	 */
	public void removePrepaymentInvoice(String fletCtrtNo, String invSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDAORemovePrepaymentInvoiceDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Owner Owner's Accout 정보를 변경한다<br>
	 * 
	 * @param customCSulSlpVO List<CustomCSulSlpVO>
	 * @throws DAOException
	 */
	public void modifyOwnerAccountExpenses(List<CustomCsulSlpVO> customCSulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customCSulSlpVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOCustomCSulSlpVOUSQL(), customCSulSlpVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * ERP AP에서 Owner’s account 관련 비용을 가지고 와서 변경한다<br>
	 * 
	 * @param customOwnerAccountInterfaceVO CustomOwnerAccountInterfaceVO
	 * @return int updCnt
	 * @throws DAOException
	 */
	public int modifyOwnerAccountInterfaces(CustomOwnerAccountInterfaceVO customOwnerAccountInterfaceVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int updCnt = 0;

		try {
			Map<String, String> mapVO = customOwnerAccountInterfaceVO.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsOwnrAcctSlpInterfaceUSQL(), param, null);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return updCnt;
	}

	/**
	 * ERP AP에서 Owner’s account 관련 비용을 가지고 와서 생성한다<br>
	 * 
	 * @param customOwnerAccountInterfaceVO List<CustomOwnerAccountInterfaceVO>
	 * @throws DAOException
	 */
	public void addOwnerAccountInterfaces(CustomOwnerAccountInterfaceVO customOwnerAccountInterfaceVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int updCnt = 0;
		
		try {
			Map<String, String> mapVO = customOwnerAccountInterfaceVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsOwnrAcctSlpInterfaceCSQL(), param, null);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 대선 수입 채권 발생 시 기존 생성해놓은 Hire 정보 중 당 월 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param currCd String
	 * @param slpOfcCd String
	 * @return List<SearchInvoiceListByRevenueSlipVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchInvoiceListByRevenueSlipVO> searchPrepaymentByRevenueSlipList(String fletCtrtNo, String currCd, String slpOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchInvoiceListByRevenueSlipVO> searchInvoiceListByRevenueSlipVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("curr_cd", currCd);
			param.put("slp_ofc_cd", slpOfcCd);
			
			velParam.put("flet_ctrt_no", fletCtrtNo);
			velParam.put("curr_cd", currCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsInvoiceListByRevenueSlipRSQL(), param, velParam);
			searchInvoiceListByRevenueSlipVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceListByRevenueSlipVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchInvoiceListByRevenueSlipVO;
	}
	
	/**
	 * 대선 전표가 생성되면 정산 테이블에 변경된다<br>
	 * 
	 * @param customCsulSlpVO List<CustomCsulSlpVO>
	 * @throws DAOException, Exception
	 */
	public void modifySubletRevenueSlips(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customCsulSlpVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsSubletRevenueSlipUSQL(), customCsulSlpVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * 대선 전표가 생성되면 정산 테이블의 Address Commission 계정에 변경된다<br>
	 * 
	 * @param customCsulSlpVO List<CustomCsulSlpVO>
	 * @throws DAOException, Exception
	 */
	public void modifySubletRevenueSlipCommission(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customCsulSlpVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsSubletRevenueSlipCommissionUSQL(), customCsulSlpVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * VMS에서 용선선박 용선료를 조회한다<br>
	 * 
	 * @param vslCd String
	 * @param effDt String
	 * @return hireAmt String
	 * @throws DAOException
	 */
    public String searchVesselCodeHireInterface(String vslCd, String effDt) throws DAOException {
    	DBRowSet dbRowset = null;
    	String hireAmt = "";
 
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
 
    	try{
    		param.put("vsl_cd", vslCd);
    		param.put("eff_dt", effDt);
 
    		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsHireInterfaceRSQL(), param, null);
    		if(dbRowset.next()) {
    			hireAmt = dbRowset.getString("hire_amt");
    		}
    	}catch(SQLException se){
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	}catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	}

    	return hireAmt;
    }
	 
	/**
	 * VMS에서 CDAM 정산 데이터를 조회한다<br>
	 * 
	 * @param vslCd String
	 * @param effDt String
	 * @param expDt String
	 * @return List<SearchVesselCodeInvoiceInterfaceVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchVesselCodeInvoiceInterfaceVO> searchVesselCodeInvoiceInterface(String vslCd, String effDt, String expDt) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchVesselCodeInvoiceInterfaceVO> searchVesselCodeInvoiceInterfaceVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("vsl_cd", vslCd);
			param.put("eff_dt", effDt);
			param.put("exp_dt", expDt);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsInvoiceInterfaceRSQL(), param, null);
			searchVesselCodeInvoiceInterfaceVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVesselCodeInvoiceInterfaceVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchVesselCodeInvoiceInterfaceVO;
	}

	/**
	 * Payment Slip화면에서 계약번호 선택 후 정산 관련 기본 정보를 조회한다.<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchInvoiceByPaymentSlipVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlip(String fletCtrtNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInvoiceByPaymentSlipVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
	
			param.put("flet_ctrt_no", fletCtrtNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchInvoiceByPaymentSlipVORSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceByPaymentSlipVO .class);
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 

		/**
		 * Payment Slip화면에서 계약번호 선택 후 정산 관련 기본 정보를 조회한다.<br>
		 * 
		 * @param fletCtrtNo String
		 * @return List<SearchInvoiceByPaymentSlipVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlip2(String fletCtrtNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchInvoiceByPaymentSlipVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
		
			try{
		
				param.put("flet_ctrt_no", fletCtrtNo);
		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchInvoiceByPaymentSlipOwVORSQL(), param, null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceByPaymentSlipVO .class);
		
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
	 
	/**
	 * VMS 에서 실시간으로 Offhire Expense 자료가 수신되면 FMS_OFFH_EXPN 테이블에 입력된다<br>
	 * 
	 * @param customOffHireExpenseInterfaceVO List<CustomOffHireExpenseInterfaceVO>
	 * @throws DAOException, Exception
	 */
	public void mergeOffHireExpenseInterfaces(List<CustomOffHireExpenseInterfaceVO> customOffHireExpenseInterfaceVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customOffHireExpenseInterfaceVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsOffHireExpenseInterfaceUSQL(), customOffHireExpenseInterfaceVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to merge No"+ i + " SQL");
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
	 * @param customInterfaceStatusVO CustomInterfaceStatusVO
	 * @throws DAOException
	 */
	public void modifyInterfaceStatusInvoice(CustomInterfaceStatusVO customInterfaceStatusVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int updCnt = 0;
	
		try {
			Map<String, String> mapVO = customInterfaceStatusVO.getColumnValues();
			param.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("");
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDBDAOCustomInterfaceStatusVOUSQL(), param, null);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * Bunker Price 를 Interface 정보를 조회한다<br>
	 * 
	 * @param locCd  String
	 * @param fromDt String
	 * @param toDt   String
	 * @return List<SearchBunkerPriceInterfaceListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchBunkerPriceInterfaceListVO> searchBunkerPriceInterfaceList(String locCd, String fromDt, String toDt) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchBunkerPriceInterfaceListVO> searchBunkerPriceInterfaceListVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("loc_cd", locCd);
			param.put("from_dt", fromDt);
			param.put("to_dt", toDt);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchBunkerPrieceInterfaceListRSQL(), param, null);
			searchBunkerPriceInterfaceListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBunkerPriceInterfaceListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchBunkerPriceInterfaceListVO;
	}
	
	/**
	 * 품의되지 않은 선급금 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchBunkerPriceInterfaceListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchPrepaymentListByPaymentSlipVO> searchPrepaymentListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchPrepaymentListByPaymentSlipVO> searchPrepaymentListByPaymentSlipVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("csr_curr_cd", csrCurrCd);
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchPrepaymentListByPaymentSlipRSQL(), param, null);
			searchPrepaymentListByPaymentSlipVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentListByPaymentSlipVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchPrepaymentListByPaymentSlipVO;
	}

	/**
	 * 용선/대선 전표가 취소 되면 Invoice 에 전표번호가 Null 로 변경된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @throws DAOException, Exception
	 */
	public void modifySlipApprovalCancelInvoice(String csrNo, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csrNo);
			param.put("upd_usr_id", usrId);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDBDAOSlipApprovalCancelInvoiceUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 용선 전표가 취소 되면 Account Account 에 전표번호가 Null 로 변경된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @throws DAOException, Exception
	 */
	public void modifySlipApprovalCancelOwnerAccount(String csrNo, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csrNo);
			param.put("upd_usr_id", usrId);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDBDAOSlipApprovalCancelOwnerAccountUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 품의되지 않은 Charterer's Account 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchCharterListByPaymentSlipVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchCharterListByPaymentSlipVO> searchCharterListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchCharterListByPaymentSlipVO> searchCharterListByPaymentSlipVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("csr_curr_cd", csrCurrCd);
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchCharterListByPaymentSlipRSQL(), param, null);
			searchCharterListByPaymentSlipVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCharterListByPaymentSlipVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchCharterListByPaymentSlipVO;
	}
    
    /**
	 * 기 작성된 Offhire Expenses / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchCharterListByPaymentSlipVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchOffhireListByPaymentSlipVO> searchOffhireListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchOffhireListByPaymentSlipVO> searchOffhireListByPaymentSlipVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("csr_curr_cd", csrCurrCd);
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchOffhireListByPaymentSlipRSQL(), param, null);
			searchOffhireListByPaymentSlipVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOffhireListByPaymentSlipVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchOffhireListByPaymentSlipVO;
	}
    
    /**
	 * 기 작성된 Owner’s Account / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchOwnerListByPaymentSlipVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchOwnerListByPaymentSlipVO> searchOwnerListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchOwnerListByPaymentSlipVO> searchOwnerListByPaymentSlipVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("csr_curr_cd", csrCurrCd);
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchOwnerListByPaymentSlipRSQL(), param, null);
			searchOwnerListByPaymentSlipVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnerListByPaymentSlipVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchOwnerListByPaymentSlipVO;
	}

	/**
	 * 대선 전표가 승인 되면 Invoice 에 IF NO를 업데이트한다<br>
	 * 
	 * @param searchArSlipDetailListVO List<SearchArSlipDetailListVO>
	 * @throws DAOException, Exception
	 */
	public void modifySlipApprovalInvoice(List<SearchArSlipDetailListVO> searchArSlipDetailListVO) throws DAOException,Exception {
		
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(searchArSlipDetailListVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOSlipApprovalInvoiceUSQL(), searchArSlipDetailListVO, null);
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
	 * Manual 전표 생성 시 Broker 관련 Invoice 계정에 수정한다<br>
	 * 
	 * @param customCsulSlpVO List<CustomCsulSlpVO>
	 * @throws DAOException, Exception
	 */
	public void modifyManualSlip(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customCsulSlpVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOFmsModifyManualSlipUSQL(), customCsulSlpVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * 전표 생성 완료 후 Invoice 테이블을 업데이트한다.<br>
	 * 
	 * @param customPamCsulSlpVO List<CustomPamCsulSlpVO>
	 * @throws DAOException
	 */
	public void modifyPaymentSlipInvoices(List<CustomPamCsulSlpVO> customPamCsulSlpVO) throws DAOException,Exception {
		
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customPamCsulSlpVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOModifyPaymentSlipInvoicesUSQL(), customPamCsulSlpVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01201",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 전표 생성 완료 후 Owner's Account 테이블을 업데이트한다.<br>
	 * 
	 * @param customPamCsulSlpVO List<CustomPamCsulSlpVO>
	 * @throws DAOException
	 */
	public void modifyPaymentSlipOwnerAccounts(List<CustomPamCsulSlpVO> customPamCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customPamCsulSlpVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOModifyPaymentSlipOwnerAccountsUSQL(), customPamCsulSlpVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01201",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 선주 지불 예정 비용 중 하역 실수로 발생한 비용에 대한 지불 처리 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param fromPayDt String
	 * @param toPayDt String
	 * @param appFlg String
	 * @return List<SearchChaterInvoiceSdmsListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchChaterInvoiceSdmsListVO> searchChaterInvoiceSdmsList(String fletCtrtNo, String fromPayDt, String toPayDt, String appFlg) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchChaterInvoiceSdmsListVO> searchChaterInvoiceSdmsListVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("from_pay_dt", fromPayDt);
			param.put("to_pay_dt", toPayDt);
			
			velParam.put("app_flg", appFlg);
			velParam.put("from_pay_dt", fromPayDt);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchChaterInvoiceSdmsListRSQL(), param, velParam);
			searchChaterInvoiceSdmsListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchChaterInvoiceSdmsListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchChaterInvoiceSdmsListVO;
	}
    
    /**
	 * 입력한 Invoice No 가 맞는지 체크한다.<br>
	 * INV No. 를 가져온다
	 * 
	 * @param invNo String
	 * @return sdmsInvNo String
	 * @throws DAOException
	 */
	 
    public String searchCheckSdmsInvoiceNo(String invNo) throws DAOException {
		
        DBRowSet dbRowset = null;
        
        String sdmsInvNo = "";

		try{	
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("to_inv_no", invNo);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchCheckSdmsInvoiceNoRSQL(), param, null);
			 
			if(dbRowset.next()) {
				sdmsInvNo = dbRowset.getString("to_inv_no");
			}
			 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		return sdmsInvNo;
	}
    
    /**
	 * 입력한 Hire No 가 존재하는지 체크한다.<br>
	 * Hire No. 를 가져온다
	 * 
	 * @param fletCtrtNo String
	 * @param hireNo String
	 * @return String hireNo
	 * @throws DAOException
	 */
	 
    public String searchCheckHireNo(String fletCtrtNo, String hireNo) throws DAOException {
		
        DBRowSet dbRowset = null;
        
        String ppayHireNo = "";

		try{	
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("ppay_hire_no", hireNo);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchCheckHireNoRSQL(), param, null);
			 
			if(dbRowset.next()) {
				ppayHireNo = dbRowset.getString("ppay_hir_no");
			}
			 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		return ppayHireNo;
	}
    
    /**
	 * GL Inquiry Owner Accout 정보를 조회한다<br>
	 * 
	 * @param condSearchOwnerInvoiceVO CondSearchOwnerInvoiceVO
	 * @return List<SearchOwnerInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOwnerInvoiceListVO> searchGlInquiryOwnerInvoiceList(CondSearchOwnerInvoiceVO condSearchOwnerInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOwnerInvoiceListVO> searchOwnerInvoiceListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchOwnerInvoiceVO != null){
				Map<String, String> mapVO = condSearchOwnerInvoiceVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchGlInquiryOwnerInvoiceListRSQL(), param, velParam);
			searchOwnerInvoiceListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnerInvoiceListVO .class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchOwnerInvoiceListVO;
	}
	
//############################################################################################	
//############################################################################################	
//############################################################################################	
    /**
	 * Off-Hire Expenses CNFM 정보를 조회한다<br>
	 * 
	 * @param SearchOffhireExpensesListVO vo
	 * @return List<SearchOffhireExpensesListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOffhireExpensesListVO> searchOffhireCnfmList(SearchOffhireExpensesListVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOffhireExpensesListVO> searchOffhireExpensesListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if("C".equals(vo.getVnorItmProcCd())){	// C : Confrim
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchOffhireCnfmListConfirmRSQL(), param, velParam);				
				}else if("N".equals(vo.getVnorItmProcCd())){	// N : Non Confirm
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchOffhireCnfmListNonConfirmRSQL(), param, velParam);
				}else if("P".equals(vo.getVnorItmProcCd())){  // P : Processing & Completed				
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchOffhireCnfmListRSQL(), param, velParam);				
				}
		    }
			
			searchOffhireExpensesListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOffhireExpensesListVO .class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchOffhireExpensesListVO;
	}
	
	
	/**
	 * FMS VNOR ITEM을 수정한다.<br>
	 * 
	 * @param fmsVnorItmVOs List<FmsVnorItmVO>
	 * @throws DAOException
	 */
	public void modifyVnorItm(List<FmsVnorItmVO> fmsVnorItmVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(fmsVnorItmVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOModifyVnorItmUSQL(), fmsVnorItmVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Vnor Seq 조회한다.<br>
	 * 
	 * @param vslCd String
	 * @return String vnorSeq
	 * @throws DAOException
	 */
	 
    public String searchVnorSeq(String vslCd) throws DAOException {		
        DBRowSet dbRowset = null;        
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
        String vnorSeq = "";

		try{	
			 if (vslCd != null) {
				 param.put("vsl_cd", vslCd);
				 velParam.put("vsl_cd", vslCd);
			 }
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchVnorSeqRSQL(), param, velParam);
			 
			if(dbRowset.next()) {
				vnorSeq = dbRowset.getString("vnor_seq");
			}
			 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return vnorSeq;
	}	
	
    
    /**
	 * Vnor Seq 조회한다.<br>
	 * 
	 * @param vslCd String
	 * @param vnorOffhFmDt String
	 * @param vnorOffhToDt String  
	 * @param crChkFlg String	 
	 * @return String vnorSeq
	 * @throws DAOException
	 */
	 
    public String searchVnorSeq(String vslCd, String vnorOffhFmDt, String vnorOffhToDt, String crChkFlg) throws DAOException {		
        DBRowSet dbRowset = null;        
        String vnorSeq = "";

		try{	
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("vsl_cd", vslCd);
			param.put("vnor_offh_fm_dt", vnorOffhFmDt);
			param.put("vnor_offh_to_dt", vnorOffhToDt);
			param.put("cr_chk_flg", crChkFlg);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchVnorSeq2RSQL(), param, null);
			 
			if(dbRowset.next()) {
				vnorSeq = dbRowset.getString("vnor_seq");
			}
			 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return vnorSeq;
	}	    
    
    
    /**
	 * Vnor Itm Seq 조회한다.<br>
	 * 
	 * @param vslCd String
	 * @param vnorOffhFmDt String
	 * @param vnorOffhToDt String
	 * @param crChkFlg String
	 * @return String vnorSeq	
	 * @throws DAOException
	 */
	 
    public String searchVnorItmSeq(String vslCd, String vnorOffhFmDt, String vnorOffhToDt, String crChkFlg) throws DAOException {		
        DBRowSet dbRowset = null;        
        String vnorSeq = "";

		try{	
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("vsl_cd", vslCd);
			param.put("vnor_offh_fm_dt", vnorOffhFmDt);
			param.put("vnor_offh_to_dt", vnorOffhToDt);
			param.put("cr_chk_flg", crChkFlg);			
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchVnorItmSeqRSQL(), param, null);
			 
			if(dbRowset.next()) {
				vnorSeq = dbRowset.getString("vnor_seq");
			}
			 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return vnorSeq;
	}	      
    
	/**
	 * FMS VNOR를 입력한다.<br>
	 * 
	 * @param fmsVnorVO List<FmsVnorVO>
	 * @throws DAOException
	 */
	public void addVnor(FmsVnorVO fmsVnorVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = fmsVnorVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);		
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDAOAddVnorCSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}									
	}		
		
	/**
	 * FMS VNOR을 수정한다.<br>
	 * 
	 * @param fmsVnorVOs List<FmsVnorVO>
	 * @throws DAOException
	 */
	public void updateVnor(List<FmsVnorVO> fmsVnorVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(fmsVnorVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOUpdateVnorUSQL(), fmsVnorVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * FMS VNOR을 삭제한다.<br>
	 * 
	 * @param fmsVnorVOs List<FmsVnorVO>
	 * @throws DAOException
	 */
	public void deleteVnor(List<FmsVnorVO> fmsVnorVOs) throws DAOException,Exception {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (fmsVnorVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAODeleteVnorDSQL(),fmsVnorVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}catch (SQLException se){			
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
	
//-------------------------------------------------------------	
	
	/**
	 * FMS VNOR ITM를 입력한다.<br>
	 * 
	 * @param fmsVnorItmVO List<FmsVnorItmVO>
	 * @throws DAOException
	 */
	public void addVnorItm(FmsVnorItmVO fmsVnorItmVO) throws DAOException,Exception {
/*		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = fmsVnorItmVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);		
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDAOAddVnorItmCSQL(), param, velParam, true);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}*/		
		
		List<FmsVnorItmVO> fmsVnorItmVO2s = new ArrayList<FmsVnorItmVO>();	
		fmsVnorItmVO2s.add(fmsVnorItmVO);
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(fmsVnorItmVO2s.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOAddVnorItmCSQL(), fmsVnorItmVO2s,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * FMS VNOR ITM을 수정한다.<br>
	 * 
	 * @param fmsVnorItmVOs List<FmsVnorItmVO>
	 * @throws DAOException
	 */
	public void updateVnorItm(List<FmsVnorItmVO> fmsVnorItmVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(fmsVnorItmVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOUpdateVnorItmUSQL(), fmsVnorItmVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * FMS VNOR ITM을 삭제한다.<br>
	 * 
	 * @param fmsVnorItmVOs List<FmsVnorItmVO>
	 * @throws DAOException
	 */
	public void deleteVnorItm(List<FmsVnorItmVO> fmsVnorItmVOs) throws DAOException,Exception {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (fmsVnorItmVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAODeleteVnorItmDSQL(),fmsVnorItmVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}catch (SQLException se){			
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
	
	/**
	 * Audit Comment를 수정한다.<br>
	 * 
	 * @param fmsVnorItmVOs List<FmsVnorItmVO>
	 * @throws DAOException
	 */
	public void modifyAuditComment(List<FmsVnorItmVO> fmsVnorItmVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(fmsVnorItmVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDAOModifyAuditCommentUSQL(), fmsVnorItmVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Retrieve 조회<br>
	 * [ESM_FMS_0097] (New) Owner’s Account<br>
	 * 
	 * @param CondSearchOwnerAccountVO condSearchOwnerAccountVO
	 * @return List<SearchNewOwnerAccountListVO>
	 * @exception EventException
	 */
	public List<SearchNewOwnerAccountListVO> searchNewOwnerAccountList(CondSearchOwnerAccountVO condSearchOwnerAccountVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<SearchNewOwnerAccountListVO> searchNewOwnerAccountListVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchOwnerAccountVO != null) {
				condSearchOwnerAccountVO.setEffDt1(condSearchOwnerAccountVO.getEffDt1().replaceAll("-",""));
				condSearchOwnerAccountVO.setEffDt2(condSearchOwnerAccountVO.getEffDt2().replaceAll("-",""));
				
				Map<String, String> mapVO = condSearchOwnerAccountVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String strAcctItmSeq = condSearchOwnerAccountVO.getAcctItmSeq();
				String strCmbSttlmnt = condSearchOwnerAccountVO.getCmbSttlmnt();
				
				velParam.put("vel_acct_itm_seq", (strAcctItmSeq == null || strAcctItmSeq.equals("") || strAcctItmSeq.equals("null")) ? "" : strAcctItmSeq);
				List<String> listAcctItmSeq = new ArrayList<String>();
				
				velParam.put("vel_cmb_sttlmnt", (strCmbSttlmnt == null || strCmbSttlmnt.equals("") || strCmbSttlmnt.equals("null")) ? "" : strCmbSttlmnt);
				List<String> listCmbSttlmnt = new ArrayList<String>();
				
				if(strAcctItmSeq != null && !strAcctItmSeq.equals("")) {
					listAcctItmSeq = BizComFmsUtil.getSeperationParameter(strAcctItmSeq, ",");
				}
				
				if(strCmbSttlmnt != null && !strCmbSttlmnt.equals("")) {
					listCmbSttlmnt = BizComFmsUtil.getSeperationParameter(strCmbSttlmnt, ",");
				}
				
				velParam.put("list_acct_itm_seq", listAcctItmSeq.iterator());
				velParam.put("list_cmb_settlmnt", listCmbSttlmnt.iterator());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchNewOwnerAccountListRSQL(), param, velParam);
			searchNewOwnerAccountListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNewOwnerAccountListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchNewOwnerAccountListVOs;
	}
	
	/**
	 * Save 저장<br>
	 * [ESM_FMS_0097] (New) Owner’s Account<br>
	 * 
	 * @param searchNewOwnerAccountListVO List<SearchNewOwnerAccountListVO>
	 * @throws DAOException, Exception
	 */
	public void modifytNewOwnerAccount(List<SearchNewOwnerAccountListVO> searchNewOwnerAccountListVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(searchNewOwnerAccountListVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOModifyNewOwnerAccountUSQL(), searchNewOwnerAccountListVO, null);
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
	 * VVD 체크<br>
	 * [ESM_FMS_0097] (New) Owner’s Account<br>
	 * 
	 * @param strVvd String
	 * @return Boolean
	 * @exception EventException
	 */
	public Boolean checkVvdInFmsCntrct(String strVvd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
    	boolean bExistVvd = true;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("vvd", strVvd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOChkVvdInFmsCntrctRSQL(), param,null);
			
			if(!dbRowset.next()) {
				bExistVvd = false;
			}
			
			return bExistVvd;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

    /**
	 * FRGN Exchange Transaction(O/A) 정보를 조회한다<br>
	 * 
	 * @param FrgnExchangeTransactionVO vo
	 * @return List<FrgnExchangeTransactionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FrgnExchangeTransactionVO> searchFrgnExchangeTransactionList(FrgnExchangeTransactionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<FrgnExchangeTransactionVO> frgnExchangeTransactionVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
    
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchFrgnExchangeTransactionListRSQL(), param, velParam);				
		    }
			
			frgnExchangeTransactionVO = (List)RowSetUtil.rowSetToVOs(dbRowset, FrgnExchangeTransactionVO .class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return frgnExchangeTransactionVO;
	} 
    
	/**
	 *EFF_DT 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String[]
	 * @throws DAOException
	 */
	  
	  public String[] searchEffMinDate(String ofcCd) throws DAOException {		
	      DBRowSet dbRowset = null;        
	      String effdt[] = new String[2];
    
		try{	
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("ofc_cd", ofcCd);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchEffMinDateRSQL(), param, null);
			 
			if(dbRowset.next()) {
				effdt[0] = dbRowset.getString("EFF_DT");
				effdt[1] = dbRowset.getString("SYS_DT");
			}
			 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return effdt;
	 }
    
	  /**
	   * FMS_CONSULTATION를 입력한다.<br>
	   * 
	   * @param FmsConsultationVO fmsConsultationVO
	   * @throws DAOException
	   */
	  public void addFmsConsultation(FmsConsultationVO fmsConsultationVO) throws DAOException,Exception {
	  	//query parameter
	  	Map<String, Object> param = new HashMap<String, Object>();
	  	//velocity parameter
	  	Map<String, Object> velParam = new HashMap<String, Object>();
	  	
	  	int result = 0;
	  	try {
	  		Map<String, String> mapVO = fmsConsultationVO.getColumnValues();
	  		
	  		param.putAll(mapVO);
	  		velParam.putAll(mapVO);		
	  		SQLExecuter sqlExe = new SQLExecuter("");
	  		result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDBDAOAddFmsConsultationCSQL(), param, velParam, true);
	  		if(result == Statement.EXECUTE_FAILED)
	  				throw new DAOException("Fail to insert SQL");
	  	} catch (SQLException se) {
	  		log.error(se.getMessage(),se);
	  		throw new DAOException(new ErrorHandler(se).getMessage());
	  	}catch(Exception ex){
	  		log.error(ex.getMessage(),ex);
	  		throw new DAOException(new ErrorHandler(ex).getMessage());
	  	}									
	  }		
	  
	  /**
	   * CSR 정보를  조회한다<br>
	   * 
	   * @param String ofcCd
	   * @param String csrNo
	   * @return List<SearchCsrInfoVO>
	   * @throws DAOException
	   */
	  @SuppressWarnings("unchecked")
	  public List<SearchCsrInfoVO> searchCsrInfo(String ofcCd ,String csrNo) throws DAOException {
	  	DBRowSet dbRowset = null;
	  	List<SearchCsrInfoVO> searchCsrInfoVO = null;
	  	//query parameter
	  	Map<String, Object> param = new HashMap<String, Object>();
	  	//velocity parameter
	  	Map<String, Object> velParam = new HashMap<String, Object>();
    
	  	try{
	  		param.put("ofc_cd", ofcCd);
	  		velParam.put("ofc_cd", ofcCd);
	  		param.put("csr_no", csrNo);
	  		velParam.put("csr_no", csrNo);
	  		
	  		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchCsrInfoRSQL(), param, velParam);				
	  		
	  		searchCsrInfoVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCsrInfoVO .class);
	  		
	  	}catch(SQLException se){
	  		log.error(se.getMessage(),se);
	  		throw new DAOException(new ErrorHandler(se).getMessage(), se);
	  	}catch(Exception ex){
	  		log.error(ex.getMessage(),ex);
	  		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	  	}
	  	return searchCsrInfoVO;
	  }
	  
	  
		/**
		 * FmsCsulSlpVO를 수정한다.<br>
		 * 
		 * @param List<FmsCsulSlpVO> fmsCsulSlpVOs 
		 * @throws DAOException
		 */
		public void modifyfmsCsulSlp(List<FmsCsulSlpVO> fmsCsulSlpVOs) throws DAOException,Exception {
			try {				
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				if(fmsCsulSlpVOs.size() > 0){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOAddFmsCsulSlpCSQL(), fmsCsulSlpVOs, null);
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
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
		 * FmsCsulSlpVO를 입력한다.<br>
		 * 
		 * @param fmsCsulSlpVO FmsCsulSlpVO
		 * @throws DAOException
		 */
		public void insertfmsCsulSlp(FmsCsulSlpVO fmsCsulSlpVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				Map<String, String> mapVO = fmsCsulSlpVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);		
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDBDAOAddFmsCsulSlpCSQL(), param, velParam, true);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}				
		}		
		
		
		/**
		 * AP 전표 Detail 계정 항목들을 조회한다<br>
		 * 
		 * @param csrNo String
		 * @return List<SearchApSlipDetailListVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SearchApSlipDetailListVO> searchApSlipDetailListFngn (String csrNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchApSlipDetailListVO> searchApSlipDetailListVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			try{
				
				param.put("csr_no", csrNo);
		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchApSlipDetailListFngnRSQL(), param, null);
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
		 * 회계일자 검사한다.<br>
		 * 
		 * @param slpOfcCd String
		 * @param effDt String
		 * @return String
		 * @throws DAOException
		 */
		public String searchCheckEffectiveDateFrgn(String slpOfcCd, String effDt) throws DAOException {
			DBRowSet dbRowset = null;
			String result = "";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
		
			try{
				
				param.put("eff_yrmon", effDt.substring(0,6));		//Effective Date
				param.put("slp_ofc_cd", slpOfcCd);					//Office Code
		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOsearchCheckEffectiveDateFrgnRSQL(), param, null);
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
		public String searchCheckMdmVvdCodeFrgn(String vvdCd) throws DAOException {
			DBRowSet dbRowset = null;
			String result = "";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
		
			try{
				param.put("vvd_cd", vvdCd);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchCheckMdmVvdCodeFrgnRSQL(), param, null);
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
		 * Slip Approval 승인 시에 Vendor/Owner Code 존재 검사한다<br>
		 * 
		 * @param vndrSeq String
		 * @param custCntCd String
		 * @param custSeq String
		 * @return List<SearchSlipApprovalOwnerVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SearchSlipApprovalOwnerVO> searchSlipApprovalOwnerFrgn (String vndrSeq ,String custCntCd ,String custSeq ) throws DAOException {
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
    
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchSlipApprovalOwnerFrgnRSQL(), param, vparam);
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
		 * @return List<SearchSlipApprovalOfficeVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeFrgn (String usrId ) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			try{
				
				param.put("usr_id", usrId);
		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDBDAOSearchSlipApprovalOfficeFrgnRSQL(), param, null);
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
		 * AP Header 테이블에 생성된다.<br>
		 * 
		 * @param customSlipApprovalHeaderVO CustomSlipApprovalHeaderVO
		 * @throws DAOException
		 */
		public void addApSlipApprovalHeaderFrgn(CustomSlipApprovalHeaderVO customSlipApprovalHeaderVO) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
		
				//AP_INV_HDR 저장
				Map<String, String> mapVO = customSlipApprovalHeaderVO.getColumnValues();
				
				param.putAll(mapVO);
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOInvoiceDBDAOAddApSlipApprovalHeaderFrgnRSQL(), param, null);
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
		public void addApSlipApprovalDetailsFrgn(List<CustomSlipApprovalDetailVO> customSlipApprovalDetailVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				
				//AP_INV_DTRB 저장
				if(customSlipApprovalDetailVOs.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOAddApSlipApprovalDetailsFrgnRSQL(), customSlipApprovalDetailVOs,null);
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
		 * 기 작성된 Owner’s Account / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다.(Prepayment, Standard)<br>
		 * 
		 * @param fletCtrtNo String
		 * @param ofcCd String
		 * @param csrCurrCd String
		 * @param slpTp String
		 * @return List<OwnerAccountByPaymentSlipVO>
		 * @throws DAOException
		 */
	    @SuppressWarnings("unchecked")
		public List<OwnerAccountByPaymentSlipVO> searchOwnerAccountListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd, String slpTp) throws DAOException {
			DBRowSet dbRowset = null;
			
			List<OwnerAccountByPaymentSlipVO> ownerAccountByPaymentSlipVO = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter 
			Map<String, Object> vparam = new HashMap<String, Object>();
			try{
				param.put("flet_ctrt_no", fletCtrtNo);
				param.put("csr_curr_cd", csrCurrCd);
				param.put("ofc_cd", ofcCd);
				param.put("slp_tp", slpTp);				

				vparam.putAll(param);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOSearchOwnerAccountListByPaymentSlipRSQL(), param, vparam);
				ownerAccountByPaymentSlipVO = (List)RowSetUtil.rowSetToVOs(dbRowset, OwnerAccountByPaymentSlipVO.class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
			return ownerAccountByPaymentSlipVO;
		}
		
	   	/**
		 * File Upload 리스트 조회<br>
		 * 
		 * @param String csrNo
		 * @return List<FileUploadListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<FileUploadListVO> searchCsrFileUploadList(String csrNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<FileUploadListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				param.put("csr_no", csrNo);
				velParam.putAll(param);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInvoiceDAOFileUploadListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, FileUploadListVO.class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}	    
	    
		/**
		 * GL 대사이후 Settle Date 를 update 한다.<br>
		 * 
		 * @param searchOwnerInvoiceListVO List<SearchOwnerInvoiceListVO>
		 * @throws DAOException
		 */
		public void modifySettleDate(List<SearchOwnerInvoiceListVO> searchOwnerInvoiceListVO) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				if(searchOwnerInvoiceListVO.size() > 0){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOInvoiceDBDAOModifySettleDateUSQL(), searchOwnerInvoiceListVO, null);
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler("FMS01201",new String[]{}).getUserMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
//##############################################################################################################	
}
