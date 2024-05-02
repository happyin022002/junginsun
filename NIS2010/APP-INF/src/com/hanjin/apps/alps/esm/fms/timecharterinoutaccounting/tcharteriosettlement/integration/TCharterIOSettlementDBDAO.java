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
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.basic.TCharterIOSettlementBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondOwnerAccountExpenseVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVvdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByOwnerAccountSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchMultiPrepaymentSettlementInquiryListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchOwnerAccountExpenseListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdAmountByAccountListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdAmountVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * NIS2010 TCharterIOSettlementDBDAO <br>
 * - NIS2010-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon, Seyeong
 * @see TCharterIOSettlementBCImpl 참조
 * @since J2EE 1.6
 */
public class TCharterIOSettlementDBDAO extends DBDAOSupport {

	/**
	 * Owner's Account Expense List 내용을 조회한다.<br>
	 * 
	 * @param condOwnerAccountExpenseVO CondOwnerAccountExpenseVO
	 * @return List<SearchOwnerAccountExpenseListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchOwnerAccountExpenseListVO> searchOwnerAccountExpenseList(CondOwnerAccountExpenseVO condOwnerAccountExpenseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOwnerAccountExpenseListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condOwnerAccountExpenseVO != null){
				Map<String, String> mapVO = condOwnerAccountExpenseVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOSettlementDBDAOSearchOwnerAccountExpenseListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnerAccountExpenseListVO .class);
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
	 * Invoice By Owner's Account Slip 내용을 조회한다.<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchInvoiceByOwnerAccountSlipVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchInvoiceByOwnerAccountSlipVO> searchInvoiceByOwnerAccountSlip(String fletCtrtNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInvoiceByOwnerAccountSlipVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
	
			param.put("flet_ctrt_no", fletCtrtNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOSettlementDBDAOSearchInvoiceByOwnerAccountSlipRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceByOwnerAccountSlipVO .class);
	
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
	 * 미 정리된 선급금 전표를 조회한다.<br>
	 * 
	 * @param condSearchPrepaymentSettleVO CondSearchPrepaymentSettleVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPrepaymentSettleListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchPrepaymentSettleListVO> searchPrepaymentSettleList(CondSearchPrepaymentSettleVO condSearchPrepaymentSettleVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPrepaymentSettleListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(condSearchPrepaymentSettleVO != null){
				Map<String, String> mapVO = condSearchPrepaymentSettleVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("ofc_cd",account.getOfc_cd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOSettlementDBDAOSearchPrepaymentSettleListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentSettleListVO .class);
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
	 * 조건에 해당하는 모든 미 정리된 선급금 전표를 조회한다<br>
	 * 
	 * @param condSearchPrepaymentSettleListVO CondSearchPrepaymentSettleListVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPrepaymentSettleListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CondSearchPrepaymentSettleListVO> searchPrepaymentSettleListAll(CondSearchPrepaymentSettleListVO condSearchPrepaymentSettleListVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<CondSearchPrepaymentSettleListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(condSearchPrepaymentSettleListVO != null){
				Map<String, String> mapVO = condSearchPrepaymentSettleListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("ofc_cd",account.getOfc_cd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOSettlementDBDAOSearchPrepaymentSettleListAllVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CondSearchPrepaymentSettleListVO .class);
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
	 * 미 정리된 선급금 전표를 항차별로 분리한다.<br>
	 * 
	 * @param condSearchPrepaymentSettleVvdVO CondSearchPrepaymentSettleVvdVO
	 * @return List<SearchPrepaymentSettleVvdListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchPrepaymentSettleVvdListVO> searchPrepaymentSettleVvdList(CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPrepaymentSettleVvdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(condSearchPrepaymentSettleVvdVO != null){
				Map<String, String> mapVO = condSearchPrepaymentSettleVvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOSettlementDBDAOSearchPrepaymentSettleVvdListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentSettleVvdListVO .class);
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
	 * 미 정리된 선급금 전표에서 계정별 비용 합계를 가져온다(FMS_INV_DTL)<br>
	 * 
	 * @param condSearchPrepaymentSettleVvdVO CondSearchPrepaymentSettleVvdVO
	 * @return List<SearchPrepaymentSettleVvdAmountVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchPrepaymentSettleVvdAmountVO> searchPrepaymentSettleVvdAmount(CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPrepaymentSettleVvdAmountVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(condSearchPrepaymentSettleVvdVO != null){
				Map<String, String> mapVO = condSearchPrepaymentSettleVvdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOSettlementDBDAOSearchPrepaymentSettleVvdAmountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentSettleVvdAmountVO .class);
			
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
	 * 미 정리된 선급금 전표를 항차별로 분리한 목록 중 계정별 csr_amt합계를 가져온다<br>
	 * 
	 * @param condSearchPrepaymentSettleVvdVO CondSearchPrepaymentSettleVvdVO
	 * @return List<SearchPrepaymentSettleVvdAmountVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchPrepaymentSettleVvdAmountByAccountListVO> searchPrepaymentSettleVvdAmountByAccount(CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPrepaymentSettleVvdAmountByAccountListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(condSearchPrepaymentSettleVvdVO != null){
				Map<String, String> mapVO = condSearchPrepaymentSettleVvdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOSettlementDBDAOSearchPrepaymentSettleVvdAmountByAccountListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentSettleVvdAmountByAccountListVO .class);
			
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
	 * Multi Prepayment Settlement 에서 Inquiry 조건에 해당하는 전표 목록을 가져온다<br>
	 * 
	 * @param condSearchPrepaymentSettleListVO CondSearchPrepaymentSettleListVO
	 * @param SignOnUserAccount account
	 * @return List<SearchMultiPrepaymentSettlementInquiryListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMultiPrepaymentSettlementInquiryListVO> searchPrepaymentSettlementInquiryList(CondSearchPrepaymentSettleListVO condSearchPrepaymentSettleListVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMultiPrepaymentSettlementInquiryListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(condSearchPrepaymentSettleListVO != null){
				Map<String, String> mapVO = condSearchPrepaymentSettleListVO.getColumnValues();
			
				param.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOSettlementDBDAOSearchMultiPrepaymentSettlementInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMultiPrepaymentSettlementInquiryListVO .class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}